package org.vbc4me.awanna.gui.forms.student;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.actions.picture.AttachPhotoAction;
import java.awt.BorderLayout;

public final class StudentDisplayForm extends JPanel {

  private static final long serialVersionUID = -6820054695958009796L;

  private static final String CHILD = "child";
  private static final String PARENT = "parent";
  private static final String AUTH1 = "auth1";
  private static final String AUTH2 = "auth2";
  private static final String AUTH3 = "auth3";
  private static final String AUTH4 = "auth4";
  private static final String DISPLAY = "StudentDisplayForm";

  public static JPanel childPhotoPanel;
  public static JPanel parentPhotoPanel;
  public static JPanel auth1PhotoPanel;
  public static JPanel auth2PhotoPanel;
  public static JPanel auth3PhotoPanel;
  public static JPanel auth4PhotoPanel;



  public StudentDisplayForm() {
    setLayout(new MigLayout("", "[grow][90px][20px][40px][10px][80px][10px][30px][10px][80px][10px][60px][10px][80px][10][80px][10px,grow]", "[20px,grow][20px][20px][25px][20px][][20px][20px][25px][20px][][20px][20px][20px][][20px][20px][][20px][25px][25px][25px][25px][20px,grow]"));

    JLabel lblChild = new JLabel("Child");
    lblChild.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lblChild, "cell 1 1,growx,aligny top");

    childPhotoPanel = new JPanel();
    add(childPhotoPanel, "cell 1 2 1 2,grow");

    JLabel lblChildFirst = new JLabel("First");
    lblChildFirst.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblChildFirst, "cell 3 2,alignx right,aligny center");

    JLabel txtChildFirstName = new JLabel();
    txtChildFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblChildFirst.setLabelFor(txtChildFirstName);
    lblChild.setLabelFor(txtChildFirstName);
    add(txtChildFirstName, "cell 5 2 3 1,growx,aligny center");

    JLabel lblChildLast = new JLabel("Last");
    lblChildLast.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblChildLast, "cell 9 2,alignx right,aligny center");

    JLabel txtChildLastName = new JLabel();
    txtChildLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtChildLastName, "cell 11 2 3 1,growx,aligny center");

    JLabel lblChildAge = new JLabel("Age");
    lblChildAge.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblChildAge, "cell 3 3,alignx right,aligny center");

    JLabel txtChildAge = new JLabel();
    txtChildAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtChildAge, "cell 5 3,growx,aligny center");

    JLabel lblChildGrade = new JLabel("Grade");
    lblChildGrade.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblChildGrade, "cell 7 3,alignx right,aligny center");

    JLabel txtChildGrade = new JLabel();
    txtChildGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtChildGrade, "cell 9 3,growx,aligny center");

    JLabel lblChildDateOfBirth = new JLabel("Date of Birth");
    lblChildDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblChildDateOfBirth, "cell 11 3,alignx center,aligny center");

    JLabel txtChildDOB = new JLabel();
    txtChildDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtChildDOB, "cell 13 3,growx,aligny center");

    JLabel lblSpecialNeedsallergies = new JLabel("Special Needs/Allergies");
    lblSpecialNeedsallergies.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblSpecialNeedsallergies, "cell 1 4 3 1,alignx right,aligny center");

    JLabel txtChildSpecialNeeds = new JLabel();
    txtChildSpecialNeeds.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtChildSpecialNeeds, "cell 5 4 9 1,growx,aligny top");

    JLabel lblParentgardian = new JLabel("Parent/Gardian");
    lblParentgardian.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lblParentgardian, "cell 1 6,alignx left,aligny top");

    parentPhotoPanel = new JPanel();
    add(parentPhotoPanel, "cell 1 7 1 2,grow");

    JLabel label = new JLabel("First");
    label.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label, "cell 3 7,alignx right,aligny center");

    JLabel txtParentFirstName = new JLabel();
    txtParentFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtParentFirstName, "cell 5 7 3 1,growx,aligny center");

    JLabel lblParentLastName = new JLabel("Last");
    lblParentLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblParentLastName, "cell 9 7,alignx right,aligny center");

    JLabel txtParentLastName = new JLabel();
    txtParentLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtParentLastName, "cell 11 7 3 1,growx,aligny center");

    JLabel lblAddress = new JLabel("Address");
    lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblAddress, "cell 3 8,alignx right,aligny center");

    JLabel txtParentAddress = new JLabel();
    txtParentAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtParentAddress, "cell 5 8 9 1,growx,aligny center");

    JLabel lblCity = new JLabel("City");
    lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblCity, "cell 3 9,alignx right,aligny center");

    JLabel txtParentCity = new JLabel();
    txtParentCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtParentCity, "cell 5 9,alignx center,aligny center");

    JLabel lblState = new JLabel("State");
    lblState.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblState, "cell 7 9,alignx right,aligny center");

    JLabel txtParentState = new JLabel();
    txtParentState.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtParentState, "cell 9 9,growx,aligny center");

    JLabel lblZipCode = new JLabel("Zip Code");
    lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblZipCode, "cell 11 9,alignx right,aligny center");

    JLabel txtParentZipCode = new JLabel();
    txtParentZipCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtParentZipCode, "cell 13 9,growx,aligny center");

    JLabel lblPhone = new JLabel("Phone/Email");
    lblPhone.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lblPhone, "cell 1 11,alignx left,aligny top");

    JLabel lblHome = new JLabel("Home");
    lblHome.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblHome, "cell 3 12,alignx right,aligny center");

    JLabel txtPhoneHome = new JLabel();
    txtPhoneHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtPhoneHome, "cell 5 12,growx,aligny center");

    JLabel lblCellPhone = new JLabel("Cell#");
    lblCellPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblCellPhone, "cell 7 12,alignx right,aligny center");

    JLabel txtPhoneCell = new JLabel();
    txtPhoneCell.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtPhoneCell, "cell 9 12,growx,aligny top");

    JLabel lblAltPhone = new JLabel("Alt. Phone");
    lblAltPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblAltPhone, "cell 11 12,alignx right,aligny center");

    JLabel txtPhoneAlt = new JLabel();
    txtPhoneAlt.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtPhoneAlt, "cell 13 12,growx,aligny center");

    JLabel lblEmailAddress = new JLabel("Email Address");
    lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblEmailAddress, "cell 2 13 2 1,alignx right,aligny center");

    JLabel txtEmailAddress = new JLabel();
    txtEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtEmailAddress, "cell 5 13 7 1,growx,aligny center");

    JLabel lblEmergencyContact = new JLabel("Emergency Contact Info");
    lblEmergencyContact.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(lblEmergencyContact, "cell 1 15 3 1,alignx left,aligny top");

    JLabel lblName = new JLabel("Name");
    lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblName, "cell 3 16,alignx right,aligny center");

    JLabel txtEmergencyName = new JLabel();
    txtEmergencyName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtEmergencyName, "cell 5 16 3 1,growx,aligny center");

    JLabel lblPhone_1 = new JLabel("Phone");
    lblPhone_1.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblPhone_1, "cell 9 16,alignx right,aligny center");

    JLabel txtEmergencyPhone = new JLabel();
    txtEmergencyPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtEmergencyPhone, "cell 11 16 3 1,growx,aligny center");
    
    JLabel lblAuthorizedPickup = new JLabel("Authorized Pickup");
    add(lblAuthorizedPickup, "cell 1 18,alignx left,aligny bottom");
    lblAuthorizedPickup.setFont(new Font("Tahoma", Font.BOLD, 16));
    
    auth1PhotoPanel = new JPanel();
    add(auth1PhotoPanel, "cell 1 19,grow");
    auth1PhotoPanel.setLayout(new BorderLayout(0, 0));

    JLabel label_2 = new JLabel("First");
    label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_2, "cell 3 19,alignx right,aligny center");

    JLabel txtAuth1FirstName = new JLabel();
    txtAuth1FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth1FirstName, "cell 5 19,growx,aligny center");

    JLabel lblLast_1 = new JLabel("Last");
    lblLast_1.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblLast_1, "cell 7 19,alignx right,aligny center");

    JLabel txtAuth1LastName = new JLabel();
    txtAuth1LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth1LastName, "cell 9 19,growx,aligny center");

    JLabel lblRelationship = new JLabel("Relationship");
    lblRelationship.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(lblRelationship, "cell 11 19,alignx right,aligny center");

    JLabel txtAuth1Relationship = new JLabel();
    txtAuth1Relationship.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth1Relationship, "cell 13 19,growx,aligny center");
    
    auth2PhotoPanel = new JPanel();
    add(auth2PhotoPanel, "cell 1 20 2 1,grow");

    JLabel label_3 = new JLabel("First");
    label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_3, "cell 3 20,alignx right,aligny center");

    JLabel txtAuth2FirstName = new JLabel();
    txtAuth2FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth2FirstName, "cell 5 20,growx,aligny center");

    JLabel label_6 = new JLabel("Last");
    label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_6, "cell 7 20,alignx right,aligny center");

    JLabel txtAuth2LastName = new JLabel();
    txtAuth2LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth2LastName, "cell 9 20,growx,aligny center");

    JLabel label_9 = new JLabel("Relationship");
    label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_9, "cell 11 20,alignx right,aligny center");

    JLabel txtAuth2Relationship = new JLabel();
    txtAuth2Relationship.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth2Relationship, "cell 13 20,growx,aligny center");
    
    auth3PhotoPanel = new JPanel();
    add(auth3PhotoPanel, "cell 1 21,grow");

    JLabel label_4 = new JLabel("First");
    label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_4, "cell 3 21,alignx right,aligny center");

    JLabel txtAuth3FirstName = new JLabel();
    txtAuth3FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth3FirstName, "cell 5 21,growx,aligny center");

    JLabel label_7 = new JLabel("Last");
    label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_7, "cell 7 21,alignx right,aligny center");

    JLabel txtAuth3LastName = new JLabel();
    txtAuth3LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth3LastName, "cell 9 21,growx,aligny center");

    JLabel label_10 = new JLabel("Relationship");
    label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_10, "cell 11 21,alignx right,aligny center");

    JLabel txtAuth3Relationship = new JLabel();
    txtAuth3Relationship.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth3Relationship, "cell 13 21,growx,aligny center");
    
    auth4PhotoPanel = new JPanel();
    add(auth4PhotoPanel, "cell 1 22,grow");

    JLabel label_5 = new JLabel("First");
    label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_5, "cell 3 22,alignx right,aligny center");

    JLabel txtAuth4FirstName = new JLabel();
    txtAuth4FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth4FirstName, "cell 5 22,growx,aligny center");

    JLabel label_8 = new JLabel("Last");
    label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_8, "cell 7 22,alignx right,aligny center");

    JLabel txtAuth4LastName = new JLabel();
    txtAuth4LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth4LastName, "cell 9 22,growx,aligny center");

    JLabel label_11 = new JLabel("Relationship");
    label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
    add(label_11, "cell 11 22,alignx right,aligny center");

    JLabel txtAuth4Relationship = new JLabel();
    txtAuth4Relationship.setFont(new Font("Tahoma", Font.PLAIN, 16));
    add(txtAuth4Relationship, "cell 13 22,growx,aligny center");
  }

  public static void addPhoto(AttachPhotoAction apa) {
    String person = (String) apa.getValue("person");
    String file = (String) apa.getValue("file");

    BufferedImage image = null;
    try {
      image = ImageIO.read(new File(file));
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (image == null) {
      throw new IllegalArgumentException("Failed to retreive valid file: " + file);
    }
    JLabel picture = new JLabel(new ImageIcon(image));

    switch (person) {
      case CHILD:
        childPhotoPanel.add(picture);
        break;
      case PARENT:
        parentPhotoPanel.add(picture);
        break;
      case AUTH1:
        auth1PhotoPanel.add(picture);
        break;
      case AUTH2:
        auth2PhotoPanel.add(picture);
        break;
      case AUTH3:
        auth3PhotoPanel.add(picture);
        break;
      case AUTH4:
        auth4PhotoPanel.add(picture);
        break;
      default:
        throw new IllegalArgumentException("Trying to attache an unknown person type: "
            + person);
    }
  }
}
