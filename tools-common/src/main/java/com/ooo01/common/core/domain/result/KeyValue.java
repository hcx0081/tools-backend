package com.ooo01.common.core.domain.result;

import lombok.Data;

import java.io.Serializable;

/**
 * {@code @description:} Key Value 的键值对
 */
@Data
public class KeyValue<K, V> implements Serializable {
    private K key;
    private V value;
}
