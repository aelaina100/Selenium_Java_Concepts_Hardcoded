package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Added_static_dropDown {
	
	@Test
	public void seleniumManager()
	{
		  
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);   
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
	}

}
