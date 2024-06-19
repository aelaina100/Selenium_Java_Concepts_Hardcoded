package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class zzzzzzzzzzzzzz {
	
	@Test
	public void A()
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*"); 
		  WebDriver driver = new ChromeDriver(options); 
		driver.get("https://login.salesforce.com/?locale=ca");
		
		//Below line is to enter username
		//driver.findElement(By.id("username")).sendKeys("RandomUserName");
		
		// The below line will return an error of: Compound classes are not accepted.
		driver.findElement(By.className("r4")).sendKeys("SomeRandottyyytte");
		
		//However; As a fix, the line below works well
		//driver.findElement(By.cssSelector("input.input.r4.wide.mb16.mt8.username")).sendKeys("USERBBBBBBB");
		
		// or even the below line:
		//driver.findElement(By.xpath("//input[@class= 'input r4 wide mb16 mt8 username'] ")).sendKeys("USERNAMMMMAEE");
		
		// But once again the id is to be used first and foremost ( The other locator techniques above are for demonstrational purposed ONLY)
		
		//Below line is to enter the password 
		driver.findElement(By.id("password")).sendKeys("Password");
		
		//below line is to click on the login button
		driver.findElement(By.id("Login")).click();
	}

}
