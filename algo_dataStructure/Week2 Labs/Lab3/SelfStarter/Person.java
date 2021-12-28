
/**
 * An all-in-one self-starting app[.
  */
public class Person
{
	// instance variables - replace the example below with your own
	private String name;

	/**
	 * Constructor for objects of class Person
	 */
	public Person(String nameIn)
	{
		// initialise instance variables
	     name = nameIn;
	}

	public String getName()
	{
		return name;
	}
   //Starting Point
   public static void main(String[] args)
   {
      System.out.println("In main ..starting application");   
      System.out.println("Making an object of myself");
      Person itsMe = new Person("Fred Blogss");
      System.out.println("My name is "+itsMe.getName() );
      System.out.println("How clever I am. I started myself");
      
   }

}
