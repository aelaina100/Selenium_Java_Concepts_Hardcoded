package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Added21_synchroAssig {
	/* Navigate to: https://rahulshettyacademy.com/loginpagePractise/
	 * 
	 * 
	 * 
	 */
	
	@Test(enabled=false)   //CRUCIAL: (Don't change any of the locators)
	        //Examine it, investigating it's behaviour. It will take your automation skills to the next level.
	public void synchroAssigTest_troubleshoot() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3000));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle()); // output: LoginPage Practise | Rahul Shetty Academy
		
		String userName= "rahulshettyacademy";
		String password= "learning";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(userName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value= 'user']/following-sibling::span")));
		driver.findElement(By.xpath("//input[@value= 'user']/following-sibling::span")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
		driver.findElement(By.id("terms")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signInBtn")));
		driver.findElement(By.id("signInBtn")).click();
		
		// Below: landing on a new page.  Title of the page:  ProtoCommerce
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-info")));
		// seperate: is waiting for an element to be visible, render it clickable ? (I don't think so).
		List<WebElement> elements= driver.findElements(By.cssSelector(".btn.btn-info"));
		for(int i=0; i<elements.size(); i++)
		{
			elements.get(i).click();

		}
		
	}
	@Test(enabled= false)
	public void synchroAssigTest() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String userName= "rahulshettyacademy";
		String password= "learning";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(userName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value= 'user']/following-sibling::span")));
		driver.findElement(By.xpath("//input[@value= 'user']/following-sibling::span")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
		driver.findElement(By.id("terms")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("signInBtn")));
		driver.findElement(By.id("signInBtn")).click();
		
		
		// Below: landing on a new page.  Title of the page:  ProtoCommerce
		 //Assuming when the first add to cart button becomes clickable, then the rest will be at the same time too.
		  // would much rather use .elementSSSToBeClickable  .But, such an explicit method isn't available.
		   // Now, I could also use visibilityofAllElements.. But does visibility necessarily imply that
		   // the buttons are clickable/enabled ??  I don't think so. Hence, refrain from using it here.
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-info")));
		List<WebElement> elements= driver.findElements(By.cssSelector("button.btn.btn-info"));
		for(int i=0; i<elements.size(); i++)
		{
			elements.get(i).click();

		}
		
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Checkout"))); // clicking on the checkout buttonm
		 driver.findElement(By.partialLinkText("Checkout")).click();
		
		// Below:Another wait attempt for clicking on the checkout button that has the text of "Checkout(#)" where '#' = int
		 
		 /*
		  String checkoutButtonText= "Checkout " +"( " + elements.size() + " )(current)";
		  System.out.println(checkoutButtonText);     //debugging purposes
		 
	       wait.until(ExpectedConditions.textToBe(By.partialLinkText("Checkout"),checkoutButtonText));  
		  driver.findElement(By.partialLinkText("Checkout")).click();                                     
		 
		 //Above wait not working because of the text format in HTML as evident in the below line=================>
		 //System.out.println(driver.findElement(By.partialLinkText("Checkout")).getText()); // yields an interesting output.  
		 
		 */
		 
		// One may ask, why not use the elementToBeClickable explicit method instead ?
		  //well, if you examine the lines above it, I used .elementToBeClickable for the add buttons. I assume that once these
		    // add buttons become clickable and are clicked on afterwards, then the checkout button should be already clickable at that point.
		     // Plus, it's vital to explore other explicit wait methods in automation.
		 
		 
		 // Crucial:  System.out.println(driver.findElement(By.partialLinkText("Checkout")).getText());  yields an interesting output
	}
 @Test(enabled= true)
 public void titleFetching()   // use page titles for explicit waits.
 {
	 WebDriver driver= new ChromeDriver();
	 driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	 System.out.println(driver.getTitle()); // output: LoginPage Practise | Rahul Shetty Academy
	 
     driver.get("https://rahulshettyacademy.com/angularpractice/shop");
     System.out.println(driver.getTitle());  // output: ProtoCommerce
		
 }
 
 
}
