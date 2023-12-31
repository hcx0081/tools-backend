package com.ooo01.framework.log;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * {@code @description:} 数据日志记录实体类
 */
@Data
public class LogEntity {
    // 日志主键id
    private Long id;
    // 功能模块编码
    private String moduleCode;
    // 功能模块名称
    private String moduleName;
    // 操作url
    private String url;
    // 客户端IP地址
    private String ipAddress;
    // 客户端MAC地址
    private String macAddress;
    // 客户端主机名称
    private String hostName;
    // 操作时间
    private LocalDateTime operationTime;
    // 操作类型
    private String operationType;
    // 操作用户id
    private String userId;
    // 操作用户名称
    private String userName;
    // 操作用户机构代码
    private String deptId;
    // 操作用户机构名称
    private String deptName;
    // 日志类型（1：登录日志、2：模块操作日志）
    private String logType;
    // 操作状态（1：成功、0：失败）
    private String status;
    // 失败信息
    private String errorMsg;
    // 耗时（单位：毫秒）
    private Long costTime;
    // HTTP请求方式
    private String httpMethod;
    // 请求方法
    private String reqMethod;
    // 请求参数
    private String reqParam;
    // 响应数据
    private String respResult;
    // 描述说明
    private String description;
}
