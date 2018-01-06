package org.vbc4me.awanna.utility.writers;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.vbc4me.awanna.facets.Account;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Pickup;
import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.facets.Transaction;
import org.vbc4me.awanna.utility.Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public final class StudentFileWriter {

  /**
   * Writes out an xml file for the student(s) current Season record including. Passing in "all" will execute an entire
   * write of all students currently in the system.
   *
   * @param path to store new file
   * @param name of student to print or all for every student
   * @return true if successfully writes out to file.
   */
  public static boolean writeFile(Path path, String name, Season season) {

    // Create the document
    Document doc = new Document(new Element("students"));

    if (name.equals("all")) {
      // attach all students
      for (Student student : season.students().values()) {
        doc.getRootElement().addContent(getMemberElement(student));
      }

    } else {
      Student student = season.students().get(name);

      if (student == null) {
        return false;
      }

      doc.getRootElement().addContent(getMemberElement(student));
    }

    try {
      XMLOutputter xmlOutput = new XMLOutputter();
      xmlOutput.setFormat(Format.getPrettyFormat());
      xmlOutput.output(doc, new FileWriter(path.toFile()));
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return false;
    }
    return true;
  }

  public static boolean writeStream(Path path, String name, Season season) {

    // Create the document
    Document doc = new Document(new Element("students"));

    Student student = season.students().get(name);

    if (student == null) {
      return false;
    }

    doc.getRootElement().addContent(getMemberElement(student));

    try {
      XMLOutputter xmlOutput = new XMLOutputter();
      xmlOutput.setFormat(Format.getPrettyFormat());
      xmlOutput.output(doc, new FileWriter(path.toFile()));
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Creates a {@link Student} {@link Element} with all information attached
   *
   * @param student record to convert into element object
   * @return the element to attach to the xml document
   */
  private static Element getMemberElement(Student student) {
    Element element = new Element(student.recordType());
    element.setAttribute("studentId", student.id().toString());

    /* Set up Child portion of record */
    Element cname = new Element("name");
    cname.addContent(new Element("first").addContent(student.firstName()));
    cname.addContent(new Element("last").addContent(student.lastName()));
    element.addContent(cname);
    element.addContent(new Element("age").addContent(student.age().toString()));
    element.addContent(new Element("grade").addContent(student.grade()));
    element.addContent(new Element("dob").addContent(student.dateOfBirth().toString()));
    element.addContent(new Element("special-needs").addContent(student.specialNeeds()));
    element.addContent(new Element("club").addContent(student.currentClub()));

    String s_image = "";
    String s_thumb = "";
    try {
      s_image = Utilities.encodePhoto(student.guardian().photo().cloneImage());
      s_thumb = Utilities.encodePhoto(student.guardian().photo().cloneThumbnail());
    } catch (IOException e) {
      e.printStackTrace();
    }
    element.addContent(new Element("photo")
        .addContent(new Element("image").addContent(s_image))
        .addContent(new Element("thumb").addContent(s_thumb)));

    /* Set up Parent portion of record */
    Element parent = new Element("parent");

    // Name
    Element pname = new Element("name");
    pname.addContent(new Element("first").addContent(student.guardian().firstName()));
    pname.addContent(new Element("last").addContent(student.guardian().lastName()));
    parent.addContent(pname);

    // Address
    parent.addContent(new Element("address").addContent(student.guardian().address().streetAddress()));
    parent.addContent(new Element("city").addContent(student.guardian().address().city()));
    parent.addContent(new Element("state").addContent(student.guardian().address().state()));
    parent.addContent(new Element("zip-code").addContent(student.guardian().address().zipcode().toString()));

    // Phone Numbers
    Element phNumber = new Element("phone-number");
    for (PhoneNumber ph : student.guardian().phoneNumbers()) {
      phNumber.addContent(new Element(ph.type()).addContent(ph.number(false)));
    }
    parent.addContent(phNumber);

    // Email
    parent.addContent(new Element("email-address").addContent(student.guardian().emailAddress()));

    String g_image = "";
    String g_thumb = "";
    try {
      g_image = Utilities.encodePhoto(student.guardian().photo().cloneImage());
      g_thumb = Utilities.encodePhoto(student.guardian().photo().cloneThumbnail());
    } catch (IOException e) {
      e.printStackTrace();
    }

    parent.addContent(new Element("photo")
        .addContent(new Element("image").addContent(g_image))
        .addContent(new Element("thumb").addContent(g_thumb)));

    // add parent info to student element
    element.addContent(parent);

    /* Set up Authorized Pickup portion of record */
    Element pickup = new Element("authorized-pickup");

    int count = 0;
    for (Pickup pu : student.authPickupList()) {
      ++count;
      String nodeName;
      switch (count) {
        case 1:
          nodeName = "one";
          break;
        case 2:
          nodeName = "two";
          break;
        case 3:
          nodeName = "three";
          break;
        case 4:
          nodeName = "four";
          break;
        default:
          throw new IllegalArgumentException("Only 4 authorized pickup's allowed");
      }
      Element auth = new Element(nodeName);
      auth.addContent(new Element("first").addContent(pu.firstName()));
      auth.addContent(new Element("last").addContent(pu.lastName()));
      auth.addContent(new Element("relationship").addContent(pu.relationship()));
      String p_image = "";
      String p_thumb = "";
      try {
        p_image = Utilities.encodePhoto(student.guardian().photo().cloneImage());
        p_thumb = Utilities.encodePhoto(student.guardian().photo().cloneThumbnail());
      } catch (IOException e) {
        e.printStackTrace();
      }
      auth.addContent(new Element("photo")
          .addContent(new Element("image").addContent(p_image))
          .addContent(new Element("thumb").addContent(p_thumb)));

      pickup.addContent(auth);
    }
    element.addContent(pickup);

    Account account = student.account();
    Element acct = new Element("account")
        .setAttribute(new Attribute("id", account.id().toString()))
        .setAttribute(new Attribute("balance", String.valueOf(account.balance())));
    Element trans = new Element("transactions");
    acct.addContent(trans);
    for (Transaction t : account.transactions().values()) {
      Element tr = new Element("transaction")
          .setAttribute(new Attribute("datetime", t.dateTime().toString()))
          .setAttribute(new Attribute("type", t.type().name().toLowerCase()))
          .setAttribute(new Attribute("amount", String.valueOf(t.amount())))
          .addContent(new Element("description", t.description()));
      if (t.activityId() != null) {
        tr.addContent(new Element("activityId", t.activityId().toString()));
      }
      trans.addContent(tr);
    }
    return element;
  }

}
