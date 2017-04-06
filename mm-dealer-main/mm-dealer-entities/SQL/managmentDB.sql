CREATE DATABASE `managment_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `tbl_departments` (
  `dept_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) NOT NULL,
  `dept_description` varchar(255) DEFAULT NULL,
  `dept_cover` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_sub_topics` (
  `topic_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tbl_subjects_sub_id` int(10) unsigned NOT NULL,
  `topic_name` varchar(255) NOT NULL,
  `topic_description` varchar(255) DEFAULT NULL,
  `topic_cover` varchar(255) NOT NULL,
  `topic_detailed` longtext NOT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `tbl_sub_topics_FKIndex1` (`tbl_subjects_sub_id`),
  CONSTRAINT `tbl_sub_topics_ibfk_1` FOREIGN KEY (`tbl_subjects_sub_id`) REFERENCES `tbl_subjects` (`sub_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_subjects` (
  `sub_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tbl_departments_dept_id` int(10) unsigned NOT NULL,
  `sub_name` varchar(45) NOT NULL,
  `sub_description` varchar(255) DEFAULT NULL,
  `sub_cover` varchar(100) NOT NULL,
  `sub_year` int(10) unsigned NOT NULL,
  `semister` int(10) unsigned NOT NULL,
  PRIMARY KEY (`sub_id`),
  KEY `tbl_subjects_FKIndex1` (`tbl_departments_dept_id`),
  CONSTRAINT `tbl_subjects_ibfk_1` FOREIGN KEY (`tbl_departments_dept_id`) REFERENCES `tbl_departments` (`dept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `userdetails_tbl` (
  `id` int(11) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `mobile_phone` varchar(45) NOT NULL,
  `uniqueId` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modification_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `mobile_phone_UNIQUE` (`mobile_phone`),
  UNIQUE KEY `email_id_UNIQUE` (`email_id`),
  UNIQUE KEY `uniqueId_UNIQUE` (`uniqueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usertokens_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `token` varchar(500) NOT NULL,
  `expiry_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
