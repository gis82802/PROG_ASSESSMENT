-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2025-09-26 04:18:50
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
-- 資料表結構 `classes`
--

CREATE TABLE `classes` (
  `ClassID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `TeacherID` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `classes`
--

INSERT INTO `classes` (`ClassID`, `Name`, `TeacherID`) VALUES
(1, 'Java程式設計(111-2)', '1'),
(2, 'Java程式設計(112-2)', '1'),
(3, 'Java程式設計(113-1)', '1'),
(4, 'Java程式設計(113-2)', '1'),
(5, '113-3 Java暑修', '1'),
(6, '測試用', '2'),
(7, 'test', '1'),
(8, '114-1 Java程式設計(一)', '1');

-- --------------------------------------------------------

--
-- 資料表結構 `final`
--

CREATE TABLE `final` (
  `listID` int(11) NOT NULL,
  `HomeworkID` text NOT NULL,
  `StudentID` text NOT NULL,
  `Score` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `final`
--

INSERT INTO `final` (`listID`, `HomeworkID`, `StudentID`, `Score`) VALUES
(116, '5', '108', 0),
(117, '5', '183', 0),
(118, '5', '184', 0),
(119, '5', '185', 0),
(120, '5', '186', 0),
(121, '5', '187', 0),
(122, '5', '188', 0),
(123, '5', '189', 0),
(124, '6', '188', 0),
(125, '8', '100', 100),
(126, '8', '11', 90),
(127, '8', '12', 0),
(128, '8', '13', 90),
(129, '8', '14', 78),
(130, '8', '15', 90),
(131, '8', '16', 60),
(132, '8', '17', 90),
(133, '8', '18', 90),
(134, '8', '19', 90),
(135, '8', '20', 90),
(136, '8', '21', 90),
(137, '8', '22', 90),
(138, '8', '23', 90),
(139, '8', '24', 90),
(140, '8', '25', 65),
(141, '8', '26', 0),
(142, '8', '27', 85),
(143, '8', '28', 90),
(144, '8', '29', 90),
(145, '8', '30', 75),
(146, '8', '31', 75),
(147, '8', '32', 75),
(148, '8', '33', 90),
(149, '8', '34', 81),
(150, '8', '35', 71),
(151, '8', '36', 90),
(152, '8', '37', 75),
(153, '8', '38', 90),
(154, '8', '39', 90),
(155, '8', '40', 90),
(156, '8', '41', 90),
(157, '8', '42', 90),
(158, '8', '43', 90),
(159, '8', '44', 90),
(160, '8', '45', 90),
(161, '8', '46', 90),
(162, '8', '47', 90),
(163, '8', '48', 90),
(164, '8', '49', 85),
(165, '8', '50', 90),
(166, '8', '51', 90),
(167, '8', '52', 90),
(168, '8', '53', 90),
(169, '8', '54', 90),
(170, '8', '55', 90),
(171, '8', '56', 90),
(172, '8', '57', 90),
(173, '8', '58', 90),
(174, '8', '59', 90),
(175, '8', '60', 90),
(176, '8', '61', 90),
(177, '8', '62', 90),
(178, '8', '63', 78),
(179, '8', '64', 90),
(180, '8', '65', 90),
(181, '8', '66', 90),
(182, '8', '67', 90),
(183, '8', '68', 0),
(184, '8', '69', 85),
(185, '8', '70', 0),
(186, '8', '71', 90);

-- --------------------------------------------------------

--
-- 資料表結構 `homeworkslist`
--

CREATE TABLE `homeworkslist` (
  `HomeworkID` int(11) NOT NULL,
  `Deadline` datetime NOT NULL,
  `HomeworkName` text NOT NULL,
  `QuestionSum` int(2) NOT NULL,
  `ClassID` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `homeworkslist`
--

INSERT INTO `homeworkslist` (`HomeworkID`, `Deadline`, `HomeworkName`, `QuestionSum`, `ClassID`) VALUES
(1, '2025-09-30 23:20:00', '01_環境測試用', 2, '6'),
(2, '2025-08-12 17:00:00', '0812 課堂練習', 2, '5'),
(3, '2025-08-20 17:10:00', '0820 課堂練習', 1, '5'),
(4, '2025-08-31 23:59:00', '02_新增測試', 0, '6'),
(5, '2025-09-07 17:16:00', '內部測試', 1, '5'),
(6, '2025-09-06 03:50:00', 'test1', 1, '7'),
(7, '2025-09-14 16:05:00', 'test2', 1, '7'),
(8, '2025-09-19 11:59:00', '0919 課堂作業', 1, '8');

-- --------------------------------------------------------

--
-- 資料表結構 `results`
--

CREATE TABLE `results` (
  `listID` int(11) NOT NULL,
  `HomeworkID` text NOT NULL,
  `StudentID` text NOT NULL,
  `Question` int(2) NOT NULL,
  `Score` int(3) NOT NULL,
  `LLM` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `student`
--

CREATE TABLE `student` (
  `listID` int(11) NOT NULL,
  `ClassID` text NOT NULL,
  `StudentID` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `student`
--

INSERT INTO `student` (`listID`, `ClassID`, `StudentID`) VALUES
(1, '8', '11'),
(2, '8', '12'),
(3, '8', '13'),
(4, '8', '14'),
(5, '8', '15'),
(6, '8', '16'),
(7, '8', '17'),
(8, '8', '18'),
(9, '8', '19'),
(10, '8', '20'),
(11, '8', '21'),
(12, '8', '22'),
(13, '8', '23'),
(14, '8', '24'),
(15, '8', '25'),
(16, '8', '26'),
(17, '8', '27'),
(18, '8', '28'),
(19, '8', '29'),
(20, '8', '30'),
(21, '8', '31'),
(22, '8', '32'),
(23, '8', '33'),
(24, '8', '34'),
(25, '8', '35'),
(26, '8', '36'),
(27, '8', '37'),
(28, '8', '38'),
(29, '8', '39'),
(30, '8', '40'),
(31, '8', '41'),
(32, '8', '42'),
(33, '8', '43'),
(34, '8', '44'),
(35, '8', '45'),
(36, '8', '46'),
(37, '8', '47'),
(38, '8', '48'),
(39, '8', '49'),
(40, '8', '50'),
(41, '8', '51'),
(42, '8', '52'),
(43, '8', '53'),
(44, '8', '54'),
(45, '8', '55'),
(46, '8', '56'),
(47, '8', '57'),
(48, '8', '58'),
(49, '8', '59'),
(50, '8', '60'),
(51, '8', '61'),
(52, '8', '62'),
(53, '8', '63'),
(54, '8', '64'),
(55, '8', '65'),
(56, '8', '66'),
(57, '8', '67'),
(58, '8', '68'),
(59, '8', '69'),
(60, '8', '70'),
(61, '8', '71'),
(100, '8', '100'),
(198, '6', '100');

-- --------------------------------------------------------

--
-- 資料表結構 `users`
--

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `Email` text NOT NULL,
  `Password` text NOT NULL,
  `FirstName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `LastName` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Job` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `users`
--

INSERT INTO `users` (`UserID`, `Email`, `Password`, `FirstName`, `LastName`, `Job`) VALUES
(1, 'LinWJ@nfu.edu.tw', '1234', 'Lin', 'WJ', 1),
(2, 'teacher', '1234', '1', '234', 1),
(11, '41143122@nfu.edu.tw', 'Ss123', '林', '柏儒', 0),
(12, '41143224@nfu.edu.tw', 'Ss123', '林', '震宇', 0),
(13, '41243247@nfu.edu.tw', 'Ss123', '廖', '宥凱', 0),
(14, '41245139@nfu.edu.tw', 'Ss123', '林', '頌學', 0),
(15, '41343101@nfu.edu.tw', 'Ss123', '王', '薇詒大美女(神秘人到此一遊)', 0),
(16, '41343106@nfu.edu.tw', 'Ss123', '丁', '祥誌', 0),
(17, '41343107@nfu.edu.tw', 'Ss123', '王', '世豪', 0),
(18, '41343109@nfu.edu.tw', 'Ss123', '吳', '育丞', 0),
(19, '41343111@nfu.edu.tw', 'Ss123', '巫', '雨樹', 0),
(20, '41343112@nfu.edu.tw', 'Ss123', '李', '宗懌Epsilon大帥哥', 0),
(21, '41343119@nfu.edu.tw', 'Ss123', '金', '宗翰', 0),
(22, '41343121@nfu.edu.tw', '27994598', '徐', '唯祐', 0),
(23, '41343124@nfu.edu.tw', 'Ss123', '張', '豈睿', 0),
(24, '41343128@nfu.edu.tw', 'Ss123', '陳', '廷鑫大帥哥', 0),
(25, '41343131@nfu.edu.tw', '123635790', '陳', '宥儒', 0),
(26, '41343136@nfu.edu.tw', 'Ss123', '温', '禮全--溫大泉', 0),
(27, '41343137@nfu.edu.tw', 'Ss123', '游', '承宥', 0),
(28, '41343143@nfu.edu.tw', 'Ss123', '詹', '竣翔', 0),
(29, '41343150@nfu.edu.tw', 'Ss123', '薛', '莛穎大帥哥', 0),
(30, '41343202@nfu.edu.tw', 'Ss123', '倪', '怡卉', 0),
(31, '41343203@nfu.edu.tw', 'Ss123', '陳', '家翎', 0),
(32, '41343205@nfu.edu.tw', 'Ss123', '謝', '宜選', 0),
(33, '41343208@nfu.edu.tw', 'Ss123', '吳', '宇綸', 0),
(34, '41343209@nfu.edu.tw', 'Ss123', '吳', '邦睿', 0),
(35, '41343211@nfu.edu.tw', 'Ss123', '李', '佳興', 0),
(36, '41343212@nfu.edu.tw', 'eW91QXJlU3BhbQ==', '李', '品劭', 0),
(37, '41343214@nfu.edu.tw', 'Ss123', '沈', '世翔', 0),
(38, '41343215@nfu.edu.tw', 'Ss123', '林', '五樂', 0),
(39, '41343216@nfu.edu.tw', 'Ss123', '林', '政穎', 0),
(40, '41343217@nfu.edu.tw', 'Ss123', '林', '祐丞', 0),
(41, '41343219@nfu.edu.tw', 'Ss123', '姜', '伯叡', 0),
(42, '41343220@nfu.edu.tw', 'Ss123', '洪', '楷珉', 0),
(43, '41343221@nfu.edu.tw', 'Ss123', '徐', '慎彌', 0),
(44, '41343222@nfu.edu.tw', 'Ss123', '張', '弘穎(陳威佐到此一遊)', 0),
(45, '41343223@nfu.edu.tw', 'Ss123', '張', '佑安', 0),
(46, '41343224@nfu.edu.tw', 'Ss123', '張', '竣傑', 0),
(47, '41343226@nfu.edu.tw', 'Ss123', '許', '冠群', 0),
(48, '41343227@nfu.edu.tw', 'Ss123', '陳', '天霖', 0),
(49, '41343229@nfu.edu.tw', 'Ss123', '陳', '明正', 0),
(50, '41343231@nfu.edu.tw', 'Ss123', '陳', '威齊', 0),
(51, '41343232@nfu.edu.tw', 'Ss123', '陳', '彥宇', 0),
(52, '41343233@nfu.edu.tw', 'Ss123', '陳', '韋廷', 0),
(53, '41343234@nfu.edu.tw', 'Ss123', '陳', '睿捷', 0),
(54, '41343235@nfu.edu.tw', 'Ss123', '曾', '偉傑', 0),
(55, '41343236@nfu.edu.tw', 'Ss123', '游', '定叡', 0),
(56, '41343238@nfu.edu.tw', 'Ss123', '黃', '仕傑', 0),
(57, '41343239@nfu.edu.tw', 'Ss123', '黃', '致翔', 0),
(58, '41343240@nfu.edu.tw', 'Ss123', '黃', '榮裕', 0),
(59, '41343241@nfu.edu.tw', 'Ss123', '楊', '濰鴻', 0),
(60, '41343242@nfu.edu.tw', 'Ss123', '葛', '宸愷', 0),
(61, '41343247@nfu.edu.tw', 'Ss123', '盧', '冠宇', 0),
(62, '41343252@nfu.edu.tw', 'Ss123', '顏', '丞志', 0),
(63, '51015101@nfu.edu.tw', 'Ss123', '謝', '淇行', 0),
(64, '51015105@nfu.edu.tw', 'Ss123', '陳', '睿璿', 0),
(65, '51015108@nfu.edu.tw', 'Ss123', '王', '杰', 0),
(66, '51015114@nfu.edu.tw', 'Ss123', '彭', '裕軒', 0),
(67, '51015120@nfu.edu.tw', 'Ss123', '王', '之瑜', 0),
(68, '51015121@nfu.edu.tw', 'Ss123', '林', '誼旻', 0),
(69, '51015130@nfu.edu.tw', 'Ss123', '林', '敬雅', 0),
(70, '51015132@nfu.edu.tw', 'Ss123', '鄭', '睿軒', 0),
(71, '51015139@nfu.edu.tw', 'Ss123', '張', '博鈞', 0),
(100, '41243154@nfu.edu.tw', 'Ss123', '蔡', '品辰', 0),
(101, '41343131@nfu.deu.tw', '123635790', '陳', '宥儒', 0),
(102, 'a0967017679@gmail.com', 'a0967017679gmail##', '李', '佳興', 0);

-- --------------------------------------------------------

--
-- 資料表結構 `waitjoinclass`
--

CREATE TABLE `waitjoinclass` (
  `listID` int(11) NOT NULL,
  `StudentID` text NOT NULL,
  `TeacherID` text NOT NULL,
  `ClassID` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`ClassID`);

--
-- 資料表索引 `final`
--
ALTER TABLE `final`
  ADD PRIMARY KEY (`listID`);

--
-- 資料表索引 `homeworkslist`
--
ALTER TABLE `homeworkslist`
  ADD PRIMARY KEY (`HomeworkID`);

--
-- 資料表索引 `results`
--
ALTER TABLE `results`
  ADD PRIMARY KEY (`listID`);

--
-- 資料表索引 `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`listID`);

--
-- 資料表索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- 資料表索引 `waitjoinclass`
--
ALTER TABLE `waitjoinclass`
  ADD PRIMARY KEY (`listID`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `final`
--
ALTER TABLE `final`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `results`
--
ALTER TABLE `results`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1101;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `student`
--
ALTER TABLE `student`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=199;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `users`
--
ALTER TABLE `users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000092;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `waitjoinclass`
--
ALTER TABLE `waitjoinclass`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
