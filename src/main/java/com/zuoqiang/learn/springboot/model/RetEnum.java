package com.zuoqiang.learn.springboot.model;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 7:21 下午
 */

public enum RetEnum {
    ERROR(1, "失败"),
    SUCCESS(0, "成功");

    private int ret;

    private String msg;

    RetEnum(int ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
