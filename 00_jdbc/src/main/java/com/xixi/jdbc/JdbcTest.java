package com.xixi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 * 测试jdbc的执行过程
 * @author Asus
 *
 */
public class JdbcTest {

	
	public static void main(String[] args) {
		try {
			//1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3309/test";
			String username = "root";
			String password = "root";
			//2.获取连接
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "insert into t_user(username, address) values(?,?)";
			//3.获取statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			User user = new User("张三", "beijing");
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2,user.getAddress());
			//4.执行SQL语句
			int res = preparedStatement.executeUpdate();
			System.out.println("执行结果: " + res);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}


/*
CREATE DATABASE test;

USE test;

CREATE TABLE t_user(
	id INT NOT NULL auto_increment,
	username VARCHAR(20),
	address VARCHAR(50),
	PRIMARY KEY(id)
);

INSERT INTO t_user VALUES(2,"占三","beijing");
 */
