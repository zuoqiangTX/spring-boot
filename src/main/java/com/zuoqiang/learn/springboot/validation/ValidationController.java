package com.zuoqiang.learn.springboot.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Locale;

/**
 * @author zuoqiang
 * @version 1.0
 * @description SpringBoot参数校验和国际化使用
 * @date 2020/5/11 5:05 下午
 */

@RestController
public class ValidationController {
    @Autowired
    private LocalMessageComponent localMessageComponent;

    @RequestMapping("getMessageByKey")
    public ResultBean getMessageByKey() {
        String key = "user.name.null";
        Object[] param = {"2019-8-8", "2019-9-9"};
        Locale locale = LocaleContextHolder.getLocale();
        return new ResultBean(localMessageComponent.getLocalMesage(key, param));
    }

    @RequestMapping("global")
    public String test5(@Valid @RequestBody TestDto dto) {
        System.out.println("dto....................");
        return "dto.........................";
    }
}
