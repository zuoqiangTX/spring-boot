package com.zuoqiang.learn.springboot.event;

import java.util.EventListener;

/**
 * 监听器接口
 *
 * @author zuoqiang
 */
public interface TaskFinishEventListner extends EventListener {

    void onTaskFinish(TaskFinishEvent event);
}
