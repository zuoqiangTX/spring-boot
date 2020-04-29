package com.zuoqiang.learn.springboot.asyc.service;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 7:37 下午
 */

public interface PiceaService {
    //无返回参数方法
    void task() throws Exception;
    //有返回参数方法
    String task2() throws Exception;
}
