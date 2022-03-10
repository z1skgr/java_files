public class WorkerItem extends Item {
	private Workers wr;
	
	public WorkerItem(Workers wr){this.wr=wr;}
	public Object key() { return wr;}   
	
	public boolean equals(Item o) { return wr.getAFM()==((Workers)(o.key())).getAFM(); }
	public boolean less(Item o) {return wr.getAFM()<((Workers)(o.key())).getAFM();}
	
	public void print(){	//Methodos ektypwshs gia kathe antikeimeno typou ergath. Ektypononte ola ta stoixeia tou
		wr.printWorkers();
	}
	
	
	

	
}
