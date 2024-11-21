
public class AnimalItem extends Item {	//hyper class
	private Animals an;		//vars
	public AnimalItem(Animals an){this.an=an;	}
	public Object key() { return an;}   
	
										
	public boolean equals(Item o) { return an.gets_Code()==((Animals)(o.key())).gets_Code(); }
	public boolean less(Item o) { return an.gets_Code()<((Animals)(o.key())).gets_Code(); }
	
	public void print(){	//print method. Extends item
		an.printAnimals();	//print elements for every animal item
	}
}
