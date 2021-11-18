
/**
 * A class to use and test the oblong class
 * 
 * @Simon Sharpe
 * @June 2002
 */
import java.util.*;

public class OblongTester
{
	
	// Create an Object and test the methods
	public static void main(String args[])
	{
	
       //We will be creating a new oblong - Give it a name so we can reference it
       //i.e. like we declared a primitive data variable
		Oblong myOblong1;
		
		//Now Create a new oblong with length = 5 and height = 3
		//In BlueJ we normally do this by right-mouse click and create new object
		myOblong1 = new Oblong(5,3);
			
		//Using theTest the various methods
		System.out.println("Oblong length = "+ myOblong1.getLength());
		System.out.println("Oblong height = "+ myOblong1.getHeight());
		System.out.println("Oblong area is "+ myOblong1.calculateArea());
		System.out.println("Oblong perimeter is "+ myOblong1.calculatePerimeter());	 	
	
	    
		//Test interactively
		// Two variables to hold the length and height of the oblong
		double obLength, obHeight;
		
		//We will be creating a new oblong - we need to give it a name so we can reference it
		Oblong myOblong;
		
		Scanner sc=new Scanner (System.in);
		//Get the values from the user
		System.out.print("Enter oblong length : ");
		obLength = sc.nextDouble();
		System.out.print("Enter oblong height : ");
		obHeight = sc.nextDouble();
		
		//Create a new Oblong object, passing the dimensions as parameters
		myOblong = new Oblong(obLength,obHeight);
		
		//Try out the various methods
		System.out.println("Oblong area is "+ myOblong.calculateArea());
		System.out.println("Oblong perimeter is "+ myOblong.calculatePerimeter());
		
	 	
	}
}
