package org.vbc4me.awanna.utility.readers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Zipcode;
import org.vbc4me.awanna.gui.picture.Photo;
import org.vbc4me.awanna.utility.Utilities;

public class StaffFileReader {

  public static List<Staff> parse(File file) {

    if (!file.exists() || !file.canRead()) {
      throw new IllegalArgumentException("File must exist and be readable");
    }
    SAXBuilder saxBuilder = new SAXBuilder();
    List<Staff> personnel = new ArrayList<>();

    try {
      Document document = saxBuilder.build(file);
      Element root = document.getRootElement();
      List<Element> list = root.getChild("personnel").getChildren();

      for (Element staff : list) {

        Staff.Builder builder = Staff.builder()
            .id(UUID.fromString(staff.getAttributeValue("id")))
            .firstName(staff.getAttributeValue("first"))
            .lastName(staff.getAttributeValue("last"));

        Element address = staff.getChild("address");
        builder.address(Address.builder()
            .streetAddress(address.getChildText("streetAddress"))
            .city(address.getChildText("city"))
            .state(address.getChildText("state"))
            .zipcode(Zipcode.of(address.getChildText("zipcode")))
            .create());

        Element phoneNumbers = staff.getChild("phonenumbers");
        for (Element number : phoneNumbers.getChildren()) {
          builder.phoneNumber(
              PhoneNumber.of(PhoneNumber.Type.valueOf(number.getName().toUpperCase()), number.getText()));
        }

        builder.email(staff.getChildText("emailaddress"));

        Element contact = staff.getChild("emergencycontact");
        builder.emergencyContact(EmergencyContact.builder()
            .firstName(contact.getAttributeValue("first"))
            .lastName(contact.getAttributeValue("last"))
            .addPhoneNumber(PhoneNumber.of(
                PhoneNumber.Type.valueOf(contact.getChild("phone").getAttributeValue("type").toUpperCase()),
                contact.getChildText("phone")))
            .create());

        builder.specialNeeds(staff.getChildText("specialneeds"));
        builder.club(Club.get(staff.getChildText("club")));
        builder.title(staff.getChildText("title"));

        if (staff.getChild("image") != null) {
          builder.photo(new Photo(Utilities.decodePhoto(staff.getChildText("image")),
              Utilities.decodePhoto(staff.getChildText("thumbnail"))));
        }

        personnel.add(builder.create());
      }

    } catch (JDOMException | IOException e) {
      e.printStackTrace();
    }
    return personnel;
  }
}
