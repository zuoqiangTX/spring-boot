package com.zuoqiang.learn.springboot.event.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zuoqiang
 * @version 1.0
 * @date 2019-12-22 17:50
 */
@Slf4j
@Data
@AllArgsConstructor
public class SmsTaskFinishListener implements TaskFinishEventListner {
    private String address;

    @Override
    public void onTaskFinish(TaskFinishEvent event) {
        log.info("Send Message to {}, Task:{}", address, event.getSource());
    }
}
