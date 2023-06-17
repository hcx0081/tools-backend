package com.ooo01.datalog;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@code @Description:} 数据日志记录切面
 */
@Aspect
@Component
@Slf4j
public class DataLogAspect {
    /**
     * 排除敏感属性字段
     */
    public static final String[] EXCLUDE_PROPERTIES = {"password", "oldPassword", "newPassword", "confirmPassword"};
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    ExecutorService executorPool = Executors.newFixedThreadPool(10);
    
    public static TimerTask recordOperationLog(final DataLogEntity dataLogEntity) {
        return new TimerTask() {
            @Override
            public void run() {
                // SysOperaLogDomainService sysOperaLogDomainService = (SysOperaLogDomainService) SpringContextUtil.getBean(SysOperaLogDomainService.class);
                // sysOperaLogDomainService.insertOperlog(operLog);
                
            }
        };
    }
    
    // 配置织入点
    @Pointcut("@annotation(com.ooo01.datalog.DataLog)")
    public void logPointCut() {
    }
    
    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(dataLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, DataLog dataLog, Object jsonResult) {
        handleLog(joinPoint, dataLog, null, jsonResult);
    }
    
    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(dataLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, DataLog dataLog, Exception e) {
        handleLog(joinPoint, dataLog, e, null);
    }
    
    private void handleLog(final JoinPoint joinPoint, DataLog dataLog, final Exception e, Object jsonResult) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            
            DataLogEntity dataLogEntity = new DataLogEntity();
            // CustomUserDetails userDetails = UserInfoUtils.getUserInfo();
            dataLogEntity.setOperationTime(LocalDateTime.now());
            dataLogEntity.setLogType(DataLog.OperationTypeEnum.OPERA.getCode());
            dataLogEntity.setStatus(DataLog.OperationTypeEnum.SUCCESS.getCode());
            // if (userDetails != null) {
            //     dataLogEntity.setUserId(userDetails.getUserId());
            //     dataLogEntity.setUserName(userDetails.getUsername());
            //     dataLogEntity.setDeptId(userDetails.getDeptId());
            //     dataLogEntity.setDeptName(userDetails.getDeptName());
            // }
            
            if (e != null) {
                // dataLogEntity.setStatus(EnumOperationStatus.FAIL.getCode());
                // dataLogEntity.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // dataLogEntity.setIpAddress(IpUtils.getIpAddr(request));
            dataLogEntity.setHostName(request.getRemoteHost());
            
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            dataLogEntity.setMethod(className + "." + methodName + "()");
            dataLogEntity.setRequestMethod(request.getMethod());
            dataLogEntity.setUrl(request.getRequestURI());
            
            dataLogEntity.setOperationType(dataLog.value().getCode());
            dataLogEntity.setDescription(dataLog.memo());
            
            // 获取参数的信息，传入到数据库中。
            setRequestValue(joinPoint, dataLogEntity, request);
            if (jsonResult != null) {
                dataLogEntity.setJsonResult(StringUtils.substring(JSON.toJSONString(jsonResult), 0, 2000));
            }
            
            logger.info(controllerLog.memo());
            executorPool.execute(recordOperationLog(dataLogEntity));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("操作日志插入错误");
        }
    }
    
    /**
     * 获取请求的参数，放到log中
     *
     * @param operLog 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(JoinPoint joinPoint, DataLog dataLog, HttpServletRequest request) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        if (MapUtils.isNotEmpty(map)) {
            String params = JSONObject.toJSONString(map, excludePropertyPreFilter());
            dataLog.setOperationParam(params);
        } else {
            Object args = joinPoint.getArgs();
            if (ObjectUtils.isNotEmpty(args)) {
                String params = argsArrayToString(joinPoint.getArgs());
                dataLog.setOperationParam(params);
            }
        }
    }
    
    /**
     * 忽略敏感属性
     */
    public PropertyPreFilters.MySimplePropertyPreFilter excludePropertyPreFilter() {
        return new PropertyPreFilters().addFilter().addExcludes(EXCLUDE_PROPERTIES);
    }
    
    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (ObjectUtils.isNotEmpty(o) && !isFilterObject(o)) {
                    try {
                        Object jsonObj = JSONObject.toJSONString(o, excludePropertyPreFilter());
                        params += jsonObj.toString() + " ";
                    } catch (Exception e) {
                    }
                }
            }
        }
        return params.trim();
    }
    
    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
    }
}
