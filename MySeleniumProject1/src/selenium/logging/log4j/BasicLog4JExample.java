package selenium.logging.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLog4JExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("Log4JExample");
		//DOMConfigurator.configure("log4j.xml"); // this file needs to be in the same directory
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		logger.info("Browser Opened");
		
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		logger.info("Enter User");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		
		logger.info("Enter Password");
		driver.findElement(By.name("password")).sendKeys("mercury");
		
		logger.info("Click Login");
		driver.findElement(By.name("submit")).click();
		
		String expectedTitle = "Login: Mercury Tours";
		String actualTitle = driver.getTitle();
		
		logger.info("Starting Validation");
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test Passed\nExpected: " 
					+ expectedTitle + "\nActual: " + actualTitle);
			logger.info("Validation Passed");
		} else {
			System.out.println("Test Failed\nExpected: " 
					+ expectedTitle + "\nActual: " + actualTitle);
			logger.info("Validation Failed");
		}
		
		logger.info("Exiting Validation");
		logger.info("Test Finished");
		driver.close();
	}

}
