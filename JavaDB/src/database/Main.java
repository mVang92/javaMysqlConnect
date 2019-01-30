package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {
		// Calling getConnection function requires throws Exception for main method
//		getConnection();
		// Call the createTable function directly
		createTable();
	}

	// Creating a table
	public static void createTable() throws Exception {
		try {
			// Call getConnection function to connect to database
			Connection con = getConnection();
			// Import PreparedStatement(java.sql)
			// Create SQL query
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS customers (id INT NOT NULL AUTO_INCREMENT, firstName VARCHAR(255), lastName VARCHAR(255), email VARCHAR(255), PRIMARY KEY (id))");
			// Run the query assigned to create
			create.executeUpdate();
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			System.out.println("Query ran successfully.");
		}
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
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}
