package org.vbc4me.awanna.gui.forms.season.actions;

import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.gui.AppGui;
import org.vbc4me.awanna.utility.readers.SeasonFileReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.prefs.Preferences;

/**
 * Used to create a new blank Season record.
 *
 * @author John Hameier: June 2015.
 */
public final class OpenSeasonAction extends AbstractAction {

  private static final long serialVersionUID = -6301577011454895115L;
  private Container frame;

  public OpenSeasonAction(Container frame) {
    this.frame = frame;
    putValue(NAME, "Open Season");
    putValue(SHORT_DESCRIPTION, "Opens an existing Season.");
  }

  public void actionPerformed(ActionEvent e) {
    Preferences preferences = Preferences.userRoot();
    String path = preferences.get("DEFAULT_PATH", "");
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogType(JFileChooser.OPEN_DIALOG);
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setCurrentDirectory(new File(path));

    FileNameExtensionFilter filter = new FileNameExtensionFilter("Season File", "sea");
    chooser.setFileFilter(filter);

    int returnValue = chooser.showOpenDialog(frame);
    if (returnValue == JFileChooser.APPROVE_OPTION) {

      File file = new File(chooser.getSelectedFile().getAbsolutePath());
      chooser.setCurrentDirectory(file);
      preferences.put("DEFAULT_PATH", file.getAbsolutePath());


      Season season = null;
      try {
        season = SeasonFileReader.parse(file);
      } catch (Exception ex) {
        String message = ex.getMessage() + "\n\nProgram exiting.";
        JOptionPane.showMessageDialog(frame, message, "Program Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
      AppGui.currentSeason(season);
    }
  }
}