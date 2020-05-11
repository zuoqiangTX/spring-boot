package com.zuoqiang.learn.springboot.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    public ResponseEntity<ResultBean> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ResultBean response = new ResultBean();
        response.setCode("500");
        String message = "";
        BindingResult result = ex.getBindingResult();
        //组装校验错误信息
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            StringBuffer errorMsgBuffer = new StringBuffer();
            for (ObjectError error : list) {
                if (error instanceof FieldError) {
                    FieldError errorMessage = (FieldError) error;
                    errorMsgBuffer = errorMsgBuffer.append(errorMessage.getDefaultMessage() + ",");
                }
            }
            //返回信息格式处理
            message = errorMsgBuffer.toString().substring(0, errorMsgBuffer.length() - 1);
        }
        response.setMsg(message);
        return new ResponseEntity<>(response, null, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResultBean methodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
//        ResultBean result = ResultBean.FAIL;
//        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
//        StringBuffer errorMsg = new StringBuffer();
////        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
//        errorMsg.append(errors.get(0).getDefaultMessage());
//        log.error("---MethodArgumentNotValidException Handler--- ERROR: {}", errorMsg.toString());
//        result.setMsg(errorMsg.toString());
//        return result;
//    }
}
