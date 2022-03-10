
public class Zoo {
		
		protected String onomaZoo;		//METVAVLITES
		protected String poliZoo;

		private SortedList zwa;
		private SortedList ergates;
		private WorkerItem Item1;
		private AnimalItem Item2;
		
		
		public Lista getZwa() {			//GETTERS && SETTERS
			return zwa;
		}

		public void setZwa(SortedList zwa) {
			this.zwa = zwa;
		}

		public Lista getErgates() {
			return ergates;
		}

		public void setErgates(SortedList ergates) {
			this.ergates = ergates;
		}

		public Zoo(String name,String poli){		//Constructors
			onomaZoo=name;
			poliZoo=poli;
			ergates=new SortedList();
			zwa=new SortedList();
		}
		
		public String getOnomaZoo() {
			return onomaZoo;
		}
		public void setOnomaZoo(String onomaZoo) {
			this.onomaZoo = onomaZoo;
		}
		public String getPoliZoo() {
			return poliZoo;
		}
		public void setPoliZoo(String poliZoo) {
			this.poliZoo = poliZoo;
		}
		
		public void printZoo(){			//Synartisi ektipwshs olon ton stoixeion tou zoologikou
			System.out.println("[Name of Zoo]: " +  onomaZoo + "\n[City of Zoo]: " + poliZoo+"\n");
			zwa.print();
			ergates.print();
		}
		
		public void eisagwgi2(Animals a){			//methodos pou dhmiourgei antikeimena animalItem kai ta eisxorei sth lista me ta zwa
			Item2=new AnimalItem(a);
			zwa.insert(Item2);
		}
		
		public void eisagwgi1(Workers b){		//methodos pou dhmiourgei antikeimena WorkerItem kai ta eisxorei sth lista me ta zwa
			Item1=new WorkerItem(b);
			ergates.insert(Item1);

		}
		
		public void termatismos(){		//katharismos kathe listas
			zwa.clearList();
			ergates.clearList();
		}
				
		public void diagrafi(int kodikos){		//methodos diagrafis me vasi ton afm.Afora ta zwa
			Item2=new AnimalItem(new Animals(kodikos));		//prwta dhmiourgoume antikeimena animalItem
			Node n=zwa.search(Item2);		//se metavliti komvou ta eisxoroume kai ta anazitoume sth lista zwa.
			if (n == null)
	            System.out.println("To zow me kodiko "+kodikos+" den vrethike sth lista");	//gia n=null dn iparxei o kodikos sth lista . den yparxei to zow
	        else{
	        	System.out.println("Vrethike to zow me kodiko: " + kodikos);//afou yparxei o kodikos diagrafoume ta stoixeia tou zwou
	        	zwa.delete(Item2);
	        	System.out.println("Epitixis diagrafi!");
	        }
			
		}
		
		public void anazitisi2(int kodikos){		//methodos anazitisis me vasi to seiriako kodiko.afora ta zoa
			Item2=new AnimalItem(new Animals(kodikos));//prwta dhmiourgoume antikeimena animalItem
			Node n=zwa.search(Item2);	//se metavliti komvou ta eisxoroume kai ta anazitoume sth lista zwa.
			if (n == null)
				System.out.println("To zow me kodiko "+kodikos+" den vrethike sth lista");//gia n=null dn iparxei o kodikos sth lista . den yparxei to zow
			else{
	        	System.out.println("Vrethike to zow me kodiko: " + kodikos); //afou yparxei o kodikos ektypwnoume ta stoixeia tou zoou
	        	n.ektipwsi();
	        }
		}
		
		public void anazitisi1(int kodikos){		//methodos anazitisis me vasi to afm .afora tous ergazomenous
			Item1=new WorkerItem(new Workers(kodikos));//prwta dhmiourgoume antikeimena workerItem
			Node n=ergates.search(Item1);//se metavliti komvou ta eisxoroume kai ta anazitoume sth lista ergates.
			if(n==null)
				System.out.println("O ergaths me kodiko "+kodikos+" den vrethike sth lista");//gia n=null dn iparxei o kodikos sth lista . den yparxei o ergaths
			else{
	        	System.out.println("Vrethike o ergaths me kodiko: " + kodikos);//afou yparxei o kodikos ektypwnoume ta stoixeia tou ergath
	        	n.ektipwsi();
			}
		}
		
		public void eidikoPrint(String className,String onoma){	//methodos pou kalei thn methodo PrintAllInHierarchy
			if(onoma.equalsIgnoreCase("Ergates")){				
                ergates.printAllInHierarchy(className);	//gia tous ergates
			}				
			else if(onoma.equalsIgnoreCase("Zwa")){		//gia ta zwa
				zwa.printAllInHierarchy(className);
			}
		}
		
		
		

		
}

