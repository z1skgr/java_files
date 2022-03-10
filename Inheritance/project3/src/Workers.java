
public class  Workers {
		protected String onomaWorker;		//Metavlites
		protected float AFM;
		
		public Workers(String name,float AFM){	//Constructors
			onomaWorker=name;
			this.AFM=AFM;
		}
		
		public void printWorkers() {		//Methodos ektypwshs
			System.out.println("Worker Description: ");
			System.out.println("[Name]: " +  onomaWorker + "\n[AFM]: " + AFM);
	    }
		
		public Workers(float AFM){		//Getters && Setters
			this.AFM=AFM;
		}

		public String getOnomaWorker() {
			return onomaWorker;
		}

		public void setOnomaWorker(String onomaWorker) {
			this.onomaWorker = onomaWorker;
		}

		public float getAFM() {
			return AFM;
		}

		public void setAFM(float afm) {
			AFM = afm;
		}
		


}
