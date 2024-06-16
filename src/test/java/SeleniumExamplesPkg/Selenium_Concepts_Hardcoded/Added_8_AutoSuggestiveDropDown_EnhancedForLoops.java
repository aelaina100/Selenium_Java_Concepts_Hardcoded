package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added_8_AutoSuggestiveDropDown_EnhancedForLoops {

	@Test
	public void Added_8_AutoSuggestiveDropDown_EnhancedForLoopsTest() throws InterruptedException
	{
		    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		 	ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
			WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			//1-  Testcase: Type in a valid countrie's name.
			//2-  Ensure that this country appears in the suggested dropdown list without being automatically chosen.
			//3-  Ensure it can be selected
			
			String country= "georgia"; // Use 'georgia' A good choice since at least two results come up  //use 'Ar'
			driver.findElement(By.id("autosuggest")).sendKeys(country);  // 1
			
			Thread.sleep(1000L); // as takes time for the dropdown to open up and elements to load
			List<WebElement> elements= driver.findElements(By.cssSelector("ul[class*='ui-autocomplete'] a")); // elements holding the text of countries
			System.out.println(elements.size());    // line For debugging 
			
			Assert.assertNotEquals(elements.size(),0, "NOT a single result displayed/ There is NO displayed country suggested in the dropdown list");
		    JavascriptExecutor js= (JavascriptExecutor)driver;
			
		    int i=0;
			for(WebElement element: elements)
			{
				String displayed_country= element.getText();
				System.out.println(displayed_country);
				i++;
				
				if(displayed_country.equalsIgnoreCase(country))
				{   
					js.executeScript("arguments[0].click()", element);
					//With: driver.findElements(By.cssSelector("ul[class*='ui-autocomplete'] a")  ===>  throwing: Element click intercepted with country 'georgia'
					 // Also with: //body/form/following-sibling::ul/li/a  &  more..
					
					// Write a code here ensuring that the clicked country is the one that's showing up in the field
					 
					break; // As soon as you find the country, there is no need to continue looping through the rest of the displayed elements (countries)
				}
				
				else if (elements.size()== i) // argument= at the last element (country) // Crucial arument: count==i-1 will render this
					                    // else if block unexecutable
					                 // If controller moves here, it means the element (country) isn't in the list 
				{
					System.out.println("Country of: " + country + " is NOT displayed. But other countries are");
					Assert.assertTrue(false, " Country is NOT in the suggested list that's being displayed");
					
				}  
			}          
	}

}
