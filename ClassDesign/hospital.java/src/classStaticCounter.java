public class classStaticCounter {
	static int counter=1000;		//Assigning a code to doctors and examinations
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
