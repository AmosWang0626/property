# 此文件是所有SQL的备份,防止数据库误删,起备份作用.
# 请将最新的SQL脚本往备份进来

-- 综合管理模块 SQL

CREATE TABLE `MEMBER` (
  `MEMBER_ID` bigint(20) NOT NULL COMMENT '会员编号',
  `PHONE_NO` varchar(11) NOT NULL COMMENT '手机号',
  `NICK_NAME` varchar(64) NOT NULL COMMENT '昵称',
  `ID_NO` varchar(128) DEFAULT NULL COMMENT '身份证号',
  `REAL_NAME` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `GENDER` varchar(64) DEFAULT NULL COMMENT '用户性别',
  `AGE` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `MARITAL_STATUS` varchar(64) NOT NULL COMMENT '婚姻状况',
  `UPDATE_TIME` datetime NOT NULL COMMENT '修改时间',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `LOGIN_INFO` (
  `MEMBER_ID` bigint(20) NOT NULL,
  `SALT` varchar(64) NOT NULL COMMENT '密码盐',
  `PASSWORD` varchar(64) NOT NULL COMMENT '加密后的密码',
  `ERROR_COUNT` int(11) NOT NULL DEFAULT '0' COMMENT '连续输错密码次数',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登陆时间',
  PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录信息表';
