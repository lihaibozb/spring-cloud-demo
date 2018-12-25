/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1
 Source Database       : cloud_db1

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 12/25/2018 11:11:04 AM
*/
create database `cloud_db1`;
USE cloud_db1;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL,
  `account_name` varchar(50) NOT NULL,
  `account_sum` decimal(14,3) NOT NULL,
  `modify_time` datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  KEY `idx_modify_time` (`modify_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_account`
-- ----------------------------
BEGIN;
INSERT INTO `t_account` VALUES ('1', 'bob', '200.000', '2018-11-13 17:33:29.000');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
