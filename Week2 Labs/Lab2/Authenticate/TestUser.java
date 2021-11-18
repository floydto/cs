
/**
 * A Class to test the Password class
 * 
 */

import java.util.*;

public class TestUser
{
    //Create a reference to a user object
    User u1;
    
	public void setUserPassword()
	{
	   //Create a User Object
        u1 = new User();
	   //Variable to hold a temporary password whilst its being validated
	    String tempPassword = "";
	   //boolean flag to check if password is OK 
	    boolean goodPassword = false;
	   
	    Scanner sc=new Scanner (System.in);
	   //Prompt user for a password
	    System.out.println("Please enter a password (6 chars or more) ");
	    tempPassword = sc.next(); 
	  		
		//Do some validation, just one validation here - could be expanded
		while (!goodPassword)
		{
		   //If OK the set flag to good
		   if (tempPassword.length() > 5)
		   {
		      goodPassword = true;
		   }
		   //Else prompt again (with a helpful error message)
		   else
		   {
		       System.out.println("The password must be 6 charaters or more ");
		      goodPassword = false; 
		      System.out.println("Please enter a password (6 chars or more) ");
 	          tempPassword = sc.next(); 
		   }
	 	 }//End while    
	    
	    //Set User password
	    u1.setPassword(tempPassword);
	    //Prove it
	    System.out.println("Password has been set to " + u1.getPassword());
     }

     public boolean checkPassword(String passwordIn)
	{
	    //Get the user password
	    String pass = u1.getPassword();
	    
	    //Check
	    if (pass.equalsIgnoreCase(passwordIn))
	    {
	        return true;
	    }
	    else return false;
	}
     
     public static void main(String args[]) {
    	 TestUser t=new TestUser();
    	 t.setUserPassword();
    	 System.out.println(t.checkPassword("Yorker"));
    	 
     }

}
