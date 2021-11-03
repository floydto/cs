/** Using Operators - 
 * Try and calculate the values you would expect by calling 'doOperations()'
 *  Invoke the 'doOperations()' method and check
 * 
 */
public class Calculator1
{
   int result;
   int mins;
   int hours;
   int strange;
   double stranger;
   float moreLikeIt;
        
  public void doOperations()
  {
    result = (27/3+2*3) - 1;
    mins =  200%60;
    hours = 200/60;
    strange = 7/4;
    stranger = 7/4;
    moreLikeIt = 7/4f;
    
  }  
 
  public void displayAnswers()
  {
    System.out.print("(27/3+2*3) - 1 = ");
    System.out.println(result);
    
    System.out.print("200%60 = ");
    System.out.println(mins);
    
    System.out.print("200/60 = ");
    System.out.println(hours);
    
    System.out.print("7/4 = ");
    System.out.println(strange);
    
    System.out.print("7/4 (assigned to a 'real' variable) = ");
    System.out.println(stranger);
    
    System.out.print("7/4f (defined as a real and assigned to a real) = ");
    System.out.println(moreLikeIt);
    
  }
  
}
