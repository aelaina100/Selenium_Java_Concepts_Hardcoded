package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

                     //===========================================================
                    // Automate: Is the link titled, "Rest API" brocken or not ?||
                   //            Is its server accessible or not.               ||
                  //============================================================||

public class J1_BrockenLinksDetection {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement restApi_element= driver.findElement(By.linkText("REST API"));
		String url= restApi_element.getAttribute("href");   // href is an attribute that happens to have the url value of this link.
		
		// A- Create a connection to internet network:
		HttpURLConnection connect= (HttpURLConnection) new URL(url).openConnection();
		// B- Set the request type of HEAD http (to make a call to the url)
		connect.setRequestMethod("HEAD");
		// C- Send the URL through the established connection to Internet networks
		connect.connect();
		//D- Get the status code:
		int statusCode= connect.getResponseCode();
		System.out.println(statusCode); 
		if(statusCode>400)
		{
			System.out.println(" FAILED: Link is brocken of: '"  + restApi_element.getText() + "' As status code is: " + statusCode);
			//Assert.assertTrue(false);
		}
		else
		{
			System.out.println(" Pass: '"+ restApi_element.getText()+ "' Link is functional as status code is: " + statusCode);
		}
	}
}
