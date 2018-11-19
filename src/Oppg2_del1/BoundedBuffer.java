package Oppg2_del1;

import Oppg2_del1.Buffer;
import Oppg2_del1.Semaphore;

public class BoundedBuffer {
 public static void main(String[] args) {
	Buffer buffer = new Buffer();
	Semaphore empty = new Semaphore(10);
	Semaphore full = new Semaphore(0);
	Semaphore mutex = new Semaphore(1);
	Producer pro = new Producer(buffer, empty, full, mutex);
	Consumer con = new Consumer(buffer, empty, full, mutex);
	pro.start();
	con.start();
}
}
