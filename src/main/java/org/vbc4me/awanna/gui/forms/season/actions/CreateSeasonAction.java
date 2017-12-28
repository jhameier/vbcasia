package org.vbc4me.awanna.gui.forms.season.actions;

import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.season.SeasonEditForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new SeasonContainer with the name and date from the session panel.
 *
 * @author John Hameier: June 2015.
 */
public final class CreateSeasonAction extends AbstractAction {
    private static final long serialVersionUID = 5370980765758188903L;

    public CreateSeasonAction() {
        putValue(NAME, "Create Season");
        putValue(SHORT_DESCRIPTION, "Create a New Season.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        int ans = JOptionPane.showConfirmDialog(AppGui.displayPanel(), "Create a new Season?");
        if (ans == JOptionPane.YES_OPTION) {
            System.out.println(SeasonEditForm.fileName());
        }
    }
}