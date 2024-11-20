
public class patient {
	private String nameOfPatient; //name
	private float SSN;           // social security number
	
	public String getNameOfPatient() {		//getters setters
		return nameOfPatient;
	}
	public void setNameOfPatient(String nameOfPat) {
		nameOfPatient = nameOfPat;
	}
	public float getSSN() {
		return SSN;
	}
	public void setSSN(float ssn) {
		SSN = ssn;
	}
	
	public void patientMethod(String nameOfPat,float ssn){
			nameOfPatient=nameOfPat;			//Initialize patient data
			SSN=ssn;
	}
	
	public void printpat(){
		System.out.println("Patient name: "+nameOfPatient);
		System.out.println("Patient's social security number: "+SSN);
	}

}
