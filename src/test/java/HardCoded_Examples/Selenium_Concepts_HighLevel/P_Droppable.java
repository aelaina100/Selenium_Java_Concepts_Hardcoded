package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// Drag and drop
public class P_Droppable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
		Actions a= new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		
		
		

	}

}
