/**
 * 
 */
package quiz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Wrapper;
import quiz.Connect;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * @author codebreaker
 *
 */

public class Register extends JFrame 
{
	private JPanel contentPane; 
	private JTextField txtUser;
	private JTextField txtName;
	private JTextField txtMail;
	private JTextField txtPassword1;
	private JButton btnSignup;
	private JButton btnLogin;
	protected java.lang.String Spassword;
	
	// database URL
	static final String DB_URL = "jdbc:mysql://localhost/sys";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	protected static final String String = null;
	
	
	public static void main(String[] args) 
	{
	Connect.main(null);//Database Connection

		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Register frame = new Register();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public Register() 
	{	
		setTitle("Welcome To CB Quiz:"+Connect.success);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		//create object of JPanel
		contentPane = new JPanel();
		JLabel label1 = new JLabel("SignUp");
		label1.setText("SIGN UP");
		label1.setBounds(250, 10, 50, 60);
		label1.setSize(50, 20);
		contentPane.add(label1);
		JLabel label2 = new JLabel("CB");
		label2.setText("Coded BY CODEBREAKER");
		label2.setBounds(350, 300, 200, 100);
		contentPane.add(label2);
                //set contentPane border
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		//set ContentPane with new object
		setContentPane(contentPane);
		//set contentPane layout is null
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(250, 51, 99, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtMail = new JTextField();
		txtMail.setBounds(250, 102, 99, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		txtUser = new JTextField();
		txtUser.setBounds(250, 153, 99, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		txtPassword1 = new JTextField();
		txtPassword1.setBounds(250, 204, 99, 20);
		contentPane.add(txtPassword1);
		txtPassword1.setColumns(10);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(170,54,86,14);
		contentPane.add(lblName);
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(170, 105, 86, 14);
		contentPane.add(lblMail);
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(170, 156, 86, 14);
		contentPane.add(lblUserName);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(170, 207, 86, 14);
		contentPane.add(lblPassword);
		
		
        //create buttonsignup
		btnSignup = new JButton("SignUp");

		btnSignup.setBounds(250, 251, 89, 23);
		contentPane.add(btnSignup);
		btnSignup.addActionListener(new ActionListener() 
                {
		                public void actionPerformed(ActionEvent e) 
                                {				
		                	Connect.main(null);
                 if(Connect.success.equals("Connected to database successfully")) {
				Wrapper conn = null;
				try  //try block
                                {
				String full_name= "";
				String g_mail= "";
				String user_name = "";
				String passwd = "";
				
				full_name = txtName.getText().trim();
				g_mail = txtMail.getText().trim();
				user_name = txtUser.getText().trim();
				passwd = txtPassword1.getText().trim();
				
                                // check condition it field equals to blank throw error message
				if (user_name.equals("")|| passwd.equals(""))
				{
					JOptionPane.showMessageDialog(null," name or password or Role is wrong","Error",JOptionPane.ERROR_MESSAGE);
				}
				else  //else insert query is run properly
                                {
					String IQuery = "INSERT INTO `sys`.`quiz`(`full_name`,`g_mail`,`user_name`,`passwd`) VALUES('"+full_name+"','"+g_mail+"','"+user_name+"', '"+passwd+"')";
					System.out.println(IQuery);//print on console
					System.out.println("Connecting to a selected database...");
				
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("Connected database successfully...");
					  
				((Connection)conn).createStatement().execute(IQuery);//select the rows
					// define SMessage variable
					String SMessage = "Successfully Registered as "+user_name;
					
                                       // create dialog ox which is print message
	                    JOptionPane.showMessageDialog(null,SMessage,"Message",JOptionPane.PLAIN_MESSAGE);
					((java.sql.Connection)conn).close();
				}				
                                
				
			}
                 
			catch (SQLException se) 
			{
				//handle errors for JDBC
				se.printStackTrace();
			}
			catch (Exception a) //catch block
			{
				a.printStackTrace();
			}
                 }
                 else {
                	 String SMessage="\n------Error Info------\n$database_cnt_error.Proceeding in Offline Mode :localhost server must be present."
 			    			+ "\nIf not it accepts any password or username in login screen(Registration not going to work in Offline Mode)";
 					JOptionPane.showMessageDialog(null,SMessage,"About",JOptionPane.ERROR_MESSAGE); 
 					new Login().setVisible(true);
 					dispose();
	                }
                                
                                }
                                
		    
		               
		});
	
		
		btnLogin = new JButton("Login");

		btnLogin.setBounds(160, 251, 89, 23);
		contentPane.add(btnLogin);
	
		btnLogin.addActionListener(new ActionListener() 
		{

		    public void actionPerformed(ActionEvent e) {
		        new Login().setVisible(true); 
		        dispose();
		    }

		});
	}
	
	
}