/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : ssm_car_rent

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 14/03/2022 11:43:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cars
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars`  (
  `carnumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cartype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `color` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rentprice` decimal(10, 2) NOT NULL,
  `deposit` decimal(10, 2) NOT NULL,
  `isrenting` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cardesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carimg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seat` int(5) NOT NULL,
  PRIMARY KEY (`carnumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cars
-- ----------------------------
INSERT INTO `cars` VALUES ('京A-10001', '宝马X6', '蓝色', 1000.00, 100000.00, '未出租', '现代车', '京A-10001.jpg', 4);
INSERT INTO `cars` VALUES ('京A-10002', '宝马X6', '红色', 1000.00, 100000.00, '未出租', '现代车', '京A-10002.jpg', 4);
INSERT INTO `cars` VALUES ('京A-10003', '桑塔纳X1', '红色', 500.00, 100000.00, '未出租', '复古车', '京A-10003.jpg', 4);
INSERT INTO `cars` VALUES ('京A-10004', '奔驰X9', '棕色', 1000.00, 100000.00, '未出租', '现代车', '京A-10004.jpg', 4);

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`  (
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `custname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `career` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `custpwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`identity`) USING BTREE,
  INDEX `custname`(`custname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('100001', '赵克', '男', '北京', '13345676544', '开发', '123456');
INSERT INTO `customers` VALUES ('100002', '黄山', '男', '广东', '13456540987', '运营', 'wwwwww');
INSERT INTO `customers` VALUES ('100003', '李丽', '女', '深圳', '13346787654', '采购', '123456');
INSERT INTO `customers` VALUES ('100004', '张红', '女', '北京', '13478765643', '人力', '123456');
INSERT INTO `customers` VALUES ('100005', '张刚', '男', '武汉', '13456988765', '品质', '123456');
INSERT INTO `customers` VALUES ('100006', '张燕', '女', '长沙', '13450987863', '运维', '123456');

-- ----------------------------
-- Table structure for funs
-- ----------------------------
DROP TABLE IF EXISTS `funs`;
CREATE TABLE `funs`  (
  `funid` decimal(8, 0) NOT NULL,
  `funname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `funurl` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menuid` decimal(8, 0) NOT NULL,
  PRIMARY KEY (`funid`) USING BTREE,
  INDEX `FUNS_FK`(`menuid`) USING BTREE,
  CONSTRAINT `FUNS_FK` FOREIGN KEY (`menuid`) REFERENCES `menus` (`menuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of funs
-- ----------------------------
INSERT INTO `funs` VALUES (1, '主页面', 'index.jsp', 1);
INSERT INTO `funs` VALUES (2, '头页面', 'head.jsp', 1);
INSERT INTO `funs` VALUES (3, '菜单页面', 'menu.jsp', 1);
INSERT INTO `funs` VALUES (4, '脚页面', 'foot.jsp', 1);
INSERT INTO `funs` VALUES (5, '操作页面', 'welcome.jsp', 1);
INSERT INTO `funs` VALUES (6, '权限提示页面', 'norole.jsp', 1);
INSERT INTO `funs` VALUES (8, '退出系统动作n', 'ExitSystemAction.do', 1);
INSERT INTO `funs` VALUES (9, '菜单导航', 'modNavTop.jsp', 1);
INSERT INTO `funs` VALUES (10, '菜单条', 'splitor.jsp', 1);
INSERT INTO `funs` VALUES (11, '操作失败提示页面', 'error.jsp', 1);
INSERT INTO `funs` VALUES (12, '系统崩溃提示页面', 'appError.jsp', 1);
INSERT INTO `funs` VALUES (13, '成功页面', 'ok.jsp', 1);
INSERT INTO `funs` VALUES (30, '底页面', 'foot.jsp', 1);
INSERT INTO `funs` VALUES (50, '添加用户角色查询动作n', 'AddUserAction.do', 3);
INSERT INTO `funs` VALUES (51, '添加用户页面', 'addUser.jsp', 3);
INSERT INTO `funs` VALUES (52, '添加用户动作', 'AddUser.do', 3);
INSERT INTO `funs` VALUES (53, '查询用户角色查询动作n', 'FindUserAction.do', 4);
INSERT INTO `funs` VALUES (54, '查询用户页面', 'findUser.jsp', 4);
INSERT INTO `funs` VALUES (55, '显示查询用户结果页面n', 'viewUser.jsp', 4);
INSERT INTO `funs` VALUES (56, '查询用户动作', 'FindUser.do', 4);
INSERT INTO `funs` VALUES (57, '预更新查询用户动作', 'PreUpdateUser.do', 4);
INSERT INTO `funs` VALUES (58, '显示更新用户页面', 'updateUser.jsp', 4);
INSERT INTO `funs` VALUES (59, '更新用户动作', 'UpdateUser.do', 4);
INSERT INTO `funs` VALUES (60, '删除用户动作', 'DeleteUser.do', 4);
INSERT INTO `funs` VALUES (61, '预修改用户密码', 'PreChangeUserPwd.do', 4);
INSERT INTO `funs` VALUES (62, '修改用户密码页面', 'chengeUserPwd.jsp', 4);
INSERT INTO `funs` VALUES (63, '修改用户密码动作', 'ChangeUserPwd.do', 4);
INSERT INTO `funs` VALUES (100, '添加客户页面', 'addCustomers.jsp', 6);
INSERT INTO `funs` VALUES (101, '添加客户动作n', 'AddCustomersAction.do', 6);
INSERT INTO `funs` VALUES (102, '查询客户页面', 'findCustomers.jsp', 7);
INSERT INTO `funs` VALUES (103, '查询客户信息动作n', 'FindCustomersAction.do', 7);
INSERT INTO `funs` VALUES (104, '显示查询客户结果页面', 'viewCustomers.jsp', 7);
INSERT INTO `funs` VALUES (105, '预更新客户查询动作', 'PreCustomers.do', 7);
INSERT INTO `funs` VALUES (106, '显示更新客户页面', 'updateCustomers.jsp', 7);
INSERT INTO `funs` VALUES (107, '更新客户动作', 'UpdateCustomers.do', 7);
INSERT INTO `funs` VALUES (108, '删除客户动作', 'DeleteCustomers.do', 7);
INSERT INTO `funs` VALUES (109, '预修改客户密码', 'PreChangeCustomerPwd.do', 7);
INSERT INTO `funs` VALUES (110, '修改客户密码页面', 'chengeCustomersPwd.jsp', 7);
INSERT INTO `funs` VALUES (111, '修改用户密码动作', 'ChangeCustomersPwd.do', 7);
INSERT INTO `funs` VALUES (200, '添加汽车页面', 'addCar.jsp', 9);
INSERT INTO `funs` VALUES (201, '添加汽车动作n', 'AddCarAction.do', 9);
INSERT INTO `funs` VALUES (202, '查询汽车页面', 'findCar.jsp', 10);
INSERT INTO `funs` VALUES (203, '显示查询汽车结果页面', 'viewCars.jsp', 10);
INSERT INTO `funs` VALUES (204, '查询汽车信息动作n', 'FindCarAction.do', 10);
INSERT INTO `funs` VALUES (205, '预更新查询汽车动作', 'PreUpdateCar.do', 10);
INSERT INTO `funs` VALUES (206, '显示更新汽车结果页面', 'updateCar.jsp', 10);
INSERT INTO `funs` VALUES (207, '更新汽车动作', 'UpdateCar.do', 10);
INSERT INTO `funs` VALUES (209, '删除汽车动作', 'DeleteCar.do', 10);

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
  `menuid` decimal(8, 0) NOT NULL,
  `menuname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `connurl` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fatherid` decimal(8, 0) NOT NULL,
  PRIMARY KEY (`menuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES (1, '汽车信息管理系统', NULL, -1);
INSERT INTO `menus` VALUES (2, '用户管理', NULL, 1);
INSERT INTO `menus` VALUES (3, '添加用户', 'houtai/addUser.jsp', 2);
INSERT INTO `menus` VALUES (4, '查询用户', 'houtai/selUser.jsp', 2);
INSERT INTO `menus` VALUES (5, '客户管理', NULL, 1);
INSERT INTO `menus` VALUES (6, '添加客户信息', 'houtai/addCustomer.jsp', 5);
INSERT INTO `menus` VALUES (7, '查询客户信息', 'houtai/selCustomer.jsp', 5);
INSERT INTO `menus` VALUES (8, '汽车管理', NULL, 1);
INSERT INTO `menus` VALUES (9, '添加汽车信息', 'houtai/addCar.jsp', 8);
INSERT INTO `menus` VALUES (10, '查询汽车信息', 'houtai/selCar.jsp', 8);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `roleid` int(8) NOT NULL,
  `rolename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, '超级管理员');
INSERT INTO `roles` VALUES (2, '管理员');

-- ----------------------------
-- Table structure for roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus`  (
  `roleid` int(8) NOT NULL,
  `menuid` decimal(8, 0) NOT NULL,
  PRIMARY KEY (`roleid`, `menuid`) USING BTREE,
  INDEX `ROLES_MENUS_FK2`(`menuid`) USING BTREE,
  CONSTRAINT `ROLES_MENUS_FK1` FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ROLES_MENUS_FK2` FOREIGN KEY (`menuid`) REFERENCES `menus` (`menuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles_menus
-- ----------------------------
INSERT INTO `roles_menus` VALUES (1, 1);
INSERT INTO `roles_menus` VALUES (2, 1);
INSERT INTO `roles_menus` VALUES (1, 2);
INSERT INTO `roles_menus` VALUES (1, 3);
INSERT INTO `roles_menus` VALUES (1, 4);
INSERT INTO `roles_menus` VALUES (1, 5);
INSERT INTO `roles_menus` VALUES (2, 5);
INSERT INTO `roles_menus` VALUES (1, 6);
INSERT INTO `roles_menus` VALUES (2, 6);
INSERT INTO `roles_menus` VALUES (1, 7);
INSERT INTO `roles_menus` VALUES (2, 7);
INSERT INTO `roles_menus` VALUES (1, 8);
INSERT INTO `roles_menus` VALUES (2, 8);
INSERT INTO `roles_menus` VALUES (1, 9);
INSERT INTO `roles_menus` VALUES (2, 9);
INSERT INTO `roles_menus` VALUES (1, 10);
INSERT INTO `roles_menus` VALUES (2, 10);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fullname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userlevel` int(8) NOT NULL,
  `userpwd` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`identity`) USING BTREE,
  INDEX `USERS_UK`(`identity`) USING BTREE,
  INDEX `username`(`username`) USING BTREE,
  INDEX `USERS_FK`(`userlevel`) USING BTREE,
  CONSTRAINT `USERS_FK` FOREIGN KEY (`userlevel`) REFERENCES `roles` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('admin', '10001', '管理员', '男', '武汉', '13332900878', '管理员', 1, 'admin');
INSERT INTO `users` VALUES ('lisi', '10002', '李四', '男', '南京', '13345653456', '职员', 2, '123456');
INSERT INTO `users` VALUES ('wangwu', '10003', '王五', '男', '上海', '12234567656', '经理', 2, '123456');
INSERT INTO `users` VALUES ('zhaoliu', '10004', '赵六', '男', '北京', '13443676543', '职员', 2, '123456');

SET FOREIGN_KEY_CHECKS = 1;
