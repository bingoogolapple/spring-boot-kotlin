# spring-boot-kotlin

> 创建 MySQL 容器

```
docker run -d -p 3306:3306 --name sbk_mysql -e MYSQL_ROOT_PASSWORD=111111 -e MYSQL_DATABASE=sbk mysql:latest --character-set-server=utf8 --collation-server=utf8_general_ci --lower-case-table-names=1
```
> 创建用户表

```
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL COMMENT '登录用户名需要建立唯一索引',
  `password` varchar(32) NOT NULL,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱地址',
  `cellphone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `inUser` varchar(50) NOT NULL COMMENT '创建人',
  `inDate` datetime(3) NOT NULL COMMENT '创建日期',
  `lastEditUser` varchar(50) NOT NULL COMMENT '更新人',
  `lastEditDate` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `isActive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1:Active 0:Deactive',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_t_user_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
> 在 IntelliJ IDEA 中运行

![image](https://user-images.githubusercontent.com/8949716/27800009-24f38830-604a-11e7-8c93-31845ff5bc9a.png)

> 在命令行中运行

```
gradle sbk-backend:clean sbk-backend:bootRun -Pdev
```
> 打包

```
gradle sbk-backend:clean sbk-backend:war -Pprod
```