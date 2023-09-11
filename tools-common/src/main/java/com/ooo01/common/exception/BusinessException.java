package com.ooo01.common.exception;

/**
 * {@code @description:} 业务异常
 */
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
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
}