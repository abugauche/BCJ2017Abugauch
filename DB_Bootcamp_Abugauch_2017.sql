-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`country` (
  `alpha3_code` CHAR NOT NULL,
  `name` CHAR NOT NULL,
  `alpha2_code` CHAR NOT NULL,
  PRIMARY KEY (`alpha3_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`state` (
  `name` CHAR NULL,
  `abbr` CHAR NOT NULL,
  `area` INT NULL,
  `capital` CHAR NULL,
  `country_alpha3_code` CHAR NOT NULL,
  PRIMARY KEY (`country_alpha3_code`, `abbr`),
  INDEX `fk_state_country_idx` (`country_alpha3_code` ASC),
  CONSTRAINT `fk_state_country`
    FOREIGN KEY (`country_alpha3_code`)
    REFERENCES `mydb`.`country` (`alpha3_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`weather`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`weather` (
  `idWeather` INT NOT NULL,
  `description` CHAR NULL,
  PRIMARY KEY (`idWeather`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`wind`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`wind` (
  `idWind` INT NOT NULL,
  `chill` INT NULL,
  `direction` INT NULL,
  `speed` INT NULL,
  PRIMARY KEY (`idWind`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `mydb`.`atmosphere`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atmosphere` (
  `idAtmosphere` INT NOT NULL,
  `humidity` INT NULL,
  `presseaure` FLOAT NULL,
  `rising` INT NULL,
  `visibility` FLOAT NULL,
  PRIMARY KEY (`idAtmosphere`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`actuallyCondition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`actuallyCondition` (
  `date` DATE NOT NULL,
  `temp` INT NULL,
  `state_country_alpha3_code` CHAR NOT NULL,
  `state_abbr` CHAR NOT NULL,
  `clima_idClima` INT NOT NULL,
  `wind_idWind` INT NOT NULL,
  `atmosphere_idAtmosphere` INT NOT NULL,
  PRIMARY KEY (`date`, `state_country_alpha3_code`, `state_abbr`, `clima_idClima`, `wind_idWind`, `atmosphere_idAtmosphere`),
  INDEX `fk_actuallyCondition_state1_idx` (`state_country_alpha3_code` ASC, `state_abbr` ASC),
  INDEX `fk_actuallyCondition_clima1_idx` (`clima_idClima` ASC),
  INDEX `fk_actuallyCondition_wind1_idx` (`wind_idWind` ASC),
  INDEX `fk_actuallyCondition_atmosphere1_idx` (`atmosphere_idAtmosphere` ASC),
  CONSTRAINT `fk_actuallyCondition_state1`
    FOREIGN KEY (`state_country_alpha3_code` , `state_abbr`)
    REFERENCES `mydb`.`state` (`country_alpha3_code` , `abbr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_clima1`
    FOREIGN KEY (`clima_idClima`)
    REFERENCES `mydb`.`weather` (`idWeather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_wind1`
    FOREIGN KEY (`wind_idWind`)
    REFERENCES `mydb`.`wind` (`idWind`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuallyCondition_atmosphere1`
    FOREIGN KEY (`atmosphere_idAtmosphere`)
    REFERENCES `mydb`.`atmosphere` (`idAtmosphere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`extendedCondition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`extendedCondition` (
  `extendedDate` DATE NOT NULL,
  `day` CHAR NULL,
  `high` INT NULL,
  `low` INT NULL,
  `clima_idClima` INT NOT NULL,
  `actuallyCondition_day` DATE NOT NULL,
  `actuallyCondition_state_country_alpha3_code` CHAR NOT NULL,
  `actuallyCondition_state_abbr` CHAR NOT NULL,
  PRIMARY KEY (`extendedDate`, `clima_idClima`, `actuallyCondition_day`, `actuallyCondition_state_country_alpha3_code`, `actuallyCondition_state_abbr`),
  INDEX `fk_extendCondition_clima1_idx` (`clima_idClima` ASC),
  INDEX `fk_extendedCondition_actuallyCondition1_idx` (`actuallyCondition_day` ASC, `actuallyCondition_state_country_alpha3_code` ASC, `actuallyCondition_state_abbr` ASC),
  CONSTRAINT `fk_extendCondition_clima1`
    FOREIGN KEY (`clima_idClima`)
    REFERENCES `mydb`.`weather` (`idWeather`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_extendedCondition_actuallyCondition1`
    FOREIGN KEY (`actuallyCondition_day` , `actuallyCondition_state_country_alpha3_code` , `actuallyCondition_state_abbr`)
    REFERENCES `mydb`.`actuallyCondition` (`date` , `state_country_alpha3_code` , `state_abbr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
