package com.ooo01.controller;

import com.ooo01.entity.Result;

/**
 * {@code @Description:} 控制层基类
 */
public class BaseController {
    /**
     * 返回成功消息
     */
    public Result success() {
        return Result.success();
    }

    /**
     * 返回失败消息
     */
    public Result error() {
        return Result.error();
    }

    /**
     * 返回成功消息
     */
    public Result success(String msg) {
        return Result.success(msg);
    }

    /**
     * 返回成功数据
     */
    public Result success(Object data) {
        return Result.success(data);
    }

    /**
     * 返回失败消息
     */
    public Result error(String msg) {
        return Result.error(msg);
    }

    /**
     * 返回失败数据
     */
    public Result warn(Object data) {
        return Result.error(data);
    }

    /**
     * 返回结果
     *
     * @param rows 影响行数
     * @return 结果
     */
    protected Result toResult(int rows) {
        return rows > 0 ? Result.success() : Result.error();
    }

    /**
     * 返回结果
     *
     * @param result 执行结果
     * @return 结果
     */
    protected Result toResult(boolean result) {
        return result ? success() : error();
    }
}
