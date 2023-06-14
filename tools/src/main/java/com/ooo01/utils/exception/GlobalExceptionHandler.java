package com.ooo01.utils.exception;

import com.ooo01.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * {@code @Description:} 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 请求方式不支持
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return Result.error("不支持' " + e.getMethod() + "'请求");
    }
    
    // 拦截未知的运行时异常
    @ExceptionHandler(RuntimeException.class)
    public Result notFount(RuntimeException e) {
        log.error("运行时异常：", e);
        return Result.error("运行时异常:" + e.getMessage());
    }
}
