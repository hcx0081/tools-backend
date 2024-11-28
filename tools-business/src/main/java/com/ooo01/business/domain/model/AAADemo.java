package com.ooo01.business.domain.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ooo01.common.core.domain.model.BaseModelMP;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code @description:} 示例实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "business_demo")
public class AAADemo extends BaseModelMP {
    private String id;
}
