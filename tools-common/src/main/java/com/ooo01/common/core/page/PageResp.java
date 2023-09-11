package com.ooo01.common.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * {@code @description:} 分页响应数据
 */
@Data
@ApiModel("分页响应数据")
public class PageResp<T> {
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty("记录数")
    private Long count;
    @ApiModelProperty("总记录数")
    private Long total;
}
