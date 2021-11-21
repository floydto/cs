 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingArea extends JPanel {
 
    // The size of the
    private final int size=20;
	public void paintComponent(Graphics g) { 		
	// An example of a 'nested loop' (a loop within another loop)... 		
	// This example fills a rectangular drawing area (a JPanel) 		
	// with a series of circles (in different colours)
	
	// These are the 'loop counters' 		
	 int horz, vert; 
	// The 'outer loop' 
	for ( vert = 0; vert < size; vert++ ) { 			
	 // The 'inner loop' 			
	  for( horz = 0; horz < size; horz++ ) {
	  // Create a new Color object 				
	     int icol = 65536*horz*12 + (vert*12);
	     Color c = new Color(icol); 
	     // Set the drawing colour.
	     g.setColor(c);
	     // Create a circle 
	     g.fillOval(horz*size,vert*size,size-1,size-1);
	   } 		
	 } 
   }	
} 
