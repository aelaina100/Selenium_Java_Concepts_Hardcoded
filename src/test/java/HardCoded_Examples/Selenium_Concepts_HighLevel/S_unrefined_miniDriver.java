package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S_unrefined_miniDriver {

	public static void main(String[] args) throws InterruptedException {
		// On: https://www.rahulshettyacademy.com/AutomationPractice/
// 1- Count the total number of links on the web page.
// 2- Count the number of links in the footer section only.	
// 3- Count the  number of links in the 1st vertical section of the footer section.
// 4- Count the  number of links in the 2nd vertical section of the footer section.
// 5- Count the  number of links in the 3rd vertical section of the footer section.
// 6-  Count the  number of links in the 4th  vertical section of the footer section.
// 7- In the footer section, count the number of Links sharing a bigger font.
// 8- In the footer section: Click on each link and get their respective page title.
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		//1-
		int totalNumberLinks= driver.findElements(By.tagName("a")).size();
		System.out.println("Total number of links on the webpage is:         " + totalNumberLinks);
		//2-
		WebElement footerSection= driver.findElement(By.id("gf-BIG"));
		//Below: I'll limit the scope of the webdriver from the entire page, to that section of the webpage by creating a mini driver.
		 //This mini driver will only be for that footer section. It's 100 % limited to that footer section ONLY.
		   //So I have 'driver' which has an excess to ALL & EVERY single element on the entire webpage ( Including the footer section off course.
		     // Mini driver 'footerSection'  has access to all & each elements that are inside the footer section ONLY.
		       //Note: Now, any of thee webdrivers 'driver' & 'footerSection' can be used anytime when applicable. There is no such thing as 
		          // 'switching between then'.
		
		int footerNumberLinks= footerSection.findElements(By.tagName("a")).size();
		System.out.println("Number of Links in the footer section only is:   " + footerNumberLinks );
		System.out.println("====================================================================");
		
		//3-
		int FirstSection_numberOfLinks= footerSection.findElements(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[1]/ul/li")).size(); 
		// 'footerSection' mini driver,can be replaced by 'driver' Since locator above is unique( with attribute 'id' being unique off course !)
		System.out.println("	Footer 1st Section's number of links is: " + FirstSection_numberOfLinks);
		//4-
		int SecondSection_numberOfLinks= footerSection.findElements(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[2]/ul/li")).size();
		System.out.println("	Footer 2nd Section's number of links is: " + SecondSection_numberOfLinks);
		//5-
		int ThirdSection_numberOfLinks= footerSection.findElements(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[3]/ul/li")).size();
		System.out.println("	Footer 3rd Section's number of links is: " + ThirdSection_numberOfLinks);
		//6- 
		int FourthSection_numberOfLinks= footerSection.findElements(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[4]/ul/li")).size();
		System.out.println("	Footer 4th Section's number of links is: " + FourthSection_numberOfLinks);
		//7- 
		int footerFirstLinks_bigFont =driver.findElements(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td/ul/li/h3")).size();
		System.out.println("	The number of Footer links sharing a big font is: " + footerFirstLinks_bigFont);
		System.out.println("====================================================================");
		
		//8-  Additional: later on, try to click on every single link on the webpage (Hint: some are clickable)
		Actions a =new Actions(driver);
		
		for (int i=0; i< footerNumberLinks; i++)
		{
			WebElement footerLink= footerSection.findElements(By.tagName("a")).get(i);
			a.moveToElement(footerLink).keyDown(Keys.CONTROL).click().build().perform();	
		}
		
		Set<String> ids= driver.getWindowHandles();
	    Iterator<String> it= ids.iterator();
	    it.next();  // So that next iteration and so on, only gets the titles of links/ Not that of the parent page as well
	    int count=0;
	
	    while(it.hasNext())
	    {   
	    	count=count+1;
	    	String windowHandleId= it.next();
	    	driver.switchTo().window(windowHandleId);
	    	String pageTitle= driver.getTitle();
	    	System.out.println("Page Title is: " + "[" + pageTitle + "]" + " for link number: " +count);
	    	//driver.switchTo().defaultContent(); 
	    	//The very above line is meaningless. The output would be the same. Doesn't effect the position of the iterating object 'it'.
	    }
		driver.quit();
	}

}
