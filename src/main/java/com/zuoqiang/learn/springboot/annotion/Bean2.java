package com.zuoqiang.learn.springboot.annotion;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 2:19 下午
 */

@Slf4j
public class Bean2 {
    private static Bean2 instance = uniqueInstance();

    public static Bean2 uniqueInstance() {
        if (instance == null)
            instance = new Bean2();

        return instance;
    }

    public Bean2() {
        log.info(System.currentTimeMillis() + ": Bean2 Construtor 构造器 【其中Bean2没有被Spring IOC容器管理。】");
    }

    public void test() {
        log.info(System.currentTimeMillis() + ": bean2-->test方法()【其中Bean2没有被Spring IOC容器管理。】");
    }
}
