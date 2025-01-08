package com.ooo01.common.core.domain.result;

import lombok.Data;

import java.io.Serializable;

/**
 * {@code @description:} Name Count 的键值对
 */
@Data
public class NameCount<Name, Count> implements Serializable {
    private Name name;
    private Count count;
}
