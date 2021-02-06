package selenium.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageMethod2 {

	WebDriver driver;
	
	// Method 1
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	WebElement link_registration;
	
	// Method 1
	@FindBy(how = How.NAME, using = "firstName")
	WebElement txt_firstName;
	
	// Method 2
	@FindBy(name = "lastName")
	WebElement txt_lastName;
	
	@FindBy(name = "phone")
	WebElement txt_phone;
	
	@FindBy(name = "userName")
	WebElement txt_email;
	
	@FindBy(name = "address1")
	WebElement txt_address;
	
	@FindBy(name = "city")
	WebElement txt_city;
	
	@FindBy(name = "state")
	WebElement txt_state;
	
	@FindBy(name = "postalCode")
	WebElement txt_postalCode;
	
	@FindBy(name = "country")
	WebElement select_country;
	
	@FindBy(name = "email")
	WebElement txt_user;
	
	@FindBy(name = "password")
	WebElement txt_pass;
	
	@FindBy(name = "confirmPassword")
	WebElement txt_confirmPass;
	
	@FindBy(name = "submit")
	WebElement btn_submit;
	
	RegistrationPageMethod2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegistrationLink() {
		link_registration.click();
	}
	
	public void setFirstName(String firstName) {
		txt_firstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		txt_lastName.sendKeys(lastName);
	}
	
	public void setPhone(String phoneNum) {
		txt_phone.sendKeys(phoneNum);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setAddress(String address) {
		txt_address.sendKeys(address);
	}
	
	public void setCity(String city) {
		txt_city.sendKeys(city);
	}
	
	public void setState(String state) {
		txt_state.sendKeys(state);
	}
	
	public void setPostalCode(String postalCode) {
		txt_postalCode.sendKeys(postalCode);
	}
	
	public void setCountry(String country) {
		Select countryList = new Select(select_country);
		countryList.selectByVisibleText(country);
	}
	
	public void setUserName(String user) {
		txt_user.sendKeys(user);
	}
	
	public void setPassword(String pass) {
		txt_pass.sendKeys(pass);
	}
	
	public void setConfirmedPassword(String pass) {
		txt_confirmPass.sendKeys(pass);
	}
	
	public void clickSubmit() {
		btn_submit.click();
	}
}
