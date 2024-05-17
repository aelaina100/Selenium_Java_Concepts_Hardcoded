package HardCoded_Examples.Selenium_Concepts_HighLevel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//1- Select "one-way" / a seperate testcase to ensure it's already selected by default
//2- From: 'Hyderabad", To: "Chenai"   
//3- Departure date: Select the highlited one / a seperate testcase to select the day after highlighted one AND to iterate throughout the days.
//4- Return Date: Ensure it is disabled.
//5- Passenger: 2 children
//6- Currency: USD
//7- Radio button: 'Students'
//8- Click on 'Search Flight'.

public class Y_trav_drop_disabElem {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.spicejet.com/");
		
		//1-
		driver.findElement(By.xpath("//div[@data-testid= 'one-way-radio-button']")).click();
		//driver.findElement(By.xpath("//div[@data-testid= 'round-trip-radio-button']")).click(); // This selects 'round trip' instead
		
		//2-
		driver.findElement(By.xpath("//div[text()= 'From']/following-sibling::div[1]")).click();//clicks on 'From' section, so that dropdown opens up.
		driver.findElement(By.xpath("//div[text()='Hyderabad']")).click(); //Selects 'Hyderabad'. resulting in 2nd drop down automatically openning up.
		
		driver.findElement(By.xpath("//div[text()='Chennai']")).click(); //Selects 'Hyderabad'. resulting in 'Departure date' calender opens up.
		
		//3-
		driver.findElement(By.cssSelector("div[data-testid*='undefined-month'] div[class*='r-jwli3a']")).click(); 
		// CRUCIAL NOTE: 'SO far', you can NEVER locate the default element that is '25' without this above SPECIFIC cssSelector,
		  // because the defaulted element (number) will have additional characters Added to the value of the class attribute
		    // in its associated <HTML  code>..think about it (in this SPECIFIC case) where NO attribute is unique EVER S
		
		//As of today, what is highlighted is 25. So, '25' should be selected.
		  // the highlighted day, might be already selected. So to prove that the above selector is correct,
		
		 
		//4- Once again: assuming that 'one-way' radio button is selected
		String ReturnDate_EnableOrDisable= driver.findElement(By.xpath("//div[text()= 'Select Date']")).getAttribute("style");
		System.out.println(ReturnDate_EnableOrDisable);
		if (ReturnDate_EnableOrDisable.contains("opacity: 0.5"))
		{
			System.out.println(" DISABLED 'Return Date'  "); // Assuming one-way is selected
		}
		
		else
		{
			System.out.println(" Enabled 'Retunrn Date' ");  // assuming one-way is selected
		}
		
		//5- 
		driver.findElement(By.xpath("//div[text()= 'Passengers']")).click(); // opens up the 'passenger' drop down
		
		int numberChildren =2; 
		for (int i=0; i< numberChildren; i++)
		{
		driver.findElement(By.xpath("//div[@data-testid= 'Children-testID-plus-one-cta']")).click();
		}
		
		//6-
		
		driver.findElement(By.xpath("//div[text()= 'Currency']")).click(); //opens up the currency dropdown
		driver.findElement(By.xpath("//div[text()= 'USD']")).click();
		
		
		//7
		driver.findElement(By.xpath("//div[text()= 'Students']")).click();
		
		int number_Frames= driver.findElements(By.tagName("iframe")).size();
		System.out.println(" Number of frames on the webpages: " + number_Frames); // returns 2 but we happen not to automate anything inside a frame
		//8-
		
		//driver.findElement(By.xpath("//div[text()= 'Search Flight']")).click(); 
		 // above line: Not going to work
		 // org.openqa.selenium.ElementClickInterceptedException = element not clickable
		  
		driver.findElement(By.xpath("//div[text()= 'Search Flight']/parent :: div")).click(); 
		

	}

	
	}

 
