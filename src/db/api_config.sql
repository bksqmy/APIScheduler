/*
Navicat MySQL Data Transfer

Source Server         : 定时任务动态调用
Source Server Version : 50718
Source Host           : localhost
Source Database       : global_config

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-05-11 17:26:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for api_category
-- ----------------------------
DROP TABLE IF EXISTS `api_category`;
CREATE TABLE `api_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(64) NOT NULL COMMENT ' 算法类别code',
  `category_name` varchar(64) NOT NULL COMMENT '算法类别名称',
  `is_vaild` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效  0无效',
  `work_order` bigint(20) DEFAULT NULL COMMENT '执行顺序',
  `config` varchar(32) NOT NULL COMMENT '配置参数 参考 api-config表 config字段',
  `job_name` varchar(128) NOT NULL COMMENT '任务名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of api_category
-- ----------------------------
INSERT INTO `api_category` VALUES ('1', 'job1', '定时job1', '1', '1', 'prod', 'ASAP_ADS_GUIDANCE_VMS_PLAN_SERVER');
INSERT INTO `api_category` VALUES ('2', 'job2', '定时job2', '1', '1', 'prod', 'ASAP_ADS_GUIDANCE_VMS_PLAN_SERVER');
INSERT INTO `api_category` VALUES ('3', 'job3', '定时job3', '1', '2', 'prod', 'ASAP_CITYBRAIN_SPEEDINTERP_HANGZHOU_SERVER');
INSERT INTO `api_category` VALUES ('4', 'job4', '定时job4', '1', '3', 'prod', 'ASAP_CITY_BRAIN_CLEAR_FORMAL_SERVER');
INSERT INTO `api_category` VALUES ('5', 'job5', '定时job5', '0', '4', 'prod', 'ASAP_CITY_BRAIN_FORMAL_SERVER');
-- ----------------------------
-- Table structure for api_scheduler
-- ----------------------------
DROP TABLE IF EXISTS `api_scheduler`;
CREATE TABLE `api_scheduler` (
  `job_name` varchar(128) NOT NULL COMMENT '任务名称',
  `trigger_name` varchar(128) NOT NULL COMMENT '触发器名称',
  `job_group_name` varchar(128) NOT NULL COMMENT '任务组',
  `trigger_group_name` varchar(128) NOT NULL COMMENT '触发器组',
  `is_vaild` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效  0无效',
  `class_path` varchar(128) NOT NULL COMMENT '类路径',
  `is_restart` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否重启该任务 1 重启  0不重启',
  `corn` varchar(256) NOT NULL COMMENT 'corn表达式',
  `restart_time` datetime DEFAULT NULL COMMENT '重启时间',
  `last_run_time` datetime DEFAULT NULL COMMENT '最后一次运行时间',
  PRIMARY KEY (`job_name`,`trigger_name`),
  UNIQUE KEY `job_name` (`job_name`),
  UNIQUE KEY `trigger_name` (`trigger_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of api_scheduler
-- ----------------------------
INSERT INTO `api_scheduler` VALUES ('ASAP_ADS_GUIDANCE_VMS_PLAN_SERVER', 'ASAP_ADS_GUIDANCE_VMS_PLAN_TRIGGER', 'ASAP_ADS_GUIDANCE_VMS_PLAN_JOB_GROUP', 'ASAP_ADS_GUIDANCE_VMS_PLAN_JOB_GROUP', '1', 'com.sl.api.job.OtherAsapJob', '0', '0 0/2 * * * ?', '2018-05-04 15:58:42', '2018-05-11 17:26:05');
INSERT INTO `api_scheduler` VALUES ('ASAP_CITYBRAIN_SPEEDINTERP_HANGZHOU_SERVER', 'ASAP_CITYBRAIN_SPEEDINTERP_HANGZHOU_TRIGGER', 'ASAP_CITYBRAIN_SPEEDINTERP_HANGZHOU_JOB_GROUP', 'ASAP_CITYBRAIN_SPEEDINTERP_HANGZHOU_JOB_GROUP', '1', 'com.sl.api.job.OtherAsapJob', '0', '0 0/2 * * * ?', '2018-05-04 15:58:42', '2018-05-11 17:26:05');
INSERT INTO `api_scheduler` VALUES ('ASAP_CITY_BRAIN_CLEAR_FORMAL_SERVER', 'ASAP_CITY_BRAIN_CLEAR_FORMAL_TRIGGER', 'ASAP_CITY_BRAIN_CLEAR_FORMAL_JOB_GROUP', 'ASAP_CITY_BRAIN_CLEAR_FORMAL_JOB_GROUP', '1', 'com.sl.api.job.CityBrainJob', '0', '0 0 0 * * ?', null, '2018-05-11 00:00:00');
INSERT INTO `api_scheduler` VALUES ('ASAP_CITY_BRAIN_FORMAL_SERVER', 'ASAP_CITY_BRAIN_FORMAL_TRIGGER', 'ASAP_CITY_BRAIN_FORMAL_JOB_GROUP', 'ASAP_CITY_BRAIN_FORMAL_JOB_GROUP', '1', 'com.sl.api.job.CityBrainJob', '0', '30 1/2 * * * ?', null, '2018-05-11 17:25:49');
