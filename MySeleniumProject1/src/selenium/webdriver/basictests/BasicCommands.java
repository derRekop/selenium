package selenium.webdriver.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicCommands {

	public static void main(String[] args) {
		// Sets system property for correct driver
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		
		//creates new driver
		ChromeDriver driver = new ChromeDriver();
		
		/**
		 * Get commands
		 */
		
		//opens the browser with provided URL
		driver.get("http://demo.guru99.com/test/newtours/");
		
		//returns a String with the title of the current page
		String pageTitle = driver.getTitle();
		
		//returns a String with the current URL
		String currentURL = driver.getCurrentUrl();
		
		//returns a String with the inner text of the element
		String currentDate = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")).getText();
		
		System.out.println(pageTitle+"\n"+currentURL+"\n"+currentDate);
		
		/**
		 * Navigation commands
		 */
		
		//navigates to a new URL in current browser
		driver.navigate().to("http://www.google.com");
		
		//navigates to previous URL in current browser
		driver.navigate().back();
		
		//navigates to forward URL in current browser
		driver.navigate().forward();
		
		//this is a test that adds text in the google search box so we can later refresh the page
		driver.findElement(By.name("q")).sendKeys("Rayados");
		
		//refreshes the page in current browser
		driver.navigate().refresh();
		
		/**
		 * Conditional commands
		 */
		
		//prerequisite
		driver.navigate().to("https://phptravels.org/clientarea.php");
		
		//checks if the web element is displayed
		WebElement user = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		
		if(user.isDisplayed()) {
			if(user.isEnabled()) {
				user.sendKeys("mercury");
			}
		}
		
		if(pass.isDisplayed()) {
			if(pass.isEnabled()) {
				pass.sendKeys("mercury");
			}
		}
		
		//checks if the web element is selected
		System.out.println(driver.findElement(By.name("rememberme")).isSelected());
		
		//selects the CheckBox
		driver.findElement(By.name("rememberme")).click();
		
		//checks if the web element is selected
		System.out.println(driver.findElement(By.name("rememberme")).isSelected());
		
		driver.close();

	}

}
