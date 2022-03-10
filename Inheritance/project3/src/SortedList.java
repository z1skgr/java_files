
public class SortedList extends Lista {
	public Node insert (Item a) {              	           // Επιστρέφει την κεφαλή
	    Node tmp = new Node(a);     length++;
	    Node n1 = head, n2 = head;
	    // Εδώ θα είναι χρήσιμη η μέθοδος σύγκρισης less
	    while ((n1 != null) && (n1.getValue().less(a) )) {  // Αναζητούμε τους 2 κόμβους μεταξύ
	      n2 = n1;   n1 = n1.getNext();  }                          // των οποίων θα γίνει η εισαγωγή
	    if (n1 == head) {                                                  // Εάν γίνεται εισαγωγή στην αρχή...
	      tmp.setNext(n1); head = tmp;
	    }
	    else {                    // Εισαγωγή μεταξύ n1 και n2. Καλύπτει και την εισαγωγή στο τέλος
	      n2.setNext(tmp);
	      tmp.setNext(n1);   
	    } 
	    return head;
	  }
	
	public void print(){		//methodos ektypwshs ton stoixeion pou einai apothikeumena ston komvo
			for (Node tmp = head;      tmp != null;      tmp = tmp.getNext())
			      tmp.ektipwsi();		
	}
	
	public void printAllInHierarchy(String className) {	//Methodos printAllInHierarchy 
		System.out.println("Trying to find all objects instance of: " + className);		
		for(Node tmp=head;tmp!=null;tmp=tmp.getNext()){	//elegxete kathe komvos tis listas . 
				try{		//An to onoma pou exei dwsei o xristis pou thelei na ektypwsei einai idio me to onoma tou antikeimenou(animalItem h workerItem)
					if(Class.forName(className).isInstance(tmp.getValue().key())){ // pou einai apothikeumeno ston komvo
						tmp.ektipwsi();												//tote ektypononte ta stoixeia tou
					}
				}catch(ClassNotFoundException e){
					e.printStackTrace();
			}
		}
	}
}