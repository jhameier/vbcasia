package org.vbc4me.awanna.utility.readers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.joda.money.Money;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Session;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Student;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SeasonFileReader {

  public static Season parse(File file) throws Exception {
    Objects.requireNonNull(file);

    SAXBuilder saxBuilder = new SAXBuilder();
    try {
      Document document = saxBuilder.build(file);
      Element root = document.getRootElement();
      UUID seasonId = UUID.fromString(root.getAttributeValue("id"));
      String seasonName = root.getAttributeValue("name");

      // Get the session element and extract info
      Element sessionElement = root.getChild("session");
      UUID sessionId = UUID.fromString(sessionElement.getAttributeValue("id"));
      LocalDate startDate = LocalDate.parse(sessionElement.getChildText("startdate"));
      LocalDate endDate = LocalDate.parse(sessionElement.getChildText("enddate"));

      // Instantiate the session builder
      Session.Builder sessionBuilder = Session.builder()
          .id(sessionId)
          .startDate(startDate)
          .endDate(endDate);

      // Add the activities to the Session
      for (Element element : sessionElement.getChild("activities").getChildren()) {
        Activity activity = Activity.builder()
            .id(UUID.fromString(element.getAttributeValue("id")))
            .date(LocalDate.parse(element.getChildText("date")))
            .time(LocalTime.parse(element.getChildText("time")))
            .name(element.getChildText("event"))
            .description(element.getChildText("description"))
            .cost(Money.parse(element.getChildText("cost")))
            .create();
        sessionBuilder.activity(activity);
      }

      // Create the season
      Season season = Season.builder()
          .id(seasonId)
          .name(seasonName)
          .session(sessionBuilder.build())
          .build();

      // Add the students
      List<Student> students = StudentFileReader.parse(file);
      for (Student student : students) {
        season.addStudent(student);
      }

      // Add the staff
      List<Staff> personnel = StaffFileReader.parse(file);
      for (Staff staff : personnel) {
        season.addStaff(staff);
      }

      return season;

    } catch (JDOMException | IOException e) {
      e.printStackTrace();
    }

    throw new Exception("Unknown error occured reading the Season file exiting.");
  }
}
