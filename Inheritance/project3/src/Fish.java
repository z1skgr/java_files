
public class Fish extends Animals {
	protected String colorFish;	//metavlites
	protected String shapeFish;
	
	public Fish(String name,int count,String color,String shape){	//Constructors
		super(name,count);
		colorFish=color;
		shapeFish=shape;
	}
	
	public void printAnimals(){		//methodos ektipwshs . energopoieite kai h methodos ektipwshs ths yperklashs
		super.printAnimals();
		System.out.println("Xroma psariou: "+colorFish);
		System.out.println("Sxima psariou: "+shapeFish+"\n");
	}

	public String getColorFish() {		//getters && setters
		return colorFish;
	}

	public void setColorFish(String colorFish) {
		this.colorFish = colorFish;
	}

	public String getShapeFish() {
		return shapeFish;
	}

	public void setShapeFish(String shapeFish) {
		this.shapeFish = shapeFish;
	}

}

