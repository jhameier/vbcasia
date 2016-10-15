package account;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.vbc4me.awanna.account.PhoneNumber;
import org.vbc4me.awanna.account.Student;

public class TestStudent {
	
	@Test
	public void TestStudentCreation() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		formatter = formatter.withLocale(Locale.US);
		LocalDate dob = LocalDate.parse("03/04/2012", formatter);
		BufferedImage cimage = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage cthumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage pimage = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage pthumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth1image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth1thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth2image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth2thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth3image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth3thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth4image = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
		BufferedImage auth4thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		Student student = Student.build()
				                                          .firstName("First")
				                                          .lastName("Last")
				                                          .childDOB(dob)
				                                          .childGrade("K")
				                                          .specialNeeds("NA")
				                                          .childPhoto(cimage)
				                                          .childThumbnail(cthumb)
				                                          .parentFirstName("First")
				                                          .parentLastName("Last")
				                                          .parentPhoto(pimage)
				                                          .parentThmbnail(pthumb)
				                                          .address("123 Main Street")
				                                          .city("Some City")
				                                          .state("NJ")
				                                          .zip("12345-1234")
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
    	Assert.assertEquals("First", student.childFirstName());
    	Assert.assertEquals("Last", student.childLastName());
    	Assert.assertEquals("First Last", student.childFullName());
    	Assert.assertEquals(dob, student.childDOB());
    	// 2 ways to check age. 
    	//   From todays date (this changes over time) and from exact date which will always be accurate.
    	Assert.assertEquals(4, student.childAge(dob), 0);
    	Assert.assertEquals("K", student.childGrade());
    	Assert.assertEquals(cimage, student.childPhoto());
    	Assert.assertEquals(cthumb, student.childThumbnail());
    	Assert.assertEquals("First", student.parentFirstName());
    	Assert.assertEquals("Last", student.parentLastName());
    	Assert.assertEquals(pimage, student.parentPhoto());
    	Assert.assertEquals(pthumb, student.parentThumbnail());
    	Assert.assertEquals("123 Main Street", student.address());
    	Assert.assertEquals("Some City", student.city());
    	Assert.assertEquals("NJ", student.state());
    	Assert.assertEquals("12345-1234", student.zip());
    	Assert.assertEquals(4, student.phoneNumbers().size());
    	Assert.assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Home", "1234567890")));
    	Assert.assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Cell", "9876543210")));
    	Assert.assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Work", "5647382910")));
    	Assert.assertTrue(PhoneNumber.contains(student.phoneNumbers(), new PhoneNumber("Other","9182736450")));
    	Assert.assertEquals("firstlast@email.com", student.email());
    	Assert.assertEquals("First Last", student.emergencyContactName());
    	Assert.assertTrue(new PhoneNumber("Cell", "1324576890").isEqualTo(student.emergencyContactPhone()));
	}
	
	// FIXME Need more tests for manual construction.
}
