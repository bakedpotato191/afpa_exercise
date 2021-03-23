package com.bakedpotato.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection connect(String url, String host, String database, String username, String password) {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * CONNECTION TO DATABASE
		 */

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url + host + database, username, password);
			System.out.println("Connection successful !!");
			System.out.println(" ");
			// Do something with the Connection

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			/* Ignored */ }
	}
}
