package com.zuoqiang.learn.springboot.lombok;

import lombok.extern.slf4j.Slf4j;

//@Log
@Slf4j
//@CommonsLog(topic="CounterLog")
public class LogExample {
    public static void main(String... args) {
        log.error("Something's wrong here");
    }
}

