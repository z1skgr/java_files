
	public class Trainers extends Workers{
		protected String typeEmployee;	//Metavlites
		
		public Trainers(String name,float afm,String typeOfEmployee){		//Constructors
			super(name,afm);
			typeEmployee=typeOfEmployee;		
		}
		
		public void printWorkers(){		//Methodos ektypwshs.energopoieite kai h ektipwsh ths yperklashs
			super.printWorkers();
			System.out.println("Typos ergasias: "+typeEmployee+"\n");
		}

		public String getTypeEmployee() {	//Getters && Setters
			return typeEmployee;
		}

		public void setTypeEmployee(String typeEmployee) {
			this.typeEmployee = typeEmployee;
		}

}
