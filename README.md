# spring-boot-kotlin

> 创建 MySQL 容器

```
docker run -d -p 3306:3306 --name sbk_mysql -e MYSQL_ROOT_PASSWORD=111111 -e MYSQL_DATABASE=sbk mysql:latest --character-set-server=utf8 --collation-server=utf8_general_ci --lower-case-table-names=1
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