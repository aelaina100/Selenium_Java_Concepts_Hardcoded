package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D_Rediff {
	
	@Test(enabled= false)
	public void siblingToSibling_xpathTest()
	{
		// At this point, ensure that you've reviewed all locators written notes.
					// A program illustrating the use of the Xpath sibling technique.
					// Task: 1- Click on the 'Practice' button.  2- Get the text of this button.
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Below: Click on the 'Practice' button
	    driver.findElement(By.xpath("//header/div/button[1]")).click(); // UI correct behaviour: it's a dummy button/ UI doesn't take you anywhere !
        //or:
        // driver.findElement(By.xpath("//header/div/a/following-sibling::button[1]")).click();  // Less reliable as you traverse through more tags
	    
	   // Below: Getting the text of this button:
	    	// The objective is to ignore case sensitivity or any space(s) introduced.
	        	// Below lines are the only optimized way of coding:
	    String expected_practice_button_text = "prActice".trim().toLowerCase();
	    String actual_practice_button_text= driver.findElement(By.xpath("//header/div/button[1]")).getText().trim().toLowerCase();
	    
	    Assert.assertEquals(actual_practice_button_text, expected_practice_button_text, "Failed: Actual text isn't the one that's expected");
	    // If assertion fails- Actual & expected values are automatically shown. Hence, the failed msg need not have reference to any variable or contain the word 'assertion'  
	}   
	   
	/*  Crucial Note: For the above example====>
	 * If you decide to start traversing from the root that is: <html lang="en"> then,
	 * use a single slash instead of a double one:-
	 * 
	 *     /html/body/header/div/button[1]
	 */
	
	@Test
	public void childToParent_xpathTest()
	{
		//Task: go to the webpage & study the Xpath locator of:   //header/div/button[1]/parent::div/parent::header/a[1]
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Note: In addition to the .click() or .sendlkeys("") or etc.etc. that are actions to be applied on the element GUI, there also exist for example ==>
		
		//.getAttribute("class")  .getAttribute("id")   .getAttribute("href") etc. etc.  in order to get the value of the attributes inside the <HTML code>  
		// OR  .getTagName() in order to get the TagName in the <HTML code>
		String href_attribute_value= driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[1]")).getAttribute("href");
		System.out.println(href_attribute_value);
		
		String tagName_value= driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[1]")).getTagName();
		System.out.println(tagName_value);
		
		String login_button_text= driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
		System.out.println(login_button_text);
		
	}
	
	
	
	@Test(enabled= false)
	public void rediffTest()
	{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		
		driver.get("https://www.rediff.com/");  
		
		//clicking on the 'Sign in' link ( I verified that it's a link as its associated HTML code has the tag name 'a'):
		//driver.findElement(By.linkText("Sign in")).click(); 
		
		//clicking on the 'Sign in' link:
		//driver.findElement(By.xpath("//a[contains(@title, 'Already a user')]")).click(); 
		//or ccs regular experession:
		driver.findElement(By.cssSelector("a[title*='Already a user']")).click();
		
		//Locating the 'Username' field and entering a text into it:
		driver.findElement(By.id("login1")).sendKeys("Aelaina100");    //punch of xpath or css or even Regular expressions, etc , etccould've been used
		
		//Locating the password field and entering a text into it:
		driver.findElement(By.id("password")).sendKeys("rwrsesfs");  //punch of xpath or css or even Regular expressions, etc , etccould've been used
		
		//Locating the 'Sign in' button and clicking on it:
		driver.findElement(By.className("signinbtn")).click();   //punch of xpath or css or even Regular expressions, etc , etccould've been used

	}

}
