
public class patient {
	private String nameOfPatient;
	private float AMKA;
	
	public String getNameOfPatient() {		//getters setters
		return nameOfPatient;
	}
	public void setNameOfPatient(String nameOfPat) {
		nameOfPatient = nameOfPat;
	}
	public float getAMKA() {
		return AMKA;
	}
	public void setAMKA(float amka) {
		AMKA = amka;
	}
	
	public void patientMethod(String nameOfPat,float amka){
			nameOfPatient=nameOfPat;			//arxikopoihsh metavliton asthenh
			AMKA=amka;
	}
	
	public void printpat(){
		System.out.println("Onoma asthenh: "+nameOfPatient);
		System.out.println("AMKA asthenh: "+AMKA);
	}

}
