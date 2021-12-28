
public class StudentTester {

		public static void main(String args[])
		{
		    //Create a student using the constructor + arguments
	         Student S1 = new Student("Michael Mouse", "1234") ;
	       
	        //Call methods to get name and Id
		     System.out.println("Name = " + S1.getName()) ;
		     System.out.println("ID  = " + S1.getStudentID());
		     System.out.println("Login Name= "+ S1.getLoginName());
		     
		     //Test remaining methods
	         S1.changeName("Fred Bloggs");
	         S1.addCredits(50);
	         
	         System.out.println("Changed details for S1 ");
		     System.out.println("Name = "+ S1.getName()) ;
		     System.out.println("ID = "+ S1.getStudentID());
		     System.out.println("Credits = "+ S1.getCredits());
		}
	  
	}


