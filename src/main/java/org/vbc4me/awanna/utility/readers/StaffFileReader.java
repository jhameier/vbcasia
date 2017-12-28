package org.vbc4me.awanna.utility.readers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.EmergencyContact;
import org.vbc4me.awanna.facets.PhoneNumber;
import org.vbc4me.awanna.facets.Photo;
import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.facets.Zipcode;
import org.vbc4me.awanna.utility.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
            List<Element> list = root.getChildren("personnel");

            for (Element staff : list) {

                Staff.Builder builder = Staff.builder()
                        .id(UUID.fromString(staff.getAttributeValue("id")))
                        .firstName(staff.getAttributeValue("first"))
                        .lastName(staff.getAttributeValue("last"));

                Element residence = staff.getChild("residence");
                builder.address(Address.builder()
                        .streetAddress(residence.getChildText("address"))
                        .city(residence.getChildText("city"))
                        .state(residence.getChildText("state"))
                        .zipcode(Zipcode.of(residence.getChildText("zipcode")))
                        .create());

                Element phoneNumbers = staff.getChild("phone-numbers");
                for (Element number : phoneNumbers.getChildren()) {
                    builder.phoneNumber(PhoneNumber.of(PhoneNumber.Type.valueOf(number.getName()), number.getText()));
                }

                builder.email(staff.getChildText("emailaddress"));

                Element contact = staff.getChild("emergencycontact");
                builder.emergencyContact(EmergencyContact.builder()
                        .firstName(contact.getAttributeValue("first"))
                        .lastName(contact.getAttributeValue("last"))
                        .phoneNumber(PhoneNumber.of(
                                PhoneNumber.Type.valueOf(contact.getChild("phone").getAttributeValue("type")),
                                contact.getChildText("phone")))
                        .create());

                builder.specialNeeds(staff.getChildText("specialneeds"));
                builder.club(Club.valueOf(staff.getChildText("club")));
                builder.title(staff.getChildText("title"));
                builder.photo(new Photo(Utilities.decodePhoto(staff.getChildText("image")),
                        Utilities.decodePhoto(staff.getChildText("thumbnail"))));
                personnel.add(builder.create());
            }

        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return personnel;
    }
}
