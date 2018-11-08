package no.hvl.dat103;

public class Semaphore {

	private Integer S;

	public Semaphore(Integer S) {
		this.S = S;
	}

	public void vent() {
		while (S <= 0) {
System.out.println("t");
		}
		S--;
	}

	public void signal() {
		S++;
	}
}
