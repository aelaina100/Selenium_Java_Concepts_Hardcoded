
/*
public class Added20_synchronization { 

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		 
		 //   Implicit Wait
		 //   Explicit Wait
		 //   Fluent Wait
		 //   Thread.sleep()
		 
        
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Syntax in Selenium 4.0
		// Implicit wait should be defined immediately after the line of: WebDriver driver= new ChromeDriver()
		// as it's a global wait that applies to every single step in the method/test case. It's written one time only.
		 
  // Disadvantages: 
   
	  //Since Implicit wait, that's defined once, applies to every single step in the method/ testcase it's defined in; Then if a step requires
	  // more synchronization time than the other steps (Ex: 5 seconds), then the implicit wait should specify 5 seconds max.
	   // This denotes that a potential bug could be overlooked for a step(s) that requires 
	    //a lesser synchronization time (ex: 1.5 seconds max according to requirement) = script is concealing a performance issue in app.
	      // In this case, an explicit wait is to be used instead [An explicit wait is only to be used in general anyway in real-time projects]
	     
  // Advantages:  Code is more readable & looks more optimized (less lines of code) (That's all !)
    
   //Seperate note: A good performance has a synchronization of no more than 5 seconds for each step.
   //Seperate note: It's not suggested to give more than 10 seconds for an implicit wait. And again, good app performance means 
    // an implicit wait of no more than 5 seconds for each step.
    
    
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2)); // Syntax in Selenium 4.0
	wait.until(ExpectedConditions.              );
			
/* 1- The explicit wait step is compiled and executed first, and then the line of code below it, that it targets, is executed after.
 *    this is totally different from implicit wait, where the actual step of identifying an element is executed where if controller
 *    can not identify such element (because for example the page is still loading or the element isn't loaded yet on the webpage, etc.)
 *    then, instead of throwing an exception it will wait for the specified time set by the implicit wait (If implicit wait is definded
 *    to start with).
 *    
 * 
 * 2- Write the actual line of code and the 2nd step is to write its explicit synchronization above it.
 *    Example:  first write     driver.findElement(By....).click();   and then       wait.until(ExpectedConditions...); above it.
 * 
 * 3- presenceOfElementLocated(By locator)      presence in the list of <HTML  code>'s  regardless whether it's visible in the UI or not.
 *    visibilityOfElementLocated(By locator)    visible in the UI
 *    invisibilityOfElementLocated(By locator)  invisible in the UI
 *    elementToBeClickable             checks if it's visible first. Then once it is, checks if it's clickable.
 *                                     ;Don't throw an exception until it's clickable.
 *                                     
 *    TitleContains(String title):           It will wait until the title of the browser is changed to contain a string.
 *    titleIs(String title)
 *    urlMatches(String regex)
 *    urlToBe(String url)
 *    urlContains(String fraction)
 *    
 *   CRUCIAL:   wait.until(ExpectedConditions.alertIsPresent());  // Even if it is a Java alert. It is for ALL types of alerts.
 * 
 * 	//explore '.attribute...' explicit methods/ very important plus can you do wait with partial text ?
 
 Advantages of Explicit wait:
           - Each wait is applied at a targeted element so that no performance issues are concealed as the case in implicit wait.
           
 Disadvantages of Explicit wait:
          - Code becomes less optimized (More lines of code to write) in comparison with implicit wait.         
     
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Thread.sleep(3000L);  // Belongs to Java; Not Selenium web driver.
		                        // it freezes the compiler/controller for the entire duration specified.
		                        // Never recommnded for use under any circumstance with the exception of some capta verifications (Expand on that)
		                         
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*
  * Fluent Wait
  * is just another type of Explicit Wait.
  * 
  * Fluent wait monitors the presence of an element within regular intervals of time under a specified amount of time.
  * Just an in Implicit wait, once the element is found then there is no need to wait for the entire specified time.
  * 
  * Example:  FluentWait =10 seconds, Polling 2 seconds.
  * meaning, it will ONLY check once every 2 seconds whether the element is found or not. Whole process lasts for 10 seconds.
  * before throwing ElementNotFoundException.
  * 
  * [it checks 6 times:  On the 0 second, 2nd, 4th, 6th, 8th, & 10th second]
  * 
  * For the vast majority of the time, Explicit wait (As opposed to FluentWait) is used.
  * An example, where FluentWait is needed=====>
  * 
  * You enter credit card information and click on 'Submit':
  * where submit button displays a loading icon inside it for a few seconds
  * then, a message appears for 3 seconds "Your card is accepted"
  * then, another message appears instead, for 7 seconds, "Your order is being processed"
  * then, you're navigated to a different page.
  * 
  * Where both messages have the same <HTML  > properties 
  * 
  * This problem can be solved with either: Explicit Wait of Fluent Wait
  * 
  *  With explicit wait:===>
  * - This automation scenario can be achieved with Explicit wait when using one of the text explicit wait methods.
  * 
  *  With fluent wait:===>
  * 1-  1st message: can be automated with Explicit wait.
  * 2-  2nd message: can be automated with FluentWait   
  * ==================================================================================================
  * 
  * FluentWait code: (https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html)
  * 
  * // Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.
    /*
     
     
 
   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(30L))
       .pollingEvery(Duration.ofSeconds(3L))
       .ignoring(NoSuchElementException.class);  //In 30 sec, if element not found, don't throw NoSuchElementException.
       
 // Now: What element we are applying the timeout (30 seconds) and the polling (3 seconds) on ? ===>
  
   WebElement foo = wait.until(new Function<WebDriver, WebElement>() { 
   
     public WebElement apply(WebDriver driver) {    // wait until this method returns an element.
			       return driver.findElement(By.id("finish")); // when the element is found, it's returned.
			       //when it's not found, null is returned as opposed to the expected return type of
			       //WebElement. So instead of throwing an exception, it will poll for the next 5 seconds
			       // (Looking for the element again for one time only in the next 5 seconds) and
			       //if the element not found, then it will poll again for the 3rd time and so on
			       // until the element is actually found or NoSuchElementException error is thrown.
      
       return driver.findElement(By.id("foo"));
     }
   });
   
  * 
  * 
  * INTERVIEW Additional Notes  ====> FLuentWait comes up alot in interview questions !
  * 
  * Refresher note:  WebDriver driver= new ChromeDriver();     // Where 'ChromeDriver' is a class implementing the WebDriver interface
  * 
  *   WebDriverWait (Explicit Wait)   &   FluentWait       are 2 seperate classes that implement the SAME Wait Inteface.
  *   This ONE SAME  wait interface has the syntax of 'Wait' in FluentWait & syntax of 'WebDriverWait'in explicit wait as evident by the lines below:
  *   
  *   -Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)   // where one has to pass 'driver' an an argument. But that's not enough,
  *                                                               // ,as one has to specify WebDriver as the type of driver.
  *   
  *   -WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
  *   
  *   
  *           
  *             
  * In conclusion: FluentWait & WebDriverWait are 2 different classes implementing one exact common wait interface 
  *                FluentWait & ExplicitWait are not 2 different worlds
  * 
  * Plus explain the different working mechanisms of Implicit Vs Explicit Vs Fluent Wait.
  * They will ask you where to implement FluentWait & to type it out in IDE.
  * 
  * Refer to the source webpage: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Wait.html
  * 
  */
///////////////////////// Below: Section AAA: taken from chat GPT/////////////////////////////////
// original question in chat GPT:  best expected conditions method for a list of web elements ?
/*
 * 

WebDriverWait wait = new WebDriverWait(driver, 10);
List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("your-css-selector")));

------------
WebDriverWait wait = new WebDriverWait(driver, 10);
List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("your-css-selector")));

for (WebElement element : elements) {
    wait.until(ExpectedConditions.visibilityOf(element));
}
----------
WebDriverWait wait = new WebDriverWait(driver, 10);
List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("your-css-selector")));

for (WebElement element : elements) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
}
------------------
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> allElementsVisible(final List<WebElement> elements) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                for (WebElement element : elements) {
                    if (!element.isDisplayed()) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}

WebDriverWait wait = new WebDriverWait(driver, 10);
List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("your-css-selector")));
wait.until(CustomConditions.allElementsVisible(elements));

--------------------------------------------------------------

 */

