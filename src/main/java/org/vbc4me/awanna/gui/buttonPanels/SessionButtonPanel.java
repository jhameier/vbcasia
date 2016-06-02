package org.vbc4me.awanna.gui.buttonPanels;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.vbc4me.awanna.gui.actions.session.CopySessionAction;
import org.vbc4me.awanna.gui.actions.session.NewSessionAction;
import org.vbc4me.awanna.gui.actions.session.OpenSessionAction;
import org.vbc4me.awanna.gui.actions.session.SaveSessionAction;

public class SessionButtonPanel extends JPanel {
    private static final long serialVersionUID = -169212683318427227L;
    private JFrame frame;
    private final Action openSessionAction = new OpenSessionAction(frame);
    private final Action createNewSessionAction = new NewSessionAction(frame);
    private final Action copySessionAction = new CopySessionAction(frame);
    private final Action saveSessionAction = new SaveSessionAction(frame);
    
    public SessionButtonPanel (JFrame frame) {
	this.frame = frame;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
    	Component horizontalStrut = Box.createHorizontalStrut(1);
    	add(horizontalStrut);

    	JButton btnNew = new JButton("New Session");
    	btnNew.setAction(createNewSessionAction);
    	add(btnNew);

    	Component horizontalStrut_1 = Box.createHorizontalStrut(5);
    	add(horizontalStrut_1);

    	JButton btnOpen = new JButton("Open");
    	btnOpen.setAction(openSessionAction);
    	add(btnOpen);

    	Component horizontalStrut_2 = Box.createHorizontalStrut(5);
    	add(horizontalStrut_2);

    	JButton btnCopy = new JButton("Copy");
    	btnCopy.setAction(copySessionAction);
    	add(btnCopy);
    	
    	Component horizontalStrut_3 = Box.createHorizontalStrut(5);
    	add(horizontalStrut_3);

    	JButton btnSave = new JButton("Save");
    	btnSave.setAction(saveSessionAction);
    	add(btnSave);
    }
}