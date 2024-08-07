package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Added24_ActionClass {

	// On the Amazon website, Notice that- As a surfer, you can hover the mouse over the search field then click on it so that cursor blinks inside it
	 //, then click-hold on the SHIFT button and enter the text of 'hello' (Once again as a user you can perform that. So: Automate this.)
	public static void main(String[] args) throws InterruptedException {
		
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
		WebElement element= driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
// Separate: resolutions to Encountering Captcha:
//       https://www.guvi.in/blog/how-to-automate-captcha-in-selenium/

