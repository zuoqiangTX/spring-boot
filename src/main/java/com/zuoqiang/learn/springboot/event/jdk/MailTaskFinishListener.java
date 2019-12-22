package com.zuoqiang.learn.springboot.event.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 邮件任务完成监听器
 *
 * @author zuoqiang
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailTaskFinishListener implements TaskFinishEventListner {

    private String emial;

    @Override
    public void onTaskFinish(TaskFinishEvent event) {
        log.info("Send Emial to {} , Task : {}", emial, event.getSource());
    }
}
