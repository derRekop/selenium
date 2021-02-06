package selenium.webdriver.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///Users/fvargas/eclipse-workspace/MySeleniumProject1/sample.html");
		driver.manage().window().maximize();
		
		//get number of rows
		int totalRows = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size(); //uses findElements instead of findElement
		//System.out.println(driver.findElements(By.xpath("/html/body/table/tbody/tr")).size());

		//get number of columns
		int totalColumns = driver.findElements(By.xpath("/html/body/table/tbody/tr/th")).size(); //uses findElements instead of findElement
		//System.out.println(driver.findElements(By.xpath("/html/body/table/tbody/tr/th")).size());

		for(int i = 2; i <= totalRows; i++) {
			for(int j = 1; j <= totalColumns; j++) {
				System.out.print(driver.findElement(By.xpath("html/body/table/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");
			}
			System.out.println();
		}
		driver.close();
	}

}
