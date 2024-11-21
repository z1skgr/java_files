
public class Lizards_with_noFoot extends Lizards {
		protected float maxSpeed;	//Vars
		
		public Lizards_with_noFoot(String name,int count,String cover,float lizardSpeed){
			super(name,count,cover);		//Constructors
			maxSpeed=lizardSpeed;
		}

		public float getMaxSpeed() {		//Getters && Setters
			return maxSpeed;
		}

		public void setMaxSpeed(float maxSpeed) {
			this.maxSpeed = maxSpeed;		
		}
		
		public void printAnimals(){		//Print method.Activate print of superclass 
			super.printAnimals();
			System.out.println("Max speed: "+ maxSpeed +" km/h\n");
		}
}
