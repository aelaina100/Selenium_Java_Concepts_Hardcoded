package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C_SalesForce {

	

	@Test
	public void academyTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys("rahul");

		driver.findElement(By.name("inputPassword")).sendKeys("hello123");

		driver.findElement(By.className("signInBtn")).click();  //     <button class="submit signInBtn" type="submit">Sign In</button> 

		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // or user a class Locator. Insdtructor here is showing us diff. locators.

		driver.findElement(By.linkText("Forgot your password?")).click();

		//Thread.sleep(1000);//

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John"); // or CSS selector instead. here Instructor is trying to show as many locator types as possible.

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //or CSS selector instead. here Instructor is trying to show as many locator types as possible.

		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253"); // or CSS Selector. Here, instructor wants to show the Parent-to-Child xpath technique of the TagName type.

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); // or etc. etc. Once again, instructor wants to show you as many techniques as possible in this single testcase.

		System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // or etc. etc. as etc.
        
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); 
		//etc. etc. besides, the portion:' /button ' will work too. But, its better to use /button[1] as the compiler may 'get confused' since there is button[2]
        // Above: The value of the class attribute above is too long. Use regular expressions instead, rendering
		// 'forgot-pwd' as the constant (fixed) substring.
		
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John"); // or CSS selector instead. here Instructor is trying to show as many locator types as possible.

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.id("chkboxOne")).click();

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		//Above:  <button class="submit signInBtn" type="submit">Sign In</button>
		//Assuming that the 'signInBtn' portion keeps on changing upon refreshing the page or once every while.
	}
	

	
	@Test(enabled=false)
	public void C_SalesForceTest()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=ca");
		
		//Below line is to enter username
		driver.findElement(By.id("username")).sendKeys("RandomUserName");
		
		// The below line will return an error of: Compound classes are not accepted.
		//driver.findElement(By.className("input r4 wide mb16 mt8 username")).sendKeys("SomeRandottyyytte");
		
		//However; As a fix, the line below works well
		//driver.findElement(By.cssSelector("input.input.r4.wide.mb16.mt8.username")).sendKeys("USERBBBBBBB");
		
		// or even the below line:
		//driver.findElement(By.xpath("//input[@class= 'input r4 wide mb16 mt8 username'] ")).sendKeys("USERNAMMMMAEE");
		
		// But once again the id is to be used first and foremost ( The other locator techniques above are for demonstrational purposed ONLY)
		
		//Below line is to enter the password 
		driver.findElement(By.id("password")).sendKeys("Password");
		
		//below line is to click on the login button
		driver.findElement(By.id("Login")).click();

	}

}
