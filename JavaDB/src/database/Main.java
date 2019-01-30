package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {
		// Calling getConnection function requires throws Exception for main method
		getConnection();
	}
	
	// Establishes our database to MySQL
	// Import Connection and add return statement
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			// CREATE DATABASE javaDB and USE javaDB in MySQL Workbench
			String url = "jdbc:mysql://localhost:3306/javaDB";
			// My credentials in MySQL Workbench
			String userName = "root";
			String passWord = "root";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

}
