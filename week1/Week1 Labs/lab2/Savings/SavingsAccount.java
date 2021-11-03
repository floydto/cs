/* Bank Account Class
 * To demonstrate concepts relating to method writing, input, 
 * output and methods returning information
 */
import java.util.*;
public class SavingsAccount
{  
   //Variables to store account balance and ID 
   double balance ;
   int ID ;
   Scanner sc=new Scanner (System.in);
   
   
   //Put 'calculateProjectedInterest()' below here
   
   
   public void initialiseAccountDetails()
   {  
     //Purpose: To prompt for and initialise bank account details
      System.out.println("********  Creating A New Savings Account *******");
      System.out.println("Enter account ID (integer)");
      ID = sc.nextInt();
      System.out.println("Please enter an initial balance ");
      balance = sc.nextFloat();
      System.out.println("Account Created");
      System.out.println("ID = " + ID);
      System.out.println("Balance = "+ balance);
   }
   
   public void deposit() 
   { 
    //Purpose to deposit money into the account. 
     float amount;
     System.out.println("Please enter amount you wish to deposit ");
     amount = sc.nextFloat();
     balance = balance + amount;
     System.out.println("Transaction completed");
   }

   public void withdraw() 
   {  
     //Purpose; To withdraw money from the account
     float amount;
     System.out.println("Please enter amount you wish to withdraw ");
     amount =  sc.nextFloat();
     balance = balance - amount;    
     System.out.println("Transaction completed");
   }

   public void printStatement()
   {
     System.out.println("Statement for account ID = "+ ID);
     System.out.println("Current balance = " + balance);
   }

   public double getBalance()
   { //Purpose: To demonstrate how current balance can be returned 
     return balance; 
   }
  
    public int getID()
   { 
     //Purpose: To demonstrate how current balance can be returned 
     return ID; 
   }     

}