/*
Navicat MySQL Data Transfer

Source Server         : MyLinux
Source Server Version : 50709
Source Host           : 123.206.8.178:3306
Source Database       : jobtitleevaluation

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-10-15 11:46:38
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
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluaterecord
-- ----------------------------
INSERT INTO `evaluaterecord` VALUES ('14', '20', 'B', 'B', 'B', 'B', '58', '23');
INSERT INTO `evaluaterecord` VALUES ('15', '20', 'B', 'B', 'B', 'B', '58', '24');
INSERT INTO `evaluaterecord` VALUES ('16', '30', 'B', 'B', 'B', 'B', '58', '25');
INSERT INTO `evaluaterecord` VALUES ('17', '30', 'B', 'B', 'B', 'B', '58', '26');
INSERT INTO `evaluaterecord` VALUES ('18', '20', 'B', 'B', 'B', 'B', '58', '27');
INSERT INTO `evaluaterecord` VALUES ('19', '30', 'B', 'B', 'A', 'B', '58', '28');
INSERT INTO `evaluaterecord` VALUES ('20', '30', 'B', 'B', 'A', 'B', '58', '29');
INSERT INTO `evaluaterecord` VALUES ('21', '20', 'B', 'B', 'C', 'B', '58', '33');
INSERT INTO `evaluaterecord` VALUES ('22', '10', 'B', 'B', 'C', 'B', '58', '40');
INSERT INTO `evaluaterecord` VALUES ('23', '20', 'B', 'B', 'B', 'B', '58', '44');
INSERT INTO `evaluaterecord` VALUES ('24', '0', 'B', 'B', 'B', 'B', '58', '52');
INSERT INTO `evaluaterecord` VALUES ('25', '20', 'B', 'A', 'A', 'A', '56', '23');
INSERT INTO `evaluaterecord` VALUES ('26', '20', 'A', 'A', 'A', 'A', '57', '23');
INSERT INTO `evaluaterecord` VALUES ('27', '30', 'A', 'A', 'A', 'A', '54', '23');
INSERT INTO `evaluaterecord` VALUES ('28', '20', 'B', 'B', 'B', 'B', '54', '26');
INSERT INTO `evaluaterecord` VALUES ('29', '10', 'C', 'C', 'C', 'C', '57', '24');
INSERT INTO `evaluaterecord` VALUES ('30', '0', 'C', 'C', 'C', 'D', '56', '24');
INSERT INTO `evaluaterecord` VALUES ('31', '10', 'C', 'C', 'C', 'C', '54', '28');
INSERT INTO `evaluaterecord` VALUES ('32', '0', 'C', 'A', 'A', 'D', '57', '25');
INSERT INTO `evaluaterecord` VALUES ('33', '30', 'D', 'C', 'A', 'B', '56', '25');
INSERT INTO `evaluaterecord` VALUES ('34', '20', 'D', 'C', 'A', 'B', '54', '30');
INSERT INTO `evaluaterecord` VALUES ('35', '10', 'B', 'C', 'C', 'A', '57', '26');
INSERT INTO `evaluaterecord` VALUES ('36', '10', 'B', 'A', 'C', 'B', '56', '26');
INSERT INTO `evaluaterecord` VALUES ('37', '20', 'A', 'A', 'C', 'C', '54', '31');
INSERT INTO `evaluaterecord` VALUES ('38', '20', 'D', 'A', 'A', 'A', '54', '34');
INSERT INTO `evaluaterecord` VALUES ('39', '30', 'D', 'C', 'A', 'B', '56', '27');
INSERT INTO `evaluaterecord` VALUES ('40', '10', 'D', 'A', 'A', 'A', '54', '37');
INSERT INTO `evaluaterecord` VALUES ('41', '30', 'C', 'B', 'A', 'C', '55', '23');
INSERT INTO `evaluaterecord` VALUES ('42', '10', 'B', 'A', 'C', 'B', '56', '28');
INSERT INTO `evaluaterecord` VALUES ('43', '10', 'D', 'B', 'B', 'B', '54', '38');
INSERT INTO `evaluaterecord` VALUES ('44', '10', 'D', 'C', 'A', 'A', '55', '24');
INSERT INTO `evaluaterecord` VALUES ('45', '20', 'A', 'A', 'A', 'D', '54', '41');
INSERT INTO `evaluaterecord` VALUES ('46', '10', 'D', 'C', 'A', 'A', '59', '23');
INSERT INTO `evaluaterecord` VALUES ('47', '0', 'B', 'B', 'A', 'B', '58', '58');
INSERT INTO `evaluaterecord` VALUES ('48', '20', 'D', 'C', 'A', 'B', '56', '29');
INSERT INTO `evaluaterecord` VALUES ('49', '20', 'C', 'D', 'A', 'A', '55', '25');
INSERT INTO `evaluaterecord` VALUES ('50', '10', 'B', 'B', 'C', 'B', '58', '60');
INSERT INTO `evaluaterecord` VALUES ('51', '30', 'A', 'A', 'A', 'A', '61', '23');
INSERT INTO `evaluaterecord` VALUES ('52', '30', 'D', 'A', 'A', 'A', '54', '42');
INSERT INTO `evaluaterecord` VALUES ('53', '30', 'B', 'B', 'A', 'C', '55', '26');
INSERT INTO `evaluaterecord` VALUES ('54', '30', 'A', 'A', 'A', 'A', '54', '43');
INSERT INTO `evaluaterecord` VALUES ('55', '30', 'B', 'C', 'C', 'D', '56', '33');
INSERT INTO `evaluaterecord` VALUES ('56', '10', 'B', 'A', 'A', 'B', '61', '24');
INSERT INTO `evaluaterecord` VALUES ('57', '10', 'D', 'C', 'A', 'A', '59', '24');
INSERT INTO `evaluaterecord` VALUES ('58', '10', 'C', 'A', 'B', 'B', '61', '25');
INSERT INTO `evaluaterecord` VALUES ('59', '30', 'D', 'C', 'A', 'B', '56', '40');
INSERT INTO `evaluaterecord` VALUES ('60', '0', 'D', 'D', 'C', 'D', '54', '46');
INSERT INTO `evaluaterecord` VALUES ('61', '10', 'B', 'A', 'C', 'C', '59', '26');
INSERT INTO `evaluaterecord` VALUES ('62', '30', 'D', 'C', 'A', 'B', '61', '26');
INSERT INTO `evaluaterecord` VALUES ('63', '20', 'B', 'A', 'C', 'B', '54', '47');
INSERT INTO `evaluaterecord` VALUES ('64', '20', 'B', 'B', 'B', 'A', '55', '27');
INSERT INTO `evaluaterecord` VALUES ('65', '0', 'D', 'C', 'B', 'C', '61', '27');
INSERT INTO `evaluaterecord` VALUES ('66', '10', 'B', 'A', 'C', 'B', '56', '44');
INSERT INTO `evaluaterecord` VALUES ('67', '30', 'B', 'A', 'C', 'B', '54', '49');
INSERT INTO `evaluaterecord` VALUES ('68', '10', 'B', 'C', 'A', 'A', '59', '33');
INSERT INTO `evaluaterecord` VALUES ('69', '0', 'C', 'A', 'B', 'A', '55', '28');
INSERT INTO `evaluaterecord` VALUES ('70', '30', 'A', 'A', 'B', 'B', '61', '40');
INSERT INTO `evaluaterecord` VALUES ('71', '0', 'A', 'A', 'A', 'A', '54', '50');
INSERT INTO `evaluaterecord` VALUES ('72', '30', 'D', 'C', 'A', 'B', '56', '52');
INSERT INTO `evaluaterecord` VALUES ('73', '10', 'D', 'C', 'B', 'B', '61', '58');
INSERT INTO `evaluaterecord` VALUES ('74', '10', 'B', 'D', 'A', 'C', '59', '44');
INSERT INTO `evaluaterecord` VALUES ('75', '20', 'B', 'B', 'B', 'B', '61', '28');
INSERT INTO `evaluaterecord` VALUES ('76', '10', 'B', 'A', 'C', 'B', '56', '58');
INSERT INTO `evaluaterecord` VALUES ('77', '0', 'C', 'B', 'A', 'C', '55', '29');
INSERT INTO `evaluaterecord` VALUES ('78', '30', 'A', 'A', 'A', 'A', '54', '24');
INSERT INTO `evaluaterecord` VALUES ('79', '10', 'A', 'C', 'B', 'B', '59', '58');
INSERT INTO `evaluaterecord` VALUES ('80', '20', 'B', 'B', 'C', 'A', '57', '27');
INSERT INTO `evaluaterecord` VALUES ('81', '20', 'B', 'B', 'B', 'B', '54', '25');
INSERT INTO `evaluaterecord` VALUES ('82', '30', 'C', 'C', 'A', 'A', '61', '29');
INSERT INTO `evaluaterecord` VALUES ('83', '30', 'A', 'A', 'A', 'A', '54', '27');
INSERT INTO `evaluaterecord` VALUES ('84', '10', 'B', 'A', 'C', 'B', '56', '60');
INSERT INTO `evaluaterecord` VALUES ('85', '10', 'B', 'B', 'A', 'A', '55', '33');
INSERT INTO `evaluaterecord` VALUES ('86', '10', 'B', 'C', 'A', 'C', '57', '28');
INSERT INTO `evaluaterecord` VALUES ('87', '10', 'C', 'D', 'A', 'A', '59', '62');
INSERT INTO `evaluaterecord` VALUES ('88', '10', 'C', 'C', 'C', 'C', '54', '29');
INSERT INTO `evaluaterecord` VALUES ('89', '20', 'C', 'A', 'A', 'C', '61', '62');
INSERT INTO `evaluaterecord` VALUES ('90', '10', 'A', 'C', 'B', 'A', '57', '29');
INSERT INTO `evaluaterecord` VALUES ('91', '20', 'D', 'C', 'A', 'B', '54', '33');
INSERT INTO `evaluaterecord` VALUES ('92', '20', 'A', 'D', 'C', 'C', '55', '40');
INSERT INTO `evaluaterecord` VALUES ('93', '10', 'B', 'A', 'C', 'B', '56', '62');
INSERT INTO `evaluaterecord` VALUES ('94', '10', 'A', 'B', 'C', 'A', '57', '33');
INSERT INTO `evaluaterecord` VALUES ('95', '10', 'C', 'D', 'C', 'C', '61', '65');
INSERT INTO `evaluaterecord` VALUES ('96', '20', 'D', 'A', 'A', 'A', '54', '40');
INSERT INTO `evaluaterecord` VALUES ('97', '10', 'D', 'C', 'A', 'C', '59', '65');
INSERT INTO `evaluaterecord` VALUES ('98', '30', 'A', 'A', 'A', 'C', '57', '40');
INSERT INTO `evaluaterecord` VALUES ('99', '10', 'C', 'B', 'A', 'A', '55', '44');
INSERT INTO `evaluaterecord` VALUES ('100', '20', 'A', 'A', 'C', 'C', '54', '44');
INSERT INTO `evaluaterecord` VALUES ('101', '10', 'C', 'C', 'A', 'C', '61', '67');
INSERT INTO `evaluaterecord` VALUES ('102', '10', 'D', 'A', 'A', 'A', '54', '52');
INSERT INTO `evaluaterecord` VALUES ('103', '10', 'A', 'B', 'C', 'A', '57', '44');
INSERT INTO `evaluaterecord` VALUES ('104', '30', 'C', 'C', 'A', 'B', '56', '64');
INSERT INTO `evaluaterecord` VALUES ('105', '10', 'A', 'D', 'B', 'C', '59', '28');
INSERT INTO `evaluaterecord` VALUES ('106', '10', 'A', 'A', 'A', 'C', '55', '52');
INSERT INTO `evaluaterecord` VALUES ('107', '0', 'D', 'D', 'C', 'D', '54', '58');
INSERT INTO `evaluaterecord` VALUES ('108', '10', 'C', 'C', 'C', 'D', '61', '66');
INSERT INTO `evaluaterecord` VALUES ('109', '10', 'D', 'A', 'C', 'C', '59', '64');
INSERT INTO `evaluaterecord` VALUES ('110', '0', 'C', 'A', 'C', 'D', '55', '58');
INSERT INTO `evaluaterecord` VALUES ('111', '30', 'B', 'A', 'C', 'B', '54', '60');
INSERT INTO `evaluaterecord` VALUES ('112', '10', 'A', 'A', 'A', 'C', '57', '52');
INSERT INTO `evaluaterecord` VALUES ('113', '30', 'A', 'A', 'A', 'A', '54', '62');
INSERT INTO `evaluaterecord` VALUES ('114', '30', 'A', 'A', 'B', 'B', '61', '82');
INSERT INTO `evaluaterecord` VALUES ('115', '10', 'C', 'B', 'C', 'D', '59', '60');
INSERT INTO `evaluaterecord` VALUES ('116', '20', 'B', 'B', 'B', 'B', '54', '64');
INSERT INTO `evaluaterecord` VALUES ('117', '10', 'B', 'A', 'B', 'C', '55', '60');
INSERT INTO `evaluaterecord` VALUES ('118', '10', 'C', 'A', 'A', 'C', '57', '58');
INSERT INTO `evaluaterecord` VALUES ('119', '30', 'A', 'A', 'A', 'A', '54', '65');
INSERT INTO `evaluaterecord` VALUES ('120', '20', 'B', 'B', 'B', 'B', '54', '68');
INSERT INTO `evaluaterecord` VALUES ('121', '30', 'A', 'C', 'B', 'B', '59', '35');
INSERT INTO `evaluaterecord` VALUES ('122', '30', 'C', 'A', 'C', 'B', '57', '60');
INSERT INTO `evaluaterecord` VALUES ('123', '30', 'A', 'A', 'B', 'B', '55', '62');
INSERT INTO `evaluaterecord` VALUES ('124', '0', 'D', 'C', 'A', 'C', '61', '73');
INSERT INTO `evaluaterecord` VALUES ('125', '10', 'C', 'C', 'C', 'C', '54', '66');
INSERT INTO `evaluaterecord` VALUES ('126', '20', 'B', 'C', 'C', 'D', '59', '40');
INSERT INTO `evaluaterecord` VALUES ('127', '20', 'D', 'C', 'A', 'B', '54', '67');
INSERT INTO `evaluaterecord` VALUES ('128', '0', 'C', 'B', 'C', 'C', '55', '64');
INSERT INTO `evaluaterecord` VALUES ('129', '20', 'B', 'B', 'B', 'B', '54', '32');
INSERT INTO `evaluaterecord` VALUES ('130', '30', 'C', 'A', 'A', 'C', '61', '59');
INSERT INTO `evaluaterecord` VALUES ('131', '10', 'A', 'C', 'C', 'A', '57', '62');
INSERT INTO `evaluaterecord` VALUES ('132', '30', 'A', 'A', 'A', 'A', '54', '82');
INSERT INTO `evaluaterecord` VALUES ('133', '20', 'B', 'B', 'B', 'B', '54', '83');
INSERT INTO `evaluaterecord` VALUES ('134', '30', 'A', 'C', 'C', 'A', '57', '64');
INSERT INTO `evaluaterecord` VALUES ('135', '20', 'D', 'C', 'B', 'B', '59', '41');
INSERT INTO `evaluaterecord` VALUES ('136', '0', 'A', 'B', 'B', 'A', '59', '82');
INSERT INTO `evaluaterecord` VALUES ('137', '30', 'B', 'B', 'B', 'B', '54', '90');
INSERT INTO `evaluaterecord` VALUES ('138', '30', 'B', 'B', 'B', 'B', '54', '91');
INSERT INTO `evaluaterecord` VALUES ('139', '30', 'B', 'B', 'B', 'B', '54', '95');
INSERT INTO `evaluaterecord` VALUES ('140', '30', 'B', 'B', 'B', 'B', '54', '48');
INSERT INTO `evaluaterecord` VALUES ('141', '30', 'B', 'B', 'B', 'B', '54', '56');

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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert
-- ----------------------------
INSERT INTO `expert` VALUES ('54', '0002', '本科', '专家1', '123', '1', '1', '1');
INSERT INTO `expert` VALUES ('55', '0003', '本科', '专家2', '123', '1', '1', '1');
INSERT INTO `expert` VALUES ('56', '0004', '硕士', '专家3', '123', '2', '4', '3');
INSERT INTO `expert` VALUES ('57', '0005', '硕士', '专家4', '123', '2', '4', '3');
INSERT INTO `expert` VALUES ('58', '0006', '博士', '专家5', '123', '4', '10', '4');
INSERT INTO `expert` VALUES ('59', '0007', '博士', '专家6', '123', '4', '10', '4');
INSERT INTO `expert` VALUES ('60', '0008', '硕士', '专家7', '123', '5', '19', '10');
INSERT INTO `expert` VALUES ('61', '0009', '硕士', '专家8', '123', '5', '19', '10');
INSERT INTO `expert` VALUES ('62', '0010', '硕士', '专家8', '123', '5', '19', '10');

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
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of participateperson
-- ----------------------------
INSERT INTO `participateperson` VALUES ('23', '焦祥宇1', '/UploadFile/upload_633c2abb-7c3a-40a4-8349-95e88253b554.jpg', '1', '17', '17');
INSERT INTO `participateperson` VALUES ('24', '刘阳1', '/UploadFile/upload_b1c99486-cf15-44b5-9daf-56200e422b89.png', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('25', '刘阳2', '/UploadFile/upload_cfd1740d-814d-4388-b200-0700d9a97fce.png', '1', '2', '2');
INSERT INTO `participateperson` VALUES ('26', '焦祥宇2', '/UploadFile/upload_eb7f707b-cc55-4542-a0bb-c9e61abbd251.jpg', '1', '8', '6');
INSERT INTO `participateperson` VALUES ('27', '丁赵雷1', '/UploadFile/upload_402a3e88-47c8-40f3-a217-2c4b2b6a3046.png', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('28', '焦祥宇3', '/UploadFile/upload_e41c4f4d-f008-4962-9012-41c87b2b5b6c.jpg', '1', '11', '3');
INSERT INTO `participateperson` VALUES ('29', '刘阳3', '/UploadFile/upload_31c876de-0753-448b-bb5b-6c94841a9fdb.png', '1', '3', '3');
INSERT INTO `participateperson` VALUES ('30', '焦祥宇4', '/UploadFile/upload_187fc31c-2329-4088-a96e-0b04478f2a80.jpg', '2', '10', '6');
INSERT INTO `participateperson` VALUES ('31', '焦祥宇5', '/UploadFile/upload_e28ee46f-c907-4d60-9c88-06631f682d79.jpg', '2', '14', '8');
INSERT INTO `participateperson` VALUES ('32', '丁赵雷2', '/UploadFile/upload_0c62485b-4454-40a9-9052-80d0dde69b2e.png', '2', '3', '2');
INSERT INTO `participateperson` VALUES ('33', '刘阳4', '/UploadFile/upload_9023e3db-aaef-4cfb-b12a-168215e61c06.png', '1', '4', '4');
INSERT INTO `participateperson` VALUES ('34', '焦祥宇6', '/UploadFile/upload_2af3a5c5-1f76-457b-9d6f-5943180eeebd.jpg', '2', '11', '12');
INSERT INTO `participateperson` VALUES ('35', '刘阳5', '/UploadFile/upload_08271a8a-dcf6-4dcf-bc4e-72b7febe5084.png', '2', '5', '5');
INSERT INTO `participateperson` VALUES ('36', '丁赵雷3', '/UploadFile/upload_28a8bd50-d15c-4f17-b112-e0ebd8bd58d8.png', '3', '17', '14');
INSERT INTO `participateperson` VALUES ('37', '焦祥宇7', '/UploadFile/upload_42a6527a-2594-4408-9b2d-936eb5ea52dd.jpg', '3', '1', '1');
INSERT INTO `participateperson` VALUES ('38', '焦祥宇8', '/UploadFile/upload_39e80b18-f99d-4b14-a8fe-af73b8ded370.jpg', '3', '14', '1');
INSERT INTO `participateperson` VALUES ('39', '丁赵雷4', '/UploadFile/upload_fb97f4d4-c497-4502-b32b-154dc7e6bce9.png', '4', '14', '18');
INSERT INTO `participateperson` VALUES ('40', '刘阳6', '/UploadFile/upload_a89b1b17-632f-4657-a43f-853e2eb08381.png', '1', '6', '6');
INSERT INTO `participateperson` VALUES ('41', '焦祥宇9', '/UploadFile/upload_3a0bae23-d823-4154-bd52-5fd2350577c1.jpg', '3', '1', '1');
INSERT INTO `participateperson` VALUES ('42', '焦祥宇10', '/UploadFile/upload_f55924ea-5749-44b6-8b73-ae98c5c2cb30.jpg', '4', '1', '1');
INSERT INTO `participateperson` VALUES ('43', '焦祥宇11', '/UploadFile/upload_931988a6-f669-4564-b160-97d7b415df4a.jpg', '4', '1', '1');
INSERT INTO `participateperson` VALUES ('44', '丁赵雷5', '/UploadFile/upload_2eb1e61d-d159-4c3e-a906-de5480dd4add.jpg', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('45', '刘阳8', '/UploadFile/upload_3a677555-5cfa-4403-9a6c-bace4f1c3a22.png', '4', '8', '8');
INSERT INTO `participateperson` VALUES ('46', '焦祥宇12', '/UploadFile/upload_64930e63-a67e-4402-95b6-5ea2c6092a61.jpg', '4', '1', '1');
INSERT INTO `participateperson` VALUES ('47', '焦祥宇13', '/UploadFile/upload_fad84f27-3151-4818-a800-e0048c0c0fd6.jpg', '5', '1', '1');
INSERT INTO `participateperson` VALUES ('48', '丁赵雷6', '/UploadFile/upload_7ece94dc-6974-476b-8ad4-6642661a3335.jpg', '2', '13', '7');
INSERT INTO `participateperson` VALUES ('49', '焦祥宇14', '/UploadFile/upload_c4c832dc-908c-47bb-b29a-4f401675252f.jpg', '5', '17', '18');
INSERT INTO `participateperson` VALUES ('50', '焦祥宇15', '/UploadFile/upload_3f66ac1c-e5f1-413f-9375-ac79f39c133f.jpg', '5', '16', '18');
INSERT INTO `participateperson` VALUES ('51', '刘阳9', '/UploadFile/upload_86e8f44b-fc17-495d-967c-908cc72c47f9.png', '5', '9', '9');
INSERT INTO `participateperson` VALUES ('52', '丁赵雷7', '/UploadFile/upload_b2eaa0c3-7c39-4706-9034-f97bb5c61457.png', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('53', '刘阳10', '/UploadFile/upload_1b3d138c-c95f-491f-8f3e-7845146047e9.png', '5', '10', '10');
INSERT INTO `participateperson` VALUES ('54', '丁赵雷8', '/UploadFile/upload_82d1f5d3-595f-4711-97a4-22cdb1723eae.jpg', '4', '8', '14');
INSERT INTO `participateperson` VALUES ('55', '丁赵雷9', '/UploadFile/upload_4290f469-7bd0-41b7-8b2d-0725600b44b3.jpg', '3', '14', '7');
INSERT INTO `participateperson` VALUES ('56', '丁赵雷10', '/UploadFile/upload_b0094b27-1f3d-45b2-8eb0-4768161f7a29.jpg', '2', '18', '8');
INSERT INTO `participateperson` VALUES ('57', '丁赵雷11', '/UploadFile/upload_f037b302-7952-4a0b-8fe7-7eb09af2d4cf.jpg', '2', '8', '16');
INSERT INTO `participateperson` VALUES ('58', '丁赵雷12', '/UploadFile/upload_4c45e896-e245-4675-82e2-df187ad356c2.jpg', '1', '1', '5');
INSERT INTO `participateperson` VALUES ('59', '丁赵雷13', '/UploadFile/upload_5e08f4f0-5961-4d29-a02d-1274dfc80520.jpg', '3', '3', '7');
INSERT INTO `participateperson` VALUES ('60', '丁赵雷14', '/UploadFile/upload_b7fcfc20-503c-4c30-8926-1838272a9bf6.jpg', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('61', '丁赵雷15', '/UploadFile/upload_f1fa052d-3fd6-4522-a032-f5c48e525249.jpg', '3', '3', '4');
INSERT INTO `participateperson` VALUES ('62', '赵硕1', '/UploadFile/upload_f5efa3de-4b25-4f20-9e52-a17c1351d9ef.jpg', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('63', '宋民举', '/UploadFile/upload_47d2e411-254c-4255-8a28-3d8433576e86.png', '3', '1', '1');
INSERT INTO `participateperson` VALUES ('64', '赵硕2', '/UploadFile/upload_5b0f7168-262f-4022-9552-6458dd29d655.jpg', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('65', '老牛', '/UploadFile/upload_0a805a5f-8995-4a27-9ade-bce0be7618f6.png', '1', '4', '5');
INSERT INTO `participateperson` VALUES ('66', '赵硕3', '/UploadFile/upload_9fbd9bdf-c8dd-4425-93f2-01f5a0484d71.jpg', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('67', '赵硕4', '/UploadFile/upload_a4132fc7-ec4f-4652-8225-e742da64c440.jpg', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('68', '宋六', '/UploadFile/upload_9a9ba197-2a37-4436-ab46-b387bbfcbb2f.png', '1', '1', '14');
INSERT INTO `participateperson` VALUES ('69', '二哈', '/UploadFile/upload_04a76a0d-2271-44b4-8f43-a4590a94efa2.png', '3', '11', '9');
INSERT INTO `participateperson` VALUES ('70', '赵硕5', '/UploadFile/upload_d763edcb-b6e7-42f0-b19a-6a113edbc145.jpg', '2', '2', '2');
INSERT INTO `participateperson` VALUES ('71', '赵硕6', '/UploadFile/upload_354b3efc-b96f-4ac4-9931-2b503e90aca6.jpg', '2', '2', '2');
INSERT INTO `participateperson` VALUES ('72', '赵硕7', '/UploadFile/upload_329fedd0-6329-4c94-a0fd-caf8f2e0a2b3.jpg', '2', '2', '2');
INSERT INTO `participateperson` VALUES ('73', '赵硕8', '/UploadFile/upload_a3b17ebd-fe68-4a36-bcf3-d007c04aaeb5.jpg', '2', '2', '2');
INSERT INTO `participateperson` VALUES ('74', '赵硕9', '/UploadFile/upload_0837c216-cf41-42cd-8f31-89fb7e6b0d0d.jpg', '5', '8', '5');
INSERT INTO `participateperson` VALUES ('75', '赵硕10', '/UploadFile/upload_e1193e26-97b4-4bab-b462-5a40f181417b.jpg', '5', '8', '5');
INSERT INTO `participateperson` VALUES ('76', '赵硕11', '/UploadFile/upload_cce3f9a6-7205-4826-8a24-9d11d28d9d74.jpg', '5', '8', '5');
INSERT INTO `participateperson` VALUES ('77', '宋大大', '/UploadFile/upload_2ffe21fa-01da-4211-b7ec-ecd3c94935fe.png', '5', '6', '3');
INSERT INTO `participateperson` VALUES ('78', '赵硕12', '/UploadFile/upload_f26d461b-c0bc-49fd-b181-4973edbb6af0.jpg', '4', '3', '14');
INSERT INTO `participateperson` VALUES ('79', '赵硕13', '/UploadFile/upload_222b0fc8-7a59-4ffc-8490-7b3ccd24c18f.jpg', '4', '3', '14');
INSERT INTO `participateperson` VALUES ('80', '赵硕14', '/UploadFile/upload_708fc1d6-6184-418f-ac7d-d1bcd65bc7d6.jpg', '3', '16', '10');
INSERT INTO `participateperson` VALUES ('81', '赵硕15', '/UploadFile/upload_a0f2d132-5d93-4853-879c-11f3d8c480d5.jpg', '3', '16', '10');
INSERT INTO `participateperson` VALUES ('82', 'Nwp1', '/UploadFile/upload_de3c316b-1357-43b2-8ddf-9e9c519faa51.png', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('83', 'Nwp2', '/UploadFile/upload_ede84fd5-2306-4664-aec5-ddb1844c419a.png', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('84', 'Nwp3', '/UploadFile/upload_d7c612e7-4917-42c1-9ab6-5127a354dffd.png', '2', '1', '1');
INSERT INTO `participateperson` VALUES ('85', 'Nwp4', '/UploadFile/upload_63e6b530-9d89-421d-84ef-8f5292794206.png', '2', '5', '3');
INSERT INTO `participateperson` VALUES ('86', 'Nwp5', '/UploadFile/upload_8e493d60-78a3-4db0-a04f-09b5ada68257.png', '3', '1', '9');
INSERT INTO `participateperson` VALUES ('87', 'Nwp6', '/UploadFile/upload_eb61cea4-4b8c-4ebb-a759-f489d2ec3a98.png', '3', '4', '8');
INSERT INTO `participateperson` VALUES ('88', 'Nwp7', '/UploadFile/upload_bbe3c9b9-8c23-4b1e-902b-8e1b30f7b20f.png', '5', '5', '5');
INSERT INTO `participateperson` VALUES ('89', 'Nwp8', '/UploadFile/upload_3bf28232-15e5-4710-a4cf-656fcc193ed7.png', '2', '6', '7');
INSERT INTO `participateperson` VALUES ('90', 'Nwp9', '/UploadFile/upload_b96fb6ed-d03a-45ac-90de-a041ba5bd6af.png', '1', '4', '1');
INSERT INTO `participateperson` VALUES ('91', 'Nwp10', '/UploadFile/upload_02e39d44-7596-4c9a-952f-79ccb417123d.png', '1', '11', '1');
INSERT INTO `participateperson` VALUES ('92', 'Nwp11', '/UploadFile/upload_08cce7f0-ad39-411f-a10b-c84f65f120b6.png', '4', '1', '6');
INSERT INTO `participateperson` VALUES ('93', 'Nwp12', '/UploadFile/upload_311f0cfc-825f-43b2-88aa-94121be450f0.png', '1', '10', '9');
INSERT INTO `participateperson` VALUES ('94', 'Nwp13', '/UploadFile/upload_dd91683d-95d7-4e75-b81c-58a5f3729741.png', '4', '16', '12');
INSERT INTO `participateperson` VALUES ('95', 'Nwp14', '/UploadFile/upload_f526ec99-35a0-464d-ade3-f9743ea32177.png', '1', '1', '1');
INSERT INTO `participateperson` VALUES ('96', 'Nwp15', '/UploadFile/upload_929d0793-7dbd-4f7b-a909-7dee29395dc1.png', '1', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statistics
-- ----------------------------
INSERT INTO `statistics` VALUES ('16', '23.3333', '17.6667', '20', '0', '23');
INSERT INTO `statistics` VALUES ('17', '15', '14.5', '20', '5', '24');
INSERT INTO `statistics` VALUES ('18', '16.6667', '14.3333', '20', '0', '25');
INSERT INTO `statistics` VALUES ('19', '30', '24.5', '25', '10', '26');
INSERT INTO `statistics` VALUES ('20', '30', '23', '13.3333', '20', '27');
INSERT INTO `statistics` VALUES ('21', '20', '15', '10', '10', '28');
INSERT INTO `statistics` VALUES ('22', '20', '15', '10', '10', '29');
INSERT INTO `statistics` VALUES ('23', '13.3333', '10.6667', '0', '20', '33');
INSERT INTO `statistics` VALUES ('24', '26.6667', '25.6667', '30', '16.6667', '40');
INSERT INTO `statistics` VALUES ('25', '10', '13.6667', '20', '13.3333', '44');
INSERT INTO `statistics` VALUES ('26', '15', '7.5', '0', '0', '52');
INSERT INTO `statistics` VALUES ('27', '20', '10', '0', '0', '30');
INSERT INTO `statistics` VALUES ('28', '0', '4', '0', '20', '31');
INSERT INTO `statistics` VALUES ('29', '20', '10', '0', '0', '34');
INSERT INTO `statistics` VALUES ('30', '10', '5', '0', '0', '37');
INSERT INTO `statistics` VALUES ('31', '0', '3', '10', '0', '38');
INSERT INTO `statistics` VALUES ('32', '20', '16', '20', '0', '41');
INSERT INTO `statistics` VALUES ('33', '5', '6.16667', '10', '3.33333', '58');
INSERT INTO `statistics` VALUES ('34', '0', '6.6', '10', '18', '60');
INSERT INTO `statistics` VALUES ('35', '30', '15', '0', '0', '42');
INSERT INTO `statistics` VALUES ('36', '30', '15', '0', '0', '43');
INSERT INTO `statistics` VALUES ('37', '0', '0', '0', '0', '46');
INSERT INTO `statistics` VALUES ('38', '0', '4', '0', '20', '47');
INSERT INTO `statistics` VALUES ('39', '0', '6', '0', '30', '49');
INSERT INTO `statistics` VALUES ('40', '0', '0', '0', '0', '50');
INSERT INTO `statistics` VALUES ('41', '20', '21', '30', '10', '62');
INSERT INTO `statistics` VALUES ('42', '20', '12', '0', '10', '65');
INSERT INTO `statistics` VALUES ('43', '15', '7.5', '0', '0', '67');
INSERT INTO `statistics` VALUES ('44', '30', '23.6667', '20', '13.3333', '64');
INSERT INTO `statistics` VALUES ('45', '0', '2', '0', '10', '66');
INSERT INTO `statistics` VALUES ('46', '30', '19.5', '15', '0', '82');
INSERT INTO `statistics` VALUES ('47', '0', '6', '20', '0', '68');
INSERT INTO `statistics` VALUES ('48', '0', '9', '30', '0', '35');
INSERT INTO `statistics` VALUES ('49', '0', '0', '0', '0', '73');
INSERT INTO `statistics` VALUES ('50', '0', '6', '20', '0', '32');
INSERT INTO `statistics` VALUES ('51', '30', '15', '0', '0', '59');
INSERT INTO `statistics` VALUES ('52', '0', '6', '20', '0', '83');
INSERT INTO `statistics` VALUES ('53', '0', '9', '30', '0', '90');
INSERT INTO `statistics` VALUES ('54', '0', '9', '30', '0', '91');
INSERT INTO `statistics` VALUES ('55', '0', '9', '30', '0', '95');
INSERT INTO `statistics` VALUES ('56', '0', '9', '30', '0', '48');
INSERT INTO `statistics` VALUES ('57', '0', '9', '30', '0', '56');

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
INSERT INTO `supermanager` VALUES ('1', '1', '超级管理员', '1');

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
