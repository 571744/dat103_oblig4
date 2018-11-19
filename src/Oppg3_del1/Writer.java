package Oppg3_del1;

import java.util.Random;

import Oppg2_del1.Semaphore;

public class Writer extends Thread {
	private Semaphore rw_mutex;
	private Database database;
	Random rand = new Random();

	public Writer(Semaphore rw_mutex, Database database) {

		this.rw_mutex = rw_mutex;
		this.database = database;
	}

	@Override
	public void run() {
		while (true) {
			try {
				rw_mutex.vent();
				if (database.lengde() <= 5) {
					Integer item = rand.nextInt(100);
					database.add(item);
					System.out.println("La til " + item + ".");
				} else {
					Integer item2 = database.remove();
					System.out.println("Fjernet " + item2);
				}
				rw_mutex.signal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
