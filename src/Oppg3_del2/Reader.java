package Oppg3_del2;

import java.util.concurrent.Semaphore;

public class Reader extends Thread {

	private Semaphore rw_mutex;
	private Semaphore mutex;
	private int read_count;
	private Database database;

	public Reader(Semaphore rw_mutex, Semaphore mutex, int read_count, Database database) {

		this.rw_mutex = rw_mutex;
		this.mutex = mutex;
		this.read_count = read_count;
		this.database = database;
	}

	@Override
	public void run() {
		
		
		while (true) {
			try {
				mutex.acquire();
				read_count++;
				
				if (read_count == 1) {
					rw_mutex.acquire();
				}

				mutex.release();
				database.print();
//				mutex.acquire();

				read_count--;
				if(read_count == 0) {
					rw_mutex.release();;
				}
				mutex.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
}
