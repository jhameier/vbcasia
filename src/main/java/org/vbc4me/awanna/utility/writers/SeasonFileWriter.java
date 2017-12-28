package org.vbc4me.awanna.utility.writers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Student;

import java.io.IOException;
import java.nio.file.Path;

public final class SeasonFileWriter {

    public static void write(Path path, Season season) {

        // Create the document
        Document doc = new Document(new Element("actions"));

        // add actions information

        // add actions information
        for (Activity activity : season.session().activities().values()) {
            doc.getRootElement().addContent(getMemberElement(activity));
        }

        // write out student info to student.stu file
        // add student file path name

        // write out staff info to staff.stf file
        // add staff file path name


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
     * @param activity record to convert into element object
     * @return the element to attach to the xml document
     */
    private static Element getMemberElement(Activity activity) {
        Element element = new Element(activity.name());
//		element.setAttribute("id", staff.id());
//
//		// Name
//		Element cname = new Element("name");
//		cname.addContent(new Element("first").addContent(staff.firstName()));
//		cname.addContent(new Element("last").addContent(staff.lastName()));
//		element.addContent(cname);
//
//		// Address
//		Element residence = new Element("residence");
//		residence.addContent(new Element("address").addContent(staff.address()));
//		residence.addContent(new Element("city").addContent(staff.city()));
//		residence.addContent(new Element("state").addContent(staff.state()));
//		residence.addContent(new Element("zip-code").addContent(staff.zip()));
//		element.addContent(residence);
//
//		// Phone Numbers
//		Element phNumber = new Element("phone-number");
//		for (PhoneNumber ph : staff.phoneNumbers()) {
//			phNumber.addContent(new Element(ph.type()).addContent(ph.number(false)));
//		}
//		element.addContent(phNumber);
//
//		// Email
//		element.addContent(new Element("email-address").addContent(staff.email()));
//
//		// Emergency Contact Info
//		Element emer = new Element("emergency-contact");
//		emer.addContent(new Element("name").addContent(staff.emergencyContactName()));
//		emer.addContent(new Element("phone").addContent(staff.emergencyContactNumber().number(false)));
//		element.addContent(emer);
//
//		// General Info
//		element.addContent(new Element("special-needs").addContent(staff.specialNeeds()));
//		element.addContent(new Element("club").addContent(staff.assignedClub()));
//		element.addContent(new Element("title").addContent(staff.title()));
//
//		// Photo info
//		element.addContent(new Element("image").addContent(staff.photoPath().toString()));

        return element;
    }

}
