package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this(20);
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() { //returnerer antall innlegg-objekt som aktuelt er lagret i tabellen
		nesteledig = 0;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null)
				nesteledig++;
			}
		return nesteledig;
	}
	
	public Innlegg[] getSamling() { // returnerer en peker til tabellen av innlegg-objek
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) { //Finner posisjon av samme ID
		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				return i;
				}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) { //Ser om det er samme ID, true om det er
		if (finnInnlegg(innlegg) == -1) {
			return false;
		}
		return true;
	}

	public boolean ledigPlass() { //forteller om det er ledig plass
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		int i = 0;
		while (!finnes(innlegg)) {
			if (innleggtabell[i] == null) {
				innleggtabell[i] = innlegg;
				return true;
			}
		i++;
		}
		return false;
	}
	
	public String toString() {
		getAntall();
		String ut = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			ut += innleggtabell[i].toString();
		}
		return ut;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length*2];
		for (int i = 0; i < innleggtabell.length; i++) {
			nyTabell[i] = innleggtabell[i];
		}
		innleggtabell = nyTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if(!finnes(innlegg) && (ledigPlass())){
			return leggTil(innlegg);
		}
		else if (!finnes(innlegg) && !ledigPlass()) {
			utvid();
			return leggTil(innlegg);
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if(pos >= 0) {
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			return true;
		} else
			return false;
	}
	

	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}