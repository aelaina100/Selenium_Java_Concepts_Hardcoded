package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T_datePicker {
	//1 -From calender, Select today's date
	//2- Adate with 5 months ahead with the day being '10'
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		//Thread.sleep(6000L);
		
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		WebElement frameOfDate= driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
		driver.switchTo().frame(frameOfDate);
		//1- 
		driver.findElement(By.id("datepicker")).click();  // locates the 'date' field and clicks on it so that caleder opens up.
		driver.findElement(By.cssSelector("a[class*= 'state-highlight']")).click(); // using regular expressions.
		
//Crucial note: the above for #1 is fine 100 percent !:
  //. However; In this SPECIFIC case- today's date will have an associated <HTML code> where the attribute of class will have an additional 
	 //text ( for example any other day will have: class= ''ui-state-default'' whereas today's date will have,
		// class= "ui-state-default ui-state-highlight ui-state-active".
		  // so let's do a for-loop that iterates throughout the days where each iteration gets the value of the attribute 'class'
		    // and if this attribute contains the additioanl text, the select the date that is associated with such HTML code.
		      // this is done in the next .java file 
		
		//2
		driver.findElement(By.id("datepicker")).click();  // locates the 'date' field and clicks on it so that caleder opens up.
		
		int months_Ahead = 5;
		for(int i=0; i< months_Ahead ; i++) // click on the Next button 5 times
		{
			driver.findElement(By.cssSelector("a[data-handler= 'next']")).click();
		}
		
		// to select the day of '10'
		
		int count= driver.findElements(By.cssSelector("ui-state-default")).size();
		
		for (int i=0; i<count; i++)
		{
			String day= driver.findElements(By.cssSelector("ui-state-default")).get(i).getText();
			if(day.equalsIgnoreCase("10"))
			{
				driver.findElements(By.cssSelector("ui-state-default")).get(i).click();
				break;
				
			}
			else
			{
				continue;
			}
			
	
			}
			
		}

	}


