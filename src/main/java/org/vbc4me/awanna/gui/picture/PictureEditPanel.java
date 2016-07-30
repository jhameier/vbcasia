package org.vbc4me.awanna.gui.picture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PictureEditPanel_JPanel  extends JPanel {
	private static final long serialVersionUID = -3994207055262982817L;
	
	private PictureEditDialog editPanel;
	private BufferedImage currentImage;
	private CropBox cropBox;
	private Point mouseClickOffset = new Point();

	public PictureEditPanel_JPanel(PictureEditDialog panel){
		this.editPanel = panel;
		this.currentImage = panel.imageContainer().cloneImage();
		cropBox = new CropBox();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseClickOffset.x = e.getX();
				mouseClickOffset.y = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseAdapter()  {
			public void mouseDragged(MouseEvent e) {
				moveCropBox(e.getX(), e.getY());
			}
		});
	}
	
	protected void moveCropBox(int x, int y) {
		
		// need to calculate the distance between where mouse was clicked inside of cropBox (offset)
		//     and the curent position of the cropBox
		final int CURR_X = cropBox.x;
		final int CURR_Y = cropBox.y;
		final int CURR_W = cropBox.width;
		final int CURR_H = cropBox.height;
		int CUSHION = 1;
		if((CURR_X != x) || (CURR_Y != y)) {
			repaint(CURR_X, CURR_Y, CURR_W + CUSHION, CURR_H + CUSHION);
			cropBox.x = x;
			cropBox.y= y;
			repaint(cropBox.x, cropBox.y, cropBox.width + CUSHION, cropBox.height + CUSHION);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(currentImage, 0, 0, getWidth(), getHeight(),  null);
		cropBox.paint(g);
	}
	
}
