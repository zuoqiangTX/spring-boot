package com.zuoqiang.learn.springboot.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/11 5:56 下午
 */

@Slf4j
@Component
public class LocalMessageComponent {
    @Autowired
    private MessageSource messageSource;

    /**
     * 国际化
     *
     * @param result
     * @return
     */
    public String getLocalMesage(String result, Object[] params) {
        String message = "";
        try {
            Locale locale = LocaleContextHolder.getLocale();
            message = messageSource.getMessage(result, params, locale);
        } catch (Exception e) {
            log.error("国际化信息解析器失败!result:{},params:{},e ", result, params, e);
        }
        return message;
    }

    /**
     * 获取本地化信息
     *
     * @param key
     * @return
     */
    public String getLocalValue(String key) {
        String message = "";
        try {
            Locale locale = LocaleContextHolder.getLocale();
            message = messageSource.getMessage(key, null, locale);
        } catch (Exception e) {
            log.error("国际化信息解析器失败!result:{},e ", key, e);
        }
        return message;
    }
}
