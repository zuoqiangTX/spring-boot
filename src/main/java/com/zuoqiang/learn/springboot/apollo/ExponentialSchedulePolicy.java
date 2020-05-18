package com.zuoqiang.learn.springboot.apollo;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 过期时间策略
 *
 * <p>
 * 例如： 3 << 2，则是将数字3左移2位
 * 1)对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方
 * 例如11 >> 2，则是将数字11右移2位
 * 2)右移一位相当于除2，右移n位相当于除以2的n次方
 * </P>
 * @date 2020/5/8 10:18 上午
 */

public class ExponentialSchedulePolicy implements SchedulePolicy {
    //重试时间下限
    private final long delayTimeLowerBound;
    //重试时间上限
    private final long delayTimeUpperBound;
    //下次重试时间
    private long lastDelayTime;

    public ExponentialSchedulePolicy(long delayTimeLowerBound, long delayTimeUpperBound) {
        this.delayTimeLowerBound = delayTimeLowerBound;
        this.delayTimeUpperBound = delayTimeUpperBound;
    }


    @Override
    public long fail() {
        long delayTime = lastDelayTime;
        //// 设置初始时间
        if (delayTime == 0) {
            delayTime = delayTimeLowerBound;
            // 指数级计算，直到上限
        } else {
//            对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方
            delayTime = Math.min(lastDelayTime << 1, delayTimeUpperBound);
        }
        // 最后延迟执行时间
        lastDelayTime = delayTime;

        return delayTime;
    }

    @Override
    public void success() {
        lastDelayTime = 0;
    }
}
