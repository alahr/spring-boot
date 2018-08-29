/*
Navicat MySQL Data Transfer

Source Server         : sunyan
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : spring_boot

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2018-08-29 15:36:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `gender` char(1) DEFAULT NULL COMMENT '性别，1：男；2：女',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '孙悟空', '1999-09-09', '1', '花果山');
INSERT INTO `person` VALUES ('2', '猪八戒', '2000-01-01', '1', '高老庄');
INSERT INTO `person` VALUES ('3', '白骨精', '2002-02-02', '2', '山村');
INSERT INTO `person` VALUES ('4', '观世音', '1990-12-12', '2', '南海');
INSERT INTO `person` VALUES ('5', '如来', '1988-08-09', '1', '灵山');
