package com.zuoqiang.learn.springboot.event.jdk;

import java.util.EventObject;

/**
 * 自定义事件类型TaskFinishEvent继承自JDK中的EventObject,构造时会传入Task作为事件源。
 *
 * @author zuoqiang
 */
public class TaskFinishEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TaskFinishEvent(Object source) {
        super(source);
    }
}
