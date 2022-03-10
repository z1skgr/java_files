
public class Lizards_with_noFoot extends Lizards {
		protected float maxSpeed;	//metavlites
		
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
		
		public void printAnimals(){		//methodos ektypswshs ton stoixeion.Energopoieite kai h methodos print tou lizards
			super.printAnimals();
			System.out.println("Megisth taxuthta: "+ maxSpeed +" km/h\n");
		}
}
