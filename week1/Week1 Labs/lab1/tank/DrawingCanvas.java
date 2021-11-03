/*
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List; 
import java.util.ListIterator;
import javax.swing.JComponent;

/**
 * DrawingCanvas is a simple Swing component where {@link Drawable} objects are displayed.<P>
 * 
 * It holds a list of all currently displayed elements.
 */
public class DrawingCanvas extends JComponent {

    // instance variables - unique for each instance
    private List elements;  // list of displayed elements
    private Color bgColor;  // background color
    private Object lock;

    /**
     * Creates a component for displaying {@link Drawable} elements.
     */
    public DrawingCanvas(Color bgColor, int width, int height) {
        lock = this;
        this.bgColor = bgColor;
        elements = new ArrayList();
        setPreferredSize(new Dimension(width, height));
    }
    
    /**
     * Adds Drawable element to the list of displayed elements.
     * Element is added only once.
     * 
     * @param el  Drawable element.
     */
    public synchronized void addElement(Drawable el) {
        if(!elements.contains(el)) {
            elements.add(el);
        }
    }
    
    /**
     * Returns Drawable element at the specified index.
     * 
     * @param index  index of element to return; 0 means first, (count-1) means last.
     * @return  requested element.
     * @throws java.lang.IndexOutOfBoundsException  if the index is out of range.
     */
    public synchronized Drawable getElement(int index) {
        return (Drawable)elements.get(index);
    }
    
    /**
     * Returns the number of displayed Drawable elements.
     * 
     * @return  element count.
     */
    public synchronized int getElementCount() {
        return elements.size();
    }
    
    /**
     * Removes Drawable element from the list of displayed elements. 
     * 
     * @param el  Drawable element.
     * @return  true if removed.
     */
    public synchronized boolean removeElement(Drawable el) {
        return elements.remove(el);
    }

    /**
     * Removes Drawable element from the list of displayed elements. 
     * 
     * @param index  index of element to remove; 0 means first, (count-1) means last.
     * @return  removed element, null if nothing removed.
     * @throws java.lang.IndexOutOfBoundsException  if the index is out of range.
     */
    public synchronized Drawable removeElement(int index) {
        return (Drawable)elements.remove(index);
    }
    
    /**
     * Checks whether given element is currently displayed. 
     * 
     * @param el  Drawable element.
     * @return  true if displayed, false otherwise.
     */
    public synchronized boolean containsElement(Drawable el) {
        return elements.contains(el);
    }
    
    /**
     * Invoked to request redrawing of DrawingCanvas.
     */
    public void redraw() {
        repaint();
    }
    
    /**
     * Paints background and all elements in the list.
     * This method is called by system when this component
     * should be painted (or repainted) onscreen.
     *
     * @param g  instance of Graphics2D context to paint this component.
     */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g; // JDK 1.1 legacy issue
        paintBg(g2);
        paintElements(g2);
    }

    /**
     * Paints background.
     */
    private void paintBg(Graphics2D g2) {
        g2.setColor(bgColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
        
    /**
     * Paints all elements.
     */
    private void paintElements(Graphics2D g2) {
        synchronized(lock) { //BlueJ is not thread-safe!
            ListIterator it = elements.listIterator();
            while(it.hasNext()) {
                Drawable dr = (Drawable)it.next();
                dr.draw(g2);
            }
        }
    }
}
