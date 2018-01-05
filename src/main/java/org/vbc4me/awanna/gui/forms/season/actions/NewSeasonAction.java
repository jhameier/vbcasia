package org.vbc4me.awanna.gui.forms.season.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Used to create a new blank SeasonContainer.
 *
 * @author John Hameier: June 2015.
 */
public final class NewSeasonAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private final Container frame;

  public NewSeasonAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "New Season");
    putValue(SHORT_DESCRIPTION, "Create a New Blank Season.");
  }

  public void actionPerformed(ActionEvent e) {

  }

}