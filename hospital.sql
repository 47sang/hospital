-- MySQL dump 10.13  Distrib 5.6.50, for Linux (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	5.6.50-log

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `article_datetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `article_title` varchar(255) NOT NULL COMMENT '文章标题',
  `article_keywords` varchar(255) DEFAULT NULL COMMENT '文章关键词',
  `article_content` mediumtext NOT NULL COMMENT '文章内容',
  `doctor_id` int(11) NOT NULL COMMENT '作者医生id',
  `article_praise` int(11) DEFAULT '0' COMMENT '赞数',
  `article_views` int(11) DEFAULT '0' COMMENT '阅读数',
  `article_comments` int(11) DEFAULT '0' COMMENT '评论数',
  `article_type` varchar(255) DEFAULT NULL COMMENT '文章类型',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='健康圈文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'2022-05-27 23:57:29','医保电子凭证激活提醒','#关键词#关键词#疾病','测试内容',1,0,14,4,'健康推送'),(2,'2022-05-27 23:57:31','《全民健身指南》解读','#关键词#关键词#疾病','测试内容',1,0,0,0,'健康推送'),(3,'2022-05-26 14:26:18','“互联网+护理服务”护理质量安全管理制度','#关键词#关键词#疾病','测试内容',1,0,0,0,'最头条'),(4,'2022-05-26 14:26:12','“互联网+护理服务”医疗风险防范制度','#关键词#关键词#疾病','测试内容',1,0,0,0,'最头条'),(5,'2022-05-26 14:32:24','对于胆结石，我从未知道的如此详细','#关键词#关键词#疾病','测试内容',1,0,0,0,'健康推送'),(6,'2022-05-26 14:33:56','“互联网+护理服务”平台服务订单审核规定','#关键词#关键词#疾病','测试内容',1,0,0,0,'最头条'),(7,'2022-05-26 14:38:54','不加数字 随意测试标题测试redis','#关键词#关键词#疾病','测试内容',1,0,0,0,'banner'),(8,'2022-05-26 16:34:20','学会心理调适，助您身心健康','#关键词#关键词#疾病','测试内容',1,0,0,0,'健康推送');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment`
--

DROP TABLE IF EXISTS `article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `patient_id` int(11) NOT NULL COMMENT '患者id',
  `comment_content` varchar(255) NOT NULL COMMENT '评论内容',
  `comment_datetime` datetime(3) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='健康圈文章评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment`
--

LOCK TABLES `article_comment` WRITE;
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic`
--

DROP TABLE IF EXISTS `clinic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic` (
  `clinic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '门诊编号',
  `clinic_name` varchar(255) NOT NULL COMMENT '门诊名称',
  `department_id` int(11) DEFAULT NULL COMMENT '所属的科室部门',
  PRIMARY KEY (`clinic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室门诊表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic`
--

LOCK TABLES `clinic` WRITE;
/*!40000 ALTER TABLE `clinic` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collect` (
  `collect_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `patient_id` int(11) NOT NULL COMMENT '患者id',
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='文章收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
INSERT INTO `collect` VALUES (1,1,1),(2,3,1),(3,2,1),(4,4,2),(5,8,2),(6,8,1);
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `department_name` varchar(255) NOT NULL COMMENT '科室名称',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='科室部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'多学科疑难病门诊'),(2,'综合门诊'),(3,'内科'),(4,'外科'),(5,'妇产及生殖'),(6,'儿科');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生id',
  `doctor_name` varchar(255) NOT NULL COMMENT '医生姓名',
  `doctor_avatar` varchar(255) DEFAULT NULL COMMENT '医生头像',
  `doctor_title` varchar(255) DEFAULT NULL COMMENT '医生职称',
  `doctor_specialty` varchar(255) DEFAULT NULL COMMENT '医生专长',
  `doctor_resume` varchar(255) DEFAULT NULL COMMENT '医生履历',
  `department_id` int(11) DEFAULT NULL COMMENT '科室编号',
  `clinic_id` int(11) DEFAULT NULL COMMENT '门诊编号',
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='医生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'郝阳',NULL,'医师','甲状腺乳腺病专科综合性诊治','2018年本科毕业于蚌埠医学院，至今参加甲状腺乳腺疾病\n相关诊疗工作3年余，具有丰富的甲状腺乳腺相关疾病专\n业诊治经验。',1,1);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nav`
--

DROP TABLE IF EXISTS `nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nav` (
  `nav_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '导航id',
  `nav_title` varchar(255) NOT NULL COMMENT '导航标题',
  `nav_icon` varchar(255) DEFAULT NULL COMMENT '导航图标地址',
  `nav_type` varchar(255) DEFAULT NULL COMMENT '导航分类',
  `nav_url` varchar(255) DEFAULT NULL COMMENT '导航链接',
  `nav_sort` int(11) DEFAULT '1' COMMENT '导航排序',
  `nav_status` enum('启用','禁用') DEFAULT '启用' COMMENT '导航状态',
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='导航表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nav`
--

LOCK TABLES `nav` WRITE;
/*!40000 ALTER TABLE `nav` DISABLE KEYS */;
INSERT INTO `nav` VALUES (1,'在线购药','img/nav.png','navs',NULL,1,'启用'),(2,'报告检查','img/nav.png','navs',NULL,1,'启用'),(3,'延伸医疗','img/nav.png','navs',NULL,1,'启用'),(4,'综合查询','img/nav.png','navs',NULL,1,'启用'),(5,'便民门诊','img/nav.png','navs',NULL,1,'启用'),(6,'检验开单','img/nav.png','navs',NULL,1,'启用'),(7,'核酸开单','img/nav.png','navs',NULL,1,'启用'),(8,'核酸报告','img/nav.png','navs',NULL,1,'启用'),(9,'候诊查询',NULL,'门诊服务',NULL,1,'启用'),(10,'在线签到',NULL,'门诊服务',NULL,1,'启用'),(11,'门诊充值',NULL,'门诊服务',NULL,1,'启用'),(12,'门诊缴费',NULL,'门诊服务',NULL,1,'启用'),(13,'报告查询',NULL,'门诊服务',NULL,1,'启用'),(14,'门诊费用',NULL,'门诊服务',NULL,1,'启用'),(15,'门诊退费',NULL,'门诊服务',NULL,1,'启用'),(16,'核酸开单',NULL,'门诊服务',NULL,1,'启用'),(17,'检验开单',NULL,'门诊服务',NULL,1,'启用'),(20,'病案预约','','住院服务','',1,'启用'),(21,'病案预约1231',NULL,'住院服务',NULL,1,'禁用'),(22,'阿斯蒂芬份//123//',NULL,NULL,NULL,NULL,NULL),(23,'阿斯蒂芬份//123//665',NULL,NULL,NULL,NULL,NULL),(24,'阿斯蒂芬份//123//665斯蒂芬啊',NULL,NULL,NULL,1,'启用'),(25,'阿斯蒂芬份//12蒂芬啊',NULL,NULL,NULL,1,'启用'),(26,'阿斯蒂芬份//12蒂芬',NULL,NULL,NULL,1,'启用'),(27,'病案预约上传一个图片','1653724228405.jpg',NULL,NULL,1,'启用'),(28,'病案预约上传一个图片123123',NULL,NULL,NULL,1,'启用'),(29,'病案预约上29???',NULL,NULL,NULL,1,'启用'),(30,'病案预约12312','1653724869357.jpg',NULL,NULL,1,'启用');
/*!40000 ALTER TABLE `nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '患者id',
  `patient_name` varchar(20) NOT NULL COMMENT '患者名称',
  `patient_card_id` varchar(18) DEFAULT NULL COMMENT '患者身份证号',
  `patient_born_date` int(11) DEFAULT NULL COMMENT '患者出生日期',
  `patient_sex` enum('男','女') DEFAULT NULL COMMENT '患者性别',
  `patient_phone` int(11) DEFAULT NULL COMMENT '患者手机',
  `patient_medical_card` int(10) DEFAULT NULL COMMENT '患者就诊卡号',
  `patient_avatar` varchar(255) NOT NULL COMMENT '患者头像',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay`
--

DROP TABLE IF EXISTS `pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay` (
  `pay_id` int(11) NOT NULL COMMENT '缴费id',
  `pay_datetime` datetime(3) NOT NULL COMMENT '缴费时间',
  `pay_money` float(11,0) NOT NULL COMMENT '缴费金额',
  `pay_type` varchar(255) NOT NULL COMMENT '缴费类型',
  `pay_status` varchar(255) NOT NULL COMMENT '缴费状态',
  `patient_id` int(11) NOT NULL COMMENT '缴费患者id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门诊缴费记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay`
--

LOCK TABLES `pay` WRITE;
/*!40000 ALTER TABLE `pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `praise`
--

DROP TABLE IF EXISTS `praise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `praise` (
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `patient_id` int(11) NOT NULL COMMENT '患者id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章点赞表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `praise`
--

LOCK TABLES `praise` WRITE;
/*!40000 ALTER TABLE `praise` DISABLE KEYS */;
INSERT INTO `praise` VALUES (1,2),(1,1);
/*!40000 ALTER TABLE `praise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `patient_id` int(11) NOT NULL COMMENT '患者id',
  `doctor_id` int(11) NOT NULL COMMENT '医生id',
  `department_id` int(11) NOT NULL COMMENT '科室编号',
  `clinic_id` int(11) NOT NULL COMMENT '门诊编号',
  `datetime` datetime(3) NOT NULL COMMENT '预约时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='患者预约表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hospital'
--

--
-- Dumping routines for database 'hospital'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-30 11:15:12
