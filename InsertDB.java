
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDB {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
        
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBConnection.getConnection();
			//just a test to get some user input and insert into the db
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your username");
			String userName = scanner.nextLine();
			System.out.println("Enter your first name");
			String firstName = scanner.nextLine();
			System.out.println("Enter your last name");
			String lastName = scanner.nextLine();
			System.out.println("Enter your password");
			String passWord = scanner.nextLine();
			
			//inserting user input into the db
			System.out.println("Inserting records into the table...");
			String query = "INSERT INTO users " + "VALUES(?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setNull(1, java.sql.Types.INTEGER);
			ps.setString(2, userName);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, passWord);
			ps.setString(6, "true");
			ps.executeUpdate();
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(ps!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	//end JDBCExample
/**public static void insertMessage(){
	Connection conn = null;
	PreparedStatement ps = null;
	try{
		conn = DBConnection.getConnection();
		//just a test to get some user input and insert into the db
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in your message!");
		String message = scanner.nextLine();
	}
	
}
**/	
}