package no.hvl.dat103;

import java.util.LinkedList;



public class Buffer {

	private final static int SIZE = 10;
	private LinkedList<Integer> buffer = new LinkedList<Integer>();
	

	
	public synchronized void add(Integer item) throws InterruptedException {
		while (true) {


				if (buffer.size() == SIZE) {
					wait();
				}
				buffer.add(item);
				notify();
				return;
			
		}
	}

	public synchronized Integer remove() throws InterruptedException {
		notify();
		while (true) {

				if (buffer.isEmpty()) {
					wait();
			}
			Integer back = buffer.removeFirst();
			
			// TODO
			return back;
		}
	}

}
