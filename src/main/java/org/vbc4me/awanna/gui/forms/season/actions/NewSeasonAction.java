package org.vbc4me.awanna.gui.forms.season.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonButtonPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonEditForm;
import org.vbc4me.awanna.gui.forms.season.SeasonTableModel;

/**
 * Used to create a new blank Season.
 *
 * @author John Hameier: June 2015.
 */
public class NewSeasonAction extends AbstractAction {
	private static final long serialVersionUID = -6301577011454895115L;
	private JPanel panel;
	
	public NewSeasonAction(JPanel panel) {
		this.panel = panel;
		putValue(NAME, "New Season");
		putValue(SHORT_DESCRIPTION, "Create a New Blank Season.");
	}
	
	public void actionPerformed(ActionEvent e) {
		PrimaryGuiPanel.displayPanel().updateAllDisplays(new SeasonEditForm(),  
				new SeasonButtonPanel(), new SeasonTableModel());
	}
}