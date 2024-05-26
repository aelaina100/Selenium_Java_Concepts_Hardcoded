package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//https://www.britishairways.com/travel/home/public/en_ca/
	//Ensure that no more that 8 children can be selected.

// FAILING 
public class C1_creative_drop {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Third_Party_Browsers\\geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.britishairways.com/travel/home/public/en_ca/");
		
		Thread.sleep(5000L);
		driver.findElement(By.id("ensCloseBanner")).click();
		String correct_max_num_child= "8";
		
		Actions a= new Actions(driver);
		WebElement plus_button_child= findElement(By.cssSelector("[aria-label*= 'increase number of Children']"));
	   	do
	    {
		a.moveToElement(plus_button_child).click().build().perform(); //Identifies & clicks on the button for 'Children'.
		String class_attribute= driver.findElement(By.cssSelector("[aria-label*= 'increase number of Children']")).getAttribute("class");
		if(class_attribute.contains("disabled"))
		{
			String displayed_max_child= driver.findElement(By.cssSelector("[aria-label*= 'increase number of Children']")).getText();
			if( displayed_max_child.equalsIgnoreCase(correct_max_num_child))
			{
			System.out.println("Passed: " + displayed_max_child + " is the MAX number of children that can be selected" );
			break;
			}
			else
			{
			System.out.println("Failed: "+ displayed_max_child+ " is the MAX displayed # of child. selectable instead of " + correct_max_num_child);
			break;
			}
		}  }
		while(true);
	}

	private static WebElement findElement(By cssSelector) {
		// TODO Auto-generated method stub
		return null;
	}
}

/*  Original code without actions class. Didn't work as page wasn't loading correctly
 * System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Third_Party_Browsers\\geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.britishairways.com/travel/home/public/en_ca/");
		
		Thread.sleep(5000L);
		driver.findElement(By.id("ensCloseBanner")).click();
		String correct_max_num_child= "8";
	   	do
	    {
		driver.findElement(By.cssSelector("[aria-label*= 'increase number of Children']")).click(); //Identifies & clicks on the button for 'Children'.
		String class_attribute= driver.findElement(By.cssSelector("[aria-label*= 'increase number of Children']")).getAttribute("class");
		if(class_attribute.contains("disabled"))
		{
			String displayed_max_child= driver.findElement(By.cssSelector("[aria-label*= 'increase number of Children']")).getText();
			if( displayed_max_child.equalsIgnoreCase(correct_max_num_child))
			{
			System.out.println("Passed: " + displayed_max_child + " is the MAX number of children that can be selected" );
			break;
			}
			else
			{
			System.out.println("Failed: "+ displayed_max_child+ " is the MAX displayed # of child. selectable instead of " + correct_max_num_child);
			break;
			}
		}  }
		while(true); */
