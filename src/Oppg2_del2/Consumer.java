package Oppg2_del2;

import java.util.Random;
import java.util.concurrent.Semaphore;
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
				full.acquire();;
				mutex.acquire();;
				Integer item = buffer.remove();
				mutex.release();
				empty.release();
				System.out.println("Consumed: " + item);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			try {
				Thread.sleep(200);
				} catch(InterruptedException e) {
					e.printStackTrace();
					System.out.println("Sleep failed");
				}
		}
	}
}
