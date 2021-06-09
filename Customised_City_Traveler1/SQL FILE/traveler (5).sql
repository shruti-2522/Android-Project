-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2021 at 04:19 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `traveler`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE `tbladmin` (
  `aid` int(11) NOT NULL,
  `aname` varchar(50) NOT NULL,
  `aemail` varchar(30) NOT NULL,
  `apass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`aid`, `aname`, `aemail`, `apass`) VALUES
(1, 'shruti', 'shruti@gmail.com', 'Shruti');

-- --------------------------------------------------------

--
-- Table structure for table `tblbook`
--

CREATE TABLE `tblbook` (
  `bookid` int(11) NOT NULL,
  `hid` int(11) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tblbroom`
--

CREATE TABLE `tblbroom` (
  `rid` int(11) NOT NULL,
  `hid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `rqty` int(11) NOT NULL,
  `datep` text DEFAULT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblbroom`
--

INSERT INTO `tblbroom` (`rid`, `hid`, `uid`, `rqty`, `datep`, `time`) VALUES
(72, 15, 0, 2, '26/5/2021', '3:15'),
(73, 15, 13, 1, '27/5/2021', '2:10'),
(82, 15, 0, 1, '28/5/2021', '');

-- --------------------------------------------------------

--
-- Table structure for table `tblhotel`
--

CREATE TABLE `tblhotel` (
  `hid` int(11) NOT NULL,
  `hname` text NOT NULL,
  `stime` time NOT NULL,
  `etime` time NOT NULL,
  `addr` text NOT NULL,
  `image` text NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblhotel`
--

INSERT INTO `tblhotel` (`hid`, `hname`, `stime`, `etime`, `addr`, `image`, `price`) VALUES
(16, 'Manas Dhule by WB Hotels', '10:12:00', '12:12:00', 'AGRA MUMBAI HIGHWAY M I D C, DHULE   ', 'hotel2.jpg', 4000),
(19, 'Rasraj Hotel', '02:42:00', '03:42:00', 'Dhulle', 'Hotel1.jpg', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `tblmall`
--

CREATE TABLE `tblmall` (
  `mid` int(11) NOT NULL,
  `mname` varchar(30) NOT NULL,
  `addr` text NOT NULL,
  `stime` time NOT NULL,
  `etime` time NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblmall`
--

INSERT INTO `tblmall` (`mid`, `mname`, `addr`, `stime`, `etime`, `image`) VALUES
(6, 'Sai Mall', 'Dhule', '09:24:00', '17:24:00', 'mall1.jpg'),
(7, 'Rajshree Mall', 'Dhule', '09:24:00', '17:24:00', 'mall1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tblmusiam`
--

CREATE TABLE `tblmusiam` (
  `musiam_id` int(11) NOT NULL,
  `mname` varchar(30) NOT NULL,
  `stime` time NOT NULL,
  `etime` time NOT NULL,
  `addr` text NOT NULL,
  `image` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblmusiam`
--

INSERT INTO `tblmusiam` (`musiam_id`, `mname`, `stime`, `etime`, `addr`, `image`) VALUES
(5, 'Sark Musiam', '09:27:00', '22:27:00', 'Dhule', 'm2.jpg'),
(8, 'Strak Musiam', '10:36:00', '01:36:00', 'Dhule', 'm2.jpg'),
(9, 'Spark Musiam', '11:51:00', '03:47:00', 'Dhule', 'm1.png');

-- --------------------------------------------------------

--
-- Table structure for table `tblpark`
--

CREATE TABLE `tblpark` (
  `pid` int(11) NOT NULL,
  `pname` varchar(50) NOT NULL,
  `stime` time NOT NULL,
  `etime` time NOT NULL,
  `addr` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblpark`
--

INSERT INTO `tblpark` (`pid`, `pname`, `stime`, `etime`, `addr`, `image`) VALUES
(3, 'Sai Park', '17:34:00', '22:30:00', 'DHULE', 'park2.jpg'),
(4, 'Shitali Park', '17:34:00', '22:30:00', 'DHULE', 'park2.jpg'),
(6, 'Garden', '03:48:00', '11:52:00', 'Dhule ', 'park2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tblrest`
--

CREATE TABLE `tblrest` (
  `rid` int(11) NOT NULL,
  `rname` varchar(30) NOT NULL,
  `stime` time NOT NULL,
  `etime` time NOT NULL,
  `addr` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblrest`
--

INSERT INTO `tblrest` (`rid`, `rname`, `stime`, `etime`, `addr`, `image`) VALUES
(12, 'The Orchid', '11:20:00', '17:20:00', 'Mumabi Road,,Dhule', 'Rest1.jpg'),
(13, 'Poonam Veg Resaturent', '10:21:00', '00:21:00', 'Deopur Road,Dhule ', 'Rest2.jpg'),
(14, 'Sai Restaurent', '02:43:00', '01:43:00', 'Dhule', 'Hotel1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbltemp`
--

CREATE TABLE `tbltemp` (
  `tid` int(11) NOT NULL,
  `temp_name` varchar(30) NOT NULL,
  `otime` time NOT NULL,
  `ctime` time NOT NULL,
  `loc` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbltemp`
--

INSERT INTO `tbltemp` (`tid`, `temp_name`, `otime`, `ctime`, `loc`, `image`) VALUES
(8, 'Ekvira Mandir', '05:26:00', '23:26:00', 'Dhule', 'templ1.jpg'),
(10, 'Ganpati Mandir', '05:26:00', '23:26:00', 'Dhule', 'download (7).jpg'),
(11, 'Swami Narayan ', '02:45:00', '00:00:00', 'Dhule', 'templ1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE `tbluser` (
  `uid` int(11) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `upass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`uid`, `uname`, `email`, `upass`) VALUES
(13, 'Shruti Amrutkar', 'shruti@gmail.com', 'Shruti'),
(14, 'Komal wani', 'komal@gmail.com', 'komal');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `tblbook`
--
ALTER TABLE `tblbook`
  ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `tblbroom`
--
ALTER TABLE `tblbroom`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `tblhotel`
--
ALTER TABLE `tblhotel`
  ADD PRIMARY KEY (`hid`);

--
-- Indexes for table `tblmall`
--
ALTER TABLE `tblmall`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `tblmusiam`
--
ALTER TABLE `tblmusiam`
  ADD PRIMARY KEY (`musiam_id`);

--
-- Indexes for table `tblpark`
--
ALTER TABLE `tblpark`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `tblrest`
--
ALTER TABLE `tblrest`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `tbltemp`
--
ALTER TABLE `tbltemp`
  ADD PRIMARY KEY (`tid`);

--
-- Indexes for table `tbluser`
--
ALTER TABLE `tbluser`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tblbook`
--
ALTER TABLE `tblbook`
  MODIFY `bookid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tblbroom`
--
ALTER TABLE `tblbroom`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT for table `tblhotel`
--
ALTER TABLE `tblhotel`
  MODIFY `hid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tblmall`
--
ALTER TABLE `tblmall`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tblmusiam`
--
ALTER TABLE `tblmusiam`
  MODIFY `musiam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tblpark`
--
ALTER TABLE `tblpark`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tblrest`
--
ALTER TABLE `tblrest`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbltemp`
--
ALTER TABLE `tbltemp`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbluser`
--
ALTER TABLE `tbluser`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
