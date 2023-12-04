-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: acuioximetro
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Dumping data for table `acuicolas`
--

LOCK TABLES `acuicolas` WRITE;
/*!40000 ALTER TABLE `acuicolas` DISABLE KEYS */;
INSERT INTO `acuicolas` VALUES ('1','Pisiciola','la ye',1007196987,1);
/*!40000 ALTER TABLE `acuicolas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `especies`
--

LOCK TABLES `especies` WRITE;
/*!40000 ALTER TABLE `especies` DISABLE KEYS */;
INSERT INTO `especies` VALUES (1,'Cachama');
/*!40000 ALTER TABLE `especies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estanques`
--

LOCK TABLES `estanques` WRITE;
/*!40000 ALTER TABLE `estanques` DISABLE KEYS */;
INSERT INTO `estanques` VALUES (1,1,'Geomenbrana',1000),(2,1,'Geomenbrana',1200),(3,1,'Geomenbrana',1000);
/*!40000 ALTER TABLE `estanques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historia_oxigeno`
--

LOCK TABLES `historia_oxigeno` WRITE;
/*!40000 ALTER TABLE `historia_oxigeno` DISABLE KEYS */;
INSERT INTO `historia_oxigeno` VALUES (1,6.2,'2023-10-10 08:00:00'),(1,6.2,'2023-10-10 08:00:00'),(1,5.5,'2023-10-10 08:30:00'),(1,7.1,'2023-10-10 09:00:00'),(1,4.8,'2023-10-10 09:30:00'),(1,6.4,'2023-10-10 10:00:00'),(1,5.9,'2023-10-10 10:30:00'),(1,7.6,'2023-10-10 11:00:00'),(1,4.3,'2023-10-10 11:30:00'),(1,6.8,'2023-10-10 12:00:00'),(1,5.1,'2023-10-10 12:30:00');
/*!40000 ALTER TABLE `historia_oxigeno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (100982812,'Usuario','Angelica','Corzo','prueba@gmail.com','12345',NULL),(1007196987,'Administrador','Angel','Corzo','angel@gmail.com','12345',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-03 19:41:54
