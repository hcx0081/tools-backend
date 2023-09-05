package com.ooo01.entity;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;

/**
 * {@code @Description:} 返回结果
 */
public class Result extends HashMap<String, Object> implements Serializable {
    // 状态码
    public static final String CODE = "code";
    // 响应消息
    public static final String MSG = "msg";
    // 响应数据
    public static final String DATA = "data";
    private static final long serialVersionUID = 1L;

    /**
     * 结果
     *
     * @param status 状态
     * @param msg    消息
     * @param data   数据
     */
    public Result(Status status, String msg, Object data) {
        super.put(CODE, status.code);
        super.put(MSG, msg);
        super.put(DATA, data);
    }
    
    /**
     * 返回成功消息
     *
     * @return 成功结果
     */
    public static Result success() {
        return Result.success("操作成功");
    }
    
    /**
     * 返回成功消息
     *
     * @param msg 成功消息
     * @return 成功结果
     */
    public static Result success(String msg) {
        return new Result(Status.SUCCESS, msg, null);
    }
    
    /**
     * 返回成功数据
     *
     * @param data 成功数据
     * @return 成功结果
     */
    public static Result success(Object data) {
        return new Result(Status.SUCCESS, "操作成功", data);
    }
    
    /**
     * 返回成功消息和成功数据
     *
     * @param msg  成功消息
     * @param data 成功数据
     * @return 成功结果
     */
    public static Result success(String msg, Object data) {
        return new Result(Status.SUCCESS, msg, data);
    }
    
    /**
     * 返回失败消息
     *
     * @return 失败结果
     */
    public static Result error() {
        return Result.error("操作失败");
    }
    
    /**
     * 返回失败消息
     *
     * @param msg 失败消息
     * @return 失败结果
     */
    public static Result error(String msg) {
        return new Result(Status.ERROR, msg, null);
    }
    
    /**
     * 返回失败数据
     *
     * @param data 失败数据
     * @return 失败结果
     */
    public static Result error(Object data) {
        return new Result(Status.ERROR, "操作失败", data);
    }
    
    /**
     * 返回失败消息和失败数据
     *
     * @param msg  失败消息
     * @param data 失败数据
     * @return 失败结果
     */
    public static Result error(String msg, Object data) {
        return new Result(Status.ERROR, msg, data);
    }
    
    /**
     * 状态类型
     */
    public enum Status {
        // 成功：200 SUCCESS
        SUCCESS(HttpStatus.OK.value()),
        // 错误：500 Internal Server Error
        ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value());
        private final int code;

        Status(int code) {
            this.code = code;
        }
    }
}
