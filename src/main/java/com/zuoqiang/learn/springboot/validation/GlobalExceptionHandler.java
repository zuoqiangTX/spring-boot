package com.zuoqiang.learn.springboot.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/11 5:11 下午
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultBean methodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
        ResultBean result = ResultBean.FAIL;
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
//        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        errorMsg.append(errors.get(0).getDefaultMessage());
        log.error("---MethodArgumentNotValidException Handler--- ERROR: {}", errorMsg.toString());
        result.setMsg(errorMsg.toString());
        return result;
    }
}
