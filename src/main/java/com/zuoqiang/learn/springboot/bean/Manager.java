package com.zuoqiang.learn.springboot.bean;

import org.springframework.stereotype.Component;

@Component
public class Manager extends BaseManager {
    @Override
    public void test() {
        System.out.println("启动了！");
    }
}
