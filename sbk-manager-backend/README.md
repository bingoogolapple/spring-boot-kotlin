# sbk-manager-backend

> 创建 MySQL 容器

```
docker run -d -p 3306:3306 --name sbk_mysql -e MYSQL_ROOT_PASSWORD=111111 -e MYSQL_DATABASE=sbk mysql:latest --character-set-server=utf8 --collation-server=utf8_general_ci --lower-case-table-names=1
```
> 创建 User 表

```sql
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL COMMENT '登录用户名需要建立唯一索引',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱地址',
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Role 表

```sql
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '角色名需要建立唯一索引',
  `description` varchar(50) NOT NULL COMMENT '角色描述',
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_role_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Function 表

```sql
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(30) NOT NULL COMMENT '授权Key需要建立唯一索引',
  `name` varchar(30) NOT NULL COMMENT '授权名称',
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_function_key` (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 User 和 Role 关联表

```sql
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  KEY `ix_t_user_role_userId` (`userId`),
  KEY `ix_t_user_role_roleId` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Role 和 Function 关联表

```sql
DROP TABLE IF EXISTS `t_role_function`;
CREATE TABLE `t_role_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `functionId` int(11) NOT NULL,
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  KEY `t_role_function_roleId` (`roleId`),
  KEY `t_role_function_functionId` (`functionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Label 表

```sql
DROP TABLE IF EXISTS `t_label`;
CREATE TABLE `t_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '标签名需要建立唯一索引',
  `color` varchar(7) NOT NULL COMMENT '颜色',
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_label_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Issue 表

```sql
DROP TABLE IF EXISTS `t_issue`;
CREATE TABLE `t_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT 'Issue标题需要建立唯一索引',
  `labelId` int(11) NOT NULL,
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_issue_title` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Comment 表

```sql
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(500) NOT NULL COMMENT '内容',
  `issueId` int(11) NOT NULL,
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```