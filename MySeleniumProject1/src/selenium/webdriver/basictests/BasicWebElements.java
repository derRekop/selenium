package selenium.webdriver.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		//input or text fields
		driver.findElement(By.cssSelector("*[ng-model='FirstName']")).sendKeys("TestFirstName");
		driver.findElement(By.cssSelector("*[ng-model='LastName']")).sendKeys("TestLastName");
		driver.findElement(By.cssSelector("*[ng-model='Adress']")).sendKeys("TestAddress");
		driver.findElement(By.cssSelector("*[ng-model='EmailAdress']")).sendKeys("contact@testing.com");
		driver.findElement(By.cssSelector("*[ng-model='Phone']")).sendKeys("1234567890");
		
		//radio buttons
		driver.findElement(By.cssSelector("*[type='radio'][value='Male']")).click();
		
		//check boxes
		driver.findElement(By.id("checkbox2")).click();
		
		//smart combo box with multiple select
		driver.findElement(By.id("msdd")).click();
		driver.findElement(By.linkText("English")).click();
		driver.findElement(By.linkText("Spanish")).click();
		driver.findElement(By.linkText("German")).click();
		
		//select field
		Select skills = new Select(driver.findElement(By.id("Skills")));
		skills.selectByVisibleText("Java");
		//skills.getOptions().size(); //returns the number of items in the list
		
		Select country = new Select(driver.findElement(By.id("countries")));
		country.selectByVisibleText("Canada");
		
		Select year = new Select(driver.findElement(By.id("yearbox")));
		year.selectByVisibleText("2001");
		
		Select month = new Select(driver.findElement(By.cssSelector("select[ng-model='monthbox']")));
		month.selectByIndex(5); //index start with zero
		
		Select day = new Select(driver.findElement(By.id("daybox")));
		day.selectByValue("16"); //the value of the attribute/tag VALUE
		
		//smart drop down with search box
		driver.findElement(By.cssSelector("*[class='select2-selection select2-selection--single']")).click();
		driver.findElement(By.cssSelector("*[class='select2-search__field']")).sendKeys("Japan");
		driver.findElement(By.xpath("//li[text()='Japan']")).click();
		
		//password fields
		driver.findElement(By.id("firstpassword")).sendKeys("passWord1");
		driver.findElement(By.id("secondpassword")).sendKeys("passWord1");
		
		//upload file
		driver.findElement(By.id("imagesrc")).sendKeys("/Users/fvargas/eclipse-workspace/MySeleniumProject1/sample.html");
		driver.close();

	}

}
