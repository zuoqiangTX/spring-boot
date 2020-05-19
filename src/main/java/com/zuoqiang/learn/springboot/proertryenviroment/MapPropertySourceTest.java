package com.zuoqiang.learn.springboot.proertryenviroment;

import com.google.common.collect.Maps;
import org.springframework.core.env.MapPropertySource;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zuoqiang
 * @version 1.0
 * @description PropertySource
 * @date 2020/5/19 3:46 下午
 */

public class MapPropertySourceTest {
    public static void main(String[] args) {
        Map<String, Object> source = Maps.newConcurrentMap();
        source.put("name", "zuoqiang");
        source.putIfAbsent("name", "wang");
        source.put("age", "23");

        MapPropertySource source1 = new MapPropertySource("person", source);
        System.out.println(source1.getProperty("name"));
        System.out.println(source1.getProperty("age"));
        System.out.println(source1.getName());
        String[] propertyNames = source1.getPropertyNames();
        Arrays.stream(propertyNames).forEach(System.out::println);
        System.out.println(source1.containsProperty("class"));

    }
}
