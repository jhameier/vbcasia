package org.vbc4me.awanna.gui.forms.season;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SeasonTableModel extends AbstractTableModel {

  public static final int SELECT = 0;
  public static final int NUMBER = 1;
  public static final int NAME = 2;
  public static final int CREATED = 3;
  public static final int CLOSED = 4;
  public static final int MODIFIED = 5;
  private static final long serialVersionUID = 8530443718844287586L;
  private String[] columnNames = {"Select", "Number", "Name", "Date Created", "Date Closed", "Date Last Modified"};
  private List<File> data = new ArrayList<>();

  @Override
  public int getRowCount() {
    return data.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public Object getValueAt(int row, int column) {
    return data.get(row).getName();
  }

  public void addData(File file) {
    data.add(file);
  }

  /**
   * Returns the name of this column
   *
   * @param column number to get name of
   * @return name of the column indexed
   */
  public String getColumnName(int column) {
    return columnNames[column];
  }

  /**
   * Returns if the cell is able to be edited by the user
   *
   * @param row number of the cell
   * @param column number of the cell
   * @return if this cell is able to be edited
   */
  public boolean isCellEditable(int row, int column) {
    return column == 0;
  }

  /**
   * Returns the type of class that is associated with the data in a column
   */
  public Class<?> getColumnClass(int column) {
    switch (column) {
      case 0:
        return Boolean.class;
      case 1:
        return Integer.class;
      case 2:
        return String.class;
      case 3:
      case 4:
      case 5:
        return LocalDate.class;
      default:
        return Object.class;
    }
  }
}
