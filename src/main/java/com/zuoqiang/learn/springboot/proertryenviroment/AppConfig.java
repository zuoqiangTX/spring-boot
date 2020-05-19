package com.zuoqiang.learn.springboot.proertryenviroment;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/19 4:22 下午
 */
@Configuration
@PropertySource(value = "classpath:resources.properties", ignoreResourceNotFound = false)
public class AppConfig {
}
