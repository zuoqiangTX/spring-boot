package com.zuoqiang.learn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author zuoqiang
 */
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication(scanBasePackages = "com.zuoqiang.learn.springboot")
@EnableFeignClients(basePackages = "com.zuoqiang.learn.springboot.asyc")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
