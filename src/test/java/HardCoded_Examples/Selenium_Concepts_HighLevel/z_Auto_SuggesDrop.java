package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

                                  // Not resolved
//When typing characters into google, a suggestive list appears. Choose one of choice:
  // Type is " The theory of " and select "The theory of relativity"
public class z_Auto_SuggesDrop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.google.ca/");
		
		
		Actions a= new Actions(driver);
		WebElement searchField_element= driver.findElement(By.cssSelector("input[type='text']"));
		String text= "The theory of";
		a.moveToElement(searchField_element).click().sendKeys(text).sendKeys(Keys.ARROW_DOWN).build().perform();
		
		

	}

}
