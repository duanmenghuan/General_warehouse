/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.31-log : Database - flowershop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_dingdan` */
create database flowershop;
use flowershop;
DROP TABLE IF EXISTS `t_dingdan`;

CREATE TABLE `t_dingdan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `dianhua` varchar(255) DEFAULT NULL,
  `dizhi` varchar(255) DEFAULT NULL,
  `xiangqing` text,
  `orderid` varchar(255) DEFAULT NULL,
  `beizhu` text,
  `shijian` varchar(255) DEFAULT NULL,
  `zongjia` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_dingdan` */

insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (2,'已处理',3,'张三','13011111212','山西省太原市太原理工大学','商品名：郁金香,单价:66.0,购买数量：2,小计：132.0<br/>','20170502223651','包装好','2017-05-02 22:36:51',132);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (3,'未处理',3,'张三','13011111212','山西省太原市太原理工大学','商品名：郁金香,单价:66.0,购买数量：4,小计：264.0<br/>商品名：玫瑰花,单价:99.0,购买数量：4,小计：396.0<br/>','20170511113034','','2017-05-11 11:30:34',660);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (4,'未处理',3,'张三','13011111212','山西省太原市太原理工大学','商品名：郁金香,单价:66.0,购买数量：1,小计：66.0<br/>','20170511134257','','2017-05-11 13:42:57',66);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (5,'已处理',3,'张三','13011111212','山西省太原市太原理工大学','商品名：郁金香,单价:66.0,购买数量：1,小计：66.0<br/>','20170511163001','','2017-05-11 16:30:01',66);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (6,'未处理',7,'222222','13834341212','2222','商品名：郁金香,单价:66.0,购买数量：1,小计：66.0<br/>','20170605122020','','2017-06-05 12:20:20',66);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (7,'未处理',8,'张三','13011111211','山西省太原市太原理工大学','商品名：郁金香,单价:66.0,购买数量：1,小计：66.0<br/>','20170605122519','','2017-06-05 12:25:19',66);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (8,'未处理',8,'张三','13011111211','山西省太原市太原理工大学','商品名：玫瑰花,单价:99.0,购买数量：1,小计：99.0<br/>','20170605123015','','2017-06-05 12:30:15',99);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (9,'未处理',8,'张三','13011111211','山西省太原市太原理工大学','商品名：郁金香,单价:66.0,购买数量：1,小计：66.0<br/>','20170605123331','','2017-06-05 12:33:31',66);
insert  into `t_dingdan`(`id`,`status`,`userid`,`xingming`,`dianhua`,`dizhi`,`xiangqing`,`orderid`,`beizhu`,`shijian`,`zongjia`) values (10,'未处理',9,'李四','13812121111','太原','商品名：郁金香,单价:66.0,购买数量：10,小计：660.0<br/>','20170605160527','','2017-06-05 16:05:27',660);

/*Table structure for table `t_fenlei` */

DROP TABLE IF EXISTS `t_fenlei`;

CREATE TABLE `t_fenlei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_fenlei` */

insert  into `t_fenlei`(`id`,`fname`) values (4,'爱情类');
insert  into `t_fenlei`(`id`,`fname`) values (5,'友情类');

/*Table structure for table `t_gonggao` */

DROP TABLE IF EXISTS `t_gonggao`;

CREATE TABLE `t_gonggao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(255) DEFAULT NULL,
  `neirong` text,
  `shijian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_gonggao` */

insert  into `t_gonggao`(`id`,`biaoti`,`neirong`,`shijian`) values (2,'毕业季','毕业季也是离别季，买束鲜花送给老师和同学，感恩一路陪伴！','2017-05-02 22:33:03');
insert  into `t_gonggao`(`id`,`biaoti`,`neirong`,`shijian`) values (3,'入店须知','本店所有产品均为货到付款，收到产品后请检查好！23','2017-05-02 22:42:13');

/*Table structure for table `t_gouwuche` */

DROP TABLE IF EXISTS `t_gouwuche`;

CREATE TABLE `t_gouwuche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `jiage` float DEFAULT NULL,
  `shuliang` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_gouwuche` */

insert  into `t_gouwuche`(`id`,`userid`,`pid`,`pname`,`jiage`,`shuliang`) values (8,3,7,'百合花',99,3);

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  `fenleiid` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `jiage` float DEFAULT NULL,
  `tuijian` varchar(255) DEFAULT NULL,
  `dianjishu` int(11) DEFAULT NULL,
  `xiaoliang` int(11) DEFAULT NULL,
  `miaoshu` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_product` */

insert  into `t_product`(`id`,`pname`,`imgpath`,`createtime`,`fenleiid`,`fname`,`jiage`,`tuijian`,`dianjishu`,`xiaoliang`,`miaoshu`) values (4,'玫瑰花','20170502221745.jpg','2017-05-02 22:14:27','4','爱情类',99,'未推荐',10,5,'玫瑰原产中国，栽培历史悠久，玫瑰在植物分类学上是一种蔷薇科蔷薇属灌木(Rosa rugosa)，在日常生活中是蔷薇属一系列花大艳丽的栽培品种的统称，这些栽培品种亦可称做月季或蔷薇。\n花语:爱情、爱与美、容光焕发，勇敢。');
insert  into `t_product`(`id`,`pname`,`imgpath`,`createtime`,`fenleiid`,`fname`,`jiage`,`tuijian`,`dianjishu`,`xiaoliang`,`miaoshu`) values (5,'郁金香','20170502223117.jpg','2017-05-02 22:21:46','5','友情类',66,'未推荐',26,23,'郁金香在植物分类学上，是一类属于百合科郁金香属(学名：Tulipa)的具鳞茎草本植物，又称洋荷花、旱荷花。\n郁金香花语：博爱、体贴、善良\n');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `dianhua` varchar(255) DEFAULT NULL,
  `dizhi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`xingming`,`role`,`dianhua`,`dizhi`) values (1,'admin','111111','admin',1,NULL,NULL);
insert  into `t_user`(`id`,`username`,`password`,`xingming`,`role`,`dianhua`,`dizhi`) values (8,'111111','111111','张三',0,'13011111211','山西省太原市太原理工大学');
insert  into `t_user`(`id`,`username`,`password`,`xingming`,`role`,`dianhua`,`dizhi`) values (9,'222222','222222','李四',0,'13812121111','太原');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
