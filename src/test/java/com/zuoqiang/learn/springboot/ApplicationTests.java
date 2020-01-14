package com.zuoqiang.learn.springboot;

import com.zuoqiang.learn.springboot.config.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Date;


/**
 * springboot单元测试
 */
@SpringBootTest
class ApplicationTests {
    @Resource
    private Person person;

    @Autowired
    private ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testSpringBean() {
        System.out.println(ioc.containsBean("helloService"));

    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
//        List<Person> lists = null;
//        for (Person list : lists) {
//            System.out.println(list.getAge());
//        }
    }


}
