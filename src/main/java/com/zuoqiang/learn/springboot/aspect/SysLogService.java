package com.zuoqiang.learn.springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/9 4:14 下午
 */

@Component
@Slf4j
public class SysLogService {
    public void save(SysLog sysLog) {
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info("模拟保存操作！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
