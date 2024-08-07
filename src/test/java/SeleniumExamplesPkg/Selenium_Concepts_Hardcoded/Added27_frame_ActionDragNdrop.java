package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/* TC:
 * 1- In 'https://jqueryui.com/droppable/', do the drag and drop
 * 2- Click on the 'Download' button.
 */
public class Added27_frame_ActionDragNdrop {
	
	@Test
	public void dragNdropActionTest()
	{
		WebDriver driver= new ChromeDriver();  // Utilizing Selenium Manager to launch the browser
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3000));
		driver.get("https://jqueryui.com/droppable/");
		//System.out.println(driver.findElements(By.tagName("iframe")).size());  // finding out the number of frames on the web page.
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); works ! But switching to a frame by index isn't reliable, as tomorrow..
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame"))); // works !
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // Or switching using the old fasion way; still needs an explicit wait.
		 // But the frame explicit wait is the best most reliable way of doing it !.
		
		Actions a= new Actions(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));
		WebElement source= driver.findElement(By.id("draggable"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
		WebElement target= driver.findElement(By.id("droppable"));
		
		a.moveToElement(source).dragAndDrop(source, target).build().perform(); 
		
		//2: Clicking on the 'Download' button.
		  // So we have to switch back from the frame and onto the default content 
	    driver.switchTo().defaultContent();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Download")));
		driver.findElement(By.partialLinkText("Download")).click(); 
		// Partial link text assuming that the text will have a space(s) before or after it in the future.
		}
	}


