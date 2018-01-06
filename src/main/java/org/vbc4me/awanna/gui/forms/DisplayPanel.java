package org.vbc4me.awanna.gui.forms;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.miginfocom.swing.MigLayout;



/**
 * This class handles the various spreadsheet styles table models and JPanels to display.  This uses a JSplitPane to
 * handle the proper display layout.  This is a generic shell for tables, and can be changed by passing
 * in new table models by calling setTableDisplay(TableModel).
 *
 * @author John Hameier 2016
 */
public final class DisplayPanel extends JPanel {

  private static final long serialVersionUID = -3284524458172373047L;
  private final JTable table = new JTable();
  private final JSplitPane splitPane;
  private final JPanel upperLeftContainer;
  private final JPanel lowerLeftContainer;
  private final JPanel upperRightContainer;
  private final JPanel lowerRightContainer;
  private JPanel upperLeftPanel = null;
  private JPanel lowerLeftPanel = null;
  private JPanel upperRightPanel = null;
  private JPanel lowerRightPanel = null;

  public DisplayPanel() {
    setLayout(new BorderLayout());
    splitPane = new JSplitPane();
    splitPane.setResizeWeight(0.6);
    splitPane.setOneTouchExpandable(true);
    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
    add(splitPane, BorderLayout.CENTER);

    /*
     * Upper scroll pane holds 4 panels for various types of display panels such as button panels and/or edit panels
     * Lower scroll pane hold 1 panel for a table
     *
     *  |=== Upper Scroll Pane ========================|
     *  |                                              |
     *  | |---- Content Pane ------------------------| |
     *  | |                                          | |
     *  | | |--- Left Panel ---|--- Right Panel ---| | |
     *  | | |                  |                   | | |
     *  | | | |--------------| | |---------------| | | |
     *  | | | |  upper left  | | |  upper right  | | | |
     *  | | | |--------------| | |---------------| | | |
     *  | | |                  |                   | | |
     *  | | | |--------------| | |---------------| | | |
     *  | | | | lower left   | | |  lower right  | | | |
     *  | | | |--------------| | |---------------| | | |
     *  | | |                  |                   | | |
     *  | | |------------------|-------------------| | |
     *  | |                                          | |
     *  | |------------------------------------------| |
     *  |                                              |
     *  |==============================================|
     *  |                                              |
     *  |=== Lower Scroll Pane ========================|
     *  |                                              |
     *  | |---- JTable ------------------------------| |
     *  | |                                          | |
     *  | |             Table Model                  | |
     *  | |                                          | |
     *  | |------------------------------------------| |
     *  |                                              |
     *  |==============================================|
     */
    JPanel contentPanel = new JPanel();
    final JScrollPane upperScrollPane = new JScrollPane(contentPanel);
    upperScrollPane.getVerticalScrollBar().setUnitIncrement(10);
    contentPanel.setLayout(new MigLayout("", "[][]", "[]"));

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new MigLayout("", "[]", "[][]"));
    contentPanel.add(leftPanel);

    upperLeftContainer = new JPanel();
    lowerLeftContainer = new JPanel();

    leftPanel.add(upperLeftContainer, "cell 0 0, align left");
    leftPanel.add(lowerLeftContainer, "cell 0 1, align left");

    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new MigLayout("", "[]", "[][]"));
    contentPanel.add(rightPanel);

    upperRightContainer = new JPanel();
    lowerRightContainer = new JPanel();

    rightPanel.add(upperRightContainer, "cell 0 0, align left");
    rightPanel.add(lowerRightContainer, "cell 0 1, align left");


    /*
     * Lower scroll pane holds a table and is place inside a panel's
     * BorderLayout.CENTER so that the table can display correctly.
     * By changing the TableModel of the table, the table will display
     * different types of data in a custom spreadsheet style layout.
     */
    final JScrollPane lowerScrollPane = new JScrollPane(table);
    lowerScrollPane.getVerticalScrollBar().setUnitIncrement(10);

    splitPane.setTopComponent(upperScrollPane);
    splitPane.setBottomComponent(lowerScrollPane);

  }

  /**
   * Sets the data model for this panels table display. By passing in different models, this table display can show
   * various types of tables without creating a separate JTable for each view needed.
   */
  public void updateTableDisplay(TableModel dataModel) {
    table.setModel(dataModel);
    table.revalidate();
  }

  /**
   * Sets the left upper panel.
   */
  public void updateUpperLeft(JPanel panel) {
    upperLeftContainer.removeAll();
    upperLeftPanel = panel;
    upperLeftContainer.add(upperLeftPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Sets the left lower panel.
   */
  public void updateLowerLeft(JPanel panel) {
    lowerLeftContainer.removeAll();
    lowerLeftPanel = panel;
    lowerLeftContainer.add(lowerLeftPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Sets the right upper panel.
   */
  public void updateUpperRight(JPanel panel) {
    upperRightContainer.removeAll();
    upperRightPanel = panel;
    upperRightContainer.add(upperRightPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Sets the right lower panel.
   */
  public void updateLowerRight(JPanel panel) {
    lowerRightContainer.removeAll();
    lowerRightPanel = panel;
    lowerRightContainer.add(lowerRightPanel);
    splitPane.setDividerLocation(-1);
  }


  /**
   * Updates the left side upper and lower panels.
   */
  public void updateLeftDisplay(JPanel upperPanel, JPanel lowerPanel) {
    upperLeftContainer.removeAll();
    lowerLeftContainer.removeAll();
    updateUpperLeft(upperPanel);
    updateLowerLeft(lowerPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Updates the right side upper and lower panels.
   */
  public void updateRightDisplay(JPanel upperPanel, JPanel lowerPanel) {
    upperRightContainer.removeAll();
    lowerRightContainer.removeAll();
    updateUpperRight(upperPanel);
    updateLowerRight(lowerPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Initialize the display with placement in the upper left, lower left and lower right
   */
  public void update3PanelDisplay(JPanel upperLeft, JPanel lowerLeft, JPanel lowerRight) {
    clearAllDisplays();
    updateUpperLeft(upperLeft);
    updateLowerLeft(lowerLeft);
    updateLowerRight(lowerRight);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Initialize the display with placement in the upper left, lower left, upper right and lower right.
   */
  public void update4PanelDisplay(JPanel upperLeft, JPanel lowerLeft, JPanel upperRight, JPanel lowerRight) {
    clearAllDisplays();
    updateUpperLeft(upperLeft);
    updateLowerLeft(lowerLeft);
    updateUpperRight(upperRight);
    updateLowerRight(lowerRight);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Clear all the panels including the table model.
   */
  public void clearAllDisplays() {
    upperLeftContainer.removeAll();
    lowerLeftContainer.removeAll();
    upperRightContainer.removeAll();
    lowerRightContainer.removeAll();
    table.setModel(new DefaultTableModel());
  }

  /**
   * Return the current {@link JPanel} attached to this container.
   */
  public JPanel upperLeftPanel() {
    return upperLeftPanel;
  }

  /**
   * Return the current {@link JPanel} attached to this container.
   */
  public JPanel lowerLeftPanel() {
    return lowerLeftPanel;
  }

  /**
   * Return the current {@link JPanel} attached to this container.
   */
  public JPanel upperRightPanel() {
    return upperRightPanel;
  }

  /**
   * Return the current {@link JPanel} attached to this container.
   */
  public JPanel lowerRightPanel() {
    return lowerRightPanel;
  }
}
