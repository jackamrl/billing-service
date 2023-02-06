-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 08, 2022 at 09:32 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `billingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--
use heroku_1db594ebb69de71;
DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `no_bill` int(11) NOT NULL AUTO_INCREMENT,
  `bill_date` datetime NOT NULL,
  `discount_percentage` double DEFAULT NULL,
  `total_ht` double NOT NULL,
  `total_ttc` double NOT NULL,
  `validation_date` datetime NOT NULL,
  PRIMARY KEY (`no_bill`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`no_bill`, `bill_date`, `discount_percentage`, `total_ht`, `total_ttc`, `validation_date`) VALUES
(1, '2022-11-06 20:05:18', 17, 4444, 470000, '2022-11-06 20:05:18'),
(2, '2022-11-06 20:05:18', 7, 450000, 1, '2022-11-06 20:05:18');

-- --------------------------------------------------------

--
-- Table structure for table `bill_item`
--

DROP TABLE IF EXISTS `bill_item`;
CREATE TABLE IF NOT EXISTS `bill_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `discount_percentage` double NOT NULL,
  `qte` int(11) NOT NULL,
  `rate_tva` double DEFAULT NULL,
  `no_bill` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK51gae229t0gdt533wqbmrqqcw` (`no_bill`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill_item`
--

INSERT INTO `bill_item` (`id`, `amount`, `discount_percentage`, `qte`, `rate_tva`, `no_bill`) VALUES
(1, 54540, 10, 10, 32, 1),
(2, 100, 770, 4, 10, 2),
(3, 100, 770, 4, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `quote`
--

DROP TABLE IF EXISTS `quote`;
CREATE TABLE IF NOT EXISTS `quote` (
  `no_quote` bigint(20) NOT NULL AUTO_INCREMENT,
  `quote_date` datetime NOT NULL,
  `total_ht` double NOT NULL,
  `total_ttc` double NOT NULL,
  `validation_date` datetime NOT NULL,
  PRIMARY KEY (`no_quote`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `quote_item`
--

DROP TABLE IF EXISTS `quote_item`;
CREATE TABLE IF NOT EXISTS `quote_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qte` int(11) NOT NULL,
  `no_quote` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7qy35rrbmgp3smkmkjkqgqtka` (`no_quote`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
