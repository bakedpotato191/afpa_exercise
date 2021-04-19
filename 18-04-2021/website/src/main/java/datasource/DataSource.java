package datasource;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;

	static {
		config.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
		config.addDataSourceProperty("user", "user_test");
		config.addDataSourceProperty("password", "password_test");
		config.addDataSourceProperty("databaseName", "java");
		config.addDataSourceProperty("port", 3306);
		config.addDataSourceProperty("serverName", "localhost");
		config.addDataSourceProperty("cachePrepStmts", true);
		config.addDataSourceProperty("prepStmtCacheSize", 250);
		config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		config.addDataSourceProperty("useServerPrepStmts", true);
		config.addDataSourceProperty("useLocalSessionState", true);
		config.addDataSourceProperty("rewriteBatchedStatements", true);
		config.addDataSourceProperty("cacheResultSetMetadata", true);
		config.addDataSourceProperty("cacheServerConfiguration", true);
		config.addDataSourceProperty("elideSetAutoCommits", true);
		config.addDataSourceProperty("maintainTimeStats", true);

		ds = new HikariDataSource(config);
	}

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
