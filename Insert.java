import java.sql.*;

/**
   Insert class that inserts into DB
*/

public class Insert{

   
   //inserts into users table
   public static void insertUser(String uName, String fName, String lName, String pWord)
   {
   
          Connection conn = null;
		    PreparedStatement ps = null;
          try{
                //variables containing passed in values 
                String userName = uName;
      			 String firstName = fName;
      			 String lastName = lName;
      			 String passWord = pWord;
                
                conn = DBConnection.getConnection();
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

         
   
   }
   public static void insertMessage(String newMessage, int ID){
		Connection conn = null;
		PreparedStatement ps = null;
		try{
     
        String msg = newMessage;
			conn = DBConnection.getConnection();
			
			//Scanner scanner = new Scanner(System.in);
			//System.out.println("Type in your message!");
			//String message = scanner.nextLine();
			
        
			
			//insert the message into the db
			System.out.println("Inserting message into the msg table");
			String query = "INSERT INTO messages " + "VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setNull(1, java.sql.Types.INTEGER);
			ps.setInt(2, ID); //this is just some arbitrary number, we need a getter/setter
			ps.setString(3, msg);
			ps.setDate(4, getCurrentDate());
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
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}	






}


