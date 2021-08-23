package Klassen;

import java.util.ArrayList;
import java.util.List;

public class Burger {
	//vars
	private ArrayList<BurgerBestandteil> Bestandteile = new ArrayList<BurgerBestandteil>();
	private float Preis; 
	
	public Burger() {
		super();
	}

	//func
	
	public Burger(ArrayList<BurgerBestandteil> bestandteile) {
		super();
		Bestandteile = bestandteile;
	}

	public void addBestandteil(BurgerBestandteil burgerbestandteil)
	{
		Bestandteile.add(burgerbestandteil);
		return;
	}
	
	public void removeBestandteil(BurgerBestandteil burgerbestandteil)
	{
		Bestandteile.remove(burgerbestandteil);
		return;
	}
	//getters
	public List<BurgerBestandteil> getBestandteile() {
		return Bestandteile;
	}

	public float getPreis() {
		
		//Die Denkmaschine fängt an zu denken
		//Alle Bestandteile zusammenrechnen ergibt Preis
		float tmp_Preis = 0;
		for(BurgerBestandteil element : Bestandteile)
		{
			tmp_Preis += element.getPreis();
		}
		
		//setze Preis
		Preis = tmp_Preis;
		return Preis;
	}
}
