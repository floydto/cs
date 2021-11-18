
/**
 * class TestAccounts .
 * 
 */
public class TestAccounts
{
    public static void main (String args[])
    {
    //Create ChequeAccount object with initial balance of 1000 pence
     ChequeAccount ca1 = new ChequeAccount(1000); 
    //Set its overdraft limit using method defined in ChequeAccount class
    //Display the attributes of the ChequeAccount object
    //The odl attribute is defined in the ChequeAccount sub class
    //The balance attribute is defined in the Account super class
     System.out.println("Cheque Account ca1 object's data after creation");
     System.out.println(ca1.toString());
     System.out.println();
     
    //Set the over draft limit 
     ca1.setOdl(200);
    //Credit some cash to ChequeAccount object, using method defined in the Account super class 
     ca1.credit(500);
    //Check balance is correct - should be 1500 & odl set correctly
     System.out.println("Check ChequeAccount ca1 object's data after setting odl to 200 & credit of 500");
     System.out.println(ca1.toString());
     System.out.println();
     
    //Debit some cash from ChequeAccount object, using method defined in the Account super class 
     System.out.println("Cheque Account ca1 object's balance after 800 debit should be 700");
     if   (ca1.debit(800))
           System.out.println(" Debit of 800 Successful");
     else  System.out.println(" Debit of 800 Failed"); 
    //Check balance is correct - should be 700 
     System.out.println(ca1.toString());
     System.out.println();
 
     System.out.println("Cheque Account ca1 object's balance after 800 debit should be -100"); 
     System.out.println("As overdraft limit set to 200");      
    //Check overdraft allowed
     if   (ca1.debit(800))
           System.out.println(" Debit Successful");
     else  System.out.println(" Debit Failed"); 
     System.out.println();
    //Check balance
     System.out.println(ca1.toString());
     System.out.println();
     
     System.out.println("Test overdraft limit.");
     System.out.println("Debit 101 from Cheque Account object ca1, starting balance -100.");
     System.out.println("Balance should remain unchanged at -100"); 
     System.out.println("As overdraft limit set to 200");      
     if   (ca1.debit(101))
           System.out.println(" Debit Successful");
     else  System.out.println(" Debit Failed"); 
     System.out.println();
     
    //Check balance
     System.out.println(ca1.toString());
     System.out.println();
    }
}
