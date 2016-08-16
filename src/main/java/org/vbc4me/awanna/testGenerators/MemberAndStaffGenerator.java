package org.vbc4me.awanna.testGenerators;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.vbc4me.awanna.account.Club;
import org.vbc4me.awanna.account.Season;
import org.vbc4me.awanna.account.Staff;
import org.vbc4me.awanna.account.Student;
import org.vbc4me.awanna.account.Student.Builder;
import org.vbc4me.awanna.utility.writers.StudentFileWriter;

public final class MemberAndStaffGenerator {
	
	public static void parse(Path path) {
		// Build list with name and address by reading in files
		List<String> names = new ArrayList<>();
		List<String> firstnames = new ArrayList<>();
		List<String> addresses = new ArrayList<>();
		
		read("names.txt", names);
		read("firstNames.txt", firstnames);
		read("addresses.txt", addresses);
		
		/*
		 * Get Student Name from namesList Generate random Age Based off of Age
		 * get Grade generate random birthday (month, day) year calculated
		 * Generate random set of special needs Get First Name and use students
		 * last name Get Address & tokenize to get street address city state zip
		 * code phone number Create email adress fist initial and lastname
		 * .email.com Create Emergency Contact
		 *
		 * Create a random number of authorized pickups Get random number from 2
		 * to 4 Get name from names list Random Select from list relation
		 *
		 * Puggles ~ 2-3 years old Cubbies ~ 3-5 years old Sparks ~ 6-7 years
		 * old (grades 1,2 ) Truth & Training (T&T) ~ years 8-11 (grades
		 * 3,4,5,6)
		 *
		 */
		
		Random random = new Random();
		String[] relation = { "Aunt", "Uncle", "Grandmother", "Grandfather", "Brother", "Sister", "Mother", "Father" };
		
		for (int i = 0; i < 100; ++i) { // 100 student file
			String[] cname = names.remove(random.nextInt(names.size())).trim().split(" ");
			String[] pname = { firstnames.remove(random.nextInt(firstnames.size())).trim(), cname[1] };
			String[] addr = addresses.remove(random.nextInt(addresses.size())).trim().split(",");
			String email = pname[0].substring(0, 1) + pname[1] + "@email.com";
			int num = random.nextInt(8999) + 1000;
			String cell = addr[5].substring(0, 11) + String.valueOf(num);
			int age = random.nextInt(10) + 2; // ages 2 - 11
			String grade = parseGrade(age);
			LocalDate dob = parseDate(age, random);
			int ap = random.nextInt(4) + 1; // number of authorized pickups
			
			Builder sb = Student.build();
			sb.firstName(cname[0].trim()).lastName(cname[1].trim()).childGrade(grade).childDOB(dob)
					.parentFirstName(pname[0]).parentLastName(pname[1]).address(addr[0].trim()).city(addr[1].trim())
					.state(addr[2].trim()).zip(addr[3].trim()).phoneNumber("home", addr[5].trim())
					.phoneNumber("cell", cell.trim()).emailAddress(email).specialNeeds(specialNeed(random));
			
			// Authorized Pickups
			for (int j = 0; j < ap; ++j) {
				int rr = random.nextInt(relation.length);
				String[] name = names.remove(random.nextInt(names.size())).trim().split(" ");
				sb.authPickup(name[0], name[1], relation[rr], 
						new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB), 
						new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
			}
			Season.addStudent(sb.done());
		} // end create students
		
		// Create Staff 25
		for (int i = 0; i < 25; ++i) {
			String[] cname = names.remove(random.nextInt(names.size())).trim().split(" ");
			String[] addr = addresses.remove(random.nextInt(addresses.size())).trim().split(",");
			String email = cname[0].substring(0, 1) + cname[1] + "@email.com";
			int num = random.nextInt(8999) + 1000;
			String cell = addr[5].substring(0, 11) + String.valueOf(num);
			String[] ecname = { firstnames.remove(random.nextInt(firstnames.size())).trim(), cname[1] };
			int num2 = random.nextInt(8999) + 1000;
			String ecPhone = addr[5].substring(0, 11) + String.valueOf(num2);
			
			Staff staff = Staff.build().firstName(cname[0]).lastName(cname[1]).address(addr[0].trim())
					.city(addr[1].trim()).state(addr[2].trim()).zip(addr[3].trim()).phoneNumber("home", addr[5].trim())
					.phoneNumber("cell", cell.trim()).email(email).specialNeeds(specialNeed(random))
					.emergencyContactName(ecname[0] + " " + ecname[1]).emergencyContactNumber("cell", ecPhone)
					.title("Some Title").club(Club.CUBBIES).photo(null).done();
			Season.addStaff(staff);
		}
		
		// Write files out		
		StudentFileWriter.writeFile(path, "all");
	}
	
	private static void read(String fileName, List<String> names) {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)));) {
			String line;
			while ((line = reader.readLine()) != null) {
				names.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static LocalDate parseDate(int age, Random random) {
		int month = random.nextInt(12) + 1;
		int day;
		if (month == 2) {
			day = random.nextInt(28) + 1;
		} else {
			day = random.nextInt(30) + 1;
		}
		return LocalDate.of(2015 - age, month, day);
	}
	
	private static String parseGrade(int age) {
		switch (age) {
			case 5:
				return "Kintergarten";
			case 6:
				return "First";
			case 7:
				return "Second";
			case 8:
				return "Third";
			case 9:
				return "Fourth";
			case 10:
				return "Fifth";
			case 11:
				return "Sixth";
			default:
				return "PreK";
		}
	}
	
	private static String specialNeed(Random random) {
		switch (random.nextInt(16)) {
			case 0:
				return "Autistic";
			case 4:
				return "Deafness";
			case 8:
				return "Epilepsy";
			case 12:
				return "Attention Deficet Disorder";
			default:
				return "NA";
		}
	}
}
