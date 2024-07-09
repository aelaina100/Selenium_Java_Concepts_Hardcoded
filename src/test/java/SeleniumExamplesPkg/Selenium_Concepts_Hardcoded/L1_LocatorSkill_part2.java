package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
// This exact example is repeated under the project of 'StreamStuff' (similar class name)
/* Testcase: 
  Navigate to the Url "https://rahulshettyacademy.com/seleniumPractise/#/offers"
 1 Click on the button 'Next'.
 2- Click on the button '4'.
 3- Attempt Clicking on the button 'Next' and ensure that it is not clickable.
  
           */
public class L1_LocatorSkill_part2 {
	
	@Test
	public void L2_LocatorSkill_part2Test() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver_104.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// 1- Click on button 'Next'
		Thread.sleep(3000L);
		driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		
		// 2- Now, click on button '4'
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//span[text()='4']")).click();
		
		// 3- Now- Click on button 'Next'
		Thread.sleep(3000L);
		try {
		driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		// This line shoudl throw an exception as it is simply not clickable:
		//It can be identfified with  findElement(By.cssSelector("a[aria-label='Next']")) but
		// but the .click() part throws an exception because the button is simply not clickable at this stage
		}
		catch (Exception e)
		{
			System.out.println("PASS: The button is diabled. Hence, unclickable");
		}
	}
}
//Make another testcase where instead of ensuring that the button in not clickable, you do so by ensuring that it is disabled.
// you may want to use a diffent url for this one as choosing a locator based on inactive/disabled is not possible (again for this url here).



