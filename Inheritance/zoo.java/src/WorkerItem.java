public class WorkerItem extends Item {
	private Workers wr;
	
	public WorkerItem(Workers wr){this.wr=wr;}
	public Object key() { return wr;}   
	
	public boolean equals(Item o) { return wr.getVAT()==((Workers)(o.key())).getVAT(); }
	public boolean less(Item o) {return wr.getVAT()<((Workers)(o.key())).getVAT();}
	
	public void print(){	//Printing method 
		wr.printWorkers();
	}
	
	
	

	
}
