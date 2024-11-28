package com.ooo01.common.core.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * {@code @description:} 实体基类
 */
@Data
@Entity
public class BaseEntity {
    @Id
    private String id;
}
