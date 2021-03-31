package exercice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

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
			System.out.println("Connection successful !!");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}

	private Connect() {
		throw new IllegalStateException("Connect class");
	}
}