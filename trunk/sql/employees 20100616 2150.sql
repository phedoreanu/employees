-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.47-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema employees
--

CREATE DATABASE IF NOT EXISTS employees;
USE employees;

--
-- Definition of table `abilitate`
--

DROP TABLE IF EXISTS `abilitate`;
CREATE TABLE `abilitate` (
  `id_abilitate` bigint(20) NOT NULL AUTO_INCREMENT,
  `nume_abilitate` varchar(50) NOT NULL,
  PRIMARY KEY (`id_abilitate`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `abilitate`
--

/*!40000 ALTER TABLE `abilitate` DISABLE KEYS */;
INSERT INTO `abilitate` (`id_abilitate`,`nume_abilitate`) VALUES 
 (1,'testXX');
/*!40000 ALTER TABLE `abilitate` ENABLE KEYS */;


--
-- Definition of table `angajat`
--

DROP TABLE IF EXISTS `angajat`;
CREATE TABLE `angajat` (
  `id_angajat` bigint(20) NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `CNP` varchar(13) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `activ` tinyint(4) NOT NULL,
  `id_functie` bigint(20) DEFAULT NULL,
  `id_clasa_salariu` bigint(20) DEFAULT NULL,
  `id_clasa_concediu` bigint(20) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_angajat`),
  KEY `id_functie` (`id_functie`),
  KEY `id_clasa_salariu` (`id_clasa_salariu`),
  KEY `id_clasa_concediu` (`id_clasa_concediu`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `angajat_ibfk_1` FOREIGN KEY (`id_functie`) REFERENCES `functie` (`id_functie`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `angajat_ibfk_2` FOREIGN KEY (`id_clasa_salariu`) REFERENCES `clasa_salariu` (`id_clasa_salariu`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `angajat_ibfk_3` FOREIGN KEY (`id_clasa_concediu`) REFERENCES `clasa_concediu` (`id_clasa_concediu`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `angajat_ibfk_4` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angajat`
--

/*!40000 ALTER TABLE `angajat` DISABLE KEYS */;
/*!40000 ALTER TABLE `angajat` ENABLE KEYS */;


--
-- Definition of table `angajat_abilitate`
--

DROP TABLE IF EXISTS `angajat_abilitate`;
CREATE TABLE `angajat_abilitate` (
  `id_angajat_abilitate` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_angajat` bigint(20) DEFAULT NULL,
  `id_abilitate` bigint(20) DEFAULT NULL,
  `nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_angajat_abilitate`),
  KEY `id_angajat` (`id_angajat`),
  KEY `id_abilitate` (`id_abilitate`),
  CONSTRAINT `angajat_abilitate_ibfk_1` FOREIGN KEY (`id_angajat`) REFERENCES `angajat` (`id_angajat`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `angajat_abilitate_ibfk_2` FOREIGN KEY (`id_abilitate`) REFERENCES `abilitate` (`id_abilitate`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angajat_abilitate`
--

/*!40000 ALTER TABLE `angajat_abilitate` DISABLE KEYS */;
/*!40000 ALTER TABLE `angajat_abilitate` ENABLE KEYS */;


--
-- Definition of table `angajat_loc_anterior`
--

DROP TABLE IF EXISTS `angajat_loc_anterior`;
CREATE TABLE `angajat_loc_anterior` (
  `id_angajat_loc` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_angajat` bigint(20) DEFAULT NULL,
  `id_loc_munca` bigint(20) DEFAULT NULL,
  `data_angajare` date DEFAULT NULL,
  `data_plecare` date DEFAULT NULL,
  PRIMARY KEY (`id_angajat_loc`),
  KEY `id_angajat` (`id_angajat`),
  KEY `id_loc_munca` (`id_loc_munca`),
  CONSTRAINT `angajat_loc_anterior_ibfk_1` FOREIGN KEY (`id_angajat`) REFERENCES `angajat` (`id_angajat`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `angajat_loc_anterior_ibfk_2` FOREIGN KEY (`id_loc_munca`) REFERENCES `loc_munca_anterior` (`id_loc_munca`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angajat_loc_anterior`
--

/*!40000 ALTER TABLE `angajat_loc_anterior` DISABLE KEYS */;
/*!40000 ALTER TABLE `angajat_loc_anterior` ENABLE KEYS */;


--
-- Definition of table `angajat_zi_munca`
--

DROP TABLE IF EXISTS `angajat_zi_munca`;
CREATE TABLE `angajat_zi_munca` (
  `id_angajat_zi` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_angajat` bigint(20) DEFAULT NULL,
  `ziua` date DEFAULT NULL,
  `nr_ore` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_angajat_zi`),
  KEY `id_angajat` (`id_angajat`),
  CONSTRAINT `angajat_zi_munca_ibfk_1` FOREIGN KEY (`id_angajat`) REFERENCES `angajat` (`id_angajat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angajat_zi_munca`
--

/*!40000 ALTER TABLE `angajat_zi_munca` DISABLE KEYS */;
/*!40000 ALTER TABLE `angajat_zi_munca` ENABLE KEYS */;


--
-- Definition of table `clasa_concediu`
--

DROP TABLE IF EXISTS `clasa_concediu`;
CREATE TABLE `clasa_concediu` (
  `id_clasa_concediu` bigint(20) NOT NULL AUTO_INCREMENT,
  `nr_clasa` int(11) NOT NULL,
  PRIMARY KEY (`id_clasa_concediu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clasa_concediu`
--

/*!40000 ALTER TABLE `clasa_concediu` DISABLE KEYS */;
/*!40000 ALTER TABLE `clasa_concediu` ENABLE KEYS */;


--
-- Definition of table `clasa_salariu`
--

DROP TABLE IF EXISTS `clasa_salariu`;
CREATE TABLE `clasa_salariu` (
  `id_clasa_salariu` bigint(20) NOT NULL AUTO_INCREMENT,
  `nr_clasa` int(11) NOT NULL,
  PRIMARY KEY (`id_clasa_salariu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clasa_salariu`
--

/*!40000 ALTER TABLE `clasa_salariu` DISABLE KEYS */;
/*!40000 ALTER TABLE `clasa_salariu` ENABLE KEYS */;


--
-- Definition of table `evaluare_anuala`
--

DROP TABLE IF EXISTS `evaluare_anuala`;
CREATE TABLE `evaluare_anuala` (
  `id_evaluare` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_angajat` bigint(20) DEFAULT NULL,
  `calificativ` varchar(2) DEFAULT NULL,
  `an` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_evaluare`),
  KEY `id_angajat` (`id_angajat`),
  CONSTRAINT `evaluare_anuala_ibfk_1` FOREIGN KEY (`id_angajat`) REFERENCES `angajat` (`id_angajat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evaluare_anuala`
--

/*!40000 ALTER TABLE `evaluare_anuala` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluare_anuala` ENABLE KEYS */;


--
-- Definition of table `functie`
--

DROP TABLE IF EXISTS `functie`;
CREATE TABLE `functie` (
  `id_functie` bigint(20) NOT NULL AUTO_INCREMENT,
  `nume_functie` varchar(30) NOT NULL,
  PRIMARY KEY (`id_functie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `functie`
--

/*!40000 ALTER TABLE `functie` DISABLE KEYS */;
/*!40000 ALTER TABLE `functie` ENABLE KEYS */;


--
-- Definition of table `loc_munca_anterior`
--

DROP TABLE IF EXISTS `loc_munca_anterior`;
CREATE TABLE `loc_munca_anterior` (
  `id_loc_munca` bigint(20) NOT NULL AUTO_INCREMENT,
  `nume_loc` varchar(50) NOT NULL,
  PRIMARY KEY (`id_loc_munca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loc_munca_anterior`
--

/*!40000 ALTER TABLE `loc_munca_anterior` DISABLE KEYS */;
/*!40000 ALTER TABLE `loc_munca_anterior` ENABLE KEYS */;


--
-- Definition of table `studii_angajat`
--

DROP TABLE IF EXISTS `studii_angajat`;
CREATE TABLE `studii_angajat` (
  `id_studii_angajat` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_angajat` bigint(20) DEFAULT NULL,
  `nume_institut` varchar(50) NOT NULL,
  `tip_studiu` varchar(30) NOT NULL,
  `data_absolvire` date NOT NULL,
  PRIMARY KEY (`id_studii_angajat`),
  KEY `id_angajat` (`id_angajat`),
  CONSTRAINT `studii_angajat_ibfk_1` FOREIGN KEY (`id_angajat`) REFERENCES `angajat` (`id_angajat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studii_angajat`
--

/*!40000 ALTER TABLE `studii_angajat` DISABLE KEYS */;
/*!40000 ALTER TABLE `studii_angajat` ENABLE KEYS */;


--
-- Definition of table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`id`,`username`,`role`) VALUES 
 (1,'admin','administrator'),
 (2,'test','employee'),
 (3,'admin','manager');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id_user`,`username`,`password`) VALUES 
 (1,'admin','admin'),
 (2,'test','test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
