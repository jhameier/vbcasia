package org.vbc4me.awanna.gui.picture;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 *
 * Created by jbolt on 1/1/2016.
 */
public class PicturePanel extends JFrame {

    private static final long serialVersionUID = 2852491616246379626L;
    private BufferedImage origImage;
    public double percentage = .20;
    private JFrame frame;
    private JLabel picture;
    int x = 10;
    int y = 10;
    int w = 100;
    int h = 100;

    public void crop(BufferedImage image) {


        Graphics2D g2d = (Graphics2D)frame.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape square = new Rectangle2D.Float(50f,50f,100f,100f);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(square);
    }

    public void displayPhoto() {

    }

    public PicturePanel(BufferedImage image) {
        this.frame = new JFrame("Crop Photo");

        this.origImage = image;

        int width = image.getWidth();
        int height = image.getHeight();

        // Make a new copy of original image
        BufferedImage newImg = new BufferedImage((int)(width * percentage),
                (int)(height * percentage),
                BufferedImage.TRANSLUCENT);
        Graphics2D imageG2d = newImg.createGraphics();
        imageG2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        imageG2d.drawImage(image, 0, 0, (int)(width * percentage), (int)(height * percentage), null);
        imageG2d.dispose();

        final JPanel picturePanel = new JPanel() {

			private static final long serialVersionUID = 2441054180872543658L;

			@Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
                g2d.drawImage(newImg, 0, 0, getWidth(), getHeight(), null);
                g2d.dispose();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(newImg.getWidth(), newImg.getHeight());
            }
        };
        JPanel btnPanel = new JPanel();

        frame.add(picturePanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);

        final JPanel pp = new JPanel() {

			private static final long serialVersionUID = 4033579044363895357L;

			@Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawRect(x,y,w,h);
            }

        };

        frame.setGlassPane(pp);


        JButton btnCrop = new JButton("Crop");
        btnPanel.add(btnCrop);
        btnCrop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean visible = frame.getGlassPane().isVisible();
                frame.getGlassPane().setVisible(!visible);
                System.out.println("Crop");
            }
        });

        // Enlarges the area of the square crop zone
        JButton btnExpand = new JButton("Expand +");
        btnPanel.add(btnExpand);
        btnExpand.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                w = w + 10;
                h = h + 10;
                frame.getGlassPane().revalidate();
                System.out.println("Expand");
            }
        });

        // Shrinks the area of the square crop zone
        JButton btnShrink = new JButton("Shrink -");
        btnPanel.add(btnShrink);
        btnShrink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w = w - 10;
                h = h - 10;
                frame.getGlassPane().revalidate();
                System.out.println("Shrink");
            }
        });


        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.revalidate();
        frame.pack();
        frame.setVisible(true);
    }

}
