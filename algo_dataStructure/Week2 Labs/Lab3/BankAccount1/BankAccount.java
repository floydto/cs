
class BankAccount
{
   // the attributes
   private String accountNumber;
   private String accountName;
   private double balance;
 

   // the methods

   // the constructor
   public BankAccount(String numberIn, String nameIn)
   {
      accountNumber = numberIn;
      accountName = nameIn;
      balance = 0;
   }

   // methods to read the attributes
   public String getAccountName()
   {
      return accountName;
   }

   public String getAccountNumber()
   {
      return accountNumber;
   }

   public double getBalance()
   {
      return balance;
   }

   // methods to deposit and withdraw money
   public void deposit(double amountIn)
   {
      balance = balance + amountIn;
   }

   public void withdraw(double amountIn)
   {
     balance = balance - amountIn;
   }
}

