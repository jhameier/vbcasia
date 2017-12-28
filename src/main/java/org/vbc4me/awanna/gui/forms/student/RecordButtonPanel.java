package org.vbc4me.awanna.gui.forms.student;

import java.awt.Component;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.vbc4me.awanna.gui.forms.student.actions.CopyStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.EditStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.NewStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.SaveStudentRecordAction;

public class RecordButtonPanel extends JPanel {

  public static final JButton btnNew = new JButton("New");
  public static final JButton btnEdit = new JButton("Edit");
  public static final JButton btnCopy = new JButton("Copy");
  public static final JButton btnSave = new JButton("Save");
  private static final long serialVersionUID = 1909642709713212890L;

  public RecordButtonPanel() {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

    Component horizontalStrut = Box.createHorizontalStrut(1);
    add(horizontalStrut);

    Action createNewRecordAction = new NewStudentRecordAction(this);
    btnNew.setAction(createNewRecordAction);
    add(btnNew);

    Component horizontalStrut_1 = Box.createHorizontalStrut(5);
    add(horizontalStrut_1);

    Action loadRecordAction = new EditStudentRecordAction(this);
    btnEdit.setAction(loadRecordAction);
    add(btnEdit);

    Component horizontalStrut_2 = Box.createHorizontalStrut(5);
    add(horizontalStrut_2);

    Action copyRecordAction = new CopyStudentRecordAction(this);
    btnCopy.setAction(copyRecordAction);
    add(btnCopy);

    Component horizontalStrut_3 = Box.createHorizontalStrut(5);
    add(horizontalStrut_3);

    Action saveRecordAction = new SaveStudentRecordAction(this);
    btnSave.setAction(saveRecordAction);
    add(btnSave);
  }

}