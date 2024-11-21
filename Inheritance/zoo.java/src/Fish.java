
public class Fish extends Animals {
	protected String colorFish;	//Vars
	protected String shapeFish;
	
	public Fish(String name,int count,String color,String shape){	//Constructors
		super(name,count);
		colorFish=color;
		shapeFish=shape;
	}
	
	public void printAnimals(){		//Print method of super class
		super.printAnimals();
		System.out.println("Fish color: "+ colorFish);
		System.out.println("Fish shape: "+ shapeFish +"\n");
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

