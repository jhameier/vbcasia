package org.vbc4me.awanna.utility.readers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.vbc4me.awanna.facets.Club;
import org.vbc4me.awanna.facets.Staff;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
                builder.address(residence.getChildText("address"))
                        .city(residence.getChildText("city"))
                        .state(residence.getChildText("state"))
                        .zip(residence.getChildText("zipcode"));

                Element phoneNumbers = staff.getChild("phone-numbers");
                for (Element number : phoneNumbers.getChildren()) {
                    builder.phoneNumber(number.getName(), number.getText());
                }

                builder.email(staff.getChildText("emailaddress"));

                Element contact = staff.getChild("emergencycontact");
                builder.emergencyContactName(
                        contact.getAttributeValue("first") + " " + contact.getAttributeValue("last"));
                builder.emergencyContactNumber(
                        contact.getChild("phone").getAttributeValue("type"), contact.getChildText("phone"));
                builder.specialNeeds(staff.getChildText("specialneeds"));
                builder.club(Club.valueOf(staff.getChildText("club")));
                builder.title(staff.getChildText("title"));

                String photoString = staff.getChildText("photo");
                byte[] phtotBytes = Base64.getDecoder().decode(photoString);
                BufferedImage photo = ImageIO.read(new ByteArrayInputStream(phtotBytes));
                builder.photo(photo);

                String thumbString = staff.getChildText("thumbnail");
                byte[] thumbBytes = Base64.getDecoder().decode(thumbString);
                BufferedImage thumb = ImageIO.read(new ByteArrayInputStream(thumbBytes));
                builder.thumbnail(thumb);

                personnel.add(builder.done());
            }


        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return personnel;
    }
}
