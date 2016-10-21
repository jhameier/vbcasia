package org.vbc4me.awanna.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

import org.vbc4me.awanna.Workspace;
import org.vbc4me.awanna.gui.actions.misc.AboutAction;
import org.vbc4me.awanna.gui.forms.student.actions.EditRecordAction;
import org.vbc4me.awanna.gui.actions.misc.LookAndFeelAction;
import org.vbc4me.awanna.gui.actions.misc.PreferenceAction;
import org.vbc4me.awanna.gui.actions.misc.ProgramHelpAction;
import org.vbc4me.awanna.gui.forms.student.actions.CopyRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.NewRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.SaveRecordAction;
import org.vbc4me.awanna.gui.forms.DisplayPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonBlankForm;
import org.vbc4me.awanna.gui.forms.season.actions.NewSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.OpenSeasonAction;
import org.vbc4me.awanna.gui.forms.session.actions.CopySessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.NewSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.OpenSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveSessionAction;

/**
 * Used to hold the primary applications layout and component panels. The only
 * necessary component to expose to outside classes is the card panel in which
 * all other panels will be placed allowing a seem-less transition to display
 * different types of information.
 *
 * @author John Hameier: June 2015
 */
public class AppGui extends JFrame {
	private static final long serialVersionUID = 5953409495403830350L;
	
	private static DisplayPanel displayPanel;
	public static AppGui mainWindow;
	private static Workspace workspace;
	
	private static LookAndFeelInfo[] lookList = UIManager.getInstalledLookAndFeels();

	/**
	 * Return the current {@link DisplayPanel}.
	 */
	public static DisplayPanel displayPanel() {
		return displayPanel;
	}
	
	/**
	 * Returns the currently active workspace.
	 */
	public static Workspace workspace() {
		return workspace;
	}
	
	/**
	 * Primary constructor that lays out the basic application structure using a
	 * border layout with a menu bar, button panel in the north and the card
	 * panel in the center components.
	 */
	public AppGui() {

        /* *******************************************************************
		 *  establish the basic windowing structure.
		 *********************************************************************/
		
		displayPanel = new DisplayPanel();
		displayPanel.updateContentDisplay(new SeasonBlankForm());
		getContentPane().add(displayPanel, BorderLayout.CENTER);

        // Represents our currently working session
		Workspace.setContainer(displayPanel.displayContainer());

		/*
		 * ***************** FILE MENU ************************
		 */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewSeason = new JMenuItem("New Season");
		Action newSeasonAction = new NewSeasonAction(displayPanel);
		mntmNewSeason.addActionListener(newSeasonAction);
		mnFile.add(mntmNewSeason);
		
		JMenuItem mntmOpenSeason = new JMenuItem("Open Season");
		Action openSeasonAction = new OpenSeasonAction(displayPanel);
		mntmOpenSeason.addActionListener(openSeasonAction);
		mnFile.add(mntmOpenSeason);
		
		mnFile.addSeparator();
		
		Action newSessionAction = new NewSessionAction(displayPanel);
		JMenuItem mntmNewSession = new JMenuItem(newSessionAction);
		mnFile.add(mntmNewSession);

		Action openSessionAction = new OpenSessionAction(displayPanel);
		JMenuItem mntmOpenSession = new JMenuItem(openSessionAction);
		mnFile.add(mntmOpenSession);
		
		Action copySessionAction = new CopySessionAction(displayPanel);
		JMenuItem mntmCopySession = new JMenuItem(copySessionAction);
		mnFile.add(mntmCopySession);
		
		Action saveSessionAction = new SaveSessionAction(displayPanel);
		JMenuItem mntmSaveSession = new JMenuItem(saveSessionAction);
		mnFile.add(mntmSaveSession);
		
		mnFile.addSeparator();
		
		Action newRecordAction = new NewRecordAction(displayPanel);
		JMenuItem mntmNewRecord = new JMenuItem(newRecordAction);
		mnFile.add(mntmNewRecord);
		
		Action editRecordAction = new EditRecordAction(displayPanel);
		JMenuItem mntmEdit = new JMenuItem(editRecordAction);
		mnFile.add(mntmEdit);
		
		Action saveRecordAction = new SaveRecordAction(displayPanel);
		JMenuItem mntmSaveRecord = new JMenuItem(saveRecordAction);
		mnFile.add(mntmSaveRecord);
		
		/*
		 * ***************** EDIT MENU ************************
		 */
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		
		mnEdit.addSeparator();
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		Action copyRecordAction = new CopyRecordAction(displayPanel);
		JMenuItem mntmCopy = new JMenuItem(copyRecordAction);
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		/*
		 * ***************** HELP MENU ************************
		 */
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mntmWindowLookAndFeel = new JMenu("Window Look And Feel");
		mnHelp.add(mntmWindowLookAndFeel);
		
		// sets up the look and feel menu with radio buttons
		ButtonGroup buttonGroup = new ButtonGroup();
		
		for (LookAndFeelInfo aLookList : lookList) {
			JRadioButtonMenuItem radioButton = new JRadioButtonMenuItem(aLookList.getName());
			buttonGroup.add(radioButton);
			Action lookAndFeelAction = new LookAndFeelAction(this);
			radioButton.addActionListener(lookAndFeelAction);
			if (aLookList.getName().equals(UIManager.getLookAndFeel().getName())) {
				radioButton.setSelected(true);
			}
			mntmWindowLookAndFeel.add(radioButton);
		}
		
		Action aboutAction = new AboutAction(this);
		JMenuItem mntmAbout = new JMenuItem(aboutAction);
		mnHelp.add(mntmAbout);
		
		Action programHelp = new ProgramHelpAction(this);
		JMenuItem mntmPrgHelp = new JMenuItem(programHelp);
		mnHelp.add(mntmPrgHelp);
		
		Action preferences = new PreferenceAction(this);
		JMenuItem mntmPref = new JMenuItem(preferences);
		mnHelp.add(mntmPref);

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(AppGui::initializeAndShowGui);
	}
	
	/**
	 * Initialize our Windowing System and set window in center of primary default display.
	 */
	private static void initializeAndShowGui() {
		mainWindow = new AppGui();
		Dimension windowSize = new Dimension(800, 800);
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setTitle("Awana Workspace");
		mainWindow.setPreferredSize(windowSize);
		
		// Set window in center of Default Monitor Window
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = ge.getDefaultScreenDevice();
		Rectangle screenRect = device.getDefaultConfiguration().getBounds();
		mainWindow.setLocation(screenRect.width / 2 - windowSize.width / 2,
				screenRect.height / 2 - windowSize.height / 2);
		mainWindow.pack();
		mainWindow.setVisible(true);

	}
}
