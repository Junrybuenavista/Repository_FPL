

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;  
public class FPLDatabase{
	public FPLDatabase() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/fpldata","root","");  
			//here sonoo is database name, root is username and password 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT CAST( CURDATE() AS Date )"); 
			
			while(rs.next())  
				System.out.println(rs.getString(1));
			
			
			rs=stmt.executeQuery("select * from fpl_accounts where Update_Date IS null OR NOT Update_Date = CURDATE()"); 
			
			while(rs.next())  
				System.out.println(rs.getString(1)); 
			
			
			stmt.execute("UPDATE fpl_accounts SET Update_Date = '"+dateFormat.format(new Date())+"' where account_no ='348868589'");
			
			con.close();  
		}	catch(Exception e){ e.printStackTrace();}  
		
	}

	public static void main(String args[]){  
			new FPLDatabase();
	}
	
		
}  