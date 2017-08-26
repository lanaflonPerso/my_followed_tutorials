DROP DATABASE mybatis;

CREATE DATABASE IF NOT EXISTS mybatis
    DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;

USE mybatis;

CREATE TABLE address
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    street  VARCHAR(50) NOT NULL,
    city    VARCHAR(50) NOT NULL,
    state   VARCHAR(50) NOT NULL,
    zip     VARCHAR(10)          DEFAULT NULL,
    country VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE student
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50) NOT NULL,
    email   VARCHAR(50) NOT NULL,
    phone   VARCHAR(15)          DEFAULT NULL,
    dob     DATE                 DEFAULT NULL,
    gender  VARCHAR(6)           DEFAULT NULL,
    bio     LONGTEXT             DEFAULT NULL,
    pic     BLOB                 DEFAULT NULL,
    addr_id BIGINT               DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_EMAIL (email),
    CONSTRAINT FK_STUDENTS_ADDR FOREIGN KEY (addr_id) REFERENCES address (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE tutor
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50) NOT NULL,
    email   VARCHAR(50) NOT NULL,
    phone   VARCHAR(15)          DEFAULT NULL,
    dob     DATE                 DEFAULT NULL,
    gender  VARCHAR(6)           DEFAULT NULL,
    bio     LONGTEXT             DEFAULT NULL,
    pic     BLOB                 DEFAULT NULL,
    addr_id BIGINT               DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_EMAIL (email),
    CONSTRAINT FK_TUTORS_ADDR FOREIGN KEY (addr_id) REFERENCES address (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;


CREATE TABLE course
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(512)          DEFAULT NULL,
    start_date  DATE                  DEFAULT NULL,
    end_date    DATE                  DEFAULT NULL,
    tutor_id    BIGINT       NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_COURSE_TUTOR FOREIGN KEY (tutor_id) REFERENCES tutor (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;


CREATE TABLE course_enrollment
(
    id        BIGINT NOT NULL AUTO_INCREMENT,
    course_id BIGINT NOT NULL,
    stud_id   BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_ENROLLMENT_STUD FOREIGN KEY (stud_id) REFERENCES student (id),
    CONSTRAINT FK_ENROLLMENT_COURSE FOREIGN KEY (course_id) REFERENCES course (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;


INSERT INTO address (id, street, city, state, zip, country) VALUES
    (1, '4891 Pacific Hwy', 'San Diego', 'CA', '92110', 'San Diego'),
    (2, '2400 N Jefferson St', 'Perry', 'FL', '32347', 'Taylor'),
    (3, '710 N Cable Rd', 'Lima', 'OH', '45825', 'Allen'),
    (4, '5108 W Gore Blvd', 'Lawton', 'OK', '32365', 'Comanche');

INSERT INTO student (id, name, email, phone, dob, bio, pic, addr_id) VALUES
    (1, 'Timothy', 'timothy@gmail.com', '123-123-1234', '1988-04-25', NULL, NULL, 3),
    (2, 'Douglas', 'douglas@gmail.com', '789-456-1234', '1990-08-15', NULL, NULL, 4);

INSERT INTO tutor (id, name, email, phone, dob, gender, bio, pic, addr_id) VALUES
    (1, 'John', 'john@gmail.com', '111-222-3333', '1980-05-20', 'MALE', NULL, NULL, 1),
    (2, 'Ken', 'ken@gmail.com', '111-222-3333', '1980-05-20', 'MALE', NULL, NULL, 1),
    (3, 'Paul', 'paul@gmail.com', '123-321-4444', '1981-03-15', 'FEMALE', NULL, NULL, 2),
    (4, 'Mike', 'mike@gmail.com', '123-321-4444', '1981-03-15', 'MALE', NULL, NULL, 2);

INSERT INTO course (id, name, description, start_date, end_date, tutor_id) VALUES
    (1, 'Quickstart Core Java', 'Core Java Programming', '2013-03-01', '2013-04-15', 1),
    (2, 'Quickstart JavaEE6', 'Enterprise App Development using JavaEE6', '2013-04-01', '2013-08-30', 1),
    (3, 'MyBatis3 Premier', 'MyBatis 3 framework', '2013-06-01', '2013-07-15', 2);

INSERT INTO course_enrollment (course_id, stud_id) VALUES
    (1, 1),
    (1, 2),
    (2, 2);

