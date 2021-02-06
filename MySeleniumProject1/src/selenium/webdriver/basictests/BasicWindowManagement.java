package selenium.webdriver.basictests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWindowManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Open New Tabbed Windows")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
		
		Set<String> s = driver.getWindowHandles();
		
		for(String i:s) {
			if(driver.switchTo().window(i).getTitle().contains("SeleniumHQ")) {
				driver.close();
			} else if(driver.switchTo().window(i).getTitle().contains("Frames")) {
				driver.close();
			}
		}
		
		System.out.println("success");
	}

}
