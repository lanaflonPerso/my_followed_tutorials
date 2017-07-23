CREATE DATABASE IF NOT EXISTS angular
    COLLATE = 'utf8_general_ci'
    DEFAULT CHARACTER SET = 'utf8';

USE angular;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id        BIGINT(20) PRIMARY KEY AUTO_INCREMENT
    COMMENT '主键id',
    name      VARCHAR(32) COMMENT '用户名',
    password  VARCHAR(32) COMMENT '密码',
    sex  VARCHAR(8),
    nick_name VARCHAR(32)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;
