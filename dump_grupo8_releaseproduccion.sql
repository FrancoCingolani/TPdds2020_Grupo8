CREATE DATABASE  IF NOT EXISTS `dds` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dds`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dds
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `atm`
--

DROP TABLE IF EXISTS `atm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atm` (
  `id_medio_de_pago` int(11) NOT NULL,
  `linkPagos` int(11) NOT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atm`
--

LOCK TABLES `atm` WRITE;
/*!40000 ALTER TABLE `atm` DISABLE KEYS */;
INSERT INTO `atm` VALUES (7,1111),(8,2222),(9,3333);
/*!40000 ALTER TABLE `atm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `tipo` varchar(31) NOT NULL,
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES ('tipo1',1),('tipo2',2),('tipo3',3);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cityml`
--

DROP TABLE IF EXISTS `cityml`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cityml` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `id_country` varchar(255) DEFAULT NULL,
  `id_state` varchar(255) DEFAULT NULL,
  `latitud` varchar(255) DEFAULT NULL,
  `longitud` varchar(255) DEFAULT NULL,
  `name_city` varchar(255) DEFAULT NULL,
  `name_country` varchar(255) DEFAULT NULL,
  `name_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cityml`
--

LOCK TABLES `cityml` WRITE;
/*!40000 ALTER TABLE `cityml` DISABLE KEYS */;
INSERT INTO `cityml` VALUES (1,'1','1','1000','2000','Buenos Aires','Argentina','Buenos Aires');
/*!40000 ALTER TABLE `cityml` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clasificaciones`
--

DROP TABLE IF EXISTS `clasificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clasificaciones` (
  `id_clasificacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `clasificacionPadre_id_clasificacion` int(11) DEFAULT NULL,
  `id_criterio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_clasificacion`),
  KEY `FKb0xejcp40pkq6gd2rvfs1fbql` (`clasificacionPadre_id_clasificacion`),
  KEY `FKphxaxv7njotbdv8g0tye2w8jl` (`id_criterio`),
  CONSTRAINT `FKb0xejcp40pkq6gd2rvfs1fbql` FOREIGN KEY (`clasificacionPadre_id_clasificacion`) REFERENCES `clasificaciones` (`id_clasificacion`),
  CONSTRAINT `FKphxaxv7njotbdv8g0tye2w8jl` FOREIGN KEY (`id_criterio`) REFERENCES `criterios` (`id_criterio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clasificaciones`
--

LOCK TABLES `clasificaciones` WRITE;
/*!40000 ALTER TABLE `clasificaciones` DISABLE KEYS */;
INSERT INTO `clasificaciones` VALUES (1,'clientes',1,1),(2,'barrios',2,2),(3,'ciudades',3,2);
/*!40000 ALTER TABLE `clasificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `cantPresuReq` int(11) NOT NULL,
  `id_presupuesto_elegido` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `FKw580b89flj6va30j1hbvb1b4` (`id_presupuesto_elegido`),
  CONSTRAINT `FKw580b89flj6va30j1hbvb1b4` FOREIGN KEY (`id_presupuesto_elegido`) REFERENCES `presupuestos` (`id_presupuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,1,NULL),(2,1,NULL);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_usuarios`
--

DROP TABLE IF EXISTS `compras_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_usuarios` (
  `Compra_id_compra` int(11) NOT NULL,
  `revisores_id_usuario` int(11) NOT NULL,
  KEY `FKmovhbdt1brpassb5pd910va4g` (`revisores_id_usuario`),
  KEY `FKb19mvr0hin8qbotels7n29f9s` (`Compra_id_compra`),
  CONSTRAINT `FKb19mvr0hin8qbotels7n29f9s` FOREIGN KEY (`Compra_id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FKmovhbdt1brpassb5pd910va4g` FOREIGN KEY (`revisores_id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_usuarios`
--

LOCK TABLES `compras_usuarios` WRITE;
/*!40000 ALTER TABLE `compras_usuarios` DISABLE KEYS */;
INSERT INTO `compras_usuarios` VALUES (1,1);
/*!40000 ALTER TABLE `compras_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criterios`
--

DROP TABLE IF EXISTS `criterios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criterios` (
  `id_criterio` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_criterio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criterios`
--

LOCK TABLES `criterios` WRITE;
/*!40000 ALTER TABLE `criterios` DISABLE KEYS */;
INSERT INTO `criterios` VALUES (1,'Criterio1'),(2,'Criterio2');
/*!40000 ALTER TABLE `criterios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currencyml`
--

DROP TABLE IF EXISTS `currencyml`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currencyml` (
  `id_moneda` int(11) NOT NULL AUTO_INCREMENT,
  `decimal_places` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currencyml`
--

LOCK TABLES `currencyml` WRITE;
/*!40000 ALTER TABLE `currencyml` DISABLE KEYS */;
INSERT INTO `currencyml` VALUES (1,2,'Peso argentino','ARS'),(2,2,'Dolar Estadounidense','USD');
/*!40000 ALTER TABLE `currencyml` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dineroencuenta`
--

DROP TABLE IF EXISTS `dineroencuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dineroencuenta` (
  `id_medio_de_pago` int(11) NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dineroencuenta`
--

LOCK TABLES `dineroencuenta` WRITE;
/*!40000 ALTER TABLE `dineroencuenta` DISABLE KEYS */;
INSERT INTO `dineroencuenta` VALUES (4,1000),(5,2000),(6,1500);
/*!40000 ALTER TABLE `dineroencuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentoscomerciales`
--

DROP TABLE IF EXISTS `documentoscomerciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentoscomerciales` (
  `id_documento_comercial` int(11) NOT NULL AUTO_INCREMENT,
  `numero_identificacion` varchar(255) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_documento_comercial`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentoscomerciales`
--

LOCK TABLES `documentoscomerciales` WRITE;
/*!40000 ALTER TABLE `documentoscomerciales` DISABLE KEYS */;
INSERT INTO `documentoscomerciales` VALUES (1,'123456',1),(2,'456789',2);
/*!40000 ALTER TABLE `documentoscomerciales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entidadesjuridicas`
--

DROP TABLE IF EXISTS `entidadesjuridicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entidadesjuridicas` (
  `descripcion` varchar(255) DEFAULT NULL,
  `CUIT` varchar(255) DEFAULT NULL,
  `codigoInscripcionIGJ` int(11) NOT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `id_entidad_juridica` int(11) NOT NULL,
  `id_entidad_base` int(11) NOT NULL,
  `perteneceA_id_entidad_juridica` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_entidad_juridica`),
  KEY `FK28p4vcna6qjxw9qamj086ojlg` (`perteneceA_id_entidad_juridica`),
  KEY `FKcl559f1bafn2x2o854h1mucaa` (`id_entidad_base`),
  CONSTRAINT `FK1nefbqsofgwh8crtpw92d3w0t` FOREIGN KEY (`id_entidad_juridica`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FK28p4vcna6qjxw9qamj086ojlg` FOREIGN KEY (`perteneceA_id_entidad_juridica`) REFERENCES `entidadesjuridicas` (`id_entidad_juridica`),
  CONSTRAINT `FKcl559f1bafn2x2o854h1mucaa` FOREIGN KEY (`id_entidad_base`) REFERENCES `organizaciones` (`id_organizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entidadesjuridicas`
--

LOCK TABLES `entidadesjuridicas` WRITE;
/*!40000 ALTER TABLE `entidadesjuridicas` DISABLE KEYS */;
INSERT INTO `entidadesjuridicas` VALUES ('descripcion 1','20123456',10,'razonSocial 1',1,1,NULL);
/*!40000 ALTER TABLE `entidadesjuridicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `numeroPresupuesto` int(11) NOT NULL,
  `valor` double NOT NULL,
  `id_clasificacion` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `FKnvd3n9xccjlax331pc9s753ha` (`id_clasificacion`),
  KEY `FK6bwse5dbwnhde54deb9g6j4j1` (`id_compra`),
  KEY `FKqmf63a27pryeptnqkx5kdii68` (`id_moneda`),
  CONSTRAINT `FK6bwse5dbwnhde54deb9g6j4j1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FKnvd3n9xccjlax331pc9s753ha` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificaciones` (`id_clasificacion`),
  CONSTRAINT `FKqmf63a27pryeptnqkx5kdii68` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,10,'Computadoras',1,100000,1,1,1);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medianatramo1`
--

DROP TABLE IF EXISTS `medianatramo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medianatramo1` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medianatramo1`
--

LOCK TABLES `medianatramo1` WRITE;
/*!40000 ALTER TABLE `medianatramo1` DISABLE KEYS */;
/*!40000 ALTER TABLE `medianatramo1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medianatramo2`
--

DROP TABLE IF EXISTS `medianatramo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medianatramo2` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medianatramo2`
--

LOCK TABLES `medianatramo2` WRITE;
/*!40000 ALTER TABLE `medianatramo2` DISABLE KEYS */;
/*!40000 ALTER TABLE `medianatramo2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensajes` (
  `tipo` varchar(31) NOT NULL,
  `id_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `asuntoMensaje` varchar(255) DEFAULT NULL,
  `leido` bit(1) DEFAULT NULL,
  `textoMensaje` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_mensaje`),
  KEY `FKes3ij9ehri4aigr4thy9n5x2b` (`id_usuario`),
  CONSTRAINT `FKes3ij9ehri4aigr4thy9n5x2b` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES ('tipo1',1,'Mensaje importante al grupo 8',_binary '','Vamos a promocionar DDS',1);
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `micro`
--

DROP TABLE IF EXISTS `micro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `micro` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `micro`
--

LOCK TABLES `micro` WRITE;
/*!40000 ALTER TABLE `micro` DISABLE KEYS */;
/*!40000 ALTER TABLE `micro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacionesegreso`
--

DROP TABLE IF EXISTS `operacionesegreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operacionesegreso` (
  `id_operacion_egreso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `fueVinculado` bit(1) NOT NULL,
  `valorTotal` double NOT NULL,
  `id_clasificacion` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  `id_medio_de_pago` int(11) DEFAULT NULL,
  `id_operacion_ingreso` int(11) DEFAULT NULL,
  `id_organizacion` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  `id_operacion_egreso_entidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_operacion_egreso`),
  KEY `FK3ahhtbigtl0wj0ll9gybn9k0s` (`id_clasificacion`),
  KEY `FK4nd97wr0ijoensbf9p8qfh52d` (`id_compra`),
  KEY `FKsuu7wh48yksamtwsf70x977gk` (`id_moneda`),
  KEY `FKj8ev01sh8ttibby10x1jfs06s` (`id_operacion_ingreso`),
  KEY `FK9osx73nv93iyndbvlokse16eq` (`id_organizacion`),
  KEY `FKgtx00eptwj5wjqaqn2oqlqwr4` (`id_proveedor`),
  KEY `FKm0ai9eqsnsrc74mk3hjfl3kag` (`id_operacion_egreso_entidad`),
  CONSTRAINT `FK3ahhtbigtl0wj0ll9gybn9k0s` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificaciones` (`id_clasificacion`),
  CONSTRAINT `FK4nd97wr0ijoensbf9p8qfh52d` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FK9osx73nv93iyndbvlokse16eq` FOREIGN KEY (`id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKgtx00eptwj5wjqaqn2oqlqwr4` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`),
  CONSTRAINT `FKj8ev01sh8ttibby10x1jfs06s` FOREIGN KEY (`id_operacion_ingreso`) REFERENCES `operacionesingreso` (`id_operacion_ingreso`),
  CONSTRAINT `FKm0ai9eqsnsrc74mk3hjfl3kag` FOREIGN KEY (`id_operacion_egreso_entidad`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKsuu7wh48yksamtwsf70x977gk` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacionesegreso`
--

LOCK TABLES `operacionesegreso` WRITE;
/*!40000 ALTER TABLE `operacionesegreso` DISABLE KEYS */;
INSERT INTO `operacionesegreso` VALUES (1,'2020-11-18 00:00:00',_binary '\0',80000,1,1,1,1,1,1,NULL,1);
/*!40000 ALTER TABLE `operacionesegreso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacionesegreso_documentoscomerciales`
--

DROP TABLE IF EXISTS `operacionesegreso_documentoscomerciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operacionesegreso_documentoscomerciales` (
  `OperacionEgreso_id_operacion_egreso` int(11) NOT NULL,
  `documentosComerciales_id_documento_comercial` int(11) NOT NULL,
  KEY `FKgqaq4qokofm80rlwaq3tq6363` (`documentosComerciales_id_documento_comercial`),
  KEY `FKgkw4wemns7byj2g87uctkf8f8` (`OperacionEgreso_id_operacion_egreso`),
  CONSTRAINT `FKgkw4wemns7byj2g87uctkf8f8` FOREIGN KEY (`OperacionEgreso_id_operacion_egreso`) REFERENCES `operacionesegreso` (`id_operacion_egreso`),
  CONSTRAINT `FKgqaq4qokofm80rlwaq3tq6363` FOREIGN KEY (`documentosComerciales_id_documento_comercial`) REFERENCES `documentoscomerciales` (`id_documento_comercial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacionesegreso_documentoscomerciales`
--

LOCK TABLES `operacionesegreso_documentoscomerciales` WRITE;
/*!40000 ALTER TABLE `operacionesegreso_documentoscomerciales` DISABLE KEYS */;
INSERT INTO `operacionesegreso_documentoscomerciales` VALUES (1,1);
/*!40000 ALTER TABLE `operacionesegreso_documentoscomerciales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacionesegreso_items`
--

DROP TABLE IF EXISTS `operacionesegreso_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operacionesegreso_items` (
  `OperacionEgreso_id_operacion_egreso` int(11) NOT NULL,
  `items_id_item` int(11) NOT NULL,
  KEY `FK7bv1mck5l684jbrq1npupnnx` (`items_id_item`),
  KEY `FKn2kw8mvax6if1ssf5ija2nq5w` (`OperacionEgreso_id_operacion_egreso`),
  CONSTRAINT `FK7bv1mck5l684jbrq1npupnnx` FOREIGN KEY (`items_id_item`) REFERENCES `items` (`id_item`),
  CONSTRAINT `FKn2kw8mvax6if1ssf5ija2nq5w` FOREIGN KEY (`OperacionEgreso_id_operacion_egreso`) REFERENCES `operacionesegreso` (`id_operacion_egreso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacionesegreso_items`
--

LOCK TABLES `operacionesegreso_items` WRITE;
/*!40000 ALTER TABLE `operacionesegreso_items` DISABLE KEYS */;
INSERT INTO `operacionesegreso_items` VALUES (1,1);
/*!40000 ALTER TABLE `operacionesegreso_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacionesingreso`
--

DROP TABLE IF EXISTS `operacionesingreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operacionesingreso` (
  `id_operacion_ingreso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaIngreso` datetime DEFAULT NULL,
  `valorTotal` double NOT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  `id_organizacion` int(11) DEFAULT NULL,
  `id_subsidio` int(11) DEFAULT NULL,
  `id_operacion_ingreso_entidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_operacion_ingreso`),
  KEY `FKpcqxlor40rk5xsr5fnj68gdnb` (`id_moneda`),
  KEY `FK5d3hipv0ll8y3jhkucq2jo617` (`id_organizacion`),
  KEY `FK48okm9qs6my8vqovneno9ql4g` (`id_subsidio`),
  KEY `FKm2s3f3vajyr2h27li8m2h3idh` (`id_operacion_ingreso_entidad`),
  CONSTRAINT `FK48okm9qs6my8vqovneno9ql4g` FOREIGN KEY (`id_subsidio`) REFERENCES `proyectos` (`id_proyecto`),
  CONSTRAINT `FK5d3hipv0ll8y3jhkucq2jo617` FOREIGN KEY (`id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKm2s3f3vajyr2h27li8m2h3idh` FOREIGN KEY (`id_operacion_ingreso_entidad`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKpcqxlor40rk5xsr5fnj68gdnb` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacionesingreso`
--

LOCK TABLES `operacionesingreso` WRITE;
/*!40000 ALTER TABLE `operacionesingreso` DISABLE KEYS */;
INSERT INTO `operacionesingreso` VALUES (1,'Venta de PCs','2020-11-05 00:00:00',120000,1,1,98,NULL);
/*!40000 ALTER TABLE `operacionesingreso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizaciones`
--

DROP TABLE IF EXISTS `organizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizaciones` (
  `id_organizacion` int(11) NOT NULL AUTO_INCREMENT,
  `actividad` int(11) DEFAULT NULL,
  `direccionPostal` varchar(255) DEFAULT NULL,
  `nombreFicticio` varchar(255) DEFAULT NULL,
  `periodoVinculacion` int(11) NOT NULL,
  `personal` int(11) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `ventasAnuales` double NOT NULL,
  `categoria_id_categoria` int(11) DEFAULT NULL,
  `id_ciudad_id_ciudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_organizacion`),
  KEY `FKqjm1f1ba2ecu6nqwmb0s6wgwr` (`categoria_id_categoria`),
  KEY `FK9wpp4ags0yhlbudilqh92mlg6` (`id_ciudad_id_ciudad`),
  CONSTRAINT `FK9wpp4ags0yhlbudilqh92mlg6` FOREIGN KEY (`id_ciudad_id_ciudad`) REFERENCES `cityml` (`id_ciudad`),
  CONSTRAINT `FKqjm1f1ba2ecu6nqwmb0s6wgwr` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizaciones`
--

LOCK TABLES `organizaciones` WRITE;
/*!40000 ALTER TABLE `organizaciones` DISABLE KEYS */;
INSERT INTO `organizaciones` VALUES (1,1,'4562','grupo8',30,20,1,40000,1,1);
/*!40000 ALTER TABLE `organizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osc`
--

DROP TABLE IF EXISTS `osc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `osc` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osc`
--

LOCK TABLES `osc` WRITE;
/*!40000 ALTER TABLE `osc` DISABLE KEYS */;
/*!40000 ALTER TABLE `osc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pequenia`
--

DROP TABLE IF EXISTS `pequenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pequenia` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pequenia`
--

LOCK TABLES `pequenia` WRITE;
/*!40000 ALTER TABLE `pequenia` DISABLE KEYS */;
/*!40000 ALTER TABLE `pequenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuestos`
--

DROP TABLE IF EXISTS `presupuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuestos` (
  `id_presupuesto` int(11) NOT NULL AUTO_INCREMENT,
  `detalle` varchar(255) DEFAULT NULL,
  `numeroPresupuesto` int(11) NOT NULL,
  `valorTotal` double NOT NULL,
  `id_clasificacion` int(11) DEFAULT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  `id_proyecto` int(11) DEFAULT NULL,
  `id_compra` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_presupuesto`),
  KEY `FKg09bs0ntkoylig7iduywfe7xy` (`id_clasificacion`),
  KEY `FK22xyrayor63co5xiptlnigjvj` (`id_moneda`),
  KEY `FKtl5ux5ny59qsvkaglhhns2npk` (`id_proveedor`),
  KEY `FKn7n4p1wtg0aqqqvay34ahwul3` (`id_proyecto`),
  KEY `FKsefouvay7xchpjp77fm01gnwk` (`id_compra`),
  CONSTRAINT `FK22xyrayor63co5xiptlnigjvj` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`),
  CONSTRAINT `FKg09bs0ntkoylig7iduywfe7xy` FOREIGN KEY (`id_clasificacion`) REFERENCES `clasificaciones` (`id_clasificacion`),
  CONSTRAINT `FKn7n4p1wtg0aqqqvay34ahwul3` FOREIGN KEY (`id_proyecto`) REFERENCES `proyectos` (`id_proyecto`),
  CONSTRAINT `FKsefouvay7xchpjp77fm01gnwk` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FKtl5ux5ny59qsvkaglhhns2npk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuestos`
--

LOCK TABLES `presupuestos` WRITE;
/*!40000 ALTER TABLE `presupuestos` DISABLE KEYS */;
INSERT INTO `presupuestos` VALUES (1,'Presupuesto componentes PC',1,10000,1,1,1,98,1);
/*!40000 ALTER TABLE `presupuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuestos_documentoscomerciales`
--

DROP TABLE IF EXISTS `presupuestos_documentoscomerciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuestos_documentoscomerciales` (
  `Presupuesto_id_presupuesto` int(11) NOT NULL,
  `documentos_id_documento_comercial` int(11) NOT NULL,
  KEY `FKd5lry4n7aboumpgr7sbqgmb9w` (`documentos_id_documento_comercial`),
  KEY `FK2794696i696yb68fbtr1s91i0` (`Presupuesto_id_presupuesto`),
  CONSTRAINT `FK2794696i696yb68fbtr1s91i0` FOREIGN KEY (`Presupuesto_id_presupuesto`) REFERENCES `presupuestos` (`id_presupuesto`),
  CONSTRAINT `FKd5lry4n7aboumpgr7sbqgmb9w` FOREIGN KEY (`documentos_id_documento_comercial`) REFERENCES `documentoscomerciales` (`id_documento_comercial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuestos_documentoscomerciales`
--

LOCK TABLES `presupuestos_documentoscomerciales` WRITE;
/*!40000 ALTER TABLE `presupuestos_documentoscomerciales` DISABLE KEYS */;
INSERT INTO `presupuestos_documentoscomerciales` VALUES (1,1);
/*!40000 ALTER TABLE `presupuestos_documentoscomerciales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presupuestos_items`
--

DROP TABLE IF EXISTS `presupuestos_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presupuestos_items` (
  `Presupuesto_id_presupuesto` int(11) NOT NULL,
  `items_id_item` int(11) NOT NULL,
  UNIQUE KEY `UK_dduntl4m5rvjqcx2esj48hg7s` (`items_id_item`),
  KEY `FK7ovp5xvxqpl9hjvgil44wim0r` (`Presupuesto_id_presupuesto`),
  CONSTRAINT `FK7ovp5xvxqpl9hjvgil44wim0r` FOREIGN KEY (`Presupuesto_id_presupuesto`) REFERENCES `presupuestos` (`id_presupuesto`),
  CONSTRAINT `FKb4jovkb91nnliqkby5q7yta9n` FOREIGN KEY (`items_id_item`) REFERENCES `items` (`id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presupuestos_items`
--

LOCK TABLES `presupuestos_items` WRITE;
/*!40000 ALTER TABLE `presupuestos_items` DISABLE KEYS */;
INSERT INTO `presupuestos_items` VALUES (1,1);
/*!40000 ALTER TABLE `presupuestos_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `tipo` varchar(31) NOT NULL,
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `direccionPostal` varchar(255) DEFAULT NULL,
  `cuit` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `cuil` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_ciudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `FKsw2mciqtjvb3ifpsfinvtrygn` (`id_ciudad`),
  CONSTRAINT `FKsw2mciqtjvb3ifpsfinvtrygn` FOREIGN KEY (`id_ciudad`) REFERENCES `cityml` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('fisico',1,'1406',NULL,NULL,'Cingolani','20123456','123456','Franco',1),('fisico',2,'1274',NULL,NULL,'Sardella','20789456','789456','Josefina',1);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `id_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `cantPresupuestosRequeridos` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `montoAsignado` double NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_organizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `FKpn4y7k4cj6vl26mygf42tdkwp` (`id_usuario`),
  KEY `FKc31q2qptckmbcljpsqx05yw3k` (`id_organizacion`),
  CONSTRAINT `FKc31q2qptckmbcljpsqx05yw3k` FOREIGN KEY (`id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKpn4y7k4cj6vl26mygf42tdkwp` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (98,1,'descripcion 1',10000,'proyecto 1',1,1);
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetadecredito`
--

DROP TABLE IF EXISTS `tarjetadecredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetadecredito` (
  `id_medio_de_pago` int(11) NOT NULL,
  `codigoSeguridad` varchar(255) DEFAULT NULL,
  `duenioNombre` varchar(255) DEFAULT NULL,
  `duenioNroIdentificacion` varchar(255) DEFAULT NULL,
  `duenoTipoIdentificacion` varchar(255) DEFAULT NULL,
  `fechaExpiracion` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetadecredito`
--

LOCK TABLES `tarjetadecredito` WRITE;
/*!40000 ALTER TABLE `tarjetadecredito` DISABLE KEYS */;
INSERT INTO `tarjetadecredito` VALUES (1,'password','Franco','20123456','DNI',NULL,'456789123');
/*!40000 ALTER TABLE `tarjetadecredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetadedebito`
--

DROP TABLE IF EXISTS `tarjetadedebito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetadedebito` (
  `id_medio_de_pago` int(11) NOT NULL,
  `codigoSeguridad` varchar(255) DEFAULT NULL,
  `duenioNombre` varchar(255) DEFAULT NULL,
  `duenioNroIdentificacion` varchar(255) DEFAULT NULL,
  `duenoTipoIdentificacion` varchar(255) DEFAULT NULL,
  `fechaExpiracion` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetadedebito`
--

LOCK TABLES `tarjetadedebito` WRITE;
/*!40000 ALTER TABLE `tarjetadedebito` DISABLE KEYS */;
INSERT INTO `tarjetadedebito` VALUES (2,'password','Ignacio','852741963','DNI',NULL,'987654321');
/*!40000 ALTER TABLE `tarjetadedebito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id_medio_de_pago` int(11) NOT NULL,
  `codigoBarras` bigint(20) NOT NULL,
  `numeroParaCajero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (3,1000,'8512');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `cantidadIntentos` int(11) NOT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `intentosMaximos` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,0,'iGnac10ss',3,'ignacio',1),(2,0,'Franc0o0os',3,'usuariosfranco',1),(3,0,'J3s1casss',3,'jesica',1),(4,0,'J0sef1nass',3,'josefina',1),(5,0,'55df92989744f87d97bd04b1121088c1',3,'straccia',1);
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

-- Dump completed on 2020-12-09 22:10:07
