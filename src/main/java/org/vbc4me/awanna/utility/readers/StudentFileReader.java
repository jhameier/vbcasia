package org.vbc4me.awanna.utility.readers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.vbc4me.awanna.facets.Account;
import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.facets.Address;
import org.vbc4me.awanna.facets.Club;
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
import java.time.LocalTime;
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
            List<Element> list = root.getChildren("students");

            for (Element student : list) {

                UUID studentId = UUID.fromString(student.getAttributeValue("chileId"));
                String first = student.getAttributeValue("first");
                String last = student.getAttributeValue("last");
                BufferedImage image = Utilities.decodePhoto(student.getChildText("image"));
                BufferedImage thumb = Utilities.decodePhoto(student.getChildText("thumb"));

                Student.Builder studentBuilder = Student.builder().firstName(first).lastName(last)
                        .studentId(student.getAttributeValue("studentId"))
                        .grade(student.getChildText("grade"))
                        .dateOfBirth(LocalDate.parse(student.getChildText("dob")))
                        .specialNeeds(student.getChildText("specialneeds"))
                        .club(Club.valueOf(student.getChildText("club")))
                        .studentPhoto(new Photo(image, thumb));

                Element parent = student.getChild("parent");
                Photo pphoto = new Photo(null, null);
                Guardian guardian = Guardian.builder()
                        .first(parent.getChild("name").getChildText("first"))
                        .last(parent.getChild("name").getChildText("last"))
                        .address(Address.builder()
                                .streetAddress(parent.getChildText("address"))
                                .city(parent.getChildText("city"))
                                .state(parent.getChildText("state"))
                                .zipcode(Zipcode.of(parent.getChildText("zipcode")))
                                .create())
                        .emailAddress(parent.getChildText("emailaddress"))
                        .photo(pphoto)
                        .create();
                List<Element> ph = parent.getChild("phonenumber").getChildren();
                for (Element phone : ph) {

                    guardian.phoneNumbers().add(
                            PhoneNumber.of(PhoneNumber.Type.valueOf(phone.getName().toUpperCase()), phone.getText()));
                }
                studentBuilder.guardian(guardian);


                List<Element> pu = student.getChild("authorizedpickup").getChildren();
                for (Element pickup : pu) {
                    Pickup p = Pickup.builder()
                            .first(pickup.getChildText("first"))
                            .last(pickup.getChildText("last"))
                            .relationship(pickup.getChildText("relationship"))
                            .photo(new Photo(Utilities.decodePhoto(pickup.getChild("photo").getChildText("image")),
                                    Utilities.decodePhoto(pickup.getChild("photo").getChildText("thumb"))))
                            .create();
                    studentBuilder.authPickup(p);
                }

                // builder the student model
                Student st = studentBuilder.create();
                Account account = st.account();

                Element acct = student.getChild("account");

                account.adjustBalance(Money.of(CurrencyUnit.USD, Double.parseDouble(acct.getAttributeValue("balance"))));

                List<Element> transactions = acct.getChildren();
                for (Element trans : transactions) {
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