package HardCoded_Examples.Selenium_Concepts_HighLevel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class J_Implicit_ExplicitWaits {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		//Global Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Global explicit wait ( Latest syntax) 
		
		WebDriverWait d= new WebDriverWait(driver,Duration.ofSeconds(5));
		d.until(ExpectedConditions.alertIsPresent());   
		
		// Never mix up Implicit & Explicit waits together ! Ever !!

		//CRUCIAL: Explore all methods under the 'ExpectedConditions' class. This is of supreme importance.
			//d.until(ExpectedConditions.
		
		
		
		

		
		
	}

}
