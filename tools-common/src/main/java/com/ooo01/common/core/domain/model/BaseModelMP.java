package com.ooo01.common.core.domain.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code @description:} 实体基类（Mybatis-Plus）
 */
@Data
public class BaseModelMP implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 创建者
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT) // 新增执行
    private String createBy;
    
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    /**
     * 更新者
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
    private String updateBy;
    
    /**
     * 更新时间
     */
    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    
    /**
     * 删除标志（0：未删除、1：已删除）
     */
    @TableLogic
    @TableField(value = "del_flag")
    private Integer del_flag;
    
    /**
     * 请求参数
     */
    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
