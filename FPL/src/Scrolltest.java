import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Scrolltest 
{


 public Scrolltest()throws Exception
         {
	 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jhunta\\eclipse\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.awwwards.com/websites/scrolling/");
		
            //to perform Scroll on application using Selenium
            JavascriptExecutor js = (JavascriptExecutor) driver;
            while(true) {
            js.executeScript("window.scrollBy(0,100)", "");
            Thread.sleep(1000);}
         }
 public static void main(String args[])throws Exception {new Scrolltest();}
}