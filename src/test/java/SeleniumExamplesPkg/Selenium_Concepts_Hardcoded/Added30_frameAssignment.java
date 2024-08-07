package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/* TC: 1-Navigate to "https://the-internet.herokuapp.com"
 *     2-Click on 'Frames' > 'Nested Frames' > Print out, to the console, 'Middle' text.
 * 
 */
public class Added30_frameAssignment {
	
	@Test
	public void frameAssigTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Frames")));
		driver.findElement(By.partialLinkText("Frames")).click();  // partial, assuming the link text will in future will have a space(s) before or after it.
		
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Nested Frame")));
		driver.findElement(By.partialLinkText("Nested Frames")).click(); // same story
		
		System.out.println(driver.findElements(By.tagName("frame")).size()); // Only gives the number of outer frames
	    // Now, the element to be interacted withis ina frame that's inside a frame:
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame-top")); // String can be either an id or name locator (here it is 'name' locator).
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame-middle")); // String can be either an id or name locator (here it is 'name' locator).
		/* below is the unoptimized way of switching to the frames
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("frame-top")));
		driver.switchTo().frame("frame-top"); // the string can be either an id or name locator (here it is 'name' locator)
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("frame-middle")));
		driver.switchTo().frame("frame-middle"); // the string can be either an id or name locator (here it is 'name' locator)
		*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content"))); 
		//This wait method: May sound 'weird' but the idea is: Once the box element 'becomes' "visible", the text inside it becomes visible at the same time.
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
