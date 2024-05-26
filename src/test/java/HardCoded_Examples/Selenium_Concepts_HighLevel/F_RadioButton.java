package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


// I believe code is correct. However; not working 
public class F_RadioButton {

	public static void main(String[] args) throws InterruptedException {
		
		//http://practice.cybertekschool.com/radio_buttons
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://practice.cybertekschool.com/radio_buttons");
		Thread.sleep(4000L);
		// From the list of radio buttons, select 'Yellow'
		int count= driver.findElements(By.name("sport")).size();
		
		for(int i=0; i<count; i++)
		{
			String color= driver.findElements(By.name("color")).get(i).getText();
			if (color.equalsIgnoreCase("Yellow"))
			{
				driver.findElements(By.name("color")).get(i).click();
				break;  // essential !!
				
			}
			else
		// or replace it (Recommended) by:  else if(i= count-1) { Assert.assertTrue(False; " Yellow isn't in the list"
				 // where i= count-1 means the last index
				  //only begins to executes if "yellow' isn't in the list to start with.
				  // Note: it might be a good idea to keep the else {continue'} statement and add the else if. 
			{
				continue; 
			}
		} 
		// same thing with the below code (Modify it by adding the else if (i= count-1)
		// From the list of sports, select 'Hockey'
		int sportCount= driver.findElements(By.name("sport")).size();
		for (int i=0; i<sportCount; i++)
		{
			String sport = driver.findElements(By.name("sport")).get(i).getText();
			if(sport.equalsIgnoreCase("Hockey"))
			{
				driver.findElements(By.name("sport")).get(i).click();
			}
			
			else
			{
				continue;
			} 
			}
		}
	}


