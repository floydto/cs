/*
 * @(#)Circles.java 1.0 02/07/11
 *
 */
 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CirclesEx extends JFrame {
    private Container c;
    private DrawingArea p = new DrawingArea();
    public CirclesEx() {
     addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        c = getContentPane();
        c.add(p);
    }
    
    public void drawCircles() 
    {
     setSize(400, 400);
     setTitle("Circles");
     setVisible(true);
    }  
    
    public static void main(String args[]) {
    	CirclesEx c=new CirclesEx();
    	c.drawCircles();
    }
}
