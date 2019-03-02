package com.rest.sample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION ="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_USER = "SYSTEM";
	private static final String DB_PASSWORD = "SYSTEM";
	
	
	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {
			System.out.println(1);
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("2");
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
System.out.println("3");
		return dbConnection;

	}
}
