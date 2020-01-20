package com.zuoqiang.learn.springboot.new_feature.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/1/20 4:53 下午
 */

public class LamdaTest {
    private List<Product> products = new ArrayList<>();

    public LamdaTest() {
        products.add(new Product(1L, "苹果手机", 8888.88));
        products.add(new Product(2L, "华为手机", 6666.66));
        products.add(new Product(3L, "联想笔记本", 7777.77));
        products.add(new Product(4L, "机械键盘", 999.99));
        products.add(new Product(5L, "雷蛇鼠标", 222.22));
    }

    public static void main(String[] args) {
        LamdaTest lamdaTest = new LamdaTest();
        lamdaTest.products.stream().filter(product -> product.getPrice() > 1000).forEach(product -> System.out.println(product));
    }

}
