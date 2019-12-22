package com.zuoqiang.learn.springboot.event.spring;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 2、定义执行事件的监听器
 *
 * @author zuoqiang
 * @version 1.0
 * @date 2019-12-22 18:38
 */
@Slf4j
@Data
@Component
public class MailEventListener implements ApplicationListener<MyCustomerEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */

    private String email = "zuoqiang@163.com";

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MyCustomerEvent event) {
        log.info("Send Emial to {} , Task : {}", email, event.getSource());
    }
}
