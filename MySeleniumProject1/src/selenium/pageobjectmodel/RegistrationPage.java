package selenium.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	WebDriver driver;
	
	/**
	 * locators for each element in the page that we want to steer
	 */
	By link_registration = By.linkText("REGISTER");
	By txt_firstName = By.name("firstName");
	By txt_lastName = By.name("lastName");
	By txt_phone = By.name("phone");
	By txt_email = By.name("userName");
	By txt_address = By.name("address1");
	By txt_city = By.name("city");
	By txt_state = By.name("state");
	By txt_postalCode = By.name("postalCode");
	By select_country = By.name("country");
	By txt_user = By.name("email");
	By txt_pass = By.name("password");
	By txt_confirmPass = By.name("confirmPassword");
	By btn_submit = By.name("submit");
	// continue adding the rest of the locators
	
	/**
	 * Class constructor
	 * @param driver The WebDriver object (ChromeDriver, FirefoxDriver, etc).
	 */
	RegistrationPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * Method used to click on the registration link.
	 */
	public void clickRegistrationLink() {
		driver.findElement(link_registration).click();
	}
	
	/**
	 * Method used to type into the First Name field.
	 * @param firstName The value (String) to type into the field.
	 */
	public void setFirstName(String firstName) {
		driver.findElement(txt_firstName).sendKeys(firstName);
	}
	
	/**
	 * Method used to type into the Last Name field.
	 * @param lastName The value (String) to type into the field.
	 */
	public void setLastName(String lastName) {
		driver.findElement(txt_lastName).sendKeys(lastName);
	}
	
	/**
	 * Method used to type into the Phone field.
	 * @param phoneNum The value (String) to type into the field.
	 */
	public void setPhone(String phoneNum) {
		driver.findElement(txt_phone).sendKeys(phoneNum);
	}
	
	/**
	 * Method used to type into the Email field.
	 * @param email The value (String) to type into the field.
	 */
	public void setEmail(String email) {
		driver.findElement(txt_email).sendKeys(email);
	}
	
	// continue adding the rest of the methods
	public void setAddress(String address) {
		driver.findElement(txt_address).sendKeys(address);
	}
	
	public void setCity(String city) {
		driver.findElement(txt_city).sendKeys(city);
	}
	
	public void setState(String state) {
		driver.findElement(txt_state).sendKeys(state);
	}
	
	public void setPostalCode(String postalCode) {
		driver.findElement(txt_postalCode).sendKeys(postalCode);
	}
	
	public void setCountry(String country) {
		Select countryList = new Select(driver.findElement(select_country));
		countryList.selectByVisibleText(country);
	}
	
	public void setUserName(String user) {
		driver.findElement(txt_user).sendKeys(user);
	}
	
	public void setPassword(String pass) {
		driver.findElement(txt_pass).sendKeys(pass);
	}
	
	public void setConfirmedPassword(String pass) {
		driver.findElement(txt_confirmPass).sendKeys(pass);
	}
	
	public void clickSubmit() {
		driver.findElement(btn_submit).click();
	}

}
