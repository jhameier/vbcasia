package org.vbc4me.awanna.gui.forms.season.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.season.SeasonButtonPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonEditForm;
import org.vbc4me.awanna.gui.forms.season.SeasonTableModel;

/**
 * Used to create a new Season with the name and date from the session panel.
 *
 * @author John Hameier: June 2015.
 */
@SuppressWarnings("unused")
public class CreateSeasonAction extends AbstractAction {
    private static final long serialVersionUID = 5370980765758188903L;
    private JPanel panel;

    public CreateSeasonAction(JPanel panel) {
        this.panel = panel;
        putValue(NAME, "Create Season");
        putValue(SHORT_DESCRIPTION, "Create a New Season.");
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {


    }
}