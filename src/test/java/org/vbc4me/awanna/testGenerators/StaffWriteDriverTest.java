package org.vbc4me.awanna.testGenerators;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.vbc4me.awanna.account.Club;
import org.vbc4me.awanna.account.Season;
import org.vbc4me.awanna.account.Staff;
import org.vbc4me.awanna.utility.writers.StaffFileWriter;

public class StaffWriteDriverTest {
	
	public StaffWriteDriverTest() {
	}
	
	public static void main(String[] args) {
		
		Staff staff1 = Staff.build().firstName("Joe").lastName("Doe").address("1234 Main Street").city("Hammonton")
				.state("New Jersey").zip("08037").phoneNumber("Home", "6095615432").phoneNumber("Cell", "6095679876")
				.email("jdoe@gmail.com").specialNeeds("none").emergencyContactName("Susan Doe")
				.emergencyContactNumber("Home", "6095615432").club(Club.JOURNEY).title("Instructor").photo(null).done();
		
		Staff staff2 = Staff.build().firstName("Mary").lastName("Matlin").address("9587 3rd Street").city("Hammonton")
				.state("New Jersey").zip("08037").phoneNumber("Home", "6095617592").phoneNumber("Cell", "6092379514")
				.email("bhamstein1@gmail.com").specialNeeds("asthma symptoms").emergencyContactName("Sara Marlin")
				.emergencyContactNumber("Cell", "6095671258").club(Club.SPARKS).title("Aide").photo(null).done();
		
//		Season.staff().put(staff1.id(), staff1);
//		Season.staff().put(staff2.id(), staff2);
		
		Path path = Paths.get("./", "TestStaff.stf");
//		StaffFileWriter.write(path);
		
	}
	
}
