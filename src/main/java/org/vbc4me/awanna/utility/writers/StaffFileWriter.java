package org.vbc4me.awanna.utility.writers;

import java.io.IOException;
import java.nio.file.Path;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Student;
import org.vbc4me.awanna.utility.Utilities;

public final class StaffFileWriter {

  public static void write(Path path, Season season) {

    // Create the document
    Document doc = new Document(new Element("staff"));

    // attach staff members
    for (Staff staff : season.staff().values()) {
      doc.getRootElement().addContent(getMemberElement(staff));
    }

    try {
      XMLOutputter xmlOutput = new XMLOutputter();
      xmlOutput.setFormat(Format.getPrettyFormat());
      xmlOutput.output(doc, new java.io.FileWriter(path.toFile()));
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

  /**
   * Creates a {@link Student} {@link Element} with all information attached
   *
   * @param staff record to convert into element object
   * @return the element to attach to the xml document
   */
  private static Element getMemberElement(Staff staff) {
    Element element = new Element(staff.recordType());
    element.setAttribute("id", staff.id().toString());

    // Name
    Element cname = new Element("name");
    cname.addContent(new Element("first").addContent(staff.firstName()));
    cname.addContent(new Element("last").addContent(staff.lastName()));
    element.addContent(cname);

    // Address
    Element residence = new Element("residence");
    residence.addContent(new Element("address").addContent(staff.address().streetAddress()));
    residence.addContent(new Element("city").addContent(staff.address().city()));
    residence.addContent(new Element("state").addContent(staff.address().state()));
    residence.addContent(new Element("zip-code").addContent(staff.address().zipcode().toString()));
    element.addContent(residence);

    // Phone Numbers
    Element phNumber = new Element("phone-number");
    for (PhoneNumber ph : staff.phoneNumbers()) {
      phNumber.addContent(new Element(ph.type()).addContent(ph.number(false)));
    }
    element.addContent(phNumber);

    // Email
    element.addContent(new Element("email-address").addContent(staff.email()));

    // Emergency Contact Info
    Element emer = new Element("emergencycontact");
    emer.setAttribute(new Attribute("id", staff.emergencyContact().id().toString()))
        .setAttribute(new Attribute("first", staff.emergencyContact().firstName()))
        .setAttribute(new Attribute("last", staff.emergencyContact().lastName()));

    Element phNumElement = new Element("phonenumber");
    for (PhoneNumber number : staff.emergencyContact().phoneNumbers()) {
      phNumElement.addContent(new Element(number.type()).addContent(number.number(false)));
    }
    emer.addContent(phNumElement);
    element.addContent(emer);

    // General Info
    element.addContent(new Element("special-needs").addContent(staff.specialNeeds()));
    element.addContent(new Element("club").addContent(staff.assignedClub()));
    element.addContent(new Element("title").addContent(staff.title()));

    // Photo info
    String image = "";
    String thumb = "";
    try {
      image = Utilities.encodePhoto(staff.photo().cloneImage());
      thumb = Utilities.encodePhoto(staff.photo().cloneThumbnail());
    } catch (IOException e) {
      e.printStackTrace();
    }

    element.addContent(new Element("photo")
        .addContent(new Element("image").addContent(image)
            .addContent(new Element("thumb").addContent(thumb))));

    return element;
  }

}
