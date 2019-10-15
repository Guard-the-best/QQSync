create database web;
create user 'webUser'@'%' identified by 'webPassword';
grant all on web.* to 'webUser'@'%';

use web;

CREATE TABLE IF NOT EXISTS `userInfo`(
   `userId` INT UNSIGNED AUTO_INCREMENT,
   `username` VARCHAR(100) NOT NULL,
   `password` VARCHAR(100) NOT NULL,
   `phoneNumber` VARCHAR(100),
   `nickname` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `userId` )
)CHARSET=utf8;