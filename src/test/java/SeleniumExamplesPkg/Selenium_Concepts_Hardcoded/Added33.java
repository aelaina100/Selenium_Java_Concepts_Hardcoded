package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/* TC#1
 * 1- Navigate to: https://rahulshettyacademy.com/seleniumPractise/#/offers.
 * 2- Click on the calendar of 'Delivery Date'.
 * 3- In the open calendar, click on the current month-year text situated in the top middle of the calendar (Notice that the 12 months appear. Don't select any month).
 * 4- Click on the current year only text situated in the top middle of the calendar (Notice that a list of years appear).
 * 5- Select the wanted year (If it's not shown, then select the navigation to increase or the navigation to decrease to eventually find and select the wanted year).
 * 6- Now select the wanted month.
 * 7- Now select the wanted day.
 */

/* TC#1
 * 1- Navigate to: https://rahulshettyacademy.com/seleniumPractise/#/offers.
 * 2- Click on the calendar of 'Delivery Date'.
 * 3- In the open calendar, Use the navigation buttons (+ or -) to select the wanted month.
 * 4- Use the navigation buttons (+ or -) to select the wanted year.
 * 5- Now select the wanted day.
 */
public class Added33 {
    @Test
	public void CalendarTest() throws InterruptedException {
    	// TC#1: 
		 WebDriver driver = new ChromeDriver();
	     driver.manage().deleteAllCookies();
	     driver.manage().window().maximize();
	     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	     driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	     
	     String wantedDay=  "15";
	     String wantedMonth= "February".trim().toLowerCase(); // or simply give a value in small letters and no spaces.
	     String wantedYear= "2050";
	     
	     //2:
	     // I choose to click on the calendar symbol, to open up the calendar.
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='calendar-button']")));
	     driver.findElement(By.cssSelector("button[class*='calendar-button']")).click(); 
	     
	     //3:
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.react-calendar__navigation__label"))); 
	     // wait till the month-year text (In top middle) is visible and then till its clickable.
	     String yearMonthText= driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).getText();
	     // Gets text of the month-year to be used as an input in the next explicit wait.
	     driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
	     
	     //4:
	     // wait till the month-year text (situated on the middle top) switches to year only text and then click
	     // this is to ensure the script doesn't click twice on the month-year text (Script is so fast) resulting in the wrong page of the calender.
	     wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("button.react-calendar__navigation__label"), yearMonthText));
	     driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
	     
	     //5- Select the wanted year (If it's not shown, then select the navigation to increase or the navigation to decrease to 
	       //eventually find and select the wanted year).
	     //Below: currently there is no elementToBeClickable() for List<WebElement>. Nevertheless, the below method assumes that if the 1st
	     //box element hosting the year text becomes clickable, then the rest simultaneously become. In here, this method is much more reliable 
	     // than visibilityOfAllElements() as I want to click on the wanted year & the fact that it would 1st wait till its visible and then till 
	     //it's clickable.
	     int i;
	     List<WebElement> yearElements;
	     do{
	     wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[class*= 'years__year']"))));
	     yearElements= driver.findElements(By.cssSelector("button[class*= 'years__year']"));
	     for( i=0; i<yearElements.size(); i++) {
	    	 String extractedYear= yearElements.get(i).getText();
	    	 if(extractedYear.equals(wantedYear)) {
	    		 yearElements.get(i).click();
	    		 break; // breaks out of the 'for loop', if(), & else if() ONLY
	    	 }
    		
	    	 // else if() statement isn't executing 
	    	 else if(i==yearElements.size()-1){   // Controller will only reach here if the wanted year is not in the list/UI
	    		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*= 'navigation__next-button']")));
	    		 driver.findElement(By.cssSelector("button[class*= 'navigation__next-button']")).click();
	    		  // Try below:
	    		 //Actions a= new Actions(driver);
	    		 // Below: Since the TAB function is activated onto the preceding element of the navigation arrow (Development feature).
	    		 //a.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	    		 //or: 
	    		 //a.moveToElement(driver.findElement(By.cssSelector("button[class*= 'navigation__next-button']"))).click().build().perform();
	    	 } }
	     }
	     while(driver.findElements(By.cssSelector("button[class*= 'years__year']")).size() > 0); 
	     // while(i==yearElements.size()-1);       is the  WRONG condition (If the year selected
	        // happens to be the last element, then it returns 'true' resulting in re-execution of 
	        // the 'do' statement and returning element not found exception.
    }
}
	    		 
	   
	    	 
	    
             
	     
	    

	


