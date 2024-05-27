package HardCoded_Examples.Selenium_Concepts_HighLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class G_RadioButton {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);  
		
		String x= "Some X value";
		System.out.println(x);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// print out, one by one, the names of the radio button displayed on the web page
		int count= driver.findElements(By.className("radioButton")).size();
		Thread.sleep(3000L);
		for (int i=0; i<count; i++)
		{
			 String nameOftext= driver.findElements(By.className("radioButton")).get(i).getText();
			 Thread.sleep(1000L);
			System.out.println(nameOftext);
		}
	
		
		/*
		driver.get("https://echoecho.com/htmlforms10.htm");
		Thread.sleep(3000L);
		driver.manage().window().maximize();
		

		
		
		// let's click on the 'Cheese' radio button
		int count= driver.findElements(By.name("group1")).size();
		for(int i=0; i<count;i++)
		{
			  driver.findElements(By.name("group1")).get(i).click();
			  String food = driver.findElements(By.name("group1")).get(i).getText();
			 System.out.println(food);
			
		}
*/
	}

}
