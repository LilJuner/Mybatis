/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.20 : Database - db_mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_mybatis`;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `jobs` varchar(50) DEFAULT NULL,
  `t_phone` varchar(50) DEFAULT NULL,
  `idcard_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcard_fkey` (`idcard_id`),
  CONSTRAINT `idcard_fkey` FOREIGN KEY (`idcard_id`) REFERENCES `t_idcard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`id`,`username`,`jobs`,`t_phone`,`idcard_id`) values 
(2,'张三','工程师','13966552554',1),
(4,'李四','教师','13137788221',2);

/*Table structure for table `t_idcard` */

DROP TABLE IF EXISTS `t_idcard`;

CREATE TABLE `t_idcard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_idcard` */

insert  into `t_idcard`(`id`,`code`) values 
(1,'232321197710090818'),
(2,'232221198810081819');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
