package com.ooo01.common.core.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * {@code @description:} 分页请求数据
 */
@Data
@ApiModel("分页请求数据")
public class PageReq implements Serializable {
    
    private static final Long PAGE_NO = 1L;
    private static final Long PAGE_SIZE = 10L;
    
    @ApiModelProperty("页码")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为1")
    private Long pageNo = PAGE_NO;
    @ApiModelProperty("每页条数")
    @NotNull(message = "每页条数不能为空")
    @Min(value = 1, message = "每页条数最小值为1")
    private Long pageSize = 10L;
}
