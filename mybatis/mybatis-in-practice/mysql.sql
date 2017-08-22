DROP DATABASE mip;

CREATE DATABASE IF NOT EXISTS mip
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE mip;

CREATE TABLE pet (
  id      MEDIUMINT NOT NULL AUTO_INCREMENT,
  name    VARCHAR(20),
  owner   VARCHAR(20),
  species VARCHAR(20),
  sex     CHAR(1),
  birth   DATE,
  death   DATE,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE user (
  id         MEDIUMINT NOT NULL AUTO_INCREMENT,
  first_name CHAR(30)  NULL,
  last_name  CHAR(30)  NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DELIMITER //
CREATE PROCEDURE read_pet(
  IN  in_name     VARCHAR(100),
  OUT out_owner   VARCHAR(100),
  OUT out_species VARCHAR(100),
  OUT out_sex     VARCHAR(100),
  OUT out_birth   DATE,
  OUT out_death   DATE)
  BEGIN
    SELECT
      owner,
      species,
      sex,
      birth,
      death
    INTO out_owner, out_species, out_sex, out_birth, out_death
    FROM pet
    WHERE name = in_name;
  END //
DELIMITER ;

## The following commands are used to execute the stored procedure:
## CALL read_pet('Fluffy', @out_owner, @out_species, @out_sex, @out_birth, @out_death);
##
## Use the following command to view the stored procedure output:
## SELECT @out_owner, @out_species, @out_sex, @out_birth, @out_death;

DELIMITER //
CREATE PROCEDURE read_all_pets()
  BEGIN
    SELECT
      name,
      owner,
      species,
      sex,
      birth,
      death
    FROM pet;
  END //
DELIMITER ;

## The following command is used to execute the stored procedure:
## CALL read_all_pets();

DELIMITER $$
CREATE FUNCTION get_pet_owner(in_name VARCHAR(200))
  RETURNS
    VARCHAR(200)
  BEGIN
    DECLARE out_owner VARCHAR(200);
    SELECT owner
    INTO out_owner
    FROM pet
    WHERE name = in_name;
    RETURN out_owner;
  END;
$$
##  The following command is used to execute the stored function.
## SELECT get_pet_owner('Fluffy') AS owner;
$$
