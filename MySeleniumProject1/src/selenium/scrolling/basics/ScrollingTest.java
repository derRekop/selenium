package selenium.scrolling.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Method 1. scrolling using pixels
		js.executeScript("window.scrollBy(0,1000)", "");
		
		//Method 2. scrolling until element is found
		WebElement flag = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[1]/tbody/tr[26]/td[2]"));
		js.executeScript("arguments[0].scrollIntoView();", flag); 
		
		//Method 3. scrolling to bottom of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.close();
	}

}
