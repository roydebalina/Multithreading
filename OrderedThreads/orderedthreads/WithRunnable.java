package orderedthreads;

public class OrderedThreads {
	static Integer n = new Integer(10);
	int count = 1;

	public static void main(String[] args) {
		OrderedThreads ot = new OrderedThreads();
		Runnable firstThread = new Runnable() {
			public void run() {
				while (ot.count <= n) {
					synchronized (n) {
						while (ot.count % 2 == 0) {
							try {
								n.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						if (ot.count <= n)
							System.out.println(ot.count);
						ot.count++;
						n.notify();
					}
				}
			}
		};
		Runnable secondThread = new Runnable() {
			public void run() {
				while (ot.count <= n) {
					synchronized (n) {
						while (ot.count % 2 == 1) {
							try {
								n.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (ot.count <= n)
							System.out.println(ot.count);
						ot.count++;
						n.notify();
					}
				}
			}
		};

		Thread thread1 = new Thread(firstThread);
		Thread thread2 = new Thread(secondThread);
		thread1.start();
		thread2.start();
	}

}
