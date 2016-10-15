package org.vbc4me.awanna.gui.forms.activity.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to create a new blank record.
 * 
 * @author John Hameier: June 2015.
 */
public class OpenActivityRecordAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JFrame frame;
    
    public OpenActivityRecordAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Open Activity");
	putValue(SHORT_DESCRIPTION, "Opens an existing Activity.");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Open Activity Action";
	String title = "Open Existing Activity";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}