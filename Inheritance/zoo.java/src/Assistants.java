
public class Assistants extends Workers { //Subclass workers
		protected String workSection;		//Vars
		
		public Assistants(String name,float afm,String workDepartment){	//Constructors
			super(name,afm);
			workSection=workDepartment;
		}
		
		public void printWorkers(){			//Print Method
			super.printWorkers();	//Activate method print for hyperclass
			System.out.println("Work Section: "+ workSection+"\n");
		}

		public String getWorkSection() {	//GETTERS & SETTERS
			return workSection;
		}

		public void setWorkSection(String workSection) {
			this.workSection = workSection;
		}

}
