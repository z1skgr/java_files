/*
            ======================================================
            + Name        : main.java                            +
            + Author      : Christos Z, 			             +
            + Description : Zoo data store                  +
            ======================================================
 */


import tuc.ece.cs102.util.*;
public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException {
		Zoo Zoologikos;			//Vars
		String zooName,zooCity,employeeName,employeeType,departmentWork,typeWork,animalName,animalType;
		String colorFish,shapeFish,colorWings,shell,lizardType,temp,cat_k;
		int menuAnswer,lizardFoot,serial_c,del_code,sea_code;
		float employeeVAT,lizardSpeed;
		boolean flag=true;

		
		StandardInputRead keyboard= new StandardInputRead();
		
		
		System.out.println("Welcome to the Zoo!\n");
																				//Zoo and city
		do{
			zooName=keyboard.readString("Type the name of the zoo: ");
		}while(zooName==null);
		do{
			zooCity=keyboard.readString("Type the city where the zoo is located: ");
		}while(zooCity==null);
			
		Zoologikos=new Zoo(zooName,zooCity);		//Constructor
		
		while(flag){							//MENU
			System.out.println("\nMenu\n");
			System.out.println("1.Add employee");
			System.out.println("2.Add animal");
			System.out.println("3.Delete animal");
			System.out.println("4.Search animal by serial code");
			System.out.println("5.Search for an employee by VAT number");
			System.out.println("6.Printing items of a specific group");
			System.out.println("7.Print all elements of the zoo");
			System.out.println("8.Exit");
			
			do{	//User answer
				menuAnswer=keyboard.readPositiveInt("\nType your answer: ");
			}while(menuAnswer<1 || menuAnswer>8 || menuAnswer==StandardInputRead.POS_ERROR);
			
			if(menuAnswer==1){
				do{		//user gives employee's record
					employeeName=keyboard.readString("Type the name of the employee: ");
				}while(employeeName==null);
				
				do{
					employeeVAT=keyboard.readPositiveFloat("Type VAT number of the employee: ");
				}while(employeeVAT==StandardInputRead.POS_ERROR);
				
				do{		//The user answers what type of employee he/she wants to assign
					employeeType=keyboard.readString("Enter the type of employee (Assistant or Trainer): ");
				}while(employeeType==null);
							//Depending on the answer, it gives the corresponding data
				if(employeeType.equalsIgnoreCase("Assistant")){
					do{
						departmentWork=keyboard.readString("Enter the employee's work department: ");
					}while(departmentWork==null);
													//Make the object
					Assistants voithos=new Assistants(employeeName,employeeVAT,departmentWork);
					Zoologikos.Insert_Worker(voithos);		// method creates the worker item and assigns it to the list
				}else if(employeeType.equalsIgnoreCase("Trainer")){
					do{		//Same procedure for other workers 
						typeWork=keyboard.readString("Enter the worker's job type: ");
					}while(typeWork==null);
					Trainers ekpedeuths=new Trainers(employeeName,employeeVAT,typeWork);
					Zoologikos.Insert_Worker(ekpedeuths);
				}else
					System.out.println("The type of employee you typed does not exist!");
				
			}
			if(menuAnswer==2){
				do{		//Add animal records
					animalName=keyboard.readString("Type the name of the animal: ");
				}while(animalName==null);
				
				do{
					serial_c=keyboard.readPositiveInt("Enter the code of the animal: ");
				}while(serial_c==StandardInputRead.POS_ERROR);
				
				do{//animal type
					animalType=keyboard.readString("Type the type of animal (Fish,Bird,Lizard): ");
				}while(animalType==null);
				
				if(animalType.equalsIgnoreCase("Fish")){// records based their type
					do{	
						colorFish=keyboard.readString("Type the colour of the fish: ");
					}while(colorFish==null);
					
					do{
						shapeFish=keyboard.readString("Type the shape of the fish: ");
					}while(shapeFish==null);
					Fish psari=new Fish(animalName,serial_c,colorFish,shapeFish);//create object fish
					Zoologikos.Insert_Animal(psari);	//add animalitem in list
				}else if(animalType.equalsIgnoreCase("Bird")){
					do{		//Same procedure for all animal type
						colorWings=keyboard.readString("Type the color of the wings: ");
					}while(colorWings==null);
					
					Birds pouli=new Birds(animalName,serial_c,colorWings);
					Zoologikos.Insert_Animal(pouli);
				}
				else if(animalType.equalsIgnoreCase("Lizard")){
					do{
						shell=keyboard.readString("Enter the type of lizard shell: ");
					}while(shell==null);
					
					lizardType=keyboard.readString("Lizard with foot or not((foot) or (no foot)): ");
					if(lizardType.equalsIgnoreCase("podia")){
						do{
							lizardFoot=keyboard.readPositiveInt("Enter the number of feet: ");
						}while(lizardFoot==StandardInputRead.POS_ERROR);
						
						Lizards_with_legs sauraMePodia=new Lizards_with_legs(animalName,serial_c,shell,lizardFoot);
						Zoologikos.Insert_Animal(sauraMePodia);
					}
					else if(lizardType.equalsIgnoreCase("oxi podia")){
						do{
							lizardSpeed=keyboard.readPositiveFloat("Enter the maximum speed: ");
						}while(lizardSpeed==StandardInputRead.POS_ERROR);
						
						Lizards_with_noFoot sauraOxiPodia=new Lizards_with_noFoot(animalName,serial_c,shell,lizardSpeed);
						Zoologikos.Insert_Animal(sauraOxiPodia);
					}
					else
						System.out.println("There is no such thing as a lizard!");
				}
				else
					System.out.println("The animal category you entered does not exist!");
				
			}
			if(menuAnswer==3){
				Zoologikos.getAnimals().print();
				do{	//the user selects the code of the animal to be deleted
					del_code=keyboard.readPositiveInt("Enter the code of the animal you want to delete: ");
				}while(del_code==StandardInputRead.POS_ERROR);
				Zoologikos.Delete_Animal(del_code);	//delete method
			}
			
			if(menuAnswer==4){
				do{		// the user selects the code of the animal to be searched
					sea_code=keyboard.readPositiveInt("Enter the code of the animal you want to search: ");
				}while(sea_code==StandardInputRead.POS_ERROR);
				Zoologikos.Search_Animal(sea_code);		//search method for animals

			}
			
			if(menuAnswer==5){
				do{		//the user selects the code of the employee to be searched
					sea_code=keyboard.readPositiveInt("Enter the VAT number of the employee you want to search for: ");
				}while(sea_code==StandardInputRead.POS_ERROR);
				Zoologikos.Search_Worker(sea_code);//search method for employee

			}
			
			if(menuAnswer==6){
				do{	//The user selects a category he wishes to print
					cat_k=keyboard.readString("1.Animals\n2.Employees\nType which of the 2 categories you want to print by writing its name: ");
				}while(cat_k==null);
				if(cat_k.equalsIgnoreCase("Animals")){	//You can choose any category or all animals
					temp=keyboard.readString("1.Fish\n2.Lizards\n3.Birds\n4.All\nType which of the above you want to print by writing its name: ");
					if(!temp.equals("Fish")&&!temp.equals("Birds")&&!temp.equals("Lizards")&&!temp.equals("Αll")){
						System.out.println("The answer is not correct");		//wrong animal
					}else{
						Zoologikos.eidikoPrint(temp,cat_k); //Method that activates the print method that activates the PrintAllinHierarchy method
					}
				}
				else if(cat_k.equalsIgnoreCase("Employees")){
					temp=keyboard.readString("1.Assistants\n2.Trainers\n3.All\nType which of the above you want to print by writing its name: ");
					if(!temp.equals("Trainers") && !temp.equals("Assistants")&& !temp.equals("All")){
						System.out.println("The answer is not correct."); //wrong answer
					}else{
						Zoologikos.eidikoPrint(temp,cat_k);	//Method that activates the print method that activates the PrintAllinHierarchy method
					}
				}
				else
					System.out.println("The category you typed does not exist!");
				
			}
			
			if(menuAnswer==7){		//Print all elements of the zoo
				Zoologikos.printZoo();
			}
			
			if(menuAnswer==8){		//Program terminate
				System.out.println("Program Terminated!");
				flag=false;
				Zoologikos.terminate();
				
			}
			
		}
		
		
		
	}

}

