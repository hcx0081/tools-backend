package com.ooo01.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code @description:} 分页结果
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult extends ControllerResult {
    private int page;
    private int size;
    private long totalCount;
    private int totalPage;
}
