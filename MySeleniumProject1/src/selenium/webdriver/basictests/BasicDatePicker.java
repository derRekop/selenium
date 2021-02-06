package selenium.webdriver.basictests;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicDatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		
		//click date picker button
		driver.findElement(By.cssSelector("img[class='imgdp']")).click();
		
		//verify current month is displayed
		String displayedMonth = driver.findElement(By.cssSelector("*[class='ui-datepicker-month']")).getText();
		LocalDate date = LocalDate.now();
		if(displayedMonth.equalsIgnoreCase(date.getMonth().toString())) {
			System.out.println("Passed: Current month: " + displayedMonth);
		} else {
			System.out.println("Failed: Current month: " + displayedMonth);
		}
		
		//go back 5 months and select the day 15
		for(int i = 1; i <= 5; i++) {
			driver.findElement(By.cssSelector("*[class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		//verify new month is 5 months in the past
		displayedMonth = driver.findElement(By.cssSelector("*[class='ui-datepicker-month']")).getText();
		if(date.minusMonths(5).getMonth().toString().equalsIgnoreCase(displayedMonth)) {
			driver.findElement(By.linkText("15")).click();
		} else {
			System.out.println("Failed: Incorrect Month " + displayedMonth);
		}
		
		driver.close();

	}

}
