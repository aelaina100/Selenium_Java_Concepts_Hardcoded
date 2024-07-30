package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class E_RadioButton {

	@Test
	public void E_radioButtonException() throws InterruptedException
	{
		
		// https://echoecho.com/htmlforms10.htm
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		
		driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.get("https://echoecho.com/htmlforms10.htm");
		Thread.sleep(2000L);
		
		// Below: Scrolling down
		   // Crucial Note: arguments[0].scrollIntoView() will not work for a list of WebElements 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element= driver.findElement(By.name("group2"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		
		// 1- click on, one by one, the radio buttons of water, beer, & wine
		int count= driver.findElements(By.name("group2")).size();
		for (int i=0; i<count; i++)
		{
			driver.findElements(By.name("group2")).get(i).click();
			Thread.sleep(2000L);     //since radio buttons are clicked very fast.
		}
				
		
		// 2- click on, one by one, the radio buttons of Milk, butter, & cheese
		int sec_count = driver.findElements(By.name("group1")).size();
		for (int i=0; i<sec_count; i++)
		{
			driver.findElements(By.name("group1")).get(i).click();
			Thread.sleep(2000L);     //since radio buttons are clicked very fast.
		}
		
		// 3- click on, one by one, All of the 6 radio buttons: Milk, butter, cheese, water, beer, & wine
        Thread.sleep(5000L);
		int third_count= driver.findElements(By.xpath("//a[text()='<< PREVIOUS']//parent::td/parent::tr/parent::tbody/parent::table/parent::td/parent::tr/parent::tbody/parent::table/preceding-sibling::table[1]/tbody/tr/td/table/tbody/tr/td/input")).size();
		for (int i=0; i<third_count; i++)
		{
			driver.findElements(By.xpath("//a[text()='<< PREVIOUS']//parent::td/parent::tr/parent::tbody/parent::table/parent::td/parent::tr/parent::tbody/parent::table/preceding-sibling::table[1]/tbody/tr/td/table/tbody/tr/td/input")).get(i).click();
		
		} 
	}

}
