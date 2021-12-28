/**
   Class:   PhD Student
   Author:  Tommy Yuan
   Date:    Jan 30 2019
  Access control experiment:
 */


import student.*;

public class PhDStudent extends Student
{
	String researchArea;
	
	
    public void setResearchArea(String area) {
		
		researchArea=area;
	}
	
	public String getResearchArea() {
		
		return researchArea;
	}
	
	public void displayDetails(){
		
		System.out.println("Credits =" + super.credits); 
		
		//Try this, 
		System.out.println("ID =" + super.id);
	}
	

}
