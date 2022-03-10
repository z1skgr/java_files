//Xristos Ziskas
//AM 2014030191

import tuc.ece.cs102.util.*;
import java.util.Date;

public class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean temp=true;
		boolean flag=true;
		int menuAnswer,hospitalCounter=0,departmentsNumber=0;		// dilwsh metavliton kai pinakon
		int examinationCounter1=0,examinationCounter2=0;
		int patientsCounter1=0,patientsCounter2=0;
		int doctorsCounter1=0,doctorsCounter2=0;
		int fileCounter1=0,fileCounter2=0,thesi=0;
		int examfileCounter1=0,examfileCounter2=0;
		float patAMKA=0,findAMKA=0;
		String hospitalName=null,examName=null,docName=null,docSpec=null,patName=null,fileTo=null,fileExamname=null,printAnswer=null,fileDocname=null,filePatname=null,answerMenu=null;
		Date makeDate,lastDate,firstDate;

		hospital[] listaApoNosokomeia;
		StandardInputRead keyboard = new StandardInputRead();       //dhmiourgia antikeimenou typou standardinputread
		
		System.out.println("Welcome to the #2 project!\n");
		hospitalCounter=0;											//metriths nosokomeion

		listaApoNosokomeia=new hospital[2];
		for(int i=0;i<2;i++){										//dhmiourgia constructor hospital
			listaApoNosokomeia[i]=new hospital();
		}
		
		while(flag)//menu
		{	
			System.out.println("\nMENU\n");
			System.out.println("1.Eisagogi stoixeion nosokomeiou");			
			System.out.println("2.Eisagogi exetasis");
			System.out.println("3.Eisagogi iatrou");
			System.out.println("4.Eisagogi asthenous");
			System.out.println("5.Eisagogi fakelou noshleias");
			System.out.println("6.Diagrafi asthenous me vasi to AMKA");
			System.out.println("7.Euresi fakelou noshleias");
			System.out.println("8.Ektiposi stoixeion");
			System.out.println("9.Exodos\n");
			
			do{
				menuAnswer=keyboard.readPositiveInt("Dialexte 1 apo tis epiloges(1-9): "); //h apantisi tou xristi
			}while(menuAnswer<1 && menuAnswer>9);
			
			
			if(menuAnswer==1){
				if(hospitalCounter<2){		
					do{
					hospitalName=keyboard.readString("Pliktrologiste to onoma tou "+ (hospitalCounter+1) + "ou nosokomeiou: ");
					}while(hospitalName==null);
					listaApoNosokomeia[hospitalCounter].setNameOfHospital(hospitalName);	//arxikopoihsh tou onomatos tou nosokomeiou me setters
					do{
						departmentsNumber=keyboard.readPositiveInt("Pliktrologiste ton arithmo ton tmhmaton tou: ");
					}while(departmentsNumber==StandardInputRead.POS_ERROR);
					String[] hospitalDepartments=new String[departmentsNumber];			//dhmiourgia tou pinaka departments
					for(int j=0;j<departmentsNumber;j++){
						do{
						hospitalDepartments[j]=keyboard.readString("Pliktrologiste to onoma tou "+(j+1)+ "ou tmhmatos: ");
						}while(hospitalDepartments[j]==null);
					}
					listaApoNosokomeia[hospitalCounter].setNameOfDepartments(hospitalDepartments); 	//idia taktikh gia ta tmhmata me th voithia ton setters
					
					hospitalCounter++;	//auxanete o metriths
				}
				else
					System.out.println("Den epitreponte alla nosokomeia!");			
			}
			if(menuAnswer==2){
				if(hospitalCounter==0)
					System.out.println("\nDen yparxoun nosokomeia!");	//prepi na yparxoun nosokomeia gia na yparxoun exetaseis,astheneis kai giatroi
				else{					//metavlhtes nosokomeiou
					System.out.println("\nNosokomeia: ");
					for(int i=0;i<hospitalCounter;i++){										//prepei na teriazei to onoma p dinei o xristis m to onoma tou nosokomeiou
						System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());//ektipwnoume ta diathesima nosokomeia
					}
					do{																					//zhteite se poio nosokomeio theloume na ginei h eisagwgi
					hospitalName=keyboard.readString("Pliktrologiste to onoma tou nosokomeiou pou thelete na apothikeusete thn exetasi: ");
					}while(hospitalName==null);
					
					if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[0].getNameOfHospital())){	//mas endiaferei na einai akrivws to idio onoma anexarthta peza kefalaia
						do{//metavlites exetashs
						examName=keyboard.readString("Pliktrologiste to onoma ths "+ (examinationCounter1+1)+ "hs exetashs gia to nosokomeio: ");
						}while(examName==null);
						listaApoNosokomeia[0].examMethod(examName, examinationCounter1); 	//xrisimopoioume th methodo 
						examinationCounter1++;
																								//auxanoume ton metrith gia tis exetashs
					}
					else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getNameOfHospital())){	//idia diadikasia efoson iparxei deutero nosokomeio
						do{									
						examName=keyboard.readString("Pliktrologiste to onoma ths "+ (examinationCounter2+1)+ "hs exetashs gia to nosokomeio: ");
						}while(examName==null);
						
						listaApoNosokomeia[1].examMethod(examName, examinationCounter2);
						examinationCounter2++;	
					}
					else
						System.out.println("Lathos pliktrologisi nosokomeiou!Xanaprospathiste!");	//se antitheti periptwsi sfalma
				}
			}
			if(menuAnswer==3){
				temp=true;
				if(hospitalCounter==0)
					System.out.println("\nDen yparxoun nosokomeia!");
				else{
					System.out.println("Nosokomeia: ");
					for(int i=0;i<hospitalCounter;i++){			//ektipwnoume diathesima nosokomeia
						System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());
					}
					do{												//prepei na teriazei to onoma p dinei o xristis m to onoma tou nosokomeiou
					hospitalName=keyboard.readString("Pliktrologiste to onoma tou nosokomeiou pou thelete na apothikeusete ton giatro: ");
					}while(hospitalName==null);
					
					if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[0].getNameOfHospital())){	//o xristis prepei na dwsei sosto onoma
						do{														//metavlites giatrou
						docName=keyboard.readString("Pliktrologiste to onoma tou "+ (doctorsCounter1+1)+ "ou giatrou gia to nosokomeio: ");
						}while(docName==null);
						temp=listaApoNosokomeia[1].findDoctor(docName, doctorsCounter2);	//elegxoume an o giatros yparxei sto allo nosokomeio efoson yparxei
						if(temp==true){		//h sinthikh true mas enhmerwnei oti  dn yparxei sto allo nosokomeio o giatros
							do{
							docSpec=keyboard.readString("Pliktrologiste thn eidikothta tou " +(doctorsCounter1+1)+ "ou giatrou to nosokomeiou: ");
							}while(docSpec==null);
								
							listaApoNosokomeia[0].docMethod(docName, docSpec, doctorsCounter1); //energopoieite h methodos gia arxikopoihsh ton metavliton tou giatrou tou nosokomeiou
							doctorsCounter1++;
						}		
					}
					else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getNameOfHospital())){//idia diadikasia gia to 2o nosokomeio
						do{
						docName=keyboard.readString("Pliktrologiste to onoma tou "+ (doctorsCounter2+1)+ "ou giatrou gia to nosokomeio: ");
						}while(docName==null);
						temp=listaApoNosokomeia[0].findDoctor(docName,doctorsCounter1);
						if(temp==true){
							do{
							docSpec=keyboard.readString("Pliktrologiste thn eidikothta tou " +(doctorsCounter2+1)+ "ou giatrou gia to nosokomeio: ");
							}while(docSpec==null);
							listaApoNosokomeia[1].docMethod(docName, docSpec, doctorsCounter2);
							doctorsCounter2++;
						}						
					}
					else
						System.out.println("Lathos pliktrologisi nosokomeiou!Xanaprospathiste!");
				}
			}
			if(menuAnswer==4){
					if(hospitalCounter==0)	//prepei o xrisths na exei epilexei toulaxiston 1fora thn epilogh 1
						System.out.println("\nDen yparxoun nosokomeia!");
					else{						
							System.out.println("Nosokomeia: ");
							for(int i=0;i<hospitalCounter;i++){
								System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());
							}
							do{					//prepei na teriazei to onoma tou xristi m auto apo kapoio nosokomeio
							hospitalName=keyboard.readString("Pliktrologiste to onoma tou nosokomeiou pou thelete na apothikeusete ton asthenh: ");
							}while(hospitalName==null);
							
							if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[0].getNameOfHospital())){
								do{
								patName=keyboard.readString("Pliktrologiste to onoma tou "+ (patientsCounter1+1)+ "ou asthenh gia to nosokomeio: ");
								}while(examName==null);
															//metavlites asthenwn
								do{
								patAMKA=keyboard.readPositiveFloat("Pliktrologiste to AMKA tou " +(patientsCounter1+1)+ "ou asthenh gia to nosokomeiou: ");
								}while(patAMKA==StandardInputRead.POS_ERROR);
								
								listaApoNosokomeia[0].patMethod(patName, patAMKA, patientsCounter1);	//methodos arxikopoihshs
								patientsCounter1++;			//auxanete o metrhths ton asthenwn
							}
							else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getNameOfHospital())){ //idia diadikasia gia to 2o nosokomeio
								do{
								patName=keyboard.readString("Pliktrologiste to onoma tou "+ (patientsCounter2+1)+ "ou asthenh gia to nosokomeio: ");
								}while(patName==null);
									
								do{
								patAMKA=keyboard.readPositiveFloat("Pliktrologiste to AMKA tou " +(patientsCounter2+1)+ "ou asthenh gia to nosokomeiou: ");
								}while(patAMKA==StandardInputRead.POS_ERROR);
									
								listaApoNosokomeia[1].patMethod(patName, patAMKA, patientsCounter2);
								patientsCounter2++;
							}
							else
								System.out.println("Lathos pliktrologisi nosokomeiou!Xanaprospathiste!");
					}
				}
				if(menuAnswer==5){
					if(examinationCounter1==0 && examinationCounter2==0)
						System.out.println("\nDen yparxoun exetaseis!");	//elegxoi
					if(doctorsCounter1==0 && doctorsCounter2==0)
						System.out.println("\nDen yparxoun giatroi!");		//efoson kapoio apo auta dn isxuei dn boroume na dhmiourghsoume fakelous
					if(patientsCounter1==0 && patientsCounter2==0)
						System.out.println("\nDen yparxoun asthenois!");
					
					if(hospitalCounter==0)
						System.out.println("\nDen yparxoun nosokomeia!");
					else{
						System.out.println("Nosokomeia: ");
						for(int i=0;i<hospitalCounter;i++){			//ektipwnoume ta diathesima nosokomeia me getters
							System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());
						}
						do{
						fileTo=keyboard.readString("Pliktrologiste to nosokomeio pou thelete na apothikeusete to fakelo: ");
						}while(fileTo==null);
						
						if(fileTo.equalsIgnoreCase(listaApoNosokomeia[0].getNameOfHospital())){
							do{
								do{									//hmeromhnies eisagwgis-exagwgis asthenh(elegxos h mia prin apo thn allh)
								firstDate=keyboard.readDate("Pliktrologiste thn hmeromhnia eisagwgis tou asthenh: ");
								}while(firstDate==null);
								do{
								lastDate=keyboard.readDate("Pliktrologiste thn hmeromhnia exagwgis tou asthenh: ");
								}while(lastDate==null);
							}while(firstDate.after(lastDate));
							listaApoNosokomeia[0].hospitalFiles[fileCounter1].setImportDate(firstDate);//arxikopoihsh ton hmeromhnion
							listaApoNosokomeia[0].hospitalFiles[fileCounter1].setExportDate(lastDate);
							listaApoNosokomeia[0].printExam(examinationCounter1);	//ektipwsh ton diathesimon exetaseon tou antistoixou nosokomeiou
							do{															//dexomaste ton arithmo ton exetaseon mikrotero tou 5
								examfileCounter1=keyboard.readPositiveInt("Pliktrologiste ton arithmo ton exetaseon tou fakelou(mikrotero-iso tou 5): ");
							}while(examfileCounter1==StandardInputRead.POS_ERROR && examfileCounter1<6);
							for(int i=0;i<examfileCounter1;i++){
								do{
								fileExamname=keyboard.readString("Pliktrologiste thn "+(i+1)+"h exetash pou thelete na pragmatopoihthei: ");
								}while(fileExamname==null);	//gia kathe exetash pernoume mia hmeromhnia kai ena onoma
								do{
									do{
									makeDate=keyboard.readDate("Pliktrologiste thn hmeromhnia pragmatopoihshs ths "+(i+1)+"hs exetashs: ");
									}while(makeDate==null);	//orio exetaseon s kathe fakelo =5			//elegxos tou mhna oste na einai anamesa sthn import kai export Date
								}while(makeDate.compareTo(listaApoNosokomeia[0].hospitalFiles[fileCounter1].getImportDate())<0 && makeDate.compareTo(listaApoNosokomeia[0].hospitalFiles[fileCounter1].getExportDate())>0);
								listaApoNosokomeia[0].hospitalFiles[fileCounter1].examsDates[i]=makeDate;
								thesi=listaApoNosokomeia[0].findExam(fileExamname, examinationCounter1); //energopoihte h methodos
								if(thesi==-1)		//an dn vrethei epistrefoume sthn proigoumenh prospathia
									i--;
								else{				//an vrethei arxikopoioume tis times  gia tis exetaseis ston fakelon me tin voithia ton antikeimenon ths class hospital
									listaApoNosokomeia[0].hospitalFiles[fileCounter1].examsDates[i]=makeDate;
									listaApoNosokomeia[0].hospitalFiles[fileCounter1].patientExams[i].setNameOfExamination(listaApoNosokomeia[0].hospitalExams[thesi].getNameOfExamination());
									listaApoNosokomeia[0].hospitalFiles[fileCounter1].patientExams[i].setCodeOfExamination(listaApoNosokomeia[0].hospitalExams[thesi].getCodeOfExamination());
								}
							}
							listaApoNosokomeia[0].printdoc(doctorsCounter1); //ektipwnoume tous diathesimous giatrous
							
							do{
								fileDocname=keyboard.readString("Pliktrologiste ton giatro pou parakolouthhse ton asthenh: ");
							}while (fileDocname==null);
										//energopoieite h methodos
							thesi=listaApoNosokomeia[0].findpatienddoctor(fileDocname, doctorsCounter1, fileCounter1);
							while(thesi==-1){	//ekteleite h methodos mexri o xristis na eisagei sosto onoma giatrou
								do{
									fileDocname=keyboard.readString("Pliktrologiste ton giatro pou parakolouthhse ton asthenh: ");
								}while (fileDocname==null);
								thesi=listaApoNosokomeia[0].findpatienddoctor(fileDocname, doctorsCounter1, fileCounter1);
							}	//arxikopoiounte ta stoixeia tou giatrou sto fakelo
							listaApoNosokomeia[0].hospitalFiles[fileCounter1].doctorName.setSpecialtyOfDoctor(listaApoNosokomeia[0].hospitalDocs[thesi].getSpecialtyOfDoctor());
							listaApoNosokomeia[0].hospitalFiles[fileCounter1].doctorName.setNameOfDoctor(listaApoNosokomeia[0].hospitalDocs[thesi].getNameOfDoctor());
							listaApoNosokomeia[0].hospitalFiles[fileCounter1].doctorName.setCodeOfDoctor(listaApoNosokomeia[0].hospitalDocs[thesi].getCodeOfDoctor());
							
							listaApoNosokomeia[0].printpat(patientsCounter1);	//ektipwnoume tous diathesimous asthenois
							do{
								filePatname=keyboard.readString("Pliktrologiste to onoma tou asthenh pou afora o fakelos: ");
							}while(filePatname==null);	//ekteleite h methodos mexri na dwsei o xristis onoma asthenh pou na vriskete sto nosokomeio
							temp=listaApoNosokomeia[0].findPatient(filePatname, patientsCounter1, fileCounter1);
							while(temp==false){		
								do{
								filePatname=keyboard.readString("Pliktrologiste to onoma tou asthenh pou afora o fakelos: ");
								}while(filePatname==null);
								temp=listaApoNosokomeia[0].findPatient(filePatname, patientsCounter1, fileCounter1);
							}
										//h methodos kanei anazitisi tou giatrou sto nosokomeio
							fileCounter1++;		//auxanete o metrhths ton fakelon tou nosokomeiou
						}
						else if(fileTo.equalsIgnoreCase(listaApoNosokomeia[1].getNameOfHospital())){	//idia diadikasia gia to deutero nosokomeio
							do{
								do{
								firstDate=keyboard.readDate("Pliktrologiste thn hmeromhnia eisagwgis tou asthenh: ");
								}while(firstDate==null);
								do{
								lastDate=keyboard.readDate("Pliktrologiste thn hmeromhnia exagwgis tou asthenh: ");
								}while(lastDate==null);
							}while(firstDate.after(lastDate));
							
							listaApoNosokomeia[1].hospitalFiles[fileCounter2].setImportDate(firstDate);
							listaApoNosokomeia[1].hospitalFiles[fileCounter2].setExportDate(lastDate);
							listaApoNosokomeia[1].printExam(examinationCounter2);
							do{
								examfileCounter2=keyboard.readPositiveInt("Pliktrologiste ton arithmo ton exetaseon tou fakelou(mikrotero-iso tou 5): ");
							}while(examfileCounter2==StandardInputRead.POS_ERROR &&examfileCounter2<6);
							for(int i=0;i<examfileCounter2;i++){
								do{
								fileExamname=keyboard.readString("Pliktrologiste thn "+(i+1)+"h exetash pou thelete na pragmatopoihthei: ");
								}while(fileExamname==null);
								do{
									do{
									makeDate=keyboard.readDate("Pliktrologiste thn hmeromhnia pragmatopoihshs ths "+(i+1)+"hs exetashs: ");
									}while(makeDate==null);
								}while(makeDate.compareTo(listaApoNosokomeia[1].hospitalFiles[fileCounter2].getImportDate())<0 && makeDate.compareTo(listaApoNosokomeia[1].hospitalFiles[fileCounter2].getExportDate())>0);
								listaApoNosokomeia[1].hospitalFiles[fileCounter2].examsDates[i]=makeDate;
								thesi=listaApoNosokomeia[1].findExam(fileExamname, examinationCounter2);
								if(thesi==-1)
									i--;
								else{
									
									listaApoNosokomeia[1].hospitalFiles[fileCounter2].patientExams[i].setNameOfExamination(listaApoNosokomeia[1].hospitalExams[thesi].getNameOfExamination());
									listaApoNosokomeia[1].hospitalFiles[fileCounter2].patientExams[i].setCodeOfExamination(listaApoNosokomeia[1].hospitalExams[thesi].getCodeOfExamination());
								}
								
							}
							
							listaApoNosokomeia[1].printdoc(doctorsCounter2);
							do{
							fileDocname=keyboard.readString("Pliktrologiste ton giatro pou parakolouthhse ton asthenh: ");
							}while (fileDocname==null);
							
							while(thesi==-1){
								do{
									fileDocname=keyboard.readString("Pliktrologiste ton giatro pou parakolouthhse ton asthenh: ");
								}while (fileDocname==null);
								thesi=listaApoNosokomeia[1].findpatienddoctor(fileDocname, doctorsCounter2, fileCounter2);
							}
								
								
							listaApoNosokomeia[1].hospitalFiles[fileCounter2].doctorName.setSpecialtyOfDoctor(listaApoNosokomeia[1].hospitalDocs[thesi].getSpecialtyOfDoctor());
							listaApoNosokomeia[1].hospitalFiles[fileCounter2].doctorName.setNameOfDoctor(listaApoNosokomeia[1].hospitalDocs[thesi].getNameOfDoctor());
							listaApoNosokomeia[1].hospitalFiles[fileCounter2].doctorName.setCodeOfDoctor(listaApoNosokomeia[1].hospitalDocs[thesi].getCodeOfDoctor());
							
							listaApoNosokomeia[1].printpat(patientsCounter2);
							do{
							filePatname=keyboard.readString("Pliktrologiste to onoma tou asthenh pou afora o fakelos: ");
							}while(filePatname==null);
							listaApoNosokomeia[1].findPatient(filePatname, patientsCounter2, fileCounter2);
							
							fileCounter2++;
						}
						else
							System.out.println("Lathos pliktrologisi nosokomeiou!Xanaprospathiste!");
						
						}
				}
				if(menuAnswer==6){
					if(patientsCounter1==0 && patientsCounter2==0)
						System.out.println("\nDen yparxoun asthenois");
					
					if(fileCounter1==0 && fileCounter2==0)
						System.out.println("\nDen yparxoun fakeloi!");
					
					if(hospitalCounter==0)
						System.out.println("\nDen yparxoun nosokomeia!");
					else{
						System.out.println("Nosokomeia: ");
						for(int i=0;i<hospitalCounter;i++){			//ektipwnoume ta diathesima nosokomeia me getters
							System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());
						}
						do{
						fileTo=keyboard.readString("Pliktrologiste to nosokomeio pou sto opoio vriskete o asthenhs: ");
						}while(fileTo==null); //efoson oi metavlites simfwnoun to prog ektipwnei tous astheneis
						if(fileTo.equalsIgnoreCase(listaApoNosokomeia[0].getNameOfHospital())){
							listaApoNosokomeia[0].printpat(patientsCounter1);
							do{												//zhtaei to zhtoumeno amka
							patAMKA=keyboard.readPositiveFloat("Pliktrologiste to AMKA tou asthenous pou thelete na diagrapsete: ");
							}while(patAMKA==StandardInputRead.POS_ERROR);
							int i=0;
							while ((i < patientsCounter1) && (patAMKA!=listaApoNosokomeia[0].hospitalFiles[i].patientName.getAMKA())){
								i++;				//elegxos an exei vrethei to amka
							}
							if(i<fileCounter1){			//an vrethei
								for(int k=i;k<(fileCounter1-1);k++)		//antimetatheoume tis times apo ekei kai epeite thn mia me
									listaApoNosokomeia[0].hospitalFiles[k]=listaApoNosokomeia[0].hospitalFiles[k+1];
								listaApoNosokomeia[0].hospitalFiles[fileCounter1-1]=null;	//h teleutea arxikopoieite me null
								System.out.println("O asthenhs diagrapthike me epityxia");	//diagrafete o fekelos me to zhtoumeno amka
								fileCounter1--; 	//meionete o metritis ton fakelon
							}
							i=0;							//h idia diadikasia gia thn diagrafi asthenous
							while ((i < patientsCounter1) && (patAMKA!=listaApoNosokomeia[0].hospitalPatients[i].getAMKA())){
								i++;
							}
							if(i<patientsCounter1){
									for(int k=i;k<(patientsCounter1-1);k++)
										listaApoNosokomeia[0].hospitalPatients[k]=listaApoNosokomeia[0].hospitalPatients[k+1];
									listaApoNosokomeia[0].hospitalPatients[patientsCounter1-1]=null;
									patientsCounter1--;
							}
							else
								System.out.println("Den yparxei asthenhs me tetoio amka sto nosokomeio!");
							
							
						}									//i idia diadikasia gia to allo nosokomeio
						else if(hospitalName.equalsIgnoreCase(listaApoNosokomeia[1].getNameOfHospital())){
							listaApoNosokomeia[1].printpat(patientsCounter2);
							do{
							patAMKA=keyboard.readPositiveFloat("Pliktrologiste to AMKA tou asthenous pou thelete na diagrapsete: ");
							}while(patAMKA==StandardInputRead.POS_ERROR);
							int i=0;
							while ((i < fileCounter2) && (patAMKA!=listaApoNosokomeia[1].hospitalFiles[i].patientName.getAMKA())){
								i++;
							}
							if(i<fileCounter2){
								for(int k=i;k<fileCounter2-1;k++)
									listaApoNosokomeia[1].hospitalFiles[k]=listaApoNosokomeia[1].hospitalFiles[k+1];
								listaApoNosokomeia[1].hospitalFiles[fileCounter2-1]=null;
								System.out.println("Den yparxei pia fakelos noshleias me to sygkekrimeno amka");
								
								fileCounter2--;
							}
							i=0;
							while ((i < patientsCounter2) && (patAMKA!=listaApoNosokomeia[1].hospitalPatients[i].getAMKA())){
								i++;
							}
							if(i<patientsCounter2){
									for(int k=i;k<patientsCounter2-1;k++)
										listaApoNosokomeia[1].hospitalPatients[k]=listaApoNosokomeia[1].hospitalPatients[k+1];
									listaApoNosokomeia[1].hospitalPatients[patientsCounter2-1]=null;
									System.out.println("O asthenhs diagrapthike me epityxia");
									patientsCounter2--;
							}
							else
								System.out.println("Den yparxei asthenhs me tetoio amka sto nosokomeio!");
						}
						else
							System.out.println("Lathos pliktrologish nosokomeiou.Xanaprospathiste!");
						
					}
				}
				
				if(menuAnswer==7){
					if(patientsCounter1==0 && patientsCounter2==0)	//elegxoi
						System.out.println("\nDen yparxoun asthenois");
					if(fileCounter1==0 && fileCounter2==0)
						System.out.println("\nDen yparxoun fakeloi!");
					
					if(hospitalCounter==0)
						System.out.println("\nDen yparxoun nosokomeia!");
					else{
						do{			//rotate o xristis gia ton tropo euresis fakelon
						answerMenu=keyboard.readString("Pliktrologiste me vasi pio kritirio thelete na ginei h euresi fakelon\n1.Amka\n2.Nosokomeio kai xroniko euros(Nosokomeio)\nPliktrologiste thn apantish sas: ");
						}while(answerMenu==null);
						if(answerMenu.equalsIgnoreCase("Amka")){
							do						//to zhtoumeno amka
							findAMKA=keyboard.readPositiveFloat("Pliktrologiste to amka pou anazhtate: ");
							while(findAMKA==StandardInputRead.POS_ERROR);
							
							if(hospitalCounter==1){	//elegxos sto prwto nosokomeio
								for(int i=0;i<fileCounter1;i++){			//an ta amka sympiptoun tipwnoume to sygkekrimeno fakelo
									if(listaApoNosokomeia[0].hospitalFiles[i].patientName.getAMKA()==findAMKA)
										listaApoNosokomeia[0].hospitalFiles[i].printFiles();
								}
							}else if(hospitalCounter==2){
								for(int k=0;k<fileCounter1;k++){	//elegxos kai sta dio nosokomeia
									if(listaApoNosokomeia[0].hospitalFiles[k].patientName.getAMKA()==findAMKA)
										listaApoNosokomeia[0].hospitalFiles[k].printFiles();
								}
								for(int y=0;y<fileCounter2;y++){
									if(listaApoNosokomeia[1].hospitalFiles[y].patientName.getAMKA()==findAMKA)
										listaApoNosokomeia[1].hospitalFiles[y].printFiles();
								}
							}
							
						}else if(answerMenu.equalsIgnoreCase("Nosokomeio")){	//tropos eureshs nosokomeia kai xronos
							System.out.println("Nosokomeia: ");
							for(int i=0;i<hospitalCounter;i++){			//ektipwnoume ta diathesima nosokomeia me getters
								System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());
							}
							do{
							answerMenu=keyboard.readString("Pliktrologiste to onoma tou nosokomeiou gia thn euresh fakelou: ");
							}while(answerMenu==null);
							if(answerMenu.equalsIgnoreCase(listaApoNosokomeia[0].getNameOfHospital())){
										//zhtate o xristis na dwsei to diasthma pou apaitei
								do{
									firstDate=keyboard.readDate("Pliktrologiste to diasthma noshleias sto nosokomeio: ");
								}while(firstDate==null);	//prepei to diasthma auto na vriskete anamesa sthn hm/eisagwghs kai exagwghs tou asthenh
								do{
									lastDate=keyboard.readDate("mexri: ");
								}while(lastDate==null);
								for(int i=0;i<fileCounter1;i++){		//tote ekteipwnete o fakelos t
									if(firstDate.after(listaApoNosokomeia[0].hospitalFiles[i].getImportDate())&& lastDate.before(listaApoNosokomeia[0].hospitalFiles[i].getExportDate())){
										listaApoNosokomeia[0].hospitalFiles[i].printFiles();
									}
								}
								
							}			//antistixh diadikasia gia to deutero nosokomeio
							else if(answerMenu.equalsIgnoreCase(listaApoNosokomeia[1].getNameOfHospital())){
								System.out.println("Nosokomeia: ");
								for(int i=0;i<hospitalCounter;i++){			//ektipwnoume ta diathesima nosokomeia me getters
									System.out.println((i+1)+"."+listaApoNosokomeia[i].getNameOfHospital());
								}
								do{
									firstDate=keyboard.readDate("Pliktrologiste to diasthma noshleias sto nosokomeio: ");
								}while(firstDate==null);
								do{
									lastDate=keyboard.readDate("mexri: ");
								}while(lastDate==null);
								for(int i=0;i<fileCounter2;i++){
									if(firstDate.after(listaApoNosokomeia[1].hospitalFiles[i].getImportDate())&& lastDate.before(listaApoNosokomeia[1].hospitalFiles[i].getExportDate())){
										listaApoNosokomeia[1].hospitalFiles[i].printFiles();
									}
								}
								
							}
							else
								System.out.println("Pliktrologisate lathos nosokomeio!");
						}
					}
				}
				
				if(menuAnswer==8){
					if(hospitalCounter==0)
						System.out.println("\nDen yparxoun nosokomeia!");
					else{
						for(int i=0;i<hospitalCounter;i++){		//ektipwsh stoixeion nosokomeiou
							listaApoNosokomeia[i].printhospital(listaApoNosokomeia[i].getNameOfDepartments().length);
						}
						do{
						printAnswer=keyboard.readString("\nStoixeia pros ektipwsh:\n1.Exetaseis\n2.Iatroi\n3.Asthenois\n4.Fakeloi\nPliktrologiste poio apo ta parapanw stoixeia thelete na ektipwsete(px Iatroi): ");
						}while(printAnswer==null);
						if(printAnswer.equalsIgnoreCase("Exetaseis")){
							if(examinationCounter1==0 && examinationCounter2==0){
								System.out.println("Den yparxoun exetaseis!");
							}				//ektipwsh exetaseon
							else{
								if(examinationCounter1>0)
									listaApoNosokomeia[0].printExam(examinationCounter1);
								if(examinationCounter2>0)
									listaApoNosokomeia[1].printExam(examinationCounter2);
								

							}
						}
						else if(printAnswer.equalsIgnoreCase("Iatroi")){
							if(doctorsCounter1==0 && doctorsCounter2==0){
								System.out.println("Den yparxoun giatroi!");
							}
							else{
								if(doctorsCounter1>0)
									listaApoNosokomeia[0].printdoc(doctorsCounter1);
								if(doctorsCounter2>0)		//ektipwsh giatron
									listaApoNosokomeia[1].printdoc(doctorsCounter2);
								
							}
							
						}
						else if(printAnswer.equalsIgnoreCase("Asthenois")){
							if(patientsCounter1==0 && patientsCounter2==0){
								System.out.println("Den yparxoun asthenois!");
							}
							else{
								if(patientsCounter1>0)
									listaApoNosokomeia[0].printpat(patientsCounter1);
								if(patientsCounter2>0)		//ektipwsh asthenwn
									listaApoNosokomeia[1].printpat(patientsCounter2);
								
							}
							
						}
						else if(printAnswer.equalsIgnoreCase("Fakeloi")){
							if(fileCounter1==0 && fileCounter2==0){
								System.out.println("Den yparxoun fakeloi!");
							}
							else{
								if(fileCounter1>0){
										listaApoNosokomeia[0].printFile(fileCounter1);
													//ektipwsh fakelon
								}
								if(fileCounter2>0){
										listaApoNosokomeia[1].printFile(fileCounter2);
								}
							}
						}
						else
							System.out.println("Pliktrologisate lathos stoixeio!Xanaprospathiste!");
					}
				}
				
				if(menuAnswer==9){								//h apanthsh prokalh termatismo tou programmatos
					flag=false;
					System.out.println("Termatismos Programmatos!");
				}
			
		}
	}
}


