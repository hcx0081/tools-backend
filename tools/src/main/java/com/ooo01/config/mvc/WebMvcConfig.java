package com.ooo01.config.mvc;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * {@code @description:}
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
    
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 获取Json转换器
        MappingJackson2HttpMessageConverter converter = (MappingJackson2HttpMessageConverter) converters.get(0);
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, new ToStringSerializer());
        module.addSerializer(long.class, new ToStringSerializer());
        converter.getObjectMapper().registerModule(module);
    }
}