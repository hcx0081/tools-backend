package com.ooo01.common.core.entity;

import com.ooo01.common.core.page.PageResp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * {@code @description:} 分页结果
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult extends ControllerResult {
    // 记录数
    public static final String COUNT = "count";
    // 总记录数
    public static final String TOTAL = "total";
    
    public static <T> ControllerResult success(PageResp<T> pageResp) {
        ControllerResult result = ControllerResult.success(pageResp.getData());
        result.put(COUNT, pageResp.getCount());
        result.put(TOTAL, pageResp.getTotal());
        return result;
    }
}
