# README #

This is web application which will be used to receive data from the Raspberry Pi Board. Store all data in online mySQL database. This application has 3 major functions.

**1. Register Chronograph**
  Power on Raspberry Pi and it will automatically run application 
  To register chronograph we have to click the Register button.
  The chronograph will register chronograph serial no in online  
  Open this Web Application and Click register.
  Fill all information and Serial No. Printed on Chronograph
  Then you will get a username and password for login
  Email field should be used as username.

**2. Live Display**
  To get a live display that what is going on currently on your Chronograph, Click Live View on Home 
  Page then fill username and password. There you will get all shots fired on Chronograph.  
  
**3. View Database**
  Click View Database on Home Page, enter credentials and you will get all history of your data


Run Application
this application is a Netbeans project. So we can import project.

Project requires following Libraries
1. json-simple-1.1.1.jar
2. mysql-connecter-java-5.1.18-bin.jar

Create mysql database with following script  or ‘chronotable.sql’ file then run application.

**SCRIPT FOR APP**

*CREATE DATABASE  IF NOT EXISTS `chronydata` 

USE `chronydata`;


DROP TABLE IF EXISTS `reg`;


CREATE TABLE `reg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dop` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `company` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chtype` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chmac` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chserial` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `velrecords`;

CREATE TABLE `velrecords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chserial` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `velocity` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ftime` time DEFAULT NULL,
  `fdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


*