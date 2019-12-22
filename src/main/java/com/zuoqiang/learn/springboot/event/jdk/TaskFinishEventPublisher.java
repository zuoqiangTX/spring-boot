package com.zuoqiang.learn.springboot.event.jdk;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 自定义事件发布器
 *
 * @author zuoqiang
 */
public class TaskFinishEventPublisher {

    /**
     * 监听器列表
     */
    private List<TaskFinishEventListner> listners = Lists.newArrayList();

    /**
     * 添加事件
     *
     * @param listner
     */
    public void addListener(TaskFinishEventListner listner) {
        if (!listners.contains(listner)) {
            listners.add(listner);
        }
    }

    /**
     * 移除事件
     *
     * @param listner
     */
    public void removeListener(TaskFinishEventListner listner) {
        listners.remove(listner);
    }

    /**
     * 发布事件
     *
     * @param event
     */
    public void publishEvent(TaskFinishEvent event) {
        for (TaskFinishEventListner listner : listners) {
            listner.onTaskFinish(event);
        }
    }

}
