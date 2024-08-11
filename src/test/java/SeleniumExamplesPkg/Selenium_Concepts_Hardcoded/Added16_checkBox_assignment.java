package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Added16_checkBox_assignment {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
 
		        WebDriver driver = new ChromeDriver(); 		

				driver.get("https://demoqa.com/books");

				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
;
				

				driver.findElement(By.id("login")).click();

				System.out.println("Click on Login link: " + driver.findElement(By.id("login")).getText());

				

				System.out.println("Click on new user: " + driver.findElement(By.cssSelector("button[id='newUser']")).getText());

				driver.findElement(By.id("newUser")).click();

				driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Samuel");

				System.out.println("First Name is: " + driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value"));

				driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Ozofereh");

				System.out.println("Last Name is: " + driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value"));

				driver.findElement(By.id("userName")).sendKeys("sammy2121");

				System.out.println("User Name is: " + driver.findElement(By.id("userName")).getAttribute("value"));

				driver.findElement(By.id("password")).sendKeys("Condoct22@@");

				System.out.println("Password is: " + driver.findElement(By.id("password")).getAttribute("value"));

				

				JavascriptExecutor js = (JavascriptExecutor)driver;

				js.executeScript("window.scrollBy(0, 500)");

				

				System.out.println("Click on goto Login button: " + driver.findElement(By.id("gotologin")).getText());

				driver.findElement(By.id("gotologin")).click();



				driver.findElement(By.id("userName")).sendKeys("sammy2121");

				System.out.println("Enter the User Name as: " + driver.findElement(By.id("userName")).getAttribute("value"));

				driver.findElement(By.id("password")).sendKeys("Condoct22@@");

				System.out.println("Enter the Password as: " + driver.findElement(By.id("password")).getAttribute("value"));

				

				System.out.println("Click on Login button: " + driver.findElement(By.xpath("//button[@id='login']")).getText());

				driver.findElement(By.xpath("//button[@id='login']")).click();

				

				WebElement gotoStore = driver.findElement(By.xpath("//button[@id='gotoStore']"));

				js.executeScript("arguments[0].scrollIntoView(true);", gotoStore);		

				System.out.println("Click on goto Store button: " + gotoStore.getText());

				gotoStore.click();

				driver.findElement(By.id("searchBox")).sendKeys("Speaking JavaScript");

				System.out.println("Enter the Book for Searching as: " + driver.findElement(By.id("searchBox")).getAttribute("value"));

				Thread.sleep(2000);

				

				System.out.println("Click on Speaking Javascript Link:" + driver.findElement(By.linkText("Speaking JavaScript")).getText());

				driver.findElement(By.linkText("Speaking JavaScript")).click();

				WebElement addToCollection = driver.findElement(By.xpath("(//button[@id='addNewRecordButton'])[2]"));

				js.executeScript("arguments[0].scrollIntoView(true);", addToCollection);

				Thread.sleep(2000);		

				System.out.println("Click on add To Collection button: " + addToCollection.getText());

				addToCollection.click();

				

				Thread.sleep(2000);

				Alert alert = driver.switchTo().alert();

				String alertMessage= driver.switchTo().alert().getText();

				System.out.println("Alert message is: " +alertMessage);

				Thread.sleep(3000);//This will get the text on the pop up alert

				alert.accept();

						

	}

}
