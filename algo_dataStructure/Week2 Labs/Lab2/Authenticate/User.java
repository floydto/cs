
/**
 * To demonstrate passing string objects as parameters
 * 
 */
public class User
{
	// instance variable to hold user password
	private String password;
    
   //Constructor
    public User()
	{
		// initialise password
		password = "NULL";
	} 
   
    public void setPassword(String passwordIn)
	{		
	    password = passwordIn;
	}
	
	public String getPassword()
	{
	  return password;
	}
     
}
