
/**
 * GUI_IO class to demonstrate the use of JOptionPane.
 * 
 * @Simon Sharpe
 * @Sept 2002
 */

import javax.swing.JOptionPane;  // import class JOptionPane

public class GUI_IO {

   String name = "default name";
  /*==================================
   * Methods to show output
   * ================================= */
  
   
  //Use basic showMessageDialog 
   public void basicMessage()
   {
      //The 'null' parameter means centre the dialog box.
      //Notice how we can use \n to create new lines
      JOptionPane.showMessageDialog(null, "Welcome\nto\nJava\nProgramming!" );
   }
    
   //Show with a Title bar and a Warning message  
   public void titleBarWarning()
   {
     JOptionPane.showMessageDialog(null, "Look out! - don't press that!", 
                                    "A Warning", JOptionPane.WARNING_MESSAGE );
   }
  
  //Prompt for a name using the showInputDialog method
   public void basicPromptDisplay()
   {
        name = JOptionPane.showInputDialog("What is your name");
       //Various
       JOptionPane.showMessageDialog(null, "Hi " + name + " how do you like these dialog boxes?",
                                     "A Question", JOptionPane.QUESTION_MESSAGE ); 
    }

}  
