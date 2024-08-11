package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added32Assignment {
	/* On:  "https://rahulshettyacademy.com/AutomationPractice/"
	 * 1- Select any checkbox
	 * 2- In the adjacent dropdown, select the option that reflects the selected checkbox. 
	 * 3- In the 'Enter Your Name' field below, enter the text of the selected checkbox/dropdown option.
	 * 4- Click on 'Alert' & verify that the alert text contains the text of the selected checkbox/dropdown option
	 */
	@Test
	public void added32AssignmentTest()
	{
	    WebDriver driver = new ChromeDriver();
	     driver.manage().deleteAllCookies();
	     driver.manage().window().maximize();
	     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	     driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	     //1:
	     wait.until(ExpectedConditions.elementToBeClickable(By.id("checkBoxOption1")));
	     driver.findElement(By.id("checkBoxOption1")).click();
	     String checkBoxText= driver.findElement(By.cssSelector("label[for= 'bmw']")).getText().trim(); 
	     System.out.println(checkBoxText); // debugging purposes only.
	     //2:
	     
	     wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-class-example")));
	     Select s= new Select(driver.findElement(By.id("dropdown-class-example")));
	     s.selectByVisibleText(checkBoxText);
	     //s.selectByValue(checkBoxText.toLowerCase());  // works too.
	     
	     //3:
	     wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
	     driver.findElement(By.id("name")).sendKeys(checkBoxText);
	     //4:
	     wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
	     driver.findElement(By.id("alertbtn")).click();
	     
	     wait.until(ExpectedConditions.alertIsPresent()); // for ALL types of alerts/ pop-ups:   HTML & Java (Doesn't have an associated HTML code
	     String alertText= driver.switchTo().alert().getText();
	     Assert.assertTrue(alertText.contains(checkBoxText), "Alert text does NOT contain the text of: " + checkBoxText);
	}
	

}
