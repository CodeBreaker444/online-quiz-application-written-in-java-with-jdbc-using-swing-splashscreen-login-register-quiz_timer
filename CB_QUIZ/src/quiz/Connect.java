/**
 * 
 */
package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author codebreaker
 *
 */

public class Connect //create class Connectivity
{ 
	
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		
	    static final String DB_URL = "jdbc:mysql://localhost/sys";

	    public static String success="database_cnt_error.Proceeding in Offline Mode";
	    //  Database credentials
	    static final String USER = "root" ;
	    static final String PASS = "root";
	   
	    public static void main(String[] args) //main method
	    {
	    	Connection conn = null;//create object of Connection and define it null
	    	try //try block
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		System.out.println("Connecting to database...");
	    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    		success="Connected to database successfully";//used for offline mode detection
	    		System.out.println("Connected to database successfully...");	    	
                }
	    	catch(SQLException se)
	    	{
	    		se.printStackTrace();
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	finally 
	    	{
	    		try  
	    		{
	    			if(conn!=null)
	    			conn.close(); 
	    		}
	    		catch(SQLException se)
	    		{
	    			se.printStackTrace();
	    		}
	    	}
	    }
}