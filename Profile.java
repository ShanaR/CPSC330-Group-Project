import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class Profile implements Screen, ActionListener {

	JFrame frame = new JFrame("Profile");
	JButton postMessage, logOut; 
	JTextField message, myMessages;
   JTextArea allMessages; 
	int ID;
	
	public void createLayout(String Username, int Id) //public void createLayout(int id)
	{
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel one, two, bigger, last;
		JLabel name, messageHeader;
	
		ID = Id;
		bigger = new JPanel();
		bigger.setLayout(new GridLayout(1, 2));
		one = new JPanel();
		two = new JPanel();
		last = new JPanel();
		one.setLayout( new GridLayout( 3,1 ));
		name = new JLabel(Username + " " + Id);
		one.add(name);
		message = new JTextField(140);
		one.add(message);
		postMessage = new JButton("Post Message");
		postMessage.addActionListener(this);
		one.add(postMessage);
      
      messageHeader = new JLabel("Recent Messages");
      two.add(messageHeader); 
      allMessages = new JTextArea(15, 30);
      JScrollPane scrolledText = new JScrollPane(allMessages);
      scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      two.add(scrolledText);
       
		//myMessages = new JTextField(140);
		//two.add(myMessages);
		bigger.add(one);
		bigger.add(two);
		logOut = new JButton("Logout");
		logOut.addActionListener(this);
		last.add(logOut);
		frame.add(last, BorderLayout.SOUTH);
		frame.add(bigger, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==postMessage){
			 String msg = message.getText();
			 System.out.println(msg);
			 Insert.insertMessage(msg, ID);
			 //frame.setVisible(false);
			 //frame.dispose();
			 //add message
		 }
		 else if(e.getSource()==logOut){
			 frame.setVisible(false);
			 frame.dispose();
			 String dontMatter = "";
			 int dontM = 0;
			 HomeScreen myHS = new HomeScreen();
			 myHS.createLayout(dontMatter, dontM);
			 //add message
		 }
		 
	}
}
