package account;

import org.junit.Test;
import org.vbc4me.awanna.account.PhoneNumber;

import junit.framework.Assert;

/**
 * Test class for {@link PhoneNumber}.
 */
public class TestPhoneNumber {
	
	/**
	 * Test that the phone number is created correctly and that every form that can be returned
	 * is formed correctly.
	 */
	@Test
	public void TestPhoneNumberCreation() {
		PhoneNumber phoneNumber = new PhoneNumber("Home", "1234567890");
		Assert.assertEquals("Home", phoneNumber.type());
		Assert.assertEquals("1234567890", phoneNumber.number(false));
		Assert.assertEquals("(123) 456-7890", phoneNumber.number(true));
		Assert.assertEquals("Home: (123) 456-7890", phoneNumber.toString());
	}
	
	/**
	 * Test that standard formated phone number input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestOpenParenthesisCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", "(");
	}
	
	/**
	 * Test that standard formated phone number input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestCloseParenthesisCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", ")");
	}
	
	/**
	 * Test that standard formated phone number input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestDashCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", "-");
	}
	
	/**
	 * Test that other special character input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestSpecialCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", "{");
	}
	
	/**
	 * Test that Alphabetic character input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", "F");
	}
	
	/**
	 * Test that any less than 10 characters will throw
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestLessThanTenNumbersThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", "123456789");
	}
	
	/**
	 * Test that any more than 10 characters will throw
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestMoreThanTenNumbersThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = new PhoneNumber("Home", "12345678901");
	}
	
}
