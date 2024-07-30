package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


                         /* TC#1:
                          * 1- Navigate to: https://rahulshettyacademy.com/loginpagePractise/
                          * 2- Click on the flashing link (This will open a child window)
                          * 3- In the child window, print out the text in red onto the screen.
                          * 4- Ensure that the box element that's supposed to contain red text actually contains text regardless of what it is.
                          */
public class Added28_childWindows {
	
	@Test(enabled=false)
	public void firstChildWindowTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("blinkingText"))); 
		driver.findElement(By.className("blinkingText")).click();   // this opens a child window that we need to move the controller to
		
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		 //String parentWidnowHandleId= it.next();   // commented out since 'parentWidnowHandleId' will be marked as unused variable warning.
		it.next();  // it iterates to the parent. The value it returns that is   String parentWidnowHandleId isn't included (So not to get a warning msg)
		String childWindowHandleId=  it.next();   // then to the child
		driver.switchTo().window(childWindowHandleId);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));
		String redText= driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(redText); // prints out the text onto the screen.
		// Later: how about you close the child window and switch back to the parent one.
		//Below: Ensuring that in the box element, text is not null (There is a text regardless of what it is)
		Assert.assertTrue(redText.length()>0, "Red text is empty");   
		// or:
		Assert.assertNotEquals(redText, null); 
	}
	
	
	/* TC#2:
     * 1- Navigate to: https://rahulshettyacademy.com/loginpagePractise/
     * 2- Click on the flashing link (This will open a child window)
     * 3- In the child window, in the red text, use the email address as the username in the parent window.
     */
	@Test
	public void secondChildWindowTest() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("blinkingText"))); 
		driver.findElement(By.className("blinkingText")).click();   // this opens a child window that we need to move the controller to
		
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		String parentWidnowHandleId = it.next();  
		String childWindowHandleId  =  it.next();   // then it iterates to the child
		driver.switchTo().window(childWindowHandleId);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText()); //Essential for ebugging purposes only.
		
		String extractedEmail= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];
		System.out.println(extractedEmail); // debugging purposes only.
		
		/*//unoptimized way of applying string operations:
	    String array[]= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at "); // an array of 2 elements.
	    String array2[]= array[1].split(" "); // splits based on ALL spaces. Result is an array of 7 elements
	    System.out.println(array2.length); // debugging purposes to show its an array consisting of 7 elements.
	    String extractedEmail= array2[0];
	    System.out.println(extractedEmail);  // for debugging purposes only
	    */
	    // CRUCIAL NOTE: I used split() based on 'at + space'. Hence no need for trim(), similarily
	     // you can use .split("at") [with no space] and then use .trim() to trim space(s) at the front and the back (front & back ONLY) of the string
	    
        driver.close();   // to close the child window after extracting the text (Optional)
		driver.switchTo().window(parentWidnowHandleId);  // driver switches back to the parent window
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(extractedEmail);
		
		Thread.sleep(2000L);
		driver.findElement(By.id("username")).clear(); // additional step to clear the text.
	    
		
		/*   // Below code section is unrecommended as it exrtacts the substring (Email address) directly based on the <HTML code> associated with the 
		 *   // email/substring: Avoid this, by simply using String operations (split method) to extract the
		 *   // substring from the entire string. 
		 *   //
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.im-para.red a"))); //For the box element only holding the email address
		String extractedEmail= driver.findElement(By.cssSelector("p.im-para.red a")).getText(); // xpath= //p[@class= 'im-para red']/strong/a
		driver.close();   // to close the child window after extracting the text (Optional)
		
		driver.switchTo().window(parentWidnowHandleId);  // driver switches back to the parent window
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(extractedEmail);
		*/	
	}
	
	/* TC#3:
     * 1- Navigate to: https://rahulshettyacademy.com/loginpagePractise/
     * 2- Click on the flashing link (This will open a child window)
     * 3- Ensure that the red text contains "mentor@rahulshettyacademy.com"
     */
	
	@Test(enabled=false)
	public void thirdChildWindowTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("blinkingText"))); 
		driver.findElement(By.className("blinkingText")).click();   // this opens a child window that we need to move the controller to
		
		Set<String> ids= driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		 //String parentWidnowHandleId= it.next();   // commented out since 'parentWidnowHandleId' will be marked as unused variable warning.
		it.next();  // it iterates to the parent. The value it returns that is   String parentWidnowHandleId isn't included (So not to get a warning msg)
		String childWindowHandleId=  it.next();   // then it iterates to the child
		driver.switchTo().window(childWindowHandleId);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-para.red")));
		String redText= driver.findElement(By.cssSelector(".im-para.red")).getText();
		String email= "mentor@rahulshettyacademy.com";
		Assert.assertTrue(redText.contains(email), "Email: " + email+ " is not contained within the string message");		
	}

}
