create table vote.vote_activity
(
    id                 bigint                                   not null comment 'id',
    imgs               varchar(100)   default ''                not null comment '活动图片',
    title              varchar(100)   default ''                not null comment '活动标题',
    remark             varchar(200)   default ''                not null comment '备注',
    share_count        bigint         default 0                 not null comment '分享次数',
    ticket_count       bigint         default 0                 not null comment '票数',
    popularity         bigint         default 0                 not null comment '人气',
    sign_up_count      bigint         default 0                 not null comment '报名人数',
    sign_up_start_time datetime                                 not null comment '报名开始时间',
    sign_up_end_time   datetime                                 not null comment '报名结束时间',
    vote_start_time    datetime                                 not null comment '投票开始时间',
    vote_end_time      datetime                                 not null comment '投票结束时间',
    real_browse        bigint         default 0                 not null comment '真实浏览',
    total_amount       decimal(10, 2) default 0.00              not null comment '总金额',
    today_amount       decimal(10, 2) default 0.00              not null comment '今日金额',
    vote_rule          varchar(100)   default ''                not null comment '投票规则',
    status             int            default 0                 not null comment '状态（0：关闭、1：结束、2：正常、3：投票）',
    is_gift            int            default 1                 not null comment '是否开启送礼功能（0：关闭、1：开启）',
    is_sign_up_review  int            default 1                 not null comment '是否开启报名审核（0：关闭、1：开启）',
    is_sys_img         int            default 1                 not null comment '是否使用系统图片（0：关闭、1：开启）',
    notice             varchar(500)   default ''                not null comment '公告内容',
    introduction       varchar(500)   default ''                not null comment '活动介绍',
    prize              varchar(500)   default ''                not null comment '活动奖品',
    create_by          varchar(64)    default ''                not null comment '创建者',
    create_time        datetime       default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_by          varchar(64)    default ''                not null comment '更新者',
    update_time        datetime       default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted            int            default 0                 not null comment '逻辑删除',
    primary key (id)
) comment '活动表' row_format = DYNAMIC;

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    user_id     bigint(20) not null auto_increment comment '用户ID',
    dept_id     bigint(20) default null comment '部门ID',
    user_name   varchar(30) not null comment '用户账号',
    nick_name   varchar(30) not null comment '用户昵称',
    user_type   varchar(2)   default '00' comment '用户类型（00系统用户）',
    email       varchar(50)  default '' comment '用户邮箱',
    phonenumber varchar(11)  default '' comment '手机号码',
    sex         char(1)      default '0' comment '用户性别（0男 1女 2未知）',
    avatar      varchar(100) default '' comment '头像地址',
    password    varchar(100) default '' comment '密码',
    status      char(1)      default '0' comment '帐号状态（0正常 1停用）',
    del_flag    char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    login_ip    varchar(128) default '' comment '最后登录IP',
    login_date  datetime comment '最后登录时间',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into sys_user
values (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin',
        sysdate(), '', null, '管理员');
insert into sys_user
values (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '',
        '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin',
        sysdate(), '', null, '测试员');