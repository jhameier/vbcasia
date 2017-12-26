package org.vbc4me.awanna.utility.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

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

public final class StudentFileWriter {
	
	/**
	 * Writes out an xml file for the student(s) current Season record including.
	 * Passing in "all" will execute an entire write of all students currently
	 * in the system.
	 *
	 * @param path
	 *            to store new file
	 * @param name
	 *            of student to print or all for every student
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
		element.setAttribute("childId", student.childId());
		
		/* Set up Child portion of record */
		Element cname = new Element("name");
		cname.addContent(new Element("first").addContent(student.childFirstName()));
		cname.addContent(new Element("last").addContent(student.childLastName()));
		element.addContent(cname);
		element.addContent(new Element("age").addContent(student.childAge().toString()));
		element.addContent(new Element("grade").addContent(student.childGrade()));
		element.addContent(new Element("dob").addContent(student.childDOB().toString()));
		element.addContent(new Element("special-needs").addContent(student.specialNeeds()));
		element.addContent(new Element("club").addContent(student.currentClub()));
		element.addContent(new Element("photo").addContent(student.childPhotoPath().toString())); 
		element.addContent(new Element("thumbnail").addContent(student.childThumbnailPath().toString()));
		
		/* Set up Parent portion of record */
		Element parent = new Element("parent");
		
		// Name
		Element pname = new Element("name");
		pname.addContent(new Element("first").addContent(student.parentFirstName()));
		pname.addContent(new Element("last").addContent(student.parentLastName()));
		parent.addContent(pname);
		
		// Address
		parent.addContent(new Element("address").addContent(student.address()));
		parent.addContent(new Element("city").addContent(student.city()));
		parent.addContent(new Element("state").addContent(student.state()));
		parent.addContent(new Element("zip-code").addContent(student.zip().toString()));
		
		// Phone Numbers
		Element phNumber = new Element("phone-number");
		for (PhoneNumber ph : student.phoneNumbers()) {
			phNumber.addContent(new Element(ph.type()).addContent(ph.number(false)));
		}
		parent.addContent(phNumber);
		
		// Email
		parent.addContent(new Element("email-address").addContent(student.email()));
		parent.addContent(new Element("photo").addContent(student.parentPhotoPath().toString())); 
		parent.addContent(new Element("thumbnail").addContent(student.parentThumbnailPath().toString()));
		
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
			auth.addContent(new Element("photo").addContent(pu.photoPath().toString()));
			auth.addContent(new Element("thumbnail").addContent(pu.thumbnailPath().toString()));
			
			
			pickup.addContent(auth);
		}
		element.addContent(pickup);
		
		Account account = student.account();
		Element acct = new Element("account");
		acct.setAttribute(new Attribute("balance", String.valueOf(account.balance())));
		Element trans = new Element("transactions");
		acct.addContent(trans);
		for (Transaction t : account.transactions().values()) {
			Element tr = new Element("transaction");
			tr.setAttribute("type", t.type());
			tr.setAttribute("amount", String.valueOf(t.amount()));
			
			Element activity = new Element("actions");
			activity.setAttribute("date", t.activity().date().toString());
			activity.setAttribute("time", t.activity().time().toString());
			activity.addContent(t.activity().name());
			tr.addContent(activity);
			trans.addContent(tr);
		}
		return element;
	}
	
}
