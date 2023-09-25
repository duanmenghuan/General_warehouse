-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssmukwx2
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `ask` longtext COMMENT '提问',
  `reply` longtext COMMENT '回复',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751906890 DEFAULT CHARSET=utf8 COMMENT='客服聊天表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (81,'2021-03-03 05:33:33',1,1,'提问1','回复1',1),(82,'2021-03-03 05:33:33',2,2,'提问2','回复2',2),(83,'2021-03-03 05:33:33',3,3,'提问3','回复3',3),(84,'2021-03-03 05:33:33',4,4,'提问4','回复4',4),(85,'2021-03-03 05:33:33',5,5,'提问5','回复5',5),(86,'2021-03-03 05:33:33',6,6,'提问6','回复6',6),(1614751809095,'2021-03-03 06:10:08',1614751541738,NULL,'在吗',NULL,0),(1614751906889,'2021-03-03 06:11:46',1614751541738,1,NULL,'在的',NULL);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','http://localhost:8080/ssmukwx2/upload/1614751512060.jpg'),(2,'picture2','http://localhost:8080/ssmukwx2/upload/1614750942742.jpg'),(3,'picture3','http://localhost:8080/ssmukwx2/upload/1614750981866.jpg'),(6,'homepage',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussjingdianxinxi`
--

DROP TABLE IF EXISTS `discussjingdianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussjingdianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751645725 DEFAULT CHARSET=utf8 COMMENT='景点信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussjingdianxinxi`
--

LOCK TABLES `discussjingdianxinxi` WRITE;
/*!40000 ALTER TABLE `discussjingdianxinxi` DISABLE KEYS */;
INSERT INTO `discussjingdianxinxi` VALUES (121,'2021-03-03 05:33:33',1,1,'评论内容1','回复内容1'),(122,'2021-03-03 05:33:33',2,2,'评论内容2','回复内容2'),(123,'2021-03-03 05:33:33',3,3,'评论内容3','回复内容3'),(124,'2021-03-03 05:33:33',4,4,'评论内容4','回复内容4'),(125,'2021-03-03 05:33:33',5,5,'评论内容5','回复内容5'),(126,'2021-03-03 05:33:33',6,6,'评论内容6','回复内容6'),(1614751645724,'2021-03-03 06:07:25',1614751257489,1614751541738,'很不错的景点',NULL);
/*!40000 ALTER TABLE `discussjingdianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussjiudianxinxi`
--

DROP TABLE IF EXISTS `discussjiudianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussjiudianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751669470 DEFAULT CHARSET=utf8 COMMENT='酒店信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussjiudianxinxi`
--

LOCK TABLES `discussjiudianxinxi` WRITE;
/*!40000 ALTER TABLE `discussjiudianxinxi` DISABLE KEYS */;
INSERT INTO `discussjiudianxinxi` VALUES (131,'2021-03-03 05:33:33',1,1,'评论内容1','回复内容1'),(132,'2021-03-03 05:33:33',2,2,'评论内容2','回复内容2'),(133,'2021-03-03 05:33:33',3,3,'评论内容3','回复内容3'),(134,'2021-03-03 05:33:33',4,4,'评论内容4','回复内容4'),(135,'2021-03-03 05:33:33',5,5,'评论内容5','回复内容5'),(136,'2021-03-03 05:33:33',6,6,'评论内容6','回复内容6'),(1614751669469,'2021-03-03 06:07:49',1614751359689,1614751541738,'很不错的酒店',NULL);
/*!40000 ALTER TABLE `discussjiudianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusskefangxinxi`
--

DROP TABLE IF EXISTS `discusskefangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusskefangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8 COMMENT='客房信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusskefangxinxi`
--

LOCK TABLES `discusskefangxinxi` WRITE;
/*!40000 ALTER TABLE `discusskefangxinxi` DISABLE KEYS */;
INSERT INTO `discusskefangxinxi` VALUES (141,'2021-03-03 05:33:33',1,1,'评论内容1','回复内容1'),(142,'2021-03-03 05:33:33',2,2,'评论内容2','回复内容2'),(143,'2021-03-03 05:33:33',3,3,'评论内容3','回复内容3'),(144,'2021-03-03 05:33:33',4,4,'评论内容4','回复内容4'),(145,'2021-03-03 05:33:33',5,5,'评论内容5','回复内容5'),(146,'2021-03-03 05:33:33',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discusskefangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751773802 DEFAULT CHARSET=utf8 COMMENT='交流论坛';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (91,'2021-03-03 05:33:33','帖子标题1','帖子内容1',1,1,'用户名1','开放'),(92,'2021-03-03 05:33:33','帖子标题2','帖子内容2',2,2,'用户名2','开放'),(93,'2021-03-03 05:33:33','帖子标题3','帖子内容3',3,3,'用户名3','开放'),(94,'2021-03-03 05:33:33','帖子标题4','帖子内容4',4,4,'用户名4','开放'),(95,'2021-03-03 05:33:33','帖子标题5','帖子内容5',5,5,'用户名5','开放'),(96,'2021-03-03 05:33:33','帖子标题6','帖子内容6',6,6,'用户名6','开放'),(1614751764342,'2021-03-03 06:09:23','江西红色旅游景点游玩攻略','<p>江西红色旅游景点游玩攻略</p>\n<p><img src=\"../../../upload/1614751760318.jpg\" alt=\"\" width=\"679\" height=\"452\" /></p>',0,1614751541738,'1','开放');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goupiaoxinxi`
--

DROP TABLE IF EXISTS `goupiaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goupiaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `jingdianmingcheng` varchar(200) DEFAULT NULL COMMENT '景点名称',
  `jingdiandizhi` varchar(200) DEFAULT NULL COMMENT '景点地址',
  `menpiaojiage` int(11) DEFAULT NULL COMMENT '门票价格',
  `shuliang` int(11) NOT NULL COMMENT '数量',
  `zongjine` varchar(200) DEFAULT NULL COMMENT '总金额',
  `goupiaoriqi` date DEFAULT NULL COMMENT '购票日期',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751636890 DEFAULT CHARSET=utf8 COMMENT='购票信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goupiaoxinxi`
--

LOCK TABLES `goupiaoxinxi` WRITE;
/*!40000 ALTER TABLE `goupiaoxinxi` DISABLE KEYS */;
INSERT INTO `goupiaoxinxi` VALUES (31,'2021-03-03 05:33:33','订单编号1','景点名称1','景点地址1',1,1,'总金额1','2021-03-03','备注1','用户名1','姓名1','手机1','是','','未支付'),(32,'2021-03-03 05:33:33','订单编号2','景点名称2','景点地址2',2,2,'总金额2','2021-03-03','备注2','用户名2','姓名2','手机2','是','','未支付'),(33,'2021-03-03 05:33:33','订单编号3','景点名称3','景点地址3',3,3,'总金额3','2021-03-03','备注3','用户名3','姓名3','手机3','是','','未支付'),(34,'2021-03-03 05:33:33','订单编号4','景点名称4','景点地址4',4,4,'总金额4','2021-03-03','备注4','用户名4','姓名4','手机4','是','','未支付'),(35,'2021-03-03 05:33:33','订单编号5','景点名称5','景点地址5',5,5,'总金额5','2021-03-03','备注5','用户名5','姓名5','手机5','是','','未支付'),(36,'2021-03-03 05:33:33','订单编号6','景点名称6','景点地址6',6,6,'总金额6','2021-03-03','备注6','用户名6','姓名6','手机6','是','','未支付'),(1614751636889,'2021-03-03 06:07:16','202133147963305512','景德镇民窑博物馆','竟成镇航空路18号',200,2,'400','2021-03-03','','1','陈一','12312312312','是','ok','已支付');
/*!40000 ALTER TABLE `goupiaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingdianxinxi`
--

DROP TABLE IF EXISTS `jingdianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingdianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingdianmingcheng` varchar(200) NOT NULL COMMENT '景点名称',
  `jingdiantupian` varchar(200) DEFAULT NULL COMMENT '景点图片',
  `jingdiandengji` varchar(200) DEFAULT NULL COMMENT '景点等级',
  `jingdiandizhi` varchar(200) DEFAULT NULL COMMENT '景点地址',
  `menpiaojiage` int(11) DEFAULT NULL COMMENT '门票价格',
  `kaifangshijian` varchar(200) DEFAULT NULL COMMENT '开放时间',
  `jingdianjieshao` longtext COMMENT '景点介绍',
  `goupiaoxuzhi` longtext COMMENT '购票须知',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751257490 DEFAULT CHARSET=utf8 COMMENT='景点信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingdianxinxi`
--

LOCK TABLES `jingdianxinxi` WRITE;
/*!40000 ALTER TABLE `jingdianxinxi` DISABLE KEYS */;
INSERT INTO `jingdianxinxi` VALUES (21,'2021-03-03 05:33:33','景点名称1','http://localhost:8080/ssmukwx2/upload/jingdianxinxi_jingdiantupian1.jpg','A','景点地址1',1,'开放时间1','景点介绍1','购票须知1','2021-03-03 13:33:33',1),(22,'2021-03-03 05:33:33','景点名称2','http://localhost:8080/ssmukwx2/upload/jingdianxinxi_jingdiantupian2.jpg','A','景点地址2',2,'开放时间2','景点介绍2','购票须知2','2021-03-03 13:33:33',2),(23,'2021-03-03 05:33:33','景点名称3','http://localhost:8080/ssmukwx2/upload/jingdianxinxi_jingdiantupian3.jpg','A','景点地址3',3,'开放时间3','景点介绍3','购票须知3','2021-03-03 13:33:33',3),(24,'2021-03-03 05:33:33','景点名称4','http://localhost:8080/ssmukwx2/upload/1614750763615.jpg','A','景点地址4',4,'开放时间4','<p>景点介绍4</p>','购票须知4','2021-03-03 14:06:22',11),(25,'2021-03-03 05:33:33','景点名称5','http://localhost:8080/ssmukwx2/upload/jingdianxinxi_jingdiantupian5.jpg','A','景点地址5',5,'开放时间5','景点介绍5','购票须知5','2021-03-03 13:33:33',5),(26,'2021-03-03 05:33:33','景点名称6','http://localhost:8080/ssmukwx2/upload/1614750776454.jpg','A','景点地址6',6,'开放时间6','<p>景点介绍6</p>','购票须知6','2021-03-03 13:52:49',7),(1614751257489,'2021-03-03 06:00:56','景德镇民窑博物馆','http://localhost:8080/ssmukwx2/upload/1614751255078.jpg','AAAAA','竟成镇航空路18号',200,'9:00-18:00','<p><span style=\"background-color: rgb(255, 236, 236); color: rgb(51, 51, 51);\">&nbsp;景德镇民窑博物馆设于全国著名的湖田窑古瓷遗址文物保护区内。在四十余万平方米的地下积淀了五代至明朝（公元907年—公元1644年）制瓷历史的丰富文化遗存，它清晰地反映了这七百年间陶瓷工艺史上重大变革和集中国古代制瓷历史之大成的全过程，是全国乃至全世界陶瓷史学研究者、陶瓷工艺美术爱好者和中外广大游客的朝圣之地。</span></p><p><span style=\"background-color: rgb(255, 236, 236); color: rgb(51, 51, 51);\"><span class=\"ql-cursor\">﻿</span></span><img src=\"http://localhost:8080/ssmukwx2/upload/1614751246749.jpg\"></p>','门票一旦售出，不退不改','2021-03-03 14:07:28',3);
/*!40000 ALTER TABLE `jingdianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiudianxinxi`
--

DROP TABLE IF EXISTS `jiudianxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiudianxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiudianmingcheng` varchar(200) NOT NULL COMMENT '酒店名称',
  `tupian` varchar(200) NOT NULL COMMENT '图片',
  `xingji` varchar(200) NOT NULL COMMENT '星级',
  `jiudianleixing` varchar(200) NOT NULL COMMENT '酒店类型',
  `jiudiandizhi` varchar(200) DEFAULT NULL COMMENT '酒店地址',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `jiudianjieshao` longtext COMMENT '酒店介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751359690 DEFAULT CHARSET=utf8 COMMENT='酒店信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiudianxinxi`
--

LOCK TABLES `jiudianxinxi` WRITE;
/*!40000 ALTER TABLE `jiudianxinxi` DISABLE KEYS */;
INSERT INTO `jiudianxinxi` VALUES (41,'2021-03-03 05:33:33','酒店名称1','http://localhost:8080/ssmukwx2/upload/jiudianxinxi_tupian1.jpg','一星','民宿','酒店地址1','联系电话1','酒店介绍1'),(42,'2021-03-03 05:33:33','酒店名称2','http://localhost:8080/ssmukwx2/upload/jiudianxinxi_tupian2.jpg','一星','民宿','酒店地址2','联系电话2','酒店介绍2'),(43,'2021-03-03 05:33:33','酒店名称3','http://localhost:8080/ssmukwx2/upload/jiudianxinxi_tupian3.jpg','一星','民宿','酒店地址3','联系电话3','酒店介绍3'),(44,'2021-03-03 05:33:33','酒店名称4','http://localhost:8080/ssmukwx2/upload/jiudianxinxi_tupian4.jpg','一星','民宿','酒店地址4','联系电话4','酒店介绍4'),(45,'2021-03-03 05:33:33','酒店名称5','http://localhost:8080/ssmukwx2/upload/jiudianxinxi_tupian5.jpg','一星','民宿','酒店地址5','联系电话5','酒店介绍5'),(46,'2021-03-03 05:33:33','酒店名称6','http://localhost:8080/ssmukwx2/upload/1614750797409.jpg','一星','民宿','酒店地址6','联系电话6','<p>酒店介绍6</p>'),(1614751359689,'2021-03-03 06:02:38','江西宾馆','http://localhost:8080/ssmukwx2/upload/1614751279873.jpg','三星','连锁酒店','南昌市东湖区八一大道8号','0791-12345678','<p>提倡在传统中发现时尚，感受温馨</p><p><img src=\"http://localhost:8080/ssmukwx2/upload/1614751357520.jpg\"></p>');
/*!40000 ALTER TABLE `jiudianxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kefangleixing`
--

DROP TABLE IF EXISTS `kefangleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kefangleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kefangleixing` varchar(200) NOT NULL COMMENT '客房类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kefangleixing` (`kefangleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751369307 DEFAULT CHARSET=utf8 COMMENT='客房类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kefangleixing`
--

LOCK TABLES `kefangleixing` WRITE;
/*!40000 ALTER TABLE `kefangleixing` DISABLE KEYS */;
INSERT INTO `kefangleixing` VALUES (51,'2021-03-03 05:33:33','大床房'),(52,'2021-03-03 05:33:33','双人房'),(53,'2021-03-03 05:33:33','三人房'),(54,'2021-03-03 05:33:33','主题套房'),(1614751369306,'2021-03-03 06:02:48','标准套房');
/*!40000 ALTER TABLE `kefangleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kefangxinxi`
--

DROP TABLE IF EXISTS `kefangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kefangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kefangmingcheng` varchar(200) NOT NULL COMMENT '客房名称',
  `kefangleixing` varchar(200) NOT NULL COMMENT '客房类型',
  `kefangtupian` varchar(200) NOT NULL COMMENT '客房图片',
  `kefangsheshi` varchar(200) DEFAULT NULL COMMENT '客房设施',
  `kefangjiage` int(11) NOT NULL COMMENT '客房价格',
  `kefangzhuangtai` varchar(200) NOT NULL COMMENT '客房状态',
  `kefangjieshao` longtext COMMENT '客房介绍',
  `jiudianmingcheng` varchar(200) DEFAULT NULL COMMENT '酒店名称',
  `jiudianleixing` varchar(200) DEFAULT NULL COMMENT '酒店类型',
  `jiudiandizhi` varchar(200) DEFAULT NULL COMMENT '酒店地址',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751411922 DEFAULT CHARSET=utf8 COMMENT='客房信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kefangxinxi`
--

LOCK TABLES `kefangxinxi` WRITE;
/*!40000 ALTER TABLE `kefangxinxi` DISABLE KEYS */;
INSERT INTO `kefangxinxi` VALUES (61,'2021-03-03 05:33:33','客房名称1','三人房','http://localhost:8080/ssmukwx2/upload/1614750842859.jpg','客房设施1',1,'可预订','<p>客房介绍1</p>','酒店名称1','酒店类型1','酒店地址1','2021-03-03 13:53:57',2),(62,'2021-03-03 05:33:33','客房名称2','主题套房','http://localhost:8080/ssmukwx2/upload/kefangxinxi_kefangtupian2.jpg','客房设施2',2,'可预订','<p>客房介绍2</p>','酒店名称2','酒店类型2','酒店地址2','2021-03-03 13:54:08',3),(63,'2021-03-03 05:33:33','客房名称3','双人房','http://localhost:8080/ssmukwx2/upload/kefangxinxi_kefangtupian3.jpg','客房设施3',3,'可预订','<p>客房介绍3</p>','酒店名称3','酒店类型3','酒店地址3','2021-03-03 13:54:15',4),(64,'2021-03-03 05:33:33','客房名称4','双人房','http://localhost:8080/ssmukwx2/upload/kefangxinxi_kefangtupian4.jpg','客房设施4',4,'可预订','<p>客房介绍4</p>','酒店名称4','酒店类型4','酒店地址4','2021-03-03 13:54:25',5),(65,'2021-03-03 05:33:33','客房名称5','双人房','http://localhost:8080/ssmukwx2/upload/1614750878425.jpg','客房设施5',5,'可预订','<p>客房介绍5</p>','酒店名称5','酒店类型5','酒店地址5','2021-03-03 13:54:31',6),(66,'2021-03-03 05:33:33','客房名称6','大床房','http://localhost:8080/ssmukwx2/upload/kefangxinxi_kefangtupian6.jpg','客房设施6',6,'可预订','<p>客房介绍6</p>','酒店名称6','酒店类型6','酒店地址6','2021-03-03 13:54:47',7),(1614751411921,'2021-03-03 06:03:31','604房','标准套房','http://localhost:8080/ssmukwx2/upload/1614751383683.jpg','空调冰箱电视',290,'已预订','<p>设施齐全，温馨</p><p><img src=\"http://localhost:8080/ssmukwx2/upload/1614751409300.jpg\"></p>','江西宾馆','连锁酒店','南昌市东湖区八一大道8号','2021-03-03 14:11:09',3);
/*!40000 ALTER TABLE `kefangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kefangyuding`
--

DROP TABLE IF EXISTS `kefangyuding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kefangyuding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dingdanbianhao` varchar(200) DEFAULT NULL COMMENT '订单编号',
  `kefangmingcheng` varchar(200) DEFAULT NULL COMMENT '客房名称',
  `kefangleixing` varchar(200) DEFAULT NULL COMMENT '客房类型',
  `kefangzhuangtai` varchar(200) DEFAULT NULL COMMENT '客房状态',
  `jiudianmingcheng` varchar(200) DEFAULT NULL COMMENT '酒店名称',
  `kefangjiage` int(11) DEFAULT NULL COMMENT '客房价格',
  `yudingtianshu` int(11) NOT NULL COMMENT '预订天数',
  `zongjiage` varchar(200) DEFAULT NULL COMMENT '总价格',
  `xiadanshijian` date DEFAULT NULL COMMENT '下单时间',
  `ruzhushijian` datetime NOT NULL COMMENT '入住时间',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `ispay` varchar(200) DEFAULT '未支付' COMMENT '是否支付',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dingdanbianhao` (`dingdanbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751711296 DEFAULT CHARSET=utf8 COMMENT='客房预订';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kefangyuding`
--

LOCK TABLES `kefangyuding` WRITE;
/*!40000 ALTER TABLE `kefangyuding` DISABLE KEYS */;
INSERT INTO `kefangyuding` VALUES (71,'2021-03-03 05:33:33','订单编号1','客房名称1','客房类型1','客房状态1','酒店名称1',1,1,'总价格1','2021-03-03','2021-03-03 13:33:33','用户名1','姓名1','身份证1','是','','未支付'),(72,'2021-03-03 05:33:33','订单编号2','客房名称2','客房类型2','客房状态2','酒店名称2',2,2,'总价格2','2021-03-03','2021-03-03 13:33:33','用户名2','姓名2','身份证2','是','','未支付'),(73,'2021-03-03 05:33:33','订单编号3','客房名称3','客房类型3','客房状态3','酒店名称3',3,3,'总价格3','2021-03-03','2021-03-03 13:33:33','用户名3','姓名3','身份证3','是','','未支付'),(74,'2021-03-03 05:33:33','订单编号4','客房名称4','客房类型4','客房状态4','酒店名称4',4,4,'总价格4','2021-03-03','2021-03-03 13:33:33','用户名4','姓名4','身份证4','是','','未支付'),(75,'2021-03-03 05:33:33','订单编号5','客房名称5','客房类型5','客房状态5','酒店名称5',5,5,'总价格5','2021-03-03','2021-03-03 13:33:33','用户名5','姓名5','身份证5','是','','未支付'),(76,'2021-03-03 05:33:33','订单编号6','客房名称6','客房类型6','客房状态6','酒店名称6',6,6,'总价格6','2021-03-03','2021-03-03 13:33:33','用户名6','姓名6','身份证6','是','','未支付'),(1614751711295,'2021-03-03 06:08:31','202133148693433238','604房','标准套房','可预订','江西宾馆',290,2,'580','2021-03-03','2021-03-04 13:00:00','1','陈一','123456789789456123','是','ok','已支付');
/*!40000 ALTER TABLE `kefangyuding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `introduction` longtext COMMENT '简介',
  `picture` varchar(200) NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751500750 DEFAULT CHARSET=utf8 COMMENT='红色文化';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (111,'2021-03-03 05:33:33','标题1','简介1','http://localhost:8080/ssmukwx2/upload/news_picture1.jpg','内容1'),(112,'2021-03-03 05:33:33','标题2','简介2','http://localhost:8080/ssmukwx2/upload/news_picture2.jpg','内容2'),(113,'2021-03-03 05:33:33','标题3','简介3','http://localhost:8080/ssmukwx2/upload/news_picture3.jpg','内容3'),(114,'2021-03-03 05:33:33','标题4','简介4','http://localhost:8080/ssmukwx2/upload/news_picture4.jpg','内容4'),(115,'2021-03-03 05:33:33','标题5','简介5','http://localhost:8080/ssmukwx2/upload/news_picture5.jpg','内容5'),(116,'2021-03-03 05:33:33','标题6','简介6','http://localhost:8080/ssmukwx2/upload/news_picture6.jpg','内容6'),(1614751500749,'2021-03-03 06:05:00','红色文物-罗有荣','生平简介','http://localhost:8080/ssmukwx2/upload/1614751492760.jpg','<p>罗有荣（1914—1989）江西省宁都县人。一九三一年加入中国共产主义青年团。一九三三年参加中国工农红军。一九三五年由团转入中国共产党。土地革命战争时期，任红军大学区队长、副队长，红一方面军第一军团二师二团连政治指导员。参加了长征。抗日战争时期，任八路军一一五师三四三旅六八五团政治处敌工股股长，苏鲁豫支队第四大队政治处主任，新四军第三师七旅二十一团政治委员，淮海军分区第四支队政治委员，第十旅二十八团政治委员。解放战争时期，任辽吉军区第三军分区副司令员，第二旅政治委员，独立第二师政治委员，第四野战军四十四军一三一师政治委员。中华人民共和国成立后，任广州市公安总队政治委员，武汉市公安总队政治委员，武汉军区公安军政治委员，人民武装警察部队湖北总队第二政治委员。一九六二年晋升为少将军衔。</p>');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751685585 DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
INSERT INTO `storeup` VALUES (1614751662110,'2021-03-03 06:07:41',1614751541738,1614751359689,'jiudianxinxi','江西宾馆','http://localhost:8080/ssmukwx2/upload/1614751279873.jpg'),(1614751685584,'2021-03-03 06:08:05',1614751541738,1614751411921,'kefangxinxi','604房','http://localhost:8080/ssmukwx2/upload/1614751383683.jpg');
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'abo','users','管理员','hpgma59npq50kxwuecy1wq7sk5v40853','2021-03-03 05:52:25','2021-03-03 07:10:43'),(2,1614751541738,'1','yonghu','用户','t1r4nic048irqcaax34i6riqm92fm94o','2021-03-03 06:05:47','2021-03-03 07:05:47');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2021-03-03 05:33:33');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuming` varchar(200) NOT NULL COMMENT '用户名',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuming` (`yonghuming`)
) ENGINE=InnoDB AUTO_INCREMENT=1614751541739 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2021-03-03 05:33:33','用户1','123456','姓名1','男','http://localhost:8080/ssmukwx2/upload/yonghu_touxiang1.jpg','13823888881','440300199101010001'),(12,'2021-03-03 05:33:33','用户2','123456','姓名2','男','http://localhost:8080/ssmukwx2/upload/yonghu_touxiang2.jpg','13823888882','440300199202020002'),(13,'2021-03-03 05:33:33','用户3','123456','姓名3','男','http://localhost:8080/ssmukwx2/upload/yonghu_touxiang3.jpg','13823888883','440300199303030003'),(14,'2021-03-03 05:33:33','用户4','123456','姓名4','男','http://localhost:8080/ssmukwx2/upload/yonghu_touxiang4.jpg','13823888884','440300199404040004'),(15,'2021-03-03 05:33:33','用户5','123456','姓名5','男','http://localhost:8080/ssmukwx2/upload/yonghu_touxiang5.jpg','13823888885','440300199505050005'),(16,'2021-03-03 05:33:33','用户6','123456','姓名6','男','http://localhost:8080/ssmukwx2/upload/yonghu_touxiang6.jpg','13823888886','440300199606060006'),(1614751541738,'2021-03-03 06:05:41','1','1','陈一','女','http://localhost:8080/ssmukwx2/upload/1614751559234.jpg','12312312312','123456789789456123');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-03 22:21:04
