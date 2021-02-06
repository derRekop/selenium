package selenium.webdriver.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		//driver.get("http://advantageonlineshopping.com/");
		//driver.findElement(By.id("menuUserLink")).click();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize(); //maximizes the browser window
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
		
		String expectedTitle = "Login: Mercury Tours";
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test Passed\nExpected: " 
					+ expectedTitle + "\nActual: " + actualTitle);
		} else {
			System.out.println("Test Failed\nExpected: " 
					+ expectedTitle + "\nActual: " + actualTitle);
		}
		
		driver.close();

	}

}
