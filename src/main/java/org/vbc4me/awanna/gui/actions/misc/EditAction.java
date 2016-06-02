package org.vbc4me.awanna.gui.actions.misc;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 *  Action Classes for Buttons and Menu Items
 */
public class EditAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JFrame frame;
    
    public EditAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Edit Record");
	putValue(SHORT_DESCRIPTION, "Edits the currently loaded record information ");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Edit Record Action";
	String title = "Edit Record";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}
