package com.ooo01.business.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@code @description:} 示例枚举类
 */
@Getter
@AllArgsConstructor
public enum AAADemoEnum {
    SUCCESS(0, "成功"),
    ERROR(1, "失败");
    
    private final Integer code;
    private final String desc;
}
