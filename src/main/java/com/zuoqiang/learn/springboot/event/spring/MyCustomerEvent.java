package com.zuoqiang.learn.springboot.event.spring;

import org.springframework.context.ApplicationEvent;

/**
 * 1、自定义事件
 *
 * @author zuoqiang
 * @version 1.0
 * @date 2019-12-22 18:37
 */
public class MyCustomerEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyCustomerEvent(Object source) {
        super(source);
    }
}
