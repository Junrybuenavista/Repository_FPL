import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;

public class FPL2 {
	
	public FPL2() 
	{
		// # Constants used in this example
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"; 
		final String LOGIN_FORM_URL = "https://mail.rediff.com/cgi-bin/login.cgi";
		final String USERNAME = "junrybuenavista@rediffmail.com";  
		final String PASSWORD = "Killingme(";  

		try {
				// # Go to login page
				Connection.Response loginFormResponse = Jsoup.connect(LOGIN_FORM_URL)
				                                             .method(Connection.Method.GET)
				                                             .userAgent(USER_AGENT)
				                                             .execute();  
		
				// # Fill the login form
				// ## Find the form first...
				FormElement loginForm = (FormElement)loginFormResponse.parse()
				                                         .select("form").first();
				checkElement("Login Form", loginForm);

				// ## ... then "type" the username ...
				Element loginField = loginForm.select("#login1").first();
				checkElement("Login Field", loginField);
				loginField.val(USERNAME);
				
				// ## ... and "type" the password
				Element passwordField = loginForm.select("#password").first();
				checkElement("Password Field", passwordField);
				passwordField.val(PASSWORD);
				
				// # Now send the form for login
				Connection.Response loginActionResponse = loginForm.submit()
				         .cookies(loginFormResponse.cookies())
				         .userAgent(USER_AGENT)  
				         .execute();
		
				
				System.out.println(loginActionResponse.parse().html());
				//System.out.println(loginForm);
		}catch(Exception e) {e.printStackTrace();}		

	}
	public static void checkElement(String name, Element elem) {
	    if (elem == null) {
	        throw new RuntimeException("Unable to finds " + name);
	    }
	}
	public static void main(String[] args) {
		new FPL2();

	}
	
}
