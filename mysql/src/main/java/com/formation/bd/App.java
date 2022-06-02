package com.formation.bd;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		var db = DataBase.instance();

		try {
			db.connect();
		} catch (SQLException e) {
			System.out.println("Cannot connect to db");
		}

		System.out.println("connected");

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close db connection");
		}
	}
}
