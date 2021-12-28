
public class NotebookTester {

	public static void main(String[] args) {
		//Create Notebook objects and test the methods
		Notebook n=new Notebook();
		
		n.storeNote("Monday");
		n.storeNote("Tuesday");
		n.storeNote("Wednesday");
		n.storeNote("THursday");
		
		n.showNote(2);
		n.listNotes();

	}

}
