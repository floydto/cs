/* Bank Account Class
 * To demonstrate concepts relating to method writing, input, 
 * output and methods returning information
 */
import java.util.*;

public class BankAccount
{  
   //Variables to store account balance and ID 
   double balance;
   String accountID;  
   String accountHolder;
    
   public void promptAccountDetails()
   {  
     //Purpose: To prompt for and initialise bank account details
      Scanner sc=new Scanner(System.in);
      System.out.println("********  Initialising Bank Account  Details *******");
      System.out.print("Please enter Name => ");
      accountHolder =sc.next();
      System.out.print("Please enter ID => ");
      
      accountID = sc.next();
      System.out.print("Please enter an initial balance => ");
      
      balance = sc.nextDouble();
      System.out.println("Account Initialised");
   }
  
  //A method to demonstrate how details could be set using parameters
  public void setAccountHolder(String accountHolderIn)
  {
     accountHolder = accountHolderIn;
  }
  
  
    public void displayDetails()
   {
    //Purpose: To display current account details
     System.out.println("******** Account Details *******");
     System.out.println("Name = " + accountHolder + "   ID = " + accountID);
     System.out.println("Current balance = " + balance);
   }
      
      
   
   public void deposit(float amount) 
   { 
     balance = balance + amount;
     System.out.println("Deposit transaction completed");
   }

   public void withdraw(float amount) 
   {  
     balance = balance - amount;    
     System.out.println("Withdrawn transaction completed - ");
   }

   public void printStatement()
   {
     System.out.println("Statement for account ID = "+ accountID);
     System.out.println("Current balance = " + balance);
   }

   public double getBalance()
   { //Purpose: To demonstrate how current balance can be returned 
     return balance; 
   }
  
   public String getHolder()
   { //Purpose: Return the name of the account holder
     return accountHolder;
   }
   
    public double availableForLoan(double income, double debt)
   {
     double tempLoanAvailable;
     
     tempLoanAvailable = 2.5*income + balance - debt;
     
     return tempLoanAvailable;
   
   }
}