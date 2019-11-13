package com.zuoqiang.learn.springboot;

import com.zuoqiang.learn.springboot.config.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * springboot单元测试
 */
@SpringBootTest
class ApplicationTests {
    @Resource
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
