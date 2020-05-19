package com.zuoqiang.learn.springboot.proertryenviroment;

import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/19 4:15 下午
 */

public class EnvironmentTest {
    public static void main(String[] args) {
        Environment environment = new StandardEnvironment();
        System.out.println(environment.getProperty("file.encoding"));
    }
}
