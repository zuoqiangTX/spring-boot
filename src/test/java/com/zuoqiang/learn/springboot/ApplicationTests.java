package com.zuoqiang.learn.springboot;

import com.google.common.collect.Lists;
import com.zuoqiang.learn.springboot.config.Person;
import com.zuoqiang.learn.springboot.entity.Config;
import com.zuoqiang.learn.springboot.query.ConfigQuery;
import com.zuoqiang.learn.springboot.service.ConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * springboot单元测试
 */
@SpringBootTest
class ApplicationTests {
    @Resource
    private Person person;

    @Autowired
    private ApplicationContext ioc;

    @Autowired
    private ConfigService configService;

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


    @Test
    public void test() throws InterruptedException {
//        for (int i = 0; i < 7; i++) {
//            Config config = new Config();
//            config.setId(i);
//            config.setAppId("APP" + i);
//            config.setName("test" + i);
//            config.setAppType("0");
//            config.setComment("");
//            config.setIsDeleted(true);
//            config.setCreateTime(new Date());
//            configService.insert(config);
//            TimeUnit.SECONDS.sleep(10);
//        }
        ConfigQuery configQuery = new ConfigQuery();
        configQuery.setIds(Lists.newArrayList(1, 2, 3, 4));
        List<Config> configs = configService.selectByIds(configQuery);
        configs.forEach(System.out::println);
    }
}
