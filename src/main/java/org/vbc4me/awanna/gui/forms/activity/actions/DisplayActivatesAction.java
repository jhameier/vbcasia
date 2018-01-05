package org.vbc4me.awanna.gui.forms.activity.actions;

import org.vbc4me.awanna.facets.Activity;
import org.vbc4me.awanna.gui.AppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Map;

public class DisplayActivatesAction extends AbstractAction {
  private final Container frame;

  public DisplayActivatesAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Display All");
    putValue(SHORT_DESCRIPTION, "Display all the current Activities for the open session");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Map<LocalDate, Activity> activities = AppGui.currentSeason().session().activities();

  }
}
