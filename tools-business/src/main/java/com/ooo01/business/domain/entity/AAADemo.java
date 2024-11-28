package com.ooo01.business.domain.entity;

import com.ooo01.common.core.domain.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@code @description:} 示例实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "business_demo")
public class AAADemo extends BaseEntity {

}
