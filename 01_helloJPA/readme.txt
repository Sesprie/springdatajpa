JPA入门，使用hibernate实现


1.引入依赖
	数据库连接池 c3p0
	数据库驱动 mysql-connector
	hibernate
	junit
	log4j
	
2.配置resources/META-INF/persistence.xml
3.建立实体类
4.将实体类于表之间建立关系



表示使用默认端口localhost:3306
jdbc:mysql:///jpa






JPA规范：
JPA全称：Java Persistence API
实现了ORM思想的框架：mybatis、hibernate
JPA是应用ORM思想的一个规范(可理解为接口)，即此规范的实现用法都是一样的
遵循JPA规范的：Hibernate、TopLink

JDBC规范：
无论是Mysql驱动或者Oracle驱动，其用法相同，因为他们都遵循JDBC规范


JPA和Hibernate的关系类似JDBC和JDBC驱动的关系















/*=======================================================================*/

CREATE DATABASE test;

USE test;

CREATE TABLE t_customer(
	t_id INT NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
	t_username VARCHAR(20) DEFAULT NULL COMMENT '客户名称(公司名称)',
	t_phone VARCHAR(32) DEFAULT NULL COMMENT '客户电话',
	PRIMARY KEY(`t_id`)
)DEFAULT CHARSET=utf8;




/*=======================================================================*/


