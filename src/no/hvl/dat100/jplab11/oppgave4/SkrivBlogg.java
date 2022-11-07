package no.hvl.dat100.jplab11.oppgave4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {			
			BufferedWriter skriver = new BufferedWriter
					(new FileWriter(mappe + filnavn));
			skriver.write(samling.toString());
			skriver.close();
			return true;
			
		} catch (IOException e) {
			return false;
		}
	}
}
