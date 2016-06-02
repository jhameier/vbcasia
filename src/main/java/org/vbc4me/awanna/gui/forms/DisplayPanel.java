package org.vbc4me.awanna.gui.forms;

import java.awt.BorderLayout;
import java.util.Optional;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.vbc4me.awanna.gui.PrimaryGuiPanel;


/**
 * This class handles the various spreadsheet styles to display. This uses a Border layout manager
 * to handle the proper display setup for this panel to display correctly. This is a generic shell for a table,
 * and can be changed by passing in new table models to display different types of data in
 * different ways by calling setTableDisplay(TableModel) and passing in the model of the data
 * that needs to be displayed.
 *
 * @author John Hameier July 2015
 */
public class DisplayPanel extends JPanel {
  private static final long serialVersionUID = -5551648075668029716L;
  private JTable table;
  private JPanel panel;
  JScrollPane scrollPane = new JScrollPane(table);

  public DisplayPanel() {
    setLayout(new BorderLayout());
  }

  /**
   *  Sets the table model for this panels table display. By passing in different models, this table display can show
   *  various types of tables without creating a separate JTable for each view needed.
   *
   *  <p>This method will throw an {@link InstantiationError} if the table that this model is being associated with
   *  was not initialized prior to calling this method.
   *  
   * @param model to display
   */
  public void addModel(TableModel model) {
    if(table != null) {
      table.setModel(model);
      return;
    }
    throw new InstantiationError("Table must be initialized before a model can be added to the table");
  }
  
  /**
   * Gets the table associated with this display panel This may or may not return a table but will return
   * an Optional Empty if the table was not previously initialize properly.
   * 
   * @return the table associated with this panel
   */
  public Optional<JTable> getTable() {
    if(table != null)
      return Optional.of(table);
    else
      return Optional.empty();
  }
  
  public void setDisplayPanel(JPanel panel) {
    initializePanel();
    this.table = null;
    this.panel = panel;
    add(panel, BorderLayout.CENTER);
    PrimaryGuiPanel.mainWindow.pack();
  }

  private void initializePanel() {
    if(scrollPane != null) {
      getLayout().removeLayoutComponent(scrollPane);
    }

    if(panel != null) {
      getLayout().removeLayoutComponent(panel);
    }
  }

  /**
   * Initializes this panel with a dual display setup. The top panel will
   * hold a standard JPanel (usually used to display text information) and
   * the lower section is for holding a {@link JTable} for displaying spreadsheet
   * style data. It should be noted that the tableModel can be added to the table
   * either before passing it into this method or can be added using the method call
   * addModel(tableModel) within this class.
   *
   * @param textPanel to display in the upper section of this panel
   * @param jtable to display in the lower section of this panel
   */
  public void setSplitPanel(JPanel textPanel, JTable jtable) {
    initializePanel();
    this.panel = textPanel;
    this.table = jtable;
    add(panel, BorderLayout.NORTH);
    add(table, BorderLayout.CENTER);
  }

}
