package com.ooo01.common.utils;

import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * {@code @description:} Redis工具类
 */
@Component
public class RedisClient {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    
    /**
     * 设置缓存
     *
     * @param key      键
     * @param value    值
     * @param time     时长
     * @param timeUnit 单位
     */
    public void set(String key, Object value, Long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), time, timeUnit);
    }
}
