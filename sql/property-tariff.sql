-- 此文件是所有SQL的备份,防止数据库误删,起备份作用.
-- 请将最新的SQL脚本往备份进来.

-- -------------------------- 资费管理模块 SQL ------------------------------------------------


-- ----------------------------
-- Table structure for tariff_bill
-- ----------------------------
DROP TABLE IF EXISTS `tariff_bill`;
CREATE TABLE `tariff_bill` (
  `BILL_NO` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账单编号',
  `HOUSE_NO` varchar(32) NOT NULL COMMENT '户号',
  `MEMBER_ID` bigint(20) NOT NULL COMMENT '用户编号',
  `STANDARD_ID` bigint(20) NOT NULL COMMENT '资费标准编号',
  `BUSINESS` varchar(32) NOT NULL COMMENT '业务类型',
  `UNIT_PRICE` decimal(18,4) NOT NULL COMMENT '缴费单价(冗余字段)',
  `OVERDUE_RATE` decimal(18,4) NOT NULL COMMENT '逾期利率(冗余字段)',
  `USED_TOTAL` decimal(18,4) NOT NULL COMMENT '使用量',
  `BILL_AMOUNT` decimal(18,2) NOT NULL COMMENT '账单金额',
  `BILL_MONTH` varchar(32) NOT NULL COMMENT '账单月份',
  `BILL_STATUS` varchar(32) NOT NULL COMMENT '账单状态',
  `BILL_START_DATE` datetime NOT NULL COMMENT '账单起始时间',
  `BILL_END_DATE` datetime NOT NULL COMMENT '账单结束时间',
  `EXPAND` varchar(256) DEFAULT NULL COMMENT '拓展字段',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`BILL_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='缴费账单表';

-- ----------------------------
-- Table structure for tariff_bill_plan
-- ----------------------------
DROP TABLE IF EXISTS `tariff_bill_plan`;
CREATE TABLE `tariff_bill_plan` (
  `PLAN_NO` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '缴费计划编号',
  `BILL_NO` bigint(20) NOT NULL COMMENT '账单编号',
  `MEMBER_ID` bigint(20) NOT NULL COMMENT '用户编号',
  `REPAY_DATE` datetime NOT NULL COMMENT '应还款日期',
  `SETTLE_DATE` datetime NOT NULL COMMENT '结清日期',
  `OVERDUE_DAYS` int(6) NOT NULL COMMENT '逾期天数',
  `BILL_STATUS` varchar(32) NOT NULL COMMENT '账单状态',
  `BILL_AMOUNT` decimal(18,4) NOT NULL COMMENT '应缴纳本金',
  `LATE_CHARGE_AMT` decimal(18,4) NOT NULL COMMENT '应缴纳滞纳金',
  `BILL_AMOUNT_PAID` decimal(18,4) NOT NULL COMMENT '已缴纳本金',
  `LATE_CHARGE_AMT_PAID` decimal(18,4) NOT NULL COMMENT '已缴纳滞纳金',
  `BILL_AMOUNT_OFFER` decimal(18,4) NOT NULL COMMENT '优惠减免本金',
  `LATE_CHARGE_AMT_OFFER` decimal(18,4) NOT NULL COMMENT '优惠减免滞纳金',
  `EXPAND` varchar(256) DEFAULT NULL COMMENT '拓展字段',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`PLAN_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='缴费账单还款计划表';

-- ----------------------------
-- Table structure for tariff_company
-- ----------------------------
DROP TABLE IF EXISTS `tariff_company`;
CREATE TABLE `tariff_company` (
  `COMPANY_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司编号',
  `BUSINESS` varchar(32) NOT NULL COMMENT '业务类型',
  `NAME` varchar(64) NOT NULL COMMENT '公司名称',
  `ADDRESS` varchar(128) NOT NULL COMMENT '公司地址',
  `TELEPHONE` varchar(64) NOT NULL COMMENT '公司联系方式',
  `ORGANIZATION_CODE` varchar(10) DEFAULT NULL COMMENT '组织机构代码',
  `LEGAL_NAME` varchar(64) DEFAULT NULL COMMENT '企业法人名字',
  `ESTABLISH` varchar(64) DEFAULT NULL COMMENT '成立时间',
  `REGISTER_CAPITAL` varchar(64) DEFAULT NULL COMMENT '注册资金',
  `STATUS` tinyint(1) NOT NULL COMMENT '状态(1:正常;0:无效)',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30000 DEFAULT CHARSET=utf8 COMMENT='收费公司信息表';

-- ----------------------------
-- Table structure for tariff_company_bill
-- ----------------------------
DROP TABLE IF EXISTS `tariff_company_bill`;
CREATE TABLE `tariff_company_bill` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `COMPANY_ID` bigint(20) NOT NULL COMMENT '公司编号',
  `MEMBER_ID` bigint(20) NOT NULL COMMENT '用户编号',
  `PLAN_NO` bigint(20) NOT NULL COMMENT '缴费计划编号',
  `BUSINESS` varchar(32) NOT NULL COMMENT '业务类型',
  `PAYMENT_AMOUNT` decimal(18,2) NOT NULL COMMENT '交易金额',
  `PAYMENT_WAY` varchar(32) NOT NULL COMMENT '支付方式',
  `PAYMENT_STATUS` varchar(32) NOT NULL COMMENT '支付状态',
  `PAYMENT_DATE` datetime NOT NULL COMMENT '交易时间',
  `ERROR_CODE` varchar(256) DEFAULT NULL COMMENT '错误码',
  `ERROR_MESSAGE` varchar(256) DEFAULT NULL COMMENT '错误信息',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='收费公司账目表';

-- ----------------------------
-- Table structure for tariff_standard
-- ----------------------------
DROP TABLE IF EXISTS `tariff_standard`;
CREATE TABLE `tariff_standard` (
  `STANDARD_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '缴费标准编号',
  `BUSINESS` varchar(32) NOT NULL COMMENT '业务类型',
  `LEVEL` varchar(32) NOT NULL COMMENT '缴费标准等级',
  `UNIT_PRICE` decimal(18,4) NOT NULL COMMENT '缴费单价',
  `OVERDUE_RATE` decimal(18,4) NOT NULL COMMENT '逾期利率',
  `START_TIME` datetime NOT NULL COMMENT '缴费标准生效时间',
  `END_TIME` datetime NOT NULL COMMENT '缴费标准失效时间',
  `STATUS` tinyint(1) NOT NULL COMMENT '状态(1:正常;0:无效)',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`STANDARD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50000 DEFAULT CHARSET=utf8 COMMENT='缴费标准表';
