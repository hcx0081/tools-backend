package com.ooo01.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ooo01.business.domain.entity.AAADemo;

/**
 * {@code @description:} 示例服务接口
 */
public interface AAADemoService extends IService<AAADemo> {
    String getDemo();
}
