
/**
 * To illustrate declaration of variables, changing variables and the use of operators
 * and expression
 * 
 */
public class SpaceShip
{
   //All objects created from SpaceShip with have the following initialised variables
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
   
   public void displayHeisenburgThrust()
   {
     double ht  ;
     ht = starSpeed + mass * TIME_COMPENSATOR/(warpFactor + cosmicAcceleration) ;
     System.out.println("Heisenburg Thrust = " + ht );
    }
      
   public void increaseWarpFactor()
   {
     warpFactor = warpFactor + 1; 
   }
   
   public void displaySettings()
   {
     System.out.print("Mass = ");
     System.out.println(mass);
	 System.out.print("Warning Level = "); 
	 System.out.println(warningLevel);     
     //In the space below, complete the output for cosmicAcceleration, 
     // starSpeed, defenseShieldArmed and warpFactor     
   
   
   
   }//End of displaySettings()
    
     	
}
