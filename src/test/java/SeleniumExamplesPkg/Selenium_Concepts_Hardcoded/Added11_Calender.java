package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added11_Calender {
	
	@Test
	public void handlingCalender() throws InterruptedException
	{
		  //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		 // ChromeOptions options = new ChromeOptions();
		 // options.addArguments("--remote-allow-origins=*"); 
		  WebDriver driver = new ChromeDriver();   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  
		// Findings:===> (1st step EVER=> observe the UI and come up with findings for locators BEFORE reading this program/Knowing what the testcase is)
		  
		 // div[class*= 'ui-datepicker-group-first'] td[data-event= 'click'] a     
		 // shared by all selectable dates (Today's date - End of the month) in the 1st group (month) of date picker of Depart Date or Return Date 
		   // Both Depart Date & Return Date calenders share the same <HTML  code>

		//  div[class*= 'ui-datepicker-group-last'] td[data-event= 'click'] a  
		// shared by all selectable dates (Today's date - End of the month) in the 2nd group (month) of date picker of Depart Date or Return Date
		  
		//       className= ui-state-default   OR  td[data-event= 'click'] a (worse)
		//      Shared by all selectable dates in BOTH 1st & 2nd groups
		  
		//Today's by-default highlighted date has the unique locator of:     class= ui-state-highlight
		// CRUCIAL: Any date that GETS selected will have an addition class value of 'ui-state-active'
		  
	// Testcase1: From DEPART DATE, 1st group (Month), select the highlighted date (If you observe- It's today's date)
		  driver.findElement(By.id("ctl00_mainContent_view_date1")).click(); //opens up the calender
		  Thread.sleep(1000L); // As it takes time for the calender to open up; let alone, loading all the elements inside it.
		 
		  //driver.findElement(By.className("ui-state-highlight")).click(); //Selects the highlighted date (Today's date)
		  driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-hover")).click();
		    // Above locator is too long. Hence, only use  "a.ui-state-default.ui-state-highlight"
		  
		  
		  /*
		  Thread.sleep(1000L); // As it takes time for the attribute 'a.ui-state-default.ui-state-active' to be generated
		  //Below line will fail as the calender closes where the locator becomes invalid.
		  //will only work if you click again on the calender 
		  // Now, it's CRUCIAL to ensure that the date selected is the correct one that's being displayed:==>
		  String selected_date= driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).getText();
		  // Above: stores  the selected date as it has a unique attribute value 'ui-state-active' (generated for ANY date after getting selected)
		  // Now- use Java to generate today's date where it has to contain the string of 'selected date'
		  
		    Date d= new Date(); // contains current date, in and by itself.
			System.out.println(d.toString());  // output is:    Sat Feb 11 19:39:26 EST 2023   so to format:
	        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	        System.out.println(sdf.format(d));  // For debugging purposes.
	        
	        if(sdf.format(d).contains(selected_date))
	        {
	        	System.out.println("PASS: The selected calender day [Which appears highlighted by default] is displayed correctly in the UI");
	        }
	        
	        else
	        {
	        	Assert.assertTrue(false, "The selected calender day [Which appears highlighted by default] is NOT displayed correctly in the UI ");
	        }
		  
		  */
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  /* This is a very bad technique created earlier (As it assumes that the caption displayed will always be correct/ won't get buggy in the future !)
		   * // Now, it's CRUCIAL to ensure that the date selected is the correct one that's being displayed:==>
		   
		  String highlighted_calender_day= driver.findElement(By.className("ui-state-active")).getText(); // 17...for example
		  
		  String displayed_calender_date= driver.findElement(By.id("view_fulldate_id_1")).getText(); // Mon, Jun 17 2024...for example
		  // also, below caption under the already chosen departure date'
		  
		  if(displayed_calender_date.contains(highlighted_calender_day))
		  {
			  System.out.println("Pass: Date selected in DEPARTURE DATE calender is correctly reflected in the UI");
		  }
		  
		  else
		  {
			  Assert.assertTrue(false, "Date selected from DEPARTURE DATA calender is NOT correctly reflected in the UI");
		  }
		  */
		  
		  
    // Testcase2: Selecting a specific date (Example:==> June 29th,2024)
		  // Instructor will add this testcase (Method) as we progress along.
	}

}
