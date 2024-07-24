package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added15_alerts {
	
	/* 1st, visit the supplementary written notes
	 */
	  
	@Test(enabled =false)    // Observe the following code;
	public void alertTest()
	{
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
		driver.findElement(By.id("alertbtn")).click();  // clicking on the alert button so that a Java alert/pop-up appears
	
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept(); //clicks on 'Ok' of the alert. So that. alert disappears.
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
		driver.findElement(By.id("alertbtn")).click();  // Again- Clicking on the alert button so that a Java alert/pop-up appears.
		
		wait.until(ExpectedConditions.alertIsPresent());
		String alertMessage= driver.switchTo().alert().getText();//Getting the text in the alert message and printing it onto the screen.
		System.out.println(alertMessage);
		}
	
	/* TC #2
	 * Navigate to: https://rahulshettyacademy.com/AutomationPractice/
	 * In the section of 'Switch To Alert Example', Enter a name.
	 * Click on 'Alert' button
	 * In the pop-up, ensure that the displayed text contains the name entered
	 * + another step to ensure that the the pop-up contains text.
	 * 
	 */
	@Test
	public void alertVerifyTest()
	{
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String name= "Ahmad";
		wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		driver.findElement(By.id("name")).sendKeys(name);   //enters a name in the text field.
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
		driver.findElement(By.id("alertbtn")).click();  // clicking on the alert button so that a Java alert/pop-up appears
		
		wait.until(ExpectedConditions.alertIsPresent());
		//Assert.assertTrue(driver.switchTo().alert().getText().contains(name));
		Assert.assertNotEquals(driver.switchTo().alert().getText(), null);
		
		
		
	}

}
