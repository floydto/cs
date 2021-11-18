import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * @author David J. Barnes and Michael Kolling.
 * @version 2001.06.08
 */
public class MenuNotebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList notes;
     //An array of strings
    private String alternatives[] = {"List", "Add", "Show", "Exit"};

    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public MenuNotebook()
    {
        notes = new ArrayList();
    }

    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        notes.add(note);
    }

    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Show a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
     public void listNotes()
    {
        int index = 0;
        while(index < notes.size()) {
            System.out.println(notes.get(index));
            index++;
        }
    }
    
     public void runMenu()
     {
        
        int option = getChoice();
        while (option != 3)
        {
          //Action depending on choice
          if (option == 0)//List notes
          {
           if (numberOfNotes() >0 )
           { 
            listNotes();
           }
           else System.out.println("No notes in list");
          }
          else if (option == 1) //Add note
          {
           String newNote= JOptionPane.showInputDialog(null,"Enter a new note","New Note", JOptionPane.PLAIN_MESSAGE);
           storeNote(newNote) ; 
         
          }
          else if (option == 2)
          {
            if (numberOfNotes() >0 )
            {
              String strNum= JOptionPane.showInputDialog(null,"Enter a note Number","Show Note", JOptionPane.PLAIN_MESSAGE);
              int num = Integer.parseInt(strNum); 
              if (num <= numberOfNotes())
              {
                showNote(num) ;
              }
              else System.out.println("Invalid number");
            }
            else System.out.println("No notes in list");
          }
           else JOptionPane.showMessageDialog(null, "No Comprendo " +option);
         //Prompt again
         option = getChoice();
        }//End while
     }
    
    public int getChoice()
    {
        int choice = JOptionPane.showOptionDialog(null, "Select from ..","Notebook Menu",
                     JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, alternatives, alternatives[0]);
        return choice;
    }
    
}
