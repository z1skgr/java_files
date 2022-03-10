
public class Assistants extends Workers { //YPOKLASH TOU WORKERS
		protected String workSection;		//METAVLITES
		
		public Assistants(String name,float afm,String workDepartment){	//Constructors
			super(name,afm);
			workSection=workDepartment;
		}
		
		public void printWorkers(){			//METHODOS EKTIPWSHS
			super.printWorkers();	//ENERGOPOIHTE KAI H METHODOS THS YPERKLASHS
			System.out.println("Tomeas ergasias: "+workSection+"\n");
		}

		public String getWorkSection() {	//GETTERS & SETTERS
			return workSection;
		}

		public void setWorkSection(String workSection) {
			this.workSection = workSection;
		}

}
