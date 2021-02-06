package selenium.cookies.basic;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		//get all cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		
		//get cookies list size
		System.out.println("Total cookies: " + cookies.size());
		
		//print each cookies name and value
		for(Cookie cookie : cookies) {
			System.out.println(
					"Name: " + cookie.getName() +
					"\nValue: " + cookie.getValue());
		}
		
		//get specific cookie by name
		System.out.println(driver.manage().getCookieNamed("session-id"));
		
		//create new cookie
		Cookie newCookie = new Cookie("myNewCookie", "arriba los rayados");
		
		//add cookie to the browser
		driver.manage().addCookie(newCookie);
		
		//print the new cookies list size
		cookies = driver.manage().getCookies();
		System.out.println("Total cookies: " + cookies.size());
		
		//print each cookies name and value
		for(Cookie cookie : cookies) {
			System.out.println(
					"Name: " + cookie.getName() +
					"\nValue: " + cookie.getValue());
		}
				
		//delete specific cookie
		driver.manage().deleteCookie(newCookie);
		cookies= driver.manage().getCookies();
		System.out.println("Total cookies: " + cookies.size());
		
		//print each cookies name and value
		for(Cookie cookie : cookies) {
			System.out.println(
					"Name: " + cookie.getName() +
					"\nValue: " + cookie.getValue());
		}
		
		// delete all cookies
		driver.manage().deleteAllCookies();
		cookies= driver.manage().getCookies();
		System.out.println("Total cookies: " + cookies.size());
		
		//print each cookies name and value
		for(Cookie cookie : cookies) {
			System.out.println(
					"Name: " + cookie.getName() +
					"\nValue: " + cookie.getValue());
		}
		driver.close();
	}

}
