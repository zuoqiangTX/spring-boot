package com.zuoqiang.learn.springboot.new_feature.dto;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/1/20 4:43 下午
 */


public class MagicLambda {
    private List<Product> products = new ArrayList<>();

    public MagicLambda() {
        products.add(new Product(1L, "苹果手机", 8888.88));
        products.add(new Product(2L, "华为手机", 6666.66));
        products.add(new Product(3L, "联想笔记本", 7777.77));
        products.add(new Product(4L, "机械键盘", 999.99));
        products.add(new Product(5L, "雷蛇鼠标", 222.22));
    }

    public static void main(String[] args) {
        MagicLambda magicLambda = new MagicLambda();
        //1、需求：筛选出所有名称包含手机的商品
//        List<Product> list = filterProductByName(magicLambda.products);

        //2、需求：筛选出所有价格大于1000的商品
        List<Product> list = filterProductByPrice(magicLambda.products);
        for (Product product : list) {
            System.out.println(product);
        }
    }

    /**
     * 需求：筛选出所有名称包含手机的商品
     *
     * @param products
     * @return
     */
    public static List<Product> filterProductByName(List<Product> products) {
        List<Product> list = Lists.newArrayList();
        for (Product product : products) {
            if (product.getName().contains("手机")) {
                list.add(product);
            }
        }
        return list;
    }

    /**
     * 需求：筛选出所有价格大于1000的商品
     *
     * @param products
     * @return
     */
    public static List<Product> filterProductByPrice(List<Product> products) {
        List<Product> list = Lists.newArrayList();
        for (Product product : products) {
            if (product.getPrice() > 1000) {
                list.add(product);
            }
        }
        return list;
    }
}
