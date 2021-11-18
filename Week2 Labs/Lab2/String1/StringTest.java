
/**
 * A class devised to test some of the methods associated with strings.
 * 
 * @Simon Sharpe
 * @version (a version number or a date)
 */

import java.util.*;
public class StringTest
{
    
	public static void main(String args[])
    {
		//Create a new string - 
		String str = new String("Hi there - I'm Des");
		
		//And Display it
		System.out.println(str);
		
		//Prompt the user for a string 
     	Scanner sc=new Scanner(System.in);
     	System.out.println("Please enter a string with at least 5 characters");
     	str =sc.next();	
 			
     	//Display the length of the users string
     	System.out.println("The length of your piece of string is "+str.length() );
		
     	//Display third character
     	System.out.println("Character at position 3 = "+str.charAt(2));
		
     	//Display a selected part of the users string
     	System.out.println("Characters 2 to 4 are "+str.substring(1,4));
     	
     	//Display the users string in upper case
     	System.out.println("This is uppercase "+str.toUpperCase());		
     	
     	//Display the users string in lower case
     	System.out.println("This is lowercase "+str.toLowerCase());

     	//Compare the two strings for equality with regard to their content
     	System.out.println("Please enter your first string to compare:");
     	String s1 =sc.next();
     	System.out.println("Please enter your second string to compare:");
     	String s2 =sc.next();
        
     	if (s1.equals(s2))
        {
          System.out.println("The strings are identical");
        }
        else
        {
             System.out.println("The strings are NOT identical");
        }  

    }
	

}
