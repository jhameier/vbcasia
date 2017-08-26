package org.vbc4me.awanna.gui.forms.student.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class CopyStudentRecordAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JPanel panel;

    public CopyStudentRecordAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "Copy Record");
        putValue(SHORT_DESCRIPTION, "Copies the currently loaded Record");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Copy Record Action";
        String title = "Copy Record";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}