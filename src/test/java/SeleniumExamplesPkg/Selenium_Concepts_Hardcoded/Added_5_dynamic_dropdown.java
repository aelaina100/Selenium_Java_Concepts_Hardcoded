package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Added_5_dynamic_dropdown {
	
	@Test
	public void Added_4_dynamic_dropdownTest()
	{
	// In: https://rahulshettyacademy.com/dropdownsPractise/"
	  // From the 'PASSENGERS' dropdown, select 3 adults and click on 'Done'
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*"); 
	WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	// IMPORTANT: Open in-cognito if you encounter issues with elements on the web page.

	
}
	
	
	
	
	
	
	
	
  }