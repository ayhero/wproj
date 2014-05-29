-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 05 月 29 日 15:25
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
  `consume_id` bigint(20) NOT NULL,
  `payables` double DEFAULT NULL,
  `payDate` datetime DEFAULT NULL,
  `ispay` int(11) DEFAULT NULL,
  `paymoney` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`consume_id`),
  KEY `FK_coosum_card` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `customer_card`
--

CREATE TABLE IF NOT EXISTS `customer_card` (
  `card_id` bigint(20) NOT NULL,
  `activeDate` datetime DEFAULT NULL,
  `money` double DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  KEY `FK_card_type` (`type_id`),
  KEY `FK_employee_customercard` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `damage_product`
--

CREATE TABLE IF NOT EXISTS `damage_product` (
  `product_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `damageTime` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_damage_type` (`type_id`),
  KEY `FK_employee_damageproduct` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` bigint(20) NOT NULL,
  `dept_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `department_employee`
--

CREATE TABLE IF NOT EXISTS `department_employee` (
  `dept_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dept_id`,`employee_id`,`post_id`),
  KEY `FK_deptpost_employee` (`employee_id`),
  KEY `FK_deptpost_post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` bigint(20) NOT NULL,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `Identification` bigint(20) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `Identification` (`Identification`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `financial_bill`
--

CREATE TABLE IF NOT EXISTS `financial_bill` (
  `bill_id` bigint(20) NOT NULL,
  `financial_id` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `money` double DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `pm_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `FK_financial_bills` (`financial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `financial_income`
--

CREATE TABLE IF NOT EXISTS `financial_income` (
  `income_id` bigint(20) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `income_money` double DEFAULT NULL,
  `consume_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `in_charges` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`income_id`),
  KEY `FK_financial_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `group`
--

CREATE TABLE IF NOT EXISTS `group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tableName` varchar(50) COLLATE utf8_bin NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `in_product`
--

CREATE TABLE IF NOT EXISTS `in_product` (
  `In_id` bigint(20) NOT NULL,
  `supplier_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `inDate` datetime DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`In_id`),
  KEY `FK_product_inproduct` (`product_id`)
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
  `product_id` bigint(20) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `product_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `in_price` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_product_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `product_orderlist`
--

CREATE TABLE IF NOT EXISTS `product_orderlist` (
  `consume_id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `inDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`consume_id`),
  KEY `FK_employee_productOrder` (`employee_id`),
  KEY `FK_product_productOrder` (`product_id`),
  KEY `FK_productorder_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `service_id` bigint(20) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `FK_service_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `service_orderlist`
--

CREATE TABLE IF NOT EXISTS `service_orderlist` (
  `consume_id` bigint(20) NOT NULL,
  `service_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  `payDate` datetime DEFAULT NULL,
  PRIMARY KEY (`consume_id`),
  KEY `FK_orderlist_employee` (`employee_id`),
  KEY `FK_orderlist_service` (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `groupid` int(11) NOT NULL,
  PRIMARY KEY (`type_id`),
  KEY `groupid` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) NOT NULL,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `phone1` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `phone2` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `phone3` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `user_card_info`
--

CREATE TABLE IF NOT EXISTS `user_card_info` (
  `card_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `isactive` int(11) DEFAULT NULL,
  KEY `FK_user_usercardinfo` (`user_id`),
  KEY `card_id` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` bigint(20) NOT NULL,
  `skin` int(11) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `health` int(11) DEFAULT NULL,
  `sprots` int(11) DEFAULT NULL,
  `smook` int(11) DEFAULT NULL,
  `emotion` int(11) DEFAULT NULL,
  `sleep` int(11) DEFAULT NULL,
  `eatting` int(11) DEFAULT NULL,
  `nature` int(11) DEFAULT NULL,
  `postcode` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 限制导出的表
--

--
-- 限制表 `consume`
--
ALTER TABLE `consume`
  ADD CONSTRAINT `FK_coosum_card` FOREIGN KEY (`card_id`) REFERENCES `customer_card` (`card_id`);

--
-- 限制表 `customer_card`
--
ALTER TABLE `customer_card`
  ADD CONSTRAINT `FK_card_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`),
  ADD CONSTRAINT `FK_employee_customercard` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- 限制表 `damage_product`
--
ALTER TABLE `damage_product`
  ADD CONSTRAINT `FK_damage_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`),
  ADD CONSTRAINT `FK_employee_damageproduct` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `FK_product_damageproduct` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- 限制表 `department_employee`
--
ALTER TABLE `department_employee`
  ADD CONSTRAINT `FK_deptpost_dept` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  ADD CONSTRAINT `FK_deptpost_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);

--
-- 限制表 `financial_bill`
--
ALTER TABLE `financial_bill`
  ADD CONSTRAINT `FK_financial_bills` FOREIGN KEY (`financial_id`) REFERENCES `financial_income` (`income_id`);

--
-- 限制表 `financial_income`
--
ALTER TABLE `financial_income`
  ADD CONSTRAINT `FK_financial_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`);

--
-- 限制表 `in_product`
--
ALTER TABLE `in_product`
  ADD CONSTRAINT `FK_product_inproduct` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- 限制表 `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_product_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`);

--
-- 限制表 `product_orderlist`
--
ALTER TABLE `product_orderlist`
  ADD CONSTRAINT `FK_consume_productOrder` FOREIGN KEY (`consume_id`) REFERENCES `consume` (`consume_id`),
  ADD CONSTRAINT `FK_employee_productOrder` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `FK_productorder_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`),
  ADD CONSTRAINT `FK_product_productOrder` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- 限制表 `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `FK_service_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`);

--
-- 限制表 `service_orderlist`
--
ALTER TABLE `service_orderlist`
  ADD CONSTRAINT `FK_orderlist_consume` FOREIGN KEY (`consume_id`) REFERENCES `consume` (`consume_id`),
  ADD CONSTRAINT `FK_orderlist_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `FK_orderlist_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- 限制表 `type`
--
ALTER TABLE `type`
  ADD CONSTRAINT `type_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `group` (`id`);

--
-- 限制表 `user_card_info`
--
ALTER TABLE `user_card_info`
  ADD CONSTRAINT `FK_card_usercardinfo` FOREIGN KEY (`card_id`) REFERENCES `customer_card` (`card_id`),
  ADD CONSTRAINT `FK_user_usercardinfo` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- 限制表 `user_info`
--
ALTER TABLE `user_info`
  ADD CONSTRAINT `FK_user_userinfo` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
