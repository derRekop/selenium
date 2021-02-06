package selenium.actionclass.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSliderSteering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement slider = driver.findElement(By.cssSelector("*[class='ui-slider-handle ui-corner-all ui-state-default']"));	
		
		Actions mouseActions = new Actions(driver);
		mouseActions.moveToElement(slider).dragAndDropBy(slider, 300, 0).build().perform();
		driver.close();
	}

}
