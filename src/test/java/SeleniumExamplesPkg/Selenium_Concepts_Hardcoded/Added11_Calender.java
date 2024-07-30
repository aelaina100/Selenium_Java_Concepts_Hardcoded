package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added11_Calender {
	
	// Findings:===> (1st step EVER=> observe the UI and come up with findings for locators BEFORE reading this program/Knowing what the testcase is)===>
	// The TEMPLATE for finding/ future findings are as follow ====>
	
	// 3  types of elements exist in this calender: 
	   //1- Disabled elementS    2-By-default highlighted enabled element (Today's day)    3- Enabled elementS
	    
// Before selection of ANYTHING:
	  	// 1- has the HTML code of ===========>    <span   class="ui-state-default">19</span>
	    // 2- has the HTML code of ===========>    <a      class="ui-state-default  ui-state-highlight  ui-state-hover" href="#">20</a>
	    // 3- has the HTML code of ===========>    <a      class="ui-state-default"  href="#">22</a>
	  
// AFTER  selecting the By-default highlighted enabled element (Today's day) 
//  1- has the HTML code of ===========>    <span  class="ui-state-default">19</span>
//  2- has the HTML code of ===========>    <a     class="ui-state-default  ui-state-highlight  ui-state-active ui-state-hover" href="#">20</a> only //'ui-state-active' Added
//  *3- has the HTML code of ===========>   <a     class="ui-state-default" href="#">21</a>
	  

// or AFTER  selecting an enabled element (Not the By-default highlighted)
// 1- has the HTML code of ===========>    <span   class="ui-state-default">19</span>
// 2- has the HTML code of ===========>    <a      class="ui-state-default ui-state-highlight" href="#">20</a> //  " ui-state-hover" disappear
// 3- has the HTML code of ===========>    <a      class="ui-state-default" href="#">21</a>
	
	/* In coclusion: Selecting the by-default highlighted day adds    class= ui-state-highlight  to it
	                 Selecting another day removes from the by-default highlighted day    class = ui-state-hover                                                                             */
	  
	/* [Type of day elements to click on by the script]:
	A- Today's highlighted element .....
	B- The day after today.....
	C- The first/last enabled element 
	D- A specific date (Example: the 17th. Where, if it's disabled, then select the nearest next enabled day)
	
	*/
	@Test(enabled=false)
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
	}
		  //Or:  
		  /*    //A more optimized way, would be: [But sometimes, one has to use the usual iteration technique above as the use of instance Xpath (  ) [] might not be permitted.]
		  
		  String locator= "(//td[@data-handler= 'selectDay'])" + "[" +driver.findElements(By.xpath("//td[@data-handler= 'selectDay']")).size() +"]";
		  driver.findElement(By.xpath(locator)).click();  
		   */
	
	
static int todays_index; 
@Test
public void Tc2_handlingCalender() throws InterruptedException
{  
	
	/* Test Case #2:
	  * 1- Select Round Trip.
	  * 2- From the Depart Date, select the day after the by default highlighted today's date.
	  * 3- From the RETURN DATE, select another specific enabled day element ( Ex: 17- Assume that, in future, an day element will become disabled).
	  *    Where if it turns out to be disabled, then move to the next enabled day. */
	
	  WebDriver driver = new ChromeDriver();   // Using Selenium Manager
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // 1
	  driver.findElement(By.id("ctl00_mainContent_view_date1")).click();  // Clicks on DEPARTURE DATE calender to open it up.
	  Thread.sleep(1000L);  // As it takes time for the RETURN DATE calender to become enabled.
	  
	  //2 below
	  
	  int today= Integer.parseInt(driver.findElement(By.className("ui-state-highlight")).getText());
	  //  String today= driver.findElement(By.cssSelector("div.ui-datepicker-group-first a.ui-state-highlight")).getText();
	  // Above: Gets the text of the by-default highlighted day of today. Now, find the element whose text is today +1==>
	  
	  int count_enabled_days= driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).size();
	  for(int i=0; i<count_enabled_days; i++)
		{
		 int enabled_day =Integer.parseInt(driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).get(i).getText());
		 
		 if(enabled_day== today +1) 
		 {
			 driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).get(i).click();
			 break;
         }
		 else if(i==count_enabled_days -1) //If controller reaches here, then ifcondition wasn't fullfilled on the last iteration
			   //                          (Day wasn't found. neither 32(nor 31 if month ends at 30
		 {
			 driver.findElement(By.cssSelector("div.ui-datepicker-group-last a[href= '#']" )).click(); 
			 // Since the highlighted day happens to be the last day on the 1st group, then select the 1st enabled day on the 2nd group
		 }     }
		 
		 
 /*
	  // Or: A more optimized code (If instance Xpath is permitted in the workplace) ===>
	     // Get the index at which the by-default highlighted day is.
	     // Increase the index by 1, plugging it into the Instance XPAth technique
	    // int todays_index = 0 ;
	     String today= driver.findElement(By.className("ui-state-highlight")).getText();
	     //Now figure, at which index is the text
	     int count_enabled_elements= driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).size();
	     for (int i=0; i<count_enabled_elements; i++)
	     {
	    	 if(driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).get(i).getText().equals(today))
	    	 {
	    	   todays_index= i;  // very crucial to discern ==>
	    	   break;
	    	 }
	     }
	    
		driver.findElement(By.xpath("(//td[@data-handler= 'selectDay']/a)" + "[" + todays_index+2 +"]"  )).click(); 
		 //+2 since instance Xpath starts from 1 and index starts from zero
		// +2 will select the day after the highlighted day.
		// If the last day happens to be 31 or 30 or 28, this isntance xpath will select the first enabled day in the 2nd group of DEPART DATE calender.
	 
 */
		 //3 Below 
	  
		 driver.findElement(By.id("ctl00_mainContent_view_date2")).click(); // Clicks on the RETURN DATE calender to open it up.
		 Thread.sleep(1000L);  // As it takes time for the calender to open up, let alone finish loading all the elements inside it.
		 
		 String day_to_select ="2"; 
		 int count_enabled_days_1stGroup_return= driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).size();
		 for(int j=0; j<count_enabled_days_1stGroup_return; j++ )
		 {

			if (driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).get(j).getText().equals(day_to_select))
					{
				     driver.findElements(By.cssSelector("div.ui-datepicker-group-first a[href= '#']")).get(j).click();
					}
			
			else if (j== count_enabled_days_1stGroup_return-1)   // on the last iteration where the last element doesn't meet the 'if' condition.
				                                                   // In other words: If the day_to_select is not an enabled one or an invalid one (ex: 32)
			{
				// Then, in the 2nd (last group)- Select the earliest enabled day:
				driver.findElement(By.cssSelector("div.ui-datepicker-group-last a[href= '#']")).click();
			}
				
				 
			}   
		 
		// Below: if I were to choose the last enabled element (Move to a seperate testcase)
		 /*
	     driver.findElement(By.id("ctl00_mainContent_view_date2")).click(); // Clicks on the RETURN DATE calender to open it up.
		 Thread.sleep(1000L);  // As it takes time for the calender to open up, let alone finish loading all the elements inside it.
		 int count_enabled_days_2ndGroup_return= driver.findElements(By.cssSelector("div.ui-datepicker-group-last a[href= '#']")).size();
		 for (int k=0; k< count_enabled_days_2ndGroup_return; k++)
		 {
			 if (k== count_enabled_days_2ndGroup_return-1)  // for 1st enabled element either the line x modified or the unoptimized if(i=0)
			 {
				 driver.findElements(By.cssSelector("div.ui-datepicker-group-last a[href= '#']")).get(k).click();.....x
			 }
			
} 
*/
} }
	  
		  
		  
		