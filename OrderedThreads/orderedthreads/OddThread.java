package orderedthreads;

public class OddThread extends Thread {
	int n;
	OrderedThreads ot;
	
	public OddThread(int n, OrderedThreads ot)
	{
		this.n = n;
		this.ot = ot;
	}

	public void run()                       
    {   
		while (ot.count <= n) {
			synchronized (ot) {
				while (ot.count % 2 == 0) {
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
