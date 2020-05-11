package com.zuoqiang.learn.springboot.validation;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/11 5:10 下午
 */

@Data
public class ResultBean implements Serializable {

    public static final ResultBean FAIL = new ResultBean("", "500", "");
    private static final long serialVersionUID = -8325571021507513852L;

    public ResultBean(String msg) {
        this.msg = msg;
    }

    private String msg;

    private String code;

    private String content;

    public ResultBean(String msg, String code, String content) {
        this.msg = msg;
        this.code = code;
        this.content = content;
    }

    public ResultBean() {
    }
}
