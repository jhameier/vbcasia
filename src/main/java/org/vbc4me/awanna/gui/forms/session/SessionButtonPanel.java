package org.vbc4me.awanna.gui.forms.session;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.forms.session.actions.CopySessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.NewSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.OpenSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveSessionAction;

public class SessionButtonPanel extends JPanel {
	private static final long serialVersionUID = -169212683318427227L;

	private final Action openSessionAction = new OpenSessionAction(this);
	private final Action createNewSessionAction = new NewSessionAction(this);
	private final Action copySessionAction = new CopySessionAction(this);
	private final Action saveSessionAction = new SaveSessionAction(this);
	
	public SessionButtonPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(1);
		add(horizontalStrut);
		
		JButton btnNew = new JButton("New Session");
		btnNew.setAction(createNewSessionAction);
		add(btnNew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		add(horizontalStrut_1);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setAction(openSessionAction);
		add(btnOpen);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		add(horizontalStrut_2);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.setAction(copySessionAction);
		add(btnCopy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		add(horizontalStrut_3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setAction(saveSessionAction);
		add(btnSave);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		add(horizontalStrut_4);
		
		JButton btnNewActivity = new JButton("New Activity");
		add(btnNewActivity);
	}
}