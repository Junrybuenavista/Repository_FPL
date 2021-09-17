
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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
	public Test(){
		// TODO Auto-generated method stub
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhunta\\eclipse\\selenium\\chromedriver.exe");
		
			HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			
			Jscript = (JavascriptExecutor) driver;

			driver.get("https://www.fpl.com/my-account/multi-dashboard.html");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(3000);
			
			Monitor monitor=new Monitor();
			monitor.start();
			
			//new SendEmail();
			//driver.quit();
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
									
				driver.findElement(By.id("core_view_form_ValidationTextBox_4")).sendKeys("8694466163");
				
							
				//WebElement name = driver.findElements(By.className("name")).get(2);
				//System.out.println("Name = "+name.getText());			
				//WebElement address = driver.findElements(By.className("address")).get(1);
				//System.out.println("address = "+address.getText());		
				//WebElement balance = driver.findElements(By.className("balance")).get(1);
				//System.out.println("balance = "+balance.getText());			
				//WebElement account = driver.findElements(By.xpath("//a[@class='account-number-link']")).get(0);
				//System.out.println("Account = "+account.getText());
							
					
				onClickXpath("Click Account No.","//a[@class='account-number-link']");
				onClickLink("Click Close","Close");
				onClickLink("Click View Bill","VIEW BILL");	
				onClickXpath("Click Download","//span[@id='core_view_form_Button_2_label']");
			}catch(Exception ee) {System.out.println("Monitor exception");ee.printStackTrace();}
				
			}
			public void onClickXpath(String title,String input) throws Exception
			{
				int timeouts = 0;
				scroll=new ScrollPage();
				scroll.start();
				while(true) {
					try {
						 if(timeouts == 0) 
							System.out.println("Starting "+title);
						 else
							 System.out.println("Timeout "+timeouts);				 
							driver.findElement(By.xpath(input)).click();
						scroll.stop();	
						System.out.println(title+" completes:");
						break;
					}catch(NoSuchElementException e) {System.out.println("Page refresh1");driver.navigate().refresh();}
					catch(Exception ee) {Thread.sleep(2000);}
				}
			}
			
			public void onClickLink(String title,String input) throws Exception
			{
				int timeouts = 0;
				scroll=new ScrollPage();
				scroll.start();
				while(true) {
					try {
						 if(timeouts == 0) 
							System.out.println("Starting "+title);
						 else
							 System.out.println("Timeout "+timeouts);
						 
						 driver.findElement(By.linkText(input)).click();
						scroll.stop();	
						System.out.println(title+" complete:");
						break;
					}catch(NoSuchElementException e) {System.out.println("Page refresh2");driver.navigate().refresh();}
					 catch(Exception ee) {Thread.sleep(2000);}
				}
			}
			public void onClickId(String title,String input) throws Exception
			{
				int timeouts = 0;
				scroll=new ScrollPage();
				scroll.start();
				while(true) {
					try {
						 if(timeouts == 0) 
							System.out.println("Starting "+title);
						 else
							 System.out.println("Timeout "+timeouts);
						 
						 driver.findElement(By.id(input)).click();
						scroll.stop();	
						System.out.println(title+" complete:");
						break;
					}catch(NoSuchElementException e) {System.out.println("Page refresh3");driver.navigate().refresh();}
					catch(Exception ee) {Thread.sleep(2000);}
				}
			}
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
