package com.ooo01.business.service.impl;

import com.ooo01.business.service.AAADemoService;
import org.springframework.stereotype.Service;

/**
 * {@code @description:} 示例服务接口实现类
 */
@Service
public class AAADemoServiceImpl implements AAADemoService {
    @Override
    public String getDemo() {
        return "demo";
    }
}