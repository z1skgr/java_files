
public class doctor {
	private String nameOfDoctor;
	private String specialtyOfDoctor;
	private int codeOfDoctor;



	public void doctorMethod(String nameOfDoc, String specOfDoc,classStaticCounter count) {
		nameOfDoctor = nameOfDoc;				//arxikopoioume tis times kai energopoioume thn static methodo gia ton kodiko
		specialtyOfDoctor = specOfDoc;
		codeOfDoctor = classStaticCounter.getCounter();
		count.increment();
		}
	
	public void printdoct(){
		System.out.println("Onoma giatrou: "+nameOfDoctor);		//ektipwsh stoixeion giatrou
		System.out.println("Kodikos giatrou: "+codeOfDoctor);
		System.out.println("Eidikothta giatrou: "+specialtyOfDoctor);
	}
	
	public String getNameOfDoctor() {		//getters setters
		return nameOfDoctor;
	}

	public void setNameOfDoctor(String nameOfDoctor) {
		this.nameOfDoctor = nameOfDoctor;
	}

	public String getSpecialtyOfDoctor() {
		return specialtyOfDoctor;
	}

	public void setSpecialtyOfDoctor(String specialtyOfDoctor) {
		this.specialtyOfDoctor = specialtyOfDoctor;
	}

	public int getCodeOfDoctor() {
		return codeOfDoctor;
	}

	public void setCodeOfDoctor(int codeOfDoctor) {
		this.codeOfDoctor = codeOfDoctor;
	}


}
