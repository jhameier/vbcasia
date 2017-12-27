package org.vbc4me.awanna.utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Utilities {

    /**
     * Returns a string encoded image suitable for storage as part of a flat file such as xml.  This allows storage
     * of the {@link BufferedImage} without having to keep a local copy available.  Throws an {@link IOException} if
     * a problem occurs during the encoding process.
     */
    public static String encodePhoto(BufferedImage image) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", outputStream);
            outputStream.flush();
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        }
    }

    /**
     * Returns a BufferedImage from the image string.  This us normally used to decode a string that was
     * encoded using the {@link #encodePhoto(BufferedImage)} method to store an image in an xml file.  This method
     * throws an {@link IOException} if the {@link ImageIO#read(InputStream)} encounters an issue in reading
     * then {@link ByteArrayInputStream}.
     */
    public static BufferedImage decodePhoto(String imageString) throws IOException {
        byte[] phototBytes = Base64.getDecoder().decode(imageString);
        return ImageIO.read(new ByteArrayInputStream(phototBytes));
    }
}
