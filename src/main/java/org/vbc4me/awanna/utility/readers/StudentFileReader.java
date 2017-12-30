package org.vbc4me.awanna.utility.readers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.joda.money.Money;
import org.vbc4me.awanna.facets.Account;
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.Guardian;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Photo;
import org.vbc4me.awanna.facets.Pickup;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Transaction;
import org.vbc4me.awanna.facets.Zipcode;
import org.vbc4me.awanna.utility.Utilities;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentFileReader extends DefaultHandler {

  public static List<Student> parse(File file) {

    if (!file.exists() || !file.canRead()) {
      throw new IllegalArgumentException("File must exist and be readable");
    }

    SAXBuilder saxBuilder = new SAXBuilder();

    List<Student> students = new ArrayList<>();
    try {
      Document document = saxBuilder.build(file);
      Element root = document.getRootElement();
      List<Element> list = root.getChild("students").getChildren();

      for (Element student : list) {

        String first = student.getAttributeValue("first");
        String last = student.getAttributeValue("last");

        Student.Builder studentBuilder = Student.builder().firstName(first).lastName(last)
            .studentId(student.getAttributeValue("id"))
            .grade(student.getChildText("grade"))
            .dateOfBirth(LocalDate.parse(student.getChildText("dob")))
            .specialNeeds(student.getChildText("specialneeds"))
            .club(Club.get(student.getChildText("club")));

        if (student.getChild("photo") != null) {
          Element photo = student.getChild("photo");
          BufferedImage image = Utilities.decodePhoto(photo.getChildText("image"));
          BufferedImage thumb = Utilities.decodePhoto(photo.getChildText("thumbnail"));
          studentBuilder.studentPhoto(new Photo(image, thumb));
        }


        Element guardianElement = student.getChild("guardian");
        Guardian.Builder guardianBuilder = Guardian.builder()
            .id(guardianElement.getAttributeValue("id"))
            .first(guardianElement.getAttributeValue("first"))
            .last(guardianElement.getAttributeValue("last"))
            .address(Address.builder()
                .streetAddress(guardianElement.getChild("address").getChildText("streetAddress"))
                .city(guardianElement.getChild("address").getChildText("city"))
                .state(guardianElement.getChild("address").getChildText("state"))
                .zipcode(Zipcode.of(guardianElement.getChild("address").getChildText("zipcode")))
                .create())
            .emailAddress(guardianElement.getChildText("emailaddress"));
        List<Element> ph = guardianElement.getChild("phonenumber").getChildren();
        for (Element phone : ph) {
          guardianBuilder.setPhoneNumber(
              PhoneNumber.of(PhoneNumber.Type.valueOf(phone.getName().toUpperCase()), phone.getText()));
        }
        studentBuilder.guardian(guardianBuilder.create());

        List<Element> pu = student.getChild("authorizedpickup").getChildren();
        for (Element pickup : pu) {
          Pickup.Builder pub = Pickup.builder()
              .first(pickup.getChildText("first"))
              .last(pickup.getChildText("last"))
              .relationship(pickup.getChildText("relationship"));

          if (pickup.getChild("photo") != null) {
            pub.photo(new Photo(Utilities.decodePhoto(pickup.getChild("photo").getChildText("image")),
                Utilities.decodePhoto(pickup.getChild("photo").getChildText("thumb"))));
          }
          studentBuilder.authPickup(pub.create());
        }

        Element emerContactElement = student.getChild("emergencycontact");
        EmergencyContact.Builder emContactBuilder = EmergencyContact.builder()
            .id(UUID.fromString(emerContactElement.getAttributeValue("id")))
            .firstName(emerContactElement.getAttributeValue("first"))
            .lastName(emerContactElement.getAttributeValue("last"));

        List<Element> emPhone = emerContactElement.getChild("phonenumber").getChildren();
        for (Element phone : emPhone) {
          emContactBuilder.addPhoneNumber(
              PhoneNumber.of(PhoneNumber.Type.valueOf(phone.getName().toUpperCase()), phone.getText()));
        }
        studentBuilder.emergencyContact(emContactBuilder.create());

        Element accountElement = student.getChild("account");
        Account account = new Account(UUID.fromString(accountElement.getAttributeValue("id")));
        account.adjustBalance(Money.parse(accountElement.getAttributeValue("balance")));

        List<Element> transactions = accountElement.getChild("transactions").getChildren();
        for (Element trans : transactions) {
          Transaction.Builder transBuilder = Transaction.builder()
              .trasactionId(UUID.fromString(trans.getAttributeValue("id")))
              .datetime(LocalDateTime.parse(trans.getAttributeValue("datetime")))
              .type(Transaction.Type.valueOf(trans.getAttributeValue("type").toUpperCase()))
              .amount(Money.parse(trans.getAttributeValue("amount")))
              .description(trans.getChildText("description"));
          if (trans.getChild("activityId") != null) {
            transBuilder.activityId(UUID.fromString(trans.getChildText("activityId")));
          }
          account.insertTransaction(transBuilder.create());
        }

        students.add(studentBuilder.create());
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return students;
  }
}