package facets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;

import org.junit.Test;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.Person;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Staff;

public class TestStaff {
	
	@Test
	public void TestStaffCreation() {
		BufferedImage photo = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage thumbnail = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
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
											   .photo(photo)
											   .thumbnail(thumbnail)
											   .done();
		
		assertEquals(member.recordType(), Person.Type.STAFF.name());
		assertEquals("Title", member.title());
		assertEquals("First", member.firstName());
		assertEquals("Last", member.lastName());
		assertEquals("1234 Main Street", member.address());
		assertEquals("Some City", member.city());
		assertEquals("NJ", member.state());
		assertEquals("12345-6789", member.zip());
		PhoneNumber one = member.phoneNumbers().get(0);
		PhoneNumber two = member.phoneNumbers().get(1);
		PhoneNumber three = member.phoneNumbers().get(2);
		assertEquals(3, member.phoneNumbers().size());
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), one));
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), two));
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), three));
		assertEquals("NA", member.specialNeeds());
		assertEquals("firstLast@email.com", member.email());
		assertEquals(photo, member.photo());
		assertEquals(thumbnail, member.thumbnail());
	}
	
	/**
	 * Test that individual setters work as intended.
	 */
	@Test
	public void TestIndividualSettersWork() {
		Staff member = Staff.build().firstName("First").lastName("Last").done();
		assertEquals("First", member.firstName());
		assertEquals("Last", member.lastName());
		assertEquals(member.recordType(), Person.Type.STAFF.name());
		member.title("Teacher");
		assertEquals("Teacher", member.title());
		member.address("123 Main Street");
		assertEquals("123 Main Street", member.address());
		member.city("Some City");
		assertEquals("Some City", member.city());
		member.state("NJ");
		assertEquals("NJ", member.state());
		member.zip("12345-6789");
		assertEquals("12345-6789", member.zip());
		member.addUnformattedPhoneNumber("Home", "1234567890");
		member.addUnformattedPhoneNumber("Cell", "0987654321");
		member.addUnformattedPhoneNumber("Other", "5467382910");
		PhoneNumber one = member.phoneNumbers().get(0);
		PhoneNumber two = member.phoneNumbers().get(1);
		PhoneNumber three = member.phoneNumbers().get(2);
		assertEquals(3, member.phoneNumbers().size());
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), one));
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), two));
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), three));
		member.addSpecialNeed("NA");
		assertEquals("NA", member.specialNeeds());
		member.email("firstLast@email.com");
		assertEquals("firstLast@email.com", member.email());
		BufferedImage photo = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		member.photo(photo);
		assertEquals(photo, member.photo());
		BufferedImage thumbnail = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		member.thumbnail(thumbnail);
		assertEquals(thumbnail, member.thumbnail());
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
