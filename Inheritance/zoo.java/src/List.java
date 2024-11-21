
public abstract class List {
		  protected Node head;             
		  protected int length;    //Vars

		  public List()  {  head = null;  length = 0; }  //Initial values times
	  
		  public boolean isEmpty()    { return head == null; }	//Condition for empty list
	  
		  public abstract Node insert(Item a); 
		  public abstract void print();	//Print method
		  
		  public Node search(Item a) {
			  for (Node tmp = head;     tmp != null;      tmp = tmp.getNext()){
			    	if (a.equals(tmp.getValue()))    
		            	 return tmp;   
			    }                       
		        return null;                                  
		  }
		  
		  public int getLength() { return length; }		//Size
		  public void clearList() { head = null; length = 0; }	//default values

		  public Node delete (Item a) {
			    Node n1 = head, n2 = head;
			    					//Find adjacent nodes for the note to be deleted
			    while ((n1 != null) && (!a.equals( n1.getValue() ) ) ) { 
			        n2 = n1; n1 = n1.getNext(); }		//We find the node we want to delete. So DELETE
			    if (n1 != null) {     				//Keep the adjacent nodes connected
			        length--;
			        if (n2 != n1)       // n1 != head
			            n2.setNext(n1.getNext());	//Modify head
			        else                 
			            head = head.getNext();     
			        n1.setNext(null);
			    }
			    return head;
			  }
	 
}
