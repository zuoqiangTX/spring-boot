package com.zuoqiang.learn.springboot.model;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 7:20 下午
 */

import java.io.Serializable;
import java.util.HashMap;


/**
 * @description: 封装返回结果类
 * @author: hs
 * @create: 2018-09-21 22:42:04
 **/
public class R<T> extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 372875066309188329L;

    public R(int code, String msg) {
        put("code", code);
        put("msg", msg);
        put("data", null);
        put("error", false);
    }

    public static R fail() {

        return new R(RetEnum.ERROR.getRet(), RetEnum.ERROR.getMsg());
    }

    public static R fail(String msg) {
        return fail(RetEnum.ERROR.getRet(), msg);
    }

    public static R fail(int code, String msg) {
        R r = new R(code, msg);
        r.put("error", true);
        r.put("data", null);
        return r;
    }

    public static <T> R<T> fail(T data) {
        R r = new R(RetEnum.ERROR.getRet(), RetEnum.ERROR.getMsg());
        r.put("data", data);
        r.put("error", true);
        return r;
    }


    public static <T> R<T> fail(int code, String msg, T data) {
        R r = new R(code, msg);
        r.put("data", data);
        r.put("error", true);
        return r;
    }


    public static R ok() {

        return new R(RetEnum.SUCCESS.getRet(), RetEnum.SUCCESS.getMsg());
    }


    public static R ok(String msg) {
        R r = new R(RetEnum.SUCCESS.getRet(), msg);
        r.put("data", msg);
        r.put("error", false);

        return r;
    }

    public static R ok(int code, String msg) {
        R r = new R(code, msg);
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", null);
        r.put("error", false);

        return r;
    }


    public static <T> R<T> ok(T data) {
        R r = new R(RetEnum.SUCCESS.getRet(), RetEnum.SUCCESS.getMsg());
        r.put("data", data);
        r.put("error", false);
        return r;
    }


    public static <T> R<T> ok(int code, String msg, T data) {
        R r = new R(code, msg);
        r.put("data", data);
        r.put("error", false);
        return r;
    }


    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}

