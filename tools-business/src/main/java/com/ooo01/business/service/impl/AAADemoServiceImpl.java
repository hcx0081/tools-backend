package com.ooo01.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ooo01.business.domain.model.AAADemo;
import com.ooo01.business.mapper.AAADemoMapper;
import com.ooo01.business.service.AAADemoService;
import org.springframework.stereotype.Service;

/**
 * {@code @description:} 示例服务接口实现类
 */
@Service
public class AAADemoServiceImpl extends ServiceImpl<AAADemoMapper, AAADemo> implements AAADemoService {
    @Override
    public String getDemo() {
        return "demo";
    }
}
