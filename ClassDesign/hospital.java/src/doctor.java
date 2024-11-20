
public class doctor {
	private String n_Doctor; //name doc
	private String s_Doctor; //specialty doc
	private int c_Doctor; //code doc



	public void doctorMethod(String nDoc, String sDoc,classStaticCounter cnt) {
		n_Doctor = nDoc;				// Initialization and activate the static method for the code
		s_Doctor = sDoc;
		c_Doctor = classStaticCounter.getCounter();
		cnt.increment();
	}
	
	public void printdoct(){
		System.out.println("Doctor Name: "+n_Doctor);		//Print doctor
		System.out.println("Doctor Code: "+c_Doctor);
		System.out.println("Speciality doctor: " +s_Doctor);
	}
	
	public String getn_Doctor() {		//getters setters
		return n_Doctor;
	}

	public void setn_Doctor(String n_Doctor) {
		this.n_Doctor = n_Doctor;
	}

	public String gets_Doctor() {
		return s_Doctor;
	}

	public void sets_Doctor(String s_Doctor) {
		this.s_Doctor = s_Doctor;
	}

	public int getc_Doctor() {
		return c_Doctor;
	}

	public void setc_Doctor(int c_Doctor) {
		this.c_Doctor = c_Doctor;
	}


}
