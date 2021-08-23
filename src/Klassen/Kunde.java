package Klassen;

import java.util.Random;

public class Kunde{
		//vars
	public int ID;
	public KontaktInformationen kontaktinformationen;
	public Warenkorb warenkorb;
	//konstruktor
	//leerer
	public Kunde() {
		this.kontaktinformationen = new KontaktInformationen();
		this.warenkorb = new Warenkorb();
		//Generiere zufaellige ID zwischen 1 und 100
		Random random = new Random();
	    this.ID = random.nextInt(100 - 1) + 1;
	}
	
	public Kunde(String telefonnummer, String eMail, String vorname, String nachname, int postleitzahl,
			String straﬂe, String hausnummer) {
		//Generiere zufaellige ID zwischen 1 und 100
		Random random = new Random();
	    this.ID = random.nextInt(100 - 1) + 1;
		this.kontaktinformationen = new KontaktInformationen(telefonnummer,eMail,vorname,nachname,postleitzahl,straﬂe,hausnummer);
		this.warenkorb = new Warenkorb();
	}
	
	//mit vars
	public Kunde(int iD, String telefonnummer, String eMail, String vorname, String nachname, int postleitzahl,
			String straﬂe, String hausnummer) {
		super();
		ID = iD;
		this.kontaktinformationen = new KontaktInformationen(telefonnummer,eMail,vorname,nachname,postleitzahl,straﬂe,hausnummer);
		this.warenkorb = new Warenkorb();
	}

	//override
	@Override
	public boolean equals(Object other) {
		//System.out.println("Override");
        if (this == other)
    	{
        	return true;
    	}
        
        if (other == null || getClass() != other.getClass())
    	{
    		//System.out.println("Klassen Fehler");
        	return false;
    	}
		//System.out.println("Klassen ok");

		Kunde that = (Kunde) other;
        
		if (this.getID() == (that.getID()))
        {
        	//System.out.println("ID ok");
            if (this.getKontaktinformationen().getEMail().equals(that.getKontaktinformationen().getEMail()))
            {
            	//System.out.println("EMAIL ok");
                if (this.getKontaktinformationen().getHausnummer().equals(that.getKontaktinformationen().getHausnummer()))
                {
                	//System.out.println("Hausnummer ok");

                    if (this.getKontaktinformationen().getNachname().equals(that.getKontaktinformationen().getNachname()))
                    {
                    	//System.out.println("Nachname ok");

                        if (this.getKontaktinformationen().getVorname().equals(that.getKontaktinformationen().getVorname()))
                        {
                        	//System.out.println("Vorname ok");

                            if (this.getKontaktinformationen().getPostleitzahl() == (that.getKontaktinformationen().getPostleitzahl()))
                            {
                            	//System.out.println("plz ok");

                                if (this.getKontaktinformationen().getStraﬂe().equals(that.getKontaktinformationen().getStraﬂe()))
                                {
                                	//System.out.println("Strasse ok");

                                    if (this.getKontaktinformationen().getTelefonnummer().equals(that.getKontaktinformationen().getTelefonnummer()))
                                    {
                                    	//System.out.println("Telefon ok");

                                    	//alles stimmt, return turue
                                    		return true;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }
		
        return false;
	}
	
	//getters und setters
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the kontaktinformationen
	 */
	public KontaktInformationen getKontaktinformationen() {
		return kontaktinformationen;
	}

	/**
	 * @param kontaktinformationen the kontaktinformationen to set
	 */
	public void setKontaktinformationen(KontaktInformationen kontaktinformationen) {
		this.kontaktinformationen = kontaktinformationen;
	}

	/**
	 * @return the warenkorb
	 */
	public Warenkorb getWarenkorb() {
		return warenkorb;
	}

	/**
	 * @param warenkorb the warenkorb to set
	 */
	public void setWarenkorb(Warenkorb warenkorb) {
		this.warenkorb = warenkorb;
	};

}
