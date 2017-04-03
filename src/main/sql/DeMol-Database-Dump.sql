-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.0.188    Database: javaexpertsDB
-- ------------------------------------------------------
-- Server version	5.5.53-MariaDB

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
-- Table structure for table `Aflevering`
--

DROP TABLE IF EXISTS `Aflevering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Aflevering` (
  `nummer` int(11) NOT NULL,
  `vertrekkende_kandidaat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`nummer`),
  KEY `FKeys9qwo7b20x8no5icsh9p5yv` (`vertrekkende_kandidaat_id`),
  CONSTRAINT `FKeys9qwo7b20x8no5icsh9p5yv` FOREIGN KEY (`vertrekkende_kandidaat_id`) REFERENCES `Kandidaat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aflevering`
--

LOCK TABLES `Aflevering` WRITE;
/*!40000 ALTER TABLE `Aflevering` DISABLE KEYS */;
INSERT INTO `Aflevering` VALUES (1,NULL),(2,NULL),(3,NULL),(4,NULL),(5,NULL),(7,NULL),(8,NULL),(6,1);
/*!40000 ALTER TABLE `Aflevering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Aflevering_Vraag`
--

DROP TABLE IF EXISTS `Aflevering_Vraag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Aflevering_Vraag` (
  `aflevering_id` int(11) NOT NULL,
  `vraag_id` bigint(20) NOT NULL,
  `volgorde` int(11) NOT NULL,
  PRIMARY KEY (`aflevering_id`,`volgorde`),
  KEY `FKhuvwtqr2hx8vfxfocqayqru2k` (`vraag_id`),
  CONSTRAINT `FKcem4wxme7wagvu06ntlswbcoh` FOREIGN KEY (`aflevering_id`) REFERENCES `Aflevering` (`nummer`),
  CONSTRAINT `FKhuvwtqr2hx8vfxfocqayqru2k` FOREIGN KEY (`vraag_id`) REFERENCES `Vraag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aflevering_Vraag`
--

LOCK TABLES `Aflevering_Vraag` WRITE;
/*!40000 ALTER TABLE `Aflevering_Vraag` DISABLE KEYS */;
INSERT INTO `Aflevering_Vraag` VALUES (2,1,1),(4,1,1),(6,1,1),(8,1,1),(1,2,1),(3,2,1),(5,2,1),(7,2,1),(1,3,0),(2,3,0),(3,3,0),(4,3,0),(5,3,0),(6,3,0),(7,3,0),(8,3,0);
/*!40000 ALTER TABLE `Aflevering_Vraag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Antwoord`
--

DROP TABLE IF EXISTS `Antwoord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Antwoord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `antwoord` varchar(255) DEFAULT NULL,
  `aflevering_nummer` int(11) DEFAULT NULL,
  `kandidaat_id` bigint(20) DEFAULT NULL,
  `vraag_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKev4h8nxtc1tbyleh6k8rlr1om` (`aflevering_nummer`),
  KEY `FKjg4770g5pr6pq0jf28o2r5vuk` (`kandidaat_id`),
  KEY `FK8mhl2b238dqkf25mukgkax9fu` (`vraag_id`),
  CONSTRAINT `FK8mhl2b238dqkf25mukgkax9fu` FOREIGN KEY (`vraag_id`) REFERENCES `Vraag` (`id`),
  CONSTRAINT `FKev4h8nxtc1tbyleh6k8rlr1om` FOREIGN KEY (`aflevering_nummer`) REFERENCES `Aflevering` (`nummer`),
  CONSTRAINT `FKjg4770g5pr6pq0jf28o2r5vuk` FOREIGN KEY (`kandidaat_id`) REFERENCES `Kandidaat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Antwoord`
--

LOCK TABLES `Antwoord` WRITE;
/*!40000 ALTER TABLE `Antwoord` DISABLE KEYS */;
INSERT INTO `Antwoord` VALUES (1,'Foutief',1,1,3),(2,'Robin',1,2,3),(3,'Foutief',1,3,3),(4,'Foutief',1,4,3),(5,'Foutief',1,5,3),(6,'Foutief',1,1,2),(7,'true',1,2,2),(8,'Foutief',1,3,2),(9,'Foutief',1,4,2),(10,'Foutief',1,5,2),(11,'Foutief',2,1,3),(12,'Robin',2,2,3),(13,'Foutief',2,3,3),(14,'Foutief',2,4,3),(15,'Foutief',2,5,3),(16,'Foutief',2,1,1),(17,'false',2,2,1),(18,'Foutief',2,3,1),(19,'Foutief',2,4,1),(20,'Foutief',2,5,1),(21,'Foutief',3,1,3),(22,'Robin',3,2,3),(23,'Foutief',3,3,3),(24,'Foutief',3,4,3),(25,'Foutief',3,5,3),(26,'Foutief',3,1,2),(27,'true',3,2,2),(28,'Foutief',3,3,2),(29,'Foutief',3,4,2),(30,'Foutief',3,5,2),(31,'Foutief',4,1,3),(32,'Robin',4,2,3),(33,'Foutief',4,3,3),(34,'Foutief',4,4,3),(35,'Foutief',4,5,3),(36,'Foutief',4,1,1),(37,'false',4,2,1),(38,'Foutief',4,3,1),(39,'Foutief',4,4,1),(40,'Foutief',4,5,1),(41,'Foutief',5,1,3),(42,'Robin',5,2,3),(43,'Foutief',5,3,3),(44,'Foutief',5,4,3),(45,'Foutief',5,5,3),(46,'Foutief',5,1,2),(47,'true',5,2,2),(48,'Foutief',5,3,2),(49,'Foutief',5,4,2),(50,'Foutief',5,5,2),(51,'Foutief',6,1,3),(52,'Robin',6,2,3),(53,'Foutief',6,3,3),(54,'Foutief',6,4,3),(55,'Foutief',6,5,3),(56,'Foutief',6,1,1),(57,'false',6,2,1),(58,'Foutief',6,3,1),(59,'Foutief',6,4,1),(60,'Foutief',6,5,1),(61,'Foutief',7,1,3),(62,'Robin',7,2,3),(63,'Foutief',7,3,3),(64,'Foutief',7,4,3),(65,'Foutief',7,5,3),(66,'Foutief',7,1,2),(67,'true',7,2,2),(68,'Foutief',7,3,2),(69,'Foutief',7,4,2),(70,'Foutief',7,5,2),(71,'Foutief',8,1,3),(72,'Robin',8,2,3),(73,'Foutief',8,3,3),(74,'Foutief',8,4,3),(75,'Foutief',8,5,3),(76,'Foutief',8,1,1),(77,'false',8,2,1),(78,'Foutief',8,3,1),(79,'Foutief',8,4,1),(80,'Foutief',8,5,1);
/*!40000 ALTER TABLE `Antwoord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GeslotenVraag`
--

DROP TABLE IF EXISTS `GeslotenVraag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GeslotenVraag` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKodukcx92kkrqx0p9pokuq9v3i` FOREIGN KEY (`id`) REFERENCES `Vraag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GeslotenVraag`
--

LOCK TABLES `GeslotenVraag` WRITE;
/*!40000 ALTER TABLE `GeslotenVraag` DISABLE KEYS */;
INSERT INTO `GeslotenVraag` VALUES (1),(2);
/*!40000 ALTER TABLE `GeslotenVraag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Kandidaat`
--

DROP TABLE IF EXISTS `Kandidaat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Kandidaat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `beroep` varchar(255) DEFAULT NULL,
  `beste_eigenschap` varchar(255) DEFAULT NULL,
  `foto` longblob,
  `geboortedatum` date DEFAULT NULL,
  `hobbys` varchar(255) DEFAULT NULL,
  `identificeert_zich_met` varchar(255) DEFAULT NULL,
  `lievelingsartiest` varchar(255) DEFAULT NULL,
  `lievingseten` varchar(255) DEFAULT NULL,
  `slechts_eigenschap` varchar(255) DEFAULT NULL,
  `voornaam` varchar(255) DEFAULT NULL,
  `woonplaats` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Kandidaat`
--

LOCK TABLES `Kandidaat` WRITE;
/*!40000 ALTER TABLE `Kandidaat` DISABLE KEYS */;
INSERT INTO `Kandidaat` VALUES (1,'Showroomadviseur','Sociaal',NULL,'1992-07-02','Joggen, bowlen, jetskiën, wakeboarden, denkspelletjes, kubben','Hond','Flogging Molly','Spaghetti vongole','Uitstelgedrag','Sam','Hamont-Achel'),(2,'Leerkracht godsdienst','Hulpvaardig',NULL,'1958-04-19','Koken, feestjes geven, organiseren van kwissen',NULL,'Bruce Springsteen','Salades (Griekse, niçoise)','Overdrijven','Annelies','Schoten'),(3,'Houtbewerker','Oprechtheid',NULL,'1988-03-07','Moto\'s, interieur, muziek, festivals','Tonijn','Ryan Adams','Pistolets','Oprechtheid','Davey','Onze-Lieve-Vrouw-Waver'),(4,'Politie-inspecteur','Assertief',NULL,'1992-04-24','Voetbal, sport algemeen, monitor out of limits','Labrador','Ed Sheeran','Frieten met steak en pepersaus','Onverdraagzaam','Eline','Overmere'),(5,'Laborant','Ondernemend',NULL,'1973-06-29','Tennis, basketbal, lopen','Giraf','INXS','Pasta','Snel ontgoocheld in iemand','Robin','Holsbeek');
/*!40000 ALTER TABLE `Kandidaat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KeuzeVraag`
--

DROP TABLE IF EXISTS `KeuzeVraag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KeuzeVraag` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKbqkabppdiqjq07tlrw78ssr73` FOREIGN KEY (`id`) REFERENCES `Vraag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KeuzeVraag`
--

LOCK TABLES `KeuzeVraag` WRITE;
/*!40000 ALTER TABLE `KeuzeVraag` DISABLE KEYS */;
INSERT INTO `KeuzeVraag` VALUES (3);
/*!40000 ALTER TABLE `KeuzeVraag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KeuzeVraagAntwoorden`
--

DROP TABLE IF EXISTS `KeuzeVraagAntwoorden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KeuzeVraagAntwoorden` (
  `keuzevraag_id` bigint(20) NOT NULL,
  `antwoord` varchar(255) DEFAULT NULL,
  KEY `FK5vibdtmuw1vi59a6pbi4j5bau` (`keuzevraag_id`),
  CONSTRAINT `FK5vibdtmuw1vi59a6pbi4j5bau` FOREIGN KEY (`keuzevraag_id`) REFERENCES `KeuzeVraag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KeuzeVraagAntwoorden`
--

LOCK TABLES `KeuzeVraagAntwoorden` WRITE;
/*!40000 ALTER TABLE `KeuzeVraagAntwoorden` DISABLE KEYS */;
/*!40000 ALTER TABLE `KeuzeVraagAntwoorden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Opdracht`
--

DROP TABLE IF EXISTS `Opdracht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Opdracht` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `omschrijving` varchar(255) DEFAULT NULL,
  `plaats` varchar(255) DEFAULT NULL,
  `aflevering_nummer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqjfbuh1uw6eie3lgtx8uo3ms` (`aflevering_nummer`),
  CONSTRAINT `FKqjfbuh1uw6eie3lgtx8uo3ms` FOREIGN KEY (`aflevering_nummer`) REFERENCES `Aflevering` (`nummer`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Opdracht`
--

LOCK TABLES `Opdracht` WRITE;
/*!40000 ALTER TABLE `Opdracht` DISABLE KEYS */;
INSERT INTO `Opdracht` VALUES (1,'Opdracht','KAAPSTAD',1),(2,'Opdracht','ANTWERPEN',2),(3,'Opdracht','KAAPSTAD',3),(4,'Opdracht','KAAPSTAD',4),(5,'Opdracht','KAAPSTAD',5),(6,'Opdracht','KAAPSTAD',6),(7,'Opdracht','KAAPSTAD',7),(8,'Opdracht','JOHANNESBURG',8);
/*!40000 ALTER TABLE `Opdracht` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vraag`
--

DROP TABLE IF EXISTS `Vraag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vraag` (
  `soort` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `correct_antwoord` varchar(255) DEFAULT NULL,
  `vraagstelling` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vraag`
--

LOCK TABLES `Vraag` WRITE;
/*!40000 ALTER TABLE `Vraag` DISABLE KEYS */;
INSERT INTO `Vraag` VALUES ('GESLOTEN',1,'false','Had De Mol de walkie-talkie tijdens de opdracht?'),('GESLOTEN',2,'true','Zat De Mol in de auto tijdens de opdracht?'),('KEUZE',3,'Robin','Wie is De Mol?');
/*!40000 ALTER TABLE `Vraag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-20 19:08:20
