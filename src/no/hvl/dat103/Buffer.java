package no.hvl.dat103;

import java.util.LinkedList;



public class Buffer {

	
	private LinkedList<Integer> buffer = new LinkedList<Integer>();
	

	
	public void add(Integer item) throws InterruptedException {
		buffer.add(item);
	}

	public  Integer remove() throws InterruptedException {
		Integer back = buffer.removeFirst();
		return back;
	}

}
