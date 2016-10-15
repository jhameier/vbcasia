package org.vbc4me.awanna.gui.actions.misc;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *  Action Class for Buttons and Menu Items
 */
public class EditAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;
	private JPanel panel;
    
    public EditAction(JPanel panel) {
	this.panel = panel;
	putValue(NAME, "Edit Record");
	putValue(SHORT_DESCRIPTION, "Edits the currently loaded record information ");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Edit Record Action";
	String title = "Edit Record";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}
