/*
Navicat MySQL Data Transfer

Source Server         : MyLinux
Source Server Version : 50709
Source Host           : 123.206.8.178:3306
Source Database       : jobtitleevaluation

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-10-16 19:58:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `evaluatedstandard`
-- ----------------------------
DROP TABLE IF EXISTS `evaluatedstandard`;
CREATE TABLE `evaluatedstandard` (
  `evalStan_id` int(11) NOT NULL AUTO_INCREMENT,
  `evalStan_moralityStandard` varchar(255) DEFAULT NULL,
  `evalStan_scientifiStandard` varchar(255) DEFAULT NULL,
  `evalStan_teachStandard` varchar(255) DEFAULT NULL,
  `evalStan_jobtile_jobTi_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`evalStan_id`),
  KEY `FK_8d9ror7uhwc3ne9lnfhoi2s8s` (`evalStan_jobtile_jobTi_id`),
  CONSTRAINT `FK_8d9ror7uhwc3ne9lnfhoi2s8s` FOREIGN KEY (`evalStan_jobtile_jobTi_id`) REFERENCES `jobtitle` (`jobTi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluatedstandard
-- ----------------------------
INSERT INTO `evaluatedstandard` VALUES ('1', '是否教书育人，为人事表，具有较好的思想政治素质和职业道德。', '是否形成了稳定的研究方向和系统的研究成果；具有较高的学艺造诣，能及时把握本学科领域前沿发展动态，具有主持和指导科学研究和学术创新的能力，沦为具有较高的学术价值，著作，教材具有较高的学术水平和应用价值', '是否系统担任两门以上主干课程的讲授工作，每学年至少教授一门课程，教学效果优秀；具有主持本学科教育教学改革研究的能力。', '1');
INSERT INTO `evaluatedstandard` VALUES ('2', '是否教书育人，为人师表，具有较好的思想政治素质和职业道德。', '是否形成了比较稳定的研究方向；能及时把握笨学科流域前沿发展动态，具有较强的焦距教学和科学研究能力；论文具有较高的学术价值，著作、教材具有较高的学术谁评和应用价值。', '是否系统担任一门公共课、基础课或两门以上专业课程的讲授工作，每学年至少讲授一门课程；教学效果优秀；积极开展本学成教育教学改革研究。', '2');
INSERT INTO `evaluatedstandard` VALUES ('3', '是否教书育人，为人师表，具有较好的思想政治素质和职业道德。', '是否掌握本学科国内外实验技术现状和发展趋势；具备指导大型实验技术工作以及解决关键性技术问题的能力；论文具有较高的学术价值，著作、教材具有较高的学术水平和应用价值。', '是否积极完成学校规定的工作任务；能独立、熟练承担本专业实验课程；能够独立地创造或改善实验条件，设计、加工特殊实验装置，改进有关仪器设备性能指标，独立承担精密仪器、大型设备的调试、维护、建修、故障排除等。', '3');
INSERT INTO `evaluatedstandard` VALUES ('4', '是否教书育人，为人师表，具有较好的思想政治素质和职业道德。', '是否掌握本学科国内外实验技术现状和发展趋势；具备指导大型实验技术工作以及解决关键性技术问题的能力；论文具有较高的学术价值，著作、教材具有较高的学术水平和应用价值。', '是否系统担任两门以上主干课程的讲授工作，每学年至少教授一门课程，教学效果优秀；具有主持本学科教育教学改革研究的能力。', '4');
INSERT INTO `evaluatedstandard` VALUES ('5', '是否教书育人，为人事表，具有较好的思想政治素质和职业道德。', '是否形成了比较稳定的研究方向；能及时把握笨学科流域前沿发展动态，具有较强的焦距教学和科学研究能力；论文具有较高的学术价值，著作、教材具有较高的学术谁评和应用价值。', '是否系统担任两门以上主干课程的讲授工作，每学年至少教授一门课程，教学效果优秀；具有主持本学科教育教学改革研究的能力。', '5');

-- ----------------------------
-- Table structure for `evaluaterecord`
-- ----------------------------
DROP TABLE IF EXISTS `evaluaterecord`;
CREATE TABLE `evaluaterecord` (
  `evalrecor_id` int(11) NOT NULL AUTO_INCREMENT,
  `evalRecor_allAssessment` varchar(255) DEFAULT NULL,
  `evalRecor_ethics` varchar(255) DEFAULT NULL,
  `evalRecor_research` varchar(255) DEFAULT NULL,
  `evalRecor_spciaFamiliar` varchar(255) DEFAULT NULL,
  `evalRecor_teaching` varchar(255) DEFAULT NULL,
  `evalRecor_expart_exp_id` int(11) DEFAULT NULL,
  `evalRecor_participatedPerson_parti_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`evalrecor_id`),
  KEY `FK_m1xvfehfe1p1x00c2121784aw` (`evalRecor_expart_exp_id`),
  KEY `FK_7dyn20m3yf4ojnwqx04ahufdx` (`evalRecor_participatedPerson_parti_id`),
  CONSTRAINT `FK_7dyn20m3yf4ojnwqx04ahufdx` FOREIGN KEY (`evalRecor_participatedPerson_parti_id`) REFERENCES `participateperson` (`parti_id`),
  CONSTRAINT `FK_m1xvfehfe1p1x00c2121784aw` FOREIGN KEY (`evalRecor_expart_exp_id`) REFERENCES `expert` (`exp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluaterecord
-- ----------------------------

-- ----------------------------
-- Table structure for `expert`
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `exp_id` int(11) NOT NULL AUTO_INCREMENT,
  `exp_accountNum` varchar(255) DEFAULT NULL,
  `exp_educationLevel` varchar(255) DEFAULT NULL,
  `exp_name` varchar(255) DEFAULT NULL,
  `exp_password` varchar(255) DEFAULT NULL,
  `exp_jobTitle_jobTi_id` int(11) DEFAULT NULL,
  `exp_specialty_spec_id` int(11) DEFAULT NULL,
  `exp_unit_uni_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `FK_lgqp8xjdf6mhjt414fbxyyrs4` (`exp_jobTitle_jobTi_id`),
  KEY `FK_eh1dvny84nq2347ymor95plg8` (`exp_specialty_spec_id`),
  KEY `FK_9bgjh64t750ad0pfyhj8e21jt` (`exp_unit_uni_id`),
  CONSTRAINT `FK_9bgjh64t750ad0pfyhj8e21jt` FOREIGN KEY (`exp_unit_uni_id`) REFERENCES `unit` (`uni_id`),
  CONSTRAINT `FK_eh1dvny84nq2347ymor95plg8` FOREIGN KEY (`exp_specialty_spec_id`) REFERENCES `specialty` (`spec_id`),
  CONSTRAINT `FK_lgqp8xjdf6mhjt414fbxyyrs4` FOREIGN KEY (`exp_jobTitle_jobTi_id`) REFERENCES `jobtitle` (`jobTi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert
-- ----------------------------

-- ----------------------------
-- Table structure for `jobtitle`
-- ----------------------------
DROP TABLE IF EXISTS `jobtitle`;
CREATE TABLE `jobtitle` (
  `jobTi_id` int(11) NOT NULL AUTO_INCREMENT,
  `jobTi_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jobTi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobtitle
-- ----------------------------
INSERT INTO `jobtitle` VALUES ('1', '教授');
INSERT INTO `jobtitle` VALUES ('2', '副教授');
INSERT INTO `jobtitle` VALUES ('3', '高级实验师');
INSERT INTO `jobtitle` VALUES ('4', '讲师');
INSERT INTO `jobtitle` VALUES ('5', '实验师');

-- ----------------------------
-- Table structure for `participateperson`
-- ----------------------------
DROP TABLE IF EXISTS `participateperson`;
CREATE TABLE `participateperson` (
  `parti_id` int(11) NOT NULL AUTO_INCREMENT,
  `parti_name` varchar(255) DEFAULT NULL,
  `parti_pathurl` varchar(255) DEFAULT NULL,
  `parti_jobTitle_jobTi_id` int(11) DEFAULT NULL,
  `parti_recommendUnit_uni_id` int(11) DEFAULT NULL,
  `parti_specialty_spec_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`parti_id`),
  KEY `FK_j2pf81pqsshfsk9ii6mi2cgjo` (`parti_jobTitle_jobTi_id`),
  KEY `FK_7slr908cd1eg3xglfqqh522y3` (`parti_recommendUnit_uni_id`),
  KEY `FK_gsknt1mx0tgwof2iykwtgtjp7` (`parti_specialty_spec_id`),
  CONSTRAINT `FK_7slr908cd1eg3xglfqqh522y3` FOREIGN KEY (`parti_recommendUnit_uni_id`) REFERENCES `unit` (`uni_id`),
  CONSTRAINT `FK_gsknt1mx0tgwof2iykwtgtjp7` FOREIGN KEY (`parti_specialty_spec_id`) REFERENCES `specialty` (`spec_id`),
  CONSTRAINT `FK_j2pf81pqsshfsk9ii6mi2cgjo` FOREIGN KEY (`parti_jobTitle_jobTi_id`) REFERENCES `jobtitle` (`jobTi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of participateperson
-- ----------------------------

-- ----------------------------
-- Table structure for `requestcode`
-- ----------------------------
DROP TABLE IF EXISTS `requestcode`;
CREATE TABLE `requestcode` (
  `reqCode_id` int(11) NOT NULL AUTO_INCREMENT,
  `reqCode_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reqCode_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requestcode
-- ----------------------------
INSERT INTO `requestcode` VALUES ('1', 'YlAxRkFgdq7wOjgW');

-- ----------------------------
-- Table structure for `specialty`
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `spec_id` int(11) NOT NULL AUTO_INCREMENT,
  `spec_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`spec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialty
-- ----------------------------
INSERT INTO `specialty` VALUES ('1', '哲学');
INSERT INTO `specialty` VALUES ('2', '经济学');
INSERT INTO `specialty` VALUES ('3', '法学');
INSERT INTO `specialty` VALUES ('4', '政治学');
INSERT INTO `specialty` VALUES ('5', '马克思主义理论');
INSERT INTO `specialty` VALUES ('6', '就业指导');
INSERT INTO `specialty` VALUES ('7', '教育学');
INSERT INTO `specialty` VALUES ('8', '心理学');
INSERT INTO `specialty` VALUES ('9', '体育学');
INSERT INTO `specialty` VALUES ('10', '中国语言文学');
INSERT INTO `specialty` VALUES ('11', '外国语言文学');
INSERT INTO `specialty` VALUES ('12', '新闻传播学');
INSERT INTO `specialty` VALUES ('13', '历史学');
INSERT INTO `specialty` VALUES ('14', '数学');
INSERT INTO `specialty` VALUES ('15', '物理学');
INSERT INTO `specialty` VALUES ('16', '化学');
INSERT INTO `specialty` VALUES ('17', '地理学');
INSERT INTO `specialty` VALUES ('18', '生物学');
INSERT INTO `specialty` VALUES ('19', '统计学');
INSERT INTO `specialty` VALUES ('20', '机械工程');
INSERT INTO `specialty` VALUES ('21', '材料科学与工程');
INSERT INTO `specialty` VALUES ('22', '电气工程');
INSERT INTO `specialty` VALUES ('23', '电子科学与技术');
INSERT INTO `specialty` VALUES ('24', '信息与通信工程');
INSERT INTO `specialty` VALUES ('25', '计算机科学与技术');
INSERT INTO `specialty` VALUES ('26', '建筑学');
INSERT INTO `specialty` VALUES ('27', '土木工程');
INSERT INTO `specialty` VALUES ('28', '水利工程');
INSERT INTO `specialty` VALUES ('29', '化学工程与技术');
INSERT INTO `specialty` VALUES ('30', '地质资源与地质工程');
INSERT INTO `specialty` VALUES ('31', '纺织科学与工程(新增)');
INSERT INTO `specialty` VALUES ('32', '轻工技术与工程');
INSERT INTO `specialty` VALUES ('33', '环境科学与工程');
INSERT INTO `specialty` VALUES ('34', '食品科学与工程');
INSERT INTO `specialty` VALUES ('35', '作物学');
INSERT INTO `specialty` VALUES ('36', '园艺学');
INSERT INTO `specialty` VALUES ('37', '畜牧学');
INSERT INTO `specialty` VALUES ('38', '兽医学');
INSERT INTO `specialty` VALUES ('39', '林学');
INSERT INTO `specialty` VALUES ('40', '基础医学');
INSERT INTO `specialty` VALUES ('41', '临床医学');
INSERT INTO `specialty` VALUES ('42', '公共卫生与预防医学');
INSERT INTO `specialty` VALUES ('43', '中医学');
INSERT INTO `specialty` VALUES ('44', '药学');
INSERT INTO `specialty` VALUES ('45', '中药学');
INSERT INTO `specialty` VALUES ('46', '护理学');
INSERT INTO `specialty` VALUES ('47', '管理科学与工程');
INSERT INTO `specialty` VALUES ('48', '工商管理');
INSERT INTO `specialty` VALUES ('49', '公共管理');
INSERT INTO `specialty` VALUES ('50', '艺术学');
INSERT INTO `specialty` VALUES ('51', '音乐与舞蹈学');
INSERT INTO `specialty` VALUES ('52', '戏剧与影视学');
INSERT INTO `specialty` VALUES ('53', '美术学');
INSERT INTO `specialty` VALUES ('54', '设计学');

-- ----------------------------
-- Table structure for `statistics`
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `sta_id` int(11) NOT NULL AUTO_INCREMENT,
  `sta_AScored` float NOT NULL,
  `sta_AllScored` float NOT NULL,
  `sta_BScored` float NOT NULL,
  `sta_CScored` float NOT NULL,
  `sta_participatedPerson_parti_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sta_id`),
  KEY `FK_h5ux2tmhlkyf3qwvfg1h2p6h0` (`sta_participatedPerson_parti_id`),
  CONSTRAINT `FK_h5ux2tmhlkyf3qwvfg1h2p6h0` FOREIGN KEY (`sta_participatedPerson_parti_id`) REFERENCES `participateperson` (`parti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statistics
-- ----------------------------

-- ----------------------------
-- Table structure for `supermanager`
-- ----------------------------
DROP TABLE IF EXISTS `supermanager`;
CREATE TABLE `supermanager` (
  `sup_id` int(11) NOT NULL AUTO_INCREMENT,
  `sup_accountNum` varchar(255) DEFAULT NULL,
  `sup_name` varchar(255) DEFAULT NULL,
  `sup_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supermanager
-- ----------------------------
INSERT INTO `supermanager` VALUES ('1', 'rsc', '超级管理员', '3040777');

-- ----------------------------
-- Table structure for `unit`
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `uni_id` int(11) NOT NULL AUTO_INCREMENT,
  `uni_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uni_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES ('1', '生命科技学院');
INSERT INTO `unit` VALUES ('2', '经济与管理学院');
INSERT INTO `unit` VALUES ('3', '机电学院');
INSERT INTO `unit` VALUES ('4', '食品学院');
INSERT INTO `unit` VALUES ('5', '动物科技学院');
INSERT INTO `unit` VALUES ('6', '园艺园林学院');
INSERT INTO `unit` VALUES ('7', '资源与环境学院');
INSERT INTO `unit` VALUES ('8', '信息工程学院');
INSERT INTO `unit` VALUES ('9', '化学化工学院');
INSERT INTO `unit` VALUES ('10', '文法学院');
INSERT INTO `unit` VALUES ('11', '教育科学学院');
INSERT INTO `unit` VALUES ('12', '艺术学院');
INSERT INTO `unit` VALUES ('13', '服装学院');
INSERT INTO `unit` VALUES ('14', '数学科学学院');
INSERT INTO `unit` VALUES ('15', '外国语学院');
INSERT INTO `unit` VALUES ('16', '体育学院');
INSERT INTO `unit` VALUES ('17', '马克思主义教育学院');
INSERT INTO `unit` VALUES ('18', '高等职业技术学院');
INSERT INTO `unit` VALUES ('19', '新科学院');
INSERT INTO `unit` VALUES ('20', '党校');
INSERT INTO `unit` VALUES ('21', '招生就业处');
INSERT INTO `unit` VALUES ('22', '实验中心');
DROP TRIGGER IF EXISTS `person_delete`;
DELIMITER ;;
CREATE TRIGGER `person_delete` BEFORE DELETE ON `participateperson` FOR EACH ROW begin

 delete from evaluaterecord where evalRecor_participatedPerson_parti_id=old.parti_id;

 delete from statistics where sta_participatedPerson_parti_id=old.parti_id;
end
;;
DELIMITER ;
