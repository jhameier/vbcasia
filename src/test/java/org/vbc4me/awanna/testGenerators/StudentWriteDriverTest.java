package org.vbc4me.awanna.testGenerators;

import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.Guardian;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Photo;
import org.vbc4me.awanna.facets.Pickup;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Student.Builder;
import org.vbc4me.awanna.facets.Zipcode;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentWriteDriverTest {
	
	public StudentWriteDriverTest() {
	}
	
	public static void main(String[] args) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		Builder stBuilder1 = Student.builder().firstName("John").lastName("Doe");
		stBuilder1.grade(String.valueOf(5));
		stBuilder1.dateOfBirth(LocalDate.parse("12-14-2005", dtf));
		stBuilder1.specialNeeds("none");
		stBuilder1.guardian(Guardian.builder()
				.first("Susan")
                .last("Doe")
                .address(Address.builder()
                        .streetAddress("1234 Main Street")
                        .city("Hammonton")
                        .state("New Jersey")
                        .zipcode(Zipcode.of("08037"))
                        .create())
                .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "6095615432"))
                .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "6095679876"))
				.emailAddress("jdoe@gmail.com")
                .create());
		stBuilder1.emergencyContact(EmergencyContact.builder()
                .firstName("Susan")
                .lastName("Doe")
                .addPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "6095615432"))
                .create());
		stBuilder1.authPickup(Pickup.builder()
                .first("Bill")
                .last("Doe")
                .relationship("Dad")
                .photo(new Photo(new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB),
                        new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)))
                .create());
		stBuilder1.authPickup(Pickup.builder()
                .first("Harry")
                .last("Johnson")
                .relationship("Brother")
                .photo(new Photo(new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB),
                        new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)))
                .create());

		Builder stBuilder2 = Student.builder().firstName("Mary").lastName("Matlin")
                .grade(String.valueOf(3))
                .dateOfBirth(LocalDate.parse("07-21-2007", dtf))
                .specialNeeds("asthma symptoms");
		stBuilder2.guardian(Guardian.builder()
                .first("Bart")
                .last("Hamstein")
                .streetAddress("9587 3rd Street")
                .city("Hammonton")
                .state("New Jersey")
                .zipcode(Zipcode.of("08037"))
                .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "6095617592"))
                .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "6092379514"))
                .emailAddress("bhamstein1@gmail.com")
                .create());
		stBuilder2.emergencyContact(EmergencyContact.builder()
                .firstName("Sara")
                .lastName("Marlin")
                .addPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "6095671258"))
                .create());
		stBuilder2.authPickup(Pickup.builder()
                        .first("Sarah")
                        .last("Miller")
                        .relationship("Grandmother")
                        .photo(new Photo(new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB),
                                new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)))
                        .create())
                  .authPickup(Pickup.builder()
                        .first("Flex")
                        .last("Hanson")
                        .relationship("Uncle")
                        .photo(new Photo(new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB),
                                new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)))
                        .create());

		Student student1 = stBuilder1.create();
		Student student2 = stBuilder2.create();
//		Season.addStudent(student1);
//		Season.addStudent(student2);
		
		Path path = Paths.get("./", "TestStudent.stu");
//		boolean written = StudentFileWriter.writeFile(path, "all");
		
	}
	
}
