DROP DATABASE mip;

CREATE DATABASE IF NOT EXISTS mip
    DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;

USE mip;

CREATE TABLE pet (
    id      BIGINT NOT NULL AUTO_INCREMENT,
    name    VARCHAR(32),
    owner   VARCHAR(32),
    species VARCHAR(32),
    sex     CHAR(1),
    birth   DATE,
    death   DATE,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE dept (
    id       BIGINT   NOT NULL AUTO_INCREMENT,
    name     CHAR(32) NULL,
    loc_name CHAR(32) NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE employee (
    id     BIGINT      NOT NULL AUTO_INCREMENT,
    name   VARCHAR(32) NOT NULL,
    salary INT,
    dep_id BIGINT      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_EMP_DEPT FOREIGN KEY (dep_id) REFERENCES dept (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

INSERT INTO dept VALUES
    (1, 'IT', 'Arizona'),
    (2, 'Servicing', 'IOWA'),
    (3, 'Technology', 'TEXAS');

INSERT INTO employee VALUES
    (101, 'John Smith', 10000, 1),
    (102, 'John Sims', 10000, 1),
    (103, 'John McCoy', 10000, 2),
    (104, 'DeAnne Shaw', 10000, 3);

CREATE TABLE user (
    id         BIGINT   NOT NULL AUTO_INCREMENT,
    first_name CHAR(32) NULL,
    last_name  CHAR(32) NULL,
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
