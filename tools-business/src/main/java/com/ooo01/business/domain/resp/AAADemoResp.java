package com.ooo01.business.domain.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * {@code @description:} 示例响应数据
 */
@Data
@ApiModel("示例响应数据")
public class AAADemoResp {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("名称")
    private String name;
}
