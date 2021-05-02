package orderedthreads;

public class WithThread {
	
	public static void main(String[] args) {
		int count = 1, n = 10;
		OrderedThreads ot = new OrderedThreads();
		OddThread thread1 = new OddThread(n, ot);
		EvenThread thread2 = new EvenThread(n, ot);
		thread1.start();
		thread2.start();
	}
}
