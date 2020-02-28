-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: cs5200-spring2020-a2.ccgpqnp6qpps.us-east-2.rds.amazonaws.com    Database: A2_dataset
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(225) DEFAULT NULL,
  `street2` varchar(225) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `address_primary` tinyint(4) DEFAULT NULL,
  `address_person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `address_person_id_idx` (`address_person_id`),
  CONSTRAINT `address_person_id` FOREIGN KEY (`address_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `developer`
--

DROP TABLE IF EXISTS `developer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `developer` (
  `developer_id` int(11) NOT NULL AUTO_INCREMENT,
  `developer_key` varchar(45) DEFAULT NULL,
  `developer_personid` int(11) DEFAULT NULL,
  PRIMARY KEY (`developer_id`),
  KEY `developer_personid_idx` (`developer_personid`),
  CONSTRAINT `developer_personid` FOREIGN KEY (`developer_personid`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developer`
--

LOCK TABLES `developer` WRITE;
/*!40000 ALTER TABLE `developer` DISABLE KEYS */;
/*!40000 ALTER TABLE `developer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page` (
  `page_id` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `websitepid` int(11) DEFAULT NULL,
  PRIMARY KEY (`page_id`),
  KEY `websitepid_idx` (`websitepid`),
  CONSTRAINT `websitepid` FOREIGN KEY (`websitepid`) REFERENCES `website` (`website_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page`
--

LOCK TABLES `page` WRITE;
/*!40000 ALTER TABLE `page` DISABLE KEYS */;
/*!40000 ALTER TABLE `page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page_priviledge`
--

DROP TABLE IF EXISTS `page_priviledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page_priviledge` (
  `pagepid` int(11) NOT NULL AUTO_INCREMENT,
  `pagepriviledgeid` varchar(45) DEFAULT NULL,
  `ppdeveloperid` int(11) DEFAULT NULL,
  `pppageid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pagepid`),
  KEY `ppdeveloperid_idx` (`ppdeveloperid`),
  KEY `pppageid_idx` (`pppageid`),
  KEY `pagepriviledge_idx` (`pagepriviledgeid`),
  CONSTRAINT `pagepriviledge` FOREIGN KEY (`pagepriviledgeid`) REFERENCES `priviledge` (`priviledge_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ppdeveloperid` FOREIGN KEY (`ppdeveloperid`) REFERENCES `developer` (`developer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pppageid` FOREIGN KEY (`pppageid`) REFERENCES `page` (`page_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_priviledge`
--

LOCK TABLES `page_priviledge` WRITE;
/*!40000 ALTER TABLE `page_priviledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `page_priviledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page_role`
--

DROP TABLE IF EXISTS `page_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page_role` (
  `pagerid` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `developer_id` int(11) DEFAULT NULL,
  `page_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pagerid`),
  KEY `role_id_idx` (`role_id`),
  KEY `developer_id_idx` (`developer_id`),
  KEY `page_id_idx` (`page_id`),
  CONSTRAINT `developer_id` FOREIGN KEY (`developer_id`) REFERENCES `developer` (`developer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `page_id` FOREIGN KEY (`page_id`) REFERENCES `page` (`page_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_role`
--

LOCK TABLES `page_role` WRITE;
/*!40000 ALTER TABLE `page_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `page_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`haolin`@`%`*/ /*!50003 TRIGGER `A2_dataset`.`page_role_AFTER_INSERT` AFTER INSERT ON `page_role` FOR EACH ROW
BEGIN
	set @var = new.developer_id;
    set @var2 = new.page_id;
	IF new.role_id = 1 then
		/*update website_priviledge set webpriviledge = 1234;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,1234,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("create", @var, @var2);
        #INSERT into page_priviledge(pagepriviledgeid,ppdeveloperid) values (1,@var);
        #INSERT into page_priviledge(ppdeveloperid) select developer_id from page_role;
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("update", @var, @var2);
	ELSEIF new.role_id = 2 then
		/*update website_priviledge set webpriviledge = 1234;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,1234,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("create", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("update", @var, @var2);
        #INSERT into page_priviledge(ppdeveloperid) select developer_id from page_role;
	ELSEIF new.role_id = 3 then
		/*update website_priviledge set webpriviledge = 123;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,123,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("create", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        #INSERT into page_priviledge(ppdeveloperid) select developer_id from page_role;
	ELSEIF new.role_id = 4 then
		/*update website_priviledge set webpriviledge = 23;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,23,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        #INSERT into page_priviledge(ppdeveloperid) select developer_id from page_role;
	ELSEIF new.role_id = 5 then
		/*update website_priviledge set webpriviledge = 3;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,3,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        #INSERT into page_priviledge(ppdeveloperid) select developer_id from page_role;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`haolin`@`%`*/ /*!50003 TRIGGER `A2_dataset`.`page_role_AFTER_UPDATE` AFTER UPDATE ON `page_role` FOR EACH ROW
BEGIN
	set @var = new.developer_id;
    set @var2 = new.page_id;
    delete from page_priviledge where ppdeveloperid = @var;
	IF new.role_id = 1 then
		/*update website_priviledge set webpriviledge = 1234;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,1234,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("create", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("update", @var, @var2);
	ELSEIF new.role_id = 2 then
		/*update website_priviledge set webpriviledge = 1234;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,1234,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("create", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("update", @var, @var2);
	ELSEIF new.role_id = 3 then
		/*update website_priviledge set webpriviledge = 123;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,123,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("create", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
	ELSEIF new.role_id = 4 then
		/*update website_priviledge set webpriviledge = 23;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,23,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("delete", @var, @var2);
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
	ELSEIF new.role_id = 5 then
		/*update website_priviledge set webpriviledge = 3;*/
        /*INSERT into page_priviledge(pagepid,pagepriviledge,developerppid,pppageid) values (new.pagepid,3,new.developerppid,new.pppageid);*/
        INSERT into page_priviledge(pagepriviledgeid, ppdeveloperid, pppageid) values ("read", @var, @var2);
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`haolin`@`%`*/ /*!50003 TRIGGER `A2_dataset`.`page_role_AFTER_DELETE` AFTER DELETE ON `page_role` FOR EACH ROW
BEGIN
	set @var = old.developer_id;
    delete from page_priviledge where ppdeveloperid = @var;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone` (
  `phone_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(45) DEFAULT NULL,
  `phone_primary` tinyint(4) DEFAULT NULL,
  `pho_person_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`phone_id`),
  KEY `pho_person_id_idx` (`pho_person_id`),
  CONSTRAINT `pho_person_id` FOREIGN KEY (`pho_person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `priviledge`
--

DROP TABLE IF EXISTS `priviledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `priviledge` (
  `priviledge_name` varchar(45) NOT NULL,
  PRIMARY KEY (`priviledge_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `priviledge`
--

LOCK TABLES `priviledge` WRITE;
/*!40000 ALTER TABLE `priviledge` DISABLE KEYS */;
INSERT INTO `priviledge` VALUES ('create'),('delete'),('read'),('update');
/*!40000 ALTER TABLE `priviledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'owner'),(2,'admin'),(3,'writer'),(4,'editor'),(5,'reviewer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_agreement` varchar(45) DEFAULT NULL,
  `user_personid` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_personid_idx` (`user_personid`),
  CONSTRAINT `user_personid` FOREIGN KEY (`user_personid`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `website`
--

DROP TABLE IF EXISTS `website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `website` (
  `website_id` int(11) NOT NULL AUTO_INCREMENT,
  `wname` varchar(45) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `creates` date DEFAULT NULL,
  `wupdates` date DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  `developerwebid` int(11) DEFAULT NULL,
  PRIMARY KEY (`website_id`),
  KEY `developerwebid_idx` (`developerwebid`),
  CONSTRAINT `developerwebid` FOREIGN KEY (`developerwebid`) REFERENCES `developer` (`developer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website`
--

LOCK TABLES `website` WRITE;
/*!40000 ALTER TABLE `website` DISABLE KEYS */;
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `website_priviledge`
--

DROP TABLE IF EXISTS `website_priviledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `website_priviledge` (
  `webpid` int(11) NOT NULL AUTO_INCREMENT,
  `webpriviledge` varchar(45) DEFAULT NULL,
  `developerid` int(11) DEFAULT NULL,
  `wpwebsiteid` int(11) DEFAULT NULL,
  PRIMARY KEY (`webpid`),
  KEY `webpriviledge_idx` (`webpriviledge`),
  KEY `developerid_idx` (`developerid`),
  KEY `wpwebsiteid_idx` (`wpwebsiteid`),
  CONSTRAINT `developerid` FOREIGN KEY (`developerid`) REFERENCES `developer` (`developer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `webpriviledge` FOREIGN KEY (`webpriviledge`) REFERENCES `priviledge` (`priviledge_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wpwebsiteid` FOREIGN KEY (`wpwebsiteid`) REFERENCES `website` (`website_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website_priviledge`
--

LOCK TABLES `website_priviledge` WRITE;
/*!40000 ALTER TABLE `website_priviledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `website_priviledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `website_role`
--

DROP TABLE IF EXISTS `website_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `website_role` (
  `webrid` int(11) NOT NULL AUTO_INCREMENT,
  `webrole` int(11) DEFAULT NULL,
  `developer_wid` int(11) DEFAULT NULL,
  `wrwebsite_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`webrid`),
  KEY `webrole_idx` (`webrole`),
  KEY `developer_wid_idx` (`developer_wid`),
  KEY `wrwebsite_id_idx` (`wrwebsite_id`),
  CONSTRAINT `developer_wid` FOREIGN KEY (`developer_wid`) REFERENCES `developer` (`developer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `webrole` FOREIGN KEY (`webrole`) REFERENCES `role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `wrwebsite_id` FOREIGN KEY (`wrwebsite_id`) REFERENCES `website` (`website_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website_role`
--

LOCK TABLES `website_role` WRITE;
/*!40000 ALTER TABLE `website_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `website_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`haolin`@`%`*/ /*!50003 TRIGGER `A2_dataset`.`website_role_AFTER_INSERT` AFTER INSERT ON `website_role` FOR EACH ROW
BEGIN
	set @var = new.developer_wid;
    set @var2 = new.wrwebsite_id;
    IF new.webrole = 1 then
		/*update website_priviledge set webpriviledge = 1234;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("create",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("update",@var,@var2);
	ELSEIF new.webrole = 2 then
		/*update website_priviledge set webpriviledge = 1234;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("create",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("update",@var,@var2);
	ELSEIF new.webrole = 3 then
		/*update website_priviledge set webpriviledge = 123;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("create",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
	ELSEIF new.webrole = 4 then
		/*update website_priviledge set webpriviledge = 23;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
	ELSEIF new.webrole = 5 then
		/*update website_priviledge set webpriviledge = 3;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`haolin`@`%`*/ /*!50003 TRIGGER `A2_dataset`.`website_role_AFTER_UPDATE` AFTER UPDATE ON `website_role` FOR EACH ROW
BEGIN
	set @var = new.developer_wid;
	set @var2 = new.wrwebsite_id;
	delete from website_priviledge where developerid = @var;
    IF new.webrole = 1 then
		/*update website_priviledge set webpriviledge = 1234;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("create",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("update",@var,@var2);
	ELSEIF new.webrole = 2 then
		/*update website_priviledge set webpriviledge = 1234;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("create",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("update",@var,@var2);
	ELSEIF new.webrole = 3 then
		/*update website_priviledge set webpriviledge = 123;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("create",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
	ELSEIF new.webrole = 4 then
		/*update website_priviledge set webpriviledge = 23;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("delete",@var,@var2);
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
	ELSEIF new.webrole = 5 then
		/*update website_priviledge set webpriviledge = 3;*/
        INSERT into website_priviledge(webpriviledge,developerid,wpwebsiteid) values ("read",@var,@var2);
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`haolin`@`%`*/ /*!50003 TRIGGER `A2_dataset`.`website_role_AFTER_DELETE` AFTER DELETE ON `website_role` FOR EACH ROW
BEGIN
	set @var = old.developer_wid;
    delete from website_priviledge where developerid = @var;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `widget`
--

DROP TABLE IF EXISTS `widget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `widget` (
  `widget_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `cssClass` varchar(45) DEFAULT NULL,
  `cssStyle` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `src` varchar(225) DEFAULT NULL,
  `html` varchar(225) DEFAULT NULL,
  `url` varchar(225) DEFAULT NULL,
  `sharble` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  `Dtype` varchar(45) DEFAULT NULL,
  `pageid` int(11) DEFAULT NULL,
  PRIMARY KEY (`widget_id`),
  KEY `pageid_idx` (`pageid`),
  CONSTRAINT `pageid` FOREIGN KEY (`pageid`) REFERENCES `page` (`page_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `widget`
--

LOCK TABLES `widget` WRITE;
/*!40000 ALTER TABLE `widget` DISABLE KEYS */;
/*!40000 ALTER TABLE `widget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'A2_dataset'
--

--
-- Dumping routines for database 'A2_dataset'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 21:41:46
