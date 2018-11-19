package Oppg3_del1;

import Oppg2_del1.Semaphore;

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
				mutex.vent();
				read_count++;
				if (read_count == 1) {
					rw_mutex.vent();
				}
				mutex.signal();
				database.print();
				mutex.vent();

				read_count--;
				if(read_count == 0) {
					rw_mutex.signal();
				}
				mutex.signal();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
