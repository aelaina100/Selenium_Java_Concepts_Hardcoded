package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added_static_dropDown {
	
	@Test
	public void seleniumManager()
	{
		// In: https://rahulshettyacademy.com/dropdownsPractise/"
		  // From the 'currency' dropdown, select 'USD"
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		String currency= "USD".trim().toLowerCase();
		
		WebElement static_dropDown_element= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s= new Select(static_dropDown_element); // argument: The static drop down will not only be identified. But, also clicked on (without including .click() to start with)
		s.selectByValue("USD");
		
		//s.selectByIndex(3); // Selecting by index is the least reliable method as an item could be added or taken out or items re-arranged inside the list.
		               // Hence. Selecting by 'value' is the most reliable way instead of even the most least reliable one which is selecting by visible text (you still get
		               // the text from the <Html  code>
		// But one could argue that, in this specific example  s.selectByVisibleText() is the best bet as currency names do not really change while the
		  // value attribute in the <HTML code> could change to, for example, American or Australian, etc. etc.
		
	// Now, after an item has been selected- one needs to ensure that this specific item, has indeed, been selected  =====>
		Assert.assertEquals(s.getFirstSelectedOption().getAttribute("value").trim().toLowerCase(), currency, "Currency selected is NOT the one displayed on UI");
		// or even use ====>
		   //Assert.assertEquals(s.getFirstSelectedOption().getText().trim().toLowerCase(), currency, "Currency selected is NOT the one displayed on UI");
		
		// CRUCIAL: for the error message (3rd argument), do not include any dynamic reference to variables such as + currency + " .."
		  // as when an exception is thrown, the compiler readily provides all this info What is actual VS expected)
		
		
		//CRUCIAL NOTES====>
		//s.getFirstSelectedOption());   // currently selected option 
		//s.getAllSelectedOptions() // currently ALL selected optionS  //works if you can multi-select in this static drop down (Here this option isn't available)
	}

}
