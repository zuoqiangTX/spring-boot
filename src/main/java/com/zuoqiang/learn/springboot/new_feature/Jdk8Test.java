package com.zuoqiang.learn.springboot.new_feature;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/1/20 4:40 下午
 */

public class Jdk8Test {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("测试一个lamda表达式！");
        }).start();
    }
}
