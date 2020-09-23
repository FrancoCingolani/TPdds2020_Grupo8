CREATE DATABASE  IF NOT EXISTS `dds` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dds`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dds
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `atm`
--

DROP TABLE IF EXISTS `atm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atm` (
  `id_medio_de_pago` int(11) NOT NULL,
  `linkPagos` int(11) NOT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `tipo` varchar(31) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cityml`
--

DROP TABLE IF EXISTS `cityml`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cityml` (
  `id_ciudad` int(11) NOT NULL,
  `Id_Country` varchar(255) DEFAULT NULL,
  `Id_State` varchar(255) DEFAULT NULL,
  `Latitud` varchar(255) DEFAULT NULL,
  `Longitud` varchar(255) DEFAULT NULL,
  `Name_City` varchar(255) DEFAULT NULL,
  `Name_Country` varchar(255) DEFAULT NULL,
  `Name_State` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clasificaciones`
--

DROP TABLE IF EXISTS `clasificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clasificaciones` (
  `id_clasificacion` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `clasificacionPadre_id_clasificacion` int(11) DEFAULT NULL,
  `id_criterio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_clasificacion`),
  KEY `FKb0xejcp40pkq6gd2rvfs1fbql` (`clasificacionPadre_id_clasificacion`),
  KEY `FKphxaxv7njotbdv8g0tye2w8jl` (`id_criterio`),
  CONSTRAINT `FKb0xejcp40pkq6gd2rvfs1fbql` FOREIGN KEY (`clasificacionPadre_id_clasificacion`) REFERENCES `clasificaciones` (`id_clasificacion`),
  CONSTRAINT `FKphxaxv7njotbdv8g0tye2w8jl` FOREIGN KEY (`id_criterio`) REFERENCES `criterios` (`id_criterio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `id_compra` int(11) NOT NULL,
  `cantPresuReq` int(11) NOT NULL,
  `id_presupuesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `FKdafu1tws7f4qthggs3d374onp` (`id_presupuesto`),
  CONSTRAINT `FKdafu1tws7f4qthggs3d374onp` FOREIGN KEY (`id_presupuesto`) REFERENCES `presupuestos` (`id_presupuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compras_usuarios`
--

DROP TABLE IF EXISTS `compras_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras_usuarios` (
  `Compra_id_compra` int(11) NOT NULL,
  `revisores_nombre` varchar(255) NOT NULL,
  KEY `FKdq0a70asq6ne07oxmkuqfvpdw` (`revisores_nombre`),
  KEY `FKb19mvr0hin8qbotels7n29f9s` (`Compra_id_compra`),
  CONSTRAINT `FKb19mvr0hin8qbotels7n29f9s` FOREIGN KEY (`Compra_id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FKdq0a70asq6ne07oxmkuqfvpdw` FOREIGN KEY (`revisores_nombre`) REFERENCES `usuarios` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `criterios`
--

DROP TABLE IF EXISTS `criterios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `criterios` (
  `id_criterio` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_criterio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `currencyml`
--

DROP TABLE IF EXISTS `currencyml`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currencyml` (
  `id_moneda` int(11) NOT NULL,
  `Decimal_places` int(11) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Symbol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_moneda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dineroencuenta`
--

DROP TABLE IF EXISTS `dineroencuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dineroencuenta` (
  `id_medio_de_pago` int(11) NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `documentoscomerciales`
--

DROP TABLE IF EXISTS `documentoscomerciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentoscomerciales` (
  `id_documento_comercial` int(11) NOT NULL,
  `numero_identificacion` varchar(255) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_documento_comercial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `entidadesjuridicas`
--

DROP TABLE IF EXISTS `entidadesjuridicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entidadesjuridicas` (
  `descripcion` varchar(255) DEFAULT NULL,
  `nombreFicticio` varchar(255) DEFAULT NULL,
  `CUIT` varchar(255) DEFAULT NULL,
  `codigoInscripcionIGJ` int(11) NOT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `id_entidad_base` int(11) NOT NULL,
  `id_entidad_juridica` int(11) NOT NULL,
  `perteneceA_id_entidad_juridica` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_entidad_juridica`),
  KEY `FK28p4vcna6qjxw9qamj086ojlg` (`perteneceA_id_entidad_juridica`),
  KEY `FKcl559f1bafn2x2o854h1mucaa` (`id_entidad_base`),
  CONSTRAINT `FK1nefbqsofgwh8crtpw92d3w0t` FOREIGN KEY (`id_entidad_juridica`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FK28p4vcna6qjxw9qamj086ojlg` FOREIGN KEY (`perteneceA_id_entidad_juridica`) REFERENCES `entidadesjuridicas` (`id_entidad_juridica`),
  CONSTRAINT `FKcl559f1bafn2x2o854h1mucaa` FOREIGN KEY (`id_entidad_base`) REFERENCES `organizaciones` (`id_organizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id_item` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medianatramo1`
--

DROP TABLE IF EXISTS `medianatramo1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medianatramo1` (
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medianatramo2`
--

DROP TABLE IF EXISTS `medianatramo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medianatramo2` (
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mediodepago`
--

DROP TABLE IF EXISTS `mediodepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediodepago` (
  `id_medio_de_pago` int(11) NOT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensajes` (
  `tipo` varchar(31) NOT NULL,
  `id_mensaje` int(11) NOT NULL,
  `asuntoMensaje` varchar(255) DEFAULT NULL,
  `leido` bit(1) DEFAULT NULL,
  `textoMensaje` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_mensaje`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `micro`
--

DROP TABLE IF EXISTS `micro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `micro` (
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `operacionesegreso`
--

DROP TABLE IF EXISTS `operacionesegreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacionesegreso` (
  `id_operacion_egreso` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `fueVinculado` bit(1) NOT NULL,
  `valorTotal` double NOT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  `id_medio_de_pago` int(11) DEFAULT NULL,
  `id_operacion_ingreso` int(11) DEFAULT NULL,
  `id_organizacion` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_operacion_egreso`),
  KEY `FKsuu7wh48yksamtwsf70x977gk` (`id_moneda`),
  KEY `FKrt6a7qgxkfrjmewt9rnt2puat` (`id_operacion_ingreso`),
  KEY `FK9osx73nv93iyndbvlokse16eq` (`id_organizacion`),
  KEY `FKgtx00eptwj5wjqaqn2oqlqwr4` (`id_proveedor`),
  KEY `FKjso556mpeu1oebgr76odebr03` (`id_medio_de_pago`),
  CONSTRAINT `FK9osx73nv93iyndbvlokse16eq` FOREIGN KEY (`id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKf7l02cogoy3q49gigifhdbca` FOREIGN KEY (`id_operacion_egreso`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FKgtx00eptwj5wjqaqn2oqlqwr4` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`),
  CONSTRAINT `FKjso556mpeu1oebgr76odebr03` FOREIGN KEY (`id_medio_de_pago`) REFERENCES `mediodepago` (`id_medio_de_pago`),
  CONSTRAINT `FKrt6a7qgxkfrjmewt9rnt2puat` FOREIGN KEY (`id_operacion_ingreso`) REFERENCES `operacioningreso` (`id_operacion_ingreso`),
  CONSTRAINT `FKsuu7wh48yksamtwsf70x977gk` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `operacionesegreso_documentoscomerciales`
--

DROP TABLE IF EXISTS `operacionesegreso_documentoscomerciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacionesegreso_documentoscomerciales` (
  `OperacionEgreso_id_operacion_egreso` int(11) NOT NULL,
  `documentosComerciales_id_documento_comercial` int(11) NOT NULL,
  KEY `FKgqaq4qokofm80rlwaq3tq6363` (`documentosComerciales_id_documento_comercial`),
  KEY `FKgkw4wemns7byj2g87uctkf8f8` (`OperacionEgreso_id_operacion_egreso`),
  CONSTRAINT `FKgkw4wemns7byj2g87uctkf8f8` FOREIGN KEY (`OperacionEgreso_id_operacion_egreso`) REFERENCES `operacionesegreso` (`id_operacion_egreso`),
  CONSTRAINT `FKgqaq4qokofm80rlwaq3tq6363` FOREIGN KEY (`documentosComerciales_id_documento_comercial`) REFERENCES `documentoscomerciales` (`id_documento_comercial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `operacionesegreso_items`
--

DROP TABLE IF EXISTS `operacionesegreso_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacionesegreso_items` (
  `OperacionEgreso_id_operacion_egreso` int(11) NOT NULL,
  `items_id_item` int(11) NOT NULL,
  KEY `FK7bv1mck5l684jbrq1npupnnx` (`items_id_item`),
  KEY `FKn2kw8mvax6if1ssf5ija2nq5w` (`OperacionEgreso_id_operacion_egreso`),
  CONSTRAINT `FK7bv1mck5l684jbrq1npupnnx` FOREIGN KEY (`items_id_item`) REFERENCES `items` (`id_item`),
  CONSTRAINT `FKn2kw8mvax6if1ssf5ija2nq5w` FOREIGN KEY (`OperacionEgreso_id_operacion_egreso`) REFERENCES `operacionesegreso` (`id_operacion_egreso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `operacioningreso`
--

DROP TABLE IF EXISTS `operacioningreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operacioningreso` (
  `id_operacion_ingreso` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fechaIngreso` datetime DEFAULT NULL,
  `valorTotal` double NOT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  `id_organizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_operacion_ingreso`),
  KEY `FK1xduc1xuaojd0cogsaujpmotr` (`id_moneda`),
  KEY `FK3hqsre56p878e9iyuqplcw4wy` (`id_organizacion`),
  CONSTRAINT `FK1xduc1xuaojd0cogsaujpmotr` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`),
  CONSTRAINT `FK3hqsre56p878e9iyuqplcw4wy` FOREIGN KEY (`id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `organizaciones`
--

DROP TABLE IF EXISTS `organizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizaciones` (
  `id_organizacion` int(11) NOT NULL,
  `actividad` int(11) DEFAULT NULL,
  `direccionPostal` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `organizaciones_operacionesegreso`
--

DROP TABLE IF EXISTS `organizaciones_operacionesegreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizaciones_operacionesegreso` (
  `Organizacion_id_organizacion` int(11) NOT NULL,
  `operacionesEgresoEntidad_id_operacion_egreso` int(11) NOT NULL,
  UNIQUE KEY `UK_mxebgg7jaohrajmmabeoyrqff` (`operacionesEgresoEntidad_id_operacion_egreso`),
  KEY `FKppqlk8eco89w19oxffe3ipyi7` (`Organizacion_id_organizacion`),
  CONSTRAINT `FKppqlk8eco89w19oxffe3ipyi7` FOREIGN KEY (`Organizacion_id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`),
  CONSTRAINT `FKvvk9prk6j6gkkxwyookni2jo` FOREIGN KEY (`operacionesEgresoEntidad_id_operacion_egreso`) REFERENCES `operacionesegreso` (`id_operacion_egreso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `organizaciones_operacioningreso`
--

DROP TABLE IF EXISTS `organizaciones_operacioningreso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizaciones_operacioningreso` (
  `Organizacion_id_organizacion` int(11) NOT NULL,
  `operacionesIngresoEntidad_id_operacion_ingreso` int(11) NOT NULL,
  UNIQUE KEY `UK_qnhd3qa4lh46g2nri08f9g3ha` (`operacionesIngresoEntidad_id_operacion_ingreso`),
  KEY `FKre0rdfu1moxps7vwvi8u8djls` (`Organizacion_id_organizacion`),
  CONSTRAINT `FK6menyx8x469ywx5yj29aniead` FOREIGN KEY (`operacionesIngresoEntidad_id_operacion_ingreso`) REFERENCES `operacioningreso` (`id_operacion_ingreso`),
  CONSTRAINT `FKre0rdfu1moxps7vwvi8u8djls` FOREIGN KEY (`Organizacion_id_organizacion`) REFERENCES `organizaciones` (`id_organizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `osc`
--

DROP TABLE IF EXISTS `osc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osc` (
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pequenia`
--

DROP TABLE IF EXISTS `pequenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pequenia` (
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `presupuestos`
--

DROP TABLE IF EXISTS `presupuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presupuestos` (
  `id_presupuesto` int(11) NOT NULL,
  `detalle` varchar(255) DEFAULT NULL,
  `numeroPresupuesto` int(11) NOT NULL,
  `valorTotal` double NOT NULL,
  `id_moneda` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_presupuesto`),
  KEY `FK22xyrayor63co5xiptlnigjvj` (`id_moneda`),
  KEY `FKtl5ux5ny59qsvkaglhhns2npk` (`id_proveedor`),
  CONSTRAINT `FK22xyrayor63co5xiptlnigjvj` FOREIGN KEY (`id_moneda`) REFERENCES `currencyml` (`id_moneda`),
  CONSTRAINT `FKrosfir1m9y7j456xu4pus3t93` FOREIGN KEY (`id_presupuesto`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `FKtl5ux5ny59qsvkaglhhns2npk` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `presupuestos_documentoscomerciales`
--

DROP TABLE IF EXISTS `presupuestos_documentoscomerciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presupuestos_documentoscomerciales` (
  `Presupuesto_id_presupuesto` int(11) NOT NULL,
  `documentos_id_documento_comercial` int(11) NOT NULL,
  KEY `FKd5lry4n7aboumpgr7sbqgmb9w` (`documentos_id_documento_comercial`),
  KEY `FK2794696i696yb68fbtr1s91i0` (`Presupuesto_id_presupuesto`),
  CONSTRAINT `FK2794696i696yb68fbtr1s91i0` FOREIGN KEY (`Presupuesto_id_presupuesto`) REFERENCES `presupuestos` (`id_presupuesto`),
  CONSTRAINT `FKd5lry4n7aboumpgr7sbqgmb9w` FOREIGN KEY (`documentos_id_documento_comercial`) REFERENCES `documentoscomerciales` (`id_documento_comercial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `presupuestos_items`
--

DROP TABLE IF EXISTS `presupuestos_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presupuestos_items` (
  `Presupuesto_id_presupuesto` int(11) NOT NULL,
  `items_id_item` int(11) NOT NULL,
  UNIQUE KEY `UK_dduntl4m5rvjqcx2esj48hg7s` (`items_id_item`),
  KEY `FK7ovp5xvxqpl9hjvgil44wim0r` (`Presupuesto_id_presupuesto`),
  CONSTRAINT `FK7ovp5xvxqpl9hjvgil44wim0r` FOREIGN KEY (`Presupuesto_id_presupuesto`) REFERENCES `presupuestos` (`id_presupuesto`),
  CONSTRAINT `FKb4jovkb91nnliqkby5q7yta9n` FOREIGN KEY (`items_id_item`) REFERENCES `items` (`id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `tipo` varchar(31) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tarjetadecredito`
--

DROP TABLE IF EXISTS `tarjetadecredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjetadecredito` (
  `id_medio_de_pago` int(11) NOT NULL,
  `codigoSeguridad` varchar(255) DEFAULT NULL,
  `duenioNombre` varchar(255) DEFAULT NULL,
  `duenioNroIdentificacion` varchar(255) DEFAULT NULL,
  `duenoTipoIdentificacion` varchar(255) DEFAULT NULL,
  `fechaExpiracion` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tarjetadedebito`
--

DROP TABLE IF EXISTS `tarjetadedebito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjetadedebito` (
  `id_medio_de_pago` int(11) NOT NULL,
  `codigoSeguridad` varchar(255) DEFAULT NULL,
  `duenioNombre` varchar(255) DEFAULT NULL,
  `duenioNroIdentificacion` varchar(255) DEFAULT NULL,
  `duenoTipoIdentificacion` varchar(255) DEFAULT NULL,
  `fechaExpiracion` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id_medio_de_pago` int(11) NOT NULL,
  `codigoBarras` bigint(20) NOT NULL,
  `numeroParaCajero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_medio_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `nombre` varchar(255) NOT NULL,
  `cantidadIntentos` int(11) NOT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `intentosMaximos` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'dds'
--

--
-- Dumping routines for database 'dds'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-23 17:21:25
