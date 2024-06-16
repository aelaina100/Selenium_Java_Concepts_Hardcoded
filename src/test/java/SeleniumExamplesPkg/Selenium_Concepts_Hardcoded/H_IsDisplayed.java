package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class H_IsDisplayed {

	@Test
	public void H_IsDisplayedTest() throws InterruptedException{
		//https://www.makemytrip.com/charter-flights/
		
		// TASK: Ensure that the button of 'Add Another City" ONLY & ONLY appears when ONLY the radio button of "Multicity" is selected
		
		 // Note: As of May 9th, 2024 I'd design the script differently:
		  /* 1- Click on "One way" radio button, & endure the button (Add another city) is not displayed.                    
		   * 2- Click on "Round Trip" radio button, & endure the button (Add another city) is not displayed.
		   * 3- Click on 'MultiCity" radio button, & endure the button (Add another city) IS now displayed.
		   * 4- Repeat steps 1 to 3 again.
		   */
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);     
		
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	   driver.get("https://www.makemytrip.com/flights/");
	
		Thread.sleep(8000L);
		driver.findElement(By.className("commonModal__close")).click();	  //closes the pop-up
		//Note: seems these radio buttons cant be selected even though the locators are correct. Utilize Action class or Java script commands
		
		int count =driver.findElements(By.xpath("//ul[@class= 'fswTabs latoBlack greyText']/li")).size();
		System.out.println(count);
		
		for(int i=0; i<count; i++)
		{
			String TripType= driver.findElements(By.xpath("//ul[@class= 'fswTabs latoBlack greyText']/li")).get(i).getText();
			System.out.println(TripType);
			driver.findElements(By.xpath("//ul[@class= 'fswTabs latoBlack greyText']/li/span")).get(i).click(); //modified
			
			
		}
		/*
		
			for(int i=0; i<count; i++)
			{
			String TripType= driver.findElements(By.xpath("//ul[@class= 'fswTabs latoBlack greyText']/li")).get(i).getText();  //fine
			System.out.println(TripType);  //fine
			
			driver.findElements(By.xpath("//ul[@class= 'fswTabs latoBlack greyText']/li/span")).get(i).click(); //modified  */
			}}
/* if (! TripType.equalsIgnoreCase("Municipality"))
			{
				Boolean x=  driver.findElement(By.xpath("//button[contains(text(),'ADD ANOTHER CITY')]")).isDisplayed();
						
				if (x)
				{
					System.out.println("BUG: The button of 'Add Another City' should NOt be displayed when radio:" +TripType+ " is selected");
				}
				
				else
				{
					System.out.println("PASS: The button of 'Add Another City' Is NOT displayed when radio:" +TripType+ " is selected ");
				}
				
 if  ( TripType.equalsIgnoreCase("Municipality"))
				{
					
					Boolean y=  driver.findElement(By.xpath("//button[contains(text(),'ADD ANOTHER CITY')]")).isDisplayed();
					if (y)
					{
						System.out.println("PASS: The button of 'Add Another City' Is displayed when radio:" +TripType+ " is selected");
					}
					
					else
					{
						System.out.println("FAILED: The button of 'Add Another City' Is NOT displayed when radio:" +TripType+ " is selected ");
					}
					
				} 
			} 
		}

	}

} */
