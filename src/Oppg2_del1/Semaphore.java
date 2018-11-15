package Oppg2_del1;

public class Semaphore {

	private Integer S;

	public Semaphore(Integer S) {
		this.S = S;
	}

	public void vent() {
		while (S <= 0) {
		}
		
		S--;
	}

	public void signal() {
		
		S++;
	}
}
