package com.ooo01.business.controller;

import com.ooo01.business.service.AAADemoService;
import com.ooo01.common.core.domain.ControllerResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * {@code @description:} 示例接口
 */
@Api(tags = "示例接口")
@RestController
@RequestMapping("/xxx/demo")
public class AAADemoController {
    @Resource
    private AAADemoService aaaDemoService;
    
    @GetMapping("/demo")
    public ControllerResult getDemo() {
        return ControllerResult.success(aaaDemoService.getDemo());
    }
}