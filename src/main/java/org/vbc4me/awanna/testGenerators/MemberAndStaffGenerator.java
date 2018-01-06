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
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.Guardian;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Pickup;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Student.Builder;
import org.vbc4me.awanna.facets.Zipcode;
import org.vbc4me.awanna.gui.picture.Photo;

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
    String[] relation = {"Aunt", "Uncle", "Grandmother", "Grandfather", "Brother", "Sister", "Mother", "Father"};
    List<Student> students = new ArrayList<>();

    for (int i = 0; i < 100; ++i) { // 100 student file
      String[] cname = names.remove(random.nextInt(names.size())).trim().split(" ");
      String[] pname = {firstnames.remove(random.nextInt(firstnames.size())).trim(), cname[1]};
      String[] addr = addresses.remove(random.nextInt(addresses.size())).trim().split(",");
      String email = pname[0].substring(0, 1) + pname[1] + "@email.com";
      int num = random.nextInt(8999) + 1000;
      String cell = addr[5].substring(0, 11) + String.valueOf(num);
      int age = random.nextInt(10) + 2; // ages 2 - 11
      String grade = parseGrade(age);
      LocalDate dob = parseDate(age, random);
      int ap = random.nextInt(4) + 1; // number of authorized pickups

      Guardian guardian = Guardian.builder()
          .first(pname[0])
          .last(pname[1])
          .address(Address.builder()
              .streetAddress(addr[0].trim())
              .city(addr[1].trim())
              .state(addr[2].trim())
              .zipcode(Zipcode.of(addr[3].trim()))
              .create())
          .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, addr[5].trim()))
          .setPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, cell.trim()))
          .emailAddress(email)

          .create();

      Builder sb = Student.builder()
          .firstName(cname[0].trim())
          .lastName(cname[1].trim())
          .grade(grade)
          .dateOfBirth(dob)
          .guardian(guardian)
          .specialNeeds(specialNeed(random));

      // Authorized Pickups
      for (int j = 0; j < ap; ++j) {
        int rr = random.nextInt(relation.length);
        String[] name = names.remove(random.nextInt(names.size())).trim().split(" ");
        Pickup p = Pickup.builder()
            .first(name[0])
            .last(name[1])
            .relationship(relation[rr])
            .photo(new Photo(new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB),
                new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)))
            .create();
        sb.authPickup(p);
      }

      students.add(sb.create());
    } // end create students

    // Create Staff 25
    List<Staff> personnel = new ArrayList<>();
    for (int i = 0; i < 25; ++i) {
      String[] cname = names.remove(random.nextInt(names.size())).trim().split(" ");
      String[] addr = addresses.remove(random.nextInt(addresses.size())).trim().split(",");
      String email = cname[0].substring(0, 1) + cname[1] + "@email.com";
      int num = random.nextInt(8999) + 1000;
      String cell = addr[5].substring(0, 11) + String.valueOf(num);
      String[] ecname = {firstnames.remove(random.nextInt(firstnames.size())).trim(), cname[1]};
      int num2 = random.nextInt(8999) + 1000;
      String ecPhone = addr[5].substring(0, 11) + String.valueOf(num2);

      Staff staff = Staff.builder()
          .firstName(cname[0])
          .lastName(cname[1])
          .address(Address.builder()
              .streetAddress(addr[0].trim())
              .city(addr[1].trim())
              .state(addr[2].trim())
              .zipcode(Zipcode.of(addr[3].trim()))
              .create())
          .phoneNumber(PhoneNumber.of(PhoneNumber.Type.HOME, addr[5].trim()))
          .phoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, cell.trim()))
          .email(email)
          .specialNeeds(specialNeed(random))
          .emergencyContact(EmergencyContact.builder()
              .firstName(ecname[0])
              .lastName(ecname[1])
              .addPhoneNumber(PhoneNumber.of(PhoneNumber.Type.CELL, ecPhone))
              .create())
          .title("Some Title")
          .club(Club.CUBBIES)
          .photo(new Photo(new BufferedImage(480, 640, BufferedImage.TYPE_INT_RGB),
              new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB)))
          .create();
      personnel.add(staff);
    }

    // Write files out
//		StudentFileWriter.writeFile(path, "all");
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
        return "Attention Deficit Disorder";
      default:
        return "NA";
    }
  }
}
