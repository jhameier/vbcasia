package org.vbc4me.awanna.gui.actions.activity;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 *  Action Classes for Buttons and Menu Items
 */
public class EditActivityAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
    private JFrame frame;
    
    public EditActivityAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Edit Activity");
	putValue(SHORT_DESCRIPTION, "Edits the currently loaded activity information ");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Edit Activity Action";
	String title = "Edit Activity";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}
