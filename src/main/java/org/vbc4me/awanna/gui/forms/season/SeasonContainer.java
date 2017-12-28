package org.vbc4me.awanna.gui.forms.season;

import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.facets.Session;
import org.vbc4me.awanna.gui.AppGui;

/**
 * Contains all the components needed to work on a season inside the GUI. There is only one container for the open Season.
 */
public final class SeasonContainer {

    // the panels needed to operate on this season
    public final SeasonButtonPanel buttonPanel = new SeasonButtonPanel();
    public final SeasonEditForm editForm = new SeasonEditForm(this);
    public final SeasonDisplayForm displayForm = new SeasonDisplayForm(this);
    public final SeasonTableModel tableModel = new SeasonTableModel();

    private Season season;

    public void createSeason() {

        season = Season.builder()
                .name(SeasonEditForm.fileName())
                .session(Session.builder()
                        .startDate(SeasonEditForm.startDate())
                        .endDate(SeasonEditForm.endDate())
                        .build())
                .build();


        displayForm.updatePanel(season);
        AppGui.displayPanel().updateBottomLeft(displayForm);
        AppGui.displayPanel().updateLowerRight(new DashboardButtonPanel());
        buttonPanel.createAction.setEnabled(false);
        buttonPanel.saveAction.setEnabled(true);
        buttonPanel.saveAsAction.setEnabled(true);
    }
}
