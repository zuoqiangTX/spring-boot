package com.zuoqiang.learn.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author zuoqiang
 */
@SpringBootApplication(scanBasePackages = "com.zuoqiang.learn.springboot")
@EnableFeignClients(basePackages = "com.zuoqiang.learn.springboot.asyc")
@MapperScan("com.zuoqiang.learn.springboot.mapper")
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
