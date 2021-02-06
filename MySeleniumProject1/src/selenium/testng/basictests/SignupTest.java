package selenium.testng.basictests;

import org.testng.annotations.Test;

public class SignupTest {

	@Test
	public void signupByEmail() {
		System.out.println("User has signed up by Email");
	}
	
	@Test
	public void signupByFacebook() {
		System.out.println("User has signed up by Facebook");
	}
	
	@Test
	public void signupByTwitter() {
		System.out.println("User has signed up by Twitter");
	}
}
