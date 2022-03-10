
public class classStaticCounter {
	 static int counter=1000;		//methodos anatheshs kodikou se giatrous kai exetaseis
	   public void increment()
	   {
	       counter++;
	   }
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		classStaticCounter.counter = counter;
	}
	   
}
