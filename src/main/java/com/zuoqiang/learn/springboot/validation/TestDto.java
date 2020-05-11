package com.zuoqiang.learn.springboot.validation;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/11 5:27 下午
 */

public class TestDto {
    @NotNull(message = "{user.name.null}")
    @Size(min = 2, max = 5, message = "{user.name.error}")
    private String name;//姓名

    @NotNull(message = "{user.birthday.null}")
    @Past(message = "{user.birthday.error}")
    private Date birthday;//生日

    @NotNull(message = "{user.money.null}")
    @Digits(integer = 3, fraction = 2, message = "{user.money.error}")
    private BigDecimal money;//资产

    @NotNull(message = "{user.phoneNum.null}")
    @Pattern(regexp = "\\d{11}", message = "{user.phoneNum.error}")
    private String phoneNum;//手机号
}
