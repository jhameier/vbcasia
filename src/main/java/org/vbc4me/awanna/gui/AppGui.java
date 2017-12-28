package org.vbc4me.awanna.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.List;
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
import org.vbc4me.awanna.gui.actions.AboutAction;
import org.vbc4me.awanna.gui.actions.LookAndFeelAction;
import org.vbc4me.awanna.gui.actions.PreferenceAction;
import org.vbc4me.awanna.gui.actions.ProgramHelpAction;
import org.vbc4me.awanna.gui.forms.DisplayPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonBlankForm;
import org.vbc4me.awanna.gui.forms.season.SeasonContainer;
import org.vbc4me.awanna.gui.forms.session.SessionButtonPanel;
import org.vbc4me.awanna.gui.forms.student.StudentContainer;

/**
 * Used to hold the primary applications layout and component panels. The only necessary component to expose to outside
 * classes is the card panel in which all other panels will be placed allowing a seamless transition to display
 * different types of information.
 *
 * @author John Hameier: June 2015
 */
public final class AppGui extends JFrame {

  private static final long serialVersionUID = 5953409495403830350L;

  private static DisplayPanel displayPanel;
  private static AppGui mainWindow;
  private static List<SeasonContainer> seasonContainer;

  private static LookAndFeelInfo[] lookList = UIManager.getInstalledLookAndFeels();

  /**
   * Primary constructor that lays out the basic application structure using a border layout with a menu bar, button
   * panel in the north and the card panel in the center components.
   */
  public AppGui() {

    /* *******************************************************************
     *  establish the basic windowing structure.
     *********************************************************************/
    displayPanel = new DisplayPanel();
    displayPanel.updateBottomLeft(new SeasonBlankForm());
    setCurrentSeason(new SeasonContainer());
    getContentPane().add(displayPanel, BorderLayout.CENTER);

    /*
     * ***************** FILE MENU ************************
     */

    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    JMenu mnFile = new JMenu("File");
    menuBar.add(mnFile);

    JMenuItem mntmNewSeason = new JMenuItem(season().buttonPanel.newAction);
    mnFile.add(mntmNewSeason);

    JMenuItem mntmOpenSeason = new JMenuItem(season().buttonPanel.openAction);
    mnFile.add(mntmOpenSeason);

    JMenuItem mntmSaveSeason = new JMenuItem(season().buttonPanel.saveAction);
    mnFile.add(mntmSaveSeason);

    JMenuItem mntmSaveasSeason = new JMenuItem(season().buttonPanel.saveAsAction);
    mnFile.add(mntmSaveasSeason);

    mnFile.addSeparator();

    JMenuItem mntmNewSession = new JMenuItem(SessionButtonPanel.newAction);
    mnFile.add(mntmNewSession);

    JMenuItem mntmOpenSession = new JMenuItem(SessionButtonPanel.openAction);
    mnFile.add(mntmOpenSession);

    JMenuItem mntmSaveSession = new JMenuItem(SessionButtonPanel.saveAction);
    mnFile.add(mntmSaveSession);

    JMenuItem mntmSaveasSession = new JMenuItem(SessionButtonPanel.saveAsAction);
    mnFile.add(mntmSaveasSession);

    mnFile.addSeparator();

    JMenuItem mntmNewRecord = new JMenuItem(StudentContainer.newAction);
    mnFile.add(mntmNewRecord);

    JMenuItem mntmEdit = new JMenuItem(StudentContainer.editAction);
    mnFile.add(mntmEdit);

    JMenuItem mntmSaveRecord = new JMenuItem(StudentContainer.saveAction);
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

    JMenuItem mntmCopy = new JMenuItem(StudentContainer.copyAction);
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

  /**
   * Return the current {@link DisplayPanel}.
   */
  public static DisplayPanel displayPanel() {
    return displayPanel;
  }

  /**
   * Sets the current working {@link SeasonContainer} for the GUI.
   */
  public static void setCurrentSeason(SeasonContainer season) {
    seasonContainer = Collections.singletonList(season);
  }

  /**
   * Returns the current working {@link SeasonContainer season}.
   */
  public static SeasonContainer season() {
    // there can never be more than 1
    return seasonContainer.get(0);
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
