package no.hvl.dat103;

public class Semaphore {

	private Integer S;

	public Semaphore(Integer S) {
		this.S = S;
	}

	public void wait(Semaphore S) {
		while (S.S <= 0) {

		}
		S.S--;
	}

	public void signal(Semaphore S) {
		S.S++;
	}
}
