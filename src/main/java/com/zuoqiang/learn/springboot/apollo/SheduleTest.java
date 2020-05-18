package com.zuoqiang.learn.springboot.apollo;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/8 10:21 上午
 */

public class SheduleTest {
    public static void main(String[] args) {
        //间隔时间为1-120s
        ExponentialSchedulePolicy policy = new ExponentialSchedulePolicy(1, 120);
        for (int i = 0; i < 10; i++) {
            System.out.println("每次执行失败，计算下次的延迟时间:" + policy.fail());
        }
    }
}
