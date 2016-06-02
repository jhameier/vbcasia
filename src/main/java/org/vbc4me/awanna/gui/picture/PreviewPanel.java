package org.vbc4me.awanna.gui.picture;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PreviewPanel extends JPanel {
	private static final long serialVersionUID = 1305893316185985570L;
	BufferedImage origImage = null;
	JFrame frame = null;
	
	public PreviewPanel() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("Right Click: Show Context menu");
					return;
				}
				
				if (origImage != null) {
					frame = new JFrame();
					frame.setLayout(new BorderLayout());
					frame.setPreferredSize(new Dimension(300, 300));
					
					JLabel picture = new JLabel(new ImageIcon(resizeImage(origImage, 300, 300)));
					frame.add(picture, BorderLayout.CENTER);
					
					// Set window in center of Default Monitor Window
					Dimension windowSize = frame.getSize();
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice device = ge.getDefaultScreenDevice();
					Rectangle screenRect = device.getDefaultConfiguration().getBounds();
					
					frame.setLocation(e.getXOnScreen() + 20, e.getYOnScreen() - 100);
					frame.pack();
					frame.setVisible(true);
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (frame != null) {
					frame.setVisible(false);
					frame.dispose();
				}
			}
		});
	}
	
	/**
	 * Associates an image with this panel.
	 */
	public void addImage(BufferedImage image) {
		origImage = image;
	}
	
	/**
	 * Returns if this panel has an image associated with it.
	 */
	public boolean hasImage() {
		return origImage != null;
	}
	
	/**
	 * Resize the buffered image to a specified size.
	 *
	 * <p>
	 * Adapted from: David Kroukamp's answer on stack overflow:
	 * http://stackoverflow.com/questions/14548808/scale-the-imageicon-
	 * automatically-to-label-size
	 *
	 * @param origImage
	 *            image to resize
	 * @param width
	 *            to resize image to
	 * @param height
	 *            to resize image to
	 * @return the image resized to width and height
	 */
	public static BufferedImage resizeImage(BufferedImage origImage, int width, int height) {
		BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = newImg.createGraphics();
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(origImage, 0, 0, width, height, null);
		g2d.dispose();
		return newImg;
	}
	
}
