package org.vbc4me.awanna.utility.readers;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.vbc4me.awanna.facets.Account;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Transaction;
import org.xml.sax.helpers.DefaultHandler;

public class StudentFileReader extends DefaultHandler {

  public static List<Student> parse(File file) {

    if (file == null) {
      throw new IllegalArgumentException("File must not be null");
    }
    SAXBuilder saxBuilder = new SAXBuilder();
    List<Student> students = new ArrayList<>();
    try {
      Document document = saxBuilder.build(file);
      Element root = document.getRootElement();
      List<Element> list = root.getChildren("student");

      for (Element student : list) {
	String first = student.getChild("name").getChildText("first");
	String last = student.getChild("name").getChildText("last");
        Student.Builder studentBuilder = Student.build().firstName(first).lastName(last)
        	.childId(student.getAttributeValue("childId"))
        	.childGrade(student.getChildText("grade"))
        	.childDOB(LocalDate.parse(student.getChildText("dob")))
        	.specialNeeds(student.getChildText("special-needs"))
        	.currentClub(Club.valueOf(student.getChildText("club")))
        	.childPhotoPath(student.getChildText("photo"))
        	.childThumbnailPath(student.getChildText("thumbnail"));

        Element parent = student.getChild("parent");
        studentBuilder.parentFirstName(parent.getChild("name").getChildText("first"))
            .parentLastName(parent.getChild("name").getChildText("last"))
            .address(parent.getChildText("address"))
            .city(parent.getChildText("city"))
            .state(parent.getChildText("state"))
            .zip(parent.getChildText("zip-code"))
            .emailAddress(parent.getChildText("email-address"))
             .parentPhotoPath(parent.getChildText("photo"))
             .parentThumbnailPath(parent.getChildText("thumbnail"));

        
        List<Element> ph = parent.getChild("phone-number").getChildren();
        System.out.println();
        for (Element phone : ph) {
          studentBuilder.phoneNumber(phone.getName(), phone.getText());
        }

        List<Element> pu = student.getChild("authorized-pickup").getChildren();
        for (Element pickup : pu) {
          studentBuilder.authPickup(
              pickup.getChildText("first"),
              pickup.getChildText("last"),
              pickup.getChildText("relationship"),
              pickup.getChildText("photo"),
              pickup.getChildText("thumbnail")) ;
              
        }

        // build the student model
        Student st = studentBuilder.done();
        Account account = st.account();

        Element acct = student.getChild("account");

        account.adjustBalance(Money.of(CurrencyUnit.USD, Double.parseDouble(acct.getAttributeValue("balance"))));

        List<Element> transactions = acct.getChildren();
        for(Element trans : transactions) {
          Element act = trans.getChild("actions");

          LocalDate date = LocalDate.parse(act.getAttributeValue("date"));
          LocalTime time = LocalTime.parse(act.getAttributeValue("time"));
          String actName = act.getText();
          Activity activity = Activity.builder().date(date).time(time).name(actName).cost(0.50).create();

          Transaction.TYPE type = Transaction.TYPE.valueOf(trans.getAttributeValue("type"));

          Transaction transaction = new Transaction(type, activity);
          st.account().insertTransaction(transaction);
        }

        students.add(st);
      }


    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return students;

  }
}