package org.vbc4me.awanna.gui.forms.student;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.vbc4me.awanna.gui.AppGui;

public class RecordButtonPanel extends JPanel {
  private static final long serialVersionUID = 1909642709713212890L;

  public RecordButtonPanel() {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

    Component horizontalStrut = Box.createHorizontalStrut(1);
    add(horizontalStrut);

    JButton btnNew = new JButton("New");
    btnNew.setAction(AppGui.createNewStudentRecordAction());
    add(btnNew);

    Component horizontalStrut_1 = Box.createHorizontalStrut(5);
    add(horizontalStrut_1);

    JButton btnEdit = new JButton("Edit");
    btnEdit.setAction(AppGui.editStudentRecordAction());
    add(btnEdit);

    Component horizontalStrut_2 = Box.createHorizontalStrut(5);
    add(horizontalStrut_2);

    JButton btnCopy = new JButton("Copy");
    btnCopy.setAction(AppGui.copyStudentRecordAction());
    add(btnCopy);

    Component horizontalStrut_3 = Box.createHorizontalStrut(5);
    add(horizontalStrut_3);

    JButton btnSave = new JButton("Save");
    btnSave.setAction(AppGui.saveStudentRecordAction());
    add(btnSave);
  }

}