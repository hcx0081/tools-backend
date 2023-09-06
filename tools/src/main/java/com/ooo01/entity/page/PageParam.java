package com.ooo01.entity.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * {@code @description:} 分页请求参数
 */
@Data
@ApiModel("分页请求参数")
public class PageParam {
    @ApiModelProperty("第几页")
    private Long pageNo = 1L;
    @ApiModelProperty("一页显示多少条记录")
    private Long pageSize = 10L;
}
