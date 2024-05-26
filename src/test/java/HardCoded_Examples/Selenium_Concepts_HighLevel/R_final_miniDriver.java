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

public class R_final_miniDriver {

	public static void main(String[] args) throws InterruptedException {
		// On: https://www.rahulshettyacademy.com/AutomationPractice/
		// 1- Count the total number of links on the web page.
		// 2- Count the number of links in the footer section only.
				
		// 3- Count the  number of links in the 1st vertical section of the footer section.
		// 4- Count the  number of links in the 2nd vertical section of the footer section.
		// 5- Count the  number of links in the 3rd vertical section of the footer section.
		// 6- Count the  number of links in the 4th  vertical section of the footer section.

		// 7- In the footer section, count the number of Links sharing a bigger font.

		// 8- In the footer section: Click on each link and get their respective page title.
		// 9- Find out which links are 'brocken', if any (Solved in J1_BrockenLinksDetection.java )
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");	
		//1- 
		int count_totalLink= driver.findElements(By.tagName("a")).size();
		System.out.println(" 1- Total number of links on the entire page is: "+  count_totalLink );
		//2-
		WebElement footerSec_box_element= driver.findElement(By.id("gf-BIG"));
		//Below: I'll limit the scope of the webdriver from the entire page, to that section of the webpage by creating a mini driver.
		 //This mini driver will only be for that footer section. It's 100 % limited to that footer section ONLY.
		   //So I have 'driver' which has an excess to ALL & EVERY single element on the entire webpage ( Including the footer section off course.
		     // Mini driver 'footerSection'  has access to all & each elements that are inside the footer section ONLY.
		       //Note: Now, any of thee webdrivers 'driver' & 'footerSection' can be used anytime when applicable. There is no such thing as 
		          // 'switching between them'.
		int count_numberLinks_footerSec= footerSec_box_element.findElements(By.tagName("a")).size();
		System.out.println(" 2- Number of links in the footer section only is: " + count_numberLinks_footerSec );
		//3-
		WebElement firstSec_of_footerSec_box_element= footerSec_box_element.findElement(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[1]"));
		int count_numberLinks_firstSection_of_footerSec= firstSec_of_footerSec_box_element.findElements(By.tagName("a")).size();
		System.out.println(" 3- In the 1st section of the footer section, number of links is: " + count_numberLinks_firstSection_of_footerSec);
		//4-
		WebElement secondSec_of_footerSec_box_element= footerSec_box_element.findElement(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[2]"));
		int count_numberLinks_secondSec_of_footerSec =secondSec_of_footerSec_box_element.findElements(By.tagName("a")).size();
		System.out.println(" 4- In the 2nd section of the footer section, number of links is: " + count_numberLinks_secondSec_of_footerSec);	
		//5-
		WebElement thirdSec_of_footerSec_box_element= footerSec_box_element.findElement(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[3]"));
		int count_numberLinks_thirdSec_of_footerSec= thirdSec_of_footerSec_box_element.findElements(By.tagName("a")).size();
		System.out.println(" 5- In the 3rd section of the footer section, number of links is: " + count_numberLinks_thirdSec_of_footerSec);	
		//6-
		WebElement fourthSec_of_footerSec_box_element= footerSec_box_element.findElement(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td[3]"));
		int count_numberLinks_fourth_Sec_of_footerSec= fourthSec_of_footerSec_box_element.findElements(By.tagName("a")).size();
		System.out.println(" 6- In the 4th section of the footer section, number of links is: " + count_numberLinks_fourth_Sec_of_footerSec);
		//7-
		int count_numberLinks_bigFont_of_footerSec= footerSec_box_element.findElements(By.xpath("//div[@id= 'gf-BIG']/table/tbody/tr/td/ul/li/h3/a")).size();
		System.out.println(" 7- Number of Links with Big Font in the footer section is:       " + count_numberLinks_bigFont_of_footerSec);
		//8-
		Actions a= new Actions(driver);
		for(int i=0; i<count_numberLinks_footerSec; i++)
		{
		//System.out.println("Iteration i #: "+ i);
		a.moveToElement(footerSec_box_element.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
	
		Set<String> ids= driver.getWindowHandles();
		Iterator <String> it= ids.iterator();
		it.next();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(" Title of the page is:  " + driver.getTitle());	
			//driver.switchTo().defaultContent(); 
	    	//The very above line is meaningless. The output would be the same. Doesn't effect the position of the iterating object 'it'.
		}
	    driver.quit();
	   
	}
}
