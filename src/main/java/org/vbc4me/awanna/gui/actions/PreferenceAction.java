package org.vbc4me.awanna.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 *  Action Classes for Buttons and Menu Items
 */
public final class PreferenceAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private  JFrame frame;
    
    public PreferenceAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Preferences");
	putValue(SHORT_DESCRIPTION, "Edits the currently app preferences information ");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Preferences Action";
	String title = "App Preferences";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}
