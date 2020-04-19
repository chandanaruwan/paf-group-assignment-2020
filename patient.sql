-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2020 at 11:25 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitalmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `patientID` int(10) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`patientID`, `fname`, `lname`, `nic`, `sex`, `address`, `phone`, `email`, `password`) VALUES
(1, 'Anura', 'Shantha', '650510470v', 'M', '189/c,sudarshana mawatha,malabe', '711540908', 'anura@gmail.com', 'anura1965'),
(2, 'Chandana', 'Dushantha', '931381105v', 'M', '189/c,Bakmeegaha para,pore,Athurugiriya', '716063692', 'chandana93@gmail.com', '1993chandana'),
(3, 'Nilakshi', 'Madushani', '954532010v', 'F', 'temple road, saragama,kurunegala', '770302333', 'nilakshi@gmail.com', 'nilakshi12345'),
(4, 'Somalatha', 'hettiArachchi', '483457070v', 'F', 'no123/5,Thalahena,Malabe', '715222629', 'somalatha@gmail.com', 'somalatha'),
(5, 'Jayalath', 'Premasiri', '680532805v', 'M', 'Getapalugolla,Minuwangete', '774368995', 'jayalath@gmail.com', 'jayalath'),
(6, 'qqqq', 'aaaaa', 'fdfdf', 'fsfdzf', 'xdxxbcvb', 'zfzdvcxv', 'xdxxbcvb', 'zfzdvcxv'),
(7, 'sujeewa', 'weerasinghe', '914532678v', 'M', 'sumangala mawatha,Wariyapola', '0721222478', 'sumangala mawatha,Wariyapola', '0721222478'),
(11, 'qqqqqqqqq', 'aaaaaaaaaaaaaa', '4564664v', 'f', 'fdgfg', '654645', 'fdgfg', '654645'),
(13, 'mahinda', 'rajapalsha', '456466478v', 'M', 'ranala,kaduwela', '0776546455', 'ranala,kaduwela', '0776546455');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`patientID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `patientID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
