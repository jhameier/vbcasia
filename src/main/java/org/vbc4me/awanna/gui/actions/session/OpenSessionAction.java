package org.vbc4me.awanna.gui.actions.session;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to create a new blank record.
 * 
 * @author John Hameier: June 2015.
 */
public class OpenSessionAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JFrame frame;
    
    public OpenSessionAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Open Session");
	putValue(SHORT_DESCRIPTION, "Opens an existing Session.");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Open Session Action";
	String title = "Open Existing Session";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}