
public class SortedList extends List {
	public Node insert (Item a) {              	           // ���������� ��� ������
	    Node tmp = new Node(a);     length++;
	    Node n1 = head, n2 = head;
	    // ��� �� ����� ������� � ������� ��������� less
	    while ((n1 != null) && (n1.getValue().less(a) )) {  // ���������� ���� 2 ������� ������
	      n2 = n1;   n1 = n1.getNext();  }                          // ��� ������ �� ����� � ��������
	    if (n1 == head) {                                                  // ��� ������� �������� ���� ����...
	      tmp.setNext(n1); head = tmp;
	    }
	    else {                    // �������� ������ n1 ��� n2. �������� ��� ��� �������� ��� �����
	      n2.setNext(tmp);
	      tmp.setNext(n1);   
	    } 
	    return head;
	  }
	
	public void print(){		//Print elements saved in node
			for (Node tmp = head;      tmp != null;      tmp = tmp.getNext())
			      tmp.ektipwsi();		
	}
	
	public void printAllInHierarchy(String className) {	//Method printAllInHierarchy 
		System.out.println("Trying to find all objects instance of: " + className);		
		for(Node tmp=head;tmp!=null;tmp=tmp.getNext()){	//Check every node in the list . 
				try{		//If the name given by the user is the object(animalItem or workerItem)
					if(Class.forName(className).isInstance(tmp.getValue().key())){ // stored in node
						tmp.ektipwsi();												//Print elements
					}
				}catch(ClassNotFoundException e){
					e.printStackTrace();
			}
		}
	}
}