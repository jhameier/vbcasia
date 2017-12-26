package org.vbc4me.awanna.testGenerators;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.vbc4me.awanna.gui.forms.DisplayPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonButtonPanel;
import org.vbc4me.awanna.gui.forms.season.SeasonContainer;

/**
 * Used to test panel classes in the IDE without having to run the entire
 * application.
 *
 * Created by John Hameier on July 2015.
 */
public class TestGuiPanels extends JFrame {
	private static final long serialVersionUID = 8727775107939082221L;
	
	public TestGuiPanels(final JPanel panel, String title) {
		setTitle(title);
		setLayout(new BorderLayout(5, 5));
		add(new JScrollPane(panel), BorderLayout.CENTER);
	}
	
	/**
	 * Main program driver.
	 *
	 * @param args
	 *            for command line execution (*not utilized by this program).
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(TestGuiPanels::initializeAndShowGui);
		// EventQueue.invokeLater(() -> initializeAndShowGui()); // java 8
		// lambda way
	}
	
	private static void initializeAndShowGui() {

		List<JFrame> windows = new ArrayList<>();
//		JFrame window1 = new TestGuiPanels(recBtnPanel, "Recod Button Panel");
//		windows.add(window1);
		JFrame window2 = new TestGuiPanels(new SeasonButtonPanel(), "SeasonContainer Button Panel");
		windows.add(window2);
//		JFrame window3 = new TestGuiPanels(sesBtnPanel, "Session Button Panel");
//		windows.add(window3);
//		JFrame window4 = new TestGuiPanels(studentDisplayForm, "Student Display Form");
//		windows.add(window4);
//		JFrame window5 = new TestGuiPanels(studentInputForm, "Student Input Form");
//		windows.add(window5);
//		JFrame window6 = new TestGuiPanels(seasonDisplayForm, "SeasonContainer Display Form");
//		windows.add(window6);
//		JFrame window7 = new TestGuiPanels(seasonBlankForm, "SeasonContainer Blank Form");
//		windows.add(window7);
//		JFrame window8 = new TestGuiPanels(seasonEditForm, "SeasonContainer Edit Form");
//		windows.add(window8);

        SeasonContainer seasonContainer = new SeasonContainer();
		DisplayPanel panel = new DisplayPanel();
		panel.update3PanelDisplay(seasonContainer.editForm, seasonContainer.buttonPanel,
				new JPanel(), seasonContainer.tableModel);
		JFrame window9 = new TestGuiPanels(panel, "Display Panel");
		windows.add(window9);
		
		// Display all the current windows for inspection
		Dimension offset = new Dimension(0, 0);
		for (JFrame window : windows) {
			window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			Dimension windowSize = new Dimension(800, 800);
			window.setMinimumSize(new Dimension(100, 100));
			window.setSize(windowSize);
			
			// TODO Add a way to spread panels across the display so they don't overlap
			// Set window in center of Default Monitor Window
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice device = ge.getDefaultScreenDevice();
			Rectangle screenRect = device.getDefaultConfiguration().getBounds();
			window.setLocation(screenRect.width / 2 - windowSize.width / 2 + offset.width,
					screenRect.height / 2 - windowSize.height / 2 + offset.height);
			offset.width = offset.width + 30;
			offset.height = offset.height + 30;
			window.pack();
			window.setVisible(true);
		}
		
	}
	
}
