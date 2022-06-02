package com.formation.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	private static DataBase db = new DataBase();
	private static final String URL = "jdbc:sqlite:people.db";
	private Connection conn;

	public static DataBase instance() {
		return db;
	}
	private DataBase() {
	}

	public void connect() throws SQLException {

		conn = DriverManager.getConnection(URL);

	}

	public void close() throws SQLException {
		conn.close();
	}

}
