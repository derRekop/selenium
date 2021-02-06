package selenium.pageobjectmodel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationTest {
	
	@Test
	public void verifyUserRegistration() {
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		//RegistrationPage regPage = new RegistrationPage(driver);
		RegistrationPageMethod2 regPage = new RegistrationPageMethod2(driver);
		
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		regPage.clickRegistrationLink();
		regPage.setFirstName("Lionel");
		regPage.setLastName("Messi");
		regPage.setPhone("1234567890");
		regPage.setEmail("lionel.messi@futbol.com");
		regPage.setAddress("222 South");
		regPage.setCity("Barcelona");
		regPage.setState("Catalunia");
		regPage.setPostalCode("12345");
		regPage.setCountry("SPAIN");
		
		regPage.setUserName("Messi10");
		regPage.setPassword("d10s");
		regPage.setConfirmedPassword("d10s");
		
		regPage.clickSubmit();
		
		
		if (driver.getPageSource().contains("Thank you")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		driver.close();
	}

}
