package HardCoded_Examples.Selenium_Concepts_HighLevel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
//https://corporate.spicejet.com/Default.aspx

//1- Ensure "One-way" is already selected by default
//2- click on 'round-trip' 
//3- From: 'Hyderabad", To: "Chenai" & then click on 'One-way"

//4- Return Date: Ensure it is disabled.
//5- Passenger: 4 children & 3 enfants  & 9 adults
//6- Currency: USD
//7-Select checkbox: 'Students'
//8- Click on 'Search Flight'.
//9- In the new page, deselect "No/ I do not have GST..." & fill out the field of GST
//10-Ensure 'return' date is enabled, when 'round-trip' is selected
//11- Departure date: Select the highlighted one / a seperate testcase to select the day after highlighted one AND to iterate throughout the days.

public class X_travel_various {

 public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);    
		
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	   driver.get("https://corporate.spicejet.com/Default.aspx");

//1- 
String classAttributeValue= driver.findElement(By.xpath("//input[@id= 'ctl00_mainContent_rbtnl_Trip_0']/following-sibling::label[1]")).getAttribute("class");
if (classAttributeValue.equalsIgnoreCase("select-label"))   // Invaluable note: place a semi-column at the end of this line and observe
{   
	System.out.println(" 'One-way' radio button is SELECTED");
}
else
{
	System.out.println(" 'one-way' radio button is NOT SELECTED");
}

//2- 
driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click(); //clicks on 'round-trip',let's ensure that it's actually selected
Boolean round_trip_radio =driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected();
//Boolean round_trip_radio =driver.findElement(By.xpath("//label[@text()= 'Round Trip']")).isSelected(); // NOT going to work. Very logical why this is
if(round_trip_radio)
{
	System.out.println("PASSED: radio button was indeed SELECTED for 'round-trip' ");
}

else {
	System.out.println("FAILED: radio button NOT selected for 'round-trip' ");	
}


//3
driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //  Clicks on 'From'/ Departure City
driver.findElement(By.xpath("(//a[text()= ' Hyderabad (HYD)'])[1]")).click();   // Selects Hyderabad (HYD) as a result, 2nd drop down opens up.
//driver.findElement(By.linkText(" Hyderabad (HYD)")).click(); // Not working; figure out why.
driver.findElement(By.xpath("(//a[text()= ' Chennai (MAA)'])[2]")).click();   //selects Chennai (MAA)

//below: click on 'one-way'
driver.findElement(By.cssSelector("label[for= 'ctl00_mainContent_rbtnl_Trip_0']")).click();

//4-
String styleAttributeValue= driver.findElement(By.id("Div1")).getAttribute("style");
if(styleAttributeValue.contains("opacity: 0.5"))
{
	System.out.println("PASSED: Return Date is DISABLED");
}

else
{
	System.out.println("BUG: Return Date is Enabled. It should be disabled");
}
//5-
    driver.findElement(By.id("divpaxinfo")).click(); //Identifues 'Passengers' dropdown and clicks on it.
    
    WebElement adult_dropDown= driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
   Select s = new Select(adult_dropDown);  ///Identifues 'Passengers' dropdown and clicks on it.
   s.selectByValue("2");
  
   WebElement child_dropDown= driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
   Select s1 =new Select(child_dropDown);
   s1.selectByValue("4");
   
   WebElement infant_dropDown= driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
   Select s2 =new Select(infant_dropDown);
   s2.selectByValue("1");
//6-
   WebElement currency_element= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
   Select s3= new Select(currency_element);
   s3.selectByValue("USD");
//7-
   driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
//8
   driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
//9
   driver.findElement(By.id("ControlGroupSelectView_ContactInputGSTViewSelectView_CheckBoxGST")).click();
   driver.findElement(By.id("ControlGroupSelectView_ContactInputGSTViewSelectView_TextBoxRegistrationNumberGST")).sendKeys(" YAHOOOOOOOOOOOO");
//10
   driver.navigate().back();
   driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click(); // selects round-trip
   String style_Attribute= driver.findElement(By.id("Div1")).getAttribute("style");
   if(style_Attribute.contains("opacity: 0.5"))
   {
	   System.out.println("FAILED: Return date is DISABLED even though 'Round-trip' is selected");
   }
   else
   {
	   System.out.println("PASSED: Return date is ENABLED when 'Round-trip' is selected");
   }

System.out.println("####################### Execution Complete ########################");
//Thread.sleep(5000L);
//driver.quit();

	}

}
