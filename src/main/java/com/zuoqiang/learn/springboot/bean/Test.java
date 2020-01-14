package com.zuoqiang.learn.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
    @Autowired
    private Manager manager;

    public void test() {
        manager.test();
    }
}
