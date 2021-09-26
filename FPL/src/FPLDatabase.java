

import java.sql.*;  
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
				System.out.println(rs.getDate(4));  
			con.close();  
		}	catch(Exception e){ e.printStackTrace();}  
		
	}
	public void checkUpdate() {
		
	}
	public static void main(String args[]){  
			new FPLDatabase();
	}
	
		
}  