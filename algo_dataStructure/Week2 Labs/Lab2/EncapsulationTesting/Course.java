
/**
 * Write a description of class StudentTesting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Course
{  
   public static void main (String args[])
   {
	   Student s=new Student("12345","Tommy");
	   
	   //External access to a private attribute in Student class is not allowed
	   //You should note it is a syntactical error
	   System.out.println(s.name);
	   
	   //You should access via public method
	   System.out.println(s.getName());
   }

}
    
   