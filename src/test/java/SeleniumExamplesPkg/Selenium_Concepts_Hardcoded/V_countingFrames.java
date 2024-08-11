package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker

// To count the the outer and inner frames on a given page.(not inner frames inside inner frames)
  // CRUCIAL: this example is to illustrate to you that  even though you will acquire the total number of outer frames, but you would eventually get a 
//complier error, this is because some of these outerframes are simply </iframe>..I believe this is the case.
public class V_countingFrames {
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
		
		int count= driver.findElements(By.tagName("iframe")).size(); // count the number of OUTER frames.
		System.out.println("Number of OUTER frames are: " +count);
		
		//Below: To count the number of inner frames
		int counter= 0;
		for (int i=0; i<count; i++)
		{
			driver.switchTo().frame(i);
			int count_inner_frames = driver.findElements(By.tagName("iframe")).size();
			System.out.println("	For frame # " +i+ ", Inside of it, there are: " +count_inner_frames+ " frames");
			driver.switchTo().defaultContent();
			
		    counter =count_inner_frames+0;
		}
		
		System.out.println("	Total Number of inner frames for all outer frames are: "+ counter );

	}

}
