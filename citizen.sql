-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 12:04 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `citizen`
--

-- --------------------------------------------------------

--
-- Table structure for table `guregistration`
--

CREATE TABLE `guregistration` (
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `present_add` varchar(20) NOT NULL,
  `permanent_add` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `b_group` varchar(10) NOT NULL,
  `nid` int(11) NOT NULL,
  `passport` int(11) NOT NULL,
  `pass` int(11) NOT NULL,
  `conf_pass` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `guregistration`
--

INSERT INTO `guregistration` (`first_name`, `last_name`, `email`, `phone_number`, `present_add`, `permanent_add`, `age`, `gender`, `b_group`, `nid`, `passport`, `pass`, `conf_pass`) VALUES
('ashek', 'mahady', 'ashek@gmail.com', 17999, 'nikunjo-2', 'nikunjo-2', 15, 'm', 'b+', 98098, 909099, 1234, 1234);

-- --------------------------------------------------------

--
-- Table structure for table `information`
--

CREATE TABLE `information` (
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `PhoneNo` varchar(30) DEFAULT NULL,
  `PresentAddress` varchar(30) DEFAULT NULL,
  `PermanentAddress` varchar(30) DEFAULT NULL,
  `NationalID` varchar(30) DEFAULT NULL,
  `DateOfBirth` varchar(30) DEFAULT NULL,
  `PassportNumber` varchar(30) DEFAULT NULL,
  `BloodGroup` varchar(30) DEFAULT NULL,
  `Age` varchar(30) DEFAULT NULL,
  `Gender` varchar(30) DEFAULT NULL,
  `Password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `information`
--

INSERT INTO `information` (`FirstName`, `LastName`, `Email`, `PhoneNo`, `PresentAddress`, `PermanentAddress`, `NationalID`, `DateOfBirth`, `PassportNumber`, `BloodGroup`, `Age`, `Gender`, `Password`) VALUES
('Mortuja', 'Arnob', 'mortu@gmail.com', '01521219267', 'Khilkhet', 'Rajshahi', '1998305699703', '12-11-1998', 'N/A', 'A+', '21', 'Male', '123456'),
('tony', 'mahady', 'tony@gmail.com', '014578965', 'nikunjo', 'sylhet', '457896412', '12-12-1998', '55566688', 'B+', '21', 'Male', '2222');

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE `user_type` (
  `type_id` int(5) NOT NULL,
  `type_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_type`
--

INSERT INTO `user_type` (`type_id`, `type_name`) VALUES
(1, 'General'),
(2, 'Student'),
(3, 'Police');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guregistration`
--
ALTER TABLE `guregistration`
  ADD PRIMARY KEY (`first_name`);

--
-- Indexes for table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_type`
--
ALTER TABLE `user_type`
  MODIFY `type_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
