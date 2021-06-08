-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.9-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- goodee 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `goodee` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `goodee`;

-- 테이블 goodee.student 구조 내보내기
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `gender` enum('남자','여자') NOT NULL,
  `github_address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 테이블 데이터 goodee.student:~14 rows (대략적) 내보내기
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`, `gender`, `github_address`) VALUES
	(1, '강혜란', '여자', 'https://github.com/rani0331'),
	(2, '김서희', '여자', 'https://github.com/seoh2k'),
	(3, '김선유', '남자', 'https://github.com/mksunyou'),
	(4, '김태훈', '남자', 'https://github.com/sksskaw'),
	(5, '김희진', '여자', 'https://github.com/heejin1107'),
	(6, '남궁혜영', '여자', 'https://github.com/coke0788'),
	(7, '남민정', '여자', 'https://github.com/esse4542'),
	(8, '백영재', '남자', 'https://github.com/absence18'),
	(9, '손영현', '여자', 'https://github.com/briana9504'),
	(10, '이민호', '남자', 'https://github.com/7pokmon'),
	(11, '이윤정', '여자', 'https://github.com/yunjeomi'),
	(12, '이재범', '남자', 'https://github.com/JaeBeom-L'),
	(13, '최재현', '남자', 'https://github.com/pilming'),
	(14, '최정아', '여자', 'https://github.com/Jung-Ah-C'),
	(15, '홍민성', '남자', 'https://github.com/labote');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
