package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import java.util.ArrayList;
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
	@Test(enabled = false)
	public void added18_TC1_AddingItemsIntoCartTest() {
		WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String wantedItem[] = { "PotAto", "  BEans ", " PisTA" }; // Even if it contains one item, so that in future,
																	// you can add more to cart. Correct practice !

		// Above side note: since QA may enter the name with capital/small letters
		// and/or spaces, then ==>
		// converting to lower case & trimming of array elements are
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
					.collect(Collectors.toList()); // This step is ONLY for converting to small letter & trimming of declared array elements above ONLY !.
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	// TC #2:
	// 1- On: https://rahulshettyacademy.com/seleniumPractise/#/
	// Add 'Potato' to cart
	// 2- In the checkout cart Ensure that item is reflected correctly. (high level
	// locator strategy)
	// Don't proceed further. End of testcase.

	public class Added18_TC2_Interview_AddingItemsIntoCart_debugMode { // AN EXTREMELY IMPORTANT TEST CASE = Lots of coding/logic experienced gained !~
		@Test
		public void added18_AddingItemsIntoCartTest() throws InterruptedException {
			WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

			String wantedItem[] = { "PotAto", "  BEans ", " PisTA" };

			List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));
			String itemInfo = null;
			List<String> wantedItem_arraylist = null;
			ArrayList<String> itemInfo_mainPage_selected= new ArrayList<String>();               // This is necessary for # 2 ONLY
			
			for (int i = 0; i < elements.size(); i++) {
				itemInfo = elements.get(i).getText();
				String array[] = itemInfo.split("-");
				String itemInfo_formatted = array[0].toLowerCase().trim();

				wantedItem_arraylist = Arrays.asList(wantedItem);
				List<String> final_wantedItem_arraylist = wantedItem_arraylist.stream().map(s -> s.toLowerCase().trim())
						.collect(Collectors.toList()); // This step is ONLY for converting to small letter & trimming of declared array elements above ONLY !.
				int counter = 0;
				if (final_wantedItem_arraylist.contains(itemInfo_formatted)) {
					driver.findElements(By.cssSelector("div.product-action")).get(i).click();
					itemInfo_mainPage_selected.add(itemInfo);                                 //debugging purposes only

					counter++;
					if (counter == wantedItem_arraylist.size()) {
						break;
					}
				}
			}
			
			System.out.println(itemInfo_mainPage_selected);                                 //debugging purposes only.
			// 2- Verify the correct 1 item is added to the cart:
			Thread.sleep(1000L); // As cart maybe disabled before it contains the item (Script is too fast
			driver.findElement(By.cssSelector("img[alt= 'Cart']")).click();
			Thread.sleep(1000L); // It takes time for the cart to open up, let alone loading the item inside it
			// div.cart-preview.active p.product-name // Identifies the box holding the text
			// of product info
			// It's the only unique locator [ALWAYS dig for a unique locator]
			
			//2 below: Checking the number(s) of the added item(s) to cart.
			List<WebElement> elements_previewCart = driver
					.findElements(By.cssSelector("div.cart-preview.active p.product-name"));
			Assert.assertEquals(elements_previewCart.size(), wantedItem_arraylist.size(),
					" FAILED: There is more than 1 product in basket");
			
			// 2 below: checking that the added item(s) is/are the correct one(s)  SEE IF YOU CAN OPTIMIZE this validation WITH STREAMS !
			ArrayList<String> itemsInfo_previewCart= new ArrayList<String>();  
			//Didn't create an array and then converted it to an ArrayList as soon as needed, becasue the array created would be empty(My discretion ! check again !)
			for (int i=0; i< elements_previewCart.size(); i++) {
				itemsInfo_previewCart.add(elements_previewCart.get(i).getText());
			}
		    System.out.println(itemsInfo_previewCart); // debugging purposes.
			Assert.assertEquals(itemsInfo_previewCart,itemInfo_mainPage_selected );
				

			/*
			Assert.assertTrue(driver.findElement(By.cssSelector("div.cart-preview.active p.product-name")).getText()
					.toLowerCase().contains(itemInfo));
			Assert.assertTrue(
					driver.findElement(By.cssSelector("div.cart-preview.active p.quantity")).getText().contains("1"),
					"FAILED: Quantity of '1' is NOT displayed next to the item");          */
			// I'd say, (& it's still scenario specific), only used hard assertions in here.
		}

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
