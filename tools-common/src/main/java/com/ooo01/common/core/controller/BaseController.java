package com.ooo01.common.core.controller;

import com.ooo01.common.core.domain.result.ControllerResult;

/**
 * {@code @description:} 控制层基类
 */
public class BaseController {
    /**
     * 返回成功消息
     */
    public ControllerResult success() {
        return ControllerResult.success();
    }
    
    /**
     * 返回失败消息
     */
    public ControllerResult error() {
        return ControllerResult.error();
    }
    
    /**
     * 返回成功消息
     */
    public ControllerResult success(String msg) {
        return ControllerResult.success(msg);
    }
    
    /**
     * 返回成功数据
     */
    public ControllerResult success(Object data) {
        return ControllerResult.success(data);
    }
    
    /**
     * 返回失败消息
     */
    public ControllerResult error(String msg) {
        return ControllerResult.error(msg);
    }
    
    /**
     * 返回失败数据
     */
    public ControllerResult warn(Object data) {
        return ControllerResult.error(data);
    }
    
    /**
     * 返回结果
     *
     * @param rows 影响行数
     * @return 结果
     */
    protected ControllerResult toResult(int rows) {
        return rows > 0 ? ControllerResult.success() : ControllerResult.error();
    }
    
    /**
     * 返回结果
     *
     * @param result 执行结果
     * @return 结果
     */
    protected ControllerResult toResult(boolean result) {
        return result ? success() : error();
    }
}
