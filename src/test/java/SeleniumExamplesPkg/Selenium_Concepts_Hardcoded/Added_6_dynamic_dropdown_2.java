package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Added_6_dynamic_dropdown_2 {
	
	//Assume that the 2nd instance XPATH technique isn't accepted by the SDET (Even though there is no reason for that)
	
	@Test
	public void Added_6_dynamnic_dropdown_test() throws InterruptedException
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // clicks on the Dymanic droplist
		
		Thread.sleep(1000L);
		driver.findElement(By.xpath("(//a[@value='MAA'])")).click();
		
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("div[id= 'ctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='BHO']")).click();
		// Above line: The idea was to use a regular expression CSS for the containing box as in ==>
		////     div[id*= 'destinationStation1']  but validation showed that it's not unique. so NEVER use it.
		
		
	}

}
