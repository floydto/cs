/* An addition program demonstrating grapical input 
 * and Wrapper class conversion 
*/

import javax.swing.JOptionPane;
public class Awrap{
   
     public static void main(String args[])
   {
      String firstNumber;   // first string entered by user
      String secondNumber;  // second string entered by user
      int number1;          // first number to add
      int number2;          // second number to add
      int sum;              // sum of number1 and number2

      // read in first number from user as a string - using a 'swing' dialog box
      firstNumber =JOptionPane.showInputDialog( "Enter first integer" );

      // read in second number from user as a string
      secondNumber = JOptionPane.showInputDialog( "Enter second integer" );

      // convert numbers from type String to type int using the WRAPPER method
      number1 = Integer.parseInt( firstNumber ); 
      number2 = Integer.parseInt( secondNumber );
     //If these were decimal numbers we could use
     // number1 = Double.parseDouble(firstNumber);
      // add the numbers
      sum = number1 + number2;

      // display the results
    JOptionPane.showMessageDialog(null, "The sum is " + sum,
                                     "Sum Total", JOptionPane.INFORMATION_MESSAGE ); 
 

     }
}
