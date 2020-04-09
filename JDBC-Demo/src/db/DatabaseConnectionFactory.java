package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnectionFactory {

	static Connection con;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String path = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "MKJOnline";
		String password = "online";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(path, username, password);
		return con;
	}
	
	
}
