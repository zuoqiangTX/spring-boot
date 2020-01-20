package com.zuoqiang.learn.springboot.new_feature.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/1/20 4:42 下午
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id; //商品编号
    private String name; //商品名称
    private Double price;
    ; //商品价格
}
