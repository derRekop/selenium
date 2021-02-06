package selenium.datadriven.basictests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicExcelReading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/fvargas/Selenium/SeleniumDrivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		/*
		 * Excel Steering
		 */
		
		FileInputStream file = new FileInputStream("//Users//fvargas//eclipse-workspace//MySeleniumProject1//XLSTestFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("MySecondSheet");
		
		int rowsCount = sheet.getLastRowNum();
		
		for(int i = 1; i <= rowsCount; i++) {
			XSSFRow currentRow = sheet.getRow(i);
			
			String xlsFirstName = currentRow.getCell(0).toString();
			String xlsLastName = currentRow.getCell(1).toString();
			String xlsAddress = currentRow.getCell(2).toString();
			String xlsEmail = currentRow.getCell(3).toString();
			String xlsPhone = currentRow.getCell(4).toString();
			String xlsHobbies = currentRow.getCell(5).toString();
			String xlsLanguage = currentRow.getCell(6).toString();
			String xlsSkills = currentRow.getCell(7).toString();
			String xlsCountry = currentRow.getCell(8).toString();
			String xlsDOB = currentRow.getCell(9).toString();
			String xlsPassword = currentRow.getCell(10).toString();
			
			// entering values into AUT
			
			driver.findElement(By.cssSelector("*[ng-model='FirstName']")).sendKeys(xlsFirstName);
			driver.findElement(By.cssSelector("*[ng-model='LastName']")).sendKeys(xlsLastName);
			driver.findElement(By.cssSelector("*[ng-model='Adress']")).sendKeys(xlsAddress);
			driver.findElement(By.cssSelector("*[ng-model='EmailAdress']")).sendKeys(xlsEmail);
			driver.findElement(By.cssSelector("*[ng-model='Phone']")).sendKeys(xlsPhone);
			
			driver.findElement(By.cssSelector("*[type='radio'][value='Male']")).click();
			
			// starts hobbies logic
			
			String checkboxID = "";
			switch(xlsHobbies.toLowerCase()) {
			case "cricket":
				checkboxID = "checkbox1";
				break;
			case "movies":
				checkboxID = "checkbox2";
				break;
			case "hockey":
				checkboxID = "checkbox3";
				break;
				default:
					System.out.println("Hobby not in list");
					break;
			}
			
			driver.findElement(By.id(checkboxID)).click();
			// ends hobbies logic
			
			driver.findElement(By.id("msdd")).click();
			driver.findElement(By.linkText(xlsLanguage)).click();
			
			Select skills = new Select(driver.findElement(By.id("Skills")));
			skills.selectByVisibleText(xlsSkills);
			//skills.getOptions().size(); //returns the number of items in the list
			
			Select country = new Select(driver.findElement(By.id("countries")));
			country.selectByVisibleText(xlsCountry);
			
			// starts DOB logic
			try {
				Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(xlsDOB);
				LocalDate date = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				Select year = new Select(driver.findElement(By.id("yearbox")));
				year.selectByVisibleText(String.valueOf(date.getYear()));
				
				Select month = new Select(driver.findElement(By.cssSelector("select[ng-model='monthbox']")));
				month.selectByIndex(date.getMonthValue()); //index start with zero
				
				Select day = new Select(driver.findElement(By.id("daybox")));
				day.selectByValue(String.valueOf(date.getDayOfMonth()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			// ends DOB logic
			
			//smart drop down with search box
			driver.findElement(By.cssSelector("*[class='select2-selection select2-selection--single']")).click();
			driver.findElement(By.cssSelector("*[class='select2-search__field']")).sendKeys(xlsCountry);
			driver.findElement(By.xpath("//li[text()='"+ xlsCountry + "']")).click();
			
			//password fields
			driver.findElement(By.id("firstpassword")).sendKeys(xlsPassword);
			driver.findElement(By.id("secondpassword")).sendKeys(xlsPassword);
			
			// refresh form
			driver.findElement(By.id("Button1")).click();
			
		}
		
		workbook.close();
		driver.close();

	}

}
