
/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author	Michael Kolling, David J. Barnes, 
 * @version 1.2  (14 Sept 2003)
 * 
 */
public class Picture
{
	//Defines what the picture is made of
	private Square wall;
	private Square window;
	private Triangle roof;
	private	Circle sun;

    //This 'method' is automatically run when the program starts
    public static void main (String[] args)
    {
       //Creates a new picture object and calls it P1
        Picture P1 = new Picture();
    }
    
    //This defines what the picture will be like when its created.
    public Picture()
    {
		wall = new Square();
		wall.moveVertical(80);
		wall.changeSize(100);
		wall.makeVisible();
		
		window = new Square();
		window.changeColor("black");
		window.moveHorizontal(20);
		window.moveVertical(100);
		window.makeVisible();

		roof = new Triangle();	
		roof.changeSize(50, 140);
		roof.moveHorizontal(60);
		roof.moveVertical(70);
		roof.makeVisible();

		sun = new Circle();
		sun.changeColor("yellow");
		sun.moveHorizontal(180);
		sun.moveVertical(-10);
		sun.changeSize(60);
		sun.makeVisible();
	}

	

}
