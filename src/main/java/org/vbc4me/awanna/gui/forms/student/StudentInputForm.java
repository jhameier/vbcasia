package org.vbc4me.awanna.gui.forms.student;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.picture.PreviewPanel;
import org.vbc4me.awanna.gui.actions.picture.AttachPhotoAction;

public class StudentInputForm extends JPanel {

  private static final long serialVersionUID = -6820054695958009796L;
  public JTextField txtChildFirstName;
  public JTextField txtChildLastName;
  public JTextField txtChildAge;
  public JTextField txtChildGrade;
  public JTextField txtChildDOB;
  public JTextField txtParentFirstName;
  public JTextField txtParentLastName;
  public JTextField txtParentAddress;
  public JTextField txtParentState;
  public JTextField txtParentZipCode;
  public JTextField txtParentCity;
  public JTextField txtPhoneHome;
  public JTextField txtPhoneCell;
  public JTextField txtEmailAddress;
  public JTextField txtChildSpecialNeeds;
  public JTextField txtEmergencyPhone;
  public JTextField txtEmergencyName;
  public JTextField txtAuth1FirstName;
  public JTextField txtAuth1LastName;
  public JTextField txtAuth1Relationship;
  public JTextField txtAuth2FirstName;
  public JTextField txtAuth3FirstName;
  public JTextField txtAuth4FirstName;
  public JTextField txtAuth2LastName;
  public JTextField txtAuth3LastName;
  public JTextField txtAuth4LastName;
  public JTextField txtAuth2Relationship;
  public JTextField txtAuth3Relationship;
  public JTextField txtAuth4Relationship;

  public static PreviewPanel childPhotoPanel;
  public static PreviewPanel parentPhotoPanel;
  public static PreviewPanel auth1PhotoPanel;
  public static PreviewPanel auth2PhotoPanel;
  public static PreviewPanel auth3PhotoPanel;
  public static PreviewPanel auth4PhotoPanel;

  private static final String CHILD = "child";
  private static final String PARENT = "parent";
  private static final String AUTH1 = "auth1";
  private static final String AUTH2 = "auth2";
  private static final String AUTH3 = "auth3";
  private static final String AUTH4 = "auth4";
  private static final String INPUT = "StudentInputForm";


  public StudentInputForm() {
    setLayout(new MigLayout("", "[][90px][20px][40px][20px][80px][20px][30px][20px][80px][20px][60px][20px][80px][][80px][]", "[20px][20px][20px,grow][25px][20px][20px][20px,grow][25px][20px][20px][20px][20px][20px][20px][20px][25px,grow][25px,grow][25px,grow][25px,grow][20px]"));

    JLabel lblChild = new JLabel("Child");
    lblChild.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(lblChild, "cell 1 1 5 1,growx,aligny top");
    
    childPhotoPanel = new PreviewPanel();
    childPhotoPanel.setBorder(null);
    add(childPhotoPanel, "cell 1 2 1 2,grow");

    JLabel lblChildFirst = new JLabel("First");
    add(lblChildFirst, "cell 3 2,alignx right,aligny center");

    txtChildFirstName = new JTextField();
    lblChildFirst.setLabelFor(txtChildFirstName);
    lblChild.setLabelFor(txtChildFirstName);
    add(txtChildFirstName, "cell 5 2 3 1,growx,aligny center");
    txtChildFirstName.setColumns(10);

    JLabel lblChildLast = new JLabel("Last");
    add(lblChildLast, "cell 9 2,alignx right,aligny center");

    txtChildLastName = new JTextField();
    add(txtChildLastName, "cell 11 2 3 1,growx,aligny center");
    txtChildLastName.setColumns(10);

    JLabel lblChildAge = new JLabel("Age");
    add(lblChildAge, "cell 3 3,alignx right,aligny center");

    txtChildAge = new JTextField();
    add(txtChildAge, "cell 5 3,growx,aligny center");
    txtChildAge.setColumns(10);

    JLabel lblChildGrade = new JLabel("Grade");
    add(lblChildGrade, "cell 7 3,alignx right,aligny center");

    txtChildGrade = new JTextField();
    add(txtChildGrade, "cell 9 3,growx,aligny center");
    txtChildGrade.setColumns(10);

    JLabel lblChildDateOfBirth = new JLabel("Date of Birth");
    add(lblChildDateOfBirth, "cell 11 3,alignx center,aligny center");

    txtChildDOB = new JTextField();
    add(txtChildDOB, "cell 13 3,growx,aligny center");
    txtChildDOB.setColumns(10);

    JButton btnAddChildPhoto = new JButton("Add Photo");
    add(btnAddChildPhoto, "cell 15 3,alignx left,aligny top");
    AttachPhotoAction childPhotoAction = new AttachPhotoAction(this, CHILD, INPUT);
    btnAddChildPhoto.addActionListener(childPhotoAction);

    JLabel lblSpecialNeedsallergies = new JLabel("Special Needs/Allergies");
    add(lblSpecialNeedsallergies, "cell 1 4 3 1,alignx right,aligny center");

    txtChildSpecialNeeds = new JTextField();
    add(txtChildSpecialNeeds, "cell 5 4 9 1,growx,aligny top");
    txtChildSpecialNeeds.setColumns(10);

    JLabel lblParentgardian = new JLabel("Parent/Gardian");
    lblParentgardian.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(lblParentgardian, "cell 1 5 2 1,alignx left,aligny top");
    
    parentPhotoPanel = new PreviewPanel();
    parentPhotoPanel.setBorder(null);
    add(parentPhotoPanel, "cell 1 6 1 2,grow");

    JLabel label = new JLabel("First");
    add(label, "cell 3 6,alignx right,aligny center");

    txtParentFirstName = new JTextField();
    txtParentFirstName.setColumns(10);
    add(txtParentFirstName, "cell 5 6 3 1,growx,aligny center");

    JLabel label_1 = new JLabel("Last");
    add(label_1, "cell 9 6,alignx right,aligny center");

    txtParentLastName = new JTextField();
    txtParentLastName.setColumns(10);
    add(txtParentLastName, "cell 11 6 3 1,growx,aligny center");

    JLabel lblAddress = new JLabel("Address");
    add(lblAddress, "cell 3 7,alignx right,aligny center");

    txtParentAddress = new JTextField();
    add(txtParentAddress, "cell 5 7 9 1,growx,aligny center");
    txtParentAddress.setColumns(10);

    JButton btnAddParentPhoto = new JButton("Add Photo");
    add(btnAddParentPhoto, "cell 15 7,alignx left,aligny top");
    AttachPhotoAction parentPhotoAction = new AttachPhotoAction(this, PARENT, INPUT);
    btnAddParentPhoto.addActionListener(parentPhotoAction);

    JLabel lblCity = new JLabel("City");
    add(lblCity, "cell 3 8,alignx right,aligny center");

    txtParentCity = new JTextField();
    add(txtParentCity, "cell 5 8,growx,aligny top");
    txtParentCity.setColumns(10);

    JLabel lblState = new JLabel("State");
    add(lblState, "cell 7 8,alignx right,aligny center");

    txtParentState = new JTextField();
    add(txtParentState, "cell 9 8,growx,aligny top");
    txtParentState.setColumns(10);

    JLabel lblZipCode = new JLabel("Zip Code");
    add(lblZipCode, "cell 11 8,alignx right,aligny center");

    txtParentZipCode = new JTextField();
    add(txtParentZipCode, "cell 13 8,growx,aligny top");
    txtParentZipCode.setColumns(10);

    JLabel lblPhone = new JLabel("Phone/Email");
    lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(lblPhone, "cell 1 9,alignx left,aligny top");

    JLabel lblHome = new JLabel("Home");
    add(lblHome, "cell 3 10,alignx right,aligny center");

    txtPhoneHome = new JTextField();
    add(txtPhoneHome, "cell 5 10,growx,aligny top");
    txtPhoneHome.setColumns(10);

    JLabel lblCellPhone = new JLabel("Cell#");
    add(lblCellPhone, "cell 7 10,alignx right,aligny center");

    txtPhoneCell = new JTextField();
    add(txtPhoneCell, "cell 9 10,growx,aligny top");
    txtPhoneCell.setColumns(10);

    JLabel lblAltPhone = new JLabel("Alt. Phone");
    add(lblAltPhone, "cell 11 10,alignx right,aligny center");

    JFormattedTextField txtPhoneAlt = new JFormattedTextField();
    add(txtPhoneAlt, "cell 13 10,growx,aligny top");

    JLabel lblEmailAddress = new JLabel("Email Address");
    add(lblEmailAddress, "cell 2 11 2 1,alignx right,aligny center");

    txtEmailAddress = new JTextField();
    add(txtEmailAddress, "cell 5 11 7 1,growx,aligny top");
    txtEmailAddress.setColumns(10);

    JLabel lblEmergencyContact = new JLabel("Emergency Contact Info");
    lblEmergencyContact.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(lblEmergencyContact, "cell 1 12 3 1,alignx left,aligny top");

    JLabel lblName = new JLabel("Name");
    add(lblName, "cell 3 13,alignx right,aligny center");

    txtEmergencyName = new JTextField();
    add(txtEmergencyName, "cell 5 13 3 1,growx,aligny top");
    txtEmergencyName.setColumns(10);

    JLabel lblPhone_1 = new JLabel("Phone");
    add(lblPhone_1, "cell 9 13,alignx right,aligny center");

    txtEmergencyPhone = new JTextField();
    add(txtEmergencyPhone, "cell 11 13 3 1,growx,aligny top");
    txtEmergencyPhone.setColumns(10);

    JLabel lblAuthorizedPickup = new JLabel("Authorized Pickup");
    lblAuthorizedPickup.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(lblAuthorizedPickup, "cell 1 14 2 1,alignx left,aligny top");
    
    auth1PhotoPanel = new PreviewPanel();
    auth1PhotoPanel.setBorder(null);
    add(auth1PhotoPanel, "cell 1 15,grow");

    JLabel label_2 = new JLabel("First");
    add(label_2, "cell 3 15,alignx right,aligny center");

    txtAuth1FirstName = new JTextField();
    add(txtAuth1FirstName, "cell 5 15,growx,aligny center");
    txtAuth1FirstName.setColumns(10);

    JLabel lblLast_1 = new JLabel("Last");
    add(lblLast_1, "cell 7 15,alignx right,aligny center");

    txtAuth1LastName = new JTextField();
    add(txtAuth1LastName, "cell 9 15,growx,aligny center");
    txtAuth1LastName.setColumns(10);

    JLabel lblRelationship = new JLabel("Relationship");
    add(lblRelationship, "cell 11 15,alignx right,aligny center");

    txtAuth1Relationship = new JTextField();
    add(txtAuth1Relationship, "cell 13 15,growx,aligny center");
    txtAuth1Relationship.setColumns(10);

    JButton btnAddAuth1Photo = new JButton("Add Photo");
    add(btnAddAuth1Photo, "cell 15 15,alignx left,aligny top");
    AttachPhotoAction auth1PhotoAction = new AttachPhotoAction(this, AUTH1, INPUT);
    btnAddAuth1Photo.addActionListener(auth1PhotoAction);
    
    auth2PhotoPanel = new PreviewPanel();
    auth2PhotoPanel.setBorder(null);
    add(auth2PhotoPanel, "cell 1 16,grow");

    JLabel label_3 = new JLabel("First");
    add(label_3, "cell 3 16,alignx right,aligny center");

    txtAuth2FirstName = new JTextField();
    txtAuth2FirstName.setColumns(10);
    add(txtAuth2FirstName, "cell 5 16,growx,aligny center");

    JLabel label_6 = new JLabel("Last");
    add(label_6, "cell 7 16,alignx right,aligny center");

    txtAuth2LastName = new JTextField();
    txtAuth2LastName.setColumns(10);
    add(txtAuth2LastName, "cell 9 16,growx,aligny center");

    JLabel label_9 = new JLabel("Relationship");
    add(label_9, "cell 11 16,alignx right,aligny center");

    txtAuth2Relationship = new JTextField();
    txtAuth2Relationship.setColumns(10);
    add(txtAuth2Relationship, "cell 13 16,growx,aligny center");

    JButton btnAddAuth2Photo = new JButton("Add Photo");
    add(btnAddAuth2Photo, "cell 15 16,alignx left,aligny top");
    AttachPhotoAction auth2PhotoAction = new AttachPhotoAction(this, AUTH2, INPUT);
    btnAddAuth2Photo.addActionListener(auth2PhotoAction);
    
    auth3PhotoPanel = new PreviewPanel();
    auth3PhotoPanel.setBorder(null);
    add(auth3PhotoPanel, "cell 1 17,grow");

    JLabel label_4 = new JLabel("First");
    add(label_4, "cell 3 17,alignx right,aligny center");

    txtAuth3FirstName = new JTextField();
    txtAuth3FirstName.setColumns(10);
    add(txtAuth3FirstName, "cell 5 17,growx,aligny center");

    JLabel label_7 = new JLabel("Last");
    add(label_7, "cell 7 17,alignx right,aligny center");

    txtAuth3LastName = new JTextField();
    txtAuth3LastName.setColumns(10);
    add(txtAuth3LastName, "cell 9 17,growx,aligny center");

    JLabel label_10 = new JLabel("Relationship");
    add(label_10, "cell 11 17,alignx right,aligny center");

    txtAuth3Relationship = new JTextField();
    txtAuth3Relationship.setColumns(10);
    add(txtAuth3Relationship, "cell 13 17,growx,aligny center");

    JButton btnAddAuth3Photo = new JButton("Add Photo");
    add(btnAddAuth3Photo, "cell 15 17,alignx left,aligny top");
    AttachPhotoAction auth3PhotoAction = new AttachPhotoAction(this, AUTH3, INPUT);
    btnAddAuth3Photo.addActionListener(auth3PhotoAction);
    
    auth4PhotoPanel = new PreviewPanel();
    auth4PhotoPanel.setBorder(null);
    add(auth4PhotoPanel, "cell 1 18,grow");

    JLabel label_5 = new JLabel("First");
    add(label_5, "cell 3 18,alignx right,aligny center");

    txtAuth4FirstName = new JTextField();
    txtAuth4FirstName.setColumns(10);
    add(txtAuth4FirstName, "cell 5 18,growx,aligny center");

    JLabel label_8 = new JLabel("Last");
    add(label_8, "cell 7 18,alignx right,aligny center");

    txtAuth4LastName = new JTextField();
    txtAuth4LastName.setColumns(10);
    add(txtAuth4LastName, "cell 9 18,growx,aligny center");

    JLabel label_11 = new JLabel("Relationship");
    add(label_11, "cell 11 18,alignx right,aligny center");

    txtAuth4Relationship = new JTextField();
    txtAuth4Relationship.setColumns(10);
    add(txtAuth4Relationship, "cell 13 18,growx,aligny center");

    JButton btnAddAuth4Photo = new JButton("Add Photo");
    add(btnAddAuth4Photo, "cell 15 18,alignx left,aligny top");
    AttachPhotoAction auth4PhotoAction = new AttachPhotoAction(this, AUTH4, INPUT);
    btnAddAuth4Photo.addActionListener(auth4PhotoAction);
  }

  public static void addPhoto(AttachPhotoAction apa) {
    String person = (String)apa.getValue("person");
    String file = (String)apa.getValue("file");

    BufferedImage image = null;
    try {
      image = ImageIO.read(new File(file)); // image read now create a copy to crop

    } catch (IOException e) {
      e.printStackTrace();
    }

    if(image == null) {
        throw new IllegalArgumentException("Failed to retreive valid file: " + file);
    }

    BufferedImage newImg = new BufferedImage(100, 100, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = newImg.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, 100, 100, null);
    g2d.dispose();
    JLabel picture = new JLabel(new ImageIcon(newImg));

    switch (person) {
      case CHILD:
        childPhotoPanel.addImage(image);
        if(childPhotoPanel.getComponentCount() > 0)
          childPhotoPanel.remove(0);
        childPhotoPanel.add(picture);
        childPhotoPanel.revalidate();
        break;
      case PARENT:
        parentPhotoPanel.addImage(image);
        if(parentPhotoPanel.getComponentCount() > 0)
          parentPhotoPanel.remove(0);
        parentPhotoPanel.add(picture);
        parentPhotoPanel.revalidate();
        break;
      case AUTH1:
        auth1PhotoPanel.addImage(image);
        if(auth1PhotoPanel.getComponentCount() > 0)
          auth1PhotoPanel.remove(0);
        auth1PhotoPanel.add(picture);
        auth1PhotoPanel.revalidate();
        break;
      case AUTH2:
        auth2PhotoPanel.addImage(image);
        if(auth2PhotoPanel.getComponentCount() > 0)
          auth2PhotoPanel.remove(0);
        auth2PhotoPanel.add(picture);
        auth2PhotoPanel.revalidate();
        break;
      case AUTH3:
        auth3PhotoPanel.addImage(image);
        if(auth3PhotoPanel.getComponentCount() > 0)
          auth3PhotoPanel.remove(0);
        auth3PhotoPanel.add(picture);
        auth3PhotoPanel.revalidate();
        break;
      case AUTH4:
        auth4PhotoPanel.addImage(image);
        if(auth4PhotoPanel.getComponentCount() > 0)
          auth4PhotoPanel.remove(0);
        auth4PhotoPanel.add(picture);
        auth4PhotoPanel.revalidate();
        break;
      default:
        throw new IllegalArgumentException("Trying to attache an unknown person type: "
                                                                              + person);
    }
  }


}
