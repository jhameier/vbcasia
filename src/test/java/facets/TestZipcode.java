package facets;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vbc4me.awanna.facets.Zipcode;

public class TestZipcode {
	
	@Test (expected = IllegalArgumentException.class)
	public void tooFewPrimaryThrows() {
		Zipcode.of("1234");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void tooManyPrimaryThrows() {
		Zipcode.of("123456");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nonNumericPrimayThrows() {
		Zipcode.of("12A45");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void tooFewExtendedThrows() {
		Zipcode.of("12345-123");
	}
	
	@Test  (expected = IllegalArgumentException.class)
	public void tooManyExtendedThrows() {
		Zipcode.of("12345-12345");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nonNumericExtendedThrows() {
		Zipcode.of("12345-12B4");
	}
	
	@Test
	public void primaryBuildsAndReturnsCorrectly() {
		Zipcode zip = Zipcode.of("12345");
		assertEquals("12345", zip.primary());
		assertEquals("12345", zip.toString());
	}
	
	@Test
	public void extendedBuildsAndReturnsCorrectly() {
		Zipcode zipcode = Zipcode.of("12345-6789");
		assertEquals(zipcode.primary(), "12345");
		assertEquals(zipcode.extended(), "6789");
		assertEquals(zipcode.toString(), "12345-6789");
	}
}
