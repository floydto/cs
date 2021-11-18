/*
 * Exercise Draw6_sol
 *
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.Graphics2D;
import java.awt.Image;

/**
 * Image of some track to drive your track.
 */
public class Background implements Drawable {
    Image bg;
    
    public Background() {
        bg = ImageHelper.getImageResource("background.png");
    }

    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
    }
}
