

public class hospital {
	private String nameOfHospital;
	private String[] nameOfDepartments=new String[100];
	doctor[] hospitalDocs=new doctor[100];
	patient[] hospitalPatients=new patient[100];
	patientFile[] hospitalFiles=new patientFile[100];
	examination[] hospitalExams=new examination[100];
	
	public hospital(){
		for(int i=0; i<100 ;i++)				//dhmiourgia constructors otan energopoieite o constructor ths hospital
		{	
			hospitalPatients[i]=new patient();
			hospitalExams[i]=new examination();
			hospitalFiles[i]=new patientFile();
			hospitalDocs[i]=new doctor();

		}
	}
	
	public void printFile(int fileNumber){
			for(int i=0;i<fileNumber;i++){
				System.out.print((i+1)+ ". ");
				hospitalFiles[i].printFiles();
			}
			System.out.println("\n");
		}
	
	
	public void examMethod(String examName,int j){ /* otan energopoieite h methodos elegxei an*/
													/*einai mikroteros o arithmos ton exetaseon  kai tote arxikopoiei tis times*/
		if(j==100){									/*energopoiontas trith methodo*/	//orio 100
			System.out.println("Exoume ftasei sthn " + j +"h exetasi.Den epitreponte alles!");
		}
		else if(j<100){
			classStaticCounter count=new classStaticCounter();
			hospitalExams[j].examinationMethod(examName,count);
			
		}
	}
	
	public void printExam(int examNumber){
		for(int i=0;i<examNumber;i++)		//methodos ektipwshs exetaseon
		{
			System.out.print((i+1) + ".\n");
			hospitalExams[i].printexam();
		}
	
		
	}
	
	public void docMethod(String docName,String docSpec,int j){
		
		if(j<100){
			classStaticCounter count=new classStaticCounter();	/*otan energopoieite h methodos elegxei an*/
			hospitalDocs[j].doctorMethod(docName,docSpec,count);/*einai mikroteros o arithmos ton giatron kai arxikopoiei tis times*/
		}													/*energopoiontas allh methodo*/
		else if(j==100){										//orio 100
				System.out.println("Error. The number of doctors you want to administrate is higher than 100!");
			}
		}
	public void printdoc(int docNumber){
		
		for(int i=0;i<docNumber;i++){		/*methodos ektipwshs giatron*/
			System.out.print((i+1) + ".\n");
			hospitalDocs[i].printdoct();
			}
		}
	
	public void printhospital(int departmentsNumber){	//methodo ektipwshs stoixeion nosokomeio
		System.out.println("Nosokomeio ("+this.nameOfHospital+ ") me tmhmata:");
		for(int i=0;i<departmentsNumber;i++)
		{
			System.out.println((i+1)+"." +this.nameOfDepartments[i]);
		}
	}
	
	public void patMethod(String patName,Float AMKA,int j){//
		
		if(j<100){													/*otan energopoieite h methodos elegxei an*/
			hospitalPatients[j].patientMethod(patName, AMKA);	/*einai mikroteros o arithmos ton asthenwn kai arxikopoiei tis times*/
		}																	/*energopoiontas allh methodo*/
		else if(j==100){												//orio 100
			System.out.println("Error. The number of patient you want to administrate is higher than 100 !!!");
	}

}

	public void printpat(int patNumber){
	
	for(int i=0;i<patNumber;i++){			//methodos ektipwshs asthenwn
		System.out.print((i+1) + ".\n");
		hospitalPatients[i].printpat();
		}
	}
	
	public int findExam(String name,int sizeNumber)
	{											//h methodos xrisimopoieite gia na dixoume oti h apantish tou xristi yparxei sto nosokomeio
		int i=0;
        boolean found = false;    // set the boolean value to false until the key is found

        for (i=0;i<sizeNumber;i++)
        {										//h methodos vasizete sth siriakh anaziti(sequential search)
               if (hospitalExams[i].getNameOfExamination().equalsIgnoreCase(name))
              {
                       found = true;      
                       break;
               }
         }

        if (found==false)   //When found is true, the index of the location of key will be printed.
        {
        	System.out.println("H exetash pou pliktrologisate dn yparxei!!.");
        	return -1;		//h timh found kathorizei to apotelesma
        }						//epistrefete -1 otan dn exoun antistoixia h exetash kai to onoma
        else				// epistrefei thn timh sthn opoia einai ises otan 
        	return i;
	}
	
	public boolean findDoctor(String name,int sizeNumber)
	{
		int i=0;
        boolean found = true;    // set the boolean value to true until the key is found

        for (i=0;i<sizeNumber;i++)
        {
               if (hospitalDocs[i].getNameOfDoctor().equalsIgnoreCase(name))
              {
                       found = false;      
                       break;
               }
         }
        if (found==false)   //When found is true, the index of the location of key will be printed.
        	System.out.println(name + " is already working in another hospital! " );
        
        return found;
	}
	
	public boolean findPatient(String name,int sizeNumber,int filenumber)
	{
			int i=0;	//xrisimopoieite h methodos gia thn anazitisi tou astthen sto nosokomeio
	        boolean found = false;    // set the boolean value to false until the key is found
	        for (i=0;i<sizeNumber;i++)
	        {
	        	if (hospitalPatients[i].getNameOfPatient().equalsIgnoreCase(name))
	        	{
	                       found = true;      
	                       break;
	        	}
	        }
	     if (found)   
	     {				//an vrethei o astheneis tote kratame th thesi tou oste na arxikopoihsoume me vasi ton asthenh tou nosokomeiou ton fakelo
	     		hospitalFiles[filenumber].patientName.setNameOfPatient(name);
	     		hospitalFiles[filenumber].patientName.setAMKA(hospitalPatients[i].getAMKA());
	     }
	     else
	     {			//an dn isxuei h sinthikh dn iparxei o asthenhs
	    	 System.out.println("O asthenhs pou plhktrologisate dn iparxei!");
	     }
	     return found;
	}
	
	public int findpatienddoctor(String name,int sizeNumber,int filenumber){
    	int i=0;
        boolean found = false;    // set the boolean value to true until the key is found

        for (i=0;i<sizeNumber;i++)
        {
               if (hospitalDocs[i].getNameOfDoctor().equalsIgnoreCase(name))
              {
                       found = true;      
                       break;
               }
         }
        if (found)   //When found is true, the index of the location of key will be printed.
        {
        	hospitalFiles[filenumber].doctorName.setNameOfDoctor(name);
        	hospitalFiles[filenumber].doctorName.setSpecialtyOfDoctor(hospitalDocs[i].getSpecialtyOfDoctor());
        	hospitalFiles[filenumber].doctorName.setCodeOfDoctor(hospitalDocs[i].getCodeOfDoctor());
        	return i;
        }
        else{
        	System.out.println("O giatros pou pliktrologisate dn iparxei sto nosokomeio!");
        	return -1;
        }   	
    }
	
	
	public examination[] getHospitalExams() {		//dhmiourgeia methodon arxikopoihshs set/gets
		return hospitalExams;
	}
										
	public void setHospitalExams(examination[] hospitalExams) {
		this.hospitalExams = hospitalExams;
	}

	public void setHospitalFiles(patientFile[] hospitalFiles) {
		this.hospitalFiles = hospitalFiles;
	}
	
	public String[] getNameOfDepartments() {
		return nameOfDepartments;
	}

	public void setNameOfDepartments(String[] nameOfDepartments) {
		this.nameOfDepartments = nameOfDepartments;
	}

	public String getNameOfHospital() {
		return nameOfHospital;
	}

	public void setNameOfHospital(String nameOfHospital) {
		this.nameOfHospital = nameOfHospital;
	}
		
	public doctor[] getHospitalDocs() {
			return hospitalDocs;
		}

	public void setHospitalDocs(doctor[] hospitalDocs) {
			this.hospitalDocs = hospitalDocs;
		}
	
	public patient[] getHospitalPatients() {
			return hospitalPatients;
		}

	public void setHospitalPatients(patient[] hospitalPatients) {
			this.hospitalPatients = hospitalPatients;
	}

	public patientFile[] getHospitalFiles() {
		return hospitalFiles;
	}

	
}
