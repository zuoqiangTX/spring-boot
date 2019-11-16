package com.zuoqiang.learn.springboot.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 测试 lombok 的用法
 *
 * @author zuoqiang
 */

//@ToString(exclude = "name")  //不包含具体某个name的值
//@ToString(includeFieldNames = false)   //是否包含field的信息
@ToString(doNotUseGetters = false)  //则Lombok会直接获取field 而不是通过get方法获取值。
public class Project {
    @Getter
    @Setter
    private String name;

    @Setter
    private int price;

    public static void main(String[] args) {
        Project project = new Project();
        project.setName("zuoqiang");
        project.setPrice(100);
        System.out.println(project);
    }
}
