package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Added33CalendarPractical {
	
	@Test
	public void calendarPracticalTest() throws InterruptedException
	{
		 WebDriver driver = new ChromeDriver();
	     driver.manage().deleteAllCookies();
	     driver.manage().window().maximize();
	     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	     driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	     
	     String day=  "15";
	     String month= "February".trim().toLowerCase(); // or simply give a value in small letters and no spaces.
	     String year= "2026";
	     // The UI behavious is: Select year, then month, and lastly day.
	     /*
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='calendar-button']")));
	     driver.findElement(By.cssSelector("button[class*='calendar-button']")).click();
	     //Selecting the day:
	     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("react-calendar__tile"))); 
	     // As it takes time for the day elements to be loaded inside the calendar.
	     List<WebElement> daysElements= driver.findElements(By.className("react-calendar__tile"));
	     for(int i=0; i<daysElements.size(); i++) {
	    	 String dayText= daysElements.get(i).getText();
	    	 if(dayText.equals(day)) {
	    		 daysElements.get(i).click();  // Once a day is selected, calendar closes.
	    		 break; }}
	     wait.until(ExpectedConditions.invisibilityOfAllElements(daysElements)); // As it takes time for the calendar to close up.
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='calendar-button']")));
	     driver.findElement(By.cssSelector("button[class*='calendar-button']")).click();
	     */
	     //Selecting the month:
	     /*
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='calendar-button']")));
	     driver.findElement(By.cssSelector("button[class*='calendar-button']")).click(); // clicking on calender so it opens up.
	     
	     Thread.sleep(2000L);
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.react-calendar__navigation__label")));
	     driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click(); 
	     //Above: clicking on the top middle current month and year so that a list of the 12 months opens up.
	     
	     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class*= 'months__month']")));
	     //As it takes time for the month elements to load up inside the calender
	     List<WebElement> monthsElements= driver.findElements(By.cssSelector("button[class*= 'months__month']"));
	     for(int i=0; i< monthsElements.size(); i++) {
	    	 String monthText= monthsElements.get(i).getText().trim().toLowerCase();
	    	 if(monthText.equals(month)) {
	    		 monthsElements.get(i).click();
	    		 break; }}
	    		 */
	    //selecting the year
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='calendar-button']")));
	     driver.findElement(By.cssSelector("button[class*='calendar-button']")).click();
	     
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.react-calendar__navigation__label")));
	     driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click(); 
	   //Above: clicking on the top middle month and year so that a list of the 12 months opens up.
	     
	     wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.react-calendar__navigation__label")));
	     driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
	     //Above: clicking again so that a list of years open up.
	     
	     // Below: including them outside of do while statement yields a stale element exception.
	    // wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class*= 'years__year']")));
	     //As it takes time for the year elements to load up inside the calender
	    // List<WebElement> yearElements= driver.findElements(By.cssSelector("button[class*= 'years__year']"));
	     
	     int i;
	     List<WebElement> yearElements;
	     do {
	    	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[class*= 'years__year']")));
		     //As it takes time for the year elements to load up inside the calender
		     yearElements= driver.findElements(By.cssSelector("button[class*= 'years__year']"));
		     
	     for(i=0; i<yearElements.size(); i++) {
	    	 String yearText= driver.findElements(By.cssSelector("button[class*= 'years__year']")).get(i).getText();
	    	 if (yearText.equals(year)) {
	    		 driver.findElements(By.cssSelector("button[class*= 'years__year']")).get(i).click();
	    		 System.out.println("i: "+ i);
	    		 break; }// removing it yields a stale element exception. Why ?!
	    	 
	    	 else if(i== driver.findElements(By.cssSelector("button[class*= 'years__year']")).size());  // Controller reaches here when last iteration doesn't fulfill the condition
	    	 { 
	    		 //Thread.sleep(4000L);
	    		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*= 'next-button']")));
	    		 driver.findElement(By.cssSelector("button[class*= 'next-button']")).click(); 
	    	 }
	    	 
	    	 }}
	    	 while(i== driver.findElements(By.cssSelector("button[class*= 'years__year']")).size()); // should not have curly brackers and subsequently line(s) of code. If this is the case then its ALWAYS executed.
	    	 
	    		 
	    	  } }
	     
	
	    	    	 
	    	    
	     
	     

	    
	     
	     
	     
	     
	     
	     
	     
	     



