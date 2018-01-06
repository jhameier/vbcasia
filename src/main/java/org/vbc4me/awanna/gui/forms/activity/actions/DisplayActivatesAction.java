package org.vbc4me.awanna.gui.forms.activity.actions;

import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.activity.ActivitiesTableModel;

import javax.swing.AbstractAction;
import java.awt.Container;
import java.awt.event.ActionEvent;

public class DisplayActivatesAction extends AbstractAction {
  private final Container frame;

  public DisplayActivatesAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Display All");
    putValue(SHORT_DESCRIPTION, "Display all the current Activities for the open session");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ActivitiesTableModel model = new ActivitiesTableModel();
    for (Activity activity: AppGui.currentSeason().session().activities().values()) {
      model.addData(activity);
    }

    AppGui.displayPanel().updateTableDisplay(model);
  }
}
