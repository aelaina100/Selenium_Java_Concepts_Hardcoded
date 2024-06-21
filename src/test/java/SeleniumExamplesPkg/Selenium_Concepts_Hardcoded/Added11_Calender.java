package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added11_Calender {
	
	// Findings:===> (1st step EVER=> observe the UI and come up with findings for locators BEFORE reading this program/Knowing what the testcase is)===>
	
	  // 3  types of elements exist in this calender: 1- Disabled elementS    2-By-default highlighted enabled element (Today's day)    3- Enabled elementS
	    
// Before selection of ANY day:
	  	// 1- has the HTML code of ===========>    <span   class="ui-state-default">19</span>
	    // 2- has the HTML code of ===========>    <a      class="ui-state-default  ui-state-highlight  ui-state-hover" href="#">20</a>
	    // 3- has the HTML code of ===========>    <a      class="ui-state-default"  href="#">22</a>
	  
// AFTER  selecting the By-default highlighted enabled element (Today's day) 
//  1- has the HTML code of ===========>    <span  class="ui-state-default">19</span>
//  2- has the HTML code of ===========>    <a     class="ui-state-default  ui-state-highlight  ui-state-active ui-state-hover" href="#">20</a> //'ui-state-active' Added
//  *3- has the HTML code of ===========>   <a     class="ui-state-default" href="#">21</a>
	  

// or AFTER  selecting an enabled element (Not the By-default highlighted)
// 1- has the HTML code of ===========>    <span   class="ui-state-default">19</span>
// 2- has the HTML code of ===========>    <a      class="ui-state-default ui-state-highlight" href="#">20</a> //  " ui-state-hover" disappear
// 3- has the HTML code of ===========>    <a      class="ui-state-default" href="#">21</a>
	  
	/* [Type of day elements to click on by the script]:
	A- Today's highlighted element .....
	B- The day after today.....
	C- The first/last enabled element 
	D- A specific date (Example: the 17th. Where, iff it's disabled, then select the next enabled day)
	
	*/
	@Test
	public void Tc1_handlingCalender() throws InterruptedException
	{  
		
		 /* Test Case #1:
		  * 1- Select Round Trip.
		  * 2- Validate that 'Return Date'calender is enabled.
		  * 3- From the Depart Date, select the by-default hightlighted (Today's) day.
		  * 4- From the RETURN DATE, select an enabled day element (First or last) (Assume that, in future, an day element will become disabled).
		  */
		  WebDriver driver = new ChromeDriver();   // Using Selenium Manager
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // 1
		  Thread.sleep(1000L);  // As it takes time for the RETURN DATE calender to become enabled.
		  Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"), "Bug: RETURN DATA calender disabled when round trip is selected"); //2
		  driver.findElement(By.id("ctl00_mainContent_view_date1")).click();  // Clicks on DEPARTURE DATE calender to open it up.
		  Thread.sleep(1000L); // As it takes time for the calender to open up; let alone loading all elements inside it.
		  driver.findElement(By.className("ui-state-highlight")).click(); //3
		  driver.findElement(By.id("ctl00_mainContent_view_date2")).click(); // Clicks on RETURN DATE calender to open it up.
		  Thread.sleep(1000L); // As it takes time for the calender to open up; let alone loading all elements inside it.
		  //driver.findElement(By.cssSelector("div#ui-datepicker-div a[href= '#']")).click(); //4  Selects FIRST enabled day
		  // or: driver.findElement(By.xpath("(//td[@data-handler= 'selectDay'])[1] ")).click(); //=100 %=  //td[@data-handler= 'selectDay'])
		  
		  // Below to select last enabled element:  //4
		  int count_enabled_day_elements= driver.findElements(By.cssSelector("div#ui-datepicker-div a[href= '#']")).size();
		  //System.out.println(count_Of_Enabled_day_elements); // debugging purposes
		  for (int i=0; i<count_enabled_day_elements; i++)
		  {
			  if (i==count_enabled_day_elements-1) // If iteration is on the last element.
			  {
			  driver.findElements(By.cssSelector("div#ui-datepicker-div a[href= '#']")).get(i).click();
			  }
		  }      
		  
		  //Or:  
		  /*    //A more optimized way, would be: [But sometimes, one has to use the usual iteration technique above as the use of instance Xpath (  ) [] might not be permitted.]
		  
		  String locator= "(//td[@data-handler= 'selectDay'])" + "[" +driver.findElements(By.xpath("//td[@data-handler= 'selectDay']")).size() +"]";
		  driver.findElement(By.xpath(locator)).click();  
		   */
	}

	
@Test(enabled=false)
public void Tc2_handlingCalender() throws InterruptedException
{  
	
	/* Test Case #2:
	  * 1- Select Round Trip.
	  * 2- Validate that 'Return Date'calender is enabled.
	  * 3- From the Depart Date, select the day after the by default highlighted today's date.
	  * 4- From the RETURN DATE, select another specific enabled day element ( Ex: 17- Assume that, in future, an day element will become disabled).
	  *   // Where if it turns out to be disabled, then move to the next enabled day.
	  */
	  WebDriver driver = new ChromeDriver();   // Using Selenium Manager
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  
	  
	  
	  
	  
	  
} }
	
		  
		  
		  
		  /*//////////////////////////////////////////////////////
		  
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
		  

