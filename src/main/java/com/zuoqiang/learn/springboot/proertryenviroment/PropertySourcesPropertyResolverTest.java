package com.zuoqiang.learn.springboot.proertryenviroment;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import java.util.HashMap;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 解析器的例子
 * <p>
 * 实现类 MutablePropertySources
 * 它包含了一个CopyOnWriteArrayList集合，用来包含多个PropertySource
 * </p>
 * @date 2020/5/19 4:03 下午
 */

public class PropertySourcesPropertyResolverTest {
    public static void main(String[] args) {
        MutablePropertySources tb = new MutablePropertySources();
        //向MutablePropertySources添加一个MapPropertySource
        tb.addLast(new MapPropertySource("map", new HashMap<String, Object>() {
            {
                put("name", "wang");
                put("age", 12);
            }
        }
        ));
        PropertyResolver resolver = new PropertySourcesPropertyResolver(tb);
        System.out.println(resolver.containsProperty("name"));
        System.out.println(resolver.getProperty("age"));
        System.out.println(resolver.resolveRequiredPlaceholders("My name is ${name} .I am ${age}."));

    }
}
