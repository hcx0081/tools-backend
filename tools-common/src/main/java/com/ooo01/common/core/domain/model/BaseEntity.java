package com.ooo01.common.core.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code @description:} 实体基类
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 创建者
     */
    private String createBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新者
     */
    private String updateBy;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 请求参数
     */
    private Map<String, Object> params = new HashMap<>();
}
