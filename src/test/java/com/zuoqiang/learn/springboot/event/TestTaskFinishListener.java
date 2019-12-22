package com.zuoqiang.learn.springboot.event;

import com.zuoqiang.learn.springboot.event.impl.MailTaskFinishListener;
import com.zuoqiang.learn.springboot.event.impl.SmsTaskFinishListener;

/**
 * spring 自带事件发布机制 测试类
 *
 * @author zuoqiang
 * @version 1.0
 * @date 2019-12-22 17:37
 */
public class TestTaskFinishListener {
    public static void main(String[] args) {
        //事件源
        Task source = new Task("用户统计", TaskFinishStatus.SUCCEDD);
        //任务结束事件
        TaskFinishEvent event = new TaskFinishEvent(source);
        //添加事件
        //邮件服务监听器
        MailTaskFinishListener mailListener = new MailTaskFinishListener("zuoqiang@163.com");
        //事件发布器
        TaskFinishEventPublisher publisher = new TaskFinishEventPublisher();

        //注册邮件服务监听器
        publisher.addListener(mailListener);

        //发布事件
        publisher.publishEvent(event);


        //sms服务监听器
        SmsTaskFinishListener smsTaskFinishListener = new SmsTaskFinishListener("123456789");
        publisher.addListener(smsTaskFinishListener);
        publisher.publishEvent(event);
    }

}
