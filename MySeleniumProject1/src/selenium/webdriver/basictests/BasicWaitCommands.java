package selenium.webdriver.basictests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicWaitCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		
		//below code is for implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//below code is for Explicit Wait
		
		/*
		 * This code will require to create a wait variable with a preset time
		 * Then you will need to add a new line of code every time you want to wait for an object
		 * Then you can steer that object
		 */
		
		//create wait time variable
		WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
		
		//tell script to wait until object is visible
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("imgdp")));
		
		//now we can steer the object
		driver.findElement(By.className("imgdp")).click();
		
		driver.close();

	}

}
