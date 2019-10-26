create database web;
create user 'webUser'@'%' identified by 'webPassword';
grant all on web.* to 'webUser'@'%';

use web;

-- --------------------------------------------------
-- --------------------------------------------------
-- location
-- --------------------------------------------------
-- --------------------------------------------------
DROP TABLE IF EXISTS `locationInfo`;
CREATE TABLE `locationInfo`
(
    `locationId`   INT UNSIGNED AUTO_INCREMENT,
    `parentId`     INT UNSIGNED NOT NULL,
    `locationName` VARCHAR(100) NOT NULL,
    `level`        INT UNSIGNED NOT NULL,-- country,province,city,county
    PRIMARY KEY (`locationId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------
-- --------------------------------------------------
-- user
-- --------------------------------------------------
-- --------------------------------------------------
DROP TABLE IF EXISTS `userInfo`;
CREATE TABLE `userInfo`
(
    `userId`      INT UNSIGNED AUTO_INCREMENT,
    `username`    VARCHAR(100) NOT NULL,
    `password`    VARCHAR(100) NOT NULL,
    `phoneNumber` VARCHAR(100),
    `nickname`    VARCHAR(100) NOT NULL,
    PRIMARY KEY (`userId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `addressInfo`;
CREATE TABLE `addressInfo`
(
    `addressId`       INT UNSIGNED AUTO_INCREMENT,
    `userId`          INT UNSIGNED NOT NULL,
    `isDefault`       INT          NOT NULL,
    `name`            VARCHAR(100) NOT NULL,
    `phoneNumber`     VARCHAR(100) NOT NULL,
    `locationId`      INT UNSIGNED NOT NULL,-- level4
    `detailedAddress` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`addressId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------
-- orders
-- --------------------------------------------------
DROP TABLE IF EXISTS `orderInfo`;
CREATE TABLE `orderInfo`
(
    `orderId` INT UNSIGNED AUTO_INCREMENT,
    `userId`  INT UNSIGNED NOT NULL,
    `orderDate` DATE NOT NULL,
    `shipAddressId` INT UNSIGNED NOT NULL,
    `billAddressId` INT UNSIGNED NOT NULL,
    `state` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`orderId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------
-- shopping cart line
-- --------------------------------------------------
DROP TABLE IF EXISTS `lineInfo`;
CREATE TABLE `lineInfo`
(
    `lineId` INT UNSIGNED AUTO_INCREMENT,
    `Id` INT UNSIGNED NOT NULL, -- userId or orderId
    `state` INT UNSIGNED NOT NULL,
    `itemId` INT UNSIGNED NOT NULL,
    `number` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`lineId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------
-- --------------------------------------------------
-- pet
-- --------------------------------------------------
-- --------------------------------------------------
DROP TABLE IF EXISTS `categoryInfo`;
CREATE TABLE `categoryInfo`
(
    `categoryId` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`categoryId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `productInfo`;
CREATE TABLE `productInfo`
(
    `productId` INT UNSIGNED AUTO_INCREMENT,
    `categoryId` INT UNSIGNED NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`productId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `itemInfo`;
CREATE TABLE `itemInfo`
(
    `itemId` INT UNSIGNED AUTO_INCREMENT,
    `productId` INT UNSIGNED NOT NULL,
    `unitPrice` INT UNSIGNED NOT NULL,
    `number` INT UNSIGNED NOT NULL,
    `attr1` VARCHAR(100),
    `attr2` VARCHAR(100),
    `attr3` VARCHAR(100),
    `attr4` VARCHAR(100),
    `attr5` VARCHAR(100),
    PRIMARY KEY (`itemId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

