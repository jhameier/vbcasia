package org.vbc4me.awanna.gui.picture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * A canvas (jpanel)  used to display an image and croping box to aid in creation of a thumbnail image.
 */
public class PictureEditPanel extends JPanel {

  private static final long serialVersionUID = -3994207055262982817L;

  private PictureEditDialog dialog;                    // the dialog that this panel belongs to
  private BufferedImage currentImage;        // the current image to create a thumbnail from
  private Dimension currentDimension;        // the current dimension of the image as seen on the screen
  private CropBox cropBox;                                // the shape used to represent the crop box
  private Point mouseClickOffset = new Point();        // the offset between where the mouse is clicked inside the crop box and the crop box origin.
  private boolean moveCrop;                            // set to true when we want to move the crop box with in this panel.


  public PictureEditPanel(PictureEditDialog dialog) {
    this.dialog = dialog;
    this.currentImage = dialog.thumbnailPanel().imageContainer().cloneImage();
    currentDimension = new Dimension(currentImage.getWidth(), currentImage.getHeight());
    cropBox = new CropBox();
    setBorder(BorderFactory.createLineBorder(Color.PINK));

    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (cropBox.contains(e.getPoint())) {
          mouseClickOffset.x = e.getX() - cropBox.x;
          mouseClickOffset.y = e.getY() - cropBox.y;
          moveCrop = true;
        } else {
          moveCrop = false;
        }
      }
    });

    addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        if (!moveCrop) {
          return;
        }

        Point position = new Point(e.getX() - mouseClickOffset.x, e.getY() - mouseClickOffset.y);
        if (position.x < 2) {
          position.x = 2;
        } else if (position.x + cropBox.width + 2 >= getWidth()) {
          position.x = getWidth() - cropBox.width - 2;
        }

        if (position.y < 2) {
          position.y = 2;
        } else if (position.y + cropBox.height + 2 >= getHeight()) {
          position.y = getHeight() - cropBox.height - 2;
        }

        moveCropBox(position.x, position.y);
      }
    });
  }

  protected void saveThumbnail() {

    ImageContainer currentContainer = new ImageContainer(currentImage, ImageContainer.createThumbnail(currentImage));
    dialog.thumbnailPanel().updateThumbnail(currentContainer);
    BufferedImage scaledImage = dialog.thumbnailPanel().imageContainer().getScaledImage(currentDimension);
    int centerOfThisPanelX = getCenterCoordinate().x;      // also the center of the image
    int centerOfThisPanelY = getCenterCoordinate().y;      // also the center of the image
    int centerOfScaledImageX = scaledImage.getWidth() / 2;  // half the distance
    int centerOfScaledImageY = scaledImage.getHeight() / 2;  // half the distance
    Point scaledImageOrigin = new Point(centerOfThisPanelX - centerOfScaledImageX,
        centerOfThisPanelY - centerOfScaledImageY);
    Point cbOffset = new Point(cropBox.x - scaledImageOrigin.x, cropBox.y - scaledImageOrigin.y);
    Dimension cbDim = new Dimension(cropBox.width, cropBox.height);

    BufferedImage thumbnail = ImageContainer.createThumbnail(scaledImage, cbOffset, cbDim);
    ImageContainer container = new ImageContainer(currentImage, thumbnail);

    dialog.thumbnailPanel().updateThumbnail(container);
    dialog.dispose();
  }

  protected void moveCropBox(int x, int y) {
    final int CURR_X = cropBox.x;
    final int CURR_Y = cropBox.y;
    final int CURR_W = cropBox.width;
    final int CURR_H = cropBox.height;
    int CUSHION = 1;

    if ((CURR_X != x) || (CURR_Y != y)) {
      repaint(CURR_X, CURR_Y, CURR_W + CUSHION, CURR_H + CUSHION);
      cropBox.x = x;
      cropBox.y = y;
      repaint(cropBox.x, cropBox.y, cropBox.width + CUSHION, cropBox.height + CUSHION);
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    currentDimension = scaleImageDimensions();
    Point centerDimension = getCenterCoordinate();
    int xPos = centerDimension.x - (currentDimension.width / 2);
    int yPos = centerDimension.y - (currentDimension.height / 2);
    g.drawImage(currentImage, xPos, yPos, currentDimension.width, currentDimension.height, null);
    cropBox.paint(g);
  }

  /**
   * Returns the center coordinate of this container
   */
  private Point getCenterCoordinate() {
    return new Point(getWidth() / 2, getHeight() / 2);
  }

  /**
   * Scales the {@code currentImage} based on the dimensions of this container maintaining the aspect ratio of the
   * {@code originalImage}.
   */
  private Dimension scaleImageDimensions() {
    Dimension targetSize = this.getSize();
    Dimension currImageSize = new Dimension(currentImage.getWidth(), currentImage.getHeight());
    Dimension scaledSize = new Dimension();

    // First set the scaled width equal to the current containers width and scale the height accordingly
    scaledSize.width = targetSize.width;
    scaledSize.height = (scaledSize.width * currImageSize.height) / currImageSize.width;

    // Check to see if the height exceeds the current window height and if so re-scale based off of height instead
    if (scaledSize.height > targetSize.height) {
      scaledSize.height = targetSize.height;
      scaledSize.width = (scaledSize.height * currImageSize.width) / currImageSize.height;
    }
    return scaledSize;
  }

  /**
   * Rotates the image displayed by the degree amount.
   */
  public void rotateImage(int degree) {
    BufferedImage rotated = dialog.thumbnailPanel().imageContainer().rotate(currentImage, degree);
    currentImage = rotated;
    repaint();
  }

  /**
   * Moves the {@link CropBox cropBox} 'Y' component by the amount passed in.
   */
  public void moveVertical(int shift) {
    if (cropBox.y + shift > 2 && cropBox.y + cropBox.height + shift < getHeight() - 2) {
      cropBox.y = cropBox.y + shift;
      repaint();
    }
  }

  /**
   * Moves the {@link CropBox cropBox} 'X' component by the amount passed in.
   */
  public void moveHorizontal(int shift) {
    if (cropBox.x + shift > 2 && cropBox.x + cropBox.width + shift < getWidth() - 2) {
      cropBox.x = cropBox.x + shift;
      repaint();
    }

  }

  /**
   * Changes the size of the {@link CropBox cropBox} by the amount passed in.
   */
  public void expandCropBox(int amount) {
    if (cropBox.width + cropBox.x + 2 < getWidth() && cropBox.height + cropBox.y + 2 < getHeight()) {
      cropBox.width = cropBox.width + amount;
      cropBox.height = cropBox.height + amount;
      repaint();
    }
  }

  /**
   * Changes the size of the {@link CropBox cropBox} by the amount passed in.
   */
  public void reduceCropBox(int amount) {
    if (cropBox.width > 20 && cropBox.height > 20) {
      cropBox.width = cropBox.width - amount;
      cropBox.height = cropBox.height - amount;
      repaint();
    }
  }
}
