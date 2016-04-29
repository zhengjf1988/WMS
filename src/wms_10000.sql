/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : wms_10000

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2016-04-29 13:39:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_ccqxgl
-- ----------------------------
DROP TABLE IF EXISTS `t_ccqxgl`;
CREATE TABLE `t_ccqxgl` (
  `ccid` int(11) NOT NULL AUTO_INCREMENT COMMENT '存储期限id',
  `ccname` varchar(32) DEFAULT NULL,
  `kwmeno` varchar(32) DEFAULT NULL,
  `issx` int(11) DEFAULT NULL,
  `creDate` datetime DEFAULT NULL,
  `inputman` varchar(32) DEFAULT NULL,
  `sxqx` varchar(20) DEFAULT NULL,
  `useTag` int(1) DEFAULT NULL,
  PRIMARY KEY (`ccid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ccqxgl
-- ----------------------------
INSERT INTO `t_ccqxgl` VALUES ('1', '1', '2', '1', '2016-04-14 00:00:00', '老马', '2016-05-14 00:00:00', '1');
INSERT INTO `t_ccqxgl` VALUES ('2', '222', '222', '0', '2016-04-14 20:22:42', '111', null, '0');
INSERT INTO `t_ccqxgl` VALUES ('3', '2', '3', '0', '2016-04-15 22:36:18', '111', '2016-04-16 01:43:56', '1');

-- ----------------------------
-- Table structure for t_consumer
-- ----------------------------
DROP TABLE IF EXISTS `t_consumer`;
CREATE TABLE `t_consumer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consumerName` varchar(32) DEFAULT NULL,
  `linkman` varchar(32) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_consumer
-- ----------------------------
INSERT INTO `t_consumer` VALUES ('1', '客户信息1', 'qqqqqqq', '231', 'fdsafdsfds', '2016-04-17 19:21:57', '管理员', 'xxx', '0');
INSERT INTO `t_consumer` VALUES ('2', 'aaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaaa', '2016-04-19 23:51:45', '管理员', 'zzzzzzz', '1');
INSERT INTO `t_consumer` VALUES ('3', 'xxxxx', 'xxxxxxxxxxx', 'xxxxxxxxxxxx', 'xxxxxxxxxxxxx', '2016-04-19 23:51:52', '管理员', 'xxxxxxxxxxxxxxxx', '0');
INSERT INTO `t_consumer` VALUES ('4', 'aaaaaaaa', 'aaaaaaa', 'sss', 'sssssssssss', '2016-04-19 23:51:58', '管理员', 'ssssssssssssss', '0');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(32) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '厂区二部', '0', '旅客尽快好凉快凉快会凉快凉快黑手党海景房的设计师的粉红粉红加', null, '李四', '0');
INSERT INTO `t_department` VALUES ('2', '生产部', '1', 'vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', null, '李四', '1');
INSERT INTO `t_department` VALUES ('3', '厂区一部', '0', '这周尼福达赛扶的', null, '李四', '0');
INSERT INTO `t_department` VALUES ('4', '质检部', '3', '范德萨', null, '李四', '0');
INSERT INTO `t_department` VALUES ('7', '销售部', '3', 'u乳液荣与辱业务员网锐欧', '2016-04-11 21:39:19', '李四', '0');
INSERT INTO `t_department` VALUES ('8', '市场部', '1', 'v刹现在v刹现在v刹现在v刹', '2016-04-11 22:36:14', '李四', '0');
INSERT INTO `t_department` VALUES ('9', '', '3', '', '2016-04-14 17:40:24', '李四', '1');
INSERT INTO `t_department` VALUES ('10', 'KKKKKKKKKKKK', '4', 'KKKKKKKKKKK', '2016-04-14 17:42:53', '李四', '0');
INSERT INTO `t_department` VALUES ('11', 'qqq', '1', 'qqqq', '2016-04-17 18:39:34', '管理员', '0');
INSERT INTO `t_department` VALUES ('12', 'zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz', '0', 'zzzzzzzzzzzzzzzzzzzzzzz', '2016-04-19 21:42:00', '管理员', '1');
INSERT INTO `t_department` VALUES ('13', 'cccccccccc', '0', 'ccccccccccccc', '2016-04-19 22:17:31', '管理员', '0');
INSERT INTO `t_department` VALUES ('14', 'wwwwww', '10', 'vvvvvvvvvvv', '2016-04-28 13:57:15', '管理员', '0');

-- ----------------------------
-- Table structure for t_kwlxgl
-- ----------------------------
DROP TABLE IF EXISTS `t_kwlxgl`;
CREATE TABLE `t_kwlxgl` (
  `kwid` int(40) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `kwname` varchar(30) DEFAULT NULL COMMENT '类型名称',
  `kwmeno` varchar(300) DEFAULT NULL COMMENT '类型说明',
  `creDate` date DEFAULT NULL COMMENT '创建时间',
  `inputman` int(40) DEFAULT NULL COMMENT '创建人',
  `iddelete` int(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`kwid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kwlxgl
-- ----------------------------
INSERT INTO `t_kwlxgl` VALUES ('1', '是的1', '阿斯达 ', '2016-04-16', '111', '0');
INSERT INTO `t_kwlxgl` VALUES ('2', '问问', '大师傅师傅的说法', '2016-04-16', '111', '1');
INSERT INTO `t_kwlxgl` VALUES ('3', '哈哈', '哈哈哈哈哈哈哈', '2016-04-16', '111', '0');

-- ----------------------------
-- Table structure for t_kwxxgl
-- ----------------------------
DROP TABLE IF EXISTS `t_kwxxgl`;
CREATE TABLE `t_kwxxgl` (
  `kwid` int(30) NOT NULL AUTO_INCREMENT,
  `kwname` varchar(30) DEFAULT NULL,
  `kwtype` varchar(30) DEFAULT NULL,
  `cctype` varchar(30) DEFAULT NULL,
  `kwrl` double(30,0) DEFAULT NULL,
  `kwbm` bigint(13) unsigned zerofill DEFAULT '0000000000000',
  `kwaddress` varchar(50) DEFAULT NULL,
  `creDate` date DEFAULT NULL,
  `inputman` varchar(30) DEFAULT NULL,
  `useTag` int(1) DEFAULT '1',
  PRIMARY KEY (`kwid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kwxxgl
-- ----------------------------
INSERT INTO `t_kwxxgl` VALUES ('1', '库位1', '3', '1', '500', '0000000000000', '上海普陀', '2016-04-15', '111', '0');
INSERT INTO `t_kwxxgl` VALUES ('2', '库位2', '1', '1', '1000', '0000000000000', '上海长宁', '2016-04-15', '111', '0');
INSERT INTO `t_kwxxgl` VALUES ('3', '库位3', '1', '2', '1222', '0000000000000', '上海徐汇', '2016-04-15', '111', '0');
INSERT INTO `t_kwxxgl` VALUES ('4', '库位11', '3', '2', '1212', '0000000000000', '上海虹桥', '2016-04-16', '111', '1');

-- ----------------------------
-- Table structure for t_ljdjgl
-- ----------------------------
DROP TABLE IF EXISTS `t_ljdjgl`;
CREATE TABLE `t_ljdjgl` (
  `djid` int(40) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `djname` varchar(30) DEFAULT NULL COMMENT '类型名称',
  `djmeno` varchar(300) DEFAULT NULL COMMENT '类型说明',
  `creDate` date DEFAULT NULL COMMENT '创建时间',
  `inputman` int(40) DEFAULT NULL COMMENT '创建人',
  `iddelete` int(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`djid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ljdjgl
-- ----------------------------
INSERT INTO `t_ljdjgl` VALUES ('1', '32423432423', '热热我惹我任务', '2016-04-16', '111', '1');
INSERT INTO `t_ljdjgl` VALUES ('2', '34324', '34324324', '2016-04-16', '111', '0');

-- ----------------------------
-- Table structure for t_ljlxgl
-- ----------------------------
DROP TABLE IF EXISTS `t_ljlxgl`;
CREATE TABLE `t_ljlxgl` (
  `lxid` int(40) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `lxname` varchar(30) DEFAULT NULL COMMENT '类型名称',
  `lxmeno` varchar(300) DEFAULT NULL COMMENT '类型说明',
  `creDate` date DEFAULT NULL COMMENT '创建时间',
  `inputman` int(40) DEFAULT NULL COMMENT '创建人',
  `iddelete` int(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`lxid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ljlxgl
-- ----------------------------
INSERT INTO `t_ljlxgl` VALUES ('1', '萨达是', '阿斯达sdfsdfsdf', '2016-04-14', '12', '0');
INSERT INTO `t_ljlxgl` VALUES ('3', 'sdf ', 'sdf ', '2016-04-14', '111', '0');
INSERT INTO `t_ljlxgl` VALUES ('4', 'asd', 'asd', '2016-04-14', '0', '1');
INSERT INTO `t_ljlxgl` VALUES ('5', 'asdasd', 'asdasdasd', '2016-04-14', '0', '1');
INSERT INTO `t_ljlxgl` VALUES ('6', 'asd', 'asd', '2016-04-14', '111', '0');

-- ----------------------------
-- Table structure for t_ljxxgl
-- ----------------------------
DROP TABLE IF EXISTS `t_ljxxgl`;
CREATE TABLE `t_ljxxgl` (
  `ljid` int(40) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `ljname` varchar(30) DEFAULT NULL COMMENT '零件名称',
  `cctype` varchar(30) DEFAULT NULL COMMENT '存储类型',
  `sjlj` varchar(30) DEFAULT NULL COMMENT '上级零件',
  `gjsl` int(30) DEFAULT NULL COMMENT '构件数量',
  `creDate` date DEFAULT NULL COMMENT '创建时间',
  `inputman` varchar(40) DEFAULT NULL COMMENT '创建人',
  `useTag` int(1) unsigned zerofill DEFAULT '1',
  `ljbm` varchar(30) DEFAULT NULL COMMENT '零件编码',
  `fk_khId` int(11) DEFAULT NULL COMMENT '客户id',
  PRIMARY KEY (`ljid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ljxxgl
-- ----------------------------
INSERT INTO `t_ljxxgl` VALUES ('8', '轴承', '问问阿达', null, '123112123', '2016-04-19', '111', '1', '301', '1');
INSERT INTO `t_ljxxgl` VALUES ('10', '刹车片', 'aaa', null, '1111', '2016-04-23', '1', '1', '111', '1');
INSERT INTO `t_ljxxgl` VALUES ('11', '千斤顶', '111', null, '111', '2016-04-26', '111', '1', '111', '1');

-- ----------------------------
-- Table structure for t_menubt
-- ----------------------------
DROP TABLE IF EXISTS `t_menubt`;
CREATE TABLE `t_menubt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menubt
-- ----------------------------
INSERT INTO `t_menubt` VALUES ('1', '生产管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('2', '入库管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('3', '出库管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('4', '库存管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('5', '信息管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('6', '基础管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('7', '系统管理', '1', '0', '0');
INSERT INTO `t_menubt` VALUES ('8', '客户生产计划', '2', '1', '0');
INSERT INTO `t_menubt` VALUES ('9', '内部生产计划', '2', '1', '0');
INSERT INTO `t_menubt` VALUES ('10', '收货管理', '2', '2', '0');
INSERT INTO `t_menubt` VALUES ('11', '生产退料', '2', '2', '0');
INSERT INTO `t_menubt` VALUES ('12', '成品入库', '2', '2', '0');
INSERT INTO `t_menubt` VALUES ('13', '退货管理', '2', '3', '0');
INSERT INTO `t_menubt` VALUES ('14', '生产发料', '2', '3', '0');
INSERT INTO `t_menubt` VALUES ('15', '成品出库', '2', '3', '0');
INSERT INTO `t_menubt` VALUES ('16', '移库管理', '2', '4', '0');
INSERT INTO `t_menubt` VALUES ('17', '库存盘点', '2', '4', '0');
INSERT INTO `t_menubt` VALUES ('18', '库存明细', '2', '4', '0');
INSERT INTO `t_menubt` VALUES ('19', '库位信息管理', '2', '5', '0');
INSERT INTO `t_menubt` VALUES ('20', '客户信息管理', '2', '5', '0');
INSERT INTO `t_menubt` VALUES ('21', '零件信息管理', '2', '5', '0');
INSERT INTO `t_menubt` VALUES ('22', '员工信息管理', '2', '5', '0');
INSERT INTO `t_menubt` VALUES ('23', '零件类型管理', '2', '6', '0');
INSERT INTO `t_menubt` VALUES ('24', '零件等级管理', '2', '6', '0');
INSERT INTO `t_menubt` VALUES ('25', '库位类型管理', '2', '6', '0');
INSERT INTO `t_menubt` VALUES ('26', '存储类型管理', '2', '6', '0');
INSERT INTO `t_menubt` VALUES ('27', '存储期限管理', '2', '6', '0');
INSERT INTO `t_menubt` VALUES ('28', '包装信息管理', '2', '6', '0');
INSERT INTO `t_menubt` VALUES ('29', '公告管理', '2', '7', '0');
INSERT INTO `t_menubt` VALUES ('30', '账户管理', '2', '7', '0');
INSERT INTO `t_menubt` VALUES ('31', '角色权限管理', '2', '7', '0');
INSERT INTO `t_menubt` VALUES ('32', '部门管理', '2', '7', '0');
INSERT INTO `t_menubt` VALUES ('33', '添加公告', '3', '29', '0');
INSERT INTO `t_menubt` VALUES ('34', '修改公告', '3', '29', '0');
INSERT INTO `t_menubt` VALUES ('35', '删除公告', '3', '29', '0');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `creatTime` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '测试公告', 'fdsahjfdshafdshafgdhsakgfdsghafgdskafdkjsajfdjh', '2016-04-11 12:32:48', '张三', '0');
INSERT INTO `t_notice` VALUES ('7', 'wwww', 'fdsahjfdshafdshafg', '2016-04-11 13:09:47', 'zzzzzz', '1');
INSERT INTO `t_notice` VALUES ('8', 'wwww', 'fdsahjfdshafdshafg', '2016-04-11 13:10:12', '李四', '1');
INSERT INTO `t_notice` VALUES ('9', 'test', null, '2016-04-10 13:12:08', '李四', '1');
INSERT INTO `t_notice` VALUES ('10', '放假通知', '我们要放假十天了ccccccccccccc', '2016-04-10 13:12:59', '李四', '0');
INSERT INTO `t_notice` VALUES ('11', 'xxxxx', 'sssxcxcxvcx', '2016-04-11 00:00:00', '李四', '0');
INSERT INTO `t_notice` VALUES ('12', '', '', '2016-04-11 18:05:23', '李四', '1');
INSERT INTO `t_notice` VALUES ('13', 'cccccccc', 'qqqqqqqqqqqqqq', '2016-04-11 20:38:40', '李四', '0');
INSERT INTO `t_notice` VALUES ('14', 'wwwww', 'qqqqqqqqqqqqqqqqq', '2016-04-11 20:39:04', '李四', '0');
INSERT INTO `t_notice` VALUES ('15', 'ccccccccccccccccccc', 'ssssssssssssss', '2016-04-12 17:16:58', '李四', '0');
INSERT INTO `t_notice` VALUES ('16', 'qqqqqqqqqqqqq', 'qqqqqqwwwwwwwwwwwwwwwwwwwww', '2016-04-12 17:17:05', '李四', '0');
INSERT INTO `t_notice` VALUES ('17', 'qqqq', 'qqqq', '2016-04-17 18:39:17', '管理员', '0');
INSERT INTO `t_notice` VALUES ('18', 'ssssss', 'cccccccc', '2016-04-18 19:49:29', '管理员', '0');
INSERT INTO `t_notice` VALUES ('19', 'rrrr', 'ttttttttttttt', '2016-04-18 23:08:50', '管理员', '0');

-- ----------------------------
-- Table structure for t_pack
-- ----------------------------
DROP TABLE IF EXISTS `t_pack`;
CREATE TABLE `t_pack` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `packName` varchar(32) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `bulk` varchar(32) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pack
-- ----------------------------
INSERT INTO `t_pack` VALUES ('1', '包装1', '1', '2', '32444444444444444444444', null, null, '0');
INSERT INTO `t_pack` VALUES ('2', '鹅鹅鹅鹅鹅鹅鹅鹅鹅', '3', '无限制', 'vvvvvvvvvvvv', null, null, '0');
INSERT INTO `t_pack` VALUES ('3', 'qqqqqqqqqqqq', '3', '无限制', 'xxxx', null, null, '0');
INSERT INTO `t_pack` VALUES ('4', 'aaa', '3', '无限制', '4', '2016-04-17 18:40:55', '管理员', '0');
INSERT INTO `t_pack` VALUES ('5', '22', '333', '444', '4444', '2016-04-18 19:50:23', '管理员', '1');
INSERT INTO `t_pack` VALUES ('6', 'aaaa', '3333', '222', 'xxxxx', '2016-04-19 23:38:40', '管理员', '1');
INSERT INTO `t_pack` VALUES ('7', 'wwwww', '3', '4', 'ssssssssss', '2016-04-19 23:50:55', '管理员', '0');

-- ----------------------------
-- Table structure for t_parttype
-- ----------------------------
DROP TABLE IF EXISTS `t_parttype`;
CREATE TABLE `t_parttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_parttype
-- ----------------------------
INSERT INTO `t_parttype` VALUES ('1', '零件1', '哇哇哇哇哇哇哇哇哇哇哇哇哇', null, null, '0');
INSERT INTO `t_parttype` VALUES ('2', 'qqqqq', 'qqqqq', '2016-04-17 18:40:31', '管理员', '0');

-- ----------------------------
-- Table structure for t_receive
-- ----------------------------
DROP TABLE IF EXISTS `t_receive`;
CREATE TABLE `t_receive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_ljID` int(11) DEFAULT NULL COMMENT '零件外键',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `fk_bzID` int(11) DEFAULT NULL COMMENT '包装类型外键',
  `thDate` varchar(32) DEFAULT NULL COMMENT '提货时间',
  `thMan` varchar(255) DEFAULT NULL COMMENT '提货人',
  `thCar` varchar(255) DEFAULT NULL COMMENT '提货车辆',
  `realCount` int(11) DEFAULT NULL COMMENT '实际数量',
  `status` int(1) DEFAULT NULL COMMENT '0:删除 1：提货 2：验货 3：分库 4：入库跟踪 5：入库完成',
  `link_id` int(11) DEFAULT NULL COMMENT '补单时关联的提货Id',
  `bd_date` varchar(32) DEFAULT NULL COMMENT '补单时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_receive
-- ----------------------------
INSERT INTO `t_receive` VALUES ('1', '10', '2001', '4', '2016-04-21', '张三;李四', '沪A7896;鄂A3197', '3105', '3', '0', null);
INSERT INTO `t_receive` VALUES ('2', '10', '400', '1', '2016-04-15', '张三;李四', '沪A7896;鄂A3197', '750', '3', '0', null);
INSERT INTO `t_receive` VALUES ('3', '10', '110', '1', '2016-04-08', '周瑾', '沪D213312', '110', '3', '0', null);
INSERT INTO `t_receive` VALUES ('4', '10', '22220', '1', '2016-04-23', null, null, '0', '0', '0', null);
INSERT INTO `t_receive` VALUES ('5', '8', '222', '2', '2016-04-25', '马凯', '沪CE9826', '400', '4', '0', null);
INSERT INTO `t_receive` VALUES ('6', '8', '11111', '3', '2016-04-25', '理想', '黑A1233', '10', '3', '0', null);
INSERT INTO `t_receive` VALUES ('7', '10', '432', '7', '2016-04-25', '王五', '沪A7896;鄂A3197', '33', '2', '0', null);
INSERT INTO `t_receive` VALUES ('15', '10', '224', '3', '2016-04-26', null, null, '0', '1', null, null);
INSERT INTO `t_receive` VALUES ('16', '10', '22', '7', '2016-04-26', null, null, '0', '1', null, null);
INSERT INTO `t_receive` VALUES ('17', '11', '500', '1', '2016-04-26', '王亮', '相B5679', '700', '2', null, null);
INSERT INTO `t_receive` VALUES ('19', '8', '200', '1', '2016-04-22', null, null, '0', '1', '5', '2016-04-26');

-- ----------------------------
-- Table structure for t_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE `t_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(32) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_roles
-- ----------------------------
INSERT INTO `t_roles` VALUES ('1', '管理员', ';1;;8;;9;;2;;10;;11;;12;;3;;13;;14;;15;;4;;16;;17;;18;;5;;19;;20;;21;;22;;6;;23;;24;;25;;26;;27;;28;;7;;29;;33;;34;;35;;30;;31;;32;', '管理员', '2016-4-12 20:55:37', '李四', '0');
INSERT INTO `t_roles` VALUES ('2', '部门经理', ';1;8;', '这是一个添加测试', '2016-04-13 17:12:38', '李四', '0');
INSERT INTO `t_roles` VALUES ('3', '厂长', ';1;8;9;2;10;11;12;3;13;14;15;4;16;17;18', '添加测试', '2016-04-13 17:13:45', '李四', '0');
INSERT INTO `t_roles` VALUES ('5', '车间主任', ';1;;8;;9;;2;;10;;11;;12;;3;;13;;14;;15;', '车间主任车间主任车间主任车间主任', '2016-04-13 17:15:08', '李四', '0');
INSERT INTO `t_roles` VALUES ('6', 'admin', ';1;;8;;9;;2;;10;;11;;12;;3;;13;;14;;15;;4;;16;;17;;18;;5;;19;;20;;21;;22;;6;;23;;24;;25;;26;;27;;28;;7;;29;;33;;34;;35;;30;;31;;32;', 'admin', '2016-04-13 17:17:58', '李四', '0');
INSERT INTO `t_roles` VALUES ('7', 'test', ';7;;29;;35;', 'test', '2016-04-13 18:10:35', '李四', '0');
INSERT INTO `t_roles` VALUES ('8', 'qqq', ';1;;8;;9;', 'qqqq', '2016-04-17 18:39:48', '管理员', '1');
INSERT INTO `t_roles` VALUES ('9', 'zzzzz', ';1;;8;;9;', 'zzzzzzzzzzz', '2016-04-19 21:42:37', '管理员', '1');

-- ----------------------------
-- Table structure for t_savetype
-- ----------------------------
DROP TABLE IF EXISTS `t_savetype`;
CREATE TABLE `t_savetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saveType` varchar(32) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_savetype
-- ----------------------------
INSERT INTO `t_savetype` VALUES ('1', '存储类型', '饭店和规范的快速咖啡客户的身份', null, null, '0');
INSERT INTO `t_savetype` VALUES ('2', 'wwwwwwwwww', 'ssssssssssssssss', null, null, '1');
INSERT INTO `t_savetype` VALUES ('3', 'xxxxx', 'xxxxx', '2016-04-17 18:40:38', '管理员', '0');
INSERT INTO `t_savetype` VALUES ('4', 'cccccccccccccc', 'ccccccccccccccccc', '2016-04-19 23:38:14', '管理员', '1');
INSERT INTO `t_savetype` VALUES ('5', 'ssssssss', 'xxxx', '2016-04-19 23:51:22', '管理员', '0');

-- ----------------------------
-- Table structure for t_selfplan
-- ----------------------------
DROP TABLE IF EXISTS `t_selfplan`;
CREATE TABLE `t_selfplan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_khId` int(11) DEFAULT NULL COMMENT '客户外键ID',
  `fk_ljId` int(11) DEFAULT NULL COMMENT '零件外键ID',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `xqDate` varchar(16) DEFAULT NULL COMMENT '需求时间',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_selfplan
-- ----------------------------
INSERT INTO `t_selfplan` VALUES ('1', '1', '10', '5000', '2016-05-05', '0');

-- ----------------------------
-- Table structure for t_tenant
-- ----------------------------
DROP TABLE IF EXISTS `t_tenant`;
CREATE TABLE `t_tenant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenantName` varchar(255) DEFAULT NULL,
  `tenantCode` varchar(255) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `lastTime` datetime DEFAULT NULL,
  `icoImg` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tenant
-- ----------------------------

-- ----------------------------
-- Table structure for t_txm
-- ----------------------------
DROP TABLE IF EXISTS `t_txm`;
CREATE TABLE `t_txm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `txm` varchar(32) DEFAULT NULL COMMENT '条形码',
  `realCount` varchar(32) DEFAULT NULL COMMENT '实际数量',
  `fk_receId` int(11) DEFAULT NULL COMMENT '提货信息的外键',
  `fk_kwTypeId` int(11) DEFAULT NULL COMMENT '库位类型Id',
  `fk_kwID` int(11) DEFAULT NULL COMMENT '库位Id',
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_txm
-- ----------------------------
INSERT INTO `t_txm` VALUES ('4', '130164759931', '200', '5', '3', '1', '0');
INSERT INTO `t_txm` VALUES ('10', '100692372053', '11', '7', null, null, '0');
INSERT INTO `t_txm` VALUES ('11', '169398564320', '22', '7', null, null, '0');
INSERT INTO `t_txm` VALUES ('12', '344662105142', '550', '2', null, null, '0');
INSERT INTO `t_txm` VALUES ('13', '468849453426', '1002', '1', null, null, '0');
INSERT INTO `t_txm` VALUES ('14', '176169496319', '2002', '1', null, null, '0');
INSERT INTO `t_txm` VALUES ('15', '105103596904', '101', '1', null, null, '0');
INSERT INTO `t_txm` VALUES ('16', '283919892728', '200', '2', null, null, '0');
INSERT INTO `t_txm` VALUES ('17', '465514936270', '200', '5', '1', '2', '0');
INSERT INTO `t_txm` VALUES ('19', '263818862420', '10', '3', null, null, '0');
INSERT INTO `t_txm` VALUES ('20', '328185942962', '100', '3', null, null, '0');
INSERT INTO `t_txm` VALUES ('21', '451741808234', '10', '6', null, null, '0');
INSERT INTO `t_txm` VALUES ('22', '176935494105', '30', '8', null, null, '0');
INSERT INTO `t_txm` VALUES ('23', '246823894267', '500', '8', null, null, '0');
INSERT INTO `t_txm` VALUES ('24', '29627276316', '300', '17', null, null, '0');
INSERT INTO `t_txm` VALUES ('25', '200038992126', '300', '17', null, null, '0');
INSERT INTO `t_txm` VALUES ('26', '273411841706', '100', '17', null, null, '0');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `psw` varchar(32) DEFAULT NULL,
  `realName` varchar(32) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `fk_departmentId` int(11) DEFAULT NULL,
  `fk_roleId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '111111', '管理员', '2016-04-15 00:02:11', '李四', '的撒旦撒旦撒ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc', '2', '2', '0');
INSERT INTO `t_user` VALUES ('7', 'test', '111111', 'test', '2016-04-17 18:40:15', '管理员', 'qqqqq', '3', '1', '0');
INSERT INTO `t_user` VALUES ('8', 'aaa', '222222', 'xxxxx', '2016-04-19 13:35:57', '管理员', '1111111112222', '2', '2', '1');
INSERT INTO `t_user` VALUES ('9', 'aaaaaaaaaaaaaaaaaaaaaaaa', 'aaaaaa', 'aaaaaaaaaaaaaaaaaaa', '2016-04-19 16:27:35', '管理员', 'aaaaaaaaaaaaaaaaaaaaaa', '3', '2', '1');
INSERT INTO `t_user` VALUES ('10', 'aaa', 'aaaaaa', 'aaa', '2016-04-26 22:26:53', '管理员', 'aaaaaaa', '4', '3', '0');
INSERT INTO `t_user` VALUES ('11', 'vvv', 'vvvvvv', 'vvv', '2016-04-26 22:28:15', '管理员', '', '7', '5', '0');

-- ----------------------------
-- Table structure for t_ygxxgl
-- ----------------------------
DROP TABLE IF EXISTS `t_ygxxgl`;
CREATE TABLE `t_ygxxgl` (
  `ygid` int(30) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ygbh` varchar(30) DEFAULT NULL COMMENT '员工编号',
  `ygxm` varchar(30) DEFAULT NULL COMMENT '员工姓名',
  `zwmc` varchar(30) DEFAULT NULL COMMENT '职位名称',
  `bmmc` varchar(30) DEFAULT NULL COMMENT '部门名称',
  `lxfs` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `sxnl` varchar(30) DEFAULT NULL COMMENT '筛选能力',
  `creDate` date DEFAULT NULL COMMENT '创建日期',
  `inputman` varchar(30) DEFAULT NULL COMMENT '创建人',
  `useTag` int(1) DEFAULT '1' COMMENT '是否可用',
  `photoAddr` varchar(300) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`ygid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ygxxgl
-- ----------------------------
INSERT INTO `t_ygxxgl` VALUES ('1', null, null, null, null, null, null, null, '111', '0', null);
INSERT INTO `t_ygxxgl` VALUES ('2', null, null, null, null, null, null, null, '111', '0', null);
INSERT INTO `t_ygxxgl` VALUES ('3', 'ewrew', 'ewrew', 'erew', 'erew', 'erew', 'erwe', null, '111', '0', null);
INSERT INTO `t_ygxxgl` VALUES ('4', 'zxcsdasdasdasdasdasdasd', 'dasdas', 'asdasd', 'asdasd', 'asdasd', 'dasdas', null, '111', '1', null);
INSERT INTO `t_ygxxgl` VALUES ('5', 'zxcsdsdfsdfasdasdas', 'dasdasdfdasd', 'asdasd', 'asdasd', 'asdasd', 'dasdas', null, '111', '1', null);
INSERT INTO `t_ygxxgl` VALUES ('6', 'zxcsd', 'dasdas', 'asdasd', 'asdasdasdasd', 'asdasd', 'dasdas', null, '111', '0', null);
INSERT INTO `t_ygxxgl` VALUES ('7', 'asdasd', 'adasd', 'asdasd', 'asd', 'asd', 'asd', null, '111', '1', null);
INSERT INTO `t_ygxxgl` VALUES ('8', 'asdas', 'asd', 'asdas', 'asd', 'asd', '232123', null, '111', '1', null);
INSERT INTO `t_ygxxgl` VALUES ('9', '43543', 'ertret', 'dftgdg', 'dfgcxvc', 'cvbvcbvc', 'vcbvcbcvb', null, '111', '1', '841f9a3d2cf9dce5-745c7e53713bc853-ecc9f6aabf548492ce0de15e9ad1f45e.jpg');
INSERT INTO `t_ygxxgl` VALUES ('10', 'sdasd', 'asdasd', 'asd', 'asd', 'asd', 'asd', null, '111', '1', '1461170576931.jpg');
