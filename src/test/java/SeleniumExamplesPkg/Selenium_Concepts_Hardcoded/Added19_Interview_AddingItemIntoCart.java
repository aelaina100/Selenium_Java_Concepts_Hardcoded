package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//In addition to the main scenarios of the previous .java class file, examine some additional ones below:

public class Added19_Interview_AddingItemIntoCart {

	// In addition to the main scenarios of the previous .java class file, examine some additional ones below:
	
	@Test(enabled = false) // Keep it turned off, as this is a primitive way of designing the above mentod/
	// testcase, as the single item we want to add to cart (Potato) is stored in a string variable instead of an array.
	// The correct way is to store it in an array so that in future you can add another item(s)) = less maintenace =usable code.
     // Where you also have to provide a dynamic break statement.
	
public void Added18_primitive_AddingItemsIntoCartTest() throws InterruptedException { // Prerequisite: ENSURE
																	// familiarity with
WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

String productInfo = null;
String wantedProduct = "Potato".toLowerCase().trim(); // Poor way of designing the method as an array must be
										// created instead, even if it contains 1 item.
int count = driver.findElements(By.cssSelector("h4.product-name")).size();
for (int i = 0; i < count; i++) {
productInfo = driver.findElements(By.cssSelector("h4.product-name")).get(i).getText().toLowerCase();
if (productInfo.contains(wantedProduct)) {
driver.findElements(By.xpath("//div[@class= 'product-action']/button")).get(i).click();
break;
}
}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// TC #3: VERY IMPORTANT
// 1- On: https://rahulshettyacademy.com/seleniumPractise/#/
// Add 'Potato', 'Beans', & 'Pista' to cart by clicking on 'Add to Cart' button via using locator by text only.
@Test
public void added18_textLocator_AddingItemsIntoCartTest() {
WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

String wantedItem[] = { "PotAto", "  BEans ", " PisTA" }; 
											
List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));
for (int i = 0; i < elements.size(); i++) {
String itemInfo = elements.get(i).getText();
String array[] = itemInfo.split("-");
String itemInfo_formatted = array[0].toLowerCase().trim(); 
												
List<String> wantedItem_arraylist = Arrays.asList(wantedItem); 															
List<String> final_wantedItem_arraylist = wantedItem_arraylist.stream().map(s -> s.toLowerCase().trim())
.collect(Collectors.toList()); 
int counter = 0;
if (final_wantedItem_arraylist.contains(itemInfo_formatted)) 
													
{
driver.findElements(By.xpath("//button[text()= 'ADD TO CART']")).get(i).click(); 
//Since when 'ADD TO CART' is clicked on, the text of the button changes to 'ADDED', this causes the index of the text to be not that of it's own button
// The solution: Never use a text locator in the first place (it's the last resort EVER EVER) & let alone if the text changes when interacting (
// where in this case, text locator will not work anyway)
// with its associated element.

// Note: //button[contains(text(), 'ADD TO CART')] is a better option considering that a space(s) would be introduced in future infront and/or
// after the text.
// see if you can still use this locator as Explicit wait has a method of textMatches(By Locator, Pattern pattern)
																	
counter++;
if (counter == wantedItem_arraylist.size()) 
{
break; 
}
}
}

}
}
