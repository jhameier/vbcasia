package org.vbc4me.awanna.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

import org.vbc4me.awanna.gui.actions.misc.AboutAction;
import org.vbc4me.awanna.gui.actions.misc.EditAction;
import org.vbc4me.awanna.gui.actions.misc.LookAndFeelAction;
import org.vbc4me.awanna.gui.actions.misc.PreferenceAction;
import org.vbc4me.awanna.gui.actions.misc.ProgramHelpAction;
import org.vbc4me.awanna.gui.actions.record.CopyRecordAction;
import org.vbc4me.awanna.gui.actions.record.NewRecordAction;
import org.vbc4me.awanna.gui.actions.record.SaveRecordAction;
import org.vbc4me.awanna.gui.actions.season.NewSeasonAction;
import org.vbc4me.awanna.gui.actions.season.OpenSeasonAction;
import org.vbc4me.awanna.gui.actions.session.CopySessionAction;
import org.vbc4me.awanna.gui.actions.session.NewSessionAction;
import org.vbc4me.awanna.gui.actions.session.OpenSessionAction;
import org.vbc4me.awanna.gui.actions.session.SaveSessionAction;
import org.vbc4me.awanna.gui.buttonPanels.RecordButtonPanel;
import org.vbc4me.awanna.gui.buttonPanels.SeasonButtonPanel;
import org.vbc4me.awanna.gui.buttonPanels.SessionButtonPanel;
import org.vbc4me.awanna.gui.forms.DisplayPanel;

/**
 * Used to hold the primary applications layout and component panels. The only
 * necessary component to expose to outside classes is the card panel in which
 * all other panels will be placed allowing a seemless transition to display
 * different types of information.
 *
 * @author John Hameier: June 2015
 */
public class PrimaryGuiPanel extends JFrame {
	private static final long serialVersionUID = 5953409495403830350L;
	
	public static PrimaryGuiPanel mainWindow;
	private static JPanel buttonCardPanel;
	private static CardLayout buttonCardLayout;
	private static DisplayPanel displayPanel;
	public static final String BUTTON = "Button";
	public static final String SEASON = "Season";
	public static final String SESSION = "Session";
	public static final String ACTIVITY = "Activity";
	
	private static LookAndFeelInfo[] lookList = UIManager.getInstalledLookAndFeels();
	
	/**
	 * Change the card layout for this applications button layout. Currently
	 * available button layouts are: SeasonButtonPanel, SessionButtonPanel and
	 * RecordButtonPanel. You call PrimaryGuiPanel.getButtonLayout().
	 */
	public static void changeButtonLayout(String buttonPanel) {
		buttonCardLayout.show(buttonCardPanel, buttonPanel);
	}
	
	/**
	 * Gets the primary display panel for this application. This is used to
	 * display different displays in this window without having to create them
	 * within the GUI itself. You can create different panels and call them from
	 * an Action and replace the panels to the primary display.
	 */
	public static DisplayPanel displayPanel() {
		return displayPanel;
	}
	
	/**
	 * Primary constructor that lays out the basic application structure using a
	 * border layout with a menu bar, button panel in the north and the card
	 * panel in the center components.
	 */
	public PrimaryGuiPanel() {
		
		buttonCardLayout = new CardLayout(5, 5);
		buttonCardPanel = new JPanel(buttonCardLayout);
		getContentPane().add(buttonCardPanel, BorderLayout.NORTH);
		
		SeasonButtonPanel seasonButtonPanel = new SeasonButtonPanel(this);
		buttonCardPanel.add(seasonButtonPanel, SEASON);
		
		SessionButtonPanel sessionButtonPanel = new SessionButtonPanel(this);
		buttonCardPanel.add(sessionButtonPanel, SESSION);
		
		RecordButtonPanel buttonPanel = new RecordButtonPanel(this);
		buttonCardPanel.add(buttonPanel, BUTTON);
		
		displayPanel = new DisplayPanel();
		JScrollPane scrollPane = new JScrollPane(displayPanel);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		/*
		 * ***************** FILE MENU ************************
		 */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewSeason = new JMenuItem("New Season");
		Action newSeasonAction = new NewSeasonAction(this);
		mntmNewSeason.addActionListener(newSeasonAction);
		mnFile.add(mntmNewSeason);
		
		JMenuItem mntmOpenSeason = new JMenuItem("Open Season");
		Action openSeasonAction = new OpenSeasonAction(this);
		mntmOpenSeason.addActionListener(openSeasonAction);
		mnFile.add(mntmOpenSeason);
		
		mnFile.addSeparator();
		
		JMenuItem mntmNewSession = new JMenuItem("New Session");
		Action newSessionAction = new NewSessionAction(this);
		mntmNewSession.addActionListener(newSessionAction);
		mnFile.add(mntmNewSession);
		
		JMenuItem mntmOpenSession = new JMenuItem("Open Session");
		Action openSessionAction = new OpenSessionAction(this);
		mntmOpenSession.addActionListener(openSessionAction);
		mnFile.add(mntmOpenSession);
		
		JMenuItem mntmCopySession = new JMenuItem("Copy Session");
		Action copySessionAction = new CopySessionAction(this);
		mntmCopySession.addActionListener(copySessionAction);
		mnFile.add(mntmCopySession);
		
		JMenuItem mntmSaveSession = new JMenuItem("Save Session");
		Action saveSessionAction = new SaveSessionAction(this);
		mntmSaveSession.addActionListener(saveSessionAction);
		mnFile.add(mntmSaveSession);
		
		mnFile.addSeparator();
		
		JMenuItem mntmNewRecord = new JMenuItem("New Record");
		Action newRecordAction = new NewRecordAction(this);
		mntmNewRecord.addActionListener(newRecordAction);
		mnFile.add(mntmNewRecord);
		
		JMenuItem mntmEdit = new JMenuItem("Edit Record");
		Action editRecordAction = new EditAction(this);
		mntmEdit.addActionListener(editRecordAction);
		mnFile.add(mntmEdit);
		
		JMenuItem mntmSaveRecord = new JMenuItem("Save Record");
		Action saveRecordAction = new SaveRecordAction(this);
		mntmSaveRecord.addActionListener(saveRecordAction);
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
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		Action copyRecordAction = new CopyRecordAction(this);
		mntmCopy.addActionListener(copyRecordAction);
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
		
		JMenuItem mntmAbout = new JMenuItem("About");
		Action aboutAction = new AboutAction(this);
		mntmAbout.addActionListener(aboutAction);
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmPrgHelp = new JMenuItem("Program Help");
		Action programHelp = new ProgramHelpAction(this);
		mntmPrgHelp.addActionListener(programHelp);
		mnHelp.add(mntmPrgHelp);
		
		JMenuItem mntmPref = new JMenuItem("Preferences");
		Action preferences = new PreferenceAction(this);
		mntmPref.addActionListener(preferences);
		mnHelp.add(mntmPref);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(PrimaryGuiPanel::initializeAndShowGui);
	}
	
	/**
	 * Initialize our Windowing System
	 */
	private static void initializeAndShowGui() {
		
		// Create the main window
		mainWindow = new PrimaryGuiPanel();
		Dimension windowSize = new Dimension(800, 800);
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setTitle("Awanna Session Workspace");
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
