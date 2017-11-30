/**
 * 
 */
package quiz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import quiz.Questions;
import quiz.Login;
/**
 * @author codebreaker
 *
 */

public class Results extends JFrame 
{
	private JPanel contentPane;
	private JButton Again;
	private JButton Exit;
	private JButton Answers;
	public static String results;
	private boolean login;
	protected java.lang.String Spassword;
	
	// database URL
	static final String DB_URL = "jdbc:mysql://localhost/sys";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	protected static final String String = null;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try  
				{
					Results frame = new Results();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public Results()
	{	
		setTitle("Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int results=Questions.score;
		String result=String.valueOf(results);
		
	
		JLabel username = new JLabel("<html>Hey....<html>"+Login.usernameq+"!");
		username.setBounds(220, 40, 200, 200);
		contentPane.add(username);
		results=10-results;
		String wrong=String.valueOf(results);
		
		JLabel finalresult = new JLabel("<html>Your FinalScore is:<html>"+result+"<html><br>Total Right Answers: <html>"+result+"<html><br>Total Wrong Answers: <html>"+wrong);
		finalresult.setBounds(200, 90, 200, 200);
		contentPane.add(finalresult);
		
		
		Exit = new JButton("Exit");
		Exit.setBounds(270, 251, 89, 23);
		contentPane.add(Exit);
		Exit.addActionListener(new ActionListener() 
                {
		                public void actionPerformed(ActionEvent e) 
                                {				
                                
		                	System.exit(0);
                                }
		});
	
	
		Again = new JButton("Play Again");
		Again.setBounds(180, 251, 89, 23);
		contentPane.add(Again);	
		Again.addActionListener(new ActionListener() 
		{

		    public void actionPerformed(ActionEvent e) {
		        
		        new Login().setVisible(true); 
		        dispose();
		    }

		});
		
		
		Answers = new JButton("Answers");
		Answers.setBounds(225, 291, 89, 23);
		contentPane.add(Answers);	
		Answers.addActionListener(new ActionListener() 
		{

		    public void actionPerformed(ActionEvent e) {
		        
		        new Answers().setVisible(true); 
		        dispose();
		    }

		});
			
		
		JLabel label2 = new JLabel("CB");
		label2.setText("Coded BY CODEBREAKER");
		label2.setBounds(350, 300, 200, 100);
		contentPane.add(label2);
}}