
public class  Workers {
		protected String nameWorker;		//Vars
		protected float VAT;
		
		public Workers(String name,float VAT){	//Constructors
			nameWorker=name;
			this.VAT=VAT;
		}
		
		public void printWorkers() {		//Print method
			System.out.println("Worker Description: ");
			System.out.println("[Name]: " +  nameWorker + "\n[VAT]: " + VAT);
	    }
		
		public Workers(float VAT){		//Getters && Setters
			this.VAT=VAT;
		}

		public String getnameWorker() {
			return nameWorker;
		}

		public void setnameWorker(String nameWorker) {
			this.nameWorker = nameWorker;
		}

		public float getVAT() {
			return VAT;
		}

		public void setVAT(float vat) {
			VAT = vat;
		}
		


}
