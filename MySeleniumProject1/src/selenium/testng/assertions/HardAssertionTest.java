package selenium.testng.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionTest {
	
	@Test
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.name("userName"));
		WebElement pass = driver.findElement(By.name("password"));
		
		Assert.assertTrue(user.isDisplayed());
		user.sendKeys("mercury");
		
		Assert.assertTrue(pass.isDisplayed());
		pass.sendKeys("mercury");
		
		driver.findElement(By.name("submit")).click();
		
		String expectedTitle = "eLogin: Mercury Tours";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
		driver.close();
	}

}
