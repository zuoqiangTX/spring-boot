package com.zuoqiang.learn.springboot.lombok;

import lombok.EqualsAndHashCode;

/**
 * lombok EqualsAndHashCode
 * 对于Array类型的变量，如果需要进行equals和hashCode的时候需要调用工具类的Arrays中的deepHashCode， deepEquals完成比较。
 */
@EqualsAndHashCode(exclude = {"id", "name"}) //exclude选项除掉不想要的属性
public class EqualsAndHashCodeExample {
    private transient int transientVar = 10;
    private static int age = 10;
    private String name;
    private double score;
    private Project project = new HighProject("weiqi", 10);
    private String[] tags;
    private int id;

    @EqualsAndHashCode(callSuper = true)//包含父类的equals 和 hashCode
    public static class HighProject extends Project {
        private String name;
        private int price;

        public HighProject(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
