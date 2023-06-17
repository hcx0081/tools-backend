create table sys_login_log
(
    id             bigint auto_increment comment '登录日志id',
    user_name      varchar(50)  default '' null comment '用户账号',
    login_ip       varchar(128) default '' null comment '登录IP地址',
    login_location varchar(255) default '' null comment '登录地点',
    browser        varchar(50)  default '' null comment '浏览器',
    os             varchar(50)  default '' null comment '操作系统',
    status         int          default 0 null comment '登录状态（0：成功、1：失败）',
    msg            varchar(255) default '' null comment '提示消息',

    login_time     datetime     default current_timestamp not null comment '访问时间',
    primary key (id)
) comment '系统登录日志';

