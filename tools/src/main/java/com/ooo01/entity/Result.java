package com.ooo01.entity;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 结果
 * {@code @Description:}
 *
 * @author Admin
 * @date 2023/06/14
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
     * @param msg    味精
     * @param data   数据
     */
    public Result(Status status, String msg, Object data) {
        super.put(CODE, status.value);
        super.put(MSG, msg);
        super.put(DATA, msg);
    }
    
    /**
     * 成功
     * 返回成功消息
     *
     * @return 成功结果
     */
    public static Result success() {
        return Result.success("操作成功");
    }
    
    /**
     * 成功
     * 返回成功消息
     *
     * @param msg 成功消息
     * @return 成功结果
     */
    public static Result success(String msg) {
        return new Result(Status.SUCCESS, msg, null);
    }
    
    /**
     * 成功
     * 返回成功数据
     *
     * @param data 成功数据
     * @return 成功结果
     */
    public static Result success(Object data) {
        return new Result(Status.SUCCESS, "操作成功", data);
    }
    
    /**
     * 成功
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
     * 错误
     * 返回失败消息
     *
     * @return 失败结果
     */
    public static Result error() {
        return Result.error("操作失败");
    }
    
    /**
     * 错误
     * 返回失败消息
     *
     * @param msg 失败消息
     * @return 失败结果
     */
    public static Result error(String msg) {
        return new Result(Status.ERROR, msg, null);
    }
    
    /**
     * 错误
     * 返回失败数据
     *
     * @param data 失败数据
     * @return 失败结果
     */
    public static Result error(Object data) {
        return new Result(Status.ERROR, "操作失败", data);
    }
    
    /**
     * 错误
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
     * 状态
     * 状态类型
     *
     * @author Admin
     * @date 2023/06/14
     */
    public enum Status {
        // 成功：200 SUCCESS
        SUCCESS(HttpStatus.OK.value()),
        // 错误：500 Internal Server Error
        ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value());
        private final int value;
        
        /**
         * 状态
         *
         * @param value 价值
         */
        Status(int value) {
            this.value = value;
        }
    }
}
