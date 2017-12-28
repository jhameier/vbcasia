package org.vbc4me.awanna.utility.readers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Session;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Student;

public class SeasonFileReader {

  public Season parse(File file) {
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
        UUID activityId = UUID.fromString(element.getAttributeValue("id"));
        String event = element.getChildText("event");
        String description = element.getChildText("description");
        LocalDate date = LocalDate.parse(element.getChildText("date"));
        LocalTime time = LocalTime.parse(element.getChildText("time"));
        double cost = Double.parseDouble(element.getChildText("cost"));

        Activity activity = Activity.builder()
            .id(activityId)
            .date(date)
            .time(time)
            .name(event)
            .description(description)
            .cost(Money.of(CurrencyUnit.USD, cost))
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


    } catch (JDOMException | IOException e) {
      e.printStackTrace();
    }

    String name = "AwannaTest";
    return null;
  }
}
