

import java.sql.*;
import java.util.Date;  
public class FPLDatabase{
	public FPLDatabase() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/fpldata","root","");  
			//here sonoo is database name, root is username and password 
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from fpl_accounts"); 
			
			while(rs.next())  
				System.out.println(rs.getString(1)); 
			
			Date date = new Date();
			System.out.println(date.getDate());
			stmt.execute("UPDATE fpl_accounts SET Update_Date = '2008-11-12' where account_no ='191498179'");
			con.close();  
		}	catch(Exception e){ e.printStackTrace();}  
		
	}

	public static void main(String args[]){  
			new FPLDatabase();
	}
	
		
}  