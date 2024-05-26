package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// From Chennai (MAA) to Surat (STV)
public class G1_dynamic_dropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();  // Idenftifies 'From' & clicks on it.
	
	}
}
