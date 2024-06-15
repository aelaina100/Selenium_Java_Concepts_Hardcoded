package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//https://chercher.tech/practice/frames-example-selenium-webdriver

public class W_countingFrames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);    
		
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		int count= driver.findElements(By.tagName("iframe")).size(); // count the number of OUTER frames.
		System.out.println("Number of OUTER frames are: " + count);
		
		//Below: To count the number of inner frames
		int counter= 0;
		for (int i=0; i<count; i++)
		{
			driver.switchTo().frame(i);
			int count_inner_frames = driver.findElements(By.tagName("iframe")).size();
			System.out.println("	For frame # " +i+ ", Inside of it, there are: " +count_inner_frames+ " frames");
			driver.switchTo().defaultContent();
			
		    counter = counter + count_inner_frames ;  //counter =count_inner_frames+0; is wring ! figure out why
		}
		
		System.out.println("	Total Number of inner frames for all outer frames are: "+ counter );
	}

}
