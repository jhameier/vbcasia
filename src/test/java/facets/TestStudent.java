package facets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Test;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Photo;
import org.vbc4me.awanna.facets.Student;

public class TestStudent {
	
	@Test
	public void testEmailCreation() {
		
	}
	
	@Test
	public void testStudentCreation() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		formatter = formatter.withLocale(Locale.US);
		LocalDate dob = LocalDate.parse("03/04/2012", formatter);
		BufferedImage cimage = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage cthumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Photo cPhoto = new Photo(Paths.get("child/cimage.jpg"), cimage, Paths.get("child/cthumb.jpg"), cthumb);
		BufferedImage pimage = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage pthumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Photo pPhoto = new Photo(Paths.get("child/pimage.jpg"), cimage, Paths.get("child/pthumb.jpg"), cthumb);
		BufferedImage auth1image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth1thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth2image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth2thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth3image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth3thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth4image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth4thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		Student student = Student.builder()
				                                          .firstName("First")
				                                          .lastName("Last")
				                                          .childDOB(dob)
				                                          .childGrade("K")
				                                          .specialNeeds("NA")
				                                          .childPhoto(cPhoto)
				                                          .parentFirstName("First")
				                                          .parentLastName("Last")
				                                          .parentPhoto(pPhoto)
				                                          .address("123 Main Street")
				                                          .city("Some City")
				                                          .state("NJ")
				                                          .zip("12345", "1234")
				                                          .phoneNumber("Home", "1234567890")
				                                          .phoneNumber("Cell", "9876543210")
				                                          .phoneNumber("Work", "5647382910")
				                                          .phoneNumber("Other","9182736450")
				                                          .emailAddress("firstlast@email.com")
				                                          .emergencyContactName("First Last")
				                                          .emergencyContactPhone(new PhoneNumber("Cell", "1324576890"))
				                                          .authPickup("First", "Last", "Brother", auth1image, auth1thumb)
				                                          .authPickup("First", "Last", "Grandmother", auth2image, auth2thumb)
				                                          .authPickup("First", "Last", "Mother", auth3image, auth3thumb)
				                                          .authPickup("First", "Last", "Father", auth4image, auth4thumb)
														  .done();
    	assertEquals("First", student.childFirstName());
    	assertEquals("Last", student.childLastName());
    	assertEquals("First Last", student.childFullName());
    	assertEquals(dob, student.childDOB());
    	// 2 ways to check age. 
    	//   From todays date (this changes over time) and from exact date which will always be accurate.
    	assertEquals(4, student.childAge(dob), 0);
    	assertEquals("K", student.childGrade());
    	assertEquals(cimage, student.childPhoto());
    	assertEquals(cthumb, student.childThumbnail());
    	assertEquals("First", student.parentFirstName());
    	assertEquals("Last", student.parentLastName());
    	assertEquals(pimage, student.parentPhoto());
    	assertEquals(pthumb, student.parentThumbnail());
    	assertEquals("123 Main Street", student.address());
    	assertEquals("Some City", student.city());
    	assertEquals("NJ", student.state());
    	assertEquals("12345-1234", student.zip());
    	assertEquals(4, student.phoneNumbers().size());
    	assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Home", "1234567890")));
    	assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Cell", "9876543210")));
    	assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Work", "5647382910")));
    	assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Other","9182736450")));
    	assertEquals("firstlast@email.com", student.email());
    	assertEquals("First Last", student.emergencyContactName());
    	assertTrue(new PhoneNumber("Cell", "1324576890").isEqualTo(student.emergencyContactPhone()));
	}
	
	// FIXME Need more tests for manual construction.
}
