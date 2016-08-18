package org.vbc4me.awanna.gui.actions.season;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonEditForm;
import org.vbc4me.awanna.gui.forms.season.SeasonTableModel;

/**
 * Used to create a new blank Season.
 *
 * @author John Hameier: June 2015.
 */
public class NewSeasonAction extends AbstractAction {
	private static final long serialVersionUID = -6301577011454895115L;
	
	public NewSeasonAction(JFrame frame) {
		putValue(NAME, "New Season");
		putValue(SHORT_DESCRIPTION, "Create a New Blank Season.");
	}
	
	public void actionPerformed(ActionEvent e) {
		PrimaryGuiPanel.changeButtonLayout(PrimaryGuiPanel.SEASON);
		PrimaryGuiPanel.displayPanel().updateBothDisplays(new SeasonEditForm(), BorderLayout.WEST, new SeasonTableModel());
		PrimaryGuiPanel.mainWindow.pack();
	}
}