package orderedthreads;

public class EvenThread extends Thread {
	int n;
	OrderedThreads ot;
	
	public EvenThread(int n, OrderedThreads ot)
	{
		this.n = n;
		this.ot = ot;
	}

	public void run()                       
    {   
		while (ot.count <= n) {
			synchronized (ot) {
				while (ot.count % 2 == 1) {
					try {
						ot.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (ot.count <= n)
					System.out.println(ot.count);
				ot.count++;
				ot.notify();
			}
		}
    }
}
