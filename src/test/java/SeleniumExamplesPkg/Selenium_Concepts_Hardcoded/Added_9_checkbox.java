package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added_9_checkbox {
    
	@Test(enabled=false)
	public void  Added_9_checkbox_ex1_Test(){
		 // Testcase #1: In https://rahulshettyacademy.com/dropdownsPractise    
		   //Ensure checkbox of: 'Family and Friends' is selectable.
		
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*"); 
	  WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  //Solution: 
	  	//1- Ensure the checkbox isn't initially selected (Assuming according to requirement).
	    //2- Select the checkbox.
	    //3- Ensure the checkbox is now selected.
	  //1- 
	  WebElement checkBox_element= driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")); //Storing it since it's used again below (Code optimization)
	  // That's 100 % how to do it (Regular expression) as the value of Id  is long & unreliable.
	  Assert.assertFalse(checkBox_element.isSelected(), "Checkbox of 'Family and Friends' IS selected (it shouldn't be).");
      //2- 
	  checkBox_element.click(); // that's 100 % how to do it (Regular expression)
      //3-
      Assert.assertTrue(checkBox_element.isSelected(), "Checkbox of 'Family and Friends' is NOT selected (It should be).");
	  
	  
	  // Crucial: Even with Aseertions there is a room for optimization (As illustrated in the below commented out block of code):
	  /* Below code is unoptimized upon 1st attempt [Observe it]
	  //1- 
	  WebElement checkBox_element= driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")); 
	  // that's 100 % how to do it (Regular expression) as the value of Id  is long & unreliable.
	  boolean checkBox_bool1= checkBox_element.isSelected();
	  Assert.assertEquals(checkBox_bool1, false, "Checkbox of 'Family and Friends' IS selected (it shouldn't be).");
	  
      //2- 
      driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).click(); // that's 100 % how to do it (Regular expression)
      //3-
      boolean checkBox_bool2= checkBox_element.isSelected();
      Assert.assertEquals(checkBox_bool2, true, "Checkbox of 'Family and Friends' is NOT selected (It should be).");
      */
	}
	
	@Test
	public void Added_9_checkbox_ex2_Test()
	{
		// Testcase #2:
		 //Validate the number of checkboxes (= 6  As of now) on the entire webpage
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*"); 
		  WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  
		  int expected_number_checkbox= 6;
		  int actual_number_checkboxes = driver.findElements(By.cssSelector("input[type= 'checkbox']")).size(); 
		  //System.out.println(actual_number_checkboxes);// for debugging purposes only
		  Assert.assertEquals(actual_number_checkboxes, expected_number_checkbox);
		  
		  // Crucial to resolve: UI only shows 5 checkboxes. 
		  	//When validating the locator in the console, 6 elements are returned. 
		  		//Where the 1st one doesn't point to any element on the UI
		  			//Even though I can find it's associated <HTML code>. This is because it's hidden 
	}

	
}
