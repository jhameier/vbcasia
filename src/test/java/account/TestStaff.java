package account;

import org.junit.Test;
import org.vbc4me.awanna.account.Club;
import org.vbc4me.awanna.account.PhoneNumber;
import org.vbc4me.awanna.account.Staff;

import junit.framework.Assert;

public class TestStaff {
	
	@Test
	public void TestStaffCreation() {
		Staff member = Staff.build()
				                               .title("Title")
				                               .club(Club.CUBBIES)
											   .firstName("First")
											   .lastName("Last")
											   .address("1234 Main Street")
											   .city("Some City")
											   .state("NJ")
											   .zip("12345-6789")
											   .phoneNumber("Home", "1234567890")
											   .phoneNumber("Cell", "0987654321")
											   .phoneNumber("Other", "5467382910")
											   .specialNeeds("NA")
											   .email("firstLast@email.com")
											   .emergencyContactName("EmerContact")
											   .emergencyContactNumber("Cell", "9182734650")
											   .done();
		
		Assert.assertEquals("Title", member.title());
		Assert.assertEquals("First", member.firstName());
		Assert.assertEquals("Last", member.lastName());
		Assert.assertEquals("1234 Main Street", member.address());
		Assert.assertEquals("Some City", member.city());
		Assert.assertEquals("NJ", member.state());
		Assert.assertEquals("12345-6789", member.zip());
		PhoneNumber one = member.phoneNumbers().get(0);
		PhoneNumber two = member.phoneNumbers().get(1);
		PhoneNumber three = member.phoneNumbers().get(2);
		Assert.assertEquals(3, member.phoneNumbers().size());
		Assert.assertTrue(PhoneNumber.contains(member.phoneNumbers(), one));
		Assert.assertTrue(PhoneNumber.contains(member.phoneNumbers(), two));
		Assert.assertTrue(PhoneNumber.contains(member.phoneNumbers(), three));
		Assert.assertEquals("NA", member.specialNeeds());
		Assert.assertEquals("firstLast@email.com", member.email());
		// TODO Add check for Image Container
	}
	
	/**
	 * Test absent required first and last name fields throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestAbsentRequiredThrows() {
		@SuppressWarnings("unused")
		Staff member = Staff.build().done();
	}
	
	/**
	 * Test absent required first name field throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestAbsentRequiredFirstNameThrows() {
		@SuppressWarnings("unused")
		Staff member = Staff.build().lastName("Last").done();
	}
	
	/**
	 * Test absent required last name field throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestAbsentRequiredLastNameThrows() {
		@SuppressWarnings("unused")
		Staff member = Staff.build().firstName("First").done();
	}
}
