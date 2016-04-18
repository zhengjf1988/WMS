/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : wms_10000

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2016-04-18 15:06:56
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_consumer
-- ----------------------------
INSERT INTO `t_consumer` VALUES ('1', 'wwwwww', 'qqqqqqq', '231', 'fdsafdsfds', '2016-04-17 19:21:57', '管理员', 'ffffffffffffffffff', '0');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(32) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '厂区二部', '旅客尽快好凉快凉快会凉快凉快黑手党海景房的设计师的粉红粉红加', '0', '0', null, '李四');
INSERT INTO `t_department` VALUES ('2', '生产部', 'vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', '1', '0', null, '李四');
INSERT INTO `t_department` VALUES ('3', '厂区一部', '这周尼福达赛扶的', '0', '0', null, '李四');
INSERT INTO `t_department` VALUES ('4', '质检部', '范德萨', '3', '0', null, '李四');
INSERT INTO `t_department` VALUES ('7', '销售部', 'u乳液荣与辱业务员网锐欧', '3', '0', '2016-04-11 21:39:19', '李四');
INSERT INTO `t_department` VALUES ('8', '市场部', 'v刹现在v刹现在v刹现在v刹', '1', '0', '2016-04-11 22:36:14', '李四');
INSERT INTO `t_department` VALUES ('9', '', '', '3', '0', '2016-04-14 17:40:24', '李四');
INSERT INTO `t_department` VALUES ('10', 'sasasas', 'sasas', '8', '0', '2016-04-14 17:42:53', '李四');
INSERT INTO `t_department` VALUES ('11', 'qqq', 'qqqq', '1', '0', '2016-04-17 18:39:34', '管理员');

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '测试公告', 'fdsahjfdshafdshafgdhsakgfdsghafgdskafdkjsajfdjh', '2016-04-11 12:32:48', '张三', '0');
INSERT INTO `t_notice` VALUES ('7', 'wwww', 'fdsahjfdshafdshafg', '2016-04-11 13:09:47', 'zzzzzz', '0');
INSERT INTO `t_notice` VALUES ('8', 'wwww', 'fdsahjfdshafdshafg', '2016-04-11 13:10:12', '李四', '0');
INSERT INTO `t_notice` VALUES ('9', 'test', null, '2016-04-11 13:12:08', '李四', '0');
INSERT INTO `t_notice` VALUES ('10', '放假通知', '我们要放假十天了', '2016-04-11 13:12:59', '李四', '0');
INSERT INTO `t_notice` VALUES ('11', '', '', '2016-04-11 00:00:00', '李四', '0');
INSERT INTO `t_notice` VALUES ('12', '', '', '2016-04-11 18:05:23', '李四', '0');
INSERT INTO `t_notice` VALUES ('13', 'cccccccc', 'qqqqqqqqqqqqqq', '2016-04-11 20:38:40', '李四', '0');
INSERT INTO `t_notice` VALUES ('14', 'wwwww', 'qqqqqqqqqqqqqqqqq', '2016-04-11 20:39:04', '李四', '0');
INSERT INTO `t_notice` VALUES ('15', 'ccccccccccccccccccc', 'ssssssssssssss', '2016-04-12 17:16:58', '李四', '0');
INSERT INTO `t_notice` VALUES ('16', 'qqqqqqqqqqqqq', 'qqqqqqwwwwwwwwwwwwwwwwwwwww', '2016-04-12 17:17:05', '李四', '0');
INSERT INTO `t_notice` VALUES ('17', 'qqqq', 'qqqq', '2016-04-17 18:39:17', '管理员', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pack
-- ----------------------------
INSERT INTO `t_pack` VALUES ('1', '包装1', '1', '2', '32444444444444444444444', null, null, '0');
INSERT INTO `t_pack` VALUES ('2', '鹅鹅鹅鹅鹅鹅鹅鹅鹅', '3', '无限制', 'vvvvvvvvvvvv', null, null, '0');
INSERT INTO `t_pack` VALUES ('3', 'qqqqqqqqqqqq', '3', '无限制', 'xxxx', null, null, '0');
INSERT INTO `t_pack` VALUES ('4', 'aaa', '3', '无限制', '4', '2016-04-17 18:40:55', '管理员', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_roles
-- ----------------------------
INSERT INTO `t_roles` VALUES ('1', '管理员', ';1;;8;;9;;2;;10;;11;;12;;3;;13;;14;;15;;4;;16;;17;;18;;5;;19;;20;;21;;22;;6;;23;;24;;25;;26;;27;;28;;7;;29;;33;;34;;35;;30;;31;;32;', '管理员', '2016-4-12 20:55:37', '李四', '0');
INSERT INTO `t_roles` VALUES ('2', '部门经理', ';1;8;', '这是一个添加测试', '2016-04-13 17:12:38', '李四', '0');
INSERT INTO `t_roles` VALUES ('3', '厂长', ';1;8;9;2;10;11;12;3;13;14;15;4;16;17;18', '添加测试', '2016-04-13 17:13:45', '李四', '0');
INSERT INTO `t_roles` VALUES ('5', '车间主任', ';1;;8;;9;;2;;10;;11;;12;;3;;13;;14;;15;', '车间主任车间主任车间主任车间主任', '2016-04-13 17:15:08', '李四', '0');
INSERT INTO `t_roles` VALUES ('6', 'admin', ';1;;8;;9;;2;;10;;11;;12;;3;;13;;14;;15;;4;;16;;17;;18;;5;;19;;20;;21;;22;;6;;23;;24;;25;;26;;27;;28;;7;;29;;33;;34;;35;;30;;31;;32;', 'admin', '2016-04-13 17:17:58', '李四', '0');
INSERT INTO `t_roles` VALUES ('7', 'test', ';7;;29;;35;', 'test', '2016-04-13 18:10:35', '李四', '0');
INSERT INTO `t_roles` VALUES ('8', 'qqq', ';1;;8;;9;', 'qqqq', '2016-04-17 18:39:48', '管理员', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_savetype
-- ----------------------------
INSERT INTO `t_savetype` VALUES ('1', '存储类型', '饭店和规范的快速咖啡客户的身份', null, null, '0');
INSERT INTO `t_savetype` VALUES ('2', 'wwwwwwwwww', 'ssssssssssssssss', null, null, '0');
INSERT INTO `t_savetype` VALUES ('3', 'qqq', 'qqqqq', '2016-04-17 18:40:38', '管理员', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '111111', '管理员', '2016-04-15 00:02:11', '李四', '的撒旦撒旦撒', '2', '2', '0');
INSERT INTO `t_user` VALUES ('7', 'test', '111111', 'test', '2016-04-17 18:40:15', '管理员', 'qqqqq', '1', '1', '0');
