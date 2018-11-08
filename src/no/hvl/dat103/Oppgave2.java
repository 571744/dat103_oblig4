package no.hvl.dat103;

public class Oppgave2 {
	
	private Integer S;
	
	public void wait(Integer S) {
		while(S<=0) {
			
		}
		this.S--;
	}
	
	public void signal(Integer S) {
		this.S++;
	}
}
