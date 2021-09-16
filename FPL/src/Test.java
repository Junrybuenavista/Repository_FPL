import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//xidwgumwwowibzwt
public class Test {

	WebDriver driver;
	public Test(){
		// TODO Auto-generated method stub
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhunta\\eclipse\\selenium\\chromedriver.exe");
		
			HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			
			driver.get("https://www.fpl.com/my-account/multi-dashboard.html");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
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
						
			//driver.quit();
		}catch(Exception ee) {ee.printStackTrace();}
	}
	public void onClickXpath(String title,String input) throws Exception
	{
		int timeouts = 0;
		while(true) {
			try {
				 if(timeouts == 0) 
					System.out.println("Starting "+title);
				 else
					 System.out.println("Timeout "+timeouts);
				 
					driver.findElement(By.xpath(input)).click();
					
				System.out.println(title+" completes:");
				break;
			}catch(Exception ee) {scrollPage();Thread.sleep(500);}
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
			}catch(Exception ee) {scrollPage();Thread.sleep(500);}
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
			}catch(Exception ee) {Thread.sleep(500);}
		}
	}
	public void scrollPage() {
		JavascriptExecutor Scrool = (JavascriptExecutor) driver;
		Scrool.executeScript("window.scrollBy(0,50)", "");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void main(String args[]) {new Test();}
}
