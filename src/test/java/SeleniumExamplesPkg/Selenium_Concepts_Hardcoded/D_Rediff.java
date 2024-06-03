package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class D_Rediff {

	@Test
	public void siblingTest()
	{
		// At this point, ensure that you've reviewed all locators written notes.
		// A program illustrating the use of the Xpath sibling technique.

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Below: Click on the 'Practice' button
		


	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	@Test
	public void rediffTest()
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		
		driver.get("https://www.rediff.com/");  
		
		//clicking on the 'Sign in' link ( I verified that it's a link as its associated HTML code has the tag name 'a'):
		//driver.findElement(By.linkText("Sign in")).click(); 
		
		//clicking on the 'Sign in' link:
		//driver.findElement(By.xpath("//a[contains(@title, 'Already a user')]")).click(); 
		//or ccs regular experession:
		driver.findElement(By.cssSelector("a[title*='Already a user']")).click();
		
		//Locating the 'Username' field and entering a text into it:
		driver.findElement(By.id("login1")).sendKeys("Aelaina100");    //punch of xpath or css or even Regular expressions, etc , etccould've been used
		
		//Locating the password field and entering a text into it:
		driver.findElement(By.id("password")).sendKeys("rwrsesfs");  //punch of xpath or css or even Regular expressions, etc , etccould've been used
		
		//Locating the 'Sign in' button and clicking on it:
		driver.findElement(By.className("signinbtn")).click();   //punch of xpath or css or even Regular expressions, etc , etccould've been used

	}

}
