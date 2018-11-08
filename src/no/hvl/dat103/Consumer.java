package no.hvl.dat103;

import java.util.Random;

public class Consumer extends Thread{

	private Buffer buffer;
	private Semaphore empty;
	private Semaphore full;
	private Semaphore mutex;

	public Consumer(Buffer buffer, Semaphore empty, Semaphore full, Semaphore mutex) {
		this.buffer = buffer;
		this.empty = empty;
		this.full = full;
		this.mutex = mutex;
	}

	@Override
	public void run() {
		while (true) {
			try {
				full.vent();
				mutex.vent();
				Integer item = buffer.remove();
				mutex.signal();
				empty.signal();
				System.out.println("Consumed: " + item);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
