/**
   Class:   Grader
   Purpose: To iteratively grade a module againt the user input
 */
import java.util.*;

public class Grader
{
    Scanner sc=new Scanner(System.in);
      
    //Method to prompt for and validate a mark in the range 0 to 100
    public int getValidMark()
    {
      //To hold the mark to be entered
       int mark;
       
       System.out.println ("Enter a mark in range 0 to 100"); 
       mark = sc.nextInt();
        while ( mark < 0 || mark  > 100 ) {
            System.out.println("Invalid mark !");
            //As the mark was invalid we would have to prompt for another
            System.out.println ("Enter a mark in range 0 to 100"); 
            mark = sc.nextInt();
        }  
        //mark is now ok and can be returned from the method
        return mark;
    }
    
    //To use the above above method to grade a valid mark
    public String gradeMark(int vMarkIn)
     { 
     /* Purpose:  Calculates A Grade for a given mark
        Receives: integer - Mark
        Returns:  String with appropriate grade
        PreCond: Mark should be less than or equal to 100
      */ 
     
      //Then apply appropriate grade
      if (vMarkIn > 69) //first test
      {
        return("Congratulations - A Distinction " );
      }
      else if (vMarkIn > 49) //Second Test
        {
          return("A Merit " );
         }
         else if (vMarkIn > 39) //Third Test
         {
           return("A Pass " );
         }
         else
          {
            return("I'm sorry you have failed " );
          }
      }

     //A driver method for this program
     public void startGrading()
      {
        //Purpose:  A controling method for this class
        char response;
        int vMark;
        String grade;
       
        System.out.println("*********** Grading Program *********"); 
        System.out.println();
         //Use a do..while loop to prompt for grades
        do 
        {
           vMark = getValidMark();
                  
          //Call the grading method
           grade = gradeMark(vMark);
           System.out.println(grade);
          
          //Prompt to continue
           System.out.print("another go (y/n)? =>");
           response = sc.next().charAt(0);
        } while (response == 'y' || response == 'Y')   ;  
    
 }

   }
