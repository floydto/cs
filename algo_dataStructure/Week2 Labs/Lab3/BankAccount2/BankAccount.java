
class BankAccount
{
   // the attributes
   private String accountNumber;
   private String accountName;
   private double balance;
   
   //Notice the static attribute
   private static double interestRate;

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
   
   public void setInterestRate(double rateIn)
   {  
      interestRate = rateIn;
   }
   
    public double getInterestRate()
   {  
      return interestRate;
   }
   
    public void addInterest()
   {  
     balance = balance + (balance *interestRate)/100;
   }
   
   
}

