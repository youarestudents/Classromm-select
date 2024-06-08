/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.29 : Database - computer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`computer` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `computer`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int DEFAULT NULL,
  `classname` char(16) DEFAULT NULL,
  `computers` int DEFAULT NULL,
  `service` int DEFAULT NULL,
  `usedemo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `class` */

LOCK TABLES `class` WRITE;

insert  into `class`(`id`,`classname`,`computers`,`service`,`usedemo`) values (602,'第二微机室',56,0,0),(608,'云计算实验室',36,6,0),(612,'人工智能实验室',28,1,0),(613,'数字电路实验室',48,48,0),(616,'物联网实训室',14,14,0),(617,'区块链实验室',48,1,0),(620,'计算机网络实验室',36,6,0),(626,'第一微机室',60,1,0);

UNLOCK TABLES;

/*Table structure for table `classusing` */

DROP TABLE IF EXISTS `classusing`;

CREATE TABLE `classusing` (
  `classid` int DEFAULT NULL,
  `sid` char(18) DEFAULT NULL,
  `persons` int DEFAULT NULL,
  `computers` int DEFAULT NULL,
  `overtime` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `classusing` */

LOCK TABLES `classusing` WRITE;

insert  into `classusing`(`classid`,`sid`,`persons`,`computers`,`overtime`) values (617,'202142452',1,1,1717591215381);

UNLOCK TABLES;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` char(9) DEFAULT NULL,
  `password` char(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

LOCK TABLES `student` WRITE;

insert  into `student`(`sid`,`password`) values ('202142452','gaorenhe123'),('202342453','12345678'),('202342454','12345678');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
