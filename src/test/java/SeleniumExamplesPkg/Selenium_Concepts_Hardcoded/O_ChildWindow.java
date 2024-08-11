package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
// Navigate to Amazon and click on "Returns and Orders" while holding down the 'Shift' button (This is to render a child window opened up/launched)
public class O_ChildWindow {
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver();  // Utilizing the new feature of Selenium Manager introduced in Selenium 4.0
		
	   
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.get("https://www.amazon.ca/");
		
		Thread.sleep(5000L); // This line is to resolve a Captcha widget. During this time, enter verification code manually.
		// Where the other real-time method is" Disabling the Captcha in the testing environment by:
				//entering 'Site key' & 'Secret Key' in Google's open source Captcha widget.
		
		
		Actions a= new Actions(driver);
		WebElement element_returnsOrders= driver.findElement(By.id("nav-orders"));
		a.moveToElement(element_returnsOrders).keyDown(Keys.SHIFT).click().build().perform();
		
		//Now, I want to finish automating on the child window that has just been launched,
		 // So, I need to first swich my driver from the original parent window and onto the child window. To do so:
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		String parentWindowHandleId= it.next();
		String childWindowHandleId= it.next();
		
		driver.switchTo().window(childWindowHandleId);  // Driver has been switched to the child window
		
		driver.findElement(By.id("ap_email")).sendKeys("SomeRandomEmail@randomness.com"); //enters email adress.
		
		// Below: Now, on the original parent window- Click on 'Best Sellers' button
		driver.switchTo().window(parentWindowHandleId); // for later: why not :driver.switchTo().defaultContent(); --> Answer: this is to switch from a frame and onto the default content
		driver.findElement(By.linkText("Best Sellers")).click();
		
		// Below: On this same original parent window- click on 'Deals Store' while holding the 'Shift' key down
		// so that a sub child window pops-up
		WebElement element_dealsStore= driver.findElement(By.linkText("Deals Store"));
		a.moveToElement(element_dealsStore).keyDown(Keys.SHIFT).click().build().perform();
		Thread.sleep(3000L);
		
		
		//On this sub child window, hover mouse over 'Prime' so that a green preview appears (as of this date)
		 // so first, I have to switch my driver from my current child window (where its currently at) and onto this sub sub-child window
		 
		 //String x= it.next(); // causing error !
		 
		 System.out.println(parentWindowHandleId);
		 System.out.println(childWindowHandleId);
		 //System.out.println(it.next());
		 
		//driver.switchTo().window(subChildWindowHandleId);
		driver.switchTo().window(it.next());
		
		
		driver.findElement(By.linkText("Gift ideas")).click();  // Using LinkText is not going to work here (review <HTML code>, 
		  // Instead, Text can only be used in text xpath.
		//Thread.sleep(6000L);
		//driver.quit();
		
		// CRUCUAL: There is a missing example where while(it.hasnext()) is used (Real time stuff). consult your notes (I believe its the example
		 // where you click on all links on some webpage and then you get all the open pages titles)
		
		
		

	}

}
