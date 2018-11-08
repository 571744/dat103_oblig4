package no.hvl.dat103;

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
				buffer.add(item);
				System.out.println("Produced: " + item);
				
				mutex.signal();
				full.signal();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
	}
}
