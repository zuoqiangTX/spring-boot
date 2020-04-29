package com.zuoqiang.learn.springboot.asyc.service.impl;

import com.zuoqiang.learn.springboot.asyc.service.PiceaService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 7:38 下午
 */

@Component
public class PiceaServiceImpl implements PiceaService {
    @Override
    public void task() throws Exception {
        System.out.println("------------------------执行+60s-------------");
        TimeUnit.SECONDS.sleep(60);
    }

    @Override
    public String task2() throws Exception {
        int k = 1;
        System.out.println("------------------------执行+20s-------------");
        TimeUnit.SECONDS.sleep(20);
        return (String.valueOf(k));
    }
}
