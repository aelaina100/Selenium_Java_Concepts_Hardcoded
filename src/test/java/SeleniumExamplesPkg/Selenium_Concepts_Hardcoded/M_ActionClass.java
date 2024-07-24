package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


  // A-  On the Amazon web site, utilizing mouse & Keyboard operations, In the search field type in a word with capital letters and highlight it.
public class M_ActionClass {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
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
		Actions a= new Actions (driver);
		WebElement element= driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("text").keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).build().perform();
		// FOR THE IMMEDIATE ABOVE LINE:-- The following two methods below NEVER worked:
		  //.keyUp(Keys.SHIFT).sendKeys(Keys.chord(Keys.CONTROL, "a"))    OR   keyUp(Keys.SHIFT).keyDown(Keys.CONTROL + Keys.chord("A"))
		    // Investigate further.
		
	// Furthermore- Earlier, the above line of code was written as (Look below)----> [ NOT A GOOD CODING IN MY OPINION]
	 //a.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("text").click().doubleClick().build().perform();
		// Where- double click is in and by itself enough to highlight the text. However; use click and then double click to ENSURE That the text will be highlighted
		Thread.sleep(2000L);
  //B- Clear up the text
		a.moveToElement(element).click().doubleClick().keyDown(Keys.BACK_SPACE).build().perform();
	}
}
