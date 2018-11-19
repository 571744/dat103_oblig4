package Oppg3_del2;

import java.util.concurrent.Semaphore;

public class ReadersWriters {

	public static void main(String[] args) {
		
		Database database = new Database();
		Semaphore  rw_mutex = new Semaphore(1);
		Semaphore mutex = new Semaphore(1);
		int read_count = 0;
		
		Writer writer = new Writer(rw_mutex, database);
		Reader reader1 = new Reader(rw_mutex, mutex, read_count, database);
		Reader reader2 = new Reader(rw_mutex, mutex, read_count, database);
		
		
		writer.start();
		reader1.start();
		reader2.start();
	}

}
