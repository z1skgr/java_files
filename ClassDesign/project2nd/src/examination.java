
public class examination {
	private String nameOfExamination;
	private int codeOfExamination;
	
	public void examinationMethod(String nameOfExam,classStaticCounter count){	//methodos arxikopoihshs to metavliton ths exetashs
		nameOfExamination=nameOfExam;
		codeOfExamination=classStaticCounter.getCounter();
		count.increment();
		}

	public void printexam(){
		System.out.println("Onoma exetashs: "+ nameOfExamination);		//ektipwsh ton metavlitwn ektipwshs
		System.out.println("Kodikos exetashs: " +codeOfExamination);
	}
	
	public String getNameOfExamination() {
		return nameOfExamination;
	}

	public void setNameOfExamination(String nameOfExamination) {
		this.nameOfExamination = nameOfExamination;
	}

	public int getCodeOfExamination() {
		return codeOfExamination;
	}

	public void setCodeOfExamination(int codeOfExamination) {
		this.codeOfExamination = codeOfExamination;
	}
}
