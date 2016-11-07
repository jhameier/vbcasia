package facets;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vbc4me.awanna.facets.Zipcode;

public class TestZipcode {
	
	@Test (expected = IllegalArgumentException.class)
	public void tooFewPrimaryThrows() {
		new Zipcode("1234");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void tooManyPrimaryThrows() {
		new Zipcode("123456");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nonNumericPrimayThrows() {
		new Zipcode("12A45");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void tooFewExtendedThrows() {
		new Zipcode("12345", "123");
	}
	
	@Test  (expected = IllegalArgumentException.class)
	public void tooManyExtendedThrows() {
		new Zipcode("12345", "12345");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nonNumericExtendedThrows() {
		new Zipcode("12345", "12B4");
	}
	
	@Test
	public void primaryBuildsAndReturnsCorrectly() {
		Zipcode zip = new Zipcode("12345");
		assertEquals("12345", zip.primary());
		assertEquals("12345", zip.toString());
	}
	
	@Test
	public void extendedBuildsAndReturnsCorrectly() {
		Zipcode zipcode = new Zipcode("12345", "6789");
		assertEquals("12345", zipcode.primary());
		assertEquals("6789", zipcode.extended());
		assertEquals("12345-6789", zipcode.toString());
	}
	
}
