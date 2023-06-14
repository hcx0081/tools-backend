package com.ooo01.datalog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * {@code @Description:} 数据日志记录注解
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataLog {
    @AliasFor("name")
    OperationTypeEnum value() default OperationTypeEnum.OTHER;
    
    @AliasFor("value")
    OperationTypeEnum name() default OperationTypeEnum.OTHER;
    
    String description() default "";
    
    @AllArgsConstructor
    @Getter
    enum OperationTypeEnum {
        ADD("1", "新增"),
        DELETE("2", "删除"),
        UPDATE("3", "修改"),
        QUERY("4", "查询"),
        GRANT("5", "授权"),
        IMPORT("6", "导入"),
        EXPORT("7", "导出"),
        OTHER("0", "其他");
        private final String code;
        private final String name;
    }
}
