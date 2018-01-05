package org.vbc4me.awanna.gui.forms;

import net.miginfocom.swing.MigLayout;
import org.vbc4me.awanna.gui.AppGui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import java.awt.Component;

public class DashboardButtonPanel extends JPanel {

  private static final long serialVersionUID = -3094138577322028959L;

  public DashboardButtonPanel() {
    setBorder(new LineBorder(new Color(0, 0, 0)));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
    buttonPanel.setLayout(new MigLayout("", "[]", "[][][]"));
    buttonPanel.setAlignmentX(LEFT_ALIGNMENT);
    add(buttonPanel);

    JPanel panelActivity = new JPanel();
    panelActivity.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelActivity.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
    buttonPanel.add(panelActivity, "cell 0 0,alignx left,aligny center");
    panelActivity.setLayout(new MigLayout("", "[50px][][][]", "[23px]"));

    JLabel lblActivity = new JLabel("Activities");
    panelActivity.add(lblActivity, "cell 0 0,alignx right,aligny center");

    // Display the current Session's Activities
    JButton btnActivityDispplay = new JButton("Display");
    btnActivityDispplay.setAction(AppGui.DisplayActivitesAction());
    panelActivity.add(btnActivityDispplay, "cell 1 0,aligny center");

    // Create a new Activity in the current Session
    JButton btnActivityCreate = new JButton("Create");
    btnActivityCreate.setAction(AppGui.NewActivityRecordAction());
    panelActivity.add(btnActivityCreate, "cell 2 0,aligny center");

    // Open the current Activity for editing
    JButton btnActivityOpen = new JButton("Edit");
    btnActivityOpen.setAction(AppGui.OpenActivityRecordAction());
    panelActivity.add(btnActivityOpen, "cell 3 0,aligny center");


    /* ********************************************************************** */
    JPanel panelStudent = new JPanel();
    panelStudent.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelStudent.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
    buttonPanel.add(panelStudent, "cell 0 1,alignx left,aligny center");
    panelStudent.setLayout(new MigLayout("", "[50px][][][]", "[23px]"));

    JLabel lblStudent = new JLabel("Student");
    panelStudent.add(lblStudent, "cell 0 0,alignx right,aligny center");

    JButton btnStudentDisplay = new JButton("Display");
    btnStudentDisplay.setAction(AppGui.OpenStudentRecordAction());
    panelStudent.add(btnStudentDisplay, "cell 1 0,aligny center");

    JButton btnStudentCreate = new JButton("Create");
    btnStudentCreate.setAction(AppGui.CreateNewStudentRecordAction());
    panelStudent.add(btnStudentCreate, "cell 2 0,aligny center");

    JButton btnStudentOpen = new JButton("Edit");
    btnStudentOpen.setAction(AppGui.OpenStudentRecordAction());
    panelStudent.add(btnStudentOpen, "cell 3 0,aligny center");

    /* ********************************************************************** */

    JPanel panelStaff = new JPanel();
    panelStaff.setAlignmentX(Component.LEFT_ALIGNMENT);
    panelStaff.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
    buttonPanel.add(panelStaff, "cell 0 2,aligny center");
    panelStaff.setLayout(new MigLayout("", "[50px][][][]", "[23px]"));

    JLabel lblStaff = new JLabel("Staff");
    panelStaff.add(lblStaff, "cell 0 0,alignx right,aligny center");

    JButton btnStaffDisplay = new JButton("Display");
    btnStaffDisplay.setAction(AppGui.OpenStaffRecordActivity());
    panelStaff.add(btnStaffDisplay, "cell 1 0,aligny center");

    JButton btnStaffCreate = new JButton("Create");
    btnStaffCreate.setAction(AppGui.CreateNewStaffRecordActivity());
    panelStaff.add(btnStaffCreate, "cell 2 0,aligny center");

    JButton btnStaffOpen = new JButton("Edit");
    btnStaffOpen.setAction(AppGui.OpenStaffRecordActivity());
    panelStaff.add(btnStaffOpen, "cell 3 0,aligny center");
  }

}
