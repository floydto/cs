
/**
 *To illustrate Boolean variables and expressions.
 * 
 */
public class BoolBag
{
   
   boolean bresult;
   
   public void a_operations()
   {
    int  a = 5; 
    int  b = 7;
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    //compute boolean expresssion ('or' operator) - putting the answer in bresult
    bresult = ( (a <  b) || (b < 5) );
    System.out.println("( (a <  b) || (b < 5) ) = " + bresult);
    
    //Using 'and' operator
    bresult = ( (a <  b) && (b == 7) );
    System.out.println("( (a <  b) && (b == 7) ) = " + bresult);
    
   }

  public void b_mixed_operations()
  {
      boolean attractive = true;
      boolean rich;
      boolean stupid = false;
      float income = 50000;
      
      boolean desirable;
      rich = (income > 40000);
     
      System.out.println ("Rich = " + rich);
      desirable = (attractive && rich && !stupid);
      System.out.println ("Desirable = " + desirable);
     
  }

}