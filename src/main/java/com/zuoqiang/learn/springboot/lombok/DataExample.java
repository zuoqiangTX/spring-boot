package com.zuoqiang.learn.springboot.lombok;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

/**
 * @Data直接修饰POJO or beans， getter所有的变量，setter所有不为final的变量。
 */
@Data
public class DataExample {
    //不生成setter
    private final String name;
    @Setter(AccessLevel.PACKAGE)
    private int age;
    private double score;
    private String[] tags;


    @ToString(includeFieldNames = true)
    @Data(staticConstructor = "zuoqiangTest")  //@Data 也可以使用staticConstructor选项生成一个静态方法。
    public static class Exercise<T> {
        private final String name;
        private final T value;
    }
}
