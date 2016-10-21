package org.vbc4me.awanna.gui.forms;

import javax.swing.JPanel;
import javax.swing.table.TableModel;

public class DisplayContainer {
	
	private final JPanel content;
	private final JPanel buttonPanel;
	private final TableModel tableModel;
	
	public DisplayContainer(JPanel panel, JPanel btnPanel, TableModel model) {
		content = panel;
		buttonPanel = btnPanel;
		tableModel = model;
	}
	
	/**
	 * @return the content
	 */
	public JPanel getContent() {
		return content;
	}

	/**
	 * @return the buttonPanel
	 */
	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	/**
	 * @return the tableModel
	 */
	public TableModel getTableModel() {
		return tableModel;
	}

	
}
