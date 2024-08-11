package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/* TC: 
 	// On: https://www.rahulshettyacademy.com/AutomationPractice/
// 1- Count the total number of links on the web page.
// 2- Count the number of links in the footerSection section only.
			
// 3- Count the  number of links in the 1st vertical section of the footerSection section.
// 4- Count the  number of links in the 2nd vertical section of the footerSection section.
// 5- Count the  number of links in the 3rd vertical section of the footerSection section.
// 6- Count the  number of links in the 4th  vertical section of the footerSection section.

// 7- In the footer section, count the number of Links sharing a bigger font.

// 8- In the footer section : Click on each link and get their respective page title storing them into an ArrayList and then printing them out.
// 9- Find out which links are 'brocken', if any (Solved in J1_BrockenLinksDetection.java )
 */

public class Added31_miniDriverprintLinksCount {

	@Test
	public void printLinksCountTest()
	{
     WebDriver driver = new ChromeDriver();
     driver.manage().deleteAllCookies();
     driver.manage().window().maximize();
     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
     driver.get("https://rahulshettyacademy.com/AutomationPractice/");
     //Note:some links look like links and some do not. A  link has anchor 'a' as the tag name regardless of how it looks like in UI.
     
     //1:
     //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("a"))); 
     // The above commented out wait method fails the test case, as the 1st link isn't, by default, visible on the web page (Look it up !)
     wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
     int numberOfLinks= driver.findElements(By.tagName("a")).size();
     System.out.println(" Number of links on the web page is: " + numberOfLinks);
     
     //2- Done by limiting the webdriver scope to the footer section only (creating a mini webdriver):
       //Below: I'll limit the scope of the webdriver from the entire page, to that section of the webpage by creating a mini driver.
	    //This mini driver will only be for that footer section. It's 100 % limited to that footerSection section ONLY.
	     //So I have 'driver' which has an excess to ALL & EVERY single element on the entire webpage ( Including the footer section off course).
	     // Mini driver 'footerSection' has access to all & each element that are inside the footerSection section ONLY.
	       //Note: Now, any of the webdrivers 'driver' & 'footerSection' can be used anytime when applicable. There is no such thing as a 'procedure' to
	          // switching between them.
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gf-BIG"))); 
     //Wait logic: Once the box element (footer section) becomes 'visible',then the links inside it become so at the same time too.
     WebElement footerSection= driver.findElement(By.id("gf-BIG"));
     List<WebElement> linksInFooter= footerSection.findElements(By.tagName("a"));
     System.out.println("Number of links in the footer section only is: " + linksInFooter.size());
     
     //3: Done by limiting the scope of the web driver (driver) to the 1st column only of the footer:
      wait.until(ExpectedConditions.visibilityOf(footerSection.findElement(By.xpath("(//td/ul)[1]")))); 
      // Using .visibilityOf(WebElement element) instead of visibilityOfElementLocated(By Locator) which can also be used instead in here.
      //Wait logic: Once the box element (footer section) becomes 'visible',then the links inside it become so at the same time too.
      WebElement firstColumnInFooter= footerSection.findElement(By.xpath("(//td/ul)[1]"));
      System.out.println(firstColumnInFooter.findElements(By.tagName("a")).size());
      
      //4: Done by limiting the scope of the web driver (driver) to the 2nd column only of the footer:
      wait.until(ExpectedConditions.visibilityOf(footerSection.findElement(By.xpath("(//td/ul)[2]"))));
      // Using .visibilityOf(WebElement element) instead of visibilityOfElementLocated(By Locator) which can also be used instead in here.
      //Wait logic: Once the box element (footer section) becomes 'visible',then the links inside it become so at the same time too.
      WebElement secondColumnInFooter= footerSection.findElement(By.xpath("(//td/ul)[2]"));
      System.out.println(secondColumnInFooter.findElements(By.tagName("a")).size());
      
      //5: Done by limiting the scope of the web driver (driver) to the 3rd column only of the footer:
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td/ul)[3]")));
      WebElement thirdColumnInFooter= footerSection.findElement(By.xpath("(//td/ul)[3]"));
      System.out.println(thirdColumnInFooter.findElements(By.tagName("a")).size());
      
      //6: Done by limiting the scope of the web driver (driver) to the 4th column only of the footer:
      wait.until(ExpectedConditions.visibilityOf(footerSection.findElement(By.xpath("(//td/ul)[4]"))));
      WebElement fourthColumnInFooter= footerSection.findElement(By.xpath("(//td/ul)[4]"));
      System.out.println(fourthColumnInFooter.findElements(By.tagName("a")).size());
      //7:
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3 a")));       //********Crucial to understand********
      //wait.until(ExpectedConditions.visibilityOfAllElements(footer.findElements(By.cssSelector("h3 a"))));  // Just as equally valid.
      System.out.println(footerSection.findElements(By.cssSelector("h3 a")).size()); 
      //Above:  'driver' whose scope is the whole page can also be used, in here, instead of the mini web driver 'footer'
      
     // 8- In the footerSection section: Click on each link and get their respective page title.
      Actions a= new Actions(driver); // passing 'driver' whose scope is the entire web page,  instead of the mimi webdriver 'footer' still works becasue 
                                       //inside the for loob, 'linksInFooter' still pints to the links of the footer section only.
                                       // but how can I pass the minidriver 'footer' as an argument ??
      
     wait.until(ExpectedConditions.visibilityOfAllElements(linksInFooter)); // will wait till all links become visible on the screen
     for(int i=0; i< linksInFooter.size(); i++){
    	 // When clicking on any of the links in the footer section, the webpage is navigated to another (This is the actual behaviour). Nevertheless,
    	  // I want for the link webpage to pop up instead. Can be done so by holding down the shift key while clicking with the mouse.
    	    // so this is the realm of the mouse & keyboard interactions that can be simulated utilizing the 'Actions' class.
    	      // So SHIFT but CTRL is neater (Find out manually)
         a.moveToElement(linksInFooter.get(i)).keyDown(Keys.CONTROL).click().build().perform();
         //driver.findElement(..).click();  
         //Above commented out line: Causes the main page to navigate to the webpage of the link. Hence, on the 2nd interation a stale element
          // exception is thrown.
     }
     
     Set<String> ids= driver.getWindowHandles(); //Automatically stores all window hande IDs(That are of type string)for all windows that are CURRENTLY/ so far open.
     Iterator <String> it= ids.iterator(); 
     it.next();  // Iterates to the parent webpage, storing inside of it the parent window handle ID.
     
     ArrayList<String> titlesArrayList= new ArrayList<String>();
     
     while(it.hasNext()){
    	 driver.switchTo().window(it.next());  // the 'it.next()' itself simply iterates and never does the switching.
    	 titlesArrayList.add(driver.getTitle());
    	 //System.out.println(driver.getTitle());  // Use this to print out to screen without the need of adding the titles into an ArrayList.
    	 //driver.close(); // can be included
     }
     System.out.println(titlesArrayList); // prints out the content of the array list with the brackets []
     System.out.println("**********************************************************************************");
     titlesArrayList.stream().forEach(s->System.out.println(s)); // to print them out without the curly brackets.
     // Now instead of printing them out, you could collect them to a list so that you could perform further aggregate operations on them such as filtering...etc (matching ? with what?)
      // or use TestNG Assertions to compare them to an expected list
     driver.quit();
     
     //9: This is done in a seperate testcase in a different .java class file (That is...)
     

}

}
