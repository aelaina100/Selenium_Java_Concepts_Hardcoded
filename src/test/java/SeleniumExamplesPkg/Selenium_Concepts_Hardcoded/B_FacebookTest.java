package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class B_FacebookTest {

	@Test
	public void B_Facebooklogin() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.get("https://www.facebook.com/");
		
		// Locates the username field (& automatically moves cursor into it)
		 driver.findElement(By.id("email")).sendKeys("testAutomation@gmail.com"); 
		//driver.findElement(By.name("email")).sendKeys("testAutomation@gmail.com");
		
		// Locates the password field and moves cursor into it
		driver.findElement(By.id("pass")).sendKeys("857472");
		
		//Located the login button & clicks on it
		//driver.findElement(By.name("login")).click();
		
		// Clicks on the "Forgot password" link
		driver.findElement(By.linkText("Forgotten password?")).click(); // Note !: link text, used to be "Forgot password ?"
		// ABove line: As you can see, the link text has changed from 'forgotten password?' to 'forgot password?'. So create a regular expression
		  // Xpath or css with the constant (fixed) string of 'forgot'
		
		Thread.sleep(3000L);
		driver.close();

	}

}
