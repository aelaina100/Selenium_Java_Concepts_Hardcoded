package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// https://www.aircanada.com/ca/en/aco/home.html#/home:flight
   
   //1- Ensure that 1 adult is selected by default // A very useful CONTINUOUS challenge !/ check if other ways are feasible. !
  


public class B1_creative_drop {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	driver.get("https://www.aircanada.com/ca/en/aco/home.html#/home:flight");
	//1-	
	driver.findElement(By.id("bkmgFlights_selectTravelersMainContainer")).click(); // Identified & clicks on the 'passenger(s)' dropdown.
	Thread.sleep(3000L); // without this wait, script will fail.
	
	 
	WebElement adult_Box_element= driver.findElement(By.xpath("//label[@for= 'bkmgFlights_selectTravelers_travelerCount_ADT']/ac-traveler-type/span[1]"));
	String text_of_adult_Box= adult_Box_element.getText();
	if(text_of_adult_Box.equalsIgnoreCase("Adult"))
	{
		System.out.println("PASSED: 1 adult ONLY is selected by default ");
	}
	
	else
	{
		System.out.println("Failed: 1 adult only is NOT selected by default ");
	}

	
	//2-
	int number_children_toSelect= 3;
	Actions a= new Actions(driver);
	WebElement children_add_button_element= driver.findElement(By.id("bkmgFlights_selectTravelers_addTraveler_CHD"));
	
	for(int i=0; i<number_children_toSelect; i++)
	{
		a.moveToElement(children_add_button_element).click().build().perform();
	}
	

	
	
	
	
	//Thread.sleep(5000L);
	//driver.quit();

}
}
