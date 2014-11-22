import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;




public class HomeScreen implements Screen, ActionListener {


	JFrame frame = new JFrame("Home Screen");
	JButton login, register, viewMessages;
	private JTextField name, pass;
	public void createLayout(String dontMatter, int dontM)
	{
		JPanel pane = new JPanel();
		JPanel pane1 = new JPanel();
		frame.setSize(500, 300  );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JButton login, register, viewMessages;
		JLabel username, password;
		login = new JButton("Login");
		login.addActionListener(this);
		pane.add(login);
		register = new JButton("Register");
		register.addActionListener(this);
		pane.add(register);
		viewMessages = new JButton("View Public Messages");
		viewMessages.addActionListener(this);
		pane.add(viewMessages);
		pane1.setLayout( new GridLayout( 2,2 ));
		username = new JLabel("Username");
		pane1.add(username);
		name = new JTextField(5);
		pane1.add(name);
		password = new JLabel("Password");
		pane1.add(password);
		pass = new JTextField(5);
		pane1.add(pass);
		frame.add(pane, BorderLayout.SOUTH);
		frame.add(pane1, BorderLayout.CENTER);
	//	frame.getContentPane().add(BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==register){
			 frame.setVisible(false);
			 frame.dispose();
			
			 String dontMatter = "";
			 int dontMa = 0;
			 Registration myRegistration = new Registration();
			 myRegistration.createLayout(dontMatter, dontMa);
		 }
		 else if(e.getSource()==login){
			 //If Login Information is correct
          //variables to hold info read in from text fields 
          String userName = name.getText();
          String passWord = pass.getText();
          
          int equal, equal1;
          equal = userName.compareTo("");
          equal1 = passWord.compareTo("");
          
          if((equal==0)&&(equal1==0))
          {
        	  JOptionPane.showMessageDialog(frame, "You must enter a username and password.");
     	 	  return;
          }
          else if(equal==0)
          {
        	  JOptionPane.showMessageDialog(frame, "You must enter a username.");
     	 	  return;
          }
          else if(equal1==0)
          {
        	  JOptionPane.showMessageDialog(frame, "You must enter a password.");
     	 	  return;
          }
          
            Connection conn = null;
         	Statement stmt = null;{
         	try{
         		conn = DBConnection.getConnection();
         		
         		System.out.println("Creating statemnt");
         		stmt = conn.createStatement();
         		
         		String sql = "SELECT userID, userName, password FROM users";
         		ResultSet rs = stmt.executeQuery(sql);
         		//extract the data from result set, iterate over the columns
         		while(rs.next()){
         			String usrnm = rs.getString("userName");
         			String pswd = rs.getString("password");
         			int uID = rs.getInt("userID");
         			if (userName.equals(usrnm) && passWord.equals(pswd)){
         			System.out.println("password: " + pswd);
         			System.out.println("userName: " + usrnm);
                   frame.setVisible(false);
			          frame.dispose();
			          Profile myProfile = new Profile();
			          myProfile.createLayout(userName, uID);//myProfile.createLayout(id)
                  }
                  else {
                     System.out.println("This user does not exist in the system.");
                     //JOptionPane.showMessageDialog(frame, "This user does not exist in the system.");
            	 	 //return;
                  
                  }
         		}
         		rs.close();
         	   }catch(SQLException se){
         	      //Handle errors for JDBC
         	      se.printStackTrace();
         	   }catch(Exception ex){
         	      //Handle errors for Class.forName
         	      ex.printStackTrace();
         	   }finally{
         	      //finally block used to close resources
         	      try{
         	         if(stmt!=null)
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
         }//end JDBCExample

          
           
			
		 
		 else if(e.getSource()==viewMessages){
			 
			 frame.setVisible(false);
			 frame.dispose();
			 String dontMatter = "";
			 int dontM = 0;
			 ViewPublicMessages myVPM = new ViewPublicMessages();
			 myVPM.createLayout(dontMatter, dontM);
		 }
	}
	
}
