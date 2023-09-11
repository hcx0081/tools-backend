package com.ooo01.framework.exception;

import com.ooo01.framework.entity.ControllerResult;
import com.ooo01.framework.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * {@code @description:} 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ControllerResult handleException(HttpRequestMethodNotSupportedException e) {
        log.error("请求方式不支持异常：", e);
        return ControllerResult.error("不支持' " + e.getMethod() + "'请求");
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("方法入参校验异常：" + e);
        return ControllerResult.error(e.getFieldError().getDefaultMessage());
    }
    
    @ExceptionHandler(BusinessException.class)
    public Object handleBusinessException(BusinessException e) {
        log.error("业务异常：" + e);
        return ControllerResult.error(e.getMsg());
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ControllerResult handleRuntimeException(RuntimeException e) {
        log.error("运行时异常：", e);
        return ControllerResult.error("运行时异常:" + e.getMessage());
    }
}
