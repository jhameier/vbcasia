package org.vbc4me.awanna.testGenerators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.vbc4me.awanna.account.Season;
import org.vbc4me.awanna.account.Student;
import org.vbc4me.awanna.utility.readers.StudentFileReader;

/**
 * Read test for newly created xml file format.
 *
 * Created by jbolt on 6/27/2015.
 */
public class ReadDriverTest {

  public static void main (String[] args) throws IOException {
    Path path = Paths.get("./", "VictoryAwannaFall2015.xml");
    MemberAndStaffGenerator.parse(path);
//    SeasonClosed.actions().startDate(LocalDate.now());

    File file = new File(path.toString());

    List<Student> students = StudentFileReader.parse(file);

    for(Student student : students) {
//      Season.addStudent(student);
    }

//    System.out.println("Members directory created.");
//    System.out.println("Total number of members created: " + SeasonClosed.students().size());
//    System.out.println("The actions start date is: " + SeasonClosed.actions().startDate());
//    System.out.println("The actions end date is: " + SeasonClosed.actions().endDate());

  }

}
