package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Added21_synchroAssig {
	
	@Test
	public void synchroAssigTest()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	}

}
