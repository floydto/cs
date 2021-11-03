/*
 * @(#)Circles.java 1.0 02/07/11
 *
 */
 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Circles extends JFrame {
    private Container c;
    private DrawingArea p = new DrawingArea();
    public Circles() {
     addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        c = getContentPane();
        c.add(p);
    }
    
    public void startCircles() 
    {
     setSize(400, 450);
     setTitle("Circles");
     setVisible(true);
    }         
}
