package org.vbc4me.awanna.gui.picture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThumbnailPanel extends JPanel {
	private static final long serialVersionUID = 1305893316185985570L;
	private ImageContainer imageContainer;
	private final JLabel label;
	
	public ThumbnailPanel() {
		setLayout(new BorderLayout());
		imageContainer = ImageContainer.intializeEmptyContainer();
		label = new JLabel();
		label.setIcon(new ImageIcon(imageContainer.cloneThumbnail()));
		Color bColor = getBackground().darker();
		label.setBorder(BorderFactory.createLineBorder(bColor));
		add(label, BorderLayout.CENTER);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
					e.consume();
					editThumbnail();
					return;
				}
			}	
		});
		
	}
	
	private void editThumbnail() {
		new PictureEditDialog(this, imageContainer);
	}
	
}
