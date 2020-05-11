package com.zuoqiang.learn.springboot.easyexcel;

import lombok.Data;

import java.util.Date;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 基础数据类
 * @date 2020/5/11 3:32 下午
 */

@Data
public class UploadData {
    private String string;
    private Date date;
    private Double doubleData;
}
