package selenium.testng.assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {
	
	SoftAssert softAssert1 = new SoftAssert();
	SoftAssert softAssert2 = new SoftAssert();
	
	@Test
	public void softAssertTest1() {
		softAssert1.assertTrue(true); //passed
		softAssert1.assertEquals("Welcome", "welcome"); //false failed
		softAssert1.assertEquals("seLenium", "selenium"); //false failed
		System.out.println("Test1 Successfully Passed!");
		softAssert1.assertAll();
	}
	
	@Test
	public void softAssertTest2() {
		softAssert2.assertTrue(true); //passed
		softAssert2.assertEquals("welcome", "welcome"); //true passed
		softAssert2.assertEquals("selenium", "selenium"); //true passed
		System.out.println("Test2 Successfully Passed!");
		softAssert2.assertAll();
	}

}
