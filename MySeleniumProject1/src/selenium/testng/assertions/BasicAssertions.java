package selenium.testng.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAssertions {
	
	@Test
	void demoTest1() {
		Assert.assertTrue(true); //passed
		Assert.assertEquals("welcome", "welcome"); //true passed
		Assert.assertEquals("selenium", "selenium"); //true passed
		System.out.println("Successfully Passed!");
	}
	
	@Test
	void demoTest2() {
		Assert.assertTrue(true); //passed
		Assert.assertEquals("welcome", "Welcome"); //false failed
		Assert.assertEquals("selenium", "selenium"); //true passed
		System.out.println("Successfully Passed!");
	}

}
