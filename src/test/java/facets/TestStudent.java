package facets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.Test;
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.Guardian;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Photo;
import org.vbc4me.awanna.facets.Pickup;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Zipcode;

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
    Photo cPhoto = new Photo(cimage, cthumb);
    BufferedImage pimage = new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB);
    BufferedImage pthumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
    Photo pPhoto = new Photo(pimage, pthumb);
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
        .dateOfBirth(dob)
        .grade("K")
        .specialNeeds("NA")
        .studentPhoto(cPhoto)
        .guardian(Guardian.builder()
            .first("First")
            .last("Last")
            .address(Address.builder()
                .streetAddress("123 Main Street")
                .city("Some City")
                .state("NJ")
                .zipcode(Zipcode.of("12345-1234"))
                .create())
            .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "1234567890"))
            .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "9876543210"))
            .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.OFFICE, "5647382910"))
            .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.OTHER, "9182736450"))
            .emailAddress("firstlast@email.com")
            .photo(pPhoto)
            .create())
        .emergencyContact(EmergencyContact.builder()
            .firstName("First")
            .lastName("Last")
            .phoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "1324576890"))
            .create())
        .authPickup(Pickup.builder()
            .first("First")
            .last("Last")
            .relationship("Brother")
            .photo(new Photo(auth1image, auth1thumb))
            .create())
        .authPickup(Pickup.builder()
            .first("First")
            .last("Last")
            .relationship("Grandmother")
            .photo(new Photo(auth2image, auth2thumb))
            .create())
        .authPickup(Pickup.builder()
            .first("First")
            .last("Last")
            .relationship("Mother")
            .photo(new Photo(auth3image, auth3thumb))
            .create())
        .authPickup(Pickup.builder()
            .first("First")
            .last("Last")
            .relationship("Father")
            .photo(new Photo(auth4image, auth4thumb))
            .create())
        .create();
    assertEquals("First", student.firstName());
    assertEquals("Last", student.lastName());
    assertEquals("First Last", student.name());
    assertEquals(dob, student.dateOfBirth());
    // 2 ways to check age.
    //   From todays date (this changes over time) and from exact date which will always be accurate.
    assertEquals(student.age(dob), 5, 0);
    assertEquals("K", student.grade());
    assertEquals(cimage, student.photo().image());
    assertEquals(cthumb, student.photo().thumbnail());
    assertEquals("First", student.guardian().firstName());
    assertEquals("Last", student.guardian().lastName());
    assertEquals(pimage, student.guardian().photo().image());
    assertEquals(pthumb, student.guardian().photo().thumbnail());
    assertEquals("123 Main Street", student.guardian().address().streetAddress());
    assertEquals("Some City", student.guardian().address().city());
    assertEquals("NJ", student.guardian().address().state());
    assertEquals("12345-1234", student.guardian().address().zipcode().toString());
    assertEquals(4, student.guardian().phoneNumbers().size());
    assertTrue(PhoneNumber.contains(student.guardian().phoneNumbers(),
        PhoneNumber.of(PhoneNumber.Type.HOME, "1234567890")));
    assertTrue(PhoneNumber.contains(student.guardian().phoneNumbers(),
        PhoneNumber.of(PhoneNumber.Type.CELL, "9876543210")));
    assertTrue(PhoneNumber.contains(student.guardian().phoneNumbers(),
        PhoneNumber.of(PhoneNumber.Type.OFFICE, "5647382910")));
    assertTrue(PhoneNumber.contains(student.guardian().phoneNumbers(),
        PhoneNumber.of(PhoneNumber.Type.OTHER, "9182736450")));
    assertEquals("firstlast@email.com", student.guardian().emailAddress());
    assertEquals("First Last", student.emergencyContact().name());
    assertTrue(PhoneNumber.of(PhoneNumber.Type.CELL, "1324576890")
        .isEqualTo(student.emergencyContact().phoneNumber()));
  }

  // FIXME Need more tests for manual construction.
}
