package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

       public class I1_HTTPS_Certifications {
	   public static void main(String[] args) {
		/*
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver(); 
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());  
		// without bypassing the certification error, one gets the WRONG title ( " Privacy error").
		 // so, we need to set a particular behaviour of the browser by utilizing the chromeOptions() class  */
	
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true); // pass 'true' to argument so certification is bypassed.
		// and for firefox, same concept applies.
		FirefoxOptions option1= new FirefoxOptions();
		option1.setAcceptInsecureCerts(true);
		
	    // and for edge as well
		EdgeOptions option2= new EdgeOptions();
		option2.setAcceptInsecureCerts(true);
		
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver(options); // pass the object with such capability as an argument.
		driver.get("https://expired.badssl.com/");  // Now, I'll land on the actual site after bypassing the certification
		System.out.println(driver.getTitle());   // Now, correct title should be displayed
		

	}

}
