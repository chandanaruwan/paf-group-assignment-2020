-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 19, 2020 at 06:33 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doctor`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospitaldoctors`
--

DROP TABLE IF EXISTS `hospitaldoctors`;
CREATE TABLE IF NOT EXISTS `hospitaldoctors` (
  `doctorid` varchar(200) NOT NULL,
  `doctorname` varchar(200) NOT NULL,
  `phone` int(200) NOT NULL,
  `specialty` varchar(200) NOT NULL,
  `experience` varchar(200) NOT NULL,
  PRIMARY KEY (`doctorid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `hospitaldoctors`
--

INSERT INTO `hospitaldoctors` (`doctorid`, `doctorname`, `phone`, `specialty`, `experience`) VALUES
('001', 'DR AJITH AMARASINGHE', 14785236, 'Allergy', 'five years'),
('002', 'DR NIMAL LIYANAGE', 25874136, 'Radiology', 'Six years'),
('003', 'DR THUSHARA GALABADA', 58742365, 'Neurology', 'Two years');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
