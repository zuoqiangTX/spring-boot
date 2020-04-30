package com.zuoqiang.learn.springboot.annotion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 2:23 下午
 */

@Slf4j
@Service("bean4")
public class Bean4 {
    @Autowired
    private Bean3 bean3;

    public Bean4() {
        log.info(System.currentTimeMillis() + ": Bean4 无参构造器");
//        log.error("下一步会报npe错误，因为bean3还没有实例化");
//        bean3.print();
    }

    @PostConstruct
    public void test() {
        log.info(System.currentTimeMillis() + ": bean4 【PostConstruct】");
        bean3.print();
    }
}
