/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : device_ms

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-04-06 19:50:36
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
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of device_log
-- ----------------------------

-- ----------------------------
-- Table structure for `device_menu`
-- ----------------------------
DROP TABLE IF EXISTS `device_menu`;
CREATE TABLE `device_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(64) DEFAULT NULL COMMENT '菜单CODE',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `style` varchar(255) DEFAULT NULL COMMENT '菜单样式',
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of device_menu
-- ----------------------------
INSERT INTO `device_menu` VALUES ('1', '办公设备管理系统', null, '/index', 'menu-icon fa fa-laptop', '2019-04-06 14:53:25', null);
INSERT INTO `device_menu` VALUES ('2', '正常设备', null, '/device/list?status=NOMAL', 'menu-icon fa fa-cogs', '2019-04-06 14:27:33', null);
INSERT INTO `device_menu` VALUES ('3', '待维修设备', null, '/device/list?status=REPAIRING', 'menu-icon fa fa-cogs', '2019-04-06 14:28:02', null);
INSERT INTO `device_menu` VALUES ('4', '报废设备', null, '/device/list?status=DUMPED', 'menu-icon fa fa-warning', '2019-04-06 14:28:24', null);
INSERT INTO `device_menu` VALUES ('5', '报失设备', null, '/device/list?status=LOST', 'menu-icon fa fa-ban', '2019-04-06 14:28:45', null);
INSERT INTO `device_menu` VALUES ('6', '设备采购', null, '/device/addPage', 'menu-icon fa fa-cog', '2019-04-06 14:29:09', null);
INSERT INTO `device_menu` VALUES ('7', '维修记录', null, '/device/repairRecord', 'menu-icon fa fa-wrench', '2019-04-06 14:29:28', null);
INSERT INTO `device_menu` VALUES ('8', '用户管理', null, '/user/list', 'menu-icon fa fa-user', '2019-04-06 14:29:46', null);
INSERT INTO `device_menu` VALUES ('9', '日志管理', null, '/opLog/list', 'menu-icon fa fa-book', '2019-04-06 14:30:12', null);
INSERT INTO `device_menu` VALUES ('10', '权限管理', null, '/roleMenu/listPage', 'menu-icon fa fa-envelope', '2019-04-06 14:30:33', null);
INSERT INTO `device_menu` VALUES ('11', '个人信息', null, '/user/myInfo', 'menu-icon fa fa-cog', '2019-04-06 14:30:56', null);

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
  `status` enum('REPAIRED','UNREPAIR') DEFAULT 'UNREPAIR',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_repair_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `device_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `device_role_menu`;
CREATE TABLE `device_role_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(64) DEFAULT NULL,
  `menus` set('13','12','11','10','9','8','7','6','5','4','3','2','1') DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`role`,`deleted_at`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of device_role_menu
-- ----------------------------
INSERT INTO `device_role_menu` VALUES ('1', 'SYSTEM_MANAGER', '11,10,9,8,7,6,5,4,3,2,1', '2019-04-06 14:49:25', null);

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
  `role` enum('EMPLOYEE','SYSTEM_MANAGER','DEVICE_MANAGER') DEFAULT NULL COMMENT '角色',
  `created_at` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_user
-- ----------------------------
INSERT INTO `device_user` VALUES ('1', '超级管理员', 'MALE', '18309225600', '18309225600@163.com', 'E10ADC3949BA59ABBE56E057F20F883E', 'SYSTEM_MANAGER', '2019-04-02 22:01:38', null);

-- ----------------------------
-- Table structure for `divice_detail`
-- ----------------------------
DROP TABLE IF EXISTS `divice_detail`;
CREATE TABLE `divice_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL COMMENT '设备编号',
  `name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `op_user_id` bigint(20) DEFAULT NULL COMMENT '更新状态人ID',
  `op_user_name` varchar(64) DEFAULT NULL COMMENT '更新状态人',
  `dumped` enum('TRUE','FALSE') DEFAULT 'FALSE' COMMENT '是否报废',
  `status` enum('NOMAL','DUMPED','LOST','REPAIRING') DEFAULT 'NOMAL',
  `price` bigint(20) DEFAULT '0' COMMENT '价格',
  `description` varchar(255) DEFAULT NULL COMMENT '设备描述',
  `source` varchar(255) DEFAULT NULL COMMENT '设备来源',
  `number` int(11) DEFAULT '1' COMMENT '数量',
  `remark` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of divice_detail
-- ----------------------------
