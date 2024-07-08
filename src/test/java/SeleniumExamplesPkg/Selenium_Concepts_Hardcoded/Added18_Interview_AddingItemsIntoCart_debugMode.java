package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// TC #1: This is an interview question.																	
// On: https://rahulshettyacademy.com/seleniumPractise/#/
// Add 'Potato' to cart
// Imperatively essential: Run in debug mode, so you can see execution step by step.

public class Added18_Interview_AddingItemsIntoCart_debugMode {
	@Test
	public void added18_AddingItemsIntoCartTest() {
		WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String wantedItem[] = { "PotAto", "  BEans ", " PisTA" }; // Even if it contains one item, so that in future,
																	// you can add more to cart. Correct practice !
		
		// Above side note: since QA may enter the name with capital/small letters and/or spaces, then ==>
		//converting to lower case & trimming of array elements are
		// stream methods of the arraylist
		// create an example under Java oop project and that of streams.
		List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < elements.size(); i++) {
			String itemInfo = elements.get(i).getText();
			String array[] = itemInfo.split("-");
			String itemInfo_formatted = array[0].toLowerCase().trim(); // Trims all spaces whether in the front or at
																		// the end of a string.
			// Above line: This line & the one below where arrayList is made stream
			// compatible, cancels out the case sensitivity issue.

			List<String> wantedItem_arraylist = Arrays.asList(wantedItem); // Converting the array into an arraylist as
																			// '.contains' is an arraylist method
			List<String> final_wantedItem_arraylist = wantedItem_arraylist.stream().map(s -> s.toLowerCase().trim())
					.collect(Collectors.toList());
			// Above: To cancel out the case sensitivity issue and any spaces included for
			// the items in the declared array above.
			int counter = 0;
			if (final_wantedItem_arraylist.contains(itemInfo_formatted)) // .contains() is always better than
																			// .equalsTo()
			{
				driver.findElements(By.cssSelector("div.product-action")).get(i).click(); // Then use the index of the
																							// text to click on the
																							// button of 'Add to cart'
				counter++;
				if (counter == wantedItem_arraylist.size()) // or counter == wantedItem.length
				{
					break; // As soon as the last item is added to cart, exit the 'for loop'.
				}
			}
		}

	}
	
	
	
	
	// Now, run the above method (test case) in debug mode ( of supreme importance)

	@Test(enabled = false) // Keep it turned off, as this is a primitive way of designing the above mentod/
							// testcase
							// [here only 1 item can be added to the cart]
							// The correct way is to include the wanted item in an array (Even if only one
							// item
							// is in the array ! so that in future you can add another item(s))
	public void Added18_primitive_AddingItemsIntoCartTest() throws InterruptedException { // Prerequisite: ENSURE
																							// familiarity with
		// the UI from the moment an item is
		// TC // added to cart, to that of checkout.
		// On: https://rahulshettyacademy.com/seleniumPractise/#/
		// Add 'Potato' to cart.
		// In the checkout cart Ensure that item is reflected correctly. (high level
		// locator strategy)
		// Don't proceed further. End of testcase.
		WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String productInfo = null;
		String wantedProduct = "Potato".toLowerCase();
		int count = driver.findElements(By.cssSelector("h4.product-name")).size();
		for (int i = 0; i < count; i++) {
			productInfo = driver.findElements(By.cssSelector("h4.product-name")).get(i).getText().toLowerCase();
			if (productInfo.contains(wantedProduct)) {
				driver.findElements(By.xpath("//div[@class= 'product-action']/button")).get(i).click();
				break;
			}
		}
		// Validations: Ensure youy're familiar with the UI first ==================>
		/*
		 * Now verify that: 1- Only 1 item is added to the cart. 2- it's the correct
		 * item. 3- Its count =1
		 */
		Thread.sleep(1000L); // As the cart could be disabled before it contains the item (Script is too
								// fast)
		driver.findElement(By.cssSelector("img[alt= 'Cart']")).click();
		Thread.sleep(1000L); // It takes time for the cart to open up, let alone loading the item inside it
		// div.cart-preview.active p.product-name // Identifies the box holding the text
		// of product info.
		// The only UNIQUE locator.
		Assert.assertEquals(driver.findElements(By.cssSelector("div.cart-preview.active p.product-name")).size(), 1,
				" FAILED: There is more than 1 product in basket");
		Assert.assertTrue(driver.findElement(By.cssSelector("div.cart-preview.active p.product-name")).getText()
				.toLowerCase().contains(productInfo));
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div.cart-preview.active p.quantity")).getText().contains("1"),
				"FAILED: Quantity of '1' is NOT displayed next to the item");
		// I'd say, (& it's still scenario specific), only used hard assertions in here.
	}

	// TC #2
	// On: https://rahulshettyacademy.com/seleniumPractise/#/
	// Add 'Potato' & 'Apple' to cart

}
