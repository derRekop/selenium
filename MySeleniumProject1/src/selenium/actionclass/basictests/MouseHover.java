package selenium.actionclass.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		if(driver.findElement(By.id("welcome")).isDisplayed()) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Failed");
		}
		
		/*
		 * Navigating through the menu but using mouse actions
		 */
		Actions mouseActions = new Actions(driver);
		
		//Mouse over action
		mouseActions.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).build().perform();
		mouseActions.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).build().perform();
		//Mouse click action
		mouseActions.moveToElement(driver.findElement(By.id("menu_admin_viewSystemUsers"))).click().build().perform();
		
		/*
		 * Single line option
		 * mouseActions.moveToElement(adminMenu).moveToElement(UserMgmt).moveToElement(users).click().build().perform();
		 */
		
		/*
		 * This is another option to access the menu without mouse operations
		 * 
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		*/
		
		if(driver.findElement(By.id("resultTable")).isDisplayed()) {
			System.out.println("Users table displayed successfully");
		} else {
			System.out.println("Users table was not present");
		}
		
		int rowCount = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[1]/td")).size();
		
		System.out.println("rows:"+rowCount+"\nCols: "+colCount);
		
		for(int i = 1; i <= rowCount; i++) {
			System.out.print(i + ": ");
			for(int j = 2; j<= colCount; j++) {
				System.out.print(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");
			}
			System.out.println();
		}
		
		int enabledEmployeesCount = 0;
		int adminEmployeesCount = 0;
		
		for(int i = 1; i <= rowCount; i++) {
			String employeesStatus = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[" + i + "]/td[5]")).getText();
			String employeesRole = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr[" + i + "]/td[3]")).getText();
			if(employeesStatus.equals("Enabled")) {
				enabledEmployeesCount++;
			}
			if(employeesRole.equals("Admin")) {
				adminEmployeesCount++;
			}
			
		}
		
		System.out.println("Total enabled employees: " + enabledEmployeesCount);
		System.out.println("Total admin employees: " + adminEmployeesCount);

	}

}
