package com.zuoqiang.learn.springboot.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zuoqiang
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Dog {
    private Integer age;
    private String name;
}
