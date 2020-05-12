package com.zuoqiang.learn.springboot.validation;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.slf4j.event.Level.ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/5/11 5:11 下午
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException ex
    ) {
        final Optional<ObjectError> firstError = ex.getBindingResult().getAllErrors().stream().findFirst();
        if (firstError.isPresent()) {
            final String firstErrorMessage = firstError.get().getDefaultMessage();
            return handleError(request, BAD_REQUEST, new RuntimeException(firstErrorMessage));
        }
        return handleError(request, BAD_REQUEST, ex);
    }

    private ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request,
                                                            HttpStatus status, Throwable ex) {
        return handleError(request, status, ex, ERROR);
    }

    private ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request,
                                                            HttpStatus status, Throwable ex, Level logLevel) {
        ResultBean response = new ResultBean();
        String message = ex.getMessage();
        printLog(message, ex, logLevel);

        Map<String, Object> errorAttributes = new HashMap<>();
        boolean errorHandled = false;

        if (ex instanceof HttpStatusCodeException) {
            try {
                //try to extract the original error info if it is thrown from apollo programs, e.g. admin service
                errorAttributes = (Map<String, Object>) JSON.parse(((HttpStatusCodeException) ex).getResponseBodyAsString());
                status = ((HttpStatusCodeException) ex).getStatusCode();
                errorHandled = true;
            } catch (Throwable th) {
                //ignore
            }
        }

        if (!errorHandled) {
//            errorAttributes.put("status", status.value());
//            errorAttributes.put("message", message);
//            errorAttributes.put("timestamp",
//                    LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//            errorAttributes.put("exception", ex.getClass().getName());

            errorAttributes.put("code", status.value());
            errorAttributes.put("msg", message);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(errorAttributes, headers, status);
    }

    //打印日志, 其中logLevel为日志级别: ERROR/WARN/DEBUG/INFO/TRACE
    private void printLog(String message, Throwable ex, Level logLevel) {
        switch (logLevel) {
            case ERROR:
                log.error(message, ex);
                break;
            case WARN:
                log.warn(message, ex);
                break;
            case DEBUG:
                log.debug(message, ex);
                break;
            case INFO:
                log.info(message, ex);
                break;
            case TRACE:
                log.trace(message, ex);
                break;
        }
    }
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<ResultBean> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        ResultBean response = new ResultBean();
//        response.setCode("500");
//        String message = "";
//        BindingResult result = ex.getBindingResult();
//        //组装校验错误信息
//        if (result.hasErrors()) {
//            List<ObjectError> list = result.getAllErrors();
//            StringBuffer errorMsgBuffer = new StringBuffer();
//            for (ObjectError error : list) {
//                if (error instanceof FieldError) {
//                    FieldError errorMessage = (FieldError) error;
//                    errorMsgBuffer = errorMsgBuffer.append(errorMessage.getDefaultMessage() + ",");
//                }
//            }
//            //返回信息格式处理
//            message = errorMsgBuffer.toString().substring(0, errorMsgBuffer.length() - 1);
//        }
//        response.setMsg(message);
//        return new ResponseEntity<>(response, null, HttpStatus.BAD_REQUEST);
//    }

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
