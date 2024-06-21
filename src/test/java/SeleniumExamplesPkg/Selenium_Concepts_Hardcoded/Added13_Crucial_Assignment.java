package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Added13_Crucial_Assignment {
	// If this is going to be a flow testcase, then use soft assertions
	@Test
	public void Added13_AssignmentTest() throws InterruptedException
	{
		  //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		  //ChromeOptions options = new ChromeOptions();
		  //options.addArguments("--remote-allow-origins=*"); 
		  WebDriver driver = new ChromeDriver();   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		  driver.get("https://rahulshettyacademy.com/angularpractice/");
		  driver.manage().window().maximize();
		  
		  String name= "Ahmad";
		  String email= "aelaina100@gmail.com";
		  String password= "random password";
		  String dob= "19850501";
		  
		  // Verifying the message: ""Success! The Form has been submitted successfully!."" is NOT dispayed onto the screen as it 
		  // can only be, after submitting the form.
		  ;
		   Assert.assertEquals(driver.findElements(By.cssSelector("div.alert")).size(), 0, "BUG: Success message that the form is submited ALREADY appears "
		   		+ "on page [BEFORE clicking on the 'Submit' button]"); 
		   System.out.println(" Success message that the form is submited does NOT yet"
		   			   		+ " appear on page [Before clicking on the 'Submit' button] "); // replaced by .log in real-time (Utilizing Log4J)
		  
		  //Fill out the name field:
		  driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(name);   // locator is according to the 'Note ALPHA' documented in Added_1_locators.java
		  // How do I validate that name is displayed correctly in the UI ?
		  
		  //Fill out the Email field:
		  driver.findElement(By.cssSelector("[name= 'email']")).sendKeys(email);
		  // How do I validate that email is displayed correctly in the UI ?
		  
		  //Fill out the password field:
		  driver.findElement(By.cssSelector("[type= 'password']")).sendKeys(password);
		  // How do I validate that password is entered correctly in the UI ?
		  
		  //Checkbox:
		  driver.findElement(By.id("exampleCheck1")).click();
		  // Now, checking if the checkbox has actually been selected in the UI: // This is unoptimized/ redundant Just use one line assertion.
		  Boolean checkbox_status= driver.findElement(By.id("exampleCheck1")).isSelected();
		  if (checkbox_status)
		  {
			  System.out.println("Checkbox is actually checked in the UI");
			  Assert.assertTrue(true);
		  }
		  
		  else
		  {
			  Assert.assertTrue(false, "Checkbox is NOT selected in the UI"); //If excecuted, controller exits without the ability to execute the subsequent code lines.
		  }                                                                   // .Hence check what finally block is ?..soft assertions ?
		  
		  /*
		  //Invaluable idea: Sure, you can use the below try..catch statement. However; why not use soft assertion ? as it's more optimized.
		  try
		  {
			 Assert.assertTrue(checkbox_status, "Checkbox is NOT selected in the UI even though script has attempted so earlier. Catching this exception");
		  }
		  
		  catch(AssertionError e)
		  {
			  System.out.println("Checkbox Not selected. Even though script has attempted so");
		  }
		  */
		  
		  //Selecting 'Female' from ther static dropdown:
		  WebElement element_static_dropdown= driver.findElement(By.id("exampleFormControlSelect1"));
		  
		  Select s= new Select(element_static_dropdown);
		  s.selectByVisibleText("Female");
		  //How to validate that UI is now showing 'Female' as the chosen value in the static dropdown ?
		  
		  //Ensuring that 'Student' radio button is not selected.
		  Assert.assertFalse(driver.findElement(By.id("inlineRadio1")).isSelected(),"FAILED: radio button of 'Student' selected by default= a requirment violation !");
		  
		  //selecting the radio button 'Student"
		  driver.findElement(By.id("inlineRadio1")).click();
		  // Now validate if the radio button is now, indeed, being displayed in the UI as selected. 
		  Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected(), "FAILED: 'student' radio button is NOT selected even though script has attempted to do so");
		  
		  //Ensuring the radio button 'Entrepreneur' is disabled:
		    // Notice here that clicking on this, by default, disabled element doesn't render it enabled. Hence, the .isEnabled() method could be 
		    //used on such a disabled element
		  Assert.assertFalse(driver.findElement(By.id("inlineRadio3")).isEnabled(),"BUG: Radio button 'Entrepreneur' is ENABLED by default= requirement violation" );
		  
		  
		  //Enter Date of Birth:
		  driver.findElement(By.cssSelector("[name= 'bday']")).sendKeys(dob);
		  // Now how to validate if the UI is, indeed, displaying the entered dob by the script ?
		  
		  //Click on 'Submit'
		  driver.findElement(By.cssSelector("[type= 'submit']")).submit();
		  
		  // Verifying submission feedback message is now displayed onto the screen 
		  Assert.assertTrue(driver.findElement(By.cssSelector("div.alert")).getText().contains("Success"));
		// Identifying the box element holding the text of  "Success! The Form has been submitted successfully!." & then getting the text and
		   //checking if it contains the substring of "Success".
		  
		  // The big question: How to validate that a certain element remains disabled during the interactions with other web elements on the webpage ?
		  	// or that a feedback message only appears after submitting a form only, etc.
	}

}
