package org.vbc4me.awanna.gui.picture;

import java.awt.*;

public class CropBox extends Rectangle {
    private static final long serialVersionUID = 4412077413040436552L;

    public CropBox() {
        this.x = 100;
        this.y = 100;
        this.width = 100;
        this.height = 100;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x, y, width, height);
    }

}
