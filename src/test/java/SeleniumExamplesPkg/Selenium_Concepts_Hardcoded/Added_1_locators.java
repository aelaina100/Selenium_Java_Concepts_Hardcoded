package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Added_1_locators {

	// First Testcase:
	@Test(enabled=false)
	public void academyTest() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String name = "Ahmad";
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(name); // enters a username (Could be anything)

		driver.findElement(By.name("inputPassword")).sendKeys("hello123"); // enters invalid password (correct password is: rahulshettyacademy)

		driver.findElement(By.className("signInBtn")).click();  //     <button class="submit signInBtn" type="submit">Sign In</button> 
        // Above: Clicks on 'SIGN IN' button
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // or user a class Locator. Insdtructor here is showing us diff. locators.
         // Above: Identifies the box holding the text, and then displaying that text onto the screen " *Incorrect username & password"
		driver.findElement(By.linkText("Forgot your password?")).click();
        // Above: clicks on "Forgot your password ?" link
		//Thread.sleep(1000);//

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name); // or CSS selector instead. here Instructor is trying to show as many locator types as possible.
        // Above: In the 'Forgot password' display, enter username
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        // Above: Then, enters email
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //or CSS selector instead. here Instructor is trying to show as many locator types as possible.
       // Above: then clears this email.
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
       // ABove: Then, re-enters this email
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253"); // or CSS Selector. Here, instructor wants to show the Parent-to-Child xpath technique of the TagName type.
      // ABove: Then, enters phone number
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); // or etc. etc. Once again, instructor wants to show you as many techniques as possible in this single testcase.
      // Above: then clicks on 'reset Login'
		System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // or etc. etc. as etc.
      // Above: identifies the box holding the text, and then displaying it onto the screen "Please use temporary.."
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); 
		// Above: clicks on 'Go to Loggin' button
		//etc. etc. besides, the portion:' /button ' will work too. But, its better to use /button[1] as the compiler may 'get confused' since there is button[2]
        // Above: The value of the class attribute above is too long. Use regular expressions instead, rendering
		// 'forgot-pwd' as the constant (fixed) substring.
		
		//Thread.sleep(1000);
		// Now- we are back on the 'Sign in' view
		//driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John"); // or CSS selector instead. here Instructor is trying to show as many locator types as possible.
        // Above: identifies username field and enters text
		//driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
         // Above: In the 'sign in' view, enter correct username (Could be anything)
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); // utilizing regular expression
		// Above: In the 'sign in' view, enter the correct password as indicated.
		
// BELOW CRUCIAL: sometimes, not always, when NOT including a wait for the codeline below, then
 // the following message appears:  
// "element click intercepted: Element <input type="checkbox" id="chkboxOne" name="chkboxOne" value="rmbrUsername">
//is not clickable at point (274, 354). Other element would receive the click: 
		//<label for="chkboxOne">...</label>"
		
		// Meaning: other element is getting clicked.
		  //This is due to the fact that: As the view is transitioning
		   //from "Forgot password" to that of "sign in", controller is identifying and clicking
		    //on an element present in initial the view of "Forgot password". Hence, a fluent wait
		     // of 1 second is to be introduced. But, in real time an explicit wait is used ONLY so try
		      // that with an explicit wait.
		Thread.sleep(1000L);
		driver.findElement(By.id("chkboxOne")).click();
		// above: clicks on the checkbox of: 'remember my username'

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();  
		//Above: clicks on the 'SIGN In' button
		//Above:  <button class="submit signInBtn" type="submit">Sign In</button>
		//Assuming that the 'signInBtn' portion keeps on changing upon refreshing the page or once every while.
		
		
	// BELOW CRUCIAL: Without including a wait for the below line of code, the text will be acquired from the 
		 //previous view of 'Sign In'page, as it seems that clicking on 'Sign in" will take sometime before
		  // this page even begins to load the next one. And as you know, the controller is much faster. So as
		   // a result, once again, a text from the 'Sign in' page is the one gotten instead.
		    // this is also why, you notice that execution of testcase ends before the next page even appears.
		 
		Thread.sleep(1000L);  // Once again, replace it with explicit wait. 
		System.out.println(driver.findElement(By.tagName("p")).getText());
		//Above: to display the text of "You are successfully logged in"

		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        //Above: Ensuring the message "Hello + username login " is displayed
		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // Nevr use this locator EVER unless it's the last choice.
        // Above: Clicks on the 'LOG OUT' button
		
		Thread.sleep(2000L);
		driver.close();
		
		// CRUCIAL CONCLUSION: Whenever you're trying to locate an element, or transitioning from a page to the next or from a view to another: ==>
		  // You ALWAYS include a wait before you even debug/run your method for the 1st time. You don't wait till your script throw an error, so that you can include 
		    // waits. This is the wrong way of thinking as an error thrown for not including a wait doesn't always persist.
		       // The wait to include is EXPLICIT wait ONLY. You should NOT use implicit & explicit waits together. Fluent wait is NOT to be used unless for
		         // very specific scenarios such as Captcha as elaborated in notes.
	}
	
   // Second TestCase (IMPORTANT):
	 //Scenario ==> on "https://rahulshettyacademy.com/locatorspractice/"
		//1- Click on "Forgot your password?"
	    //2- In the 'Forgot password' window, fill out the details
	    //3- Click on 'RESET LOGIN'
	    //4- In the same window, notice this message "Please use temporayy password 'xxxx' to Login"
			// Now- copy this password in order to use it to sign in [ As it may change/ keeps on changing everytime]
	// As this is the correct way instead of harcoding the password.
	@Test
	public void getPasswordDynamically() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String name = "Ahmad";
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
        // Above: clicks on "Forgot your password ?" link
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name); 
        // Above: In the 'Forgot password' display, enter username
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        // Above: Then, enters email
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253"); 
       // ABove: Then, enters phone number
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); 
       // Above: then clicks on 'reset Login'
		
		String reset_pwd_msg= driver.findElement(By.className("infoMsg")).getText();
		System.out.println(reset_pwd_msg);
		
		String arry[]= reset_pwd_msg.split("'"); // splits based on ALL single quotes in the String
		System.out.println(arry[0]);
		System.out.println(arry[1]);
		System.out.println(arry[2]);
		
		String password= arry[1].trim(); // in case that future white space(s) are introduced.
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); 
		// Above: clicks on 'Go to Loggin' button
		Thread.sleep(1000L);
		driver.findElement(By.id("inputUsername")).sendKeys(name); // enters a username (Could be anything)

		driver.findElement(By.name("inputPassword")).sendKeys(password); // enters invalid password (correct password is: rahulshettyacademy)
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
	}
	
	
	//Third Testcase:
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
