/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : device_ms

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-04-02 19:59:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `device_log`
-- ----------------------------
DROP TABLE IF EXISTS `device_log`;
CREATE TABLE `device_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `log_type` enum('NOMAL','ABNOMAL') DEFAULT 'NOMAL' COMMENT '日志类型：nomal正常   abnomal异常',
  `user_id` bigint(20) DEFAULT '0' COMMENT '操作者ID',
  `username` varchar(20) DEFAULT '' COMMENT '操作者',
  `operation` varchar(64) DEFAULT '' COMMENT '操作内容',
  `method_name` varchar(500) DEFAULT '' COMMENT '操作方法名',
  `request_method` enum('OPTIONS','HEAD','DELETE','PATCH','PUT','GET','POST') DEFAULT 'OPTIONS' COMMENT '请求方式',
  `request_param` varchar(500) DEFAULT '' COMMENT '请求参数',
  `remote_ip` varchar(32) DEFAULT '127.0.0.1' COMMENT '远端IP',
  `request_uri` varchar(1000) DEFAULT '' COMMENT '请求uri',
  `exception_code` varchar(32) DEFAULT '500' COMMENT '异常CODE',
  `exception_msg` varchar(5000) DEFAULT 'e' COMMENT '异常信息',
  `time_consuming` int(11) DEFAULT '0' COMMENT '请求耗时(毫秒）',
  `user_agent` varchar(300) DEFAULT '' COMMENT '请求者信息',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `deleted_at` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of device_log
-- ----------------------------

-- ----------------------------
-- Table structure for `device_repair_detail`
-- ----------------------------
DROP TABLE IF EXISTS `device_repair_detail`;
CREATE TABLE `device_repair_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `device_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '维修人员ID',
  `device_code` varchar(255) DEFAULT NULL COMMENT '设备CODE',
  `device_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `user_name` varchar(64) DEFAULT NULL COMMENT '维修人员名称',
  `created_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_repair_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `device_role`
-- ----------------------------
DROP TABLE IF EXISTS `device_role`;
CREATE TABLE `device_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL COMMENT '角色名称',
  `desc` varchar(1024) DEFAULT NULL COMMENT '角色描述',
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_role
-- ----------------------------
INSERT INTO `device_role` VALUES ('1', '测试组', '测试用的分组', '2019-03-31 00:22:10', null);

-- ----------------------------
-- Table structure for `device_user`
-- ----------------------------
DROP TABLE IF EXISTS `device_user`;
CREATE TABLE `device_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `gender` enum('MALE','FEMALE') DEFAULT 'MALE' COMMENT '性别',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(64) NOT NULL COMMENT '邮箱，登录账号（不能为空，唯一）',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` bigint(20) DEFAULT NULL COMMENT '角色',
  `created_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `deleted_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_user
-- ----------------------------

-- ----------------------------
-- Table structure for `device_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `device_user_role`;
CREATE TABLE `device_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `divice_detail`
-- ----------------------------
DROP TABLE IF EXISTS `divice_detail`;
CREATE TABLE `divice_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL COMMENT '设备编号',
  `name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `last_repair_at` datetime DEFAULT NULL COMMENT '最后一次维修时间',
  `dumped` enum('TRUE','FALSE') DEFAULT 'FALSE' COMMENT '是否报废',
  `buy_at` datetime DEFAULT NULL COMMENT '购买时间',
  `status` enum('NOMAL','DUMPED','LOST','REPAIRING') DEFAULT 'NOMAL',
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of divice_detail
-- ----------------------------
