package com.ooo01.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code @description:} 业务异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class BusinessException extends RuntimeException {
    // 错误码
    private Integer code;
    // 错误消息
    private String msg;
    
    public BusinessException() {
    }
    
    public BusinessException(Integer code) {
        this.code = code;
        this.msg = "业务异常";
    }
    
    public BusinessException(String msg) {
        this.msg = msg;
    }
    
    public BusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}