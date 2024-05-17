package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
       // This is an optimized version of the previous code named: E1_AutoSug_nonOptimiz
// Crucial: An example of supreme importance
//https://rahulshettyacademy.com/dropdownsPractise/
	// In the auosuggestive drop down, type in 'ind': it follows that a number of suggestions appear. Select "India"
public class F1_AutoSug_Optimized {

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
		List <WebElement> country_listed= driver.findElements(By.className("ui-corner-all"));
		for(WebElement x: country_listed)
		{
			String country= x.getText().toLowerCase();
			if(country.contains("india"))
			{
				x.click();  // but did the click actually selected it ?!  (see the note below)
				System.out.println("PASS: " + country + " is selected");
				break;
			}
			else
			{
				continue;
			}
		}
		// what if "India" wasn't found in the list (and subsequently, nothing is clicked ?. Look below:
	    
		
 
	}

}
