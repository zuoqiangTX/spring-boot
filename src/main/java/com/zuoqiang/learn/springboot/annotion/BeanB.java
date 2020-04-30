package com.zuoqiang.learn.springboot.annotion;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 2:33 下午
 */

@Service
public class BeanB {
    @PostConstruct
    private void init() {
        System.out.println("这是BeanB 的init 方法 【PostConstruct】");
    }

    public BeanB() {
        System.out.println("这是Bean B的 构造方法");
    }

    void testB() {
        System.out.println("这是Bean B 的 testB 方法");
    }
}
