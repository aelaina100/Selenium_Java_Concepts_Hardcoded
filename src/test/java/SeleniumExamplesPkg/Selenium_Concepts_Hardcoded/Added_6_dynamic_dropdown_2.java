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
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']/table/tbody/tr[2]/td[2]/div[3]/div[1]/div[1]/ul[1]/li[7]/a")).click();
		// LOL
	}

}
