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
  `password` varchar(32) NOT NULL,
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱地址',
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_user_username` (`username`) USING BTREE
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
  UNIQUE KEY `ix_t_label_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```
> 创建 Issue 表

```sql
DROP TABLE IF EXISTS `t_issue`;
CREATE TABLE `t_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT 'Issue标题需要建立唯一索引',
  `inUser` varchar(30) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(30) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_issue_title` (`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
```