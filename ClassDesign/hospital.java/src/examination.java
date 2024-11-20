
public class examination {
	private String n_Examination; // name exam
	private int c_Examination; // code exam
	
	public void examinationMethod(String nExam,classStaticCounter cnt){	//Initialization
		n_Examination=nExam;
		c_Examination=classStaticCounter.getCounter();
		cnt.increment();
	}

	public void printexam(){
		System.out.println("Examination name: "+ n_Examination);		//Print examination
		System.out.println("Examination code: " +c_Examination);
	}
	
	public String getn_Examination() { //Getters - setters
		return n_Examination;
	}

	public void setn_Examination(String n_Examination) {
		this.n_Examination = n_Examination;
	}

	public int getc_Examination() {
		return c_Examination;
	}

	public void setc_Examination(int c_Examination) {
		this.c_Examination = c_Examination;
	}
}
