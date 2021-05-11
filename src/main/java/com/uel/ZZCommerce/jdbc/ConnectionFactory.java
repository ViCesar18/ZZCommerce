package com.uel.ZZCommerce.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"
					+ "commerce?useTimezone=true&serverTimezone=America/"
					+ "Sao_Paulo", 
					"claudio", "1234");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
