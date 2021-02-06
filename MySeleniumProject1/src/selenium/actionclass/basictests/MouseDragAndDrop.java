package selenium.actionclass.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions mouseActions = new Actions(driver);
		WebElement source;
		WebElement target;
		//mouseActions.dragAndDrop(source, target).build().perform();
		
		for(int i = 1; i <= 7; i++) {
			source = driver.findElement(By.id("box" + i));
			String capitalCity = source.getText();
			int countryID = getCountryID(capitalCity);
			target = driver.findElement(By.id("box10" + countryID));
			mouseActions.dragAndDrop(source, target).build().perform();
			//another option to achieve the same
			//mouseActions.clickAndHold(source).moveToElement(target).release().build().perform();
		}
		
		System.out.println("Coutries Matched Successfully");
		driver.close();

	}
	
	public static int getCountryID(String city) {
		int id = 0;
		switch(city) {
		case "Oslo":
			id = 1;
			break;
		case "Stockholm":
			id = 2;
			break;
		case "Washington":
			id = 3;
			break;
		case "Copenhagen":
			id = 4;
			break;
		case "Seoul":
			id = 5;
			break;
		case "Rome":
			id = 6;
			break;
		case "Madrid":
			id = 7;
			break;
		default: 
			System.out.println("City: " + city + " could not be matched with any country");
		}
		return id;
	}

}
