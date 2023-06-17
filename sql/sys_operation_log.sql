create table sys_operation_log
(
    id                 bigint auto_increment comment '操作日志id',
    title              varchar(50)   default '' null comment '模块标题',
    method             varchar(100)  default '' null comment '方法名称',
    request_method     varchar(10)   default '' null comment '请求方式',
    request_url        varchar(255)  default '' null comment '请求URL',
    request_param      varchar(2000) default '' null comment '请求参数',
    response_result    varchar(2000) default '' null comment '响应数据',
    error_msg          varchar(2000) default '' null comment '错误消息',
    operation_type     int(2) default 0 null comment '操作类型',
    operation_ip       varchar(128)  default '' null comment '操作IP地址',
    operation_location varchar(255)  default '' null comment '操作地点',
    operator_type      int(1) default 0 null comment '操作者类型',
    operator_name      varchar(50)   default '' null comment '操作者名称',
    dept_name          varchar(50)   default '' null comment '部门名称',
    status             int(1) default 0 null comment '操作状态（0：正常、1：异常）',

    operation_time     datetime null comment '操作时间',
    primary key (id)
) comment '系统操作日志';

