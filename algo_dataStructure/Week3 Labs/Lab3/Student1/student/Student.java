/**
   Class:   Student
   Author:  Tommy Yuan
   Date:    Jan 30 2019
  Access control experiment:
 */
package student;

public class Student
{
   
   // the student's full name
	private String name;
	// the student ID
	String id;
	// the amount of credits for study taken so far
	protected int credits;

	/**
	 * Methods to set student details 
	 */
	public void setName(String nameIn)
	{
		name = nameIn;
	}
     
    public void setID(String idIn)
    {
       id = idIn;   
    }

    public void setCredits(int creditsIn)
    {
      credits = creditsIn ;  
    }

	/**
	 * Return the full name of this student.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set a new name for this student.
	 */
	public void changeName(String replacementName)
	{
		name = replacementName;
	}

	/**
	 * Return the student ID of this student.
	 */
	public String getStudentID()
	{
		return id;
	}

	/**
	 * Add some credit points to the student's accumulated credits.
	 */
	public void addCredits(int additionalPoints)
	{
		credits += additionalPoints;
	}

	/**
	 * Return the number of credit points this student has accumulated.
	 */
	public int getCredits()
	{
		return credits;
	}

	/**
	 * Print the student's name and ID number to the output terminal.
	 */
	public void printDetails()
	{
		System.out.println(name + " (" + id + ")");
		System.out.println("Credits = "+credits);
	}
     public void incCredits(int increase)
    {
      /* Purpose:  Increments the number of credits by 'increase'
         Receives: An integer increase
      */    
       credits = credits + increase;
    }

}
