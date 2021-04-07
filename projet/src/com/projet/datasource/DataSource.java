package com.projet.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

	private static HikariConfig config = new HikariConfig("resources/config.properties");
	static HikariDataSource ds = new HikariDataSource(config);

	private DataSource() {
	}

	public static Connection getConnection() {

		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}