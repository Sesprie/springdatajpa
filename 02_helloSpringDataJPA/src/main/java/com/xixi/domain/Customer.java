package com.xixi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/*
 * 使用lombok插件需要为ide装上插件，同时还需要已provided的方式引入jar包
 */
@Entity
@Table(name = "t_customer")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id")
	private long id;

	@Column(name = "t_username")
	private String username;

	@Column(name = "t_phone")
	private String phone;
	
	
}
