
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
		super.printAnimals();		//methodos ektipwshs . energopoieite kai h methodos ektipwshs tou lizards
		System.out.println("Arithmos podion: "+ footNumber+"\n");
	}
}


