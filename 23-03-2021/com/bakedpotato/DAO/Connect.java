package com.bakedpotato.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection getConnection() {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn = null;
		String url = "jdbc:mysql://";
		String host = "localhost/";
		String database = "formation";
		String user = "test";
		String password = "test";

		try {
			conn = DriverManager.getConnection(url + host + database, user, password);
			System.out.println("Connection successful !!");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
}
