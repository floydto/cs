
/**
 * class ChequeAccount .
 * 
  */

public class ChequeAccount extends Account
{
    // instance variables 
    private double odl; //Overdraft Limit

    /**
     * Constructor for objects of class ChequeAccount
     */
    public ChequeAccount(double balance)
    {
        super(balance); //call super class (Account) constructor
        odl = 0;  //set default value for over draft limit
    }

/**
  * Debit
  * if the balance will remain within the overdraft limit after the debit, 
  *     the amount is subtracted from the balance & true returned
  * else nothing is done & false is returned    
*/
    public boolean debit(double amount)
    {
        if    ((getBalance() - amount) >= -odl)
               { setBalance(getBalance() - amount);
                 return true;
               }
        else    return false;
    }
    
//Setters & getters
    public void setOdl(double odlIn)
    {
        odl = odlIn;
    }
    
    public double getOdl()
    {
        return odl;
    }
    
    public String toString()
    {
        return super.toString() + " ODL : " + odl;
    }
}
