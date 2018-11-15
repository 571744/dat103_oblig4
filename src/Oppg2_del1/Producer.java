package Oppg2_del1;

import java.util.Random;

public class Producer extends Thread {
	private Buffer buffer;
	Random rand = new Random();

	private Semaphore empty;
	private Semaphore full;
	private Semaphore mutex;

	public Producer(Buffer buffer, Semaphore empty, Semaphore full, Semaphore mutex) {
		this.buffer = buffer;
		this.empty = empty;
		this.full = full;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		while (true) {
			try {

				empty.vent();
				mutex.vent();
				Integer item = rand.nextInt(100);
				System.out.println("Produced: " + item);
				buffer.add(item);
				mutex.signal();
				full.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Sleep failed");
			}
		}
	}
}
