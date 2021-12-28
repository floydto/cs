/*
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.Graphics2D;

/**
 * Objects with interface Drawable are usually drawn on some "canvas" component.<P>
 *
 * The "canvas" component holds a list of all displayed elements.
 * Elements are drawn in the same order as they were added to the "canvas".
 */
public interface Drawable {
    
    /**
     * Invoked by associated "canvas" component to draw the element onscreen.
     *
     * @param g  the Graphics2D context used for drawing.
     */
    public void draw(Graphics2D g);
}
