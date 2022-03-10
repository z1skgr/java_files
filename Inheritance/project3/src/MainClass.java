//Χρήστος Ζήσκας ΑΜ 2014030191

import tuc.ece.cs102.util.*;
public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException {
		Zoo Zoologikos;			//METAVLITES
		String zooName,zooCity,employeeName,employeeType,departmentWork,eidosWork,animalName,animalType;
		String xromaFish,sximaFish,xromaWings,kalimaMethod,lizardType,onomaClass,onoma;
		int menuAnswer,lizardFoot,kodikos,kodikosDelete,kodikosSearch;
		float employeeAFM,lizardSpeed;
		boolean flag=true;

		
		StandardInputRead keyboard= new StandardInputRead();
		
		
		System.out.println("Welcome to the #3 project!\n");
																				//EISAGOGI ONOMATOS ZOO KAI POLIS POU YPARXEI
		do{
			zooName=keyboard.readString("Pliktrologiste to onoma tou zoologikou khpou: ");
		}while(zooName==null);
		do{
			zooCity=keyboard.readString("Pliktrologiste to onoma ths polhs pou filoxeneite o zoologikos khpos: ");
		}while(zooCity==null);
			
		Zoologikos=new Zoo(zooName,zooCity);		//Energopoieite o constructor
		
		while(flag){							//MENU
			System.out.println("\nMenu\n");
			System.out.println("1.Eisagwgi ergazomenou");
			System.out.println("2.Eisagwgi zwou");
			System.out.println("3.Diagrafi zwou");
			System.out.println("4.Anazitisi zwou me vasi ton seiriako kodiko");
			System.out.println("5.Anazitisi ergazomenou me vasi to AFM");
			System.out.println("6.Ektipwsi ton stoixeion kapoias sigkekrimenhs omadas");
			System.out.println("7.Ektipwsi olon ton stoixeion tou zoologikou");
			System.out.println("8.Exodos");
			
			do{	//APANTISI TOU USER
				menuAnswer=keyboard.readPositiveInt("\nPliktrologiste thn apantisi sas: ");
			}while(menuAnswer<1 || menuAnswer>8 || menuAnswer==StandardInputRead.POS_ERROR);
			
			if(menuAnswer==1){
				do{		//o xristis dinei ta stoixeia tou ergazomenou
					employeeName=keyboard.readString("Pliktrologiste to onoma tou ergazomenou: ");
				}while(employeeName==null);
				
				do{
					employeeAFM=keyboard.readPositiveFloat("Pliktrologiste to AΦΜ tou ergazomenou: ");
				}while(employeeAFM==StandardInputRead.POS_ERROR);
				
				do{		//o xristis apantaei th typou ergazomeno thelei na ekxorisei
					employeeType=keyboard.readString("Pliktrologiste ton typo tou ergazomenou(Assistant h Trainer): ");
				}while(employeeType==null);
							//Analoga me thn apantish tou dinei kai ta analoga stoixeia
				if(employeeType.equalsIgnoreCase("Assistant")){
					do{
						departmentWork=keyboard.readString("Pliktrologiste to tmhma ergasias tou ergazomenou: ");
					}while(departmentWork==null);
													//dhmiourgeite to antikeimeno
					Assistants voithos=new Assistants(employeeName,employeeAFM,departmentWork);
					Zoologikos.eisagwgi1(voithos);		//mesa sthn methodo dhmiourgeite to workerItem kai ekxorite sth lista
				}else if(employeeType.equalsIgnoreCase("Trainer")){
					do{		//h idia diadikasia gia tis ypoloipes katigories ergazomenou
						eidosWork=keyboard.readString("Pliktrologiste ton typo ergasias tou ergazomenou: ");
					}while(eidosWork==null);
					Trainers ekpedeuths=new Trainers(employeeName,employeeAFM,eidosWork);
					Zoologikos.eisagwgi1(ekpedeuths);
				}else
					System.out.println("O typos ergazomenou pou pliktrologisate dn yparxei!");
				
			}
			if(menuAnswer==2){
				do{		//Eisagogi stoixeion zoou
					animalName=keyboard.readString("Pliktrologiste to onoma tou zoou: ");
				}while(animalName==null);
				
				do{
					kodikos=keyboard.readPositiveInt("Pliktrologiste ton kodiko tou zwou: ");
				}while(kodikos==StandardInputRead.POS_ERROR);
				
				do{//typos zoou pou thelei o xristsi na eisagei
					animalType=keyboard.readString("Pliktrologiste to eidos tou zow(Fish,Bird,Lizard): ");
				}while(animalType==null);
				
				if(animalType.equalsIgnoreCase("Fish")){// o xristis eisagei ta stoixeia ton zoon analoga me ton typo ton zoon
					do{	
						xromaFish=keyboard.readString("Pliktrologiste to xroma tou psariou: ");
					}while(xromaFish==null);
					
					do{
						sximaFish=keyboard.readString("Pliktrologiste to sxhma tou psariou: ");
					}while(sximaFish==null);
					Fish psari=new Fish(animalName,kodikos,xromaFish,sximaFish);//dhmiourgeia antikeimenou typou fish
					Zoologikos.eisagwgi2(psari);	//eisagwgi animalItem sth lista animals 
				}else if(animalType.equalsIgnoreCase("Bird")){
					do{		//Akolouthoun idies diadikasies gia kathe typo zoou
						xromaWings=keyboard.readString("Pliktrologiste to xroma ton fteron: ");
					}while(xromaWings==null);
					
					Birds pouli=new Birds(animalName,kodikos,xromaWings);
					Zoologikos.eisagwgi2(pouli);
				}
				else if(animalType.equalsIgnoreCase("Lizard")){
					do{
						kalimaMethod=keyboard.readString("Pliktrologiste ton typo kelifous ths sauras: ");
					}while(kalimaMethod==null);
					
					lizardType=keyboard.readString("H saura exei podia h oxi((podia)h(oxi podia)): ");
					if(lizardType.equalsIgnoreCase("podia")){
						do{
							lizardFoot=keyboard.readPositiveInt("Pliktrologiste ton arithmo ton podio: ");
						}while(lizardFoot==StandardInputRead.POS_ERROR);
						
						Lizards_with_legs sauraMePodia=new Lizards_with_legs(animalName,kodikos,kalimaMethod,lizardFoot);
						Zoologikos.eisagwgi2(sauraMePodia);
					}
					else if(lizardType.equalsIgnoreCase("oxi podia")){
						do{
							lizardSpeed=keyboard.readPositiveFloat("Pliktrologiste thn max speed: ");
						}while(lizardSpeed==StandardInputRead.POS_ERROR);
						
						Lizards_with_noFoot sauraOxiPodia=new Lizards_with_noFoot(animalName,kodikos,kalimaMethod,lizardSpeed);
						Zoologikos.eisagwgi2(sauraOxiPodia);
					}
					else
						System.out.println("Den yparxei tetoio eidos sauras!");
				}
				else
					System.out.println("H kathgoria zoou pou pliktrologisate den yparxei!");
				
			}
			if(menuAnswer==3){
				Zoologikos.getZwa().print();
				do{	//o xristis epilegei ton kodiko tou zoou pou thelei na diagrapsei
					kodikosDelete=keyboard.readPositiveInt("Pliktrologiste to kodiko tou zow pou  thelete na diagrafei: ");
				}while(kodikosDelete==StandardInputRead.POS_ERROR);
				Zoologikos.diagrafi(kodikosDelete);	//energopoieite h methodos diagrafis
			}
			
			if(menuAnswer==4){
				do{		// o xristis epilegei ton kodiko tou zoou pou thelei na anazitisei
					kodikosSearch=keyboard.readPositiveInt("Pliktrologiste to kodiko tou zwou pou thelete na anazitisete: ");
				}while(kodikosSearch==StandardInputRead.POS_ERROR);
				Zoologikos.anazitisi2(kodikosSearch);		//energopoieite h methodos anazitisis gia ta zwa

			}
			
			if(menuAnswer==5){
				do{		//o xristis epilegei ton kodiko tou ergazomenou pou thelei na anazitisi
					kodikosSearch=keyboard.readPositiveInt("Pliktrologiste to AFM tou ergazomenou pou thelete na anazitisete: ");
				}while(kodikosSearch==StandardInputRead.POS_ERROR);
				Zoologikos.anazitisi1(kodikosSearch);//energopoieite h methodos anazitisis gia ta zwa

			}
			
			if(menuAnswer==6){
				do{	//o xristis epilegei poia kathgoria epithimei na ektipwsei
					onoma=keyboard.readString("1.Zwa\n2.Ergates\nPliktrologiste poio apo tis 2 kathgories epithimite gia ektipwsh grafontas to onoma ths: ");
				}while(onoma==null);
				if(onoma.equalsIgnoreCase("Zwa")){	//gia ta zwa borei na epilexei h ola ta zwa h kapoia kathgoria
					onomaClass=keyboard.readString("1.Fish\n2.Lizards\n3.Birds\n4.Animals(ola ta zwa)\nPliktrologiste poio apo ta parapanw stoixeia epithimeite gia ektipwsh grafontas to onoma tou: ");
					if(!onomaClass.equals("Fish")&&!onomaClass.equals("Birds")&&!onomaClass.equals("Lizards")&&!onomaClass.equals("Animals")){
						System.out.println("H apantish dn antistoixei se yparkto stoixeio");		//an dn isxyei h sinthiki dn yparxei to zow
					}else{
						Zoologikos.eidikoPrint(onomaClass,onoma); //methodos pou energopoiei thn methodo eidiko print pou energopoiei th methodo printAllinHierarch
					}
				}
				else if(onoma.equalsIgnoreCase("Ergates")){
					onomaClass=keyboard.readString("1.Assistants\n2.Trainers\n3.Workers(oloi oi ergates)\nPliktrologiste poio apo ta parapanw stoixeia epithimeite gia ektipwsh grafontas to onoma tou: ");
					if(!onomaClass.equals("Trainers") && !onomaClass.equals("Assistants")&& !onomaClass.equals("Workers")){
						System.out.println("H apantisi dn antistoixei se yparkto stoixei h exete pliktrologisei lanthasmena kapoio yparkto stoixeio."); //an dn isxyei dn yparxei to stoixeio
					}else{
						Zoologikos.eidikoPrint(onomaClass,onoma);	//methodos pou energopoiei thn methodo eidiko print pou energopoiei th methodo printAllinHierarch
					}
				}
				else
					System.out.println("H kathgoria pou pliktrologisate dn yparxei!");
				
			}
			
			if(menuAnswer==7){		//Apantisi 7 . Ektypononte ola ta stoixeia tou zoo.Energopoieite h methodos
				Zoologikos.printZoo();
			}
			
			if(menuAnswer==8){		//Apantisi 8 .Termatizei to programma . adeiazoun oi listes
				System.out.println("Termatismos Programmatos!");
				flag=false;
				Zoologikos.termatismos();
				
			}
			
		}
		
		
		
	}

}

