package org.vbc4me.awanna.gui.actions.record;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SaveRecordAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JFrame frame;

    public SaveRecordAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Save Record");
	putValue(SHORT_DESCRIPTION, "Saves the currently loaded Record");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Save Record Action";
	String title = "Save Record";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}