package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
// https://www.aircanada.com/ca/en/aco/home.html#/home:flight
   //1- In the 'Passenger' dropdown, ensure that choosing the maximum number of 'Adults' is '9' 
import org.testng.Assert;
import org.testng.annotations.Test;

                                       


public class A1_creative_Drop {
	
@Test 
public void A1_creative_Drop1()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	driver.get("https://www.aircanada.com/ca/en/aco/home.html#/home:flight");
		
	driver.findElement(By.id("bkmgFlights_selectTravelersMainContainer")).click(); // Identified & clicks on the 'passenger(s)' dropdown.
	
	// The idea is, 1 adult is selected by default. Now, when you click for the 9th time, the + sign becomes disabled (Expedted behaviour)
    for (int i=1; i<=10; i++)
	{
		driver.findElement(By.id("bkmgFlights_selectTravelers_addTraveler_ADT")).click();
	}  
	
    String value_of_attribute_aria_disabled= driver.findElement(By.id("bkmgFlights_selectTravelers_addTraveler_ADT")).getAttribute("aria-disabled");
    String value_of_attribute_max= driver.findElement(By.id("bkmgFlights_selectTravelers_travelerCount_ADT")).getAttribute("max");
    
  
    if(value_of_attribute_aria_disabled.contains("true") && value_of_attribute_max.equals("9") ) // The idea is, + can be disabled at 5,6,0r 7 adults.
    {
    	System.out.println(" Number of maximum adults that can be selected is: " + value_of_attribute_max );
    }

    else
    {
    	Assert.assertTrue(false, "The maximum number of adults selectable is not 9 ");
    }
}

		
	
	
	
// Another CRUCIAL way of doing it:	VERY IMPORTANT BELOW
    
    @Test(enabled=false)
    public void A1_creative_Drop2()
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
    	WebDriver driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
    	driver.get("https://www.aircanada.com/ca/en/aco/home.html#/home:flight");
    		
    	driver.findElement(By.id("bkmgFlights_selectTravelersMainContainer")).click(); // Identified & clicks on the 'passenger(s)' dropdown.
	
int numberOfClicks=0;

Actions a= new Actions(driver);
WebElement Passenger_adult_PlusSign=  driver.findElement(By.xpath("//button[@id= 'bkmgFlights_selectTravelers_addTraveler_ADT']"));

while(driver.findElement(By.id("bkmgFlights_selectTravelers_addTraveler_ADT")).getAttribute("aria-disabled").contains("false"))
{
	a.moveToElement(Passenger_adult_PlusSign).click().build().perform(); // Not using Actions class, deems locator unstable for identfification.
	numberOfClicks= numberOfClicks+1;
}
System.out.println("Number of actual max clicks performed on webpage as of now is: " +numberOfClicks);   
if(numberOfClicks==8)
{
int Max_number_adults= numberOfClicks + 1;
System.out.println("PASSED: Number of maximum clicks is: " + numberOfClicks + " (Meaning: Maximum number of adults is: "+ Max_number_adults +")");
}	
else
{
int Max_number_adults= numberOfClicks+1;
System.out.println("FAILED: Number of Maximum clicks is: " + numberOfClicks + " (Meaning: Maximum number of adults is: "+ Max_number_adults +")");
}
		
    }
}
		
		
		//1- earlier code/ first attempt:
		
	  /* int counter= 0;
	   WebElement Adult_positive_sign= driver.findElement(By.id("bkmgFlights_selectTravelers_addTraveler_ADT"));
	   while(Adult_positive_sign.getAttribute("aria-disabled").contains("false"))
	   {
		   driver.findElement(By.id("bkmgFlights_selectTravelers_addTraveler_ADT")).click();
		   counter= counter +1;
		   System.out.println(counter);   
	   }
	 //.getText();// Will NOT work. It will Throw an error as number isn't available anywhere in HTML.
	   int max_number_adults_displayed= counter +1;
	   if(counter==8) // why '8' ? this depends on studying the behaviour of UI for this specific testcase.
	   {
		   System.out.println("PASSED: " +max_number_adults_displayed+ " is the maximum number of 'Adults' that can be selected"); 
		   //Crucial:   counter+1   inside line will add up. Instead, '1' will be attached to 'counter'
	   }
	   else
	   {
		   System.out.println("FAILED: " + max_number_adults_displayed+1 + " is the maximum number of 'Adults' shown as opposed to 9" );
	   }
//.getText();// Will NOT work. It will Throw an error as number isn't available anywhere in HTML.
	  
	    */
		
//Thread.sleep(7000L);
//driver.quit();
	

	
