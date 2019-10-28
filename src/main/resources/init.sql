DROP DATABASE IF EXISTS web;
create database web;
DROP USER IF EXISTS 'webUser'@'%';
create user 'webUser'@'%' identified by 'webPassword';
grant all on web.* to 'webUser'@'%';

use web;

-- --------------------------------------------------
-- --------------------------------------------------
-- location
-- --------------------------------------------------
-- --------------------------------------------------
# DROP TABLE IF EXISTS `locationInfo`;
# CREATE TABLE `locationInfo`
# (
#     `locationId`   INT UNSIGNED AUTO_INCREMENT,
#     `parentId`     INT UNSIGNED NOT NULL,
#     `locationName` VARCHAR(100) NOT NULL,
#     `level`        INT UNSIGNED NOT NULL,-- province,city,county,village
#     PRIMARY KEY (`locationId`),
#     KEY (`locationName`)
# ) ENGINE = InnoDB
#   DEFAULT CHARSET = utf8;

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
#     `isDefault`       BOOLEAN      NOT NULL,
    `name`            VARCHAR(100) NOT NULL,
    `phoneNumber`     VARCHAR(100) NOT NULL,
    `province`        VARCHAR(100) NOT NULL,
    `city`            VARCHAR(100) NOT NULL,
    `county`          VARCHAR(100) NOT NULL,
    `village`         VARCHAR(100) NOT NULL,
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
    `orderId`       INT UNSIGNED AUTO_INCREMENT,
    `userId`        INT UNSIGNED NOT NULL,
    `orderDate`     DATETIME     NOT NULL,
    `shipAddressId` INT UNSIGNED NOT NULL,
    `billAddressId` INT UNSIGNED NOT NULL,
    `status`        INT UNSIGNED NOT NULL DEFAULT 0,-- submitted, confirmed, ...
    PRIMARY KEY (`orderId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------------------------
-- shopping cart line
-- --------------------------------------------------
DROP TABLE IF EXISTS `lineInfo`;
CREATE TABLE `lineInfo`
(
    `lineId`   INT UNSIGNED AUTO_INCREMENT,
    -- Based on property `status`. In the cart, it store userId. After ordered, it store orderId.
    `parentId` INT UNSIGNED NOT NULL,           -- userId or orderId
    `itemId`   INT UNSIGNED NOT NULL,
    `quantity` INT UNSIGNED NOT NULL DEFAULT 1,
    `status`   INT UNSIGNED NOT NULL DEFAULT 0, -- In cart: 0; Ordered: 1; ...
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
    `categoryId`   INT UNSIGNED AUTO_INCREMENT,
    `categoryName` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`categoryId`),
    KEY (`categoryName`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `productInfo`;
CREATE TABLE `productInfo`
(
    `productId`   INT UNSIGNED AUTO_INCREMENT,
    `categoryId`  INT UNSIGNED NOT NULL,
    `productName` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`productId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `itemInfo`;
CREATE TABLE `itemInfo`
(
    `itemId`    INT UNSIGNED AUTO_INCREMENT,
    `productId` INT UNSIGNED            NOT NULL,
    `listPrice` DECIMAL(10, 2) UNSIGNED NOT NULL,
    `inventory` INT UNSIGNED            NOT NULL,
    `attr1`     VARCHAR(100),
    `attr2`     VARCHAR(100),
    `attr3`     VARCHAR(100),
    `attr4`     VARCHAR(100),
    `attr5`     VARCHAR(100),
    PRIMARY KEY (`itemId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

