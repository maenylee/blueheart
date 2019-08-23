-- 创建数据库blueheart

CREATE DATABASE `blueheart`;

-- 创建用户表

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id`           INTEGER NOT NULL AUTO_INCREMENT COMMENT '{name:"主键"}',
  `user_name`    VARCHAR(64)  NOT NULL COMMENT '{name:"用户名"}',
  `real_name`    VARCHAR(32)  DEFAULT NULL COMMENT '{name:"真实名称"}',
  `password`     VARCHAR(64)  NOT NULL COMMENT '{name:"用户密码"}',
  `sex`          INTEGER      DEFAULT NULL COMMENT '{name:"性别"}',
  `age`          INTEGER      DEFAULT NULL COMMENT '{name:"年龄"}',
  `address`      VARCHAR(255) DEFAULT NULL COMMENT '{name:"家庭住址"}',
  `qq`           VARCHAR(32)     DEFAULT NULL COMMENT '{name:"QQ号"}',
  `phone_number`   VARCHAR(13)    DEFAULT NULL COMMENT '{name:"手机号"}',
  `register_ip`    VARCHAR(32)    DEFAULT NULL COMMENT '{name:"注册IP地址"}',
  `graduate_school`   VARCHAR(32)     DEFAULT NULL COMMENT '{name:"毕业院校"}',
  `status`       INTEGER      DEFAULT 0 COMMENT '{name:"用户状态 0：活跃 1：删除"}',
  `gmt_create`   DATETIME    NOT NULL COMMENT '{name:"创建时间"}',
  `gmt_modify`   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:"更新时间"}',
  PRIMARY KEY (`id`)
);