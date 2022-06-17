package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {

	private static DataBase db = new DataBase();

	private Connection conn;

	public static DataBase instance() {
		return db;
	}

	private DataBase() {
	}

	public Connection getConnection() {
		return conn;
	}

	public void connect(Properties props) throws SQLException {

		String server = props.getProperty("server");
		String port = props.getProperty("port");
		String service = props.getProperty("service");
		String user = props.getProperty("user");
		String password = props.getProperty("password");

		String url = String.format("jdbc:oracle:thin:@//%s:%s/%s", server, port, service);
		// System.out.println(url);

		conn = DriverManager.getConnection(url, user, password);
		var stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("select * from USERTEST");

		stmt.close();
		res.close();
	}

	public void close() throws SQLException {
		conn.close();
	}

}
