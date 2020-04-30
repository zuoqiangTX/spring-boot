package com.zuoqiang.learn.springboot.annotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 2:33 下午
 */

@Service
public class BeanA {
    @Autowired
    private BeanB beanB;

    public BeanA() {
        System.out.println("这是Bean A 的构造方法");
    }


    @PostConstruct
    private void init() {
        System.out.println("这是BeanA的 init 方法 【PostConstruct】");
        beanB.testB();
    }
}
