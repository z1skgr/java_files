
public class Zoo {
		
		protected String nameZoo;		//Vars
		protected String cityZoo;

		private SortedList animals;
		private SortedList employees;
		private WorkerItem w_Item;
		private AnimalItem a_Item;
		
		
		public List getAnimals() {			//GETTERS && SETTERS
			return animals;
		}

		public void setAnimals(SortedList animals) {
			this.animals = animals;
		}

		public List getEmployees() {
			return employees;
		}
		
		public void setEmployees(SortedList employees) {
			this.employees = employees;
		}

		public Zoo(String name,String poli){		//Constructors
			nameZoo=name;
			cityZoo=poli;
			employees=new SortedList();
			animals=new SortedList();
		}
		
		public String getnameZoo() {
			return nameZoo;
		}
		public void setnameZoo(String nameZoo) {
			this.nameZoo = nameZoo;
		}
		public String getcityZoo() {
			return cityZoo;
		}
		public void setcityZoo(String cityZoo) {
			this.cityZoo = cityZoo;
		}
		
		public void printZoo(){			//Print all elements in the zoo
			System.out.println("[Name of Zoo]: " +  nameZoo + "\n[City of Zoo]: " + cityZoo+"\n");
			animals.print();
			employees.print();
		}
		
		public void Insert_Animal(Animals a){			//Method to add object animalItem in animal list
			a_Item=new AnimalItem(a);
			animals.insert(a_Item);
		}
		
		public void Insert_Worker(Workers b){		//Method to add object animalItem in worker list
			w_Item=new WorkerItem(b);
			employees.insert(w_Item);

		}
		
		public void terminate(){		//Clear lists and terminate program
			animals.clearList();
			employees.clearList();
		}
				
		public void Delete_Animal(int kodikos){		//Delete based code for animals
			a_Item=new AnimalItem(new Animals(kodikos));		
			Node n=animals.search(a_Item);		//create new animal node for search
			if (n == null)
	            System.out.println("The animal with code "+kodikos+" was not found");	//n=null no animal found
	        else{
	        	System.out.println("Animal found with code: " + kodikos);//else animal found and can be deleted
	        	animals.delete(a_Item);
	        	System.out.println("Erasure success!");
	        }
			
		}
		
		public void Search_Animal(int kodikos){		//Search based serial code for animals
			a_Item=new AnimalItem(new Animals(kodikos));//create new animal node for search
			Node n=animals.search(a_Item);	
			if (n == null)
				System.out.println("The animal with code "+kodikos+" was not found");//n=null no animal found
			else{
	        	System.out.println("Search success: " + kodikos); //else animal found 
	        	n.ektipwsi();
	        }
		}
		
		public void Search_Worker(int kodikos){		//Delete based VAT Number for workers
			w_Item=new WorkerItem(new Workers(kodikos));//create new worker node for search
			Node n=employees.search(w_Item);
			if(n==null)
				System.out.println("The worker with code "+kodikos+" was not found");//n=null no worker found
			else{
	        	System.out.println("Worker found with code: " + kodikos);//else worker found
	        	n.ektipwsi();
			}
		}
		
		public void eidikoPrint(String className,String onoma){	//method that calls PrintAllInHierarchy
			if(onoma.equalsIgnoreCase("Employees")){				
                employees.printAllInHierarchy(className);	//for employees
			}				
			else if(onoma.equalsIgnoreCase("Animals")){		//for animals
				animals.printAllInHierarchy(className);
			}
		}
		
		
		

		
}

