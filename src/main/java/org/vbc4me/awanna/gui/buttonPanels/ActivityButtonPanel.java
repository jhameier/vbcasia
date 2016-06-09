package org.vbc4me.awanna.gui.buttonPanels;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.actions.activity.CopyActivityRecordAction;
import org.vbc4me.awanna.gui.actions.activity.EditActivityAction;
import org.vbc4me.awanna.gui.actions.activity.NewActivityRecordAction;
import org.vbc4me.awanna.gui.actions.activity.SaveActivityRecordAction;

public class ActivityButtonPanel extends JPanel{
    private JFrame frame;
	public static final JButton btnNew = new JButton("New");
	public static final JButton btnEdit = new JButton("Edit");
	public static final JButton btnCopy = new JButton("Copy");
	public static final JButton btnSave = new JButton("Save");
	
	public ActivityButtonPanel(JFrame frame) {
		this.frame = frame;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(1);
		add(horizontalStrut);
		
		Action createNewActivityRecordAction = new NewActivityRecordAction(frame);
		btnNew.setAction(createNewActivityRecordAction);
		add(btnNew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		add(horizontalStrut_1);
		
		Action loadActivityRecordAction = new EditActivityAction(frame);
		btnEdit.setAction(loadActivityRecordAction);
		add(btnEdit);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		add(horizontalStrut_2);
		
		Action copyActivityRecordAction = new CopyActivityRecordAction(frame);
		btnCopy.setAction(copyActivityRecordAction);
		add(btnCopy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		add(horizontalStrut_3);
		
		Action saveActivityRecordAction = new SaveActivityRecordAction(frame);
		btnSave.setAction(saveActivityRecordAction);
		add(btnSave);
	}
	
}
