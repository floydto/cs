
/**
 * Class to demonstrate the use of expressions
 * Calculate the results you would expect
 * Create a 'Calculator2' object and check your answers
 */
public class Calculator2
{
  //Declarations of variables for example methods below	
  int i, j, k;
  double f1,f2,f3; 
 
   public void a_expr()
   {
    i=2;
    j=53;
   //Simple expression - result being assigned to k and output
    k = 22 + (i + j)/11; 
 	System.out.print("If i=2,j=53, and k = 22 + (i + j)/11, then k = ");
	System.out.println(k);	
   }
   
   public void b_expr()
   {
     f1 = 0.0;
     f2 = 1.0;
	 f3 = -5.0;
	 //Another expression involving real numbers and output
	 f1 = 2*f2 - f3;
	 System.out.print("If f1=0.0, f2=1.0, f3=-5.0 and f1 = 2*f2 - f3, then f1 = ");
	 System.out.println(f1);	
    }
   
       
   public void c_expr()
   { 
     i = 2;
     f1 = 3.4;
    //Expressions where result(of RHS) is re-assigned to a variable name on LHS 
     i = i+1;
     f1 = -f1 * 2;   
     System.out.print("if i=2, f1=3.4 and i=i+1, then i = ");
     System.out.println(i);
	 System.out.print("if i=2, f1=3.4 and f1=-f1 * 2, then f1 = ");
	 System.out.println(f1); 
   }  
  
}
