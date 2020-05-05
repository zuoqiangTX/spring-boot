package com.zuoqiang.learn.springboot.job;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.zuoqiang.learn.springboot.entity.Config;
import com.zuoqiang.learn.springboot.query.ConfigQuery;
import com.zuoqiang.learn.springboot.query.OrderBy;
import com.zuoqiang.learn.springboot.service.ConfigService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author zuoqiang
 * @version 1.0
 * @date 2020-05-05 21:29
 */
@Component
@Data
@Slf4j
public class UpdateJob implements InitializingBean {

    private ScheduledExecutorService scheduledExecutorService;

    private int scanInterval;
    private TimeUnit scanIntervalTimeUnit;
    private int rebuildInterval;
    private TimeUnit rebuildIntervalTimeUnit;
    private Integer maxIdScanned;
    private static final int patchSize = 5;
    //store id -> Config
    private Map<Integer, Config> configIdCache;

    @Autowired
    private ConfigService configService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //1、 初始化一些参数
        populateDataBaseInterval();
        //2、从数据库拉取全量数据
        this.loadNewAppNamespaces();
        //3、增量更新
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            this.updateAndDeleteCache();
        }, rebuildInterval, rebuildInterval, rebuildIntervalTimeUnit);
        scheduledExecutorService.scheduleWithFixedDelay(this::loadNewAppNamespaces, scanInterval,
                scanInterval, scanIntervalTimeUnit);
    }

    /**
     * 增量更新
     */
    private void updateAndDeleteCache() {
        List<Integer> ids = Lists.newArrayList(configIdCache.keySet());
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        List<List<Integer>> partitionIds = Lists.partition(ids, patchSize);
        for (List<Integer> toRebuild : partitionIds) {
            ConfigQuery configQuery = new ConfigQuery();
            configQuery.setIds(toRebuild);
            List<Config> configs = configService.selectByIds(configQuery);

            if (configs == null) {
                continue;
            }

            //handle updated
            Set<Integer> foundIds = handleUpdatedConfigs(configs);

            //handle deleted
            handleDeletedConfigs(Sets.difference(toRebuild.stream().collect(Collectors.toSet()), foundIds));
        }

    }

    private void handleDeletedConfigs(Set<Integer> deletedIds) {
        if (CollectionUtils.isEmpty(deletedIds)) {
            return;
        }
        for (Integer deletedId : deletedIds) {
            Config deleted = configIdCache.remove(deletedId);
            if (deleted == null) {
                continue;
            }
            log.info("发现配置>>>>删除, {}", deleted);
        }
    }

    private Set<Integer> handleUpdatedConfigs(List<Config> configs) {
        Set<Integer> foundIds = Sets.newHashSet();
        for (Config config : configs) {
            foundIds.add(config.getId());
            Config thatInCache = configIdCache.get(config.getId());
            //比较缓存里面的更新时间和本身的更新时间是否发生变化
            if (config.getModifyTime() != null) {
                //说明配置里面的已经更新了，因为更新时间变了
                if (thatInCache != null && config.getModifyTime().after(thatInCache
                        .getModifyTime())) {
                    configIdCache.put(config.getId(), config);
                    log.info("发现配置>>>>变化, old: {}, new: {}", thatInCache, config);
                }
            }

        }
        return foundIds;
    }

    /**
     * 拉取全量数据
     */
    private void loadNewAppNamespaces() {
        boolean hasMore = true;
        while (hasMore && !Thread.currentThread().isInterrupted()) {
            //current batch is 5
            ConfigQuery configQuery = new ConfigQuery();
            configQuery.setOrderBy(new OrderBy("id", OrderBy.ASC));
            configQuery.setOffset(0);
            configQuery.setLimit(patchSize);
            configQuery.setMaxId(maxIdScanned);
            configQuery.setIsDeleted(false);
            List<Config> configs = configService.query(configQuery);
            mergeConfigs(configs);
            int scanned = configs.size();
            maxIdScanned = configs.get(scanned - 1).getId();
            hasMore = scanned == patchSize;
            log.info("加载 {} 新的配置信息 with startId {}", scanned, maxIdScanned);
        }

    }

    private void mergeConfigs(List<Config> configs) {
        for (Config config : configs) {
            configIdCache.put(config.getId(), config);
        }
    }

    private void populateDataBaseInterval() {
        scanInterval = 1;
        scanIntervalTimeUnit = TimeUnit.SECONDS;
        rebuildInterval = 60;
        rebuildIntervalTimeUnit = TimeUnit.SECONDS;

    }

    public UpdateJob() {
        maxIdScanned = 0;
        configIdCache = Maps.newConcurrentMap();
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }
}
