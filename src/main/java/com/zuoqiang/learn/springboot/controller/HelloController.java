package com.zuoqiang.learn.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller 必须在启动类包或子包下，不然要加自动注解的代码
 * @author zuoqiang
 */
@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/helloTo")
    public String helloTo() {
        return "hello" + name;
    }

}
