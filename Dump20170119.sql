-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_abugauch
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `actuallycondition`
--

DROP TABLE IF EXISTS `actuallycondition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actuallycondition` (
  `temp` int(11) NOT NULL,
  `wind_idWind` varchar(50) NOT NULL,
  `atmosphere_idAtmosphere` varchar(50) NOT NULL,
  `weather_idWeather` varchar(50) NOT NULL,
  `state_name` char(1) NOT NULL,
  `state_country_name` varchar(50) NOT NULL,
  `day_day` int(11) NOT NULL,
  `day_month` int(11) NOT NULL,
  `day_year` int(11) NOT NULL,
  PRIMARY KEY (`state_name`,`state_country_name`,`day_day`,`day_month`,`day_year`),
  KEY `fk_actuallyCondition_wind1_idx` (`wind_idWind`),
  KEY `fk_actuallyCondition_atmosphere1_idx` (`atmosphere_idAtmosphere`),
  KEY `fk_actuallyCondition_weather1_idx` (`weather_idWeather`),
  KEY `fk_actuallyCondition_state1_idx` (`state_name`,`state_country_name`),
  KEY `fk_actuallyCondition_day1_idx` (`day_day`,`day_month`,`day_year`),
  CONSTRAINT `fk_actuallyCondition_atmosphere1` FOREIGN KEY (`atmosphere_idAtmosphere`) REFERENCES `atmosphere` (`idAtmosphere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_day1` FOREIGN KEY (`day_day`, `day_month`, `day_year`) REFERENCES `day` (`day`, `month`, `year`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_state1` FOREIGN KEY (`state_name`, `state_country_name`) REFERENCES `state` (`name`, `country_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_weather1` FOREIGN KEY (`weather_idWeather`) REFERENCES `weather` (`idWeather`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_wind1` FOREIGN KEY (`wind_idWind`) REFERENCES `wind` (`idWind`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actuallycondition`
--

LOCK TABLES `actuallycondition` WRITE;
/*!40000 ALTER TABLE `actuallycondition` DISABLE KEYS */;
/*!40000 ALTER TABLE `actuallycondition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atmosphere`
--

DROP TABLE IF EXISTS `atmosphere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atmosphere` (
  `idAtmosphere` varchar(50) NOT NULL,
  `humidity` int(11) DEFAULT NULL,
  `presseaure` double DEFAULT NULL,
  `rising` int(11) DEFAULT NULL,
  `visibility` double DEFAULT NULL,
  PRIMARY KEY (`idAtmosphere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atmosphere`
--

LOCK TABLES `atmosphere` WRITE;
/*!40000 ALTER TABLE `atmosphere` DISABLE KEYS */;
/*!40000 ALTER TABLE `atmosphere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `alpha3_code` varchar(3) NOT NULL,
  `name` varchar(50) NOT NULL,
  `alpha2_code` varchar(2) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day`
--

DROP TABLE IF EXISTS `day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day` (
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`day`,`month`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day`
--

LOCK TABLES `day` WRITE;
/*!40000 ALTER TABLE `day` DISABLE KEYS */;
/*!40000 ALTER TABLE `day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extendedcondition`
--

DROP TABLE IF EXISTS `extendedcondition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extendedcondition` (
  `extendedDate` int(11) NOT NULL,
  `high` int(11) NOT NULL,
  `low` int(11) NOT NULL,
  `weather_idWeather` varchar(50) NOT NULL,
  `actuallyCondition_state_name` char(1) NOT NULL,
  `actuallyCondition_state_country_name` varchar(50) NOT NULL,
  `actuallyCondition_day_day` int(11) NOT NULL,
  `actuallyCondition_day_month` int(11) NOT NULL,
  `actuallyCondition_day_year` int(11) NOT NULL,
  PRIMARY KEY (`extendedDate`,`actuallyCondition_state_name`,`actuallyCondition_state_country_name`,`actuallyCondition_day_day`,`actuallyCondition_day_month`,`actuallyCondition_day_year`),
  KEY `fk_extendedCondition_weather1_idx` (`weather_idWeather`),
  KEY `fk_extendedCondition_actuallyCondition1_idx` (`actuallyCondition_state_name`,`actuallyCondition_state_country_name`,`actuallyCondition_day_day`,`actuallyCondition_day_month`,`actuallyCondition_day_year`),
  CONSTRAINT `fk_extendedCondition_actuallyCondition1` FOREIGN KEY (`actuallyCondition_state_name`, `actuallyCondition_state_country_name`, `actuallyCondition_day_day`, `actuallyCondition_day_month`, `actuallyCondition_day_year`) REFERENCES `actuallycondition` (`state_name`, `state_country_name`, `day_day`, `day_month`, `day_year`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_extendedCondition_weather1` FOREIGN KEY (`weather_idWeather`) REFERENCES `weather` (`idWeather`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extendedcondition`
--

LOCK TABLES `extendedcondition` WRITE;
/*!40000 ALTER TABLE `extendedcondition` DISABLE KEYS */;
/*!40000 ALTER TABLE `extendedcondition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `name` char(1) NOT NULL,
  `abbr` char(10) NOT NULL,
  `area` int(11) NOT NULL,
  `capital` char(1) NOT NULL,
  `country_name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`,`country_name`),
  KEY `fk_state_country1_idx` (`country_name`),
  CONSTRAINT `fk_state_country1` FOREIGN KEY (`country_name`) REFERENCES `country` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weather`
--

DROP TABLE IF EXISTS `weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weather` (
  `idWeather` varchar(50) NOT NULL,
  `description` char(1) DEFAULT NULL,
  PRIMARY KEY (`idWeather`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weather`
--

LOCK TABLES `weather` WRITE;
/*!40000 ALTER TABLE `weather` DISABLE KEYS */;
/*!40000 ALTER TABLE `weather` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wind`
--

DROP TABLE IF EXISTS `wind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wind` (
  `idWind` varchar(50) NOT NULL,
  `chill` int(11) DEFAULT NULL,
  `direction` int(11) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  PRIMARY KEY (`idWind`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wind`
--

LOCK TABLES `wind` WRITE;
/*!40000 ALTER TABLE `wind` DISABLE KEYS */;
/*!40000 ALTER TABLE `wind` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-19 14:07:16
