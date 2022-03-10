public class Animals {		//YPERCLASH
		protected String onomaAnimal;		//METAVLITES
		protected int serialCode;		
		
		public int getSerialCode() {			//GETTERS & SETTERS
			return serialCode;
		}

		public void setSerialCode(int serialCode) {
			this.serialCode = serialCode;
		}

		public String getOnomaAnimal() {
			return onomaAnimal;
		}

		public void setOnomaAnimal(String onomaAnimal) {
			this.onomaAnimal = onomaAnimal;
		}

		public Animals(String name,int count){	//Constructors
			onomaAnimal=name;
			serialCode=count;
		}
		
		public Animals(int count){
			serialCode=count;
		}
		
		public void printAnimals(){			//METHODOS EKTIPWSHS stoixeion zwou
			System.out.println("Animal Description:");	
			System.out.println("Onoma zwou: "+ onomaAnimal);
			System.out.println("Seiriakos Kodikos: "+ serialCode);
		}
}
