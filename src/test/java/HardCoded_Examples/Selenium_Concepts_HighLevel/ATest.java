package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ATest {
	//Below method(Testcase) is demonstrational (To review/ be familiar with webdriver methods)
   @Test (enabled=false)
   public void A_demonstrational() throws InterruptedException
	{
		// The below  lines invoke the browser
	   
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);     
		
	   
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));     
		
		/*
	   System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
	   EdgeOptions options= new EdgeOptions();
	   options.addArguments("--remote-allow-origins=*"); 
	   WebDriver driver = new EdgeDriver(options);  */
		 
		
		//The below line navigates to 'Google' web site
		driver.get("https://www.google.ca/");
		
		// The below line gets the title of the current web page and prints it out to console
		System.out.println(driver.getTitle());
		
		// gets the current URL and prints it out to screen
		System.out.println(driver.getCurrentUrl());
		
		//navigates to the Yahoo web page
		driver.get("https://ca.yahoo.com/");
		
		// gets the title of the current web page and prints it out on the screen
		System.out.println(driver.getTitle());
		
		//checks the current URL and prints it out on the screen
		System.out.println(driver.getCurrentUrl());
		
		//The below line makes the web page navigate from "Yahoo" and back to "Google"
		driver.navigate().back();
		
		Thread.sleep(5000);   //Figured after running that it is needed as navigating back to the google webpage is slower than the execution of the last line below
		
		//checks the current URL and prints it out on the screen
	    System.out.println(driver.getCurrentUrl());
	    
	    // Last line is to print out the page source (Manually it is when you right-click and then click on "View Page Source"
	    //System.out.println(driver.getPageSource());
	    System.out.println(" Driver going to sleep for few seconds");
	    Thread.sleep(5000);
	  
	    driver.close();     //ONLY closes the original webpage that was first launched.
	    //driver.quit(); //would work too, just fine as it's closes ALL web pageS that are open	
	} 
	// Below 2nd  method/2nd testcase is practical
   @Test(enabled=false)
   public void A_practical() throws InterruptedException
   {
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
         String url= "https://www.google.ca/";
	     driver.get(url);
		 Thread.sleep(5000L);
	     String current_url=driver.getCurrentUrl();
		 // One of the most common scenarios when a web page is hacked, is that the original requested url
		 //takes you to an entirely different one as hacker intentionally maintains same page title
		Assert.assertEquals(url, current_url, " Throwing exception/Compiler error-Hacked !, Original requested url navigates user to another one");
		System.out.println("**Success: Current url is the original requested one");  // In real-time it is replaced by 'logs'
		driver.close();
		
   }
   
   @Test
   public void basics()
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	   
	   driver.get("https://www.google.ca/");
	   String page_source= driver.getPageSource();
	   System.out.println(page_source); // Just to view in console..
	   
	   String keyword_wanted= "iframe";
	   Boolean search= page_source.contains(keyword_wanted);  // returns Boolean- Does it contain it or not ?
	   Assert.assertTrue(search, "Exception Message: Page source does NOT contain keyword:  "+ keyword_wanted +".");
	   System.out.println("PASS: Page source contains the keyword: "+  keyword_wanted); // to be replaced with logs().
	   
	   	  
		
   }
	/* Seperate note: (copied from notes):-
	 * Verifying the presence of GUI items, in brower, is done by: 
	 * 
       1- Right-clicking on the page    2- Clicking on "View page source"
       where     Ctrl+F will help you locate the name of an item or some data.
       
   //Also, there are some websites, where right-clicking is disabled (To subsequently view the page source)
   // so even if it's manually disabled, you can still view it in Selenium
    // driver.getPageSource()       // Could it help us with 'frames'- that's another question.
                                           */
}
