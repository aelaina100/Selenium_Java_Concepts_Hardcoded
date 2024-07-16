
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
 * 3- presenceOfElementLocated(By locator)   is the same as   visibilityOfElementLocated(By locator)   according to instructor.
 * 4- TitleContains(String title):           It will wait until the title of the browser is changed to contain a string.
 * 5- titleIs(String title)
 * 6- urlMatches(String regex)
 * 7- urlToBe(String url)
 * 8- urlContains(String fraction)
 
 Advantages of Explicit wait:
           - Each wait is applied at a targeted element so that no performance issues are concealed as the case in implicit wait.
           
 Disadvantages of Explicit wait:
          - Code becomes less optimized (More lines of code to write) in comparison with implicit wait.         
     
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Thread.sleep(3000L);  // Belongs to Java; Not Selenium web driver.
		
		
		            
	
	

	
} }   */
