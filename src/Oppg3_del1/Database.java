package Oppg3_del1;

import java.util.LinkedList;

public class Database {
	private LinkedList<Integer> liste = new LinkedList<Integer>();
	
	public void add(Integer item) throws InterruptedException {
		liste.add(item);
	}

	public  Integer remove() throws InterruptedException {
		Integer back = liste.removeFirst();
		return back;
	}
	public int lengde() {
		return liste.size();
	}
	
	public void print() {
		System.out.println("\nListen er:\n");
		for(Integer i : liste) {
			System.out.println(i);
		}
	}
}
