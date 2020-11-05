use sevenfivefive;

CREATE TABLE IF NOT EXISTS `agent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` TEXT NOT NULL,
  `algorithm` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `authority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `agent` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `Stock` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `organization` VARCHAR(45) NOT NULL ,
  `stockname` VARCHAR(45) NOT NULL,
  `stockprice` VARCHAR(45) NOT NULL,
  `trade_currency` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

