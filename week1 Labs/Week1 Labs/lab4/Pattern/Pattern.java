import java.util.Scanner;

/**
   Class:   Pattern Class 
   Purpose: To demonstrate class methods that use loops
   Comments:
 */
import java.util.*;
public class Pattern
{

    public void displayPattern()
     { 
     /* Purpose:  Print a 'square' pattern using a character
        Receives: integer - dimension of the square, Char - character to print
        Returns:  void
     */ 
    	  //Create a new scanner object to receive input from the keyboard
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the character you want to display: ");
        char mychar = sc.next().charAt(0);
      
        System.out.println("Enter the size of the pattern you want to display ");
        int size = sc.nextInt();
     
       for(int row = 1;  row <= size ; row++ ) // Row loop fixed to size
       {
            for (int col = 1; col <= size ; col++) //Column loop fixed to size
            {
             //Print the character
              System.out.print(mychar);
            }
         //At the end of each row print a new line
         System.out.println();
       }     
     }//End of method
   
    public static void main(String args[]) {
    	
    	Pattern p=new Pattern();
    	p.displayPattern();
    }
 }
