-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 05 月 30 日 15:34
-- 服务器版本: 5.5.24-log
-- PHP 版本: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `face`
--

-- --------------------------------------------------------

--
-- 表的结构 `consume`
--

CREATE TABLE IF NOT EXISTS `consume` (
  `id` bigint(20) NOT NULL,
  `payables` double DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `ispay` int(11) DEFAULT NULL,
  `paymoney` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `card` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `customer_card`
--

CREATE TABLE IF NOT EXISTS `customer_card` (
  `id` bigint(20) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `activedate` datetime DEFAULT NULL,
  `money` double DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `damage_product`
--

CREATE TABLE IF NOT EXISTS `damage_product` (
  `product` bigint(20) NOT NULL DEFAULT '0',
  `employee` bigint(20) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `dept_employee`
--

CREATE TABLE IF NOT EXISTS `dept_employee` (
  `department` bigint(20) NOT NULL,
  `employee` bigint(20) NOT NULL,
  `post` bigint(20) DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `identification` bigint(20) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `financial_bill`
--

CREATE TABLE IF NOT EXISTS `financial_bill` (
  `id` bigint(20) NOT NULL,
  `financial` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mrak` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `money` double DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `pm` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `financial_income`
--

CREATE TABLE IF NOT EXISTS `financial_income` (
  `id` bigint(20) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `consume` bigint(20) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `charges` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `in_product`
--

CREATE TABLE IF NOT EXISTS `in_product` (
  `id` bigint(20) NOT NULL,
  `supplier` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `product` bigint(20) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `mark` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `in_price` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `product_orderlist`
--

CREATE TABLE IF NOT EXISTS `product_orderlist` (
  `consume` bigint(20) NOT NULL,
  `product` bigint(20) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`consume`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `id` bigint(20) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `service_orderlist`
--

CREATE TABLE IF NOT EXISTS `service_orderlist` (
  `consume` bigint(20) NOT NULL,
  `service` bigint(20) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `card` bigint(20) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`consume`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `groups` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `Identification` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `phone1` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `phone2` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `phone3` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `user_card_info`
--

CREATE TABLE IF NOT EXISTS `user_card_info` (
  `card` bigint(20) NOT NULL,
  `user` bigint(20) DEFAULT NULL,
  `isactive` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `user` bigint(20) NOT NULL,
  `skin` int(11) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `health` int(11) DEFAULT NULL,
  `sport` int(11) DEFAULT NULL,
  `smook` int(11) DEFAULT NULL,
  `emotion` int(11) DEFAULT NULL,
  `sleep` int(11) DEFAULT NULL,
  `eatting` int(11) DEFAULT NULL,
  `nature` int(11) DEFAULT NULL,
  `postCode` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
