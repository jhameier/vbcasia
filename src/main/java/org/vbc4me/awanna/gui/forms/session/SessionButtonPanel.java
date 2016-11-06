package org.vbc4me.awanna.gui.forms.session;

import org.vbc4me.awanna.gui.forms.session.actions.CopySessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.NewSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.OpenSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveSessionAction;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SessionButtonPanel extends JPanel {
	private static final long serialVersionUID = -169212683318427227L;
	public final static CopySessionAction copyAction = new CopySessionAction(null);
	public final static NewSessionAction newAction = new NewSessionAction(null);
	public final static OpenSessionAction openAction = new OpenSessionAction(null);
	public final static SaveSessionAction saveAction = new SaveSessionAction(null);
	
	public SessionButtonPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(1);
		add(horizontalStrut);

		JButton btnNew = new JButton(newAction);
		add(btnNew);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		add(horizontalStrut_1);
		
		JButton btnOpen = new JButton(openAction);
		add(btnOpen);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		add(horizontalStrut_2);
		
		JButton btnCopy = new JButton(copyAction);
		add(btnCopy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		add(horizontalStrut_3);
		
		JButton btnSave = new JButton(saveAction);
		add(btnSave);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		add(horizontalStrut_4);
		
		JButton btnNewActivity = new JButton();
		add(btnNewActivity);
	}
}