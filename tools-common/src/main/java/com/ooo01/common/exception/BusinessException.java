package com.ooo01.common.exception;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.ooo01.common.core.domain.result.ControllerResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.service.spi.ServiceException;

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
    
    public static void exception(String errorMsgTemplate, Object... params) {
        String logMsg = StrUtil.format(errorMsgTemplate, params);
        throw new BusinessException(logMsg);
    }
    
    /**
     * 断言是否为true
     *
     * @param bool
     * @param errorMsgTemplate
     * @param params
     */
    public static void assertBoolean(Boolean bool, String errorMsgTemplate, Object... params) {
        if (BooleanUtil.isFalse(bool)) {
            String logMsg = StrUtil.format(errorMsgTemplate, params);
            throw new BusinessException(logMsg);
        }
    }
    
    /**
     * 断言是否为空
     *
     * @param object
     * @param errorMsgTemplate
     * @param params
     */
    public static void assertNotNull(Object object, String errorMsgTemplate, Object... params) {
        if (ObjUtil.isNull(object)) {
            String logMsg = StrUtil.format(errorMsgTemplate, params);
            throw new ServiceException(logMsg);
        }
    }
    
    /**
     * 断言结果是否失败
     *
     * @param result
     * @param errorMsgTemplate
     * @param params
     */
    public static void assertResult(ControllerResult result, String errorMsgTemplate, Object... params) {
        if (result.isFail()) {
            String logMsg = StrUtil.format(errorMsgTemplate, params);
            throw new ServiceException(logMsg);
        }
    }
}