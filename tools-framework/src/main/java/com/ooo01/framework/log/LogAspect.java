package com.ooo01.framework.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooo01.common.utils.web.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * {@code @description:} 日志切面类
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("@within(org.springframework.stereotype.Controller)||@within(org.springframework.web.bind.annotation.RestController)")
    public void logPointCut() {
    }
    
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        // 方法
        Method method = methodSignature.getMethod();
        // 类
        Class<?> targetClass = method.getDeclaringClass();
        
        String classAndMethod = targetClass.getName() + "#" + method.getName();
        
        log.info("\n开始调用:\n-> 请求方法: {}\n-> 请求URL: {}", classAndMethod, ServletUtils.getRequest().getRequestURL());
        log.info("\n入参: {}", objectMapper.writeValueAsString(getRequestParams(methodSignature, pjp)));
        
        long start = System.currentTimeMillis();
        // 执行方法
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        
        log.info("\n出参: {}", objectMapper.writeValueAsString(result));
        log.info("\n结束调用:\n-> 请求方法: {}\n-> 执行时长: {}", classAndMethod, (end - start) + "ms");
        return result;
    }
    
    private Object getRequestParams(MethodSignature methodSignature, ProceedingJoinPoint pjp) {
        Map<String, Object> requestParams = new HashMap<>();
        // 参数名
        String[] paramNames = methodSignature.getParameterNames();
        // 参数值
        Object[] paramValues = pjp.getArgs();
        
        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];
            requestParams.put(paramNames[i], value);
        }
        return requestParams;
    }
}
