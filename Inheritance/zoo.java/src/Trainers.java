
	public class Trainers extends Workers{
		protected String typeEmployee;	//Vars
		
		public Trainers(String name,float afm,String typeOfEmployee){		//Constructors
			super(name,afm);
			typeEmployee=typeOfEmployee;		
		}
		
		public void printWorkers(){		//Print method of super class
			super.printWorkers();
			System.out.println("Type of work: "+typeEmployee+"\n");
		}

		public String getTypeEmployee() {	//Getters && Setters
			return typeEmployee;
		}

		public void setTypeEmployee(String typeEmployee) {
			this.typeEmployee = typeEmployee;
		}

}
