package selenium.actionclass.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		Actions mouseActions = new Actions(driver);
		WebElement button = driver.findElement(By.cssSelector("*[class='context-menu-one btn btn-neutral']"));
		mouseActions.contextClick(button).build().perform(); //right clicks on the element

		WebElement copy = driver.findElement(By.cssSelector("li[class='context-menu-item context-menu-icon context-menu-icon-copy']"));
		mouseActions.moveToElement(copy).click().build().perform();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
	}

}
