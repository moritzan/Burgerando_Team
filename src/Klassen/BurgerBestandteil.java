package Klassen;

public class BurgerBestandteil {
	//vars
	private String Name;
	private String Kategorie;
	private float Preis;
	
	//konstruktoren
	//leer
	public BurgerBestandteil(){}
	//mit vars
	public BurgerBestandteil(String name, String kategorie, float preis) {
		super();
		Name = name;
		Kategorie = kategorie;
		Preis = preis;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the kategorie
	 */
	public String getKategorie() {
		return Kategorie;
	}
	/**
	 * @param kategorie the kategorie to set
	 */
	public void setKategorie(String kategorie) {
		Kategorie = kategorie;
	}

	/**
	 * @return the preis
	 */
	public float getPreis() {
		return Preis;
	}
	/**
	 * @param preis the preis to set
	 */
	public void setPreis(float preis) {
		Preis = preis;
	}

	//funcs

}
