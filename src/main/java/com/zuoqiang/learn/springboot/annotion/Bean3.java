package com.zuoqiang.learn.springboot.annotion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 2:19 下午
 */

@Slf4j
@Service("bean3")
public class Bean3 {
    public Bean3() {
        log.info(System.currentTimeMillis() + ": Bean3 Construtor 构造器");
    }

    public void print() {
        log.info(System.currentTimeMillis() + ": bean3-->print方法() ");
    }
}
