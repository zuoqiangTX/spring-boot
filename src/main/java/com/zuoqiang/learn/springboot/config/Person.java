package com.zuoqiang.learn.springboot.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 将配置文件中的值映射到组件中
 *
 * @author zuoqiang
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定； prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 * <p>
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 */
@Component
@Data
@EqualsAndHashCode
@ToString
@Validated
//@ConfigurationProperties(prefix = "person")
public class Person {
    /**
     * <bean class="Person">
     * <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * <bean/>
     */

    @Email //lastName必须是邮箱格式,@value不支持JSR 303校验
    @Value("${person.last-name}")
    private String lastName;

    @Value("#{11*2}")
    private Integer age;

    @Value("false")
    private Boolean boss;

    private Date birth;

    private Map<String, Object> maps;

    private List<Object> lists;

    private Dog dog;
}
