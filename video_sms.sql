/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : video_sms

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-01-25 11:00:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for video_infomation
-- ----------------------------
DROP TABLE IF EXISTS `video_infomation`;
CREATE TABLE `video_infomation` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `video_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `video_image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`video_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `video_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of video_infomation
-- ----------------------------
INSERT INTO `video_infomation` VALUES ('1', '爱在黎明破晓前', 'url_123', 'image', '1');
INSERT INTO `video_infomation` VALUES ('2', '他其实没有那么爱你', 'url_234', 'image', '1');
INSERT INTO `video_infomation` VALUES ('3', '傲慢与偏见', 'url2', 'image', '1');
INSERT INTO `video_infomation` VALUES ('4', '真爱至上', '2', '2', '1');
INSERT INTO `video_infomation` VALUES ('5', '加勒比海盗', '2', '2', '2');
INSERT INTO `video_infomation` VALUES ('6', '美国丽人', '2', '2', '1');
INSERT INTO `video_infomation` VALUES ('7', '无名之辈', '3', '3', '1');
INSERT INTO `video_infomation` VALUES ('8', '红海行动', '2', '2', '1');

-- ----------------------------
-- Table structure for video_type
-- ----------------------------
DROP TABLE IF EXISTS `video_type`;
CREATE TABLE `video_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of video_type
-- ----------------------------
INSERT INTO `video_type` VALUES ('1', '爱情片');
INSERT INTO `video_type` VALUES ('2', '动作片');
