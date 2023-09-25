DROP DATABASE IF EXISTS hospital;
CREATE DATABASE hospital CHARACTER SET utf8;
USE hospital;

-- DROP TABLE  `t_user`;
CREATE TABLE `t_user`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `username` varchar(500) COMMENT '用户名' ,
    `password` varchar(500) COMMENT '密码' ,
    `real_name` varchar(500) COMMENT '姓名' ,
    `user_sex` varchar(500) COMMENT '性别:男/女' ,
    `user_phone` varchar(500) COMMENT '手机' ,
    `user_text` varchar(500) COMMENT '备注' ,
    `user_type` varchar(500) COMMENT '类型:管理员/普通用户' 
) COMMENT='用户' ;

-- DROP TABLE  `t_notice`;
CREATE TABLE `t_notice`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `notice_name` varchar(500) COMMENT '标题' ,
    `notice_text` varchar(500) COMMENT '内容' ,
    `notice_type` varchar(500) COMMENT '类型' ,
    `create_date` varchar(500) COMMENT '创建时间' 
) COMMENT='公告' ;

-- DROP TABLE  `t_bingfang`;
CREATE TABLE `t_bingfang`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `bingfang_no` varchar(500) COMMENT '病房号' ,
    `bingfang_name` varchar(500) COMMENT '科室' ,
    `bingfang_type` varchar(500) COMMENT '类型:普通/重症' ,
    `bingfang_count` varchar(500) COMMENT '容量' ,
    `bingfang_price` varchar(500) COMMENT '价格' ,
    `bingfang_text` varchar(500) COMMENT '详情' 
) COMMENT='病房' ;

-- DROP TABLE  `t_feiyong`;
CREATE TABLE `t_feiyong`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `feiyong_no` varchar(500) COMMENT '账单号' ,
    `feiyong_zhuyuanhao` varchar(500) COMMENT '住院号' ,
    `feiyong_name` varchar(500) COMMENT '付款人' ,
    `feiyong_jine` varchar(500) COMMENT '金额' ,
    `feiyong_jiaofeifangshi` varchar(500) COMMENT '缴费方式:现金/转帐' ,
    `feiyong_jiaofeishijian` varchar(500) COMMENT '缴费时间' ,
    `feiyong_text` varchar(500) COMMENT '备注' 
) COMMENT='费用' ;

-- DROP TABLE  `t_zhuyuan`;
CREATE TABLE `t_zhuyuan`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY COMMENT '主键' ,
    `zhuyuan_name` varchar(500) COMMENT '姓名' ,
    `zhuyuan_hao` varchar(500) COMMENT '住院号' ,
    `zhuyuan_sex` varchar(500) COMMENT '性别:男/女' ,
    `zhuyuan_keshi` varchar(500) COMMENT '科室' ,
    `zhuyuan_bingfanghao` varchar(500) COMMENT '病房号' ,
    `zhuyuan_time` varchar(500) COMMENT '入院时间' ,
    `zhuyuan_yishi` varchar(500) COMMENT '护理医师' ,
    `zhuyuan_text` varchar(500) COMMENT '备注' 
) COMMENT='住院' ;
INSERT INTO `t_bingfang` VALUES (1, '0525845', '内科', '普通', '4', '288', '这是内科的病房');
INSERT INTO `t_feiyong` VALUES (1, '1619145566454', '2028051600096', '张三', '5800', '现金', '2028-08-30', '好转');
INSERT INTO `t_notice` VALUES (1, '！', '！！！！', '资讯', '1970-08-21 13:16:24');
INSERT INTO `t_zhuyuan` VALUES (1, '张三', '2028051600096', '男', '精神科', '0525845', '2028-08-30', '李四', '病人情况有所好转');

INSERT INTO `t_user` VALUES (1, 'admin', '123456', '老王', '女' , '13588888888', '是一个好人', '管理员');
INSERT INTO `t_user` VALUES (2, 'a', '123456', '王二', '男' , '13855555555', '5555', '普通用户');
SELECT * FROM `t_user`;

