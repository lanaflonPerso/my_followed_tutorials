DROP DATABASE IF EXISTS proficient;

CREATE DATABASE IF NOT EXISTS proficient
  COLLATE = 'utf8_general_ci'
  DEFAULT CHARACTER SET = 'utf8';

USE proficient;

## 创建用户表
CREATE TABLE t_user (
  user_id    INT AUTO_INCREMENT PRIMARY KEY,
  user_name  VARCHAR(30),
  password   VARCHAR(32),
  credits    INT,
  last_visit DATETIME,
  last_ip    VARCHAR(16)
)
  ENGINE = InnoDB,
  DEFAULT CHARSET = utf8;

## 创建用户登录日志表
CREATE TABLE t_login_log (
  login_log_id   INT AUTO_INCREMENT PRIMARY KEY,
  user_id        INT,
  ip             VARCHAR(16),
  login_datetime DATETIME
)
  ENGINE = InnoDB,
  DEFAULT CHARSET = utf8;

## 插入初始化数据
INSERT INTO t_user (user_name, password)
VALUES ('admin', '123456');

INSERT INTO t_login_log (user_id, ip)
VALUES (1, '192.168.100.100');

COMMIT;
