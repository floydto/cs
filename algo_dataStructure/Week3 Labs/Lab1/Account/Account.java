
/**
 * Account class.
 * Defined to illustrate inheritance
 * Will be super class to ChequeAccount & SavingsAccount classes
 * 
  */

public class Account
{
    // instance variables 
    private double balance; 

    /**
     * Constructor for objects of class Account
     */
    public Account(double balance)
    {
        // initialise instance variables
        this.balance = balance;
    }

    /**
     * credit
     * Add amount to balance
     */
    public void credit(double amount)
    {
        balance +=  amount;
    }
    /**
     * debit
     * Deduct amount from balance
     * Negative balance not allowed
     */    
    public boolean debit(double amount)
    {
        if    ((balance - amount) < 0)
              return false;
        else  balance -= amount;
        return true;
    }
    
// Getters & setters
    
    public double getBalance()
    {
        return balance;
    }
    
    public void setBalance(double newBalance)
    {
        balance = newBalance;
    }
    
    /**
     * This method overrides the toString method in the Object class
     */
    public String toString()
    {
        return  super.toString() + " Balance : " + balance;
    }
}
