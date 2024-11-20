import java.util.Date;

public class patientFile {
	patient patientName; //patient name
	doctor doctorName;  // doctor name
	Date importDate;    //date in to hospital
	Date exportDate;    //date out from hospital
	examination[] patientExams=new examination[5]; //examinations
	Date[] examsDates=new Date[5]; //examination dates
	
	public patientFile(){		//constructor
		patientName=new patient();
		doctorName=new doctor();
		for(int i=0;i<5;i++){
			patientExams[i]=new examination();
			examsDates[i]=new Date();
		}
	}
	
	public patient getPatientName() {		//getters setters
		return patientName;
	}
	public void setPatientName(patient patientName) {
		this.patientName = patientName;
	}
	public doctor getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(doctor doctorName) {
		this.doctorName = doctorName;
	}
	public Date getImportDate() {
		return importDate;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public Date getExportDate() {
		return exportDate;
	}
	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}
	public examination[] getPatientExams() {
		return patientExams;
	}
	public void setPatientExams(examination[] patientExams) {
		this.patientExams = patientExams;
	}
	public Date[] getExamsDates() {
		return examsDates;
	}
	public void setExamsDates(Date[] examsDates) {
		this.examsDates = examsDates;
	}
	
	public void fileMethod(String examName,Date makeDate,int j,int examCode){
		patientExams[j].setn_Examination(examName);
		patientExams[j].setc_Examination(examCode);		//Initialize
		examsDates[j]=makeDate;
		
	}
	public void printFiles(){
		for(int i=0;i<5;i++){
			System.out.println(examsDates[i]);	//Print patient
			patientExams[i].printexam();
		}
		System.out.println("Patient name: "+patientName.getNameOfPatient());
		System.out.println("Patient's social security number: "+patientName.getSSN());
		System.out.println("Doctor name: "+doctorName.getn_Doctor());
		System.out.println("Doctor specialty:"+doctorName.gets_Doctor());
		System.out.println("Doctor code: "+doctorName.getc_Doctor());
		System.out.println(importDate);
		System.out.println(exportDate);
	}
}
