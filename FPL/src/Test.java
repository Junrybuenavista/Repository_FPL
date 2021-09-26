
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.sql.*; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.testng.annotations.Test;
//xidwgumwwowibzwt
public class Test {

	WebDriver driver;
	JavascriptExecutor Jscript;
	ScrollPage scroll;
	Statement stmt;
	ResultSet rs;
	Statement stmt2;
	ResultSet rs2;
	
	public Test(){
		
		
		setDataBaseConnection();
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhunta\\eclipse\\selenium\\chromedriver.exe");
		
			HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			
			Jscript = (JavascriptExecutor) driver;

			driver.get("https://www.fpl.com/my-account/multi-dashboard.html");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Thread.sleep(3000);
			
			Monitor monitor=new Monitor();
			monitor.start();
			
			
		}catch(NoSuchElementException e) {System.out.println("Page refresh");driver.navigate().refresh();}
		catch(Exception ee) {ee.printStackTrace();}
	}
	class Monitor extends Thread
	{		public void run() {
			try {
				driver.findElement(By.id("core_view_form_ValidationTextBox_0")).sendKeys("bookkeeper@nbvresorts.com");
				driver.findElement(By.id("core_view_form_ValidationTextBox_1")).sendKeys("2019SandaPar");
				//driver.findElement(By.xpath("//input[@id='core_view_form_ValidationTextBox_1']")).sendKeys("2019SandaPar");			
				onClickId("Login","core_view_form_Button_0_label");
									
				rs=stmt.executeQuery("select * from fpl_accounts");
				Date checkDate;
				String account_No;
				while(rs.next()) {
					
					checkDate = rs.getDate(4);
					account_No = rs.getString(1);
					System.out.println(account_No);
					if(checkDate==null) {
						System.out.println(account_No);
						driver.findElement(By.id("core_view_form_ValidationTextBox_4")).sendKeys(account_No);			
						onClickXpath("Click Account No.","//a[@class='account-number-link']",false);
						System.out.println("updating");
						stmt2.execute("UPDATE fpl_accounts SET Update_Date = '2008-11-12' where account_no ='"+account_No+"'");
						System.out.println(account_No+" updated");
						driver.get("https://www.fpl.com/my-account/multi-dashboard.html");
					}
					
				}
				
				
				
				//onClickLink("Click Close","Close");
				//onClickLink("Click View Bill","VIEW BILL");	
				//onClickXpath("Click Download","//span[@id='core_view_form_Button_2_label']",true);
				
				
				
			}catch(NoSuchElementException e) {System.out.println("Page refreshmonitor");driver.navigate().refresh();}
			catch(Exception ee) {System.out.println("Monitor exception");ee.printStackTrace();}
				
			}
			public void onClickXpath(String title,String input,boolean forEmail) throws Exception
			{
				int timeouts = 0;
				
				while(true) {
					try {
						 if(timeouts == 0) 
							System.out.println("Starting "+title);
						 else
							 System.out.println("Timeout "+timeouts);				 
							driver.findElement(By.xpath(input)).click();
						
							if(forEmail == true) {
								new SendEmail();
								driver.quit();
							}
							
						System.out.println(title+" complete:");
						break;
					}catch(NoSuchElementException e) {System.out.println("Page refresh1");driver.navigate().refresh();}
					catch(Exception ee) {scrollDown();}
				}
			}
			
			public void onClickLink(String title,String input) throws Exception
			{
				int timeouts = 0;
				
				while(true) {
					try {
						 if(timeouts == 0) 
							System.out.println("Starting "+title);
						 else
							 System.out.println("Timeout "+timeouts);
						 
						 driver.findElement(By.linkText(input)).click();
						
						System.out.println(title+" complete:");
						break;
					}catch(NoSuchElementException e) {System.out.println("Page refresh2");driver.navigate().refresh();}
					 catch(Exception ee) {scrollDown();}
				}
			}
			public void onClickId(String title,String input) throws Exception
			{
				int timeouts = 0;
				
				while(true) {
					try {
						 if(timeouts == 0) 
							System.out.println("Starting "+title);
						 else
							 System.out.println("Timeout "+timeouts);
						 
						 driver.findElement(By.id(input)).click();
						
						System.out.println(title+" complete:");
						break;
					}catch(NoSuchElementException e) {System.out.println("Page refresh3");driver.navigate().refresh();}
					catch(Exception ee) {scrollDown();}
				}
			}
			public void scrollDown() {
				 Jscript.executeScript("window.scrollBy(0,100)", "");
			}
	}
	public void setDataBaseConnection() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/fpldata","root","");  	
			stmt=con.createStatement();
			stmt2=con.createStatement();
			
		   }catch(Exception e){ e.printStackTrace();}  
	}
	
	class ScrollPage extends Thread {
		public void run() {
			try {
				 while(true) {
			            Jscript.executeScript("window.scrollBy(0,10)", "");
			            Thread.sleep(100);}
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}catch(Exception ee) {ee.printStackTrace();}
		}
		
	}
	
	public static void main(String args[]) {new Test();}
}
