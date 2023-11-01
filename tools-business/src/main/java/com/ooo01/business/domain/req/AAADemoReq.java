package com.ooo01.business.domain.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * {@code @description:} 示例请求数据
 */
@Data
@ApiModel("示例请求数据")
public class AAADemoReq {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("名称")
    private String name;
}
