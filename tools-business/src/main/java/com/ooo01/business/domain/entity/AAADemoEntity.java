package com.ooo01.business.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * {@code @description:} 示例实体类
 */
@Data
@Entity
@Table(name = "busi_demo")
public class AAADemoEntity {
    @Id
    private String id;
}
