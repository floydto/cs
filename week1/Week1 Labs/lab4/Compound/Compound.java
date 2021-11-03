
/**
 * Calculates compound interest rates
 * 
 * @version (1.0)
 */
import java.util.*;

public class Compound
{
    double amount;
    double rate;
    int years;
  
   public void calculateCompound() 
   {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount to be invested :");
        amount = sc.nextDouble();
        System.out.println("Enter the interest rate :");
        rate =sc.nextDouble();
        System.out.println("Enter the number of years you wish to invest this money for:");
        years=sc.nextInt();
        int i;
        for(i = 1; i <= years; i++) {
            double interest = amount * (rate/100.0);
            amount = amount + interest;
            System.out.println("Amount after "+i+" years is "+amount);
        }
    }
   
   //Test in the same class
   public static void main (String args[]) {
	   Compound c=new Compound();
	   c.calculateCompound();
   }
    
    
    
}
