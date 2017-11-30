/**
 * 
 */
package quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import quiz.Connect;
/**
 * @author codebreaker
 *
 */
public class CB_Quiz extends JFrame {
	public JPanel panel;
	public Image BackgroundImage;
	JButton about;
	JButton start;
	JButton works;
	JLabel cbquiz;
	  public static void main(String args[])
	    {
	    	Connect.main(null);//Status for database from Connect.java
	    	EventQueue.invokeLater(new Runnable() 
			{
				public void run()
				{
					try  
					{
						CB_Quiz frame = new CB_Quiz();
	                                       
						frame.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
	    }
	
	    public CB_Quiz()
	    {
	    	setTitle("WELCOME to CB_QUIZ");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 420);
			panel = new JPanel();
			//panel.setBorder(new EmptyBorder(10, 10, 10, 10));
			setContentPane(panel);
			panel.setLayout(null);
			
			setLayout(new BorderLayout());
		    JLabel background=new JLabel(new ImageIcon(getClass().getResource("/quiz/cb.jpg")));
		    add(background);
		    //background.setLayout(new FlowLayout());
			JLabel cbquiz = new JLabel("CB_QUIZ");
			cbquiz.setText("CB_QUIZ");
			cbquiz.setBounds(50, 90, 800, 200);
			//cbquiz.setSize(110, 20);
			cbquiz.setFont(new Font("Sans Serif", Font.BOLD, 35));
		    cbquiz.setForeground(Color.WHITE);
			background.add(cbquiz);
			JButton start=new JButton("Start Quiz");
			start.setBounds(630,120,100,100);
			start.setSize(110, 40);
			background.add(start);
			start.addActionListener(new ActionListener() 
			{

			    public void actionPerformed(ActionEvent e) {
			        new Login().setVisible(true);
			        dispose();
			    }

			});
			JButton about=new JButton("About");
			about.setBounds(630,220,100,100);
			about.setSize(110,40);
			background.add(about);
			about.addActionListener(new ActionListener() 
			{

			    public void actionPerformed(ActionEvent e) {
			    	String SMessage="@Author: CodeBreaker\n@Page:facebook.com/zer0error\n------Error Info------\n$database_cnt_error.Proceeding in Offline Mode :localhost server must be present."
			    			+ "\nIf not it accepts any password or username in login screen(Registration not going to work in Offline Mode)";
					JOptionPane.showMessageDialog(null,SMessage,"About",JOptionPane.PLAIN_MESSAGE);    
			    }

			});
			JLabel label2 = new JLabel("CB");
			label2.setText("Coded BY CODEBREAKER");
			label2.setBounds(620, 310, 200, 100);
			background.add(label2);
		    label2.setForeground(Color.WHITE);
		    
		    JLabel label3 = new JLabel("STATUS");
			label3.setText("Status:"+Connect.success);
			label3.setBounds(20, 310, 600, 100);
			background.add(label3);
		    label3.setForeground(Color.WHITE);
		    if(Connect.success.equalsIgnoreCase("Connected to database successfully")) {
		    	label3.setForeground(Color.green);
		    }else
		    	label3.setForeground(Color.red);


		
		    
		    
	    
	    }

	   
}	  

