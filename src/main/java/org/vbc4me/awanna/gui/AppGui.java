package org.vbc4me.awanna.gui;

import org.vbc4me.awanna.facets.Season;
import org.vbc4me.awanna.gui.actions.AboutAction;
import org.vbc4me.awanna.gui.actions.LookAndFeelAction;
import org.vbc4me.awanna.gui.actions.PreferenceAction;
import org.vbc4me.awanna.gui.actions.ProgramHelpAction;
import org.vbc4me.awanna.gui.forms.DashboardButtonPanel;
import org.vbc4me.awanna.gui.forms.DisplayPanel;
import org.vbc4me.awanna.gui.forms.activity.actions.CopyActivityRecordAction;
import org.vbc4me.awanna.gui.forms.activity.actions.DisplayActivatesAction;
import org.vbc4me.awanna.gui.forms.activity.actions.EditActivityAction;
import org.vbc4me.awanna.gui.forms.activity.actions.NewActivityRecordAction;
import org.vbc4me.awanna.gui.forms.activity.actions.OpenActivityRecordAction;
import org.vbc4me.awanna.gui.forms.activity.actions.SaveActivityRecordAction;
import org.vbc4me.awanna.gui.forms.season.SeasonBlankForm;
import org.vbc4me.awanna.gui.forms.season.SeasonDisplayForm;
import org.vbc4me.awanna.gui.forms.season.actions.CloseSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.CreateSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.NewSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.OpenSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.SaveAsSeasonAction;
import org.vbc4me.awanna.gui.forms.season.actions.SaveSeasonAction;
import org.vbc4me.awanna.gui.forms.session.actions.NewSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.OpenSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveAsSessionAction;
import org.vbc4me.awanna.gui.forms.session.actions.SaveSessionAction;
import org.vbc4me.awanna.gui.forms.staff.activities.CopyStaffRecordsAction;
import org.vbc4me.awanna.gui.forms.staff.activities.CreateNewStaffRecordActivity;
import org.vbc4me.awanna.gui.forms.staff.activities.DisplayAllStaffRecordAction;
import org.vbc4me.awanna.gui.forms.staff.activities.EditStaffRecordActivity;
import org.vbc4me.awanna.gui.forms.staff.activities.OpenStaffRecordActivity;
import org.vbc4me.awanna.gui.forms.staff.activities.SaveStaffRecordActivity;
import org.vbc4me.awanna.gui.forms.student.actions.CopyStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.CreateNewStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.DisplayAllStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.EditStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.OpenStudentRecordAction;
import org.vbc4me.awanna.gui.forms.student.actions.SaveStudentRecordAction;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.util.Objects;


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
  private static Season season = null;

  private static LookAndFeelInfo[] lookList = UIManager.getInstalledLookAndFeels();
  
  private static CopyActivityRecordAction copyActivityRecordAction;
  private static DisplayActivatesAction displayActivitesAction;
  private static EditActivityAction editActivityAction;
  private static NewActivityRecordAction newActivityRecordAction;
  private static OpenActivityRecordAction openActivityRecordAction;
  private static SaveActivityRecordAction saveActivityRecordAction= new SaveActivityRecordAction(mainWindow);
  private static CloseSeasonAction closeSeasonAction;
  private static CreateSeasonAction createNewSeasonAction = new CreateSeasonAction(mainWindow);
  private static NewSeasonAction newSeasonAction;
  private static OpenSeasonAction openSeasonAction;
  private static SaveAsSeasonAction saveAsSeasonAction= new SaveAsSeasonAction(mainWindow);
  private static SaveSeasonAction saveSeasonAction;
  private static NewSessionAction newSessionAction;
  private static OpenSessionAction openSessionAction;
  private static SaveAsSessionAction saveAsSessionAction;
  private static SaveSessionAction saveSessionAction;
  private static CopyStaffRecordsAction copyStaffRecordsAction;
  private static CreateNewStaffRecordActivity createNewStaffRecordActivity;
  private static DisplayAllStaffRecordAction displayAllStaffRecordAction;
  private static EditStaffRecordActivity editStaffRecordActivity;
  private static OpenStaffRecordActivity openStaffRecordActivity;
  private static SaveStaffRecordActivity saveStaffRecordActivity;
  private static CopyStudentRecordAction copyStudentRecordAction;
  private static CreateNewStudentRecordAction createNewStudentRecordAction;
  private static EditStudentRecordAction editStudentRecordAction;
  private static OpenStudentRecordAction openStudentRecordAction;
  private static SaveStudentRecordAction saveStudentRecordAction;
  private static DisplayAllStudentRecordAction displayAllStudentRecordAction;

  /**
   * Primary constructor that lays out the basic application structure using a border layout with a menu bar, button
   * panel in the north and the card panel in the center components.
   */
  public AppGui() {

    /* *******************************************************************
     *  establish the basic windowing structure.
     *********************************************************************/
    displayPanel = new DisplayPanel();
    displayPanel.updateLowerLeft(new SeasonBlankForm());
    getContentPane().add(displayPanel, BorderLayout.CENTER);

    copyActivityRecordAction = new CopyActivityRecordAction(this);
    displayActivitesAction = new DisplayActivatesAction(this);
    editActivityAction = new EditActivityAction(this);
    newActivityRecordAction = new NewActivityRecordAction(this);
    openActivityRecordAction = new OpenActivityRecordAction(this);
    saveActivityRecordAction= new SaveActivityRecordAction(this);
    closeSeasonAction = new CloseSeasonAction(this);
    createNewSeasonAction = new CreateSeasonAction(this);
    newSeasonAction = new NewSeasonAction(this);
    openSeasonAction = new OpenSeasonAction(this);
    saveAsSeasonAction= new SaveAsSeasonAction(this);
    saveSeasonAction = new SaveSeasonAction(this);
    newSessionAction = new NewSessionAction(this);
    openSessionAction = new OpenSessionAction(this);
    saveAsSessionAction = new SaveAsSessionAction(this);
    saveSessionAction = new SaveSessionAction(this);
    copyStaffRecordsAction = new CopyStaffRecordsAction(this);
    createNewStaffRecordActivity = new CreateNewStaffRecordActivity(this);
    displayAllStaffRecordAction = new DisplayAllStaffRecordAction(this);
    editStaffRecordActivity = new EditStaffRecordActivity(this);
    openStaffRecordActivity = new OpenStaffRecordActivity(this);
    saveStaffRecordActivity = new SaveStaffRecordActivity(this);
    copyStudentRecordAction = new CopyStudentRecordAction(this);
    createNewStudentRecordAction = new CreateNewStudentRecordAction(this);
    displayAllStudentRecordAction = new DisplayAllStudentRecordAction(this);
    editStudentRecordAction = new EditStudentRecordAction(this);
    openStudentRecordAction = new OpenStudentRecordAction(this);
    saveStudentRecordAction = new SaveStudentRecordAction(this);

    
    
    /*
     * ***************** FILE MENU ************************
     */


    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    JMenu mnFile = new JMenu("File");
    menuBar.add(mnFile);

    JMenuItem mntmNewSeason = new JMenuItem(newSeasonAction);
    mnFile.add(mntmNewSeason);

    JMenuItem mntmOpenSeason = new JMenuItem(openSeasonAction);
    mnFile.add(mntmOpenSeason);

    JMenuItem mntmSaveSeason = new JMenuItem(saveSeasonAction);
    mnFile.add(mntmSaveSeason);

    JMenuItem mntmSaveasSeason = new JMenuItem(saveAsSeasonAction);
    mnFile.add(mntmSaveasSeason);

    mnFile.addSeparator();

    JMenuItem mntmNewSession = new JMenuItem(createNewSeasonAction);
    mnFile.add(mntmNewSession);

    JMenuItem mntmOpenSession = new JMenuItem(openSessionAction);
    mnFile.add(mntmOpenSession);

    JMenuItem mntmSaveSession = new JMenuItem(saveSessionAction);
    mnFile.add(mntmSaveSession);

    JMenuItem mntmSaveasSession = new JMenuItem(saveAsSessionAction);
    mnFile.add(mntmSaveasSession);

    mnFile.addSeparator();

//    JMenuItem mntmNewRecord = new JMenuItem();
//    mnFile.add(mntmNewRecord);
//
//    JMenuItem mntmEdit = new JMenuItem();
//    mnFile.add(mntmEdit);
//
//    JMenuItem mntmSaveRecord = new JMenuItem();
//    mnFile.add(mntmSaveRecord);

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

    /*
     * ***************** LOAD APPLICATION ACTIONS ************************
     */


    // HELP MENU ACTIONS
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
   * Set the current {@link Season} to be displayed.
   */
  public static void currentSeason(Season sea) {
    season = Objects.requireNonNull(sea);

    SeasonDisplayForm form = SeasonDisplayForm.createForm(season);
    DashboardButtonPanel dashboard = new DashboardButtonPanel();

    displayPanel.updateUpperLeft(form);
    displayPanel.updateLowerLeft(dashboard);
  }

  /**
   * Return the current {@link Season} that is being displayed.
   */
  public static Season currentSeason() {
    return season;
  }

  public static CopyActivityRecordAction copyActivityRecordAction() {
    return copyActivityRecordAction;
  }

  public static DisplayActivatesAction displayAllActivitesAction() {
    return displayActivitesAction;
  }

  public static EditActivityAction editActivityAction() {
    return editActivityAction;
  }

  public static NewActivityRecordAction newActivityRecordAction() {
    return newActivityRecordAction;
  }

  public static OpenActivityRecordAction openActivityRecordAction() {
    return openActivityRecordAction;
  }

  public static SaveActivityRecordAction saveActivityRecordAction() {
    return saveActivityRecordAction;
  }

  public static CloseSeasonAction closeSeasonAction() {
    return closeSeasonAction;
  }

  public static CreateSeasonAction createSeasonAction() {
    return createNewSeasonAction;
  }

  public static NewSeasonAction newSeasonAction() {
    return newSeasonAction;
  }

  public static OpenSeasonAction openSeasonAction() {
    return openSeasonAction;
  }

  public static SaveAsSeasonAction saveAsSeasonAction() {
    return saveAsSeasonAction;
  }

  public static SaveSeasonAction saveSeasonAction() {
    return saveSeasonAction;
  }

  public static NewSessionAction createNewSessionAction() {
    return newSessionAction;
  }

  public static OpenSessionAction openSessionAction() {
    return openSessionAction;
  }

  public static SaveAsSessionAction saveAsSessionAction() {
    return saveAsSessionAction;
  }

  public static SaveSessionAction saveSessionAction() {
    return saveSessionAction;
  }

  public static CopyStaffRecordsAction CopyStaffRecordsAction() {
    return copyStaffRecordsAction;
  }

  public static CreateNewStaffRecordActivity createNewStaffRecordActivity() {
    return createNewStaffRecordActivity;
  }

  public static DisplayAllStaffRecordAction displayAllStaffRecordAction() {
    return displayAllStaffRecordAction;
  }

  public static EditStaffRecordActivity editStaffRecordActivity() {
    return editStaffRecordActivity;
  }

  public static OpenStaffRecordActivity openStaffRecordActivity() {
    return openStaffRecordActivity;
  }

  public static SaveStaffRecordActivity saveStaffRecordActivity() {
    return saveStaffRecordActivity;
  }

  public static CopyStudentRecordAction copyStudentRecordAction() {
    return copyStudentRecordAction;
  }

  public static CreateNewStudentRecordAction createNewStudentRecordAction() {
    return createNewStudentRecordAction;
  }

  public static DisplayAllStudentRecordAction displayAllStudentRecordAction() {
    return displayAllStudentRecordAction;
  }

  public static EditStudentRecordAction editStudentRecordAction() {
    return editStudentRecordAction;
  }

  public static OpenStudentRecordAction openStudentRecordAction() {
    return openStudentRecordAction;
  }

  public static SaveStudentRecordAction saveStudentRecordAction() {
    return saveStudentRecordAction;
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
