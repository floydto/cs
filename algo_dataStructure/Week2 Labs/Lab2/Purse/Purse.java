public class Purse
{ 

   // instance variable to store the total
  private double total;
   
   /* methods to add coins and to get the total.
    * This allows access to Coin methods as they can be traced back
    * via this reference.
   *  coinCount is the number of coins of a particular
   * value you are adding (e.g 3 10p coins)
   */ 
   public void addCoins(int coinCount, Coin coinType)
   {  //Notice how we have access to the getValue method via the reference to Coin
      double value = coinCount * coinType.getValue();
      total = total + value;
   }

   public double getTotal()
   {  
       return total;
   }

}


