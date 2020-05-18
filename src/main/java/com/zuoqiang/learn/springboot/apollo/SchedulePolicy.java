package com.zuoqiang.learn.springboot.apollo;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 时间策略
 * @date 2020/5/8 10:18 上午
 */

public interface SchedulePolicy {
    /**
     * 失败
     *
     * @return
     */
    long fail();

    /**
     * 成功
     */
    void success();
}
