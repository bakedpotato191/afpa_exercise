package com.bakedpotato.sql;

import java.sql.Connection;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {
	public static void main(String[] args) {

		String url = "jdbc:mysql://";
		String host = "localhost/";
		String database = "formation";
		String user = "test";
		String password = "test";

		Connection conn = GetConnection.connect(url, host, database, user, password);

		String query = "SELECT * FROM programme WHERE tarif>30";

		MakeQuery.query(conn, query);

		GetConnection.close(conn);

	}
}