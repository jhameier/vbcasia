package org.vbc4me.awanna.gui.actions.season;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Used to create a new blank season record.
 *
 * @author John Hameier: June 2015.
 */
public class OpenSeasonAction extends AbstractAction {
	private static final long serialVersionUID = -6301577011454895115L;
	private JFrame frame;
	
	public OpenSeasonAction(JFrame frame) {
		this.frame = frame;
		putValue(NAME, "Open Season");
		putValue(SHORT_DESCRIPTION, "Opens an existing Season.");
	}
	
	public void actionPerformed(ActionEvent e) {
		// String message = "This is activated from Open Season Action";
		// String title = "Open Existing Season";
		// int messageType = JOptionPane.INFORMATION_MESSAGE;
		// JOptionPane.showMessageDialog(frame, message, title, messageType);
		
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
			//FIXME read in file and setup SeasonDisplayForm
		}

	}
}