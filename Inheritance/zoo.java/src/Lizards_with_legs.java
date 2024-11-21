
public class Lizards_with_legs extends Lizards {
	protected int footNumber;
	
	public Lizards_with_legs(String name,int count,String cover,int number){	//Constructors
		super(name,count,cover);
		footNumber=number;
	}

	public int getFootNumber() {		//Getters && setters
		return footNumber;
	}

	public void setFootNumber(int footNumber) {
		this.footNumber = footNumber;
	}
	
	public void printAnimals(){
		super.printAnimals();		//Print method. Activate superclass print
		System.out.println("Num Legs "+ footNumber+"\n");
	}
}


