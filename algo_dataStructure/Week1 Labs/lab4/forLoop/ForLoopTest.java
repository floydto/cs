
/**
 * Write a description of class ForLoopTest here.
 * Modify the class to print the numbers in reverse order....
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForLoopTest
{  
    public void displayNumbers()
    {
        
        for (int i=1;i<=10;i++)
        {
            System.out.println("the value of i is " +i);
        }
    }
    
    //Test in the same class as the class being tested
    public static void main(String args[])
    {
    	//Create ForLoopTest instance and call the method
        ForLoopTest f=new ForLoopTest();
    	f.displayNumbers();
    	
    }
}
