package Klassen.UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Klassen.DatenManager;
import Klassen.KontaktInformationen;
import Klassen.Kunde;
import Klassen.Restaurant;

public class DatenManagerTestRestaurants {

	@Test
	public void test() {
		
		DatenManager dm = new DatenManager(true);
		
		ArrayList<Restaurant> data = new ArrayList<Restaurant>();
		data.add(new Restaurant("Test Restaurant", new KontaktInformationen("911", "restaurant@mail", "Nachname", "Vorname", 10001,"Restaurantstrasse", "1a")));
		//speichere Daten
		dm.saveRestaurant(data);
		
		//Wandle Daten in Array um, damit vergleich funktioniert
		Restaurant[] expected = new Restaurant[data.size()];
		
		for(int i = 0; i != data.size();i++)
		{
			expected[i] = data.get(i);
		}
		
		//Lade Restaurant
		Restaurant[] actual= dm.loadRestaurants();
		
		
		/*
		System.out.println(actual[0].getKontaktinformationen().getHausnummer());
		System.out.println(expected[0].getKontaktinformationen().getHausnummer());
		
		System.out.println(actual[0].getKontaktinformationen().getEMail());
		System.out.println(expected[0].getKontaktinformationen().getEMail());

		System.out.println(actual[0].getKontaktinformationen().getNachname());
		System.out.println(expected[0].getKontaktinformationen().getNachname());

		
		System.out.println(actual[0].getKontaktinformationen().getVorname());
		System.out.println(expected[0].getKontaktinformationen().getVorname());

		
		System.out.println(actual[0].getKontaktinformationen().getPostleitzahl());
		System.out.println(expected[0].getKontaktinformationen().getPostleitzahl());

		
		System.out.println(actual[0].getKontaktinformationen().getStraﬂe());
		System.out.println(expected[0].getKontaktinformationen().getStraﬂe());

		
		System.out.println(actual[0].getKontaktinformationen().getTelefonnummer());
		System.out.println(expected[0].getKontaktinformationen().getTelefonnummer());

		
		System.out.println(actual[0].getName());
		System.out.println(expected[0].getName());
	
		System.out.println(actual.length);
		System.out.println(actual.length);

		System.out.println(actual.equals(expected));
		System.out.println(Arrays.equals(expected, actual));
		
		*/
		assertArrayEquals(expected, actual);
		
	}

}
