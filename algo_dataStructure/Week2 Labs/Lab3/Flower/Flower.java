
/**
 * Flower class to demonstrate multiple constructors.
 * 
  */
public class Flower
{
  private int petalCount;
  private String name ;
    
   // Constructor taking 1 parameter for petals
   Flower(int petalCountIn) 
   {
    petalCount = petalCountIn;
   }
   
   //Constructor taking name as parameter
    Flower(String nameIn) 
    {
      name = nameIn;
    }
  
   //Both parameters passed to the constructor
    Flower(String nameIn, int petalCountIn) 
    {
      name = nameIn;
      petalCount = petalCountIn;
     }
  
   //Default constructor - no args
    Flower() 
    { 
        petalCount = 0;
        name = "Undefined";
    }
    
    public int getPetalCount()
    {
      return petalCount;
    }
    
    public String getFlowerName()
    {
       return name;
    }

}
