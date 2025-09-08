-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2025-09-08 12:31:30
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
(6, '測試用', '190'),
(7, 'test', '1');

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
(124, '6', '188', 0);

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
(1, '2025-08-30 05:20:00', '01_環境測試用', 2, '6'),
(2, '2025-08-12 17:00:00', '0812 課堂練習', 2, '5'),
(3, '2025-08-20 17:10:00', '0820 課堂練習', 1, '5'),
(4, '2025-08-31 23:59:00', '02_新增測試', 0, '6'),
(5, '2025-09-07 17:16:00', '內部測試', 1, '5'),
(6, '2025-09-06 03:50:00', 'test1', 1, '7'),
(7, '2025-09-14 16:05:00', 'test2', 1, '7');

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
(1, '5', '108'),
(2, '5', '183'),
(3, '5', '184'),
(4, '5', '185'),
(5, '5', '186'),
(6, '5', '187'),
(7, '5', '188'),
(8, '5', '189'),
(195, '6', '108'),
(196, '7', '188'),
(197, '7', '109');

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
(2, '40843121@nfu.edu.tw', 'Ss123', '衣', '庭磊', 0),
(3, '40843122@nfu.edu.tw', 'Ss123', '林', '書涵', 0),
(4, '40843123@nfu.edu.tw', 'Ss123', '張', '家豪', 0),
(5, '40843124@nfu.edu.tw', 'Ss123', '吳', '佩珊', 0),
(6, '40843125@nfu.edu.tw', 'Ss123', '黃', '柏宇', 0),
(7, '40843126@nfu.edu.tw', 'Ss123', '劉', '育瑄', 0),
(8, '40843127@nfu.edu.tw', 'Ss123', '蔡', '承翰', 0),
(9, '40843128@nfu.edu.tw', 'Ss123', '許', '家妤', 0),
(10, '40843129@nfu.edu.tw', 'Ss123', '郭', '俊維', 0),
(11, '40843130@nfu.edu.tw', 'Ss123', '曾', '昱婷', 0),
(12, '40843131@nfu.edu.tw', 'Ss123', '鄭', '皓元', 0),
(13, '40843132@nfu.edu.tw', 'Ss123', '邱', '子瑜', 0),
(14, '40843133@nfu.edu.tw', 'Ss123', '洪', '庭萱', 0),
(15, '40843134@nfu.edu.tw', 'Ss123', '吳', '俊霖', 0),
(16, '40843135@nfu.edu.tw', 'Ss123', '蔡', '宜芳', 0),
(17, '40843136@nfu.edu.tw', 'Ss123', '賴', '柏勳', 0),
(18, '40843137@nfu.edu.tw', 'Ss123', '曾', '郁婷', 0),
(19, '40843138@nfu.edu.tw', 'Ss123', '徐', '子翔', 0),
(20, '40843139@nfu.edu.tw', 'Ss123', '許', '雅筑', 0),
(21, '40843140@nfu.edu.tw', 'Ss123', '李', '承哲', 0),
(22, '40843141@nfu.edu.tw', 'Ss123', '黃', '品蓁', 0),
(23, '40843142@nfu.edu.tw', 'Ss123', '邱', '柏豪', 0),
(24, '40843143@nfu.edu.tw', 'Ss123', '張', '郁柔', 0),
(25, '40843144@nfu.edu.tw', 'Ss123', '劉', '彥廷', 0),
(26, '40843145@nfu.edu.tw', 'Ss123', '陳', '妍希', 0),
(27, '40843146@nfu.edu.tw', 'Ss123', '林', '昱廷', 0),
(28, '40843147@nfu.edu.tw', 'Ss123', '吳', '佳瑩', 0),
(29, '40843148@nfu.edu.tw', 'Ss123', '王', '宥翔', 0),
(30, '40843149@nfu.edu.tw', 'Ss123', '鄭', '雅涵', 0),
(31, '40843150@nfu.edu.tw', 'Ss123', '曾', '品妤', 0),
(32, '40843151@nfu.edu.tw', 'Ss123', '賴', '俊傑', 0),
(33, '40843152@nfu.edu.tw', 'Ss123', '許', '怡君', 0),
(34, '40843153@nfu.edu.tw', 'Ss123', '李', '承恩', 0),
(35, '40843154@nfu.edu.tw', 'Ss123', '張', '恩綺', 0),
(36, '40843155@nfu.edu.tw', 'Ss123', '劉', '庭萱', 0),
(37, '40843156@nfu.edu.tw', 'Ss123', '洪', '柏翰', 0),
(38, '40843157@nfu.edu.tw', 'Ss123', '黃', '郁庭', 0),
(39, '40843158@nfu.edu.tw', 'Ss123', '邱', '昱蓉', 0),
(40, '40843159@nfu.edu.tw', 'Ss123', '吳', '承宇', 0),
(41, '40843160@nfu.edu.tw', 'Ss123', '林', '佳蓉', 0),
(42, '40843161@nfu.edu.tw', 'Ss123', '陳', '冠廷', 0),
(43, '40843162@nfu.edu.tw', 'Ss123', '許', '婉婷', 0),
(44, '40843163@nfu.edu.tw', 'Ss123', '曾', '子晴', 0),
(45, '40843164@nfu.edu.tw', 'Ss123', '王', '柏儒', 0),
(46, '40843165@nfu.edu.tw', 'Ss123', '李', '庭瑜', 0),
(47, '41043218@nfu.edu.tw', 'Ss123', '陳', '荔群', 0),
(48, '41043232@nfu.edu.tw', 'Ss123', '廖', '浚宏', 0),
(49, '40743207@nfu.edu.tw', 'Ss123', '王', '立權', 0),
(50, '40843109@nfu.edu.tw', 'Ss123', '林', '正晟', 0),
(51, '40843240@nfu.edu.tw', 'Ss123', '張', '繼允', 0),
(52, '41043114@nfu.edu.tw', 'Ss123', '吳', '俊憲', 0),
(53, '41043116@nfu.edu.tw', 'Ss123', '吳', '枰樟', 0),
(54, '41043117@nfu.edu.tw', 'Ss123', '吳', '瑋修', 0),
(55, '41043118@nfu.edu.tw', 'Ss123', '呂', '昱諦', 0),
(56, '41043122@nfu.edu.tw', 'Ss123', '林', '弘昱', 0),
(57, '41043129@nfu.edu.tw', 'Ss123', '林', '傳勝', 0),
(58, '41043133@nfu.edu.tw', 'Ss123', '邱', '立翰', 0),
(59, '41043134@nfu.edu.tw', 'Ss123', '邱', '昱荏', 0),
(60, '41043141@nfu.edu.tw', 'Ss123', '徐', '睿澤', 0),
(61, '41043203@nfu.edu.tw', 'Ss123', '廖', '蓉棋', 0),
(62, '41043207@nfu.edu.tw', 'Ss123', '陳', '昀嶢', 0),
(63, '41043209@nfu.edu.tw', 'Ss123', '陳', '冠宏', 0),
(64, '41043220@nfu.edu.tw', 'Ss123', '曾', '聖傑', 0),
(65, '41043229@nfu.edu.tw', 'Ss123', '楊', '峻朋', 0),
(66, '41043237@nfu.edu.tw', 'Ss123', '劉', '祐睿', 0),
(67, '41043238@nfu.edu.tw', 'Ss123', '劉', '章佑', 0),
(68, '41043239@nfu.edu.tw', 'Ss123', '蔡', '今瑞', 0),
(69, '41043241@nfu.edu.tw', 'Ss123', '鄭', '丞皓', 0),
(70, '41043243@nfu.edu.tw', 'Ss123', '鄭', '朝棟', 0),
(71, '41043245@nfu.edu.tw', 'Ss123', '賴', '則仁', 0),
(72, '41043246@nfu.edu.tw', 'Ss123', '賴', '昱銘', 0),
(73, '41043247@nfu.edu.tw', 'Ss123', '薛', '椿儒', 0),
(74, '41043251@nfu.edu.tw', 'Ss123', '顏', '嘉福', 0),
(75, '41043254@nfu.edu.tw', 'Ss123', '羅', '國書', 0),
(76, '40840149@nfu.edu.tw', 'Ss123', '曹', '盛智', 0),
(77, '40943162@nfu.edu.tw', 'Ss123', '陳', '囿瑄', 0),
(78, '41043136@nfu.edu.tw', 'Ss123', '俞', '漢威', 0),
(79, '41043145@nfu.edu.tw', 'Ss123', '張', '宇成', 0),
(80, '41043152@nfu.edu.tw', 'Ss123', '許', '書和', 0),
(81, '41243213@nfu.edu.tw', 'Ss123', '王', '維德', 0),
(82, '40643149@nfu.edu.tw', 'Ss123', '雷', '務馨', 0),
(83, '40843226@nfu.edu.tw', 'Ss123', '柯', '致㨗', 0),
(84, '40943212@nfu.edu.tw', 'Ss123', '陳', '廷威', 0),
(85, '40943267@nfu.edu.tw', 'Ss123', '張', '敬典', 0),
(86, '41043208@nfu.edu.tw', 'Ss123', '陳', '易詮', 0),
(87, '41143125@nfu.edu.tw', 'Ss123', '邱', '品翰', 0),
(88, '41143201@nfu.edu.tw', 'Ss123', '吳', '佩儒', 0),
(89, '41243101@nfu.edu.tw', 'Ss123', '伍', '翊瑄', 0),
(90, '41243108@nfu.edu.tw', 'Ss123', '鄭', '又瑄', 0),
(91, '41243109@nfu.edu.tw', 'Ss123', '謝', '於潔', 0),
(92, '41243122@nfu.edu.tw', 'Ss123', '林', '建全', 0),
(93, '41243124@nfu.edu.tw', 'Ss123', '林', '聖紘', 0),
(94, '41243128@nfu.edu.tw', 'Ss123', '徐', '聖硯', 0),
(95, '41243129@nfu.edu.tw', 'Ss123', '張', '帟淇', 0),
(96, '41243130@nfu.edu.tw', 'Ss123', '張', '凱茗', 0),
(97, '41243133@nfu.edu.tw', 'Ss123', '郭', '至峻', 0),
(98, '41243142@nfu.edu.tw', 'Ss123', '彭', '偉倫', 0),
(99, '41243143@nfu.edu.tw', 'Ss123', '曾', '兆銘', 0),
(100, '41243144@nfu.edu.tw', 'Ss123', '温', '博鈞', 0),
(101, '41243145@nfu.edu.tw', 'Ss123', '黃', '培峰', 0),
(102, '41243146@nfu.edu.tw', 'Ss123', '黃', '境安', 0),
(103, '41243149@nfu.edu.tw', 'Ss123', '廖', '章竹', 0),
(104, '41243150@nfu.edu.tw', 'Ss123', '劉', '力行', 0),
(105, '41243151@nfu.edu.tw', 'Ss123', '劉', '向榮', 0),
(106, '41243152@nfu.edu.tw', 'Ss123', '劉', '康申', 0),
(107, '41243153@nfu.edu.tw', 'Ss123', '蔡', '承廷', 0),
(108, '41243154@nfu.edu.tw', 'Ss123', '蔡', '品辰', 0),
(109, '41243155@nfu.edu.tw', 'Ss123', '鄭', '師墉', 0),
(110, '41243156@nfu.edu.tw', 'Ss123', '謝', '宏喆', 0),
(111, '41243163@nfu.edu.tw', 'Ss123', '陳', '楷翔', 0),
(112, '41243201@nfu.edu.tw', 'Ss123', '吳', '佳璇', 0),
(113, '41243202@nfu.edu.tw', 'Ss123', '林', '沛慧', 0),
(114, '41243203@nfu.edu.tw', 'Ss123', '林', '映辰', 0),
(115, '41243204@nfu.edu.tw', 'Ss123', '張', '品薰', 0),
(116, '41243205@nfu.edu.tw', 'Ss123', '黃', '詩方', 0),
(117, '41243208@nfu.edu.tw', 'Ss123', '蕭', '昱糖', 0),
(118, '41243210@nfu.edu.tw', 'Ss123', '王', '宜平', 0),
(119, '41243211@nfu.edu.tw', 'Ss123', '王', '翔禹', 0),
(120, '41243216@nfu.edu.tw', 'Ss123', '李', '宗燁', 0),
(121, '41243217@nfu.edu.tw', 'Ss123', '杜', '長勳', 0),
(122, '41243218@nfu.edu.tw', 'Ss123', '林', '承志', 0),
(123, '41243219@nfu.edu.tw', 'Ss123', '林', '厚丞', 0),
(124, '41243221@nfu.edu.tw', 'Ss123', '林', '榆傑', 0),
(125, '41243222@nfu.edu.tw', 'Ss123', '林', '諺晟', 0),
(126, '41243224@nfu.edu.tw', 'Ss123', '范', '鼎新', 0),
(127, '41243225@nfu.edu.tw', 'Ss123', '徐', '祥恩', 0),
(128, '41243226@nfu.edu.tw', 'Ss123', '張', '立名', 0),
(129, '41243227@nfu.edu.tw', 'Ss123', '張', '志華', 0),
(130, '41243231@nfu.edu.tw', 'Ss123', '許', '舜曄', 0),
(131, '41243232@nfu.edu.tw', 'Ss123', '郭', '廷威', 0),
(132, '41243233@nfu.edu.tw', 'Ss123', '郭', '思翰', 0),
(133, '41243235@nfu.edu.tw', 'Ss123', '陳', '佳源', 0),
(134, '41243236@nfu.edu.tw', 'Ss123', '陳', '柏丞', 0),
(135, '41243237@nfu.edu.tw', 'Ss123', '陳', '柏勳', 0),
(136, '41243240@nfu.edu.tw', 'Ss123', '傅', '學呈', 0),
(137, '41243243@nfu.edu.tw', 'Ss123', '黃', '安可', 0),
(138, '41243244@nfu.edu.tw', 'Ss123', '黃', '順駿', 0),
(139, '41243245@nfu.edu.tw', 'Ss123', '楊', '承穎', 0),
(140, '41243249@nfu.edu.tw', 'Ss123', '劉', '仲恩', 0),
(141, '41243250@nfu.edu.tw', 'Ss123', '劉', '宗修', 0),
(142, '41243251@nfu.edu.tw', 'Ss123', '潘', '彥愷', 0),
(143, '41243252@nfu.edu.tw', 'Ss123', '蔡', '承叡', 0),
(144, '41243253@nfu.edu.tw', 'Ss123', '蔡', '政傑', 0),
(145, '41243254@nfu.edu.tw', 'Ss123', '蕭', '楷翰', 0),
(146, '41243256@nfu.edu.tw', 'Ss123', '藍', '憲廷', 0),
(147, '50915128@nfu.edu.tw', 'Ss123', '林', '美呈', 0),
(148, '41043244@nfu.edu.tw', 'Ss123', '賴', '明賢', 0),
(149, '41243111@nfu.edu.tw', 'Ss123', '王', '家偉', 0),
(150, '41143112@nfu.edu.tw', 'Ss123', '吳', '俊彥', 0),
(151, '40939226@nfu.edu.tw', 'Ss123', '黃', '昱翔', 0),
(152, '40943122@nfu.edu.tw', 'Ss123', '李', '邦任', 0),
(153, '41136110@nfu.edu.tw', 'Ss123', '林', '冠佑', 0),
(154, '41143110@nfu.edu.tw', 'Ss123', '何', '柏鋒', 0),
(155, '41143118@nfu.edu.tw', 'Ss123', '周', '訓麒', 0),
(156, '41143144@nfu.edu.tw', 'Ss123', '黃', '楷華', 0),
(157, '41143145@nfu.edu.tw', 'Ss123', '楊', '柏文', 0),
(158, '41143251@nfu.edu.tw', 'Ss123', '蔡', '沅杰', 0),
(159, '41143254@nfu.edu.tw', 'Ss123', '鄭', '名男', 0),
(160, '40943127@nfu.edu.tw', 'Ss123', '李', '庠宇', 0),
(161, '40943132@nfu.edu.tw', 'Ss123', '周', '帥', 0),
(162, '40943257@nfu.edu.tw', 'Ss123', '蘇', '偉勝', 0),
(163, '40943260@nfu.edu.tw', 'Ss123', '張', '覲顯', 0),
(164, '41136111@nfu.edu.tw', 'Ss123', '林', '國善', 0),
(165, '41143116@nfu.edu.tw', 'Ss123', '沈', '振碩', 0),
(166, '41143122@nfu.edu.tw', 'Ss123', '林', '柏儒', 0),
(167, '41143124@nfu.edu.tw', 'Ss123', '林', '語駿', 0),
(168, '41143146@nfu.edu.tw', 'Ss123', '楊', '道恩', 0),
(169, '41143151@nfu.edu.tw', 'Ss123', '蔡', '仲威', 0),
(170, '41143209@nfu.edu.tw', 'Ss123', '王', '忠仁', 0),
(171, '41143213@nfu.edu.tw', 'Ss123', '吳', '哲瑋', 0),
(172, '41143219@nfu.edu.tw', 'Ss123', '周', '偉宸', 0),
(173, '41143238@nfu.edu.tw', 'Ss123', '陳', '峻宇', 0),
(174, '41143241@nfu.edu.tw', 'Ss123', '黃', '子峻', 0),
(175, '41143248@nfu.edu.tw', 'Ss123', '劉', '向宏', 0),
(176, '41143249@nfu.edu.tw', 'Ss123', '劉', '幸恩', 0),
(177, '41143255@nfu.edu.tw', 'Ss123', '鄭', '峻和', 0),
(178, '41143263@nfu.edu.tw', 'Ss123', '黃', '柏菻', 0),
(179, '41143264@nfu.edu.tw', 'Ss123', '楊', '育哲', 0),
(180, '40925108@nfu.edu.tw', 'Ss123', '石', '皓文', 0),
(181, '40947226@nfu.edu.tw', 'Ss123', '楊', '其軒', 0),
(182, '40971122@nfu.edu.tw', 'Ss123', '李', '承祐', 0),
(183, 'a2004jerry@gmail.com', 'Ss123', '王', '翔禹', 0),
(184, 'wwu22612@gmail.com', '126180807', '張', '楷昊', 0),
(185, 'tad960526@gmail.com', 'Ren94799', '張', '嘉仁', 0),
(186, 'bonny.fy@gmail.com', 'tomomo100', '陳', '邦譽', 0),
(187, 'connor12345960515@gmail.com', 'connor960515', '孫', '益康', 0),
(188, 'test@nfu.edu.tw', '1234', '鄭', '師墉', 0),
(189, '123456789987654321gga@gmail.com', 'a5522678', '張', '鈞閔', 0),
(190, 'teacher', '1234', '1', '234', 1),
(10000091, '412431556@nfu.edu.tw', '1234', '鄭', '師墉', 1);

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
  ADD PRIMARY KEY (`UserID`),
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `results`
--
ALTER TABLE `results`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1101;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `student`
--
ALTER TABLE `student`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=198;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `waitjoinclass`
--
ALTER TABLE `waitjoinclass`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
