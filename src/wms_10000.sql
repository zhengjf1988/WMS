/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : wms_10000

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2016-04-13 00:50:57
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '厂区二部', '旅客尽快好凉快凉快会凉快凉快黑手党海景房的设计师的粉红粉红加', '0', '0', null, '李四');
INSERT INTO `t_department` VALUES ('2', '生产部', 'vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', '1', '0', null, '李四');
INSERT INTO `t_department` VALUES ('3', '厂区一部', '这周尼福达赛扶的', '0', '0', null, '李四');
INSERT INTO `t_department` VALUES ('4', '质检部', '范德萨', '3', '0', null, '李四');
INSERT INTO `t_department` VALUES ('7', '销售部', 'u乳液荣与辱业务员网锐欧', '3', '0', '2016-04-11 21:39:19', '李四');
INSERT INTO `t_department` VALUES ('8', '市场部', 'v刹现在v刹现在v刹现在v刹', '1', '0', '2016-04-11 22:36:14', '李四');

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
  `creatTime` datetime DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_roles
-- ----------------------------
INSERT INTO `t_roles` VALUES ('1', '管理员', '1;2;3;4;5;6;7;', '管理员', '2016-4-12 20:55:37', '李四', '0');

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
  `creatDate` varchar(32) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `fk_departmentId` int(11) DEFAULT NULL,
  `fk_roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
