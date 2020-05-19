package com.zuoqiang.learn.springboot.proertryenviroment;

import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.util.Map;

/**
 * @author zuoqiang
 * @version 1.0
 * @description SystemEnvironmentPropertySource
 * <p>
 * 继承自MapPropertySource，它的source也是一个map，但来源于系统环境。
 * @date 2020/5/19 3:57 下午
 */

public class SystemEnvironmentPropertySourceTest {
    public static void main(String[] args) {
        SystemEnvironmentPropertySource source =
                new SystemEnvironmentPropertySource("systemEnvironment", (Map) System.getenv());
        System.out.println(source.getProperty("JAVA_HOME"));
        System.out.println(source.getProperty("JAVA_HOME".toLowerCase()));
        System.out.println(source.getProperty("JAVA_HOME"));

    }
}
