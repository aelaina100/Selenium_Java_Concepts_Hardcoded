package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Crucial: An example of supreme importance. it is non-optimized. The next example is.
//https://rahulshettyacademy.com/dropdownsPractise/
	// In the auosuggestive drop down, type in 'ind': it follows that a number of suggestions appear. Select "India"
public class E1_AutoSug_nonOptimiz {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		String sub_keyword= "ind";
		driver.findElement(By.id("autosuggest")).sendKeys(sub_keyword); // Identifies the auto-suggestive drop down, and inputs a text.
		Thread.sleep(2000L);
		// Below: I'm selecting "India":
		List<WebElement> elements= driver.findElements(By.className("ui-corner-all"));
		int count= elements.size();
		for(int i=0; i<count; i++)
		{
			String country= elements.get(i).getText();
			if(country.equalsIgnoreCase("india"))
			{
				elements.get(i).click();  // but did the click actually selected it ?!  (see the note below)
				System.out.println("PASS: " + country + " is selected");
				break;
			}
			
			else
			{
				continue;
			}
		 // what if "India" wasn't found in the list (and subsequently, nothing is clicked ?. Look below:
			 //This entire code is non optimized. The next example is.
		}}}
		
		
		/* Note: below is the unrefined first attempt code
		 * String sub_keyword= "ind";
		driver.findElement(By.id("autosuggest")).sendKeys(sub_keyword); // Identifies the auto-suggestive drop down, and inputs a text.
		Thread.sleep(2000L);
		// Below: I'm selecting "India":
		int count= driver.findElements(By.className("ui-corner-all")).size();
		for(int i=0; i<count; i++)
		{
			String country= driver.findElements(By.className("ui-corner-all")).get(i).getText();
			if(country.equalsIgnoreCase("india"))
			{
				driver.findElements(By.className("ui-corner-all")).get(i).click();  // but did the click actually selected it ?!  (see the note below)
				System.out.println("PASS: " + country + " is selected");
				break;
			}
			
			else
			{
				continue;
			}
		}
		// what if "India" wasn't found in the list (and subsequently, nothing is clicked ?. Look below:
	    //This entire code is non optimized
		*/
		 
		
       

