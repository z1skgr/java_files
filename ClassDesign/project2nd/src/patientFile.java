import java.util.Date;

public class patientFile {
	patient patientName;
	doctor doctorName;
	Date importDate;
	Date exportDate;
	examination[] patientExams=new examination[5];
	Date[] examsDates=new Date[5];
	
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
		patientExams[j].setNameOfExamination(examName);
		patientExams[j].setCodeOfExamination(examCode);		//arxikopoihsh timwn fakelou
		examsDates[j]=makeDate;
		
	}
	public void printFiles(){
		for(int i=0;i<5;i++){
			System.out.println(examsDates[i]);	//ektipwsh fakelou
			patientExams[i].printexam();
		}
		System.out.println("Onoma asthenh: "+patientName.getNameOfPatient());
		System.out.println("AMKA asthenh: "+patientName.getAMKA());
		System.out.println("Onoma giatrou: "+doctorName.getNameOfDoctor());
		System.out.println("Eidikothta giatrou :"+doctorName.getSpecialtyOfDoctor());
		System.out.println("Kodikos giatrou: "+doctorName.getCodeOfDoctor());
		System.out.println(importDate);
		System.out.println(exportDate);
	}
}
