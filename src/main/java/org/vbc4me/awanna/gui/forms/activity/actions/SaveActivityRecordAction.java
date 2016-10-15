package org.vbc4me.awanna.gui.forms.activity.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SaveActivityRecordAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JPanel panel;

    public SaveActivityRecordAction(JPanel panel) {
	this.panel = panel;
	putValue(NAME, "Save Activity");
	putValue(SHORT_DESCRIPTION, "Saves the currently loaded actions");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "This is activated from Save Activity Action";
	String title = "Save Activity";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}