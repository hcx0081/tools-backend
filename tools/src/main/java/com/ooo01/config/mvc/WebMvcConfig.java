package com.ooo01.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * {@code @Description:}
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new HandlerInterceptor() {
        });
        interceptor.addPathPatterns("/**")
                // 放行登录功能
                .excludePathPatterns("/employee/login", "/user/login")
                // 放行静态资源
                .excludePathPatterns("/backend/**", "/front/**")
                // 放行接口文档
                .excludePathPatterns("/doc.html", "/swagger-resources", "/webjars/**", "/v2/api-docs");
    }
}