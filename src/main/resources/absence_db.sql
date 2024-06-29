/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.19 : Database - absence_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`absence_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `absence_db`;

/*Table structure for table `leave_applications` */

DROP TABLE IF EXISTS `leave_applications`;

CREATE TABLE `leave_applications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `class` varchar(50) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `leave_type` varchar(20) NOT NULL,
  `reason` text NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `submitted_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `review_result` enum('是','否') DEFAULT '否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leave_applications` */

/*Table structure for table `leaverequest` */

DROP TABLE IF EXISTS `leaverequest`;

CREATE TABLE `leaverequest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` varchar(50) DEFAULT NULL,
  `parentName` varchar(50) DEFAULT NULL,
  `leave_type` varchar(255) DEFAULT NULL,
  `specific_reasons` text,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `is_over_two_day` varchar(10) DEFAULT NULL,
  `submitted_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `review_result` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `leaverequest` */

insert  into `leaverequest`(`id`,`studentId`,`parentName`,`leave_type`,`specific_reasons`,`start_date`,`end_date`,`is_over_two_day`,`submitted_at`,`review_result`) values 
(1,NULL,'马银','事假','只可意会不可言传','1970-01-01 00:00:00','1970-01-01 00:00:00','是','2024-06-28 21:21:42',NULL),
(2,'220312238','马英','事假','只可意会不可言喻','2024-06-28 00:00:00','2024-07-07 00:00:00','是','2024-06-28 21:28:21',NULL),
(3,NULL,'马银','事假','只可意会不可言传','1970-01-01 00:00:00','1970-01-01 00:00:00','是','2024-06-28 21:31:05',NULL),
(4,'','','事假','',NULL,NULL,'是','2024-06-28 22:10:57',NULL),
(5,'','','事假','',NULL,NULL,'是','2024-06-28 22:10:57',NULL);

/*Table structure for table `parents` */

DROP TABLE IF EXISTS `parents`;

CREATE TABLE `parents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `parent_name` varchar(50) DEFAULT NULL,
  `parent_contact` varchar(50) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `parents` */

insert  into `parents`(`id`,`student_id`,`parent_name`,`parent_contact`,`create_time`,`update_time`) values 
(1,NULL,'马银','1872639','2024-06-28 21:21:42','2024-06-28 21:21:42'),
(2,NULL,'马英','18726392089','2024-06-28 21:28:21','2024-06-28 21:28:21'),
(3,NULL,'马银','1872639','2024-06-28 21:31:05','2024-06-28 21:31:05'),
(4,NULL,'','11111111111','2024-06-28 22:10:57','2024-06-28 22:10:57'),
(5,NULL,'','11111111111','2024-06-28 22:10:57','2024-06-28 22:10:57');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) DEFAULT NULL,
  `student_id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `class` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dormitory` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`student_id`,`name`,`class`,`contact`,`email`,`dormitory`,`created_at`,`updated_at`) values 
(NULL,'','','','11111111111','','','2024-06-28 22:10:56','2024-06-28 22:10:56'),
(1,'20230001','张三','计算机科学与技术1班','13800000001','zhangsan@example.com','A栋101','2024-06-28 00:30:57','2024-06-28 00:30:57'),
(2,'20230002','李四','软件工程2班','13800000002','lisi@example.com','B栋202','2024-06-28 00:30:57','2024-06-28 00:30:57'),
(3,'20230003','王五','信息管理与信息系统3班','13800000003','wangwu@example.com','C栋303','2024-06-28 00:30:57','2024-06-28 00:30:57'),
(NULL,'220312238','徐啟光','22计科2班','19142439161','2162801998@qq.com','21栋505','2024-06-28 21:28:21','2024-06-28 21:28:21');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
