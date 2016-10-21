package org.vbc4me.awanna.gui.forms.student;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.actions.misc.EditAction;
import org.vbc4me.awanna.gui.forms.student.actions.CopyRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.NewRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.SaveRecordAction;

public class RecordButtonPanel extends JPanel {
	private static final long serialVersionUID = 1909642709713212890L;
		
	public static final JButton btnNew = new JButton("New");
	public static final JButton btnEdit = new JButton("Edit");
	public static final JButton btnCopy = new JButton("Copy");
	public static final JButton btnSave = new JButton("Save");
	
	public RecordButtonPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(1);
		add(horizontalStrut);
		
		Action createNewRecordAction = new NewRecordAction(this);
		btnNew.setAction(createNewRecordAction);
		add(btnNew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		add(horizontalStrut_1);
		
		Action loadRecordAction = new EditAction(this);
		btnEdit.setAction(loadRecordAction);
		add(btnEdit);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		add(horizontalStrut_2);
		
		Action copyRecordAction = new CopyRecordAction(this);
		btnCopy.setAction(copyRecordAction);
		add(btnCopy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		add(horizontalStrut_3);
		
		Action saveRecordAction = new SaveRecordAction(this);
		btnSave.setAction(saveRecordAction);
		add(btnSave);
	}
	
}