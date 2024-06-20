package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Added_5_dynamic_dropdown {
	
	@Test
	public void Added_4_dynamic_dropdownTest() throws InterruptedException
	{
	// Pre-requisite: Study written notes on "Dynamic DropDown" BEFORE proceeding to this example:
	// In: https://rahulshettyacademy.com/dropdownsPractise/"
	  // From the 'PASSENGERS' dropdown, select 3 adults and click on 'Done'
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*"); 
	WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	// IMPORTANT: Open in-cognito if you encounter issues with elements on the web page.
	
	
	//Before you click on the dropdown element so that it can open up:===>
	  // Assume you first want to in-console validate: //a[@value='MAA']   So, what would the outcome be ?(try it)?
	    // Outcome: No element identified.   Reason: It's a dynamic dropdown with elements that will only start loading after opening it up.
	
// Now- from the 1st dropdown only- Select ANY city ==> in-console validate: //a[@value='MAA']   So, what would the outcome be ?(try it)?
	// Outcome: 2 elements found. 1st element is in the 1st dropdown as it was already loaded   2nd element is in the 2nd dropdown as its already open with all elements loaded.
	
	//Include an implicit wait here for the 1st drop down. Even though driver.get() has an imbedded wait ensuring that all elements on the web page are fully loaded 
	 //before proceeding to the next line.
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // clicks on the Dymanic droplist
	
	Thread.sleep(1000L); // As it takes time for the drop down to open up, let alone loading the elements inside it. 
	                    // Wait is included before even running the script. Never check whether the script is going to fail, so that if it dooes I now need to include a wait !
	                    // As this is the wrong way of thinking. Wait is included even if the script passes without it (but in the future will FAIL at some point).
	
	driver.findElement(By.xpath("(//a[@value='MAA'])[1]")).click();  // Select the city Chennai(MMA) so that the 2nd dynamic dropdown automatically opens up.
	// You may argue that  //a[@value='MAA'] can identify the 1st element as controller executes from the top left corner, etc. etc. This is 100 percent correct and
	// you can do it. But here, I choose : (//a[@value='MAA'])[1] since the 2nd index has to be used (still not a good reason. There is 0 diff. 
	// But still 100 percent correct. YES
	
	//driver.findElement(By.cssSelector("(a[value='MAA'])::nth-child(1)")).click();  // denoting that this CSS formula is incorrect
	
	
	//Exercise: On this line==> What's the outcome of executing:    driver.findElement(By.xpath("(//a[@value='MAA'])[1]"  ? ===> Answer: it will be identified (In 1st dropdown)
	//Thread.sleep(1000L);
	//driver.findElement(By.xpath("(//a[@value='MAA'])[1]")).click(); ===> Answer: Element not interactable as it's now locked inside the closed dropdown.
	//Or:
	//driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click(); ===> Answer: Element not interactable as it's now locked inside the closed dropdown.
	
	//In other words: It can identify the element, but will NOT be able to interact with it (Element locked). Hence, "interactable" message is thrown.
	
	Thread.sleep(1000L);
	//driver.findElement(By.cssSelector("(a[value='VTZ')::nth-child(2)")).click();
	driver.findElement(By.xpath("(//a[@value='VTZ'])[2]")).click(); // Selects the city of  Vishakhapatnam (VTZ)
	// and again the CSS equivalent formula is not recognized. Find out !
	
	//Note: If you receive a note indicating that instance Xpaths are not allowed (Even though they are 100 % correct to use in Adjacent Dynamic dropdowns scenarios as
	  // elaborated upon in written notes, then look at the enxt example [Again, study the hand written notes before delving into this current testcase]

	
}
	
	
	
	
	
	
	
	
  }