package org.vbc4me.awanna.testGenerators;

import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Zipcode;

import java.nio.file.Path;
import java.nio.file.Paths;

public class StaffWriteDriverTest {
	
	public StaffWriteDriverTest() {
	}
	
	public static void main(String[] args) {
		
		Staff staff1 = Staff.builder().firstName("Joe").lastName("Doe")
                .address(Address.builder()
                        .streetAddress("1234 Main Street")
                        .city("Hammonton")
                        .state("New Jersey")
                        .zipcode(Zipcode.of("08037"))
                        .create())
                .phoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "6095615432"))
				.phoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "6095679876"))
				.email("jdoe@gmail.com").specialNeeds("none")
				.emergencyContact(EmergencyContact.builder()
						.firstName("Susan")
						.lastName("Doe")
						.addPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "6095615432"))
						.create())
				.club(Club.JOURNEY)
                .title("Instructor")
                .photo(null)
                .create();
		
		Staff staff2 = Staff.builder()
                .firstName("Mary")
                .lastName("Matlin")
                .address(Address.builder()
                        .streetAddress("9587 3rd Street")
                        .city("Hammonton")
				        .state("New Jersey")
                        .zipcode(Zipcode.of("08037"))
                        .create())
                .phoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, "6095617592"))
                .phoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "6092379514"))
				.email("bhamstein1@gmail.com").specialNeeds("asthma symptoms")
                .emergencyContact(EmergencyContact.builder()
                        .firstName("Sara")
                        .lastName("Marlin")
                        .addPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, "6095671258"))
                        .create())
				.club(Club.SPARKS)
                .title("Aide")
                .photo(null)
                .create();
		
//		Season.staff().put(staff1.id(), staff1);
//		Season.staff().put(staff2.id(), staff2);
		
		Path path = Paths.get("./", "TestStaff.stf");
//		StaffFileWriter.write(path);
		
	}
	
}
