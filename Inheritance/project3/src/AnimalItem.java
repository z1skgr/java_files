
public class AnimalItem extends Item {	//YPERCLASS
	private Animals an;		//METAVLITES
	public AnimalItem(Animals an){this.an=an;	}
	public Object key() { return an;}   
	
										
	public boolean equals(Item o) { return an.getSerialCode()==((Animals)(o.key())).getSerialCode(); }
	public boolean less(Item o) { return an.getSerialCode()<((Animals)(o.key())).getSerialCode(); }
	
	public void print(){	//METHODOS EKTIPWSHS TOU ENERGOPOIEI TH METHODO PRINT APO THN CLASSH ANIMALS
		an.printAnimals();	//EKTIPWNONTE TA STOIXEIA GIA KATHE ANIMAL ITEM
	}
}
