
public class Birds extends Animals {	//YPOKLASI
	protected String colorWings;		//METAVLITES
	
	public Birds(String name,int count,String color){	//Constructors
		super(name,count);
		colorWings=color;
	}
	
	public void printAnimals(){	//Methodos ektipwshs 
		super.printAnimals(); //energopoieite h methodos ektipwshs ths yperklashs
		System.out.println("Xroma fteron: "+colorWings+"\n");
	}

	public String getColorWings() {		//getters & setters
		return colorWings;
	}

	public void setColorWings(String colorWings) {
		this.colorWings = colorWings;
	}

}