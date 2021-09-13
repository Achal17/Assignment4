package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserJdbc {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/demo";
	private static String username = "root";
	private static String password = "Acha@123";

	protected static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}

}
