package Klassen;

import java.util.ArrayList;

public class Warenkorb {
	//vars
	public float Preis;
	public ArrayList<Burger> Inhalt;
	
	//func
	//Füge Burger Warenkorb zu
	public void add(Burger burger)
	{
		//Add Burger to Warenkorb
		Inhalt.add(burger);
	}
	
	public void clear()
	{
		Inhalt.clear();
	}
	
	public ArrayList<Burger> getInhalt()
	{
		return Inhalt;
	}
	
	//constructor
	public Warenkorb() {
		//Konstrukt
		Inhalt = new ArrayList<Burger>();
	}; //empty
	
}
