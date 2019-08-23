package com.xixi.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	
	private int id;
	private String username;
	private String address;
	
	public User(String username, String address) {
		this.username = username;
		this.address = address;
	}
	
}
