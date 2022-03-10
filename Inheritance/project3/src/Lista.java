
public abstract class Lista {
		  protected Node head;             
		  protected int length;    //metavlites

		  public Lista()  {  head = null;  length = 0; }  //arxikes times
	  
		  public boolean isEmpty()    { return head == null; }	//synthiki gia adeia lista
	  
		  public abstract Node insert(Item a); 
		  public abstract void print();	//methodos ektipwshs
		  
		  public Node search(Item a) {
			  for (Node tmp = head;     tmp != null;      tmp = tmp.getNext()){
			    	if (a.equals(tmp.getValue()))    
		            	 return tmp;   
			    }                       
		        return null;                                  
		  }
		  
		  public int getLength() { return length; }		//megethos tis listas
		  public void clearList() { head = null; length = 0; }	//default times

		  public Node delete (Item a) {
			    Node n1 = head, n2 = head;
			    					//vriskoume ton proigoume kai ton epomeno komvo apo auton pou theloume na diagrapsoume
			    while ((n1 != null) && (!a.equals( n1.getValue() ) ) ) {  
			        
			        n2 = n1; n1 = n1.getNext(); }		//yparxei o komvos pou psaxnoume ara tha ton diagrapsoume
			    if (n1 != null) {     				//sindeoume tous dio komvous stous opoios vriskontan anamesa o zhtoumenos komvos
			        length--;
			        if (n2 != n1)       // n1 != head
			            n2.setNext(n1.getNext());	//allazei timh to head
			        else                 
			            head = head.getNext();     
			        n1.setNext(null);
			    }
			    return head;
			  }
	 
}
