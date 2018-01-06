package org.vbc4me.awanna.gui.forms.staff.activities;

import org.vbc4me.awanna.facets.Staff;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.gui.forms.staff.StaffTableModel;

import javax.swing.AbstractAction;
import java.awt.Container;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank record.
 *
 * @author John Hameier: June 2015.
 */
public final class DisplayAllStaffRecordAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public DisplayAllStaffRecordAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Display All");
    putValue(SHORT_DESCRIPTION, "Displays all Staff Records for the current session.");
    setEnabled(true);
  }

  public void actionPerformed(ActionEvent e) {
    StaffTableModel model = new StaffTableModel();
    for (Staff staff: AppGui.currentSeason().staff().values()) {
      model.addData(staff);
    }
    AppGui.displayPanel().updateTableDisplay(model);
  }
}