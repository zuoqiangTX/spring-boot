package com.zuoqiang.learn.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Config implements Serializable {

    private static final long serialVersionUID = -1583235468397086898L;


    /**
     * 自增主键
     */
    private Integer id;

    /**
     * namespace名字，注意，需要全局唯一
     */
    private String name;

    /**
     * app id
     */
    private String appId;

    /**
     * app_type
     */
    private String appType;

    /**
     * 注释
     */
    private String comment;

    /**
     * 1: deleted, 0: normal
     */
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date modifyTime;

}