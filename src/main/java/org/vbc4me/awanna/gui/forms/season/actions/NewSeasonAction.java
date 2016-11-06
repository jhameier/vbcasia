package org.vbc4me.awanna.gui.forms.season.actions;

import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.season.SeasonButtonPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonContainer;
import org.vbc4me.awanna.gui.forms.season.SeasonEditForm;
import org.vbc4me.awanna.gui.forms.season.SeasonTableModel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
		SeasonEditForm editForm = SeasonContainer.editForm;
		SeasonButtonPanel btnPanel = SeasonContainer.buttonPanel;
		SeasonTableModel tableModel = SeasonContainer.tableModel;
		
		AppGui.displayPanel().updateTableDisplay(tableModel);
		AppGui.displayPanel().updateBottomLeft(editForm);
		AppGui.displayPanel().updateUpperLeft(btnPanel);
		
	}
}