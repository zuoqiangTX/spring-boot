package com.zuoqiang.learn.springboot.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * jdk 自带的事件通知机制
 *
 * @author zuoqiang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务状态
     */
    private TaskFinishStatus taskFinishStatus;
}
