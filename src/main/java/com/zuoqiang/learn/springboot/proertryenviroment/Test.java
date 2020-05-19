package com.zuoqiang.learn.springboot.proertryenviroment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * @author zuoqiang
 * @version 1.0
 * @description @Profile()的使用
 * <p>
 * 可以使用在类或方法上，表示这个bean或方法属于哪个剖面
 * 因为str1的剖面为test，既不是激活的dev–str2，也不是默认的default—str3
 * </P>
 * @date 2020/5/19 4:18 下午
 */

@Configuration
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        System.setProperty("spring.profiles.active", "dev");
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        System.out.println(Arrays.asList(context.getBeanNamesForType(String.class)));
    }

    @Bean()
    @Profile("test")
    public String str1() {
        return "str1";
    }

    @Bean
    @Profile("dev")
    public String str2() {
        return "str2";
    }

    @Bean
    public String str3() {
        return "str3";
    }

}
