package com.zuoqiang.learn.springboot.model;

import lombok.Data;
import lombok.Getter;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 11:30 上午
 */

@Data
public class DeferredResultResponse {
    private Integer code;
    private String msg;

    public enum Msg {
        TIMEOUT("超时"),
        FAILED("失败"),
        SUCCESS("成功");

        @Getter
        private String desc;

        Msg(String desc) {
            this.desc = desc;
        }
    }
}
