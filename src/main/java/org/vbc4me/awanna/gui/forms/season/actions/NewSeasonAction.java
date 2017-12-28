package org.vbc4me.awanna.gui.forms.season.actions;

import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.season.SeasonContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank SeasonContainer.
 *
 * @author John Hameier: June 2015.
 */
public final class NewSeasonAction extends AbstractAction {
    private static final long serialVersionUID = -6301577011454895115L;

    public NewSeasonAction() {
        putValue(NAME, "New Season");
        putValue(SHORT_DESCRIPTION, "Create a New Blank Season.");
    }

    public void actionPerformed(ActionEvent e) {
        SeasonContainer season = AppGui.season();
        AppGui.displayPanel().updateTableDisplay(season.tableModel);
        AppGui.displayPanel().updateBottomLeft(season.editForm);
        AppGui.displayPanel().updateUpperLeft(season.buttonPanel);
    }
}