package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Added29_assig_childWindow {
	
	/* TC#1
	 * 1- Navigate to: https://the-internet.herokuapp.com
	 * 2- Click on "Multiple windows"so that page navigates to another one.
	 * 3- Click on "Click Here". A child window pops up.
	 * 4- In the child window, print out the text of "New Window"
	 * 5- On the parent page, print out the text of "Opening a new window"
	 */
	
	@Test
	public void assigChildWindowTest() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Multiple Windows")));
		driver.findElement(By.linkText("Multiple Windows")).click();      // navigates to another page.
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click Here")));
		driver.findElement(By.linkText("Click Here")).click();           // opens up a child window.
		
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		String parentWindowHandleId= it.next();
		String childWindowHandleId= it.next();
		driver.switchTo().window(childWindowHandleId); // switches to the child window
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		System.out.println(	driver.findElement(By.tagName("h3")).getText());
		
	    driver.switchTo().window(parentWindowHandleId);  // switches to the parent window
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		System.out.println(	driver.findElement(By.tagName("h3")).getText());
		
		driver.quit();  // closes ALL opened windows since the very beginning of the session/testcase/method.	
	}

}
