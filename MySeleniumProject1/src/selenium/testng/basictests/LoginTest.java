package selenium.testng.basictests;

import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void loginByEmail() {
		System.out.println("User has logged in by Email");
	}
	
	@Test
	public void loginByFacebook() {
		System.out.println("User has logged in by Facebook");
	}
	
	@Test
	public void loginByTwitter() {
		System.out.println("User has logged in by Twitter");
	}
}
