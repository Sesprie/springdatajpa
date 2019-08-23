package com.xixi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity//声明实体类
@Table(name = "t_customer")//配置实体类和表的映射关系，name：配置数据库表的名称，不指定则数据库名就与当前类名同名
public class Customer {


	
	/**
	 * @Id: 声明主键
	 * @GeneratedValue: 配置主键的生成策略
	 * 		GenerationType.IDENTIRY: 自增，需要相应数据库支持auto_increment
	 * 		GenerationType.TABLE: 维护另一张表记录下一条记录的的id
	 * 		GenerationType.AUTO: 根据情况自动选择
	 * 		GenerationType.SEQUENCE: 序列，用于oracle
	 * 
	 * @Column: 配置属性和字段的映射关系：
	 * 	name: 数据库表中的字段的名称
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id")//不指定表字段名就与当前属性同名
	private long id;
	
	@Column(name = "t_username")
	private String username;
	
	@Column(name = "t_phone")
	private String phone;
	
}
