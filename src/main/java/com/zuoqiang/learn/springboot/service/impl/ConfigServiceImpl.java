package com.zuoqiang.learn.springboot.service.impl;

import com.zuoqiang.learn.springboot.entity.Config;
import com.zuoqiang.learn.springboot.mapper.ConfigMapper;
import com.zuoqiang.learn.springboot.query.ConfigQuery;
import com.zuoqiang.learn.springboot.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoqiang
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configDAO;

    @Override
    public int insert(Config config) {
        int num = configDAO.insert(config);
        return num;
    }

    @Override
    public List<Config> selectByIds(ConfigQuery query) {
        return configDAO.selectByIds(query);
    }

    @Override
    public List<Config> query(ConfigQuery query) {
        return configDAO.query(query);
    }

    @Override
    public Integer count(ConfigQuery query) {
        return configDAO.count(query);
    }

    @Override
    public Config findByUnique(Integer id) {
        return configDAO.findByUnique(id);
    }

    @Override
    public int updateByUnique(Config updateParam) {
        return configDAO.updateByUnique(updateParam);
    }

}