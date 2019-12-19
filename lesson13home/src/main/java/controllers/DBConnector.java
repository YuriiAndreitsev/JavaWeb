package controllers;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DBConnector {
	public DBConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/shop?user=root&password=");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
}
