package org.vbc4me.awanna.gui.forms.activity;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.forms.activity.actions.CopyActivityRecordAction;
import org.vbc4me.awanna.gui.forms.activity.actions.EditActivityAction;
import org.vbc4me.awanna.gui.forms.activity.actions.NewActivityRecordAction;
import org.vbc4me.awanna.gui.forms.activity.actions.SaveActivityRecordAction;

public class ActivityButtonPanel extends JPanel{
	private static final long serialVersionUID = -364619699132689562L;
		
	public ActivityButtonPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(1);
		add(horizontalStrut);
		
		Action createNewActivityRecordAction = new NewActivityRecordAction(this);
		final JButton btnNew = new JButton("New");
		btnNew.setAction(createNewActivityRecordAction);
		add(btnNew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		add(horizontalStrut_1);
		
		Action loadActivityRecordAction = new EditActivityAction(this);
		final JButton btnEdit = new JButton("Edit");
		btnEdit.setAction(loadActivityRecordAction);
		add(btnEdit);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		add(horizontalStrut_2);
		
		Action copyActivityRecordAction = new CopyActivityRecordAction(this);
		final JButton btnCopy = new JButton("Copy");
		btnCopy.setAction(copyActivityRecordAction);
		add(btnCopy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		add(horizontalStrut_3);
		
		Action saveActivityRecordAction = new SaveActivityRecordAction(this);
		final JButton btnSave = new JButton("Save");
		btnSave.setAction(saveActivityRecordAction);
		add(btnSave);
	}
	
}
