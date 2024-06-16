package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.testng.annotations.Test;

public class Added_10_assertions {
    
	@Test
	public void assetionsTest()
	{
		
	//Assertions is a feature of Testng or J-Unit frameworks.
	//With every TestNg release, some are modified. [Provide a link here]
   //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
// Crucial: Even with Assertions there is a room for optimization ====> Compare the 2 lines of code below:
		
	//Assert.assertTrue( driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected(), "Checkbox of 'Family and Friends' is NOT selected.");
	//Assert.assertEquals(driver.findElement(By.cssSelector("input[id*= 'friendsandfamily']")).isSelected(), true, "Checkbox of 'Family and Friends' is NOT selected.");
		
	//As you can see- 2nd line is noticeably more optimized than the 1st one
		//Besides- We're working with Boolean values to start with. Hence, 1 st line is to thought of first and foremost.
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		


		
		
		
		
		
		
		

	}

}
