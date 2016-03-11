package com.countryapi;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	private static Connection connection;
	public static Connection getConnection() {
		try {
			if(connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/countries", "root", "root");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
