

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;  
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
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
			
			rs=stmt.executeQuery("select * from fpl_accounts where Update_Date IS null OR NOT Update_Date = CURDATE()"); 
			
			while(rs.next())  
				System.out.println(rs.getString(1)); 
			
			
			
				File f = new File("C:\\FPL_Downloads\\Document.pdf");
				if(f.exists()) System.out.println("file exist");
				System.out.println();
				
				f.renameTo(new File("C:\\FPL_Downloads\\"+dateFormat.format(new Date())+"_123.pdf"));
				//File file2 = new File("C:\\FPL_Downloads\\Documentnewname.pdf");
				
				//f.renameTo(file2);
	
			
			      
			
			//stmt.execute("UPDATE fpl_accounts SET Update_Date = '"+dateFormat.format(new Date())+"' where account_no ='348868589'");
			
			con.close();  
		}	catch(Exception e){ e.printStackTrace();}  
		
	}

	public static void main(String args[]){  
			new FPLDatabase();
	}
	
		
}  