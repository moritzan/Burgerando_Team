package Klassen.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Klassen.DatenManager;
import Klassen.Kunde;

public class DatenManagerTestKunde {
	@Test
	public void test() {
			
		//DatenManager in Testumgebung
		DatenManager dm = new DatenManager(true);
		
		Kunde expected = new Kunde("0152 01444286", "moritz@schernus.org","Tobias", "Mourier", 10315,"Alt-Friedrichsfelde", "69");
		//speichere Daten
		dm.saveKundenDaten(expected);
		
		
		//Lade Restaurant
		Kunde actual= dm.loadKundenDaten();
		
		assertEquals(expected, actual);

	}

}

