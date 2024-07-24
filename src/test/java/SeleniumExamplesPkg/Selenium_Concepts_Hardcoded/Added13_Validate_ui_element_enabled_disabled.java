package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added13_Validate_ui_element_enabled_disabled {
	// Testcase" Ensure that RETURN DATE calender is only enabled when 'Round Trip' radio button is selected.
	@Test
	public void validate_ui_element_enabled_disabledTest() throws InterruptedException
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*"); 
		  WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  /* Steps: [It really depend on the requirements. Neverthelss, here I am going to include as many steps as possible for the purpose of fully exercising]
		   * 1- On UI ensure that 'One Way' trip is selected by default [Depends on the requirement. But here if it's not, then select it].
		   * 2- Once selected, ensure that RETURN DATE calender is disabled
		   * 3- Select 'Round Trip'
		   * 4-Ensure that 'RETURN DATE' calender is now enabled.
		   * 5- Select 'One way' radio button.
		   * 6- Now, ensure that RETURN DATE calender is back to disabled.
		   */
		  
		  //1- 
		  Boolean oneway= driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected();
		  if(oneway)  // if oneway= 'true'
		  {
			  Assert.assertTrue(true);
		  }
		  else
		  {
			  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); 
		  }
		  
		  
		  /* try  // this is more complicated  No need for try catch statement==>
		  {
			  Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected()," 'One Way' radio button in NOT selected by default. Script will select it now..." );    
		  }
		  catch (AssertionError e) // Instead of ' Exception e' in order for catch to be executable.
		  {
			  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); // clicks on 'One Way' radio button
			  //System.out.println("catch block");
		  }  */
		  
		  
		  
		  //2- Can directly be solved using the unreliasble.isEnabled() method. It only works for some browsers and defin. NOT here==>
		    //driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled(); // or "Div1" // line always returning true.
		  
		  // CRUCIAL NOTE: We know that this .Enabled() method is NOT reliable at all in this specific scenario because==>
		    //In the UI, if you click on the disabled element, then it gets enabled. The .Enabled() method (Returning true or false)
		     // is designed for UI elements that when are disabled, can never be enabled by simply clicking on it in the UI.
		  Thread.sleep(1000L); 
		  String value1_of_attribute_style= driver.findElement(By.id("Div1")).getAttribute("style");  //Extracting information from this element instead of performing an action on it such as .click();
		  
		  Assert.assertTrue(value1_of_attribute_style.contains("0.5"), "Bug: RETURN DATE Calender is ENABLED when 'One Way' radio button is selected"); // Calender is disabled when attribute 'style' contains "0.5" 
		  System.out.println("Success: Calender of 'RETURN DATE' is disabled when radio button 'One Way' is selected"); // log ("") in real-time with log4j
		  
		  /*
		  // Below if else statement is UNOPTIMIZED primitive way of expressinf the above line
		  //also exactly the same lines of code scripted by instructor:
		   
		  if (value1_of_attribute_style.contains("0.5"))  // Calender is disabled when attribute 'style' contains "0.5" 
		  {
			  System.out.println("Success: Calender of 'RETURN DATE' is disabled when radio button 'One Way' is selected");
			  Assert.assertTrue(true);
		//or  Assert.assertFalse(false);   // Same thing.
		  }
		  else
		  {
			  Assert.assertTrue(false, "Bug: RETURN DATE Calender is ENABLED when 'One Way' radio button is selected"); // throw an exception 
		  } */
		  
		  
		  //3- 
		  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); // Clicks on 'Round Trip' radio button.
		  
		  //4-
		  Thread.sleep(1000L); // As it takes some time for the RETURN DATE calender to be enabled (= to have 'style' attribute change its value)
		  String value2_of_attribute_style= driver.findElement(By.id("Div1")).getAttribute("style");  //Extracting information from this element instead of performing an action on it such as .click();
		  
		  if (value2_of_attribute_style.contains("1"))  // Calender is disabled when attribute 'style' contains "0.5" 
		  {
			  System.out.println("Success: Calender of 'RETURN DATE' is ENABLED when radio button 'Round Trip' is selected");
		  }
		  else
		  {
			  Assert.assertTrue(false, "Bug: RETURN DATE Calender is DISABLED when 'Round Trip' radio button is selected"); // throw an exception 
		  }
		  
		  //5- 
		  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); // clicks on 'One Way' radio button
		  
		  //6-
		  Thread.sleep(1000L); // As it takes time for thye caleder of RETURN DATE to be disabled  (= to have 'style' attribute change its value)
          String value3_of_attribute_style= driver.findElement(By.id("Div1")).getAttribute("style");  //Extracting information from this element instead of performing an action on it such as .click();
		  
		  if (value3_of_attribute_style.contains("0.5"))  // Calender is disabled when attribute 'style' contains "0.5" 
		  {
			  System.out.println("Success: Calender of 'RETURN DATE' is disabled when radio button 'One Way' is selected again !");
		  }
		  else
		  {
			  Assert.assertTrue(false, "Bug: RETURN DATE Calender is ENABLED when 'One Way' radio button is selected"); // throw an exception 
		  }  
	}
}
