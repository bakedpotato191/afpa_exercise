package com.bakedpotato.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MakeQuery {

	public static void query(Connection conn, String query) {

		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			// Now do something with the ResultSet ....
			rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			for (int i = 1; i <= columnsNumber; i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.print(columnName + " ");
			}
			System.out.println("");
			System.out.println("");
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print("  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		/*
		 * RELEASE RESOURCES AND CLOSE CONNECTION
		 */
		finally {
			try {
				rs.close();
			} catch (Exception e) {
				/* Ignored */ }
			try {
				stmt.close();
			} catch (Exception e) {
				/* Ignored */ }
		}
	}
}
