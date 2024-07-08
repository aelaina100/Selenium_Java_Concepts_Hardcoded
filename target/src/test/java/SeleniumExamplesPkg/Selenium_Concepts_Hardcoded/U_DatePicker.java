package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//1 -From calender, Select today's date

public class U_DatePicker {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		//Thread.sleep(6000L);
		
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		WebElement frameOfDate= driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
		driver.switchTo().frame(frameOfDate);
		driver.findElement(By.id("datepicker")).click();  // locates the 'date' field and clicks on it so that caleder opens up.
		
	//1- //driver.findElement(By.cssSelector("a[class*= 'state-highlight']")).click(); // using regular expressions.

		
//Crucial note: the above for #1 (That is commented out) is fine 100 percent !:
  //. However; In this SPECIFIC case- today's date will have an associated <HTML code> where the attribute of class will have an additional 
	 //text ( for example any other day will have: class= ''ui-state-default'' whereas today's date will have,
		// class= "ui-state-default ui-state-highlight".
		  // so let's do a for-loop that iterates throughout the days where each iteration gets the value of the attribute 'class'
		    // and if this attribute contains the additioanl text, the select the date that is associated with such HTML code.
		      // this is done in the next .java file.
		
		int count= driver.findElements(By.cssSelector("a.ui-state-default")).size();
		for (int i=0; i<count; i++)
		{
			String valueOf_ClassAttribute= driver.findElements(By.cssSelector("a.ui-state-default")).get(i).getAttribute("class");
			//System.out.println(valueOf_ClassAttribute);
			if(valueOf_ClassAttribute.contains("ui-state-highlight"))
              {
				driver.findElements(By.cssSelector("a.ui-state-default")).get(i).click();
				break;
              }
			
			else
			{
				continue;
				
			}
			}
		
		
		}
		
         
	}


