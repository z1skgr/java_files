

public class hospital {
	private String n_Hospital;
	private String[] n_Departments=new String[100];
	doctor[] hos_Doctors=new doctor[100];
	patient[] hos_Patients=new patient[100];
	patientFile[] hos_Files=new patientFile[100];
	examination[] hos_Exams=new examination[100];
	
	public hospital(){
		for(int i=0; i<100 ;i++)				// constructors hospital to initialize constructor doctors and exams and departments
		{	
			hos_Patients[i]=new patient();
			hos_Exams[i]=new examination();
			hos_Files[i]=new patientFile();
			hos_Doctors[i]=new doctor();

		}
	}
	
	public void printFile(int fileNumber){
			for(int i=0;i<fileNumber;i++){
				System.out.print((i+1)+ ". ");
				hos_Files[i].printFiles();
			}
			System.out.println("\n");
	}
	
	
	public void examMethod(String examName,int j){ /* Method to check exam number */
													/*=100 means no more exams available*/
		if(j==100){									/*<100 means exams can be added*/	
			System.out.println("We have reached the examination " + j + "th. No more is allowed.");
		}
		else if(j<100){
			classStaticCounter count=new classStaticCounter();
			hos_Exams[j].examinationMethod(examName,count);
			
		}
	}
	
	public void printExam(int examNumber){
		for(int i=0;i<examNumber;i++)		//Print examination of hospital
		{
			System.out.print((i+1) + ".\n");
			hos_Exams[i].printexam();
		}
	
		
	}
	
	public void docMethod(String docName,String docSpec,int j){
		
		if(j<100){
			classStaticCounter count=new classStaticCounter();	/*Method to check doctor number*/
			hos_Doctors[j].doctorMethod(docName,docSpec,count);/*<100 means add doctors to hospitals */
																	/*=100 means no more patients can added*/
		}													
		else if(j==100){										
			System.out.println("Error. The number of doctors you want to administrate is higher than 100!");
		}
	}
	
	public void printdoc(int docNumber){
		
		for(int i=0;i<docNumber;i++){		/*Method for printing doctors for each hospital*/
			System.out.print((i+1) + ".\n");
			hos_Doctors[i].printdoct();
		}
	}
	
	public void printhospital(int departmentsNumber){	//Method for printing statistics for hospital
		System.out.println("Hospital ("+this.n_Hospital+ ") with departments:");
		for(int i=0;i<departmentsNumber;i++)
		{
			System.out.println((i+1)+"." +this.n_Departments[i]);
		}
	}
	
	public void patMethod(String patName,Float AMKA,int j){//
		
		if(j<100){													/*Method*/
			hos_Patients[j].patientMethod(patName, AMKA);	/*<100 means we can add patients to hospital*/
		}																	/*=100 means no more patients can added*/
		else if(j==100){												
			System.out.println("Error. The number of patient you want to administrate is higher than 100 !!!");
	    }

    }

	public void printpat(int patNumber){
	
		for(int i=0;i<patNumber;i++){			//Print method
			System.out.print((i+1) + ".\n");      
			hos_Patients[i].printpat();
		}
	}
	
	public int findExam(String name,int sizeNumber)
	{											//Method to find exam in hospital
		int i=0;
        boolean found = false;    // set the boolean value to false until the key is found

        for (i=0;i<sizeNumber;i++){										
        	if (hos_Exams[i].getn_Examination().equalsIgnoreCase(name)){
        		found = true;  
                break;                  
            } 
        }  
     
        if (found==false)   //When found is true, the index of the location of key will be printed.       
        {                                                                                                 
        	System.out.println("The examination does not exist.");                                           
        	return -1;		                                                                                     
        }						                                                                                           
        else return i;				                                                                                          
                                                                                         
	}       
   	      
	
	public boolean findDoctor(String name,int sizeNumber) //Method to find doctor in hospital
	{
		int i=0;
        boolean found = true;    // set the boolean value to true until the key is found

        for (i=0;i<sizeNumber;i++){ 
                                                                  
        	if (hos_Doctors[i].getn_Doctor().equalsIgnoreCase(name)){        
        		found = false;                                             
        		break;                                                     
        	}                                                                
        }        
       
        if (found==false)   //When found is true, the index of the location of key will be printed.
        	System.out.println(name + " is already working in another hospital! " );
        
        return found;
	}
	
	public boolean findPatient(String name,int sizeNumber,int filenumber)//Method to find patient in hospital
	{
		int i=0;	
	    boolean found = false;    // set the boolean value to false until the key is found
	    for (i=0;i<sizeNumber;i++) {
            if (hos_Patients[i].getNameOfPatient().equalsIgnoreCase(name)) 
	    	{                                                              
	       		found = true;                                                 
	    	    break;                                                     
	        }                                                              
	    }    
	    if (found) {                                                                                                                                                   
	    				//If the patient is found, then we keep the patient's position in order to initialize the file based on the patient of the hospital                     
	     		hos_Files[filenumber].patientName.setNameOfPatient(name);                                                                                                 
	     		hos_Files[filenumber].patientName.setSSN(hos_Patients[i].getSSN());                                                                                       
	    }                                                                                                                                                            
	    else{                                                                                                                                                       
	        //Else does not exist                                 
	    	System.out.println("Patient does not exit!");         
	    }	
	    
	    return found;
	}
	
	public int findpatienddoctor(String name,int sizeNumber,int filenumber){
    	int i=0;
        boolean found = false;    // set the boolean value to true until the key is found

        for (i=0;i<sizeNumber;i++)
        {
               if (hos_Doctors[i].getn_Doctor().equalsIgnoreCase(name)) {

                       found = true;      
                       break;
               }
        }
        if (found)   //When found is true, the index of the location of key will be printed.
        {
        	hos_Files[filenumber].doctorName.setn_Doctor(name);
        	hos_Files[filenumber].doctorName.sets_Doctor(hos_Doctors[i].gets_Doctor());
        	hos_Files[filenumber].doctorName.setc_Doctor(hos_Doctors[i].getc_Doctor());
        	return i;
        }
        else{
        	System.out.println("O giatros pou pliktrologisate dn iparxei sto nosokomeio!");
        	return -1;
        }   	
    }
	
	
	public examination[] gethos_Exams() {		//Method set/gets
		return hos_Exams;
	}
										
	public void sethos_Exams(examination[] hos_Exams) {
		this.hos_Exams = hos_Exams;
	}

	public void sethos_Files(patientFile[] hos_Files) {
		this.hos_Files = hos_Files;
	}
	
	public String[] getn_Departments() {
		return n_Departments;
	}

	public void setn_Departments(String[] n_Departments) {
		this.n_Departments = n_Departments;
	}

	public String getn_Hospital() {
		return n_Hospital;
	}

	public void setn_Hospital(String n_Hospital) {
		this.n_Hospital = n_Hospital;
	}
		
	public doctor[] gethos_Doctors() {
			return hos_Doctors;
		}

	public void sethos_Doctors(doctor[] hos_Docs) {
			this.hos_Doctors = hos_Docs;
		}
	
	public patient[] gethos_Patients() {
			return hos_Patients;
		}

	public void sethos_Patients(patient[] hos_Patients) {
			this.hos_Patients = hos_Patients;
	}

	public patientFile[] gethos_Files() {
		return hos_Files;
	}

	
}
