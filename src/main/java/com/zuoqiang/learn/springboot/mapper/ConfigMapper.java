package com.zuoqiang.learn.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zuoqiang.learn.springboot.entity.Config;
import com.zuoqiang.learn.springboot.query.ConfigQuery;

import java.util.List;

/**
 * @author MrBird
 */
public interface ConfigMapper extends BaseMapper<Config> {
    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<Config> query(ConfigQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer count(ConfigQuery query);

    /**
     * 根据唯一键查询
     *
     * @param id 数据库ID
     */
    Config findByUnique(Integer id);

    /**
     * 根据唯一键更新一调数据
     *
     * @param updateParam 更新参数
     */
    int updateByUnique(Config updateParam);

    /**
     * 新增一条记录
     */
    @Override
    int insert(Config config);


    List<Config> selectByIds(ConfigQuery query);


}