

//STEP 1. Import required packages
import java.sql.*;

public class DBConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
	static final String DB_URL = "jdbc:ucanaccess://C:/Users/Shana/Documents/UMW/Fall 2014/CPSC330/CPSC330.accdb";

	// Database credentials
	static final String USER = "";
	static final String PASS = "";

	public static Connection getConnection(){
	//public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null; 
		try {
			// STEP 2: Register JDBC driver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
		return conn;
	}// end main
}// end JDBCExample

