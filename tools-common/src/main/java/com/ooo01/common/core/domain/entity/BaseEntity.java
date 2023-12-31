package com.ooo01.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code @description:} 实体基类
 */
public class BaseEntity implements Serializable {
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
    private LocalDate createTime;
    
    /**
     * 更新者
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
    private String updateBy;
    
    /**
     * 更新时间
     */
    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;
    
    @TableLogic
    private Integer deleted;
    
    /**
     * 请求参数
     */
    @TableField(exist = false)
    private Map<String, Object> params;
    
    
    public String getCreateBy() {
        return createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    public LocalDate getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateBy() {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    public LocalDate getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }
    
    public Integer getDeleted() {
        return deleted;
    }
    
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    
    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }
    
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
