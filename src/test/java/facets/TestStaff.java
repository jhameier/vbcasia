package facets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import org.junit.Test;
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.Person;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Photo;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Zipcode;

public class TestStaff {
	
	@Test
	public void TestStaffCreation() {
		BufferedImage image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage thumbnail = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		Staff member = Staff.builder()
				.title("Title")
        .club(Club.CUBBIES)
        .firstName("First")
        .lastName("Last")
        .address(Address.builder()
            .streetAddress("1234 Main Street")
            .city("Some City")
            .state("NJ")
            .zipcode(Zipcode.of("12345-6789"))
            .create())
        .phoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "1234567890"))
        .phoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "0987654321"))
        .phoneNumber(PhoneNumber.of(PhoneNumber.Type.OTHER, "5467382910"))
        .specialNeeds("NA")
        .email("firstLast@email.com")
        .emergencyContact(EmergencyContact.builder()
            .firstName("Emergency")
            .lastName("Contact")
            .addPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "9182734650"))
            .create())
        .photo(new Photo(image, thumbnail))
        .create();
		
		assertEquals(member.recordType(), Person.Type.STAFF.name());
		assertEquals("Title", member.title());
		assertEquals("First", member.firstName());
		assertEquals("Last", member.lastName());
		assertEquals("1234 Main Street", member.address().streetAddress());
		assertEquals("Some City", member.address().city());
		assertEquals("NJ", member.address().state());
		assertEquals("12345-6789", member.address().zipcode().toString());
		PhoneNumber one = member.phoneNumbers().get(0);
		PhoneNumber two = member.phoneNumbers().get(1);
		PhoneNumber three = member.phoneNumbers().get(2);
		assertEquals(3, member.phoneNumbers().size());
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), one));
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), two));
		assertTrue(PhoneNumber.contains(member.phoneNumbers(), three));
		assertEquals("NA", member.specialNeeds());
		assertEquals("firstLast@email.com", member.email());
		assertEquals(member.photo().image(), image);
		assertEquals(member.photo().thumbnail(), thumbnail);
	}
	
	/**
	 * Test that individual setters work as intended.
	 */
	@Test
	public void TestIndividualSettersWork() {
		Staff member = Staff.builder().firstName("First").lastName("Last").create();
		assertEquals("First", member.firstName());
		assertEquals("Last", member.lastName());
		assertEquals(member.recordType(), Person.Type.STAFF.name());
		member.title("Teacher");
		assertEquals("Teacher", member.title());
		member.updateAddress(Address.builder()
                .streetAddress("123 Main Street")
                .city("Some City")
                .state("NJ")
                .zipcode(Zipcode.of("12345-6789"))
                .create());
		assertEquals("123 Main Street", member.address().streetAddress());
		assertEquals("Some City", member.address().city());
		assertEquals("NJ", member.address().state());
		assertEquals("12345-6789", member.address().zipcode().toString());

		member.addUnformattedPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "1234567890"));
		member.addUnformattedPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "0987654321"));
		member.addUnformattedPhoneNumber(PhoneNumber.of(PhoneNumber.Type.OTHER, "5467382910"));
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
		BufferedImage image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage thumbnail = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		member.photo(new Photo(image, thumbnail));
		assertEquals(image, member.photo().image());
		assertEquals(thumbnail, member.photo().thumbnail());
	}
	
	/**
	 * Test absent required first and last name fields throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestAbsentRequiredThrows() {
		Staff.builder().create();
	}
	
	/**
	 * Test absent required first name field throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestAbsentRequiredFirstNameThrows() {
		Staff.builder().lastName("Last").create();
	}
	
	/**
	 * Test absent required last name field throws.
	 */
	@Test (expected = NullPointerException.class)
	public void TestAbsentRequiredLastNameThrows() {
		Staff.builder().firstName("First").create();
	}
}
