/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : db_cgwuliuxinxissm

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 07/03/2021 11:40:15
*/

drop database if exists db_cgwuliuxinxissm;
create database db_cgwuliuxinxissm charset utf8;
use db_cgwuliuxinxissm;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
BEGIN;
INSERT INTO `t_admin` VALUES (1, 'admin', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for t_rizhi
-- ----------------------------
DROP TABLE IF EXISTS `t_rizhi`;
CREATE TABLE `t_rizhi` (
  `rizhiId` int(11) NOT NULL AUTO_INCREMENT,
  `rizhiName` varchar(255) NOT NULL,
  `dengluIp` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`rizhiId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rizhi
-- ----------------------------
BEGIN;
INSERT INTO `t_rizhi` VALUES (1, 'admin', '127.0.0.1', '2021-12-06 21:55:48');
INSERT INTO `t_rizhi` VALUES (2, 'kehu11', '127.0.0.1', '2021-12-06 21:57:30');
INSERT INTO `t_rizhi` VALUES (3, 'yonghu1', '127.0.0.1', '2021-12-06 21:58:47');
INSERT INTO `t_rizhi` VALUES (4, 'yonghu1', '127.0.0.1', '2021-12-06 22:02:21');
INSERT INTO `t_rizhi` VALUES (5, 'yonghu1', '127.0.0.1', '2021-12-06 22:04:21');
INSERT INTO `t_rizhi` VALUES (6, 'yonghu1', '127.0.0.1', '2021-12-06 22:06:44');
INSERT INTO `t_rizhi` VALUES (7, 'kehu11', '127.0.0.1', '2021-12-06 22:08:00');
INSERT INTO `t_rizhi` VALUES (8, 'kehu11', '127.0.0.1', '2021-12-06 22:10:30');
INSERT INTO `t_rizhi` VALUES (9, 'admin', '127.0.0.1', '2021-12-06 22:10:48');
INSERT INTO `t_rizhi` VALUES (10, 'admin', '127.0.0.1', '2021-12-07 15:58:47');
INSERT INTO `t_rizhi` VALUES (11, 'admin', '127.0.0.1', '2021-12-04 22:37:22');
INSERT INTO `t_rizhi` VALUES (12, 'admin', '127.0.0.1', '2021-12-04 22:37:26');
INSERT INTO `t_rizhi` VALUES (13, 'admin', '127.0.0.1', '2021-12-04 22:37:22');
INSERT INTO `t_rizhi` VALUES (14, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:41:36');
INSERT INTO `t_rizhi` VALUES (15, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:41:38');
INSERT INTO `t_rizhi` VALUES (16, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:44:19');
INSERT INTO `t_rizhi` VALUES (17, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:51:18');
INSERT INTO `t_rizhi` VALUES (18, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:52:56');
INSERT INTO `t_rizhi` VALUES (19, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:51:43');
INSERT INTO `t_rizhi` VALUES (20, 'admin', '0:0:0:0:0:0:0:1', '2021-12-04 22:51:04');
INSERT INTO `t_rizhi` VALUES (21, 'admin', '0:0:0:0:0:0:0:1', '2021-12-05 10:21:57');
INSERT INTO `t_rizhi` VALUES (22, 'admin', '0:0:0:0:0:0:0:1', '2021-12-05 10:26:18');
INSERT INTO `t_rizhi` VALUES (23, '123456', '0:0:0:0:0:0:0:1', '2021-12-05 10:56:53');
INSERT INTO `t_rizhi` VALUES (24, 'admin', '0:0:0:0:0:0:0:1', '2021-12-05 11:01:19');
INSERT INTO `t_rizhi` VALUES (25, '123456', '0:0:0:0:0:0:0:1', '2021-12-05 11:02:36');
INSERT INTO `t_rizhi` VALUES (26, 'admin', '0:0:0:0:0:0:0:1', '2021-12-05 11:03:47');
INSERT INTO `t_rizhi` VALUES (27, '123456', '0:0:0:0:0:0:0:1', '2021-12-05 11:05:12');
INSERT INTO `t_rizhi` VALUES (28, 'admin', '0:0:0:0:0:0:0:1', '2021-12-05 11:05:39');
INSERT INTO `t_rizhi` VALUES (29, '123456', '0:0:0:0:0:0:0:1', '2021-12-05 11:08:29');
INSERT INTO `t_rizhi` VALUES (30, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 10:31:34');
INSERT INTO `t_rizhi` VALUES (31, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 10:33:09');
INSERT INTO `t_rizhi` VALUES (32, 'tom', '0:0:0:0:0:0:0:1', '2021-12-07 10:45:42');
INSERT INTO `t_rizhi` VALUES (33, '123', '0:0:0:0:0:0:0:1', '2021-12-07 10:47:49');
INSERT INTO `t_rizhi` VALUES (34, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 10:48:16');
INSERT INTO `t_rizhi` VALUES (35, 'tom', '0:0:0:0:0:0:0:1', '2021-12-07 11:15:18');
INSERT INTO `t_rizhi` VALUES (36, '123', '0:0:0:0:0:0:0:1', '2021-12-07 11:25:18');
INSERT INTO `t_rizhi` VALUES (37, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 11:25:34');
INSERT INTO `t_rizhi` VALUES (38, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 11:30:48');
INSERT INTO `t_rizhi` VALUES (39, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 11:31:39');
INSERT INTO `t_rizhi` VALUES (40, 'tom', '0:0:0:0:0:0:0:1', '2021-12-07 11:33:52');
INSERT INTO `t_rizhi` VALUES (41, 'admin', '0:0:0:0:0:0:0:1', '2021-12-07 11:35:42');
INSERT INTO `t_rizhi` VALUES (42, '123', '0:0:0:0:0:0:0:1', '2021-12-07 11:36:31');
COMMIT;

-- ----------------------------
-- Table structure for t_shangpin
-- ----------------------------
DROP TABLE IF EXISTS `t_shangpin`;
CREATE TABLE `t_shangpin` (
  `shangpinId` int(11) NOT NULL AUTO_INCREMENT,
  `shangpinName` varchar(255) DEFAULT NULL,
  `shangpinMark` varchar(255) DEFAULT NULL,
  `shangpinMark1` varchar(255) DEFAULT NULL,
  `shangpinMark2` varchar(255) DEFAULT NULL,
  `shangpinMark3` varchar(255) DEFAULT NULL,
  `shangpinDate` datetime DEFAULT NULL,
  `shangpinDate1` datetime DEFAULT NULL,
  `shangpinZong` int(11) DEFAULT NULL,
  `shangpinJin` double DEFAULT NULL,
  `shangpinXiao` double DEFAULT NULL,
  `shangpinLirun` double DEFAULT NULL,
  `shangpinType` int(11) DEFAULT NULL,
  `shangpinType1` int(11) DEFAULT NULL,
  `shangpinImg` varchar(255) DEFAULT NULL,
  `shangpinImgName` varchar(255) DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shangpinId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shangpin
-- ----------------------------
BEGIN;
INSERT INTO `t_shangpin` VALUES (1, '电脑', '中山东路128号', NULL, NULL, NULL, '2021-12-06 21:58:34', NULL, 0, 300, 0, 0, 4, NULL, NULL, NULL, 1, '东城区', 1, 'zhangsan', NULL, NULL, NULL, NULL);
INSERT INTO `t_shangpin` VALUES (2, '书本', '白下路458号', NULL, NULL, NULL, '2021-12-05 10:57:43', NULL, 0, 100, 0, 0, 4, NULL, NULL, NULL, 1, '范围1', 2, 'lisi', NULL, NULL, NULL, NULL);
INSERT INTO `t_shangpin` VALUES (3, 'iPhone12', '奥体南路128号', NULL, NULL, NULL, '2021-12-07 10:51:48', NULL, 0, 250, 0, 0, 1, NULL, NULL, NULL, 2, '保定区', 1, 'zhangsan', NULL, NULL, NULL, NULL);
INSERT INTO `t_shangpin` VALUES (4, '课桌', '马南路34号', NULL, NULL, NULL, '2021-12-07 10:56:20', NULL, 0, 120, 0, 0, 2, NULL, NULL, NULL, 4, '江宁区', 1, 'zhangsan', NULL, NULL, NULL, NULL);
INSERT INTO `t_shangpin` VALUES (5, '华为平板', '南京中路9号', NULL, NULL, NULL, '2021-12-07 10:56:54', NULL, 0, 80, 0, 0, 3, NULL, NULL, NULL, 5, '栖霞区', 1, 'zhangsan', NULL, NULL, NULL, NULL);
INSERT INTO `t_shangpin` VALUES (6, '板凳', '华南中路28号', NULL, NULL, NULL, '2021-12-07 11:06:19', NULL, 0, 900, 0, 0, 1, NULL, NULL, NULL, 2, '保定区', 1, 'zhangsan', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_spcangku
-- ----------------------------
DROP TABLE IF EXISTS `t_spcangku`;
CREATE TABLE `t_spcangku` (
  `spcangkuId` int(11) NOT NULL AUTO_INCREMENT,
  `spcangkuName` varchar(255) DEFAULT NULL,
  `spcangkuMark` varchar(255) DEFAULT NULL,
  `spcangkuMark1` varchar(255) DEFAULT NULL,
  `spcangkuMark2` varchar(255) DEFAULT NULL,
  `spcangkuPhone` varchar(255) DEFAULT NULL,
  `spcangkuDizhi` varchar(255) DEFAULT NULL,
  `spcangkuDate` datetime DEFAULT NULL,
  `spcangkuDate1` datetime DEFAULT NULL,
  `spcangkuType` int(11) DEFAULT NULL,
  `spcangkuType1` int(11) DEFAULT NULL,
  PRIMARY KEY (`spcangkuId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_spcangku
-- ----------------------------
BEGIN;
INSERT INTO `t_spcangku` VALUES (1, '苏A12345', '蓝卡A5', NULL, NULL, NULL, NULL, '2021-12-06 21:56:34', NULL, 0, NULL);
INSERT INTO `t_spcangku` VALUES (2, '京A88888', '东风25', NULL, NULL, NULL, NULL, '2021-12-05 10:29:16', NULL, 0, NULL);
INSERT INTO `t_spcangku` VALUES (3, '苏A88888', '奇瑞A3', NULL, NULL, NULL, NULL, '2021-12-07 10:58:19', NULL, 0, NULL);
INSERT INTO `t_spcangku` VALUES (4, '沪A22222', '宝俊50', NULL, NULL, NULL, NULL, '2021-12-07 10:58:54', NULL, 0, NULL);
INSERT INTO `t_spcangku` VALUES (5, '苏B66666', '奥拓X5', NULL, NULL, NULL, NULL, '2021-12-07 10:59:16', NULL, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_spgys
-- ----------------------------
DROP TABLE IF EXISTS `t_spgys`;
CREATE TABLE `t_spgys` (
  `spgysId` int(11) NOT NULL AUTO_INCREMENT,
  `spgysName` varchar(255) DEFAULT NULL,
  `spgysMark` varchar(255) DEFAULT NULL,
  `spgysMark1` varchar(255) DEFAULT NULL,
  `spgysMark2` varchar(255) DEFAULT NULL,
  `spgysPhone` varchar(255) DEFAULT NULL,
  `spgysDizhi` varchar(255) DEFAULT NULL,
  `spgysDate` datetime DEFAULT NULL,
  `spgysDate1` datetime DEFAULT NULL,
  `spgysType` int(11) DEFAULT NULL,
  `spgysType1` int(11) DEFAULT NULL,
  PRIMARY KEY (`spgysId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_spgys
-- ----------------------------
BEGIN;
INSERT INTO `t_spgys` VALUES (1, '小王', '小王', NULL, NULL, '13112345678', '北京', '2021-12-06 21:56:48', NULL, 0, NULL);
INSERT INTO `t_spgys` VALUES (2, '小李', '小李', NULL, NULL, '15222222222', '南京', '2021-12-05 10:30:12', NULL, 0, NULL);
INSERT INTO `t_spgys` VALUES (3, '小汤', '小汤', NULL, NULL, '13499999999', '南京', '2021-12-07 11:00:25', NULL, 0, NULL);
INSERT INTO `t_spgys` VALUES (4, '小张', '小张', NULL, NULL, '13488888888', '上海', '2021-12-07 11:04:16', NULL, 0, NULL);
INSERT INTO `t_spgys` VALUES (5, '小明', '小明', NULL, NULL, '13333333333', '上海', '2021-12-07 11:04:34', NULL, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_spjin
-- ----------------------------
DROP TABLE IF EXISTS `t_spjin`;
CREATE TABLE `t_spjin` (
  `spjinId` int(11) NOT NULL AUTO_INCREMENT,
  `spjinName` varchar(255) DEFAULT NULL,
  `spjinMark` varchar(255) DEFAULT NULL,
  `spjinMark1` varchar(255) DEFAULT NULL,
  `spjinMark2` varchar(255) DEFAULT NULL,
  `spjinMark3` varchar(255) DEFAULT NULL,
  `spjinDate` datetime DEFAULT NULL,
  `spjinDate1` datetime DEFAULT NULL,
  `spjinZong` int(11) DEFAULT NULL,
  `spjinJine` double DEFAULT NULL,
  `spjinZe` double DEFAULT NULL,
  `spjinType` int(11) DEFAULT NULL,
  `spjinType1` int(11) DEFAULT NULL,
  `shangpinId` int(11) DEFAULT NULL,
  `shangpinName` varchar(255) DEFAULT NULL,
  `sptypeId` int(11) DEFAULT NULL,
  `sptypeName` varchar(255) DEFAULT NULL,
  `spcangkuId` int(11) DEFAULT NULL,
  `spcangkuName` varchar(255) DEFAULT NULL,
  `spgysId` int(11) DEFAULT NULL,
  `spgysName` varchar(255) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `spjinImg` varchar(255) DEFAULT NULL,
  `spjinImgName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`spjinId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_spjin
-- ----------------------------
BEGIN;
INSERT INTO `t_spjin` VALUES (1, '上海路129号', NULL, NULL, NULL, NULL, '2021-12-06 22:04:46', NULL, NULL, NULL, NULL, 2, NULL, 1, '鲜花', 1, '栖霞区', 1, '京A88888', 1, '小李', 1, 'zhangsan', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_spjin` VALUES (2, '南方中路3号', NULL, NULL, NULL, NULL, '2021-12-05 11:02:24', NULL, NULL, NULL, NULL, 2, NULL, 2, '充电器', 1, '保定区', 1, '沪A22222', 1, '小汤', 2, 'lisi', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_spjin` VALUES (3, '奥体南路128号', NULL, NULL, NULL, NULL, '2021-12-07 10:57:46', NULL, NULL, NULL, NULL, 0, NULL, 3, 'iPhone12', 2, '保定区', 1, '苏A12345', 1, '小王', 1, 'zhangsan', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_spjin` VALUES (4, '南京中路9号', NULL, NULL, NULL, NULL, '2021-12-07 11:05:05', NULL, NULL, NULL, NULL, 1, NULL, 5, '华为平板', 5, '栖霞区', 1, '苏A12345', 1, '小王', 1, 'zhangsan', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_spjin` VALUES (5, '华南中路28号', NULL, NULL, NULL, NULL, '2021-12-07 11:09:27', NULL, NULL, NULL, NULL, 0, NULL, 6, '板凳', 2, '保定区', 2, '京A88888', 3, '小汤', 1, 'zhangsan', NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_sptype
-- ----------------------------
DROP TABLE IF EXISTS `t_sptype`;
CREATE TABLE `t_sptype` (
  `sptypeId` int(11) NOT NULL AUTO_INCREMENT,
  `sptypeName` varchar(255) DEFAULT NULL,
  `sptypeMark` varchar(255) DEFAULT NULL,
  `sptypeMark1` varchar(255) DEFAULT NULL,
  `sptypeMark2` int(11) DEFAULT NULL,
  PRIMARY KEY (`sptypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sptype
-- ----------------------------
BEGIN;
INSERT INTO `t_sptype` VALUES (1, '东城区', '东城区', NULL, NULL);
INSERT INTO `t_sptype` VALUES (2, '保定区', '保定区', NULL, NULL);
INSERT INTO `t_sptype` VALUES (3, '秦淮区', '秦淮区', NULL, NULL);
INSERT INTO `t_sptype` VALUES (4, '江宁区', '江宁区', NULL, NULL);
INSERT INTO `t_sptype` VALUES (5, '栖霞区', '栖霞区', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userXingming` varchar(255) DEFAULT NULL,
  `userSex` int(11) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userPhone` varchar(255) DEFAULT NULL,
  `userMark1` varchar(255) DEFAULT NULL,
  `userMark2` varchar(255) DEFAULT NULL,
  `userMark3` varchar(255) DEFAULT NULL,
  `userMark4` varchar(255) DEFAULT NULL,
  `userDate1` datetime DEFAULT NULL,
  `userDate2` datetime DEFAULT NULL,
  `userType1` int(11) DEFAULT NULL,
  `userType2` int(11) DEFAULT NULL,
  `userImg` varchar(255) DEFAULT NULL,
  `userImgName` varchar(255) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'zhangsan', '123', '张三', 0, 22, '13012345678', '13012345678@qq.com', NULL, NULL, NULL, '2021-12-06 21:57:24', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (2, 'lisi', '123', '李四', 0, 27, '13012345678', '13012345678@qq.com', NULL, NULL, NULL, '2021-12-05 10:26:04', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_uyijian
-- ----------------------------
DROP TABLE IF EXISTS `t_uyijian`;
CREATE TABLE `t_uyijian` (
  `uyijianId` int(11) NOT NULL AUTO_INCREMENT,
  `uyijianName` varchar(255) DEFAULT NULL,
  `uyijianMark` varchar(255) DEFAULT NULL,
  `uyijianMark1` varchar(255) DEFAULT NULL,
  `uyijianMark2` varchar(255) DEFAULT NULL,
  `uyijianImg` varchar(255) DEFAULT NULL,
  `uyijianImgName` varchar(255) DEFAULT NULL,
  `uyijianDate` datetime DEFAULT NULL,
  `uyijianDate1` datetime DEFAULT NULL,
  `uyijianType` int(11) DEFAULT NULL,
  `uyijianType1` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int(11) DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uyijianId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_uyijian
-- ----------------------------
BEGIN;
INSERT INTO `t_uyijian` VALUES (1, '东西有破损', '东西有破损', '货物已收到，但有破损，请查下', '已联系物流，会查清楚', NULL, NULL, '2021-12-06 22:08:33', NULL, 1, NULL, 1, 'zhangsan', NULL, NULL);
INSERT INTO `t_uyijian` VALUES (2, '物流很给力', '物流很给力', '物流很给力，第二天就到了，赞', '感谢您的认可', NULL, NULL, '2021-12-07 11:14:34', NULL, 1, NULL, 1, 'zhangsan', NULL, NULL);
INSERT INTO `t_uyijian` VALUES (3, '服务态度很棒', '服务态度很棒', '服务态度很棒，大大的赞', NULL, NULL, NULL, '2021-12-07 11:26:59', NULL, 0, NULL, 1, 'zhangsan', NULL, NULL);
INSERT INTO `t_uyijian` VALUES (4, '不错的物流', '不错的物流', '不错的物流，给力', NULL, NULL, NULL, '2021-12-07 11:27:19', NULL, 0, NULL, 1, 'zhangsan', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_yonghu
-- ----------------------------
DROP TABLE IF EXISTS `t_yonghu`;
CREATE TABLE `t_yonghu` (
  `yonghuId` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuName` varchar(255) DEFAULT NULL,
  `yonghuPassword` varchar(255) DEFAULT NULL,
  `yonghuXingming` varchar(255) DEFAULT NULL,
  `yonghuSex` int(11) DEFAULT NULL,
  `yonghuAge` int(11) DEFAULT NULL,
  `yonghuPhone` varchar(255) DEFAULT NULL,
  `yonghuMark1` varchar(255) DEFAULT NULL,
  `yonghuMark2` varchar(255) DEFAULT NULL,
  `yonghuMark3` varchar(255) DEFAULT NULL,
  `yonghuMark4` varchar(255) DEFAULT NULL,
  `yonghuDate1` datetime DEFAULT NULL,
  `yonghuDate2` datetime DEFAULT NULL,
  `yonghuType1` int(11) DEFAULT NULL,
  `yonghuType2` int(11) DEFAULT NULL,
  `yonghuImg` varchar(255) DEFAULT NULL,
  `yonghuImgName` varchar(255) DEFAULT NULL,
  `yhroleId` int(11) DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  `yhbumenId` int(11) DEFAULT NULL,
  `yhbumenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yonghuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yonghu
-- ----------------------------
BEGIN;
INSERT INTO `t_yonghu` VALUES (1, 'tom', '123', '汤姆', 0, 22, '13888888888', NULL, NULL, NULL, NULL, '2021-12-06 21:56:11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_yonghu` VALUES (3, 'jack', '123', '杰克', 1, 29, '13777777777', NULL, NULL, NULL, NULL, '2021-12-07 10:34:22', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
