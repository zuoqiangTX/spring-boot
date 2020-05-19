package com.zuoqiang.learn.springboot.proertryenviroment;

import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @author zuoqiang
 * @version 1.0
 * @description PropertiesPropertySource
 * @date 2020/5/19 3:52 下午
 */

public class PropertiesPropertySourceTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("name", "aget");
        properties.put("age", "23");
        PropertiesPropertySource propertySource = new PropertiesPropertySource("person", properties);
        System.out.println(propertySource.getProperty("name"));
        System.out.println(propertySource.getProperty("age"));
    }
}
