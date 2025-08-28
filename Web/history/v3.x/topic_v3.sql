-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2025-08-28 09:14:07
-- 伺服器版本： 10.4.32-MariaDB
-- PHP 版本： 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `topic`
--

-- --------------------------------------------------------

--
-- 資料表結構 `assignments`
--

CREATE TABLE `assignments` (
  `assignment_no` char(8) NOT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- 傾印資料表的資料 `assignments`
--

INSERT INTO `assignments` (`assignment_no`, `title`) VALUES
('25080501', '第1次作業'),
('25080502', '第2次作業');

-- --------------------------------------------------------

--
-- 資料表結構 `classes`
--

CREATE TABLE `classes` (
  `ClassID` char(8) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `TeacherID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- 傾印資料表的資料 `classes`
--

INSERT INTO `classes` (`ClassID`, `Name`, `TeacherID`) VALUES
('11321958', '行動裝置3D程式開發實習', 1),
('11430001', '資料庫系統', 2),
('11430002', '作業系統', 3);

-- --------------------------------------------------------

--
-- 資料表結構 `courselist`
--

CREATE TABLE `courselist` (
  `EnrollID` int(11) NOT NULL,
  `ClassID` char(8) NOT NULL,
  `UserID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- 傾印資料表的資料 `courselist`
--

INSERT INTO `courselist` (`EnrollID`, `ClassID`, `UserID`) VALUES
(1, '11321958', 108),
(2, '11321958', 187),
(3, '11430001', 108);

-- --------------------------------------------------------

--
-- 資料表結構 `courses`
--

CREATE TABLE `courses` (
  `course_no` char(8) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- 傾印資料表的資料 `courses`
--

INSERT INTO `courses` (`course_no`, `name`) VALUES
('11430001', '資料庫系統'),
('11430002', '作業系統');

-- --------------------------------------------------------

--
-- 資料表結構 `users`
--

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `UserAccount` varchar(100) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `Job` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- 傾印資料表的資料 `users`
--

INSERT INTO users (UserID, UserAccount, Email, Password, FirstName, LastName, Job)
VALUES
(1,   'b12345',   'LinWJ@nfu.edu.tw', '1234', 'Lin', 'WJ', 1),
(108, '41243154', '41243154@nfu.edu.tw', 'Ss123', '蔡', '品辰', 0),
(187, 'g1234567', '1234@gmail.com', 'Gg432', '王', '小明', 0);

-- --------------------------------------------------------

--
-- 替換檢視表以便查看 `v_assignments`
-- (請參考以下實際畫面)
--
CREATE TABLE `v_assignments` (
`assignment_no` char(8)
,`yymmdd` varchar(6)
,`seq` varchar(2)
,`title` varchar(255)
);

-- --------------------------------------------------------

--
-- 替換檢視表以便查看 `v_courses`
-- (請參考以下實際畫面)
--
CREATE TABLE `v_courses` (
`course_no` char(8)
,`school_year` varchar(3)
,`semester` varchar(1)
,`course_code` varchar(4)
,`name` varchar(255)
);

-- --------------------------------------------------------

--
-- 檢視表結構 `v_assignments`
--
DROP TABLE IF EXISTS `v_assignments`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_assignments`  AS SELECT `assignments`.`assignment_no` AS `assignment_no`, substr(`assignments`.`assignment_no`,1,6) AS `yymmdd`, substr(`assignments`.`assignment_no`,7,2) AS `seq`, `assignments`.`title` AS `title` FROM `assignments` ;

-- --------------------------------------------------------

--
-- 檢視表結構 `v_courses`
--
DROP TABLE IF EXISTS `v_courses`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_courses`  AS SELECT `courses`.`course_no` AS `course_no`, substr(`courses`.`course_no`,1,3) AS `school_year`, substr(`courses`.`course_no`,4,1) AS `semester`, substr(`courses`.`course_no`,5,4) AS `course_code`, `courses`.`name` AS `name` FROM `courses` ;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`assignment_no`);

--
-- 資料表索引 `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`ClassID`);

--
-- 資料表索引 `courselist`
--
ALTER TABLE `courselist`
  ADD PRIMARY KEY (`EnrollID`);

--
-- 資料表索引 `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_no`);

--
-- 資料表索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `courselist`
--
ALTER TABLE `courselist`
  MODIFY `EnrollID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
