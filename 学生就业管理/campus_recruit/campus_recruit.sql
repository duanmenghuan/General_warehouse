/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50734
Source Host           : localhost:3306
Source Database       : campus_recruit

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2023-02-22 15:19:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_account` varchar(50) DEFAULT NULL COMMENT '账号',
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('68', 'admin', '181901feaa468e38d1be829cdde6d36e', 'HLHx');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_no` varchar(50) DEFAULT NULL COMMENT '单位号',
  `company_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `company_contact` varchar(50) DEFAULT NULL COMMENT '联系人',
  `company_phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `company_email` varchar(255) DEFAULT NULL,
  `company_code` varchar(50) DEFAULT NULL COMMENT '机构代码',
  `company_address` varchar(255) DEFAULT NULL,
  `company_describe` varchar(255) DEFAULT NULL,
  `company_account` varchar(255) DEFAULT NULL,
  `company_password` varchar(255) DEFAULT NULL,
  `company_salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COMMENT='企业';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('70', null, '111', null, null, '123124@qq.com', null, null, null, 'qiye1', '0c6d7c5d408b00b1d0cdb742030978c8', 'z3Mk');

-- ----------------------------
-- Table structure for consultation
-- ----------------------------
DROP TABLE IF EXISTS `consultation`;
CREATE TABLE `consultation` (
  `consultation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(2) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `position_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `consultation_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`consultation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='咨询';

-- ----------------------------
-- Records of consultation
-- ----------------------------
INSERT INTO `consultation` VALUES ('19', '1', null, '74', null, '66', '70', '1', '2023-02-22 11:37:09');
INSERT INTO `consultation` VALUES ('20', '2', '19', null, null, null, '70', '111', '2023-02-22 14:37:48');
INSERT INTO `consultation` VALUES ('21', '2', '19', null, null, null, '70', '111', '2023-02-22 14:45:38');
INSERT INTO `consultation` VALUES ('22', '2', '19', null, null, null, '70', '111', '2023-02-22 14:46:22');
INSERT INTO `consultation` VALUES ('23', '3', '19', null, '69', null, null, '123123', '2023-02-22 14:58:37');
INSERT INTO `consultation` VALUES ('24', '1', '19', '74', null, null, null, '1111', '2023-02-22 15:18:15');
INSERT INTO `consultation` VALUES ('25', '1', '19', '74', null, null, null, '不是把', '2023-02-22 15:18:25');

-- ----------------------------
-- Table structure for deliver
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver` (
  `deliver_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) DEFAULT NULL,
  `position_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `deliver_state` int(2) DEFAULT NULL,
  `deliver_date` datetime DEFAULT NULL,
  PRIMARY KEY (`deliver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='投递';

-- ----------------------------
-- Records of deliver
-- ----------------------------
INSERT INTO `deliver` VALUES ('9', '74', '66', '70', '2', '2022-03-24 10:19:37');
INSERT INTO `deliver` VALUES ('10', '74', '67', '70', '2', '2022-03-24 10:19:39');
INSERT INTO `deliver` VALUES ('11', '74', '71', '70', '1', '2023-02-22 10:07:56');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `position_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `position_company` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `position_name` varchar(255) DEFAULT NULL,
  `position_fresh` varchar(255) DEFAULT NULL,
  `position_min_salary` decimal(10,2) DEFAULT NULL,
  `position_max_salary` decimal(10,2) DEFAULT NULL,
  `position_quota` varchar(255) DEFAULT NULL,
  `position_city` varchar(255) DEFAULT NULL,
  `position_require` varchar(255) DEFAULT NULL,
  `position_description` varchar(255) DEFAULT NULL,
  `position_welfare` varchar(255) DEFAULT NULL,
  `position_release` varchar(255) DEFAULT NULL,
  `position_status` varchar(10) DEFAULT NULL COMMENT '状态：1：待审核；2：通过；3：不通过',
  `position_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COMMENT='职位';

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('66', '70', 'java', '1', '1000.00', '9000.00', '10', '北京', 'java', 'java', '五险一金', '2022-02-10 14:28:02', '2', '111');
INSERT INTO `position` VALUES ('67', '70', '数据库开发', '0', '2000.00', '8000.00', '20', '北京', '数据库开发', '数据库开发', '五险一金', '2022-02-10 14:28:47', '2', '1111');
INSERT INTO `position` VALUES ('69', '70', 'java', '0', '100.00', '9000.00', '2', '北京', '123', '123', '123', '2022-04-03 20:35:06', '2', '11');
INSERT INTO `position` VALUES ('71', '70', 'java', '1', '1000.00', '10000.00', '10', '北京', '111', '111', '111', '2023-02-22 09:46:31', '2', '111111');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_account` varchar(50) DEFAULT NULL COMMENT '账号',
  `student_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `student_salt` varchar(255) DEFAULT NULL COMMENT '盐',
  `student_no` varchar(50) DEFAULT NULL COMMENT '学号',
  `student_classg` varchar(50) DEFAULT NULL COMMENT '班级',
  `student_phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `student_resume` varchar(255) DEFAULT NULL COMMENT '简历',
  `student_employment` int(2) DEFAULT NULL COMMENT '就业状态：1：待就业；2：已就业',
  `employment` varchar(50) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `student_major` varchar(50) DEFAULT NULL COMMENT '专业',
  `student_grade` varchar(50) DEFAULT NULL COMMENT '年级',
  `student_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COMMENT='学生';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('74', 'xuesheng1', '0905bfc04662bfd243474f1c5b334b3e', 'H0YD', '1', 'Wlian', '17333277345', '1', '2', '111234', 'xuesheng1', '1', '1', '123@qq.com');
INSERT INTO `student` VALUES ('75', 'xuesheng2', 'cdf7dfe03e8d88a8680d4494fe58c57e', 'svXQ', '2', 'Xguan', '2', '1', '1', null, 'xuesheng2', '2', '2', '123@qq.com');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacher_account` varchar(50) DEFAULT NULL COMMENT '账号',
  `teacher_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `teacher_salt` varchar(255) DEFAULT NULL COMMENT '盐',
  `teacher_no` varchar(50) DEFAULT NULL COMMENT '学号',
  `teacher_phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `teacher_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COMMENT='老师';

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('69', 'banzhuren1', '29ab4f66b99d9d9e4b14f79fcecbe58e', 'sZ71', 'Wlian', '1', '班主任');
