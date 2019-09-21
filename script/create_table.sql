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
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建角色表

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`(
  `id`           INTEGER NOT NULL AUTO_INCREMENT COMMENT '{name:"主键"}',
  `parent_id`    INTEGER NOT NULL COMMENT '{name:"父ID.0表示根ID"}',
  `role_name`    VARCHAR(64)  NOT NULL COMMENT '{name:"角色名称"}',
  `role_type`    VARCHAR(64)  NOT NULL COMMENT '{name:"角色标识"}',
  `role_num`     VARCHAR(32)  NOT NULL COMMENT '{name:"角色编号"}',
  `status`       INTEGER      DEFAULT 0 COMMENT '{name:"角色状态 0：启用 1：禁用"}',
  `gmt_create`   DATETIME    NOT NULL COMMENT '{name:"创建时间"}',
  `gmt_modify`   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:"更新时间"}',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建用户角色表

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`(
  `id`         INTEGER NOT NULL AUTO_INCREMENT COMMENT '{name:"主键"}',
  `user_id`    INTEGER NOT NULL COMMENT '{name:"用户ID"}',
  `role_id`    INTEGER NOT NULL COMMENT '{name:"角色ID"}',
  `gmt_create`   DATETIME    NOT NULL COMMENT '{name:"创建时间"}',
  `gmt_modify`   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:"更新时间"}',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建权限（菜单）表

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`(
  `id`           INTEGER NOT NULL AUTO_INCREMENT COMMENT '{name:"主键"}',
  `parent_id`    INTEGER NOT NULL COMMENT '{name:"父ID。0表示根ID"}',
  `perm_name`    VARCHAR(64)  NOT NULL COMMENT '{name:"权限名称"}',
  `perm_type`    VARCHAR(64)  NOT NULL COMMENT '{name:"权限标识"}',
  `perm_num`     VARCHAR(32)  DEFAULT NULL COMMENT '{name:"权限编号"}',
  `icon`     VARCHAR(32)  DEFAULT NULL COMMENT '{name:"图标"}',
  `url`     VARCHAR(255)  DEFAULT NULL COMMENT '{name:"访问url"}',
  `status`       INTEGER      DEFAULT 0 COMMENT '{name:"权限状态 0：启用 1：禁用"}',
  `gmt_create`   DATETIME    NOT NULL COMMENT '{name:"创建时间"}',
  `gmt_modify`   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:"更新时间"}',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建权限角色表

DROP TABLE IF EXISTS `sys_perm_role`;
CREATE TABLE `sys_perm_role`(
  `id`         INTEGER NOT NULL AUTO_INCREMENT COMMENT '{name:"主键"}',
  `role_id`    INTEGER NOT NULL COMMENT '{name:"角色ID"}',
  `perm_id`    INTEGER NOT NULL COMMENT '{name:"权限ID"}',
  `gmt_create`   DATETIME    NOT NULL COMMENT '{name:"创建时间"}',
  `gmt_modify`   TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '{name:"更新时间"}',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;