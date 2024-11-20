/*
            ======================================================
            + Name        : main.java                            +
            + Author      : Christos Z, 			             +
            + Description : Hospital data store                  +
            ======================================================
 */

import tuc.ece.cs102.util.*;
import java.util.Date;

public class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean temp=true;
		boolean flag=true;
		int menuAnswer,hospitalCounter=0,departmentsNumber=0;		// Initialization
		int examinationCounter1=0,examinationCounter2=0;			//counters doctors,exams, patients etc,
		int patientsCounter1=0,patientsCounter2=0;
		int doctorsCounter1=0,doctorsCounter2=0;
		int fileCounter1=0,fileCounter2=0,thesi=0;
		int examfileCounter1=0,examfileCounter2=0;
		float patSSN=0,findSSN=0;
		String hospitalName=null,examName=null,docName=null,docSpec=null,patName=null,fileTo=null,fileExamname=null,printAnswer=null,fileDocname=null,filePatname=null,answerMenu=null;
		Date makeDate,lastDate,firstDate;

		hospital[] listaApoNosokomeia;
		StandardInputRead keyboard = new StandardInputRead();       // Reading from keyboard object
		
		System.out.println("Welcome to the Hospital!\n");
		hospitalCounter=0;											//Hospital counter

		listaApoNosokomeia=new hospital[2];
		for(int i=0;i<2;i++){										//List of hospital. 2 hospitals allowed
			listaApoNosokomeia[i]=new hospital();
		}
		
		while(flag)//menu
		{
			System.out.println("\nMENU\n");
			System.out.println("1.Hospital data import");			
			System.out.println("2.Examination import");
			System.out.println("3.Doctor entry");
			System.out.println("4.Patient entry");
			System.out.println("5.Import of hospital record");
			System.out.println("6.Deletion of patient based on SSN");
			System.out.println("7.Finding a hospital record");
			System.out.println("8.Print data");
			System.out.println("9.Exit\n");
			
			do{
				menuAnswer=keyboard.readPositiveInt("Choose 1 of the options(1-9): "); //user's answer
			}while(menuAnswer<1 && menuAnswer>9);
			
			
			if(menuAnswer==1){
				if(hospitalCounter<2){		
					do{
						hospitalName=keyboard.readString("Type the name of the  hospital "+ (hospitalCounter+1) + ": ");
					}while(hospitalName==null);
					listaApoNosokomeia[hospitalCounter].setn_Hospital(hospitalName);	//Hospital name setter
					do{
						departmentsNumber=keyboard.readPositiveInt("Enter the number of its departments: ");
					}while(departmentsNumber==StandardInputRead.POS_ERROR);
					String[] hospitalDepartments=new String[departmentsNumber];			//Initialize hospital's departments
					for(int j=0;j<departmentsNumber;j++){
						do{
							hospitalDepartments[j]=keyboard.readString("Type the name of the department "+(j+1)+ ":");
						}while(hospitalDepartments[j]==null);
					}
					listaApoNosokomeia[hospitalCounter].setn_Departments(hospitalDepartments); 	
					
					hospitalCounter++;	//counter increment
				}
				else
					System.out.println("No other hospitals allowed!");			
			}
			if(menuAnswer==2){
				if(hospitalCounter==0)
					System.out.println("\nThere are no hospitals!");	//when there are hospitals, there is an init to patients, examinations, doctors
				else{					//hospital vars
					System.out.println("\nHospitals: ");
					for(int i=0;i<hospitalCounter;i++){													//The name given by the user must match the name of the hospital
						System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());			//Print available hospitals
					}
					do{																					//Hospitals for patient admission
						hospitalName=keyboard.readString("Enter the name of the hospital where you want to save the exam: ");
					}while(hospitalName==null);
					
					if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[0].getn_Hospital())){	//Data entry at the first hospital
						do{				//exam vars
							examName=keyboard.readString("Type the name of the exam "+ (examinationCounter1+1)+ " for the hospital: ");
						}while(examName==null);
						listaApoNosokomeia[0].examMethod(examName, examinationCounter1); 	
						examinationCounter1++;
																								//exam counter increment
					}
					else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getn_Hospital())){	//Data entry at the second hospital
						do{									
							examName=keyboard.readString("Type the name of the  exam "+ (examinationCounter2+1)+ " for the hospital: ");
						}while(examName==null);
						
						listaApoNosokomeia[1].examMethod(examName, examinationCounter2);
						examinationCounter2++;	
					}
					else
						System.out.println("Incorrect hospital. Try again!");	//No hospitals match the hospital in database
				}
			}
			if(menuAnswer==3){
				temp=true;
				if(hospitalCounter==0)
					System.out.println("\nThere are no hospitals!");
				else{
					System.out.println("Hospitals: ");
					for(int i=0;i<hospitalCounter;i++){			//		Print available hospitals
						System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());
					}
					do{												//Match hospitals with user answer
						hospitalName=keyboard.readString("Enter the name of the hospital where you want to save the doctor: ");
					}while(hospitalName==null);
					
					if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[0].getn_Hospital())){	//Match hospitals with user answer
						do{														//doctor vars
							docName=keyboard.readString("Type the name of the doctor "+ (doctorsCounter1+1)+ " for the hospital: ");
						}while(docName==null);
						temp=listaApoNosokomeia[1].findDoctor(docName, doctorsCounter2);	//Check if the doctor exists in the other hospital.
						if(temp==true){		//Condition true = doc do not exist in the other hospital
							do{
								docSpec=keyboard.readString("Type the specialty of the doctor " +(doctorsCounter1+1)+ " for the hospital: ");
							}while(docSpec==null);
								
							listaApoNosokomeia[0].docMethod(docName, docSpec, doctorsCounter1); //Doc init in the hospital
							doctorsCounter1++;
						}		
					}
					else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getn_Hospital())){//Doc init for the second hospital
						do{
							docName=keyboard.readString("Type the name of the doctor "+ (doctorsCounter2+1)+ " for the hospital: ");
						}while(docName==null);
						temp=listaApoNosokomeia[0].findDoctor(docName,doctorsCounter1);
						if(temp==true){
							do{
								docSpec=keyboard.readString("Type the specialty of the doctor " +(doctorsCounter2+1)+ " for the hospital: ");
							}while(docSpec==null);
							listaApoNosokomeia[1].docMethod(docName, docSpec, doctorsCounter2);
							doctorsCounter2++;
						}						
					}
					else
						System.out.println("Incorrect hospital. Try again!");
				}
			}
			if(menuAnswer==4){
					if(hospitalCounter==0)	//User has to choose option 1 at least once
						System.out.println("\nThere are no hospitals!");
					else{						
							System.out.println("Hospitals: ");
							for(int i=0;i<hospitalCounter;i++){
								System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());
							}
							do{					//Hospital selection
								hospitalName=keyboard.readString("Enter the name of the hospital where you want to save the patient: ");
							}while(hospitalName==null);
							
							if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[0].getn_Hospital())){
								do{
									patName=keyboard.readString("Type the name of the patient "+ (patientsCounter1+1)+ " for the hospital: ");
								}while(examName==null);
															//patient vars
								do{
									patSSN=keyboard.readPositiveFloat("Type SSN of the patient " +(patientsCounter1+1)+ " for the hospital: ");
								}while(patSSN==StandardInputRead.POS_ERROR);
								
								listaApoNosokomeia[0].patMethod(patName, patSSN, patientsCounter1);	//Patient init
								patientsCounter1++;			//patient counter increment
							}
							else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getn_Hospital())){ //Αdd patient to the second hospital
								do{
									patName=keyboard.readString("Type the name of the patient "+ (patientsCounter2+1)+ " for the hospital: ");
								}while(patName==null);
									
								do{
									patSSN=keyboard.readPositiveFloat("Type SSN of the patient " +(patientsCounter2+1)+ " for the hospital: ");
								}while(patSSN==StandardInputRead.POS_ERROR);
									
								listaApoNosokomeia[1].patMethod(patName, patSSN, patientsCounter2);
								patientsCounter2++;
							}
							else
								System.out.println("Incorrect hospital. Try again!");
					}
				}
				if(menuAnswer==5){
					if(examinationCounter1==0 && examinationCounter2==0)
						System.out.println("\nNo exams!");	//Controls
					if(doctorsCounter1==0 && doctorsCounter2==0)
						System.out.println("\nNo doctors!");		//One if statement is true, patient file cannot be made
					if(patientsCounter1==0 && patientsCounter2==0)
						System.out.println("\nNo patients!");
					
					if(hospitalCounter==0)
						System.out.println("\nNo hospitals available!");
					else{
						System.out.println("Hospitals: ");
						for(int i=0;i<hospitalCounter;i++){			//Print available hospitals
							System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());
						}
						do{
							fileTo=keyboard.readString("Enter the name of the hospital where you want to save the file:: ");
						}while(fileTo==null);
						
						if(fileTo.equalsIgnoreCase(listaApoNosokomeia[0].getn_Hospital())){
							do{//date in form dd/mm/year
								do{									//Control of import-export date. The first precedes the second
									firstDate=keyboard.readDate("Type the admission date of the patient: ");
								}while(firstDate==null);
								do{
									lastDate=keyboard.readDate("Type the export date of the patient: ");
								}while(lastDate==null);
							}while(firstDate.after(lastDate));
							listaApoNosokomeia[0].hos_Files[fileCounter1].setImportDate(firstDate);//Date init
							listaApoNosokomeia[0].hos_Files[fileCounter1].setExportDate(lastDate);
							listaApoNosokomeia[0].printExam(examinationCounter1);	//Printing of available tests from the corresponding hospital
							do{															//Exam number in file less than 5
								examfileCounter1=keyboard.readPositiveInt("\nType the number of exams in the file(less or equal to 5): ");
							}while(examfileCounter1==StandardInputRead.POS_ERROR && examfileCounter1<6);
							for(int i=0;i<examfileCounter1;i++){
								do{
									fileExamname=keyboard.readString("Type the name of the exam "+(i+1)+": ");
								}while(fileExamname==null);	//Exam with its execution date
								do{
									do{
										makeDate=keyboard.readDate("Type the date of the exam "+(i+1)+": ");
									}while(makeDate==null);	//Exams in file <=5			
									//Check date to be in range import date and export date
								}while(makeDate.compareTo(listaApoNosokomeia[0].hos_Files[fileCounter1].getImportDate())<0 && makeDate.compareTo(listaApoNosokomeia[0].hos_Files[fileCounter1].getExportDate())>0);
								listaApoNosokomeia[0].hos_Files[fileCounter1].examsDates[i]=makeDate;
								thesi=listaApoNosokomeia[0].findExam(fileExamname, examinationCounter1); //Find exam
								if(thesi==-1)		
									i--;
								else{				//If found we initialize the values for the exams in the file 
									listaApoNosokomeia[0].hos_Files[fileCounter1].examsDates[i]=makeDate;
									listaApoNosokomeia[0].hos_Files[fileCounter1].patientExams[i].setn_Examination(listaApoNosokomeia[0].hos_Exams[thesi].getn_Examination());
									listaApoNosokomeia[0].hos_Files[fileCounter1].patientExams[i].setc_Examination(listaApoNosokomeia[0].hos_Exams[thesi].getc_Examination());
								}
							}
							listaApoNosokomeia[0].printdoc(doctorsCounter1); //Print available doctors
							
							do{
								fileDocname=keyboard.readString("Enter the doctor who supervise the patient: ");
							}while (fileDocname==null);
										
							thesi=listaApoNosokomeia[0].findpatienddoctor(fileDocname, doctorsCounter1, fileCounter1);
							while(thesi==-1){	//Users types correct doctor
								do{
									fileDocname=keyboard.readString("Enter the doctor who supervise the patient: ");
								}while (fileDocname==null);
								thesi=listaApoNosokomeia[0].findpatienddoctor(fileDocname, doctorsCounter1, fileCounter1);
							}	//Init doctor records to the file
							listaApoNosokomeia[0].hos_Files[fileCounter1].doctorName.sets_Doctor(listaApoNosokomeia[0].hos_Doctors[thesi].gets_Doctor());
							listaApoNosokomeia[0].hos_Files[fileCounter1].doctorName.setn_Doctor(listaApoNosokomeia[0].hos_Doctors[thesi].getn_Doctor());
							listaApoNosokomeia[0].hos_Files[fileCounter1].doctorName.setc_Doctor(listaApoNosokomeia[0].hos_Doctors[thesi].getc_Doctor());
							
							listaApoNosokomeia[0].printpat(patientsCounter1);	//Print available patients
							do{
								filePatname=keyboard.readString("Enter the name of the patient to whom the file relates: ");
							}while(filePatname==null);	//Given a patient who is in hospital
							temp=listaApoNosokomeia[0].findPatient(filePatname, patientsCounter1, fileCounter1);
							while(temp==false){		
								do{
									filePatname=keyboard.readString("Enter the name of the patient to whom the file relates: ");
								}while(filePatname==null);
								temp=listaApoNosokomeia[0].findPatient(filePatname, patientsCounter1, fileCounter1);
							}
												//Search patient in hospital
							fileCounter1++;		//patient file counter increment
						}
						else if(fileTo.equalsIgnoreCase(listaApoNosokomeia[1].getn_Hospital())){	//Same procedure for hospital 2
							do{
								do{
									firstDate=keyboard.readDate("Type the admission date of the patient: ");
								}while(firstDate==null);
								do{
									lastDate=keyboard.readDate("Type the export date of the patient: ");
								}while(lastDate==null);
							}while(firstDate.after(lastDate));
							
							listaApoNosokomeia[1].hos_Files[fileCounter2].setImportDate(firstDate);
							listaApoNosokomeia[1].hos_Files[fileCounter2].setExportDate(lastDate);
							listaApoNosokomeia[1].printExam(examinationCounter2);
							do{
								examfileCounter2=keyboard.readPositiveInt("\nType the number of exams in the file(less or equal to 5):  ");
							}while(examfileCounter2==StandardInputRead.POS_ERROR &&examfileCounter2<6);
							for(int i=0;i<examfileCounter2;i++){
								do{
									fileExamname=keyboard.readString("Type the name of the exam "+(i+1)+" : ");
								}while(fileExamname==null);
								do{
									do{
										makeDate=keyboard.readDate("Type the date of the exam "+(i+1)+" : ");
									}while(makeDate==null);
								}while(makeDate.compareTo(listaApoNosokomeia[1].hos_Files[fileCounter2].getImportDate())<0 && makeDate.compareTo(listaApoNosokomeia[1].hos_Files[fileCounter2].getExportDate())>0);
								listaApoNosokomeia[1].hos_Files[fileCounter2].examsDates[i]=makeDate;
								thesi=listaApoNosokomeia[1].findExam(fileExamname, examinationCounter2);
								if(thesi==-1)
									i--;
								else{
									
									listaApoNosokomeia[1].hos_Files[fileCounter2].patientExams[i].setn_Examination(listaApoNosokomeia[1].hos_Exams[thesi].getn_Examination());
									listaApoNosokomeia[1].hos_Files[fileCounter2].patientExams[i].setc_Examination(listaApoNosokomeia[1].hos_Exams[thesi].getc_Examination());
								}
								
							}
							
							listaApoNosokomeia[1].printdoc(doctorsCounter2);
							do{
								fileDocname=keyboard.readString("Enter the doctor who supervise the patient: ");
							}while (fileDocname==null);
							
							while(thesi==-1){
								do{
									fileDocname=keyboard.readString("Enter the doctor who supervise the patient: ");
								}while (fileDocname==null);
								thesi=listaApoNosokomeia[1].findpatienddoctor(fileDocname, doctorsCounter2, fileCounter2);
							}
								
								
							listaApoNosokomeia[1].hos_Files[fileCounter2].doctorName.sets_Doctor(listaApoNosokomeia[1].hos_Doctors[thesi].gets_Doctor());
							listaApoNosokomeia[1].hos_Files[fileCounter2].doctorName.setn_Doctor(listaApoNosokomeia[1].hos_Doctors[thesi].getn_Doctor());
							listaApoNosokomeia[1].hos_Files[fileCounter2].doctorName.setc_Doctor(listaApoNosokomeia[1].hos_Doctors[thesi].getc_Doctor());
							
							listaApoNosokomeia[1].printpat(patientsCounter2);
							do{
								filePatname=keyboard.readString("Enter the name of the patient to whom the file relates: ");
							}while(filePatname==null);
							listaApoNosokomeia[1].findPatient(filePatname, patientsCounter2, fileCounter2);
							
							fileCounter2++;
						}
						else
							System.out.println("Incorrect hospital. Try again!");
						
						}
				}
				if(menuAnswer==6){
					if(patientsCounter1==0 && patientsCounter2==0)
						System.out.println("\nNo patients!");
					
					if(fileCounter1==0 && fileCounter2==0)
						System.out.println("\nNo records!");
					
					if(hospitalCounter==0)
						System.out.println("\nNo hospitals available!");
					else{
						System.out.println("Hospitals: ");
						for(int i=0;i<hospitalCounter;i++){			//Print available hospitals
							System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());
						}
						do{
							fileTo=keyboard.readString("Enter the hospital where the patient is located: ");
						}while(fileTo==null); //Print patients
						if(fileTo.equalsIgnoreCase(listaApoNosokomeia[0].getn_Hospital())){
							listaApoNosokomeia[0].printpat(patientsCounter1);
							do{												//SSN 
								patSSN=keyboard.readPositiveFloat("Enter the SSN of the patient you want to delete: ");
							}while(patSSN==StandardInputRead.POS_ERROR);
							int i=0;
							while ((i < patientsCounter1) && (patSSN!=listaApoNosokomeia[0].hos_Files[i].patientName.getSSN())){
								i++;	
							}
							if(i<fileCounter1){			//File found
								for(int k=i;k<(fileCounter1-1);k++)		//Shift elements one position front
									listaApoNosokomeia[0].hos_Files[k]=listaApoNosokomeia[0].hos_Files[k+1];
								listaApoNosokomeia[0].hos_Files[fileCounter1-1]=null;	//Relocate list, Last value with null
								System.out.println("The patient was successfully discharged");	//File deleted
								fileCounter1--; 	//Patient counter decrement
							}
							i=0;							//Same procedure for delete patient
							while ((i < patientsCounter1) && (patSSN!=listaApoNosokomeia[0].hos_Patients[i].getSSN())){
								i++;
							}
							if(i<patientsCounter1){
									for(int k=i;k<(patientsCounter1-1);k++)
										listaApoNosokomeia[0].hos_Patients[k]=listaApoNosokomeia[0].hos_Patients[k+1];
									listaApoNosokomeia[0].hos_Patients[patientsCounter1-1]=null;
									patientsCounter1--;
							}
							else
								System.out.println("Νο patient with this SSN in the hospital.!");
							
							
						}									//Same procedure for hospital 2
						else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getn_Hospital())){
							listaApoNosokomeia[1].printpat(patientsCounter2);
							do{
								patSSN=keyboard.readPositiveFloat("Enter the SSN of the patient you want to delete: ");
							}while(patSSN==StandardInputRead.POS_ERROR);
							int i=0;
							while ((i < fileCounter2) && (patSSN!=listaApoNosokomeia[1].hos_Files[i].patientName.getSSN())){
								i++;
							}
							if(i<fileCounter2){
								for(int k=i;k<fileCounter2-1;k++)
									listaApoNosokomeia[1].hos_Files[k]=listaApoNosokomeia[1].hos_Files[k+1];
								listaApoNosokomeia[1].hos_Files[fileCounter2-1]=null;
								System.out.println("There is no longer a hospital record with this SSN");
								
								fileCounter2--;
							}
							i=0;
							while ((i < patientsCounter2) && (patSSN!=listaApoNosokomeia[1].hos_Patients[i].getSSN())){
								i++;
							}
							if(i<patientsCounter2){
									for(int k=i;k<patientsCounter2-1;k++)
										listaApoNosokomeia[1].hos_Patients[k]=listaApoNosokomeia[1].hos_Patients[k+1];
									listaApoNosokomeia[1].hos_Patients[patientsCounter2-1]=null;
									System.out.println("The patient was successfully discharged");
									patientsCounter2--;
							}
							else
								System.out.println("Νο patient with this SSN in the hospital.!");
						}
						else
							System.out.println("Incorrect hospital. Try again!");
						
					}
				}
				
				if(menuAnswer==7){
					if(patientsCounter1==0 && patientsCounter2==0)	//Checks
						System.out.println("\nNo patients");
					if(fileCounter1==0 && fileCounter2==0)
						System.out.println("\nNo records!");
					
					if(hospitalCounter==0)
						System.out.println("\nNo hospitals!");
					else if(hospitalCounter >0 && ((fileCounter1!=0 || fileCounter2!=0))) {
						do{			//Search based on user answer
							answerMenu=keyboard.readString("\nType the criteria you want to use to find records\n1.SSN\n2.Hospital and date range(Hospital)\nType your answer: ");
						}while(answerMenu==null);
						if(answerMenu.equalsIgnoreCase("SNN")){
							do						//SNN
								findSSN=keyboard.readPositiveFloat("Enter the SNN: ");
							while(findSSN==StandardInputRead.POS_ERROR);
							
							if(hospitalCounter==1){	//Check first hospital
								for(int i=0;i<fileCounter1;i++){			//SNN match, print record
									if(listaApoNosokomeia[0].hos_Files[i].patientName.getSSN()==findSSN)
										listaApoNosokomeia[0].hos_Files[i].printFiles();
								}
							}else if(hospitalCounter==2){
								for(int k=0;k<fileCounter1;k++){	//Check seconds hospital
									if(listaApoNosokomeia[0].hos_Files[k].patientName.getSSN()==findSSN)
										listaApoNosokomeia[0].hos_Files[k].printFiles();
								}
								for(int y=0;y<fileCounter2;y++){
									if(listaApoNosokomeia[1].hos_Files[y].patientName.getSSN()==findSSN)
										listaApoNosokomeia[1].hos_Files[y].printFiles();
								}
							}
							
						}else if(answerMenu.equalsIgnoreCase("Hospital")){	//User answered Hospital with date range
							System.out.println("Hospitals: ");
							for(int i=0;i<hospitalCounter;i++){			//Print hospitals
								System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());
							}
							do{
								answerMenu=keyboard.readString("Type the name of the hospital to find a record: ");
							}while(answerMenu==null);
							if(answerMenu.equalsIgnoreCase(listaApoNosokomeia[0].getn_Hospital())){
										//User gives date range for search record
								do{
									firstDate=keyboard.readDate("Enter the length of hospital stay: ");
								}while(firstDate==null);	//In range [import date export date]
								do{
									lastDate=keyboard.readDate("Up to: ");
								}while(lastDate==null);
								for(int i=0;i<fileCounter1;i++){		//Then print its file
									if(firstDate.after(listaApoNosokomeia[0].hos_Files[i].getImportDate())&& lastDate.before(listaApoNosokomeia[0].hos_Files[i].getExportDate())){
										listaApoNosokomeia[0].hos_Files[i].printFiles();
									}
								}
								
							}			//Same procedure for the second hospital
							else if(answerMenu.equalsIgnoreCase(listaApoNosokomeia[1].getn_Hospital())){
								System.out.println("Hospitals: ");
								for(int i=0;i<hospitalCounter;i++){			//Print available hospitals
									System.out.println((i+1)+"."+listaApoNosokomeia[i].getn_Hospital());
								}
								do{
									firstDate=keyboard.readDate("Enter the length of hospital stay: ");
								}while(firstDate==null);
								do{
									lastDate=keyboard.readDate("Up to: ");
								}while(lastDate==null);
								for(int i=0;i<fileCounter2;i++){
									if(firstDate.after(listaApoNosokomeia[1].hos_Files[i].getImportDate())&& lastDate.before(listaApoNosokomeia[1].hos_Files[i].getExportDate())){
										listaApoNosokomeia[1].hos_Files[i].printFiles();
									}
								}
								
							}
							else
								System.out.println("Incorrect hospital. Try again!");
						}
					}
				}
				
				if(menuAnswer==8){
					if(hospitalCounter==0)
						System.out.println("\nNo hospitals!");
					else{
						for(int i=0;i<hospitalCounter;i++){		//Print hospital records
							listaApoNosokomeia[i].printhospital(listaApoNosokomeia[i].getn_Departments().length);
						}
						do{
							printAnswer=keyboard.readString("\nStats to print:\n1.Exams\n2.Doctors\n3.Patients\n4.Records\nType which of the above items you want to print (doctors etc.): ");
						}while(printAnswer==null);
						if(printAnswer.equalsIgnoreCase("Exams")){
							if(examinationCounter1==0 && examinationCounter2==0){
								System.out.println("No exams!");
							}				//Print exams
							else{
								if(examinationCounter1>0)
									listaApoNosokomeia[0].printExam(examinationCounter1);
								if(examinationCounter2>0)
									listaApoNosokomeia[1].printExam(examinationCounter2);
								

							}
						}
						else if(printAnswer.equalsIgnoreCase("Doctors")){
							if(doctorsCounter1==0 && doctorsCounter2==0){
								System.out.println("There are no doctors!");
							}
							else{
								if(doctorsCounter1>0)
									listaApoNosokomeia[0].printdoc(doctorsCounter1);
								if(doctorsCounter2>0)		//print doctors
									listaApoNosokomeia[1].printdoc(doctorsCounter2);
								
							}
							
						}
						else if(printAnswer.equalsIgnoreCase("Patients")){
							if(patientsCounter1==0 && patientsCounter2==0){
								System.out.println("There are no patients!");
							}
							else{
								if(patientsCounter1>0)
									listaApoNosokomeia[0].printpat(patientsCounter1);
								if(patientsCounter2>0)		//Print patients
									listaApoNosokomeia[1].printpat(patientsCounter2);
								
							}
							
						}
						else if(printAnswer.equalsIgnoreCase("Records")){
							if(fileCounter1==0 && fileCounter2==0){
								System.out.println("No records!");
							}
							else{
								if(fileCounter1>0){
										listaApoNosokomeia[0].printFile(fileCounter1);
													//Print files
								}
								if(fileCounter2>0){
										listaApoNosokomeia[1].printFile(fileCounter2);
								}
							}
						}
						else
							System.out.println("Incorrect element for search. Try again!");
					}
				}
				
				if(menuAnswer==9){								//Program termination
					flag=false;
					System.out.println("Exit Program!");
				}
			
		}
	}
}


