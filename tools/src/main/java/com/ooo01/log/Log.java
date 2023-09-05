package com.ooo01.log;

import java.lang.annotation.*;

/**
 * {@code @description:} 数据日志记录注解
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    OperationTypeEnum operationType() default OperationTypeEnum.OTHER;
    
    OperatorTypeEnum operatorType() default OperatorTypeEnum.OTHER;
    
    String description() default "";
    
    enum OperationTypeEnum {
        /**
         * 新增
         */
        INSERT,
        /**
         * 删除
         */
        DELETE,
        /**
         * 修改
         */
        UPDATE,
        /**
         * 查询
         */
        SELECT,
        /**
         * 授权
         */
        GRANT,
        /**
         * 导入
         */
        IMPORT,
        /**
         * 导出
         */
        EXPORT,
        /**
         * 强退
         */
        FORCE,
        /**
         * 生成代码
         */
        GEN,
        /**
         * 清空数据
         */
        CLEAN,
        /**
         * 其它
         */
        OTHER,
    }
    
    enum OperatorTypeEnum {
        /**
         * 后台用户
         */
        BACK,
        /**
         * 手机端用户
         */
        MOBILE,
        /**
         * 其它
         */
        OTHER,
    }
    
}
