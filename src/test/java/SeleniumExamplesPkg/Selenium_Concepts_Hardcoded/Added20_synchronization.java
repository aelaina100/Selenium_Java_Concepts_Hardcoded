package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Added20_synchronization {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver(); 
		/* Implicit Wait
		 * Explicit Wait
		 * Fluent Wait
		 * Thread.sleep()
		 */
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Syntax in Selenium 4.0
			
		
			//
		
		Thread.sleep(3000L);  // Belongs to Java; Not Selenium web driver.
	
	}

	

	
}
