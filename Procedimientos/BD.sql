CREATE DATABASE  IF NOT EXISTS `bdrepuestos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdrepuestos`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: bdrepuestos
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `Clicodigo` int NOT NULL AUTO_INCREMENT,
  `Clinombre` varchar(45) DEFAULT NULL,
  `RTN` varchar(17) DEFAULT NULL,
  `Clitelefono` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Cliestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Clicodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Ataraxia Horan','08011999161672','975236844','ACT'),(2,'Lina Gryski','1203199752637','25478963','ACT'),(3,'0801199918870','Francisco Godoy','78523698','INA'),(4,'Virginia Zelaya','12563478','1503196500905','ACT'),(5,'Elsa Pato','44885566','1875200197853','ACT'),(6,'Maria La del Barrio','1523647895236','125634789','ACT'),(7,'Tama Rindo','42365879','1896452397800','ACT'),(8,'Karla Medina','1520200378526','84844747','ACT'),(9,'Jules Zelaya','0801-1999-161678','97435256','ACT');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `Comcodigo` int NOT NULL AUTO_INCREMENT,
  `Comfechaped` date NOT NULL,
  `Comfechaent` date NOT NULL,
  `Procodigo` int NOT NULL,
  `TipoPago` varchar(45) NOT NULL,
  PRIMARY KEY (`Comcodigo`),
  KEY `Procodigo_idx` (`Procodigo`),
  CONSTRAINT `Procodigoss` FOREIGN KEY (`Procodigo`) REFERENCES `proveedores` (`Procodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `Concodigo` int NOT NULL AUTO_INCREMENT,
  `Connombre` varchar(45) DEFAULT NULL,
  `Contelefono` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Concorreo` varchar(100) DEFAULT NULL,
  `Procodigo` int NOT NULL,
  `Conestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Concodigo`),
  KEY `Procodigofkco_idx` (`Procodigo`),
  CONSTRAINT `Procodigofkco` FOREIGN KEY (`Procodigo`) REFERENCES `proveedores` (`Procodigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Kevin Espinal','25687413','kref004@gmail.com',3,'ACT'),(2,'Francisco Godoy','25547896','fgodoy044@yahoo.com',1,'ACT');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallecompra` (
  `Comcodigo` int NOT NULL,
  `Prodcodigo` int NOT NULL,
  `Detcompracantidadped` int DEFAULT NULL,
  `Detcompracantidadrec` int NOT NULL,
  `Detcompraprecioprod` double NOT NULL,
  PRIMARY KEY (`Comcodigo`,`Prodcodigo`),
  KEY `Prodcodigo_idx` (`Prodcodigo`),
  KEY `CompraId_idx` (`Comcodigo`),
  CONSTRAINT `CompraIdfk` FOREIGN KEY (`Comcodigo`) REFERENCES `compras` (`Comcodigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Prodcodigo` FOREIGN KEY (`Prodcodigo`) REFERENCES `productos` (`Prodcodigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecompra`
--

LOCK TABLES `detallecompra` WRITE;
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepedido`
--

DROP TABLE IF EXISTS `detallepedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallepedido` (
  `Pedcodigo` int NOT NULL,
  `Prodcodigo` int NOT NULL,
  `Detpedcant` int NOT NULL,
  `Detpedprodprecio` float DEFAULT NULL,
  `Detpedestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Pedcodigo`,`Prodcodigo`),
  KEY `Prodcodigofk_idx` (`Prodcodigo`),
  CONSTRAINT `Pedcodigojkpp` FOREIGN KEY (`Pedcodigo`) REFERENCES `pedidos` (`Pedcodigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Prodcodigofk` FOREIGN KEY (`Prodcodigo`) REFERENCES `productos` (`Prodcodigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepedido`
--

LOCK TABLES `detallepedido` WRITE;
/*!40000 ALTER TABLE `detallepedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallepedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventa` (
  `Detvencantidad` int DEFAULT NULL,
  `Ventcodigo` int NOT NULL,
  `Prodcodigo` int NOT NULL,
  PRIMARY KEY (`Prodcodigo`,`Ventcodigo`),
  KEY `Procodigo_idx` (`Prodcodigo`),
  KEY `Vencodigofk_idx` (`Ventcodigo`),
  CONSTRAINT `Procodigo` FOREIGN KEY (`Prodcodigo`) REFERENCES `productos` (`Prodcodigo`),
  CONSTRAINT `Vencodigofk` FOREIGN KEY (`Ventcodigo`) REFERENCES `ventas` (`Vencodigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `Empcodigo` int NOT NULL AUTO_INCREMENT,
  `Empidentidad` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Empnombre` varchar(45) NOT NULL,
  `Emptelefono` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Empfechanacimiento` date NOT NULL,
  `Empdireccion` varchar(75) DEFAULT NULL,
  `Empfechaingreso` date NOT NULL,
  `Empfechasalida` date DEFAULT NULL,
  `Empcorreo` varchar(100) DEFAULT NULL,
  `Empestado` varchar(3) DEFAULT NULL,
  `Empusuario` varchar(45) DEFAULT NULL,
  `Empcontrasena` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Empcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (18,'0801199916168','Marcela Zelaya','97523648','1998-08-09','Col. Cerro Grande','2017-11-01','0000-00-00','marcelazelaya547@yahoo.com','ACT','marzela21','d46ae22d74440742880f0f995ddd6601ae3541cb6aff7b316e273ae0531477f0');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `Marcodigo` int NOT NULL AUTO_INCREMENT,
  `Mardescripcion` varchar(45) DEFAULT NULL,
  `Marestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Marcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'Mistermusculo','ACT'),(2,'Andy Store','ACT'),(3,'Tamarindos','ACT');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `Pedcodigo` int NOT NULL AUTO_INCREMENT,
  `Procodigo` int DEFAULT NULL,
  `Pedfecha` date DEFAULT NULL,
  `Empcodigo` int DEFAULT NULL,
  `Pedestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Pedcodigo`),
  KEY `Procodigofkp_idx` (`Procodigo`),
  KEY `Empcodigafkp_idx` (`Empcodigo`),
  CONSTRAINT `Empcodfk` FOREIGN KEY (`Empcodigo`) REFERENCES `empleados` (`Empcodigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Procodigofkp` FOREIGN KEY (`Procodigo`) REFERENCES `proveedores` (`Procodigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `Prodcodigo` int NOT NULL AUTO_INCREMENT,
  `Proddescripcion` varchar(100) DEFAULT NULL,
  `Prodprecventa` float DEFAULT NULL,
  `Tipcodigo` int DEFAULT NULL,
  `Marcodigo` int DEFAULT NULL,
  `Proexistencia` int DEFAULT NULL,
  `Prodcantidadminima` int DEFAULT NULL,
  `Prodestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Prodcodigo`),
  KEY `Marcodigo_idx` (`Marcodigo`),
  KEY `Tipcodigo_idx` (`Tipcodigo`),
  CONSTRAINT `Marcodigo` FOREIGN KEY (`Marcodigo`) REFERENCES `marcas` (`Marcodigo`),
  CONSTRAINT `Tipcodigo` FOREIGN KEY (`Tipcodigo`) REFERENCES `tipoproducto` (`Tipcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Cera para asientos',200,1,1,8,5,'ACT'),(2,'Rines',1500,2,2,2,5,'ACT'),(3,'Volante de cuero',2300,2,1,8,5,'ACT'),(4,'Vidrio Templado',2500,2,3,30,5,'ACT');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos-proveedores`
--

DROP TABLE IF EXISTS `productos-proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos-proveedores` (
  `Procodigo` int NOT NULL,
  `Prodcodigo` int NOT NULL,
  PRIMARY KEY (`Procodigo`,`Prodcodigo`),
  KEY `Prodcodigofkpp_idx` (`Prodcodigo`),
  CONSTRAINT `Procodigofkpp` FOREIGN KEY (`Procodigo`) REFERENCES `proveedores` (`Procodigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Prodcodigofkpp` FOREIGN KEY (`Prodcodigo`) REFERENCES `productos` (`Prodcodigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos-proveedores`
--

LOCK TABLES `productos-proveedores` WRITE;
/*!40000 ALTER TABLE `productos-proveedores` DISABLE KEYS */;
INSERT INTO `productos-proveedores` VALUES (1,1),(1,2),(2,3);
/*!40000 ALTER TABLE `productos-proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `Procodigo` int NOT NULL AUTO_INCREMENT,
  `Pronombre` varchar(45) DEFAULT NULL,
  `Prodireccion` varchar(100) DEFAULT NULL,
  `Protelefono` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Proestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Procodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Variedades K&D','Residencial Cascadas','9523647','ACT'),(2,'Larach & Cia','Barrio El Centro','953264781','ACT'),(3,'TOYOTA','Res. Las Uvas','95412365','ACT'),(4,'La Mundial','Frente al City Mall','22541978','ACT');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto-empleado`
--

DROP TABLE IF EXISTS `puesto-empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puesto-empleado` (
  `Pueempcodigo` int NOT NULL AUTO_INCREMENT,
  `Empcodigo` int NOT NULL,
  `Puecodigo` int NOT NULL,
  PRIMARY KEY (`Pueempcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto-empleado`
--

LOCK TABLES `puesto-empleado` WRITE;
/*!40000 ALTER TABLE `puesto-empleado` DISABLE KEYS */;
INSERT INTO `puesto-empleado` VALUES (22,18,1);
/*!40000 ALTER TABLE `puesto-empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puestos`
--

DROP TABLE IF EXISTS `puestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puestos` (
  `Puecodigo` int NOT NULL AUTO_INCREMENT,
  `Puedescripcion` varchar(30) DEFAULT NULL,
  `Pueestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Puecodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestos`
--

LOCK TABLES `puestos` WRITE;
/*!40000 ALTER TABLE `puestos` DISABLE KEYS */;
INSERT INTO `puestos` VALUES (1,'Gerente','ACT'),(2,'Jefe de Mecánico','ACT'),(3,'Vendedor','ACT'),(4,'Aseador ','ACT'),(5,'Vigilante','ACT');
/*!40000 ALTER TABLE `puestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sar`
--

DROP TABLE IF EXISTS `sar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sar` (
  `id_sar` int NOT NULL AUTO_INCREMENT,
  `fecha_limite_emision` date NOT NULL,
  `rango_inicial` varchar(16) NOT NULL,
  `rango_final` varchar(16) NOT NULL,
  `cai` varchar(32) NOT NULL,
  PRIMARY KEY (`id_sar`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sar`
--

LOCK TABLES `sar` WRITE;
/*!40000 ALTER TABLE `sar` DISABLE KEYS */;
INSERT INTO `sar` VALUES (1,'2021-10-03','000001','999999','123456');
/*!40000 ALTER TABLE `sar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temp` (
  `Tempcodigo` int NOT NULL AUTO_INCREMENT,
  `Tempprodcodigo` int DEFAULT NULL,
  `Tempproddescripcion` varchar(100) DEFAULT NULL,
  `Tempprodprecventa` float DEFAULT NULL,
  `Tempprodcanti` int DEFAULT NULL,
  PRIMARY KEY (`Tempcodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp`
--

LOCK TABLES `temp` WRITE;
/*!40000 ALTER TABLE `temp` DISABLE KEYS */;
/*!40000 ALTER TABLE `temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoproducto` (
  `Tipcodigo` int NOT NULL AUTO_INCREMENT,
  `Tipdescripcion` varchar(45) DEFAULT NULL,
  `Tipestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Tipcodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
INSERT INTO `tipoproducto` VALUES (1,'Limpieza','ACT'),(2,'Repuestos','ACT'),(3,'Aceites','ACT');
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `Vencodigo` int NOT NULL AUTO_INCREMENT,
  `Venfecha` date DEFAULT NULL,
  `Empcodigo` int NOT NULL,
  `Clicodigo` int NOT NULL,
  `Tippacodigo` varchar(45) NOT NULL,
  `Vendescuento` float DEFAULT NULL,
  `id_sar` int DEFAULT NULL,
  `Venestado` varchar(3) DEFAULT 'ACT',
  PRIMARY KEY (`Vencodigo`),
  KEY `sar_a_venta_idx` (`id_sar`),
  KEY `Clicodigo_fk_idx` (`Clicodigo`),
  CONSTRAINT `Clicodigo_fk` FOREIGN KEY (`Clicodigo`) REFERENCES `clientes` (`Clicodigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sar_a_venta` FOREIGN KEY (`id_sar`) REFERENCES `sar` (`id_sar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bdrepuestos'
--
/*!50003 DROP PROCEDURE IF EXISTS `Compras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Compras`(proveedor int,fechapedida date, fecharecibido date, tipoPago nvarchar(45))
BEGIN
insert into compras(Procodigo,Comfechaped,Comfechaent,TipoPago) values(proveedor,fechapedida,fecharecibido,tipoPago);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DetalleCompra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DetalleCompra`(producto int,recibida int, precio double)
BEGIN
declare id int;
set id =(select Max(Comcodigo) from compras);
insert into detallecompra(Comcodigo,Prodcodigo,Detcompracantidadrec,Detcompraprecioprod) values(id,producto,recibida,precio);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filtrar_sar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filtrar_sar`(id VARCHAR(50),fecha varchar(30),ci varchar(50))
BEGIN
SELECT * FROM sar WHERE id_sar LIKE concat('%'+id+'%') or fecha_limite_emision LIKE concat('%'+id+'%')or  cai LIKE concat('%'+id+'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filtro_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filtro_clientes`(rt varchar(50),nom varchar(50))
BEGIN
SELECT * FROM Clientes WHERE RTN LIKE Concat('%',rt+'%') or Clinombre LIKE Concat('%',nom+'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllClientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllClientes`()
BEGIN
	SELECT * FROM clientes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMaxIdVentas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMaxIdVentas`()
BEGIN
 SELECT MAX(Vencodigo) FROM ventas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStockProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStockProductos`(codigo int)
BEGIN
   SELECT proexistencia from productos where prodcodigo = codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_sar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_sar`()
BEGIN
 select * from sar;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_ventasDetallesHistorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_ventasDetallesHistorial`(cod int)
BEGIN
SELECT C.Prodcodigo, C.Proddescripcion, C.Prodprecventa, B.Detvencantidad FROM ventas AS A 
JOIN detalleventa AS B ON A.Vencodigo = B.Ventcodigo
JOIN productos AS C ON B.Prodcodigo = C.Prodcodigo
WHERE A.Vencodigo = cod;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_ventasHistorial` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_ventasHistorial`()
BEGIN
SELECT Vencodigo, Venfecha, Venestado FROM ventas where Venestado = 'ACT';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_DtlVts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_DtlVts`(Detvencantidad int , Ventcodigo int , Prodcodigo int)
BEGIN
INSERT INTO `bdrepuestos`.`detalleventa`
(`Detvencantidad`,
`Ventcodigo`,
`Prodcodigo`)
VALUES
(Detvencantidad,
Ventcodigo,
Prodcodigo);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_sar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_sar`(fechaLimite VARCHAR(20),rangoIncial varchar(20),rangoFinal varchar(20),cai_ varchar(50))
BEGIN
INSERT INTO `bdrepuestos`.`sar`
(`fecha_limite_emision`,
`rango_inicial`,
`rango_final`,
`cai`)
VALUES
(fechaLimite,
rangoIncial,
rangoFinal,
cai_);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_vts` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_vts`(Venfecha varchar(20),Empcodigo int,Clicodigo int,Tippacodigo varchar(20),Vendescuento float,Venestado VARCHAR(3) ,id_sar int)
BEGIN
INSERT INTO `bdrepuestos`.`ventas`
(`Venfecha`,
`Empcodigo`,
`Clicodigo`,
`Tippacodigo`,
`Vendescuento`,
`Venestado`,
`id_sar`)
VALUES
(Venfecha,
Empcodigo,
Clicodigo,
Tippacodigo,
Vendescuento,
Venestado,
id_sar);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoClientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoClientes`(
IN _Accion VARCHAR(15),
IN _Clicodigo INT,
IN _Clinombre VARCHAR(45),
IN _RTN VARCHAR(17),
IN _Clitelefono VARCHAR(13),
IN _Cliestado VARCHAR(3),
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(RTN) FROM clientes WHERE UPPER(RTN) = UPPER(_RTN)) !=0 THEN
			SET _Estado = "errRTN"; 
		END IF;
		IF (SELECT COUNT(Clinombre) FROM clientes WHERE UPPER(Clinombre) = UPPER(_Clinombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
		IF (SELECT COUNT(Clitelefono) FROM clientes WHERE UPPER(Clitelefono) = UPPER(_Clitelefono)) !=0 THEN
			SET _Estado = "errTelefono"; 
		END IF;   
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.clientes
            VALUES (
            _Clicodigo,
            _Clinombre,
            _RTN,
            _Clitelefono,
			"ACT");
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
        IF (SELECT COUNT(RTN) FROM clientes WHERE UPPER(RTN) = UPPER(_RTN)) !=0 THEN
			SET _Estado = "errRTN"; 
		END IF;
		IF (SELECT COUNT(Clinombre) FROM clientes WHERE UPPER(Clinombre) = UPPER(_Clinombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
		IF (SELECT COUNT(Clitelefono) FROM clientes WHERE UPPER(Clitelefono) = UPPER(_Clitelefono)) !=0 THEN
			SET _Estado = "errTelefono"; 
		END IF;
        
		IF _Estado = "OK" THEN
			UPDATE clientes SET 
			Clinombre = _Clinombre, 
            RTN = _RTN,
			Clitelefono = _Clitelefono
			WHERE Clicodigo = _Clicodigo;
		END IF; 
	END IF;
    IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE clientes SET
            Cliestado = "INA"
			WHERE Clicodigo = _Clicodigo;
		END IF; 
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoContacto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoContacto`(
IN _Accion VARCHAR(20),
IN _Concodigo INT,
IN _Connombre VARCHAR(45),
IN _Contelefono VARCHAR(13),
IN _Concorreo VARCHAR(100),
IN _Procodigo INT,
IN _Conestado VARCHAR(3),
OUT _Estado VARCHAR(50)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN

		IF (SELECT COUNT(Contelefono) FROM contactos WHERE UPPER(Contelefono) = UPPER(_Contelefono)) !=0 THEN
			SET _Estado = "errTelefono"; 
		END IF;
		IF (SELECT COUNT(Concorreo) FROM contactos WHERE UPPER(Concorreo) = UPPER(_Concorreo)) !=0 THEN
			SET _Estado = "errCorreo"; 
		END IF;        
		IF _Estado = "OK" THEN
            INSERT INTO contactos 
            VALUES (
            0,
            _Connombre,
            _Contelefono,
            _Concorreo,
            _Procodigo,
            "ACT");
		END IF;
	END IF;
    
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE contactos SET 
			Connombre = _Connombre, 
			Contelefono = _Contelefono,
			Procodigo = _Procodigo,
            Concorreo =_Concorreo,
            Conestado = _Conestado
			WHERE Concodigo = _Concodigo;
		END IF; 
	END IF;
    
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE contactos SET
            Conestado = "INA"
			WHERE Concodigo = _Concodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoContrasena`(
IN _Accion VARCHAR(20),
IN _Empcodigo INT,
IN _Empusuario VARCHAR(20),
IN _Empcontrasena VARCHAR(100),
OUT _Estado VARCHAR(10))
BEGIN
	SET _Estado = "OK";
	IF _Accion LIKE '%contrasena%' THEN
		IF _Estado = "OK" THEN
			UPDATE empleados SET
				Empcontrasena = _Empcontrasena
			WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoEmpleadoPuesto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoEmpleadoPuesto`(
IN _Accion VARCHAR(15),
IN _Pueempcodigo INT,
IN _Empcodigo INT,
IN _Puecodigo INT,
OUT _Estado VARCHAR(15)
)
BEGIN
	SET SQL_SAFE_UPDATES = 0;
	SET _Estado = "OK";
	IF _Accion LIKE '%eliminar%' THEN
    
		IF _Estado = "OK" THEN
			DELETE FROM `bdrepuestos`.`puesto-empleado` 
            WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;   
	IF _Accion LIKE '%insertar%' THEN
		INSERT INTO `puesto-empleado`
        VALUES
        (
			0,
			_Empcodigo,
            _Puecodigo
        );
        
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoEmpleados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoEmpleados`(
IN _Accion VARCHAR(20),
IN _Empcodigo INT,
IN _Empidentidad VARCHAR(40),
IN _Empnombre VARCHAR(40),
IN _Emptelefono VARCHAR(15),
IN _Empfechanacimiento  VARCHAR(10),
IN _Empdireccion VARCHAR(100),
IN _Empfechaingreso VARCHAR(10),
IN _Empfechasalida VARCHAR(10),
IN _Empcorreo VARCHAR(100),
IN _Empestado VARCHAR(3),
IN _Empusuario VARCHAR(20),
IN _Empcontrasena VARCHAR(100),
OUT _Estado VARCHAR(10)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Empidentidad) FROM empleados WHERE UPPER(Empidentidad) = UPPER(_Empidentidad)) !=0 THEN
			SET _Estado = "errIdentidad"; 
		END IF;
		IF (SELECT COUNT(Empnombre) FROM empleados WHERE UPPER(Empnombre) = UPPER(_Empnombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
		IF (SELECT COUNT(Emptelefono) FROM empleados WHERE UPPER(Emptelefono) = UPPER(_Emptelefono)) !=0 THEN
			SET _Estado = "errTelefono"; 
		END IF;   
		IF (SELECT COUNT(Empusuario) FROM empleados WHERE UPPER(Empusuario) = UPPER(_Empusuario)) !=0 THEN
			SET _Estado = "errUsuario"; 
		END IF;  
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.empleados 
            VALUES (
            _Empcodigo,
            _Empidentidad,
            _Empnombre,
            _Emptelefono,
            _Empfechanacimiento,
            _Empdireccion,
            _Empfechaingreso,
			"0000-00-00",
			_Empcorreo,
			"ACT",
            _Empusuario,
            _Empcontrasena);
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE empleados SET 
            Empidentidad = _Empidentidad,
			Empnombre = _Empnombre, 
			Emptelefono = _Emptelefono, 
			Empfechanacimiento = _Empfechanacimiento, 
			Empdireccion = _Empdireccion,
			Empfechaingreso = _Empfechaingreso, 
			Empfechasalida = _Empfechasalida, 
			Empcorreo = _Empcorreo,
            Empestado = _Empestado,
            Empusuario =_Empusuario
			WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;
    
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE empleados SET
            Empfechasalida = CURDATE(),
            Empestado = "INA"
			WHERE Empcodigo = _Empcodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoMarcas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoMarcas`(
IN _Accion VARCHAR(15),
IN _Marcodigo INT,
IN _Mardescripcion VARCHAR(40),
IN _Marestado VARCHAR(3),
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Mardescripcion) FROM marcas WHERE UPPER(Mardescripcion) = UPPER(_Mardescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF; 
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.marcas 
            VALUES (
            0,
            _Mardescripcion,
			"ACT"
            );
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE marcas SET 
            Mardescripcion = _Mardescripcion,
			Marestado = _Marestado
			WHERE Marcodigo = _Marcodigo;
		END IF; 
	END IF;
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE marcas SET
            Marestado = "INA"
			WHERE Marcodigo = _Marcodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoPedidos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoPedidos`(
IN _Accion VARCHAR(15),
IN _Pedcodigo INT,
IN _Procodigo INT,
IN _Pedfecha VARCHAR(10),
IN _Empcodigo INT,
IN _Pedestado VARCHAR(3),
IN _Detpedcant INT,
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.pedidos
            VALUES (
            _Pedcodigo,
            _Procodigo,
            _Pedfecha,
            _Empcodigo,
			"ACT");
            
            INSERT INTO bdrepuestos.detallepedido (Pedcodigo ,Prodcodigo, Detpedcant, Detpedprodprecio)
			SELECT (SELECT Pedcodigo FROM bdrepuestos.pedidos
					order by Pedcodigo DESC limit 1), Tempprodcodigo, Tempprodcanti, Tempprodprecventa FROM bdrepuestos.temp;
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE pedidos SET 
			Procodigo = _Procodigo,
            Pedestado = _Pedestado
			WHERE Pedcodigo = _Pedcodigo;
            UPDATE detallepedido SET
            Detpedcant = _Detpedcant
			WHERE Pedcodigo = _Pedcodigo AND Prodcodigo = _Procodigo;
		END IF; 
	END IF;
    
    IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE pedidos SET 
            Pedestado = 'INA'
			WHERE Pedcodigo = _Pedcodigo;
            UPDATE detallepedido SET
            Detpedestado = 'INA'
			WHERE Pedcodigo = _Pedcodigo;
		END IF; 
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoProductos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoProductos`(
IN _Accion VARCHAR(20),
IN _Procodigo INT,
IN _Proddescricion VARCHAR(40),
IN _Prodprecventa Float,
IN _Tipcodigo INT,
IN _Marcodigo INT,
IN _Proexistencia INT,
IN _Procantidadminima INT,
IN _proestado VARCHAR(3),
OUT _estado VARCHAR(50))
BEGIN
	SET _estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Proddescripcion) FROM productos WHERE UPPER(Proddescripcion) = UPPER(_Proddescricion)) !=0 THEN
			SET _estado = "errDescripcion"; 
		END IF;
	
        
		IF _estado = "OK" THEN
            INSERT INTO productos 
            VALUES (
            _Procodigo,
            _Proddescricion,
            _Prodprecventa,
            _Tipcodigo,
            _Marcodigo,
            _Proexistencia,
            _Procantidadminima,
            _proestado
          );
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _estado = "OK" THEN
			UPDATE productos SET 
            Proddescripcion = _Proddescricion,
			Prodprecventa = _Prodprecventa,
            Tipcodigo=_Tipcodigo,
            Marcodigo =_Marcodigo,
            Proexistencia = _Proexistencia,
            Prodcantidadminima = _Procantidadminima,
            Prodestado = _proestado
			WHERE Prodcodigo = _Procodigo;
		END IF; 
	END IF;
    
	IF _Accion LIKE '%eliminar%' THEN
		IF _estado = "OK" THEN
			UPDATE productos SET
            Prodestado = "INA"
			WHERE Prodcodigo = _Procodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoProveedor`(
IN _Accion VARCHAR(20),
IN _Procodigo INT,
IN _Pronombre VARCHAR(45),
IN _Prodireccion VARCHAR(100),
IN _Protelefono VARCHAR(15),
IN _Proestado VARCHAR(10),
OUT _Estado VARCHAR(50)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Pronombre) FROM proveedores WHERE UPPER(Pronombre) = UPPER(_Pronombre)) !=0 THEN
			SET _Estado = "errNombre"; 
		END IF;
		IF (SELECT COUNT(Protelefono) FROM proveedores WHERE UPPER(Protelefono) = UPPER(_Protelefono)) !=0 THEN
			SET _Estado = "errTelefono"; 
		END IF;
        
		IF _Estado = "OK" THEN
            INSERT INTO proveedores 
            VALUES (
            0,
            _Pronombre,
            _Prodireccion,
            _Protelefono,
            "ACT");
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE proveedores SET 
			Pronombre = _Pronombre, 
			Prodireccion = _Prodireccion,
			Protelefono = _Protelefono,
            Proestado = _Proestado
			WHERE Procodigo = _Procodigo;
		END IF; 
	END IF;
    
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE proveedores SET
            Proestado = "INA"
			WHERE Procodigo = _Procodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoPuestos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoPuestos`(
IN _Accion VARCHAR(15),
IN _Puecodigo INT,
IN _Puedescripcion VARCHAR(40),
IN _Pueestado VARCHAR(3),
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Puedescripcion) FROM puestos WHERE UPPER(Puedescripcion) = UPPER(_Puedescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF; 
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.puestos 
            VALUES (
            0,
            _Puedescripcion,
			"ACT"
            );
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE puestos SET 
            Puedescripcion = _Puedescripcion,
			Pueestado = _Pueestado
			WHERE Puecodigo = _Puecodigo;
		END IF; 
	END IF;
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE puestos SET
            Pueestado = "INA"
			WHERE Puecodigo = _Puecodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoRecuperarContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoRecuperarContrasena`(
IN _Empusuario VARCHAR(20),
IN _Empcontrasena VARCHAR(100),
OUT _Estado VARCHAR(10))
BEGIN
	SET _Estado = "OK";
    SET SQL_SAFE_UPDATES = 0;
		IF _Estado = "OK" THEN
			UPDATE empleados SET
				Empcontrasena = _Empcontrasena
			WHERE Empusuario = _Empusuario;
		END IF; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoTemp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoTemp`(
IN _Accion VARCHAR(15),
IN _Tempprodcodigo INT,
IN _Tempproddescripcion VARCHAR(100),
IN _Tempprodprecventa FLOAT,
IN _Tempprodcanti INT,
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
        IF (SELECT COUNT(Tempproddescripcion) FROM temp WHERE UPPER(Tempproddescripcion) = UPPER(_Tempproddescripcion)) !=0 THEN
			SET _Estado = "existe"; 
		END IF;
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.temp
            VALUES (
            0,
            _Tempprodcodigo,
			_Tempproddescripcion,
			_Tempprodprecventa,
			_Tempprodcanti
            );
            
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE temp SET 
			Tempprodcanti = _Tempprodcanti
			WHERE Tempproddescripcion = _Tempproddescripcion;
		END IF; 
	END IF;
	IF _Accion LIKE '%eliminar%' THEN
		truncate table temp;
    END IF;
    IF _Accion LIKE '%quitar%' THEN
		DELETE FROM temp 
        WHERE Tempprodcodigo = _Tempprodcodigo;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `MantenimientoTipos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `MantenimientoTipos`(
IN _Accion VARCHAR(15),
IN _Tipcodigo INT,
IN _Tipdescripcion VARCHAR(40),
IN _Tipestado VARCHAR(3),
OUT _Estado VARCHAR(15)
)
BEGIN

	SET _Estado = "OK";
    
	IF _Accion LIKE '%insertar%' THEN
		IF (SELECT COUNT(Tipdescripcion) FROM tipoproducto WHERE UPPER(Tipdescripcion) = UPPER(_Tipdescripcion)) !=0 THEN
			SET _Estado = "errDescripcion"; 
		END IF; 
        
		IF _Estado = "OK" THEN
            INSERT INTO bdrepuestos.tipoproducto 
            VALUES (
            0,
            _Tipdescripcion,
			"ACT"
            );
		END IF;
	END IF;
	IF _Accion LIKE '%editar%' THEN
		IF _Estado = "OK" THEN
			UPDATE tipoproducto SET 
            Tipdescripcion = _Tipdescripcion,
			Tipestado = _Tipestado
			WHERE Tipcodigo = _Tipcodigo;
		END IF; 
	END IF;
	IF _Accion LIKE '%eliminar%' THEN
		IF _Estado = "OK" THEN
			UPDATE tipoproducto SET
            Tipestado = "INA"
			WHERE Tipcodigo = _Tipcodigo;
		END IF; 
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `UPD_EstVenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_EstVenta`(codigo int , est varchar(3))
BEGIN
UPDATE `bdrepuestos`.`ventas`
SET
Venestado = est
WHERE Vencodigo = codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `upd_sar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `upd_sar`(id int, fecha varchar(20),inicial varchar(20),final varchar(20),cai varchar(20))
BEGIN
UPDATE `bdrepuestos`.`sar`
SET
`fecha_limite_emision` = fecha,
`rango_inicial` = inicial,
`rango_final` = final,
`cai` = cai
WHERE `id_sar` = id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `upt_stockProdRes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `upt_stockProdRes`(cod int, cant int)
BEGIN
declare existencia int;
set existencia = (Select proexistencia from `bdrepuestos`.`productos` WHERE `Prodcodigo`= cod);
UPDATE `bdrepuestos`.`productos` SET`Proexistencia` = existencia - cant
WHERE `Prodcodigo` = cod ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-09  3:17:45
