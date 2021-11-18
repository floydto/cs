
/**
 * Product class -  with a description and a price
 * 
 */
class Product
{  
   
   private String description;
   private double price;
   
   /**
      Constructs a product from a description and a price.
      @param aDescription the product description
      @param aPrice the product price
   */
   public Product(String aDescription, double aPrice)
   {  
      description = aDescription;
      price = aPrice;
   }
   /**
      Sets the product price
   */ 
   public void setPrice(double priceIn)
   {
     price = priceIn;
   }
   
   /**
      Sets the product description.
   */
   public void setDescription(String descriptionIn)
   {
      description = descriptionIn;
   }
   
   /**
      Gets the product description. - @return the description
   */
   public String getDescription()
   {  
      return description;
   }

   /**
      Gets the product price.- @return the unit price
   */
   public double getPrice()
   {
      return price;
   }
   
   /*
    * Print Details to a terminal window
   */
   public void printDetails()
   {
     System.out.println("*********  Product Details ***********");
     System.out.println("Description - " + description);
     System.out.println("Price       - " + price); 
   }
   
}

