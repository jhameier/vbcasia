package org.vbc4me.awanna.gui.forms.activity.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CopyActivityRecordAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JPanel panel;

    public CopyActivityRecordAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "Copy Activity");
        putValue(SHORT_DESCRIPTION, "Copies the currently loaded Activity");
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Copy Activity Action";
        String title = "Copy Activity";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}