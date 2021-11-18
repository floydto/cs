
/**
 * To illustrate declaration of variables, changing variables and the use of operators
 * and expression
 * 
 */
//Import the Scanner class which is part of the java.util package
import java.util.*;

public class SpaceShip2
{
    
    //Default values - All spaceships created from this class will start with these
    int mass = 456000;
    char warningLevel='L';   
    float  cosmicAcceleration = 2.0f;  
    double starSpeed = 235670;
    boolean defenseShieldArmed = false;
    int warpFactor = 2;
    final double TIME_COMPENSATOR = 5.432;
    
   //Method to demonstrate changing variables
    public void setDefense()
    {
       defenseShieldArmed = true   ;
       warningLevel = 'H' ;
       warpFactor = 3;
    }
  
   public double getStarSpeed()
   {
      return starSpeed;
   }
   
   public double getHeisenburgThrust()
   {
     double ht  ;
     ht = starSpeed + mass * TIME_COMPENSATOR/(warpFactor + cosmicAcceleration) ;
     return ht;
    }
      
   public void increaseWarpFactor()
   {
     warpFactor = warpFactor + 1; 
   }
   
   public void displaySettings()
   { 
    //Purpose : To demonstrate some output techniques
    //With  1 new line escape character
    System.out.println("\n");
    
    System.out.println("Spaceship settings");
   
   //With calculation
    System.out.println("Cosmic Force = " + (mass * cosmicAcceleration));  
   
   //Internal method call
   System.out.println("Heisenburg Thrust = " + getHeisenburgThrust());
  
      //With tabs
    System.out.println("Speed =\t" + starSpeed);
    System.out.println("Level =\t " + warningLevel); 
    
    System.out.println("\"A double quote example\"");   
   
   }
    
   public void promptSettings()
   {
    /* Purpose: Demonstrate input techniques using Scanner
    */ 
      
      //Create a new scanner object to receive input from the keyboard
      Scanner sc=new Scanner(System.in);
      
      System.out.println("Enter a warning level (L,M,H) and press return ");
      warningLevel = sc.next().charAt(0);
    
      System.out.println("Enter Warp Factor (2 - 10) ");
      warpFactor = sc.nextInt();
    
      System.out.println("Enter Star Speed ");
      starSpeed = sc.nextDouble();
      
      System.out.println("Now inspect the object and see whether the relevant attributes have been updated ");
        
   }
        
  
   
        
}
