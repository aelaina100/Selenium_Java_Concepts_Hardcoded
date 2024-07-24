package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/* ##########################How to go about this example: Without viewing the code below EVER, Practice this example with its 6 questions
 *                           By creating a .java class file and coding the answers. THis is a crucial example that NEEDS to be coded as there
 *                           are certain information that can only be realized/absorbed by coding    */


public class I_RadioButton {

	public static void main(String[] args) {
		
		//https://rahulshettyacademy.com/AutomationPractice/
		
		//Note: By default, radio buttons on this webpage are not selected.
		
		//1- Check if the 3rd radio button selected or not ? (3rd WHATEVER it is).
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Boolean b= driver.findElement(By.xpath("(//input[@class= 'radioButton'])[3]")).isSelected();
		
		if (b)
		{
			System.out.println("3rd radio button is: SELECTED" );
		}
			
			else
			{
				System.out.println("3rd radio button is: NOT selected ");
			}
		
		
		//2- Check if the first radio button selected ot not ? (1st whetever it is).
		Boolean c= driver.findElement(By.xpath("(//input[@class= 'radioButton'])[1]")).isSelected();
		
		if(c)
		{
			System.out.println("1st button is SELECTED");
		}
			
			else
			{
				System.out.println("1st button is NOT selected");
			}
		
	
    	//3- select the 2nd radio button (2nd one whetever it is/ doesn't matter what it is. Tomorrow the name of it may change to whatever, still we want to be able to click on it regardless)
		driver.findElement(By.xpath("(//input[@name='radioButton'])[2]")).click();
		// above: How about using driver.findElementS(By..).get(2).click();   ?? Both lines work !
		
		//4-I want to know the text of the 2nd radio button. print it out.
		//System.out.println( driver.findElement(By.xpath("(//input[@name='radioButton'])[2]")).getText());   //CRUCIAL: This line will NOT be working. It is crucial to understand why ! Very crucial !!
		System.out.println( driver.findElement(By.xpath("(//div[@id='radio-btn-example']/fieldset/label)[2]")).getText());
		
		
		//5- I want to know the text of the 1st radio button. print it out.
		System.out.println( driver.findElement(By.xpath("(//div[@id='radio-btn-example']/fieldset/label)[1]")).getText());

		
		//6- printing out the text of " Practice Page"
		System.out.println(driver.findElement(By.xpath("//body/h1")).getText());
		
		
		
		
		}
}
		
		
	

	


