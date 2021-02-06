package selenium.testng.basictests;

import org.testng.annotations.Test;

public class PaymentTest {

	@Test
	public void paymentInDollars() {
		System.out.println("User has payed with US Dollars");
	}
	
	@Test
	public void paymentInPesos() {
		System.out.println("User has payed with Mexican Pesos");
	}
	
}
