package org.vbc4me.awanna.gui.forms.student;

import org.vbc4me.awanna.facets.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    public static final int CHECK_BOX = 0;
    public static final int LAST_NAME = 1;
    public static final int FIRST_NAME = 2;
    public static final int CLUB_NAME = 3;
    public static final int ACCOUNT_BALANCE = 4;
    private static final long serialVersionUID = 4272448093197382220L;
    protected String[] columnNames;
    protected List<Student> data;

    public StudentTableModel() {
        this.columnNames = new String[]{};
        data = new ArrayList<>();
    }

    public void addData(Student student) {
        data.add(student);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
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
     * @param row    number of the cell
     * @param column number of the cell
     * @return if this cell is able to be edited
     */
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Returns the type of class that is associated with the data in a column
     */
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return Boolean.class;
            case 1:
            case 2:
            case 3:
                return String.class;
            case 4:
                return Double.class;
            default:
                return Object.class;
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        return studentData(row)[column];
    }

    private String[] studentData(int index) {
        Student s = data.get(index);
        return new String[]{"false", s.lastName(), s.firstName(), s.currentClub(),
                String.valueOf(s.account().balance())};
    }
}
