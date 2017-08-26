package org.vbc4me.awanna.gui.forms.student.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class SaveStudentRecordAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JPanel panel;

    public SaveStudentRecordAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "Save Record");
        putValue(SHORT_DESCRIPTION, "Saves the currently loaded Record");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        String message = "This is activated from Save Record Action";
        String title = "Save Record";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(panel, message, title, messageType);
    }
}