package Klassen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class DatenManager {

	private String programmPath;
	
	//konstruktor
	public DatenManager()
	{
		//get vars

		//current dir
		programmPath = System.getProperty("user.dir");	
	}
	
	//Setze Pfad in Testumgebun
	public DatenManager(boolean TestingMode) {
		
		if (TestingMode)
		{
			//current dir + Pfad
			programmPath = System.getProperty("user.dir")+"\\Tests\\";
			
			//Erstelle Directory, falls noch nicht existent
			File file = new File(programmPath);
			file.mkdir();
		}
	}
	
	
	//Lade Kundendaten
	public Kunde loadKundenDaten()
	{
		try {
			//Pfad, wo Kundendaten gespeichert sind
			Path jsonPath =  Paths.get(programmPath + "\\Kunde.json");
			
			//vars
			byte[] temp;
			String daten;
			
			//versuche Daten zu lesen
		
			//lese datei
			temp = Files.readAllBytes(jsonPath);
			daten = new String(temp);
			
			//JSON obj
			JSONObject obj = new JSONObject(daten);
			
			//Debug
			//System.out.println("Gelesene Kunden ID: " + obj.getString("Name"));
			//System.out.println("Wir haben gelesen: " + temp);
			
			//Packe Daten in Kunden Obj
			Kunde kunde = new Kunde();
			
			kunde.setID(obj.getInt("ID"));
			kunde.kontaktinformationen.setTelefonnummer(obj.getString("Telefonnummer"));
			kunde.kontaktinformationen.setEMail(obj.getString("EMail"));
			kunde.kontaktinformationen.setVorname(obj.getString("Vorname"));
			kunde.kontaktinformationen.setNachname(obj.getString("Nachname"));
			kunde.kontaktinformationen.setPostleitzahl(obj.getInt("Postleitzahl"));
			kunde.kontaktinformationen.setStraße(obj.getString("Straße"));
			kunde.kontaktinformationen.setHausnummer(obj.getString("Hausnummer"));
			//Alles okay
			
			return kunde;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//Fehler - return leeren Kunden
			return new Kunde();
		}
		
	    // Convert JSON string to JSONObject
	    //JSONObject tomJsonObject = new JSONObject(content);

	}
	
	//Lade ladeRestaurants
	public Restaurant[] loadRestaurants()
	{
		try {
			//Pfad, wo Kundendaten gespeichert sind
			Path jsonPath =  Paths.get(programmPath + "\\Restaurants.json");
			
			//vars
			byte[] temp;
			String daten;
			
			//versuche Daten zu lesen
		
			//lese datei
			temp = Files.readAllBytes(jsonPath);
			daten = new String(temp);
			
			//JSON obj
			JSONObject obj = new JSONObject(daten);
			
			//erstellen Restaurant array
			JSONArray data = obj.getJSONArray("Name"); //sample Daten die array größe enthält
			int size = data.length(); //array größe
			Restaurant restaurant[] = new Restaurant[size]; //restaurant array
				
			//Debug
			//System.out.println("size " + size);
			
			//Jeden Index mit leeren Objekt belegen
			for(int i = 0; i <= size-1; i++)
			{
				restaurant[i] = new Restaurant();	
			}
			
			//Namen zuweisen
			data = obj.getJSONArray("Name");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				restaurant[i].setName(data.getString(i));
			}
			
			//KontaktinformationenTelefonnummer
			data = obj.getJSONArray("KontaktinformationenTelefonnummer");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				restaurant[i].kontaktinformationen.setTelefonnummer(data.getString(i));
			}
			
			//KontaktinformationenTelefonnummer
			data = obj.getJSONArray("KontaktinformationenEMail");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				restaurant[i].kontaktinformationen.setEMail(data.getString(i));
			}
			
			//KontaktinformationenPostleitzahl
			data = obj.getJSONArray("KontaktinformationenPostleitzahl");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				restaurant[i].kontaktinformationen.setPostleitzahl(data.getInt(i));
			}
			
			//KontaktinformationenStrasse
			data = obj.getJSONArray("KontaktinformationenStrasse");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				restaurant[i].kontaktinformationen.setStraße(data.getString(i));
			}
			
			//KontaktinformationenHausnummer
			data = obj.getJSONArray("KontaktinformationenHausnummer");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				restaurant[i].kontaktinformationen.setHausnummer(data.getString(i));
			}
			
			//KontaktinformationenNachname
			try
			{
				//Wir versuchen es 
				data = obj.getJSONArray("KontaktinformationenNachname");

				for(int i = 0; i <= size-1; i++)
				{
					//restaurant[i].setName(obj.getString(i));
					//Kann fehlschlagen
					restaurant[i].kontaktinformationen.setNachname(data.getString(i));
				}
				
			}catch(Exception ex)
			{
				//FUUUUUUCK
				for(int i = 0; i <= size-1; i++)
				{
					//setze ""
					restaurant[i].kontaktinformationen.setNachname("");
				}	
			}

			//KontaktinformationenVorname
			try
			{
				//Wir versuchen es 
				data = obj.getJSONArray("KontaktinformationenVorname");

				for(int i = 0; i <= size-1; i++)
				{
					//restaurant[i].setName(obj.getString(i));
					//Kann fehlschlagen
					restaurant[i].kontaktinformationen.setVorname(data.getString(i));
				}
				
			}catch(Exception ex)
			{
				//FUUUUUUCK
				for(int i = 0; i <= size-1; i++)
				{
					//setze ""
					restaurant[i].kontaktinformationen.setVorname("");
				}	
			}
			//debuggen
			//Alles okay
			//System.out.println(restaurant[0].getName() + restaurant[0].getKontaktinformationen().getStraße());
			//System.out.println(restaurant[1].getName() + restaurant[1].getKontaktinformationen().getStraße());
			//System.out.println(restaurant[2].getName() + restaurant[2].getKontaktinformationen().getStraße());
			
			//Gebe geladene Daten zurück
			return restaurant;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Fehler - return leere Restaurant Liste
			return null;
		}
	}
	
	//Für Testzwecke, um JSON von Restaurants zu erzeugen
	public void saveRestaurant(ArrayList<Restaurant> restaurants)
	{

		//vars
		JSONArray restaurantNames = new JSONArray();
		JSONArray restaurantKontaktinformationenTelefonnummer = new JSONArray();
		JSONArray restaurantKontaktinformationenEMail = new JSONArray();
		JSONArray restaurantKontaktinformationenPostleitzahl = new JSONArray();
		JSONArray restaurantKontaktinformationenStrasse = new JSONArray();
		JSONArray restaurantKontaktinformationenHausnummer = new JSONArray();
		JSONArray restaurantKontaktinformationenVorname = new JSONArray();
		JSONArray restaurantKontaktinformationenNachname= new JSONArray();

		//Restaurants in JSON Array packen
		for(Restaurant element : restaurants) {
			restaurantNames.put(element.getName());
			restaurantKontaktinformationenTelefonnummer.put(element.getKontaktinformationen().getTelefonnummer());
			restaurantKontaktinformationenEMail.put(element.getKontaktinformationen().getEMail());
			restaurantKontaktinformationenPostleitzahl.put(element.getKontaktinformationen().getPostleitzahl());
			restaurantKontaktinformationenStrasse.put(element.getKontaktinformationen().getStraße());
			restaurantKontaktinformationenHausnummer.put(element.getKontaktinformationen().getHausnummer());
			restaurantKontaktinformationenNachname.put(element.getKontaktinformationen().getNachname());
			restaurantKontaktinformationenVorname.put(element.getKontaktinformationen().getVorname());
		}
	
		//JSON Array in JSON Object packen
		JSONObject obj = new JSONObject();
		obj.put("Name", restaurantNames);
		obj.put("KontaktinformationenTelefonnummer", restaurantKontaktinformationenTelefonnummer);
		obj.put("KontaktinformationenEMail", restaurantKontaktinformationenEMail);
		obj.put("KontaktinformationenPostleitzahl", restaurantKontaktinformationenPostleitzahl);
		obj.put("KontaktinformationenStrasse", restaurantKontaktinformationenStrasse);
		obj.put("KontaktinformationenHausnummer", restaurantKontaktinformationenHausnummer);
		obj.put("KontaktinformationenNachname", restaurantKontaktinformationenNachname);
		obj.put("KontaktinformationenVorname", restaurantKontaktinformationenVorname);

		//Hierhin schreiben wir JSON
		Path jsonPath =  Paths.get(programmPath + "\\Restaurants.json");
		
		try {
			//schreibe in Datei
			Files.write(jsonPath, obj.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	
	public void saveRestaurants()
	{
		//vars
		Restaurant data[] = new Restaurant[3];
		data[0] = new Restaurant("Pizzarie", new KontaktInformationen("110", "Restaurant1Mail@dumm.de", "", "", 10001,"Restaurantstrasse", "1a"));
		data[1] = new Restaurant("Boiler", new KontaktInformationen("220", "Restaurant2Mail@dumm.de", "", "", 20002,"Restaurantstrasse", "2a"));
		data[2] = new Restaurant("Bologneseladen an der Pissecke", new KontaktInformationen("330", "Restaurant3Mail@dumm.de", "", "", 30003,"Restaurantstrasse", "3a"));

		JSONArray restaurantNames = new JSONArray();
		restaurantNames.put(data[0].getName());
		restaurantNames.put(data[1].getName());
		restaurantNames.put(data[2].getName());

		JSONArray restaurantKontaktinformationenTelefonnummer = new JSONArray();
		restaurantKontaktinformationenTelefonnummer.put(data[0].getKontaktinformationen().getTelefonnummer());
		restaurantKontaktinformationenTelefonnummer.put(data[1].getKontaktinformationen().getTelefonnummer());
		restaurantKontaktinformationenTelefonnummer.put(data[2].getKontaktinformationen().getTelefonnummer());
		
		JSONArray restaurantKontaktinformationenEMail = new JSONArray();
		restaurantKontaktinformationenEMail.put(data[0].getKontaktinformationen().getEMail());
		restaurantKontaktinformationenEMail.put(data[1].getKontaktinformationen().getEMail());
		restaurantKontaktinformationenEMail.put(data[2].getKontaktinformationen().getEMail());

		JSONArray restaurantKontaktinformationenPostleitzahl = new JSONArray();
		restaurantKontaktinformationenPostleitzahl.put(data[0].getKontaktinformationen().getPostleitzahl());
		restaurantKontaktinformationenPostleitzahl.put(data[1].getKontaktinformationen().getPostleitzahl());
		restaurantKontaktinformationenPostleitzahl.put(data[2].getKontaktinformationen().getPostleitzahl());

		JSONArray restaurantKontaktinformationenStrasse = new JSONArray();
		restaurantKontaktinformationenStrasse.put(data[0].getKontaktinformationen().getStraße());
		restaurantKontaktinformationenStrasse.put(data[1].getKontaktinformationen().getStraße());
		restaurantKontaktinformationenStrasse.put(data[2].getKontaktinformationen().getStraße());
		
		JSONArray restaurantKontaktinformationenHausnummer = new JSONArray();
		restaurantKontaktinformationenHausnummer.put(data[0].getKontaktinformationen().getHausnummer());
		restaurantKontaktinformationenHausnummer.put(data[1].getKontaktinformationen().getHausnummer());
		restaurantKontaktinformationenHausnummer.put(data[2].getKontaktinformationen().getHausnummer());
		
		
		JSONObject obj = new JSONObject();
		obj.put("Name", restaurantNames);
		obj.put("KontaktinformationenTelefonnummer", restaurantKontaktinformationenTelefonnummer);
		obj.put("KontaktinformationenEMail", restaurantKontaktinformationenEMail);
		obj.put("KontaktinformationenPostleitzahl", restaurantKontaktinformationenPostleitzahl);
		obj.put("KontaktinformationenStrasse", restaurantKontaktinformationenStrasse);
		obj.put("KontaktinformationenHausnummer", restaurantKontaktinformationenHausnummer);

		
		Path jsonPath =  Paths.get(programmPath + "\\Restaurants.json");
		
		try {
			//schreibe in Datei
			Files.write(jsonPath, obj.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	//Für Testzwecke, um JSON von Burgerbestandteilen zu erzeugen
	public void saveBurgerBestanteile()
	{
		//vars
		BurgerBestandteil data[] = new BurgerBestandteil[15];
		data[0] = new BurgerBestandteil("Vollkornbrot", "Brot", 1f);
		data[1] = new BurgerBestandteil("Mischbrot", "Brot", 1.5f);
		data[2] = new BurgerBestandteil("Ketchup", "Sosse", 1.5f);
		data[3] = new BurgerBestandteil("Majo", "Sosse", 1.5f);
		data[4] = new BurgerBestandteil("BBQ", "Sosse", 2f);
		data[5] = new BurgerBestandteil("Rinderfleisch Patty 150g", "Topping", 5f);
		data[6] = new BurgerBestandteil("Rinderfleisch Patty 250g", "Topping", 7.5f);
		data[7] = new BurgerBestandteil("Vollmilchkäse", "Topping", 2f);
		data[8] = new BurgerBestandteil("Salat", "Topping", 1f);
		data[9] = new BurgerBestandteil("Tomaten", "Topping", 1.5f);
		data[10] = new BurgerBestandteil("Bacon", "Topping", 2f);
		data[11] = new BurgerBestandteil("Pilze", "Topping", 2f);
		data[12] = new BurgerBestandteil("Gurken", "Topping", 1.5f);
		data[13] = new BurgerBestandteil("Eier", "Topping", 3f);
		data[14] = new BurgerBestandteil("Zwiebeln", "Topping", 1.5f);
		
		
		//JSONArray - hier werden Daten drin gespeichert
		JSONArray bestandteilNamen = new JSONArray();
		//JSONArray - hier werden Daten drin gespeichert
		JSONArray bestandteilKategorie = new JSONArray();
		//JSONArray - hier werden Daten drin gespeichert
		JSONArray bestandteilMenge = new JSONArray();
		//JSONArray - hier werden Daten drin gespeichert
		JSONArray bestandteilPreis = new JSONArray();
		
		//Fuege Namen jedes Bestandteils hinzu
		for (BurgerBestandteil element : data) {
			bestandteilNamen.put(element.getName());
		}

		//Fuege Namen jedes Bestandteils hinzu
		for (BurgerBestandteil element : data) {
			bestandteilKategorie.put(element.getKategorie());
		}
		
		
		//Fuege Namen jedes Bestandteils hinzu
		for (BurgerBestandteil element : data) {
			//mal 100 um cent in int umzuwandeln
			bestandteilPreis.put(element.getPreis()*100);
		}
		
		
		JSONObject obj = new JSONObject();
		obj.put("Name", bestandteilNamen);
		obj.put("Kategorie", bestandteilKategorie);
		obj.put("Menge", bestandteilMenge);
		obj.put("Preis", bestandteilPreis);
		
		Path jsonPath =  Paths.get(programmPath + "\\Burgerbestandteile.json");
		
		try {
			//schreibe in Datei
			Files.write(jsonPath, obj.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
	
	//lade Burgerbestandteile
	public BurgerBestandteil[] loadBurgerbestandteile()
	{
		try {
			//Pfad, wo Kundendaten gespeichert sind
			Path jsonPath =  Paths.get(programmPath + "\\Burgerbestandteile.json");
			
			//vars
			byte[] temp;
			String daten;
			
			//versuche Daten zu lesen
		
			//lese datei
			temp = Files.readAllBytes(jsonPath);
			daten = new String(temp);
			
			//JSON obj
			JSONObject obj = new JSONObject(daten);
			
			//erstellen Restaurant array
			JSONArray data = obj.getJSONArray("Name"); //sample Daten die array größe enthält
			int size = data.length(); //array größe
			BurgerBestandteil burgerbestandteil[] = new BurgerBestandteil[size]; //restaurant array
				
			//Debug
			//System.out.println("size " + size);
			
			//Jeden Index mit leeren Objekt belegen
			for(int i = 0; i <= size-1; i++)
			{
				burgerbestandteil[i] = new BurgerBestandteil();	
			}
			
			//Namen zuweisen
			data = obj.getJSONArray("Name");
			//und jetzt Daten lesen und rein packen
			//Fuege Namen jedes Bestandteils hinzu
			for(int i = 0; i <= size-1; i++)
			{
				//restaurant[i].setName(obj.getString(i));
				burgerbestandteil[i].setName(data.getString(i));
			}
			
			//KontaktinformationenTelefonnummer
			data = obj.getJSONArray("Kategorie");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				burgerbestandteil[i].setKategorie(data.getString(i));
			}
			
			//KontaktinformationenPostleitzahl
			data = obj.getJSONArray("Preis");
			//und jetzt Daten lesen und rein packen
			for(int i = 0; i <= size-1; i++)
			{
				//geteilt durch hundert, um cent zu bekommen. Daten sind als int gespeichert
				burgerbestandteil[i].setPreis((data.getInt(i)/(float)100));
			}
						
			//debuggen
			//Alles okay
			//System.out.println(restaurant[0].getName() + restaurant[0].getKontaktinformationen().getStraße());
			//System.out.println(restaurant[1].getName() + restaurant[1].getKontaktinformationen().getStraße());
			//System.out.println(restaurant[2].getName() + restaurant[2].getKontaktinformationen().getStraße());
			
			//Gebe geladene Daten zurück
			return burgerbestandteil;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Fehler - return leere Restaurant Liste
			return null;
		}
	}
	
	//speichere Kundendaten
	public boolean saveKundenDaten(Kunde kunde)
	{		
		//Daten reinpacken
		JSONObject JSONparser = new JSONObject();
		JSONparser.put("ID",kunde.getID());
		JSONparser.put("Postleitzahl",kunde.getKontaktinformationen().getPostleitzahl());
		JSONparser.put("EMail",kunde.getKontaktinformationen().getEMail());
		JSONparser.put("Hausnummer",kunde.getKontaktinformationen().getHausnummer());
		JSONparser.put("Nachname",kunde.getKontaktinformationen().getNachname());
		JSONparser.put("Straße",kunde.getKontaktinformationen().getStraße());
		JSONparser.put("Telefonnummer",kunde.getKontaktinformationen().getTelefonnummer());
		JSONparser.put("Vorname",kunde.getKontaktinformationen().getVorname());
		
		//Debug
		//System.out.println("Wir schreiben: " + JSONparser.toString());
		
		//speichere json
		Path jsonPath =  Paths.get(programmPath + "\\Kunde.json");
		
		try {
			//schreibe in Datei
			Files.write(jsonPath, JSONparser.toString().getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
		
	//check, if file existiert
	public boolean checkIfFileExists(String FilePath)
	{
	
		Path path = Paths.get(FilePath);

		if (Files.exists(path)) {
		  //Datei existiert
			return true;
			
		}

		if (Files.notExists(path)) {
		  //Datei nicht gefunden
			return false;
		}
		
		return false; //Falls wir hier sind, ist echt irgendwas richtig schief gegangen
	}
}
