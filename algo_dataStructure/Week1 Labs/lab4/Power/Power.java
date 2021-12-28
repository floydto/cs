
/**
 * To demonstrate the use of Math class methods
 * and parameter passing
  */
public class Power
{
	
	public void displayPowers(int lower , int upper, int increment)
	{
	
	  System.out.println("Squares and roots of numbers from "+lower+" to "+ upper + " with and increment of " + increment);
	  for (int count = lower; count <= upper; count = count + increment)
	  {
	    
	    System.out.println(count + "\t  " + Math.pow(count,2) + "\t\t  " + Math.sqrt(count)); 
      }
	}
			
}
