package facets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.vbc4me.awanna.facets.PhoneNumber;

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
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "1234567890");
		assertEquals(phoneNumber.type(), "HOME");
		assertEquals("1234567890", phoneNumber.number(false));
		assertEquals("(123) 456-7890", phoneNumber.number(true));
		assertEquals(phoneNumber.toString(), "HOME: (123) 456-7890");
	}
	
	/**
	 * Test that standard formated phone number input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestOpenParenthesisCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "(");
	}
	
	/**
	 * Test that standard formated phone number input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestCloseParenthesisCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, ")");
	}
	
	/**
	 * Test that standard formated phone number input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestDashCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "-");
	}
	
	/**
	 * Test that other special character input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestSpecialCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "{");
	}
	
	/**
	 * Test that Alphabetic character input throws
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestCharacterThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "F");
	}
	
	/**
	 * Test that any less than 10 characters will throw
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestLessThanTenNumbersThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "123456789");
	}
	
	/**
	 * Test that any more than 10 characters will throw
	 * an {@link IllegalArgumentException}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void TestMoreThanTenNumbersThrows() {
		@SuppressWarnings("unused")
		PhoneNumber phoneNumber = PhoneNumber.of(PhoneNumber.Type.HOME, "12345678901");
	}
	
	/**
	 * Test the {@link PhoneNumber #contains(java.util.List, PhoneNumber)} method.
	 */
	public void TestContainsMethod() {
		List<PhoneNumber> numbers = new ArrayList<>();
		PhoneNumber one = PhoneNumber.of(PhoneNumber.Type.HOME, "1234567890");
		PhoneNumber two = PhoneNumber.of(PhoneNumber.Type.OFFICE, "9876543210");
		PhoneNumber three = PhoneNumber.of(PhoneNumber.Type.OFFICE, "6549873210");
		PhoneNumber four = PhoneNumber.of(PhoneNumber.Type.OTHER, "7412589630");
		PhoneNumber five = PhoneNumber.of(PhoneNumber.Type.CELL, "3698521470");
		numbers.add(five);
		numbers.add(three);
		numbers.add(one);
		numbers.add(four);
		numbers.add(two);
		assertTrue(PhoneNumber.contains(numbers, one));
		assertTrue(PhoneNumber.contains(numbers, two));
		assertTrue(PhoneNumber.contains(numbers, three));
		assertTrue(PhoneNumber.contains(numbers, four));
		assertTrue(PhoneNumber.contains(numbers, five));
		assertFalse(PhoneNumber.contains(numbers, PhoneNumber.of(PhoneNumber.Type.OTHER, "9512357460")));
	}
}
