package org.vbc4me.awanna.testGenerators;

import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Student.Builder;
import org.vbc4me.awanna.utility.writers.StudentFileWriter;

public class StudentWriteDriverTest {
	
	public StudentWriteDriverTest() {
	}
	
	public static void main(String[] args) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		Builder stBuilder1 = Student.build().firstName("John").lastName("Doe");
		stBuilder1.childGrade(String.valueOf(5));
		stBuilder1.childDOB(LocalDate.parse("12-14-2005", dtf));
		stBuilder1.specialNeeds("none");
		stBuilder1.parentFirstName("Susan").parentLastName("Doe");
		stBuilder1.address("1234 Main Street").city("Hammonton").state("New Jersey").zip("08037");
		stBuilder1.phoneNumber("Home", "6095615432").phoneNumber("Cell", "6095679876");
		stBuilder1.emailAddress("jdoe@gmail.com");
		stBuilder1.childPhoto(null).parentPhoto(null);
		stBuilder1.emergencyContactName("Susan Doe").emergencyContactPhone(new PhoneNumber("Home", "6095615432"));
		stBuilder1.authPickup("Bill", "Doe", "Dad", new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB),
																						    new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)) 
						   .authPickup("Harry", "Johnson", "Brother", new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB),
								   																				new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
		
		Builder stBuilder2 = Student.build().firstName("Mary").lastName("Matlin");
		stBuilder2.childGrade(String.valueOf(3));
		stBuilder2.childDOB(LocalDate.parse("07-21-2007", dtf));
		stBuilder2.specialNeeds("asthma symptoms");
		stBuilder2.parentFirstName("Bart").parentLastName("Hamstein");
		stBuilder2.address("9587 3rd Street").city("Hammonton").state("New Jersey").zip("08037");
		stBuilder2.phoneNumber("Home", "6095617592").phoneNumber("Cell", "6092379514");
		stBuilder2.emailAddress("bhamstein1@gmail.com");
		stBuilder2.childPhoto(null).parentPhoto(null);
		stBuilder2.emergencyContactName("Sara Marlin").emergencyContactPhone(new PhoneNumber("Cell", "6095671258"));
		stBuilder2.authPickup("Sarah", "Miller", "Grandmother", new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB), 
																													   new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB))
							.authPickup("Flex", "Hanson", "Uncle", new BufferedImage(480,640, BufferedImage.TYPE_INT_RGB), 
																										new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
		
		Student student1 = stBuilder1.done();
		Student student2 = stBuilder2.done();
//		Season.addStudent(student1);
//		Season.addStudent(student2);
		
		Path path = Paths.get("./", "TestStudent.stu");
//		boolean written = StudentFileWriter.writeFile(path, "all");
		
	}
	
}
