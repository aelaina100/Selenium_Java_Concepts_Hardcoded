  package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//         *******************  These is an interview test case that's also to be run in debug mode so you can examine execution step by step *******************
//         *******************  Examine the following test cases that are going to be automated ***********************

// TC #1: 
// 1- On: https://rahulshettyacademy.com/seleniumPractise/#/
// 2- Add 'Potato' to cart.
/*****************************************************************************************************************/
//TC #2: 
//1- On: https://rahulshettyacademy.com/seleniumPractise/#/
//2- Add 'Potato', 'Beans, & 'Pisat'  to cart.
//3- In the checkout cart Ensure that item(s) is reflected correctly. 


                                              /* Conclusion:  
          * The common step is adding an item to cart. Hence, design a re-usable utility/ method that's to be used across these two testcases 
          * Instead of replicating the code twice which is not optimized way of coding as it's bad for maintenance.
          * 
          * But first, let's just automate these 2 test cases without desining the utility. Then, design the utility.          */
	
// TC# 1
public class Added18_Interview_AddingItemsIntoCart_debugMode {
	@Test(enabled = false) // keep it turned off. Run the optimized testcase below that uses the utility
	public void added18_TC1_AddingItemsIntoCartTest() {
		WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String wantedItem[] = { "PotAto" }; // Even if it contains one item (Potato), so that in future,
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
				driver.findElements(By.cssSelector("div.product-action button[type= 'button']")).get(i).click(); // Then use the index of the
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
	public class Added18_TC2_Interview_AddingItemsIntoCart_debugMode { // AN EXTREMELY IMPORTANT TEST CASE = Lots of coding/logic experienced gained !~
		@Test(enabled=false) // keep it turned off. Run the optimized testcase below that uses the utility
		public void added18_AddingItemsIntoCartTest() throws InterruptedException {
			WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

			String wantedItem[] = { "PotAto", "  BEans ", " PisTA" };

			List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));
			String itemInfo = null;
			List<String> wantedItem_arraylist = null;
			ArrayList<String> itemInfo_mainPage_selected= new ArrayList<String>();               // This is necessary for # 3 ONLY
			
			for (int i = 0; i < elements.size(); i++) {
				itemInfo = elements.get(i).getText();
				String array[] = itemInfo.split("-");
				String itemInfo_formatted = array[0].toLowerCase().trim();

				wantedItem_arraylist = Arrays.asList(wantedItem);
				List<String> final_wantedItem_arraylist = wantedItem_arraylist.stream().map(s -> s.toLowerCase().trim())
						.collect(Collectors.toList()); // This step is ONLY for converting to small letter & trimming of declared array elements above ONLY !.
				int counter = 0;
				if (final_wantedItem_arraylist.contains(itemInfo_formatted)) {
					driver.findElements(By.cssSelector("div.product-action button[type= 'button']")).get(i).click();
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
			//Assert.assertEquals(itemsInfo_previewCart,itemInfo_mainPage_selected );
				
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
    // so based on the above 2 testcases/ methods. we build the following utility
    private static ArrayList<String> itemInfo_mainPage_selected;
	public static void utility_addingItemsToCart(WebDriver driver, String wantedItem[]) 
	// void means not returning anything. Instead, an arraylist of type String is returned.
	{
		List<WebElement> elements = driver.findElements(By.cssSelector("h4.product-name"));
		//Added18_Interview_AddingItemsIntoCart_debugMode obj= new Added18_Interview_AddingItemsIntoCart_debugMode();
		
	    itemInfo_mainPage_selected= new ArrayList<String>(); // why ? TC#2 invokes such measure.
		for (int i = 0; i < elements.size(); i++) {
			String itemInfo = elements.get(i).getText();
			String array[] = itemInfo.split("-");
			String itemInfo_formatted = array[0].toLowerCase().trim(); 
																		
			List<String> wantedItem_arraylist = Arrays.asList(wantedItem); 		// Converting the array defined in the actual testcase, to an array list.											
			List<String> final_wantedItem_arraylist = wantedItem_arraylist.stream().map(s -> s.toLowerCase().trim())
					.collect(Collectors.toList()); 
			int counter = 0;
			if (final_wantedItem_arraylist.contains(itemInfo_formatted)) 
																			
			{
				driver.findElements(By.cssSelector("div.product-action button[type= 'button']")).get(i).click(); 
				itemInfo_mainPage_selected.add(itemInfo);// / why ? TC#2 invokes such measure.
																																									
				counter++;
				if (counter == wantedItem_arraylist.size()) 
				{
					break;
				} } 
		}}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
        @Test (enabled=false)
		public void tc1_Interview_AddingItemsIntoCart() throws InterruptedException // or: public static void main (String [] args) but only use TestNg compiler. otherwise, this method
		                                                	// won't be included in the testNg xml file.
		{
        	WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
    		driver.manage().window().maximize();
    		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    		 String wantedItem[] = { "PotAto" };
    		 utility_addingItemsToCart(driver, wantedItem);
    		 Thread.sleep(2000L);
    		 /* Above: Creating an object of this .java class file in order to access the utility method:===>
    		 Added18_Interview_AddingItemsIntoCart_debugMode ob= new Added18_Interview_AddingItemsIntoCart_debugMode();
    		 ob.utility_addingItemsToCart(driver, wantedItem);   */
    		 
    		 //Or instead, As done here, Call the method/utility directly (By assigning 'static' to this method/ utility).
		}

    		
        @Test (enabled=false)
		public void tc2_Interview_AddingItemsIntoCart() throws InterruptedException // or: public static void main (String [] args) but only use TestNg compiler. otherwise, this method                                              	// won't be included in the testNg xml file.
		{
      	WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
  		driver.manage().window().maximize();
  		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

  		 String wantedItem[] = { "PotAto", "MushrooM", "pIsTA" };
  		
  		utility_addingItemsToCart(driver, wantedItem);
  		
  		driver.findElement(By.cssSelector("img[alt= 'Cart']")).click();
		Thread.sleep(1000L); 
		List<WebElement> elements_previewCart = driver
				.findElements(By.cssSelector("div.cart-preview.active p.product-name"));
		
		Assert.assertEquals(elements_previewCart.size(), wantedItem.length,
				" FAILED: There is more than 1 product in basket");
		
		ArrayList<String> itemsInfo_previewCart= new ArrayList<String>();  
		
		for (int i=0; i< elements_previewCart.size(); i++) {
			itemsInfo_previewCart.add(elements_previewCart.get(i).getText());
		}
	    System.out.println(itemsInfo_previewCart); // debugging purposes.
	    System.out.println(itemInfo_mainPage_selected); // debugging purposes.
	    
		Assert.assertEquals(itemsInfo_previewCart,itemInfo_mainPage_selected);
			
		/*
		Assert.assertTrue(driver.findElement(By.cssSelector("div.cart-preview.active p.product-name")).getText()
				.toLowerCase().contains(itemInfo));
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div.cart-preview.active p.quantity")).getText().contains("1"),
				"FAILED: Quantity of '1' is NOT displayed next to the item");          */
		// I'd say, (& it's still scenario specific), only used hard assertions in here.
	}
  		 
        /*Now, TC#3:   // This is where real-time synchronization concept is introduced (Explicit wait)
         * 
         *  1- On: https://rahulshettyacademy.com/seleniumPractise/#/
         *  2- Add 'beetroot' to cart.
         *  3-Click on 'PROCEED TO CHECKOUT'
         *  4- Reach the GREENKART page, where you enter the promo code of 'rahulshettyacademy'
         *  5- Click on 'Apply'
         *  6- Where now, total final price should be deducted from.
         *  5- and message of 'promo code applied successfully' is displayed in the UI.
         *  6- Then, click on 'Place Order'           */
        
        @Test
        public void tc3_Interview_AddingItemsIntoCart() throws InterruptedException
        {
        	WebDriver driver = new ChromeDriver(); // Utilizing Selenium Manager
        	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
      		driver.manage().window().maximize();
      		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
      		String wantedItem[] = { "potato", "waLNuts", "brOcoLli"  };
      		
      		utility_addingItemsToCart(driver, wantedItem); 
    		//Crucial: An item is added to the cart ONLY WHEN <span class="cart-count">1</span> is created in the list of HTML codes
    		 //associated with elements on the web page.
    		  //Hence- After adding an item(s) & Before clicking on the basket icon, ensure that this occurs (Synchronization).
    		   // as code execution is extremely fast.
    				// 'span.cart-count' is the already in-console validated CSS Selector.
      		String promo= "rahulshettyacademy";
    		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.cart-count"))); //fails cuz locator is not 
    		 // associated with an element on the webpage. Instead, its a locator based on an attribute that appears in the list
    		  // of <HTML  code>'s as a result of interacting with an element in the UI
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.cart-count")));
    		driver.findElement(By.cssSelector("img[alt= 'Cart']")).click(); //clicks on the shopping cart image where item(s) has/have been added.
    		
    		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.cart-preview.active [type= 'button']")));
    		driver.findElement(By.cssSelector("div.cart-preview.active [type= 'button']")).click(); // clicks on 'proceed to checkout'
    		
    		// Now, get the text of the displayed 'Total After Discount' (Note: I've not applied discount yet).
    		
    		 // Wait till the box holding the number of 'Total After Discount' is visible on the screen. (Correct method ?)
    		  // Note: I looked for an explicit wait method that detects the presence of any text inside a web element. Nevertheless, it 
    		    // seems that such a method does not exist as of yet.
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.discountAmt")));
    		System.out.println(driver.findElement(By.cssSelector("span.discountAmt")).getText());   // debugging purposes
			double totalBeforePromo= Double.parseDouble(driver.findElement(By.cssSelector("span.discountAmt")).getText());
    		
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
    	    driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promo);   // enters a promo code.
    	    
    	    //When clicking on proceed to checkout/ refresh same page, one finds out that 'Apply' button is first disabled.
    	     // Now, even though the script is going to first enter a promo code and then click on 'Apply', the script will
    	       // still be too fast anyway that the 'Apply; button might still be disabled (That's how you make assumptions in test automation).
    	        // hence, ensure that 'Apply' button becomes enabled before clicking on it.
    		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.promoBtn")));  
    	    driver.findElement(By.cssSelector("button.promoBtn")).click();   // Clicks on 'Apply' (To apply promo code)
    	    
    		// Now- After applying promo code===> Get the text of the displayed 'Total After Discount' 
    	    
    	    // For synchronization: (After examining/ studying the UI behaviour and its associated HTML code)
    	     //Only as soon as "Code applied..!"  message appears, the updated 'Total After Discount' value appears.
    	      //Hence, will wait till the box holding such text becomes visible on the screen.
    	       // This explicit wait here can not be dispensed away with/ superceded by implicit wait.
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
    		System.out.println(driver.findElement(By.cssSelector("span.discountAmt")).getText()); // debugging purposes
    	    String x= driver.findElement(By.cssSelector("span.discountAmt")).getText(); 
    	    double totalAfterPromo= Double.parseDouble(x);
    	    
    	    Assert.assertTrue( totalBeforePromo > totalAfterPromo, "promo code not resulting in a reduced final price");
        }
     
		}
