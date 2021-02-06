package selenium.testng.basiclisteners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	void loginByEmail() {
		System.out.println("Verify user can login by Email");
		Assert.assertEquals("Fer", "Fer"); //hard coded to True
	}
	
	@Test
	void loginByFacebook() {
		System.out.println("Verify user can login by Facebook");
		Assert.assertEquals("Messi", "CR7"); //hard coded to False
	}

}
