/**
   Class:   Parameter Test
      Purpose: To illustrate how a parameters is copied, leaving the original unchanged 
   
 */

public class ParameterTest 
{
    public void beforeAndAfter()
     {
       // Purpose:  To create and display a parameter, before and after it is passed to a method
       int original = 10;
       System.out.println("Value before = "+ original);
       
       //Call the 'treble method' 
       treble(original);
       System.out.println("Value after = "+ original);
       System.out.println("Should be unchanged by the method call. i.e we are just passing a copy of "+original + " to the method.");
     }   
   
     public void treble(int origIn)
     { 
     /* Purpose:  To receive and amend a parameter
        Receives: integer - a copy of the original value
     */ 
        origIn = origIn * 3;
        System.out.println("Value inside treble= "+ origIn);
        
     }
     
     //Please note that I put the main and class under test in one class
     public static void main(String args[]) {
    	 ParameterTest t=new ParameterTest();
    	 t.beforeAndAfter();
     }

}
