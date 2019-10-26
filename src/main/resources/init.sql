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
   `isDefault` INT NOT NULL,
   `name` VARCHAR(100) NOT NULL,
   `phoneNumber` VARCHAR(100) NOT NULL,
   `locationId` INT UNSIGNED NOT NULL,  -- level4
   `detailedAddress` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `addressId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `category`(
   `categoryId` INT UNSIGNED AUTO_INCREMENT,
   `categoryName` VARCHAR(20) NOT NULL,
   PRIMARY KEY ( `categoryId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `product`(
   `productId` INT UNSIGNED AUTO_INCREMENT,
   `itemName` VARCHAR(50) NOT NULL,
   `parentCategory` INT UNSIGNED NOT NULL,
   PRIMARY KEY ( `productId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `item`(
   `itemId` INT UNSIGNED AUTO_INCREMENT,
   `listPrice` DECIMAL(10, 2) NOT NULL,
   `inventory` INT UNSIGNED,
   PRIMARY KEY ( `itemId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lineItem`(
   `lineId` INT UNSIGNED AUTO_INCREMENT,
   `parentId` INT NOT NULL,  -- Based on property `status`. In the cart, it store userId. After ordered, it store orderId.
   `status` INT DEFAULT 0,   -- In cart: 0; Ordered: 1; ... (change if need)
   `itemId` INT NOT NULL,
   `quantity` INT DEFAULT 1,
   PRIMARY KEY ( `lineId` )
)CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `order`(
   `orderId` INT UNSIGNED AUTO_INCREMENT,  -- AUTO_INCREMENT?
   `orderTime` DATETIME NOT NULL,          -- Should use DATE if time is not necessary
   `shipAddId` INT NOT NULL,
   `billAddId` INT NOT NULL,
   `status` INT DEFAULT 0,                 -- submitted, confirmed, ...
   PRIMARY KEY ( `orderId` )
)CHARSET=utf8;