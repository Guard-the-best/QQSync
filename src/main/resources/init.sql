create database web;
create user 'webUser'@'%' identified by 'webPassword';
grant all on web.* to 'webUser'@'%';

use web;

CREATE TABLE IF NOT EXISTS `locationInfo`(
   `locationId` INT UNSIGNED AUTO_INCREMENT,
   `parentId` INT UNSIGNED NOT NULL,
   `locationName` VARCHAR(100) NOT NULL,
   `level` INT UNSIGNED NOT NULL,-- country,province,city,county
   PRIMARY KEY ( `locationId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `userInfo`(
   `userId` INT UNSIGNED AUTO_INCREMENT,
   `username` VARCHAR(100) NOT NULL,
   `password` VARCHAR(100) NOT NULL,
   `phoneNumber` VARCHAR(100),
   `nickname` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `userId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `addressInfo`(
   `addressId` INT UNSIGNED AUTO_INCREMENT,
   `userId` INT UNSIGNED NOT NULL,
   `isDefult` INT NOT NULL,
   `name` VARCHAR(100) NOT NULL,
   `phoneNumber` VARCHAR(100) NOT NULL,
   `locationId` INT UNSIGNED NOT NULL,--level4
   `detailedAddress` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `addressId` )
)CHARSET=utf8;