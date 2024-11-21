public class Animals {		//YPERCLASH
		protected String n_Animal;		//METAVLITES
		protected int s_Code;		
		
		public int gets_Code() {			//GETTERS & SETTERS
			return s_Code;
		}

		public void sets_Code(int s_Code) {
			this.s_Code = s_Code;
		}

		public String getn_Animal() {
			return n_Animal;
		}

		public void setn_Animal(String n_Animal) {
			this.n_Animal = n_Animal;
		}

		public Animals(String name,int count){	//Constructors
			n_Animal=name;
			s_Code=count;
		}
		
		public Animals(int count){
			s_Code=count;
		}
		
		public void printAnimals(){			//Print method animal records
			System.out.println("Animal Description:");	
			System.out.println("Animal Name: "+ n_Animal);
			System.out.println("Serial Code: "+ s_Code);
		}
}
