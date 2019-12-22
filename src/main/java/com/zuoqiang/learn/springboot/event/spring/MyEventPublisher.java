package com.zuoqiang.learn.springboot.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author zuoqiang
 * @version 1.0
 * @date 2019-12-22 18:42
 */
@Component
@Slf4j
public class MyEventPublisher implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //发布事件
    public void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("手动发布事件");
        MyCustomerEvent event = new MyCustomerEvent("测试");
        publishEvent(event);
    }
}
