package org.vbc4me.awanna.gui.forms;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * This class handles the various spreadsheet styles to display. This uses a
 * Border layout manager to handle the proper display setup for this panel to
 * display correctly. This is a generic shell for a table, and can be changed by
 * passing in new table models to display different types of data in different
 * ways by calling setTableDisplay(TableModel) and passing in the model of the
 * data that needs to be displayed.
 *
 * @author John Hameier July 2015: updated June 2016
 */
public final class DisplayPanel extends JPanel {
	private static final long serialVersionUID = -3284524458172373047L;
	private final static JTable table = new JTable();
	private final static JPanel panel = new JPanel();
	
	public DisplayPanel() {
		setLayout(new BorderLayout());
		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(5);
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		/*
		 * Upper scroll pane holds a panel with a border layout. We place in this
		 * panel's BorderLayout.CENTER so that we can change what is displayed 
		 * in the upper portion of the window.
		 */
		final JScrollPane upperScrollPane = new JScrollPane(panel);
		
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
	 * Sets the data model for this panels table display. By passing in
	 * different models, this table display can show various types of tables
	 * without creating a separate JTable for each view needed.
	 */
	public static void updateLowerDisplay(TableModel dataModel) {
		table.setModel(dataModel);
		table.revalidate();
	}
	
	/**
	 * Sets the upper display with the panel passed in. 
	 */
	public static void updateUpperDisplay(JPanel display) {
		panel.removeAll();
		panel.add(display, BorderLayout.CENTER);
		panel.revalidate();
	}
	
	/**
	 * Initializes the entire panel with a dual display setup. The top panel will hold
	 * a standard JPanel (usually used to display text information) and the
	 * lower section is for holding a {@link JTable} for displaying spreadsheet
	 * style data. It should be noted that the tableModel is what is passed in and
	 * the table is updated with the then data set and layout.
	 */
	public static void updateBothDisplays(JPanel textPanel, TableModel dataModel) {
		panel.add(textPanel, BorderLayout.CENTER);
		table.setModel(dataModel);
	}
	
}
