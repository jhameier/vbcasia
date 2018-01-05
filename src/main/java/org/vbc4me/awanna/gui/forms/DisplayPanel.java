package org.vbc4me.awanna.gui.forms;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

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
  private final JPanel contentPanel = new JPanel();
  private final JSplitPane splitPane;
  private JPanel lowerLeftPanel;
  private JPanel upperLeftPanel;
  private JPanel upperRightPanel;
  private JPanel lowerRightPanel;

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
    final JScrollPane upperScrollPane = new JScrollPane(contentPanel);
    contentPanel.setLayout(new MigLayout("", "[][]", "[]"));

    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new MigLayout("", "[]", "[][]"));
    contentPanel.add(leftPanel);

    upperLeftPanel = new JPanel();
    lowerLeftPanel = new JPanel();

    leftPanel.add(upperLeftPanel, "cell 0 0, align left");
    leftPanel.add(lowerLeftPanel, "cell 0 1, align left");

    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new MigLayout("", "[]", "[][]"));
    contentPanel.add(rightPanel);

    upperRightPanel = new JPanel();
    lowerRightPanel = new JPanel();

    rightPanel.add(upperRightPanel, "cell 0 0, align left");
    rightPanel.add(lowerRightPanel, "cell 0 1, align left");


    /*
     * Lower scroll pane holds a table and is place inside a panel's
     * BorderLayout.CENTER so that the table can display correctly.
     * By changing the TableModel of the table, the table will display
     * different types of data in a custom spreadsheet style layout.
     */
    final JScrollPane lowerScrollPane = new JScrollPane(table);

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
    upperLeftPanel.removeAll();
    upperLeftPanel.add(panel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Sets the left lower panel.
   */
  public void updateLowerLeft(JPanel panel) {
    lowerLeftPanel.removeAll();
    lowerLeftPanel.add(panel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Sets the right upper panel.
   */
  public void updateUpperRight(JPanel panel) {
    upperRightPanel.removeAll();
    upperRightPanel.add(panel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Sets the right lower panel.
   */
  public void updateLowerRight(JPanel panel) {
    lowerRightPanel.removeAll();
    lowerRightPanel.add(panel);
    splitPane.setDividerLocation(-1);
  }


  /**
   * Updates the left side upper and lower panels.
   */
  public void updateLeftDisplay(JPanel upperPanel, JPanel lowerPanel) {
    upperLeftPanel.removeAll();
    upperLeftPanel.add(upperPanel);
    lowerLeftPanel.removeAll();
    lowerLeftPanel.add(lowerPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Updates the right side upper and lower panels.
   */
  public void updateRightDisplay(JPanel upperPanel, JPanel lowerPanel) {
    upperRightPanel.removeAll();
    upperRightPanel.add(upperPanel);
    lowerRightPanel.removeAll();
    lowerRightPanel.add(lowerPanel);
    splitPane.setDividerLocation(-1);
  }

  /**
   * Initialize the display with placement in the upper left, lower left and lower right
   */
  public void update3PanelDisplay(JPanel upperLeft, JPanel lowerLeft, JPanel lowerRight) {
    upperLeftPanel.removeAll();
    upperLeftPanel.add(upperLeft);

    lowerLeftPanel.removeAll();
    lowerLeftPanel.add(lowerLeft);

    lowerRightPanel.removeAll();
    lowerRightPanel.add(lowerRight);

    contentPanel.revalidate();
    splitPane.setDividerLocation(-1);
  }

  /**
   * Initialize the display with placement in the upper left, lower left, upper right and lower right.
   */
  public void update4PanelDisplay(JPanel upperLeft, JPanel lowerLeft, JPanel upperRight, JPanel lowerRight) {
    upperLeftPanel.removeAll();
    upperLeftPanel.add(upperLeft);

    lowerLeftPanel.removeAll();
    lowerLeftPanel.add(lowerLeft);

    upperRightPanel.removeAll();
    upperRightPanel.add(upperRight);

    lowerRightPanel.removeAll();
    lowerRightPanel.add(lowerRight);

    contentPanel.revalidate();
    splitPane.setDividerLocation(-1);
  }

}
