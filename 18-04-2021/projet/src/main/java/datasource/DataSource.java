package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn = null;
		String url = "jdbc:mysql://";
		String host = "localhost/";
		String database = "java";
		String user = "user_test";
		String password = "password_test";

		try {
			conn = DriverManager.getConnection(url + host + database, user, password);
		} catch (SQLException ex) {
			ex.getMessage();
		}
		return conn;
	}

	private DataSource() {
		throw new IllegalStateException("Connect class");
	}
}
