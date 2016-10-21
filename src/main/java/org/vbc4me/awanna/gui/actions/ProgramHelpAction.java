package org.vbc4me.awanna.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class ProgramHelpAction extends AbstractAction {
    private static final long serialVersionUID = -1288201101615570596L;
    private JFrame frame;

    public ProgramHelpAction(JFrame frame) {
	this.frame = frame;
	putValue(NAME, "About");
	putValue(SHORT_DESCRIPTION, "Displays Information about this Application");
    }

    public void actionPerformed(ActionEvent e) {
	String message = "The basic flow of the application is as follows:\n\n"
			
			+ "A Season is a collection which contains the following information:\n"
			+ "    A Session, Students and Staff members.\n\n"
			
			+ "A Session has information such as Start & End Dates (when the Season starts and ends)\n"
			+ "    and a host of Activities.\n\n"
			
			+ "Each Activity consists of an Event Name, a Date and Time and a Cost amount.\n\n"
			
			+ "A STUDENT is consider someone who participates in the Activity. A student consists of all the \n"
			+ "    general information such as name, age, club etc including any Special Needs.\n"
			+ " There is also information on the student's parents such as Name, Address, Phone Numbers etc,\n"
			+ "    as well as a List of Authorized persons to Pick Up from  an Activity. There are also images of the Student,\n"
			+ "    Parent and Authorized Pickups for visual reference. A students record also contains each event they have\n"
			+ "    participated in which contains the information as to who dropped them off and who picked them off.\n\n"
			
			+ "Each Student has an Account associated with them so that costs of the program and payments can be tracked.\n\n"
			
			+ "A Staff memeber is considered someone who oversees an event/drop off/pickup. The program stores information\n"
			+ "    such as Name, Address, Contact Information and a Photo for reference.\n\n\n"
			
			
			+ "This is the basic of information on what things mean in the system. For detail program instuctions see the manual.";
	String title = "Hep With This App";
	int messageType = JOptionPane.INFORMATION_MESSAGE;
	JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
}