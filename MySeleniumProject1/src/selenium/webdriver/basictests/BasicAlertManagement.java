package selenium.webdriver.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAlertManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		//commands for frame
		//driver.get("http://demo.automationtesting.in/Frames.html");
		//driver.switchTo().frame("frameName");
		//driver.switchTo().frame(driver.findElement(By.xpath("XPath")));
		
		//open alerts WebSite
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		/*
		 * First option: alert with OK button
		 */
		//identify button for 'alert with OK button'
		driver.findElement(By.linkText("Alert with OK")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
		
		//switch to the alert box
		//System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		/*
		 * Second option: alert with OK and Cancel buttons
		 */
		
		//click link, display alert and click OK
		driver.findElement(By.linkText("Alert with OK & Cancel")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		driver.switchTo().alert().accept();
		
		//verify text and display test results
		if(driver.findElement(By.id("demo")).getText().equals("You pressed Ok")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		//click link, display alert and click Cancel
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		driver.switchTo().alert().dismiss();
		
		//verify text and display test results
		if(driver.findElement(By.id("demo")).getText().equals("You Pressed Cancel")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		/*
		 * Third option: alert with text box and OK button
		 */
		//click link, display alert and click OK
		driver.findElement(By.linkText("Alert with Textbox")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
		String str = "Fernando";
		driver.switchTo().alert().sendKeys(str);
		driver.switchTo().alert().accept();
				
		//verify text and display test results
		if(driver.findElement(By.id("demo1")).getText().equals("Hello "+ str +" How are you today")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
				
		driver.close();

	}

}
