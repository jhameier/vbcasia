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
  private final String panelName;
  private final JLabel label;
  private Photo originalContainer;
  private Photo imageContainer;

  public ThumbnailPanel(String panelName) {
    this.panelName = panelName;
    setLayout(new BorderLayout());

    originalContainer = Photo.intializeEmptyContainer();
    imageContainer = originalContainer;

    Color bColor = getBackground().darker();
    label = new JLabel();
    label.setIcon(new ImageIcon(imageContainer.cloneThumbnail()));
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
    new PictureEditDialog(this);
  }

  /**
   * Updated the displayed thumbnail and attaches an {@link Photo image container} containing the original
   * image with a thumbnail for additional processing.
   */
  public void updateThumbnail(Photo container) {
    originalContainer = imageContainer;
    imageContainer = container;
    label.setIcon(new ImageIcon(imageContainer.cloneThumbnail()));
    revalidate();
  }

  public void resetThumbnail() {
    imageContainer = originalContainer;
    label.setIcon(new ImageIcon(imageContainer.cloneThumbnail()));
    revalidate();
  }

  public String panelName() {
    return panelName;
  }

  public Photo imageContainer() {
    return imageContainer;
  }
}
