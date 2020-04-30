package com.zuoqiang.learn.springboot.annotion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zuoqiang
 * @version 1.0
 * @description //加载/解析spring.xml, 得到BeanFactory, 实例化所有IOC容器中的Bean
 * //在实例化每一个Bean之后，如果当前Bean包含@PostConstruct注解的方法则会马上执行该方法，之后才会去实例化其他的Bean
 * //每一个Bean中可以有多个包含@PostConstruct注解的方法
 * @date 2020/4/30 2:18 下午
 */

@Slf4j
@Service("bean1")
public class Bean1 {
    public Bean1() {
        log.info(System.currentTimeMillis() + ": Bean1 构造器");
    }

    @PostConstruct
    public void test() {
        log.info(System.currentTimeMillis() + ": bean1-->test方法() 【PostConstruct】");
        Bean2.uniqueInstance().test();

    }

    @PostConstruct
    public void print() {
        log.info(System.currentTimeMillis() + ": bean1-->print方法() 【PostConstruct】");
    }
}
