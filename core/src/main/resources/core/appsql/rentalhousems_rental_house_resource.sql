-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rentalhousems
-- ------------------------------------------------------
-- Server version	5.5.32

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
-- Table structure for table `rental_house_resource`
--

DROP TABLE IF EXISTS `rental_house_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rental_house_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `remarks` varchar(245) DEFAULT NULL,
  `del_flag` int(11) DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `house_type` int(11) DEFAULT NULL COMMENT '房子是什么样的房型结构，对应于系统字典表中的数据',
  `rent_price` decimal(12,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0----待出租\n            1-----已出租',
  `decoration_situation` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  `house_code` varchar(45) DEFAULT NULL,
  `standard_elect_amount` decimal(12,2) DEFAULT NULL COMMENT '标准电费收取度数',
  `standard_water_amount` decimal(12,2) DEFAULT NULL COMMENT '标准水费收取度数',
  `address` varchar(245) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_house_resource`
--

LOCK TABLES `rental_house_resource` WRITE;
/*!40000 ALTER TABLE `rental_house_resource` DISABLE KEYS */;
INSERT INTO `rental_house_resource` VALUES (1,'2017-12-30 15:03:50','3','2017-12-30 15:03:50','3','',0,NULL,4622989,0,2000.00,0,'独立单间','四甲出租屋',NULL,'A001',0.70,0.00,'四甲庆丰路XXX号');
/*!40000 ALTER TABLE `rental_house_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-30 17:22:01
