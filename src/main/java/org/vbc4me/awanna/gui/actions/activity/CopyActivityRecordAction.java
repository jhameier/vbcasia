package org.vbc4me.awanna.gui.actions.activity;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CopyActivityRecordAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JFrame frame;
    
    public CopyActivityRecordAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "Copy Activity");
	putValue(SHORT_DESCRIPTION, "Copies the currently loaded Activity");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Copy Activity Action";
	String title = "Copy Activity";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}