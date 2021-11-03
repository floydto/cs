/**
 * A very simple program to place some text in a graphics window
 * 
 * @version 1.0
 */
import java.awt.*;
import javax.swing.*;
public class TestDice extends JFrame
{
    private Container c;
    private DiceRoll gr = new DiceRoll();
    public void rollDice() {
        // Default constructor
        c = getContentPane();
        c.add(gr);
        // Set the size of the window
        setSize(400,400);
        setVisible(true);
    }
    
    public static void main (String args[])
    {
    	TestDice t=new TestDice();
    	t.rollDice();
    }
}
