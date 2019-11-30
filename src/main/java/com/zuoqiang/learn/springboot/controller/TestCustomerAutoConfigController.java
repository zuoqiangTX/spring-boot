package com.zuoqiang.learn.springboot.controller;

import com.zuoqiang.starterdemo.bean.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义的starter类，注意加了配置才生效
 *
 * @author zuoqiang
 */
@RestController
public class TestCustomerAutoConfigController {
    @Autowired
    private UserClient client;

    @RequestMapping("/user/name")
    public String testAuto() {
        return client.getUserProperties().getName();
    }
}
