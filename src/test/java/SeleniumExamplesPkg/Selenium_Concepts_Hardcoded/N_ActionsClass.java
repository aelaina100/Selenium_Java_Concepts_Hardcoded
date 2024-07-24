package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class N_ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		
	       //**************************************************************************************
        // On the Amazon website, simply hover the mouse over:  Hello Sign in                  *
        //                                                      Account & Lists                *
        //                  and then do a right-click AKA context click                                               *
        //**************************************************************************************
		

		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver();     
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.amazon.ca/");
		
		Thread.sleep(5000L); // This line is to resolve a Captcha widget. During this time, enter verification code manually.
		// Where the other real-time method is" Disabling the Captcha in the testing environment by:
				//entering 'Site key' & 'Secret Key' in Google's open source Captcha widget.
		Actions a= new Actions(driver);
		WebElement element= driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(element).contextClick().build().perform();

	}

}
