package com.zuoqiang.learn.springboot.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 基础数据类
 * @date 2020/5/11 3:31 下午
 */

@Data
public class DownloadData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
}
