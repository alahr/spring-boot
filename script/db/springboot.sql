/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-10-14 08:48:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for animal
-- ----------------------------
DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `type` varchar(50) DEFAULT NULL COMMENT '宠物类型',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `gender` char(1) DEFAULT NULL COMMENT '性别，1：男；2：女',
  `owner` varchar(200) DEFAULT NULL COMMENT '主人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of animal
-- ----------------------------
INSERT INTO `animal` VALUES ('1', 'Tom', 'Cat', '2019-03-20', '1', 'Dav');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `card` varchar(20) NOT NULL COMMENT '身份证号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `gender` char(1) DEFAULT NULL COMMENT '性别，1：男；2：女',
  `address` varchar(200) DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_person_card` (`card`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '1001', '孙悟空', '1999-09-09', '1', '花果山');
INSERT INTO `person` VALUES ('2', '1002', '猪八戒', '2000-01-01', '1', '高老庄');
INSERT INTO `person` VALUES ('3', '1003', '白骨精', '2002-02-02', '2', '山村');
INSERT INTO `person` VALUES ('4', '1004', '观世音', '1990-12-12', '2', '南海');
INSERT INTO `person` VALUES ('5', '1005', '如来', '1988-08-09', '1', '灵山');
INSERT INTO `person` VALUES ('6', '1006', '五天33333', '2019-05-12', '1', '敏捷333');
INSERT INTO `person` VALUES ('9', '1007', '唐僧1', '2019-05-12', '1', '陈家庄2');
