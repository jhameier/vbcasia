package org.vbc4me.awanna.gui.forms.season;

import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Session;
import org.vbc4me.awanna.gui.AppGui;

/**
 * Contains all the components needed to work on a season
 */
public final class SeasonContainer {
    public SeasonContainer(){}
    public static SeasonButtonPanel buttonPanel = new SeasonButtonPanel();
    public static SeasonEditForm editForm = new SeasonEditForm();
    public static SeasonBlankForm blankForm = new SeasonBlankForm();
    public static SeasonDisplayForm displayForm = new SeasonDisplayForm();
    public static SeasonTableModel tableModel = new SeasonTableModel();

    public static Season season;

    public static void createSeason() {
       season = new Season(editForm.getName(), new Session(editForm.startDate(), editForm.endDate()));
       displayForm.updatePanel(season);
       AppGui.displayPanel().updateBottomLeft(displayForm);
       AppGui.displayPanel().updateLowerRight(new DashboardButtonPanel());
      SeasonButtonPanel.createAction.setEnabled(false);
      SeasonButtonPanel.saveAction.setEnabled(true);
      SeasonButtonPanel.saveAsAction.setEnabled(true);
    }
}
