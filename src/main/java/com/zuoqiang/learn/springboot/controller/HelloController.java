package com.zuoqiang.learn.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller 必须在启动类包或子包下，不然要加自动注解的代码
 * @author zuoqiang
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
