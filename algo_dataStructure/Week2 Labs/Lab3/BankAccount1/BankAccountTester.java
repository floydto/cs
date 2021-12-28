
/**
 * A Class to test the BankAccount Class 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BankAccountTester
{
   public static void main(String arg[])
   {
      //Create two bank accounts
      BankAccount account1 = new BankAccount("96723234","Marie Curie");
      BankAccount account2 = new BankAccount("99786754","Nelson Mandela");
      
      //Deposit some money
      account1.deposit(1000);
      account2.deposit(2000);
      
      //Display the details
      System.out.println("Account number: " + account1.getAccountNumber());
      System.out.println("Account name: "  + account1.getAccountName());
      System.out.println("Current balance: " + account1.getBalance());
     
      System.out.println(); //Blank line
      System.out.println("Account number: " + account2.getAccountNumber());
      System.out.println("Account name: "  + account2.getAccountName());
      System.out.println("Current balance: " + account2.getBalance());
     
       System.out.println();
     }

}
