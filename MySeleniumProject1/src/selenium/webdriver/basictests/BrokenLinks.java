package selenium.webdriver.basictests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		//get list of links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//get total links
		System.out.println(links.size());
		
		for(int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			//create connection using URL object "link"
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			
			//wait 2 seconds
			Thread.sleep(2000);
			
			httpConn.connect();
			
			int responseCode = httpConn.getResponseCode();
			
			if(responseCode >= 400) {
				System.out.println(url + " - " + "is a broken link");
			} else {
				System.out.println(url + " - " + "is a valid link");
			}
		}
		
	driver.close();

	}

}
