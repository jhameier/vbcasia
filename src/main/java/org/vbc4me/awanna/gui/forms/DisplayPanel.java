package org.vbc4me.awanna.gui.forms;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * This class handles the various spreadsheet styles and JPanels to display. This uses a
 * JSplitPane to handle the proper display setup for this panel to
 * display correctly. This is a generic shell for a table, and can be changed by
 * passing in new table models to display different types of data in different
 * ways by calling setTableDisplay(TableModel) and passing in the model of the
 * data that needs to be displayed.
 *
 * @author John Hameier 2016
 */
public final class DisplayPanel extends JPanel {
	private static final long serialVersionUID = -3284524458172373047L;
	private final JTable table = new JTable();
	private final JPanel panel = new JPanel();
	private final JSplitPane splitPane;
	private JPanel contentPanel;
	private JPanel buttonPanel;

    private DisplayContainer container;
	
	public DisplayPanel() {
		setLayout(new BorderLayout());
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		/*
		 * Upper scroll pane holds 2 panels, 1 panel with a border layout for content and the other for the button panel. 
		 * We place in this panel's BorderLayout.CENTER so that we can change what is displayed 
		 * in the upper portion of the window.
		 */
		final JScrollPane upperScrollPane = new JScrollPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		buttonPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) buttonPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(buttonPanel);

		contentPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		contentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(contentPanel);
		
		
		/*
		 * Lower scroll pane holds a table and is place inside a panel's
		 * BorderLayout.CENTER so that the table can display correctly.
		 * By changing the TableModel of the table, the table will display
		 * different types of data in a custom spreadsheet style layout.
		 */
		final JScrollPane lowerScrollPane = new JScrollPane(table);
		
		splitPane.setTopComponent(upperScrollPane);
		splitPane.setBottomComponent(lowerScrollPane);

        // holds our currently loaded panels and model
        container = new DisplayContainer(contentPanel, buttonPanel, table.getModel());
	}
	
	/**
	 * Sets the data model for this panels table display. By passing in
	 * different models, this table display can show various types of tables
	 * without creating a separate JTable for each view needed.
	 */
	public void updateTableDisplay(TableModel dataModel) {
        container = container.updateTableModel(dataModel);
		table.setModel(container.getTableModel());
		table.revalidate();
	}
	
	/**
	 * Sets the upper content display with the panel passed in, using the layout provided. The display uses
	 * a Border Layout so passing in a layout is required such as {@code BorderLayout.WEST}. 
	 * 
	 * <p>This only updates the content side of the upper display and not the button side of the display.
	 * If changing both content and button is the desired action see {@link #}
	 */
	public void updateContentDisplay(JPanel display) {
        container = container.updateContentPanel(display);
		contentPanel.add(container.getContent());
        splitPane.setDividerLocation(-1);
	}
	
	/**
	 *  Sets the upper button panel with the panel passed in. 
	 */
	public void updateButtonDisplay(JPanel btnPanel) {
        container = container.updateButtonPanel(btnPanel);
		buttonPanel.add(container.getButtonPanel());
        splitPane.setDividerLocation(-1);
	}
	
	/**
	 * Updates the upper content and button panels. The content panel requires a layout option to be set such as 
	 * {@code BorderLayout.WEST}.
	 */
	public void updateUpperDisplay(JPanel content, JPanel btnPanel) {
        container = container.updateContentAndButtonPanels(content, btnPanel);
		buttonPanel.add(container.getButtonPanel());
		contentPanel.add(container.getContent());
        splitPane.setDividerLocation(-1);
	}
	
	/**
	 * Initializes the entire panel with a dual display setup. The top panel will hold
	 * a standard JPanel (usually used to display text information) and the
	 * lower section is for holding a {@link JTable} for displaying spreadsheet
	 * style data. It should be noted that the tableModel is what is passed in and
	 * the table is updated with the then data set and layout.
	 */
	public void updateAllDisplays(DisplayContainer displayContainer) {
        container = displayContainer;
		buttonPanel.removeAll();
		buttonPanel.add(container.getButtonPanel());
		
		contentPanel.removeAll();
		contentPanel.add(container.getContent());
		
		table.removeAll();
		table.setModel(container.getTableModel());

		panel.revalidate();
		table.revalidate();
        splitPane.setDividerLocation(-1);
	}

    /**
     * Returns the container holding the currently loaded displays.
     */
	public DisplayContainer displayContainer() {
        return container;
    }
}
