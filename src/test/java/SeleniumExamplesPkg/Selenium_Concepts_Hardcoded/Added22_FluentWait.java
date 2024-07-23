package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Added22_FluentWait {
	
	/* isDisplayed() returns one of 3 potential outcomes.
	 * 
	 *   1- true:          If the element is displayed on the webpage.
	 *   
	 *   2- false:         If the element is not displayed on the webpage.
	 *   
	 *                In the above 2 cases, the element has an associated <HTML  code> is present in the list.
	 *   
	 *   3- An exception:  The claimed element has no associated <HTML code> to begin with !
	 *   
	 * 
	 */
	
	@Test(enabled=false)  // Crucial to grasp this test case first before going over the next ones below it.
	
	public void gettingTextTest_plus_isDisplayed() throws InterruptedException  // TC will resolve any confusion !
	{
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	    Thread.sleep(2000L);
	    
		System.out.println(driver.findElement(By.id("finish")).isDisplayed()); 
		// returns 'false' as locator is to identify the box element that happens to hold the text of "Hello World!". That box isn't yet displayed onto the screen/UI.
		
		driver.findElement(By.xpath("//div[@id= 'start']/button")).click(); // Clicking on 'Start' button so that loading sign appears.
		System.out.println(driver.findElement(By.id("finish")).isDisplayed());  //Executes while loading logo is in affect.
		// return 'false' as locator is to identify the box element that happens to hold the text of "Hello World!".. That box isn't yet displayed onto the screen/UI.
		
		Thread.sleep(5000L);    // Wait as the loading sign appears.
		System.out.println(driver.findElement(By.id("finish")).isDisplayed()); // executes while 'Hello World!" is already displayed on UI
		// return 'true' as locator is to identify the box element that's now displayed in the UI (can see it when you inspect) and which happens
		   //to hold the text of "Hello World!".
		
		// Now, get the displayed text "Hello World!" and print it out to the screen
		  // The displayed HTML code is as follows:
		/*
		 * <div id="finish" style>         //parent
		 *   <h4>Hello World!</h4>         //child  (Just as a valid of an HTML code as its parent or any other HTML code for this matter)
		 * </div>
		 * 
		 *NOTE: After examining:
		 * : All the above HTML codes (in this ex) ALWAYS exist (B4 clicking on 'start', while loading, & after displaying the text).
		 * 
		 * Now:   driver.findElement(By.id('finish')).getText();                          // gets the text of "Hello World!"
		 * and:   driver.findElement(By.xpath("//div[@id= 'finish']/h4")).getText());    // Also gets the text of "Hello World!"
		 * 
		 * .However; use the id locator as it's more reliable.
		 * 
		 */
		System.out.println("*****************************************************************");
		System.out.println(driver.findElement(By.id("finish")).getText());   // The only reliable locator.
		System.out.println(driver.findElement(By.xpath("//div[@id= 'finish']/h4")).getText());  //bad locator: for illustrative purposes only.
		System.out.println(driver.findElement(By.xpath("(//h4)[2]")).getText());                //bad locator: for illustrative purposes only.
		System.out.println("*****************************************************************");
		
		//Seperate: CRUCIAL: (To reach a higher understading in automation)
		// Comment out the thread.sleep();
		// This means that, I will be trying to trying to get the text (3 times) while the loading logo is displayed in the UI
		// The outcome is UNIVERSAL (Applies to any scenario or UI):==> You will get a white space and NOT the 'Hello world!" text.
	    //In order get/display "Hello world!" text, it should be visible in the UI AS WELL
		// In other words, getText() denotes 'get the displayed/ visible text in the UI"
	}
	
	/* TC: "https://the-internet.herokuapp.com/", 
	 * Navigate to: Dynamic Loading   >>   Example1: Element on Page that is hidden   >> Click on 'Start' >> As you can see: Loading logo
	 *                                     appears >> Now, it is replaced with a text "Hello World".
	 *                                     
	 * Now,  Grab the text and display it onto the screen
	 * 1st used Explicit wait
	 * 2nd, use FluentWEait.
	 * 
	*/
	
	@Test
	public void explicitWaitTest()
	{
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		// Even though driver.get() includes waiting/ synchronization in the background for all the elements on the webpage to fully load,
		//I still included a wait for the below line (Step of clicking on the 'Start' button).
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id= 'start']/button")));
		driver.findElement(By.xpath("//div[@id= 'start']/button")).click(); // Clicking on 'Start' button so that loading sign appears.
		
	   // Below: 3 methods of implementing Explicit Wait. Study them all.
		
		//wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[style= 'display:none']")))); // not working !
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		System.out.println(driver.findElement(By.id("finish")).getText());		
	}
	
	@Test(enabled=false)
	public void fluentWaitTest1()
	{
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		// Even though driver.get() includes waiting/ synchronization in the background for all the elements on the webpage to fully load,
		//I still included a wait for the below line (Step of clicking on the 'Start' button).
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id= 'start']/button")));
		driver.findElement(By.xpath("//div[@id= 'start']/button")).click(); // Clicking on 'Start' button so that loading sign appears.
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30L))
			.pollingEvery(Duration.ofSeconds(3L))
		    .ignoring(NoSuchElementException.class); //In 30 sec, if element not found, don't throw NoSuchElementException.
			// Now: What element we are applying the timeout (30 seconds) and the polling (5 seconds) on ? ===>
			  
		         fluentWait.until(new Function<WebDriver, WebElement>() { 
			     public WebElement apply(WebDriver driver) {   
			     //return driver.findElement(By.cssSelector("div.example div[style= 'display: none;']:nth-of-type(1)"));  
			     //attribute  style= 'display: none;  appears when text "Hello World!" is displayed on the UI/Screen.
			     // Nevertheless, the immediate above line contains un undesirable locator.
			     //This line should be replaced with if .isDisplayed() line of code  ==>
			    	 
			     if(driver.findElement(By.id("finish")).isDisplayed())  // = if(true) // If the box element (Happens to hold the text of 'Hello World!")
			    	                                                     //, is now displayed in the UI (Can be seen by inspecting)
			     {
			    	return driver.findElement(By.id("finish"));
			     }
			     else
				 return null;
			     }
			   });
		System.out.println(driver.findElement(By.id("finish")).getText());		
	}
	
	
	
	
	@Test(enabled= false)  // run the code and predict what's bad about it ! (same testcase: print out the 'Hello World!" text 
	public void badExample_fluentWaitTest1() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		// Even though driver.get() includes waiting/ synchronization in the background for all the elements on the webpage to fully load,
		//I still included a wait for the below line (Step of clicking on the 'Start' button).
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id= 'start']/button")));
		driver.findElement(By.xpath("//div[@id= 'start']/button")).click(); // Clicking on 'Start' button so that loading sign appears.
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30L))
			.pollingEvery(Duration.ofSeconds(5L))
		    .ignoring(NoSuchElementException.class); 
			       
			 fluentWait.until(new Function<WebDriver, WebElement>() { 
			   
			     public WebElement apply(WebDriver driver) {   // wait until this method returns an element.
			       return driver.findElement(By.id("finish")); // when the element is found, it's returned.
			     }
			   });	 
			   System.out.println(driver.findElement(By.id("finish")).getText());	
		//Solution: The bad thing about it is that locator of the box containing the text of "Hello World!"
		  //(id= "finish") will ALWAYS be present in the list of <HTML > codes:
		   // : before clicking the 'Start' button, after clicking on it while the page is loading, & after "Hello World!" is displayed.
		    // it follows that there will be no wait as the box element is already there/readily identifiable so .getText() 
		     //in this specific case is applied while the logo is loading before the 'Hello world!" text appears, producing a white space.
			   
			   // Now Crucial to comprehend this:
			    //1- Before clicking on 'Start' button"
			      //driver.findElement(By
	 }}
