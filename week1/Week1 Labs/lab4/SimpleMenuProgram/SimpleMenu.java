
/**
 * Write a description of class SimpleMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class SimpleMenu
{
  
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void displayMenu()
    {
       int ichoice;
       do {
           Scanner sc=new Scanner (System.in);
            System.out.println("Choice 1 - Enrol a new student");
            System.out.println("Choice 2 - Enter a student's mark");
            System.out.println("Choice 3 - Print out results");
            System.out.println("Choice 4 -- Calculate a student's final grade");
            System.out.println("Choice 5 - quit the program & save the data");
            ichoice = sc.nextInt();
             switch(ichoice) 
             {
               case 1:
                  // put code for enrolling a new student here
                  System.out.println("Enrolling a new student");
                  // etc etc
                  break;
               case 2:
                  // put code for entering a students mark here
                  System.out.println("Enter the students mark");
                  // etc etc
                 break;
               case 3:
                   // put code for printing out results here
                   System.out.println("Printing out results");
                   // Etc etc
                   break;
               case 4:
                  // put code for calculating final grade here
                  System.out.println("printing final grade");
                  // etc etc
                  break;
              default:
                  if(ichoice != 5) System.out.println("Unknown option");
                 // no need for a break
           } // End of the switch statement
       } while (ichoice != 5);//end of loop

    }//end of method
    
    public static void main(String args[]) {
    	SimpleMenu sm=new SimpleMenu();
    	sm.displayMenu();
    }


}
