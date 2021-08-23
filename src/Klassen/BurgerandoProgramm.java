package Klassen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BurgerandoProgramm {

	//vars
	//static DatenManager dm = new DatenManager(true); //Fuer Unit Tests 
	static DatenManager dm = new DatenManager(); //Fuer Produktion
	static Kunde kunde;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub				
		Initialize();

	}
	
	private static void Initialize()
	{
		System.out.println("Burgerando startet!");
		//int iD, String telefonnummer, String eMail, String vorname, String nachname, int postleitzahl, String stra�e, String hausnummer
		//test Kunde
		//Kunde kunde = new Kunde(69,"0152 01444286", "moritz@schernus.org", "Moritz", "Schernus", 10315, "Alt-Friedrichsfelde", "34");
		
		//Lade Kunden
		if (!LoadKunde())
		{
			//Kunde konnte nicht geladen werden, muss sich registrieren
			ClearScreen();
			//Kunde muss sich registrieren
			registerKunde();
			//jetzt koennen Daten geladen werden
			//LoadKunde();
			LoadKunde();
		}
		
		//okay, jetzt zum Main Menu
		MainMenu();
	}

	private static void MainMenu()
	{
		//Bedingung zum Schleifenbedingung
		boolean loopFurther = true;
		do {
			ClearScreen();
			dm.saveBurgerBestanteile();
			System.out.println("Wilkommen bei Burgerando, " + kunde.kontaktinformationen.getVorname() + "!");
			System.out.println();
			System.out.println("(1) Restaurants anzeigen");
			System.out.println("(2) Warenkorb anzeigen");
			System.out.println("(3) Kontoinformationen anzeigen");
			System.out.println("(4) Burgerando beenden");
			System.out.println();
			
			//Nutzer trifft Wahl
			int Auswahl = AuswahlTreffen();
			
			//Werte auswahl aus
			if (Auswahl == 1)
			{
				//Restaurants anzeigen
				RestaurantsAnzeigen();
			}
			else if (Auswahl == 2)
			{
				//Warenkorb anzeigen
				WarenkorbAnzeigen();
			}
			else if (Auswahl == 3)
			{
				//Kontoinformationen anzeigen
				NutzerkontoAnzeigen();
			}
			else if(Auswahl == 4)
			{
				//Tschau Kakao, Programm beenden
				loopFurther = false;
			}
			else
			{
				//Falsche/keine Eingabe gemacht
				//Einfach wieder ins Menu werfen
				MainMenu();
			}
		}while(loopFurther);
		
	}
	
	private static boolean LoadKunde()
	{
		//Versuche, Kunden zu laden
		Kunde tmp_kunde = dm.loadKundenDaten();
	
		//schaue, ob erfolg
		if (tmp_kunde.getKontaktinformationen().getVorname() == "")
		{
			//Kunde nicht geladen
			return false;
		}
	
		//Kunde erfolgreich geladen
		kunde = tmp_kunde;
		return true;
	}
	
	private static void RestaurantsAnzeigen()
	{
		//Endbedingung f�r Schleife
		boolean loopFurther = true;
		do {
			//Leere Konsole
			ClearScreen();
			
			//Lade restaurants
			Restaurant restaurants[] = dm.loadRestaurants();
			
			//Liste sie auf
			for (int i = 0; i < restaurants.length; i++)
			{
				//Zeige Restaurant an
				System.out.println("(" + (i+1) + ") " + restaurants[i].getName());
			}
			//Hauptmenu Eintrag
			System.out.println("(0) Zur�ck");
			//Nutzer waehlt
			int auswahl = AuswahlTreffen();
			
			//schaue, ob richtig
			if (auswahl <= restaurants.length) {
				//Auswahl sieht okay aus
				//Debug
				//System.out.println("Restaurant " + restaurants[auswahl-1].getName() + " gew�hlt");
				
				//schauen, ob er zurueck wollte
				if (auswahl == 0)
				{
					//Back to main menu
					loopFurther =false; //Schleife wird verlassen
				}
				else if (auswahl == -1)
				{
					//Kritischer Fehler bei Auswahl
				}
				else
				{
					//Menu anzeigen
					MenuAnzeigen(restaurants[(auswahl-1)]);
				}
			}
		}while(loopFurther);
		return;
	}
	
	//Menu fuer Restaurant Anzeigen
	public static void MenuAnzeigen(Restaurant restaurant)
	{
		boolean loopFurther = true;
		do {
			ClearScreen();
			System.out.println("Wilkommen im " + restaurant.getName() +"!");
			System.out.println("Hier ist unsere Karte:");
			System.out.println("(1) Eigenen Burger erstellen");
			System.out.println("(2) Warenkorb anzeigen");
			System.out.println("(0) Zur�ck");


			
			//Nutzer trifft auswahl
			int auswahl = AuswahlTreffen();
			
			if (auswahl == -1)
			{
				//kritischer Fehler
			}
			else if (auswahl == 1)
			{
				//eigenen Burger erstellen
				CreateOwnBurger();
			}
			else if (auswahl == 2)
			{
				WarenkorbAnzeigen();
			}
			else if(auswahl == 0)
			{
				return;
			}
		}while(loopFurther);
		
		return;
	}
	
	//Kunde kann sich eigenen Burger erstellen
	private static Burger CreateOwnBurger()
	{
		//Lade Bestandteile
		BurgerBestandteil burgerbestandteile[] = dm.loadBurgerbestandteile();
		ArrayList<BurgerBestandteil> tmp_bestandteile = new ArrayList<BurgerBestandteil>();
		//temp Burger in dem die Bestandteile gespeichert werden
		Burger tmp_burger = new Burger();
		//Var in der Auswahl von Nutzer gespeichert wird
		int auswahl;
		
		//Clear Screen
		ClearScreen();
		
		//Schritt 1 - Brot auswahlen
			//packe alle brote in Temp Liste
			for(BurgerBestandteil element : burgerbestandteile)
			{
				//Ist Brot?
				if (element.getKategorie().equals("Brot"))
				{
					//Ja man, ist Brot!
					//Fuege Brot in tmp Liste hinzu
					tmp_bestandteile.add(element);
				}
			}
			
			//Schleifen ENdbedingung
			boolean loopFurther = true;
			//So lange durchziehen, bis Nutzer Brot ausgew�hlt hat.
			do {
				ClearScreen();
				//jetzt alles printen
				for (int i = 0; i <= tmp_bestandteile.size()-1 ; i++)
				{
					System.out.println("(" + (i+1) + ") " + tmp_bestandteile.get(i).getPreis() + "� " + tmp_bestandteile.get(i).getName());
				}
				
				//Und natuerlich der Aussteig
				System.out.println("(0) zur�ck");
				
				//Nutzer soll auswahl �ber Brotwahl treffen
				//Nutzer soll Auswahl treffen
				auswahl = AuswahlTreffen();
				
				if (auswahl == -1)
				{
					//fuck
				}
				else if (auswahl == 0)
				{
					//Nutzer moechte zurueck
					//Einfach null zur�ckgeben
					return null;
				}
				else if (auswahl <= tmp_bestandteile.size())
				{
					//F�ge Bestandteil Burger hinzu
					//System.out.println("F�ge Burgerbestandteil hinzu: " + tmp_bestandteile.get(auswahl-1).getName());
					tmp_burger.addBestandteil(tmp_bestandteile.get(auswahl-1));
					
					//Schleife verlassen
					loopFurther = false;
				}

			}while(loopFurther);
		
		//Leere Bildschirm
		ClearScreen();
		//Leere tmp Liste
		tmp_bestandteile.clear();
		//Schritt 2 - Sosse auswahlen
			//packe alle brote in Temp Liste
			for(BurgerBestandteil element : burgerbestandteile)
			{
				//Ist Sosse?
				if (element.getKategorie().equals("Sosse"))
				{
					//Ja man, ist Sosse!
					//Fuege Sosse in tmp Liste hinzu
					tmp_bestandteile.add(element);
				}
			}
			
			//wann schleife verlassen werden soll
			loopFurther = true;
			do {
				//jetzt alles printen
				for (int i = 0; i <= tmp_bestandteile.size()-1 ; i++)
				{
					System.out.println("(" + (i+1) + ") " + tmp_bestandteile.get(i).getPreis() + "� " + tmp_bestandteile.get(i).getName());
				}
				
				//Weiter machen
				System.out.println("(0) weiter");
				
				//Nutzer soll Auswahl treffen
				auswahl = AuswahlTreffen();
				
				if (auswahl == -1)
				{
					//fuck
					ClearScreen();
					System.out.println("Das haben wir nicht verstanden, bitte widerholen Sie ihre Eingabe!");
				}
				else if (auswahl == 0)
				{
					//Nutzer moechte weiter
					loopFurther = false;
				}
				else if (auswahl <= tmp_bestandteile.size())
				{
					//Das sollte jetzt selbsterkl�rend sein, was ClearScreen tut
					ClearScreen();
					//Bestandteil hinzuf�gen1
					System.out.println(tmp_bestandteile.get(auswahl-1).getName() + " wurde dem Burger hinzugef�gt!");
					tmp_burger.addBestandteil(tmp_bestandteile.get(auswahl-1));
				}
				else
				{
					ClearScreen();
					System.out.println("Bitte nur Dinge ausw�hlen, die auf unserer Karte stehen ;)");
				}
				
			}while(loopFurther);
			
		//Schritt 3 - Toppings auswahlen
		
			//leere tmp Liste
			
			
			//packe alle brote in Temp Liste
			for(BurgerBestandteil element : burgerbestandteile)
			{
				//Ist Topping?
				if (element.getKategorie().equals("Topping"))
				{
					//Ja man, ist Topping!
					//Fuege Topping in tmp Liste hinzu
					tmp_bestandteile.add(element);
				}
			}
			
			//wann schleife verlassen werden soll
			loopFurther = true;
			do {
				//jetzt alles printen
				for (int i = 0; i <= tmp_bestandteile.size()-1 ; i++)
				{
					System.out.println("(" + (i+1) + ") " + tmp_bestandteile.get(i).getPreis() + "� " + tmp_bestandteile.get(i).getName());
				}
				
				//Weiter machen
				System.out.println("(0) weiter");
				
				//Nutzer soll Auswahl treffen
				auswahl = AuswahlTreffen();
				
				if (auswahl == -1)
				{
					//fuck
					ClearScreen();
					System.out.println("Das haben wir nicht verstanden, bitte widerholen Sie ihre Eingabe!");
				}
				else if (auswahl == 0)
				{
					//Nutzer moechte weiter
					loopFurther = false;
				}
				else if (auswahl <= tmp_bestandteile.size())
				{
					//Das sollte jetzt selbsterkl�rend sein, was ClearScreen tut
					ClearScreen();
					//Bestandteil hinzuf�gen1
					System.out.println(tmp_bestandteile.get(auswahl-1).getName() + " wurde dem Burger hinzugef�gt!");
					tmp_burger.addBestandteil(tmp_bestandteile.get(auswahl-1));
				}
				else
				{
					ClearScreen();
					System.out.println("Bitte nur Dinge ausw�hlen, die auf unserer Karte stehen ;)");
				}
				
			}while(loopFurther);
		
		//reset loop var
		loopFurther = true;
		
		//Clear Screen
		ClearScreen();
		
		//Burger fertig, frage Kunden, was nun
		do {
			//Burger ist Fertig
			System.out.println("Zutaten:");
			for(BurgerBestandteil element : tmp_burger.getBestandteile())
			{
				//Jedes Element einmal auflisten f�r Kunden
				System.out.println(element.getName());
			}
			
			//Und einmal Kosten auflisten
			System.out.println("Kosten: " + tmp_burger.getPreis() + "�");
			
			//Soll Burger hinzugef�gt werden?
			System.out.println("M�chten sie diesen Burger dem Warenkorb hinzuf�gen");
			System.out.println("(1) Ja");
			System.out.println("(0) Nein");
			
			auswahl = AuswahlTreffen();
			if (auswahl == -1)
			{
				//fuck - einfach ins Menu zur�ckwerfen
				MainMenu();
			}
			else if (auswahl == 1)
			{
				//Nutzer moechte Burger dem Warenkorb hinzuf�gen
				kunde.getWarenkorb().add(tmp_burger);
				ClearScreen();
				System.out.println("Burger wurde dem Warenkorb hinzugef�gt");
				return null;
			}
			else if (auswahl == 0)
			{
				//Nutzer m�chte Burger nicht in Warenkorb haben
				ClearScreen();
				return null;
			}
			else
			{
				ClearScreen();
				System.out.println("Bitte eine korrekte Auswahl eingaben.");
			}
		}while(loopFurther);
		
		//Fehler, return null
		return null;
	}
	
	//Nutzer taetigt Menuauswahl - ruckgabe von Auswahl, aber -1 bei Fehler
	private static int AuswahlTreffen()
	{
		System.out.println("Bitte tippen Sie die Zahl f�r die gew�nschte Menuauswahl ein und best�tigen Sie mit [Enter]");
		
		//Vars fuer Konsoleneingabe
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String Auswahl = "-1";
		
		//Lese Nutzereingabe
		try {
			//lesen
			Auswahl = reader.readLine();
			return Integer.parseInt(Auswahl);
		} catch (Exception ex) {
			
			//Schei�eeeeee
			//ex.printStackTrace();
		}
		//Fehler
		return -1;
	}
	
	//Warekorb anzeigen
	private static void WarenkorbAnzeigen()
	{
		ClearScreen();
		//Warenkorb von Nutzer anzeigen
		boolean loopFurther = false;
		
		do {
			//Kunden ansprechen
			System.out.println(kunde.getKontaktinformationen().getVorname() + " Warenkorb:");
			
			//Warenkorb auflisten
			int i = 1;//z�hler
			for(Burger element : kunde.getWarenkorb().getInhalt())
			{
				System.out.println("(" + i +") Burger (" + element.getPreis() + "�)"+ " mit:" );
				//Bestandteile auflisten
				for (BurgerBestandteil secondElement : element.getBestandteile())
				{
					System.out.println(" -(" + secondElement.getPreis() + "�)" + secondElement.getName());
				}
			}
			
			//Frage Nutzer
			System.out.println("(1) Warenkorb bestellen");
			System.out.println("(2) Warenkorb l�schen");
			System.out.println("(0) Zur�ck");
			
			int auswahl = AuswahlTreffen();
			
			if (auswahl == -1)
			{
				//fuck
			}
			else if (auswahl == 0)
			{
				//Nutzer moechte zurueck
				//Einfach zur�ckgeben
				return;
			}
			else if(auswahl == 1)
			{
				//Warenkorb bestellen
				//schaue, ob da was drin ist
				if (kunde.getWarenkorb().getInhalt().size() == 0)
				{
					ClearScreen();
					System.out.println("Der Warenkorb ist leer und kann daher nicht bestellt werden :)");
					
				}
				else
				{
					ClearScreen();
					Bestellen();
					//nach der Bestellung kann der Warenkorb gel�scht werden
					kunde.getWarenkorb().clear();
					//Ende der Bedingung f�r SChleife setzen
					loopFurther = false;
				}

			}
			else if(auswahl == 2)
			{
				//Warenkorb l�schen
				ClearScreen();
				kunde.getWarenkorb().clear();
				System.out.print("Warenkorb wurde geleert!");
				//Ende der Bedingung f�r Schleife setzen
				loopFurther = false;
			}
			
			
		}while(loopFurther);
		
		pressEnterToContinue();
		
		return;
	}
	
	//Warenkorb bestellen
	private static void Bestellen()
	{
		//Placebo Code f�r Bestellen
		System.out.println("Ihr Bestellung wurde aufgegeben!");
		return;
	}
	
	private static void NutzerkontoAnzeigen()
	{
		ClearScreen();
		System.out.println("Hier sind Ihre Nutzerinformationen");
		System.out.println("Ihr Vor- und Nachname:" + kunde.kontaktinformationen.getVorname() + " " + kunde.getKontaktinformationen().getNachname());
		System.out.println("Ihre Adresse:" + kunde.kontaktinformationen.getPostleitzahl() + ", " + kunde.kontaktinformationen.getStra�e() + ", " + kunde.kontaktinformationen.getHausnummer());
		System.out.println("Ihre Telefonnummer: " + kunde.kontaktinformationen.getTelefonnummer());
		System.out.println("Ihre E-Mailadresse: " + kunde.kontaktinformationen.getEMail());
		System.out.println("Ihre Kunden-ID: " + kunde.getID());
		
		//Warte auf Nutzer
		pressEnterToContinue();
		
		//Back to Main Menu
		return;	
	}
	
	private static void registerKunde()
	{
		//BufferedReader  fuer Konsoleneingabe
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//Kunden Objekt
		Kunde tmp_kunde = new Kunde();

		try {
		System.out.println("Bei erster Benutzung m�ssen wir ihre Kundendaten aufnehmen.");
		
		System.out.println("Wie lautet ihr Vorname?");
		tmp_kunde.kontaktinformationen.setVorname(reader.readLine()); //Lese Vorname und speicher ihn
		
		System.out.println("Wie lautet ihr Nachname?");
		tmp_kunde.kontaktinformationen.setNachname(reader.readLine()); //Lese Nachname und speicher ihn
		
		System.out.println("Wie lautet ihre Telefonnummer?");
		tmp_kunde.kontaktinformationen.setTelefonnummer(reader.readLine()); //Lese Telefonnummer und speichere
		
		System.out.println("Wie lautet ihr EMail?");
		tmp_kunde.kontaktinformationen.setEMail(reader.readLine()); //Lese EMail und speicher sie
		
		System.out.println("Wie lautet ihre Stra�e (Ohne Hausnummer)?");
		tmp_kunde.kontaktinformationen.setStra�e(reader.readLine()); //Lese Stra�e und speicher sie
		
		System.out.println("Wie lautet ihre Hausnummer?");
		tmp_kunde.kontaktinformationen.setHausnummer(reader.readLine()); //Lese Hausnummer und speicher sie
		
		System.out.println("Wie lautet ihre Postleitzahl?");
		tmp_kunde.kontaktinformationen.setPostleitzahl(Integer.parseInt(reader.readLine())); //Lese Postleitzahl und speicher sie
		
		//schlie�e scanner
		//reader.close();
		//weg mit der schei�e, macht nur Probleme
		reader = null;
		
		
		//Debug		
		}
		catch (Exception ex)
		{
			System.out.println("Sie haben eine Fehlerhafte Eingabe gemacht.");
			
			registerKunde();
			//Fehler, ups
		}
		finally {
			//speichere Daten
			dm.saveKundenDaten(tmp_kunde);
		}
	}
	
	
	//leert die Konsole (dreckig, aber es funktioniert)
	private static void ClearScreen()
	{
		//Print 50 Zeilen nichts
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	//Warte, bis Enter gedrueckt wurde um fortzufahren
    private static void pressEnterToContinue()
    {
        try {
        	
        	//Warte, bis Enter gedrueckt wurde um fortzufahren
        	System.out.println("Bitte dr�cken Sie [Enter] zum fortfahren");
			new ProcessBuilder("cmd", "/c", "pause > null").inheritIO().start().waitFor();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
